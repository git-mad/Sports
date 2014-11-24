package org.gitmad.sportsmobile.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.gitmad.sportsmobile.R;
import org.gitmad.sportsmobile.activity.VerifyLoginActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    private View root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (root != null) return root;

        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_login, container, false);

        final Intent verifyIntent = new Intent(getActivity(), VerifyLoginActivity.class);

        final EditText emailAddress = (EditText) root.findViewById(R.id.ActivityLogin_EditText_EmailAddress);
        final EditText name = (EditText) root.findViewById(R.id.ActivityLogin_EditText_Name);
        final EditText age = (EditText) root.findViewById(R.id.ActivityLogin_EditText_Age);
        final RadioGroup genderGroup = (RadioGroup) root.findViewById(R.id.ActivityLogin_RadioGroup_Gender);
        final RadioButton option1 = (RadioButton) root.findViewById(R.id.ActivityLogin_RadioButton_option1);
        final RadioButton option2 = (RadioButton) root.findViewById(R.id.ActivityLogin_RadioButton_option2);
        final RadioButton option3 = (RadioButton) root.findViewById(R.id.ActivityLogin_RadioButton_option3);


        final Button verifyInfo = (Button) root.findViewById(R.id.ActivityLogin_Button_VerifyInfo);



        verifyInfo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                verifyIntent.putExtra("Email Address", emailAddress.getText().toString());
                verifyIntent.putExtra("Name", name.getText().toString());
                verifyIntent.putExtra("Age", age.getText().toString());
                final String gender = genderGroup.getCheckedRadioButtonId() >= 0
                        ? ((RadioButton) root.findViewById(genderGroup.getCheckedRadioButtonId()))
                        .getText().toString() : "";
                verifyIntent.putExtra("Gender", gender);

                startActivity(verifyIntent);
            }
        });

        return root;
    }


}
