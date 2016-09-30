package my.edu.um.mycroft;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        final EditText et_loginid = (EditText) v.findViewById(R.id.editText_userid);
        Button btn_login = (Button) v.findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_loginid.getText().toString().equals("demo")){
                    Toast.makeText(getActivity(), "Login successful", Toast.LENGTH_SHORT).show();
                    Fragment fragment = new DashboardFragment();
                    getFragmentManager().beginTransaction().replace(R.id.content_layout,fragment,"dashboard").commit();
                }
            }
        });

        return v;
    }

}
