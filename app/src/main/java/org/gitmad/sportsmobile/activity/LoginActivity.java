package org.gitmad.sportsmobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.gitmad.sportsmobile.R;

public class LoginActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Intent verifyIntent = new Intent(this, VerifyLoginActivity.class);

        final EditText emailAddress = (EditText) findViewById(R.id.ActivityLogin_EditText_EmailAddress);
        final EditText name = (EditText) findViewById(R.id.ActivityLogin_EditText_Name);
        final EditText age = (EditText) findViewById(R.id.ActivityLogin_EditText_Age);
        final RadioGroup genderGroup = (RadioGroup) findViewById(R.id.ActivityLogin_RadioGroup_Gender);
        final RadioButton option1 = (RadioButton) findViewById(R.id.ActivityLogin_RadioButton_option1);
        final RadioButton option2 = (RadioButton) findViewById(R.id.ActivityLogin_RadioButton_option2);
        final RadioButton option3 = (RadioButton) findViewById(R.id.ActivityLogin_RadioButton_option3);


        final Button verifyInfo = (Button) findViewById(R.id.ActivityLogin_Button_VerifyInfo);



        verifyInfo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                verifyIntent.putExtra("Email Address", emailAddress.getText().toString());
                verifyIntent.putExtra("Name", name.getText().toString());
                verifyIntent.putExtra("Age", age.getText().toString());
                final String gender = genderGroup.getCheckedRadioButtonId() >= 0
                        ? ((RadioButton) findViewById(genderGroup.getCheckedRadioButtonId()))
                        .getText().toString() : "";
                verifyIntent.putExtra("Gender", gender);

                startActivity(verifyIntent);
            }
        });
    }
}