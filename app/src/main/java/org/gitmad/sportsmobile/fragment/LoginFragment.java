package org.gitmad.sportsmobile.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.gitmad.sportsmobile.R;
import org.gitmad.sportsmobile.TitleGettable;
import org.gitmad.sportsmobile.activity.VerifyLoginActivity;

public class LoginFragment extends Fragment implements TitleGettable {

    private EditText emailAddress;
    private EditText name;
    private EditText age;
    private RadioGroup genderGroup;
    private Button verifyInfo;

    @Override
    public int getTitleResource() {
        return R.string.login_title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        emailAddress = (EditText) rootView.findViewById(R.id.ActivityLogin_EditText_EmailAddress);
        name = (EditText) rootView.findViewById(R.id.ActivityLogin_EditText_Name);
        age = (EditText) rootView.findViewById(R.id.ActivityLogin_EditText_Age);
        genderGroup = (RadioGroup) rootView.findViewById(R.id.ActivityLogin_RadioGroup_Gender);
        final RadioButton option1 = (RadioButton) genderGroup.findViewById(R.id.ActivityLogin_RadioButton_option1);
        final RadioButton option2 = (RadioButton) genderGroup.findViewById(R.id.ActivityLogin_RadioButton_option2);
        final RadioButton option3 = (RadioButton) genderGroup.findViewById(R.id.ActivityLogin_RadioButton_option3);

        verifyInfo = (Button)
                rootView.findViewById(R.id.ActivityLogin_Button_VerifyInfo);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        verifyInfo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                final Intent verifyIntent = new Intent(getActivity(), VerifyLoginActivity.class);
                verifyIntent.putExtra("Email Address", emailAddress.getText().toString());
                verifyIntent.putExtra("Name", name.getText().toString());
                verifyIntent.putExtra("Age", age.getText().toString());
                final String gender = genderGroup.getCheckedRadioButtonId() >= 0
                        ? ((RadioButton) genderGroup
                        .findViewById(genderGroup.getCheckedRadioButtonId()))
                        .getText().toString() : "";
                verifyIntent.putExtra("Gender", gender);

                startActivity(verifyIntent);
            }
        });
    }
}
