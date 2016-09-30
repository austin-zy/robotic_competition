package my.edu.um.mycroft;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReminderFragment extends Fragment {
    TextView mOutputText;
    public ReminderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_reminder, container, false);
        getActivity().setTitle("Reminder");
        mOutputText = (TextView) v.findViewById(R.id.tv_event);
        return v;
    }

    public void changeText(String text){

        if(mOutputText!=null){
            mOutputText.setText(text);
        }
    }



}
