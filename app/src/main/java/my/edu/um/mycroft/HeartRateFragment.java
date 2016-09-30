package my.edu.um.mycroft;


import android.app.Fragment;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import my.edu.um.mycroft.model.Heartrate;
import my.edu.um.mycroft.rest.ApiClient;
import my.edu.um.mycroft.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class HeartRateFragment extends Fragment {
    LineChart mChart;
    Button btnRefresh;
    private final static String API_KEY = "123456";


    public HeartRateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_heart_rate, container, false);
        getActivity().setTitle("Heart Rate");
        mChart = (LineChart)v.findViewById(R.id.heart_rate_chart);
        btnRefresh = (Button) v.findViewById(R.id.btn_refresh);
        setData();
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setData();
                mChart.notifyDataSetChanged(); // let the chart know it's data changed
                mChart.invalidate(); // refresh
            }
        });
        return v;
    }

    private void setData() {

        if (API_KEY.isEmpty()) {
            Toast.makeText(getActivity(), "Please check your API Key", Toast.LENGTH_LONG).show();
            return;
        }


        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<JsonArray> call = apiService.getHeartrate();
        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                System.out.println(response);
                Gson gson = new Gson();
                Type listType = new TypeToken<List<Heartrate>>(){}.getType();
                List<Heartrate> heartrates= gson.fromJson(response.body().toString(),listType);
                int index = heartrates.size()-1;
               String heartrate = heartrates.get(index).getRate();

                ArrayList<Entry> values = new ArrayList<Entry>();
                String[] heartrateList = heartrate.split("  ");
                int num = 0;
                for (int i = 0; i < heartrateList.length; i++) {

                    if(heartrateList[i].contains(" ")){
                        heartrateList[i]= heartrateList[i].replaceAll(" ","");
                    }
                    if(heartrateList[i].contains("\n")){
                        heartrateList[i] = heartrateList[i].replaceAll("\n","");
                    }

                    if(!heartrateList[i].equals("")){
                        values.add(new Entry(num, Float.parseFloat(heartrateList[i])));
                        System.out.println(heartrateList[i]);
                        num = num+1;
                    }

                }

                LineDataSet set1;

                if (mChart.getData() != null &&
                        mChart.getData().getDataSetCount() > 0) {
                    set1 = (LineDataSet)mChart.getData().getDataSetByIndex(0);
                    set1.setValues(values);
                    mChart.getData().notifyDataChanged();
                    mChart.invalidate();
                } else {
                    // create a dataset and give it a type
                    set1 = new LineDataSet(values, "DataSet 1");

                    // set the line to be drawn like this "- - - - - -"
                    set1.enableDashedLine(10f, 5f, 0f);
                    set1.enableDashedHighlightLine(10f, 5f, 0f);
                    set1.setColor(Color.BLACK);
                    set1.setCircleColor(Color.BLACK);
                    set1.setLineWidth(1f);
                    set1.setCircleRadius(3f);
                    set1.setDrawCircleHole(false);
                    set1.setValueTextSize(9f);
                    set1.setDrawFilled(true);

                    if (Utils.getSDKInt() >= 18) {
                        // fill drawable only supported on api level 18 and above
                        Drawable drawable = ContextCompat.getDrawable(getActivity(), R.drawable.fade_red);
                        set1.setFillDrawable(drawable);
                    }
                    else {
                        set1.setFillColor(Color.BLACK);
                    }

                    ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
                    dataSets.add(set1); // add the datasets

                    // create a data object with the datasets
                    LineData data = new LineData(dataSets);

                    // set data
                    mChart.setData(data);
                }
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                System.out.println(t);
            }

        });

    }


}
