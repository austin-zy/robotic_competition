package my.edu.um.mycroft;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {


    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Dashboard");
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ImageButton heartRateBtn = (ImageButton)v.findViewById(R.id.img_btn_heart_rate);
        ImageButton reminderBtn = (ImageButton)v.findViewById(R.id.img_btn_reminder);

        heartRateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new HeartRateFragment();
                getFragmentManager().beginTransaction().replace(R.id.content_layout,fragment,"heart_rate_fragment").addToBackStack("dashboard").commit();
            }
        });

        reminderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new ReminderFragment();
                getFragmentManager().beginTransaction().replace(R.id.content_layout,fragment,"reminder_fragment").addToBackStack("dashboard").commit();
            }
        });
        return v;
    }

}
