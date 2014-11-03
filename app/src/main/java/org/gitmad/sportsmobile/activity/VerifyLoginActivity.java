package org.gitmad.sportsmobile.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.gitmad.sportsmobile.R;

public class VerifyLoginActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_login);

        final TextView emailAddress = (TextView) findViewById(R.id.ActivityVerifyLogin_TextView_EmailAddress);
        final TextView name = (TextView) findViewById(R.id.ActivityVerifyLogin_TextView_Name);
        final TextView age = (TextView) findViewById(R.id.ActivityVerifyLogin_TextView_Age);
        final TextView gender = (TextView) findViewById(R.id.ActivityVerifyLogin_TextView_Gender);
        final Button createAccount = (Button) findViewById(R.id.ActivityVerifyLogin_Button_CreateAccount);

        emailAddress.append(" " + getIntent().getExtras().getString("Email Address"));
        name.append(" " + getIntent().getExtras().getString("Name"));
        age.append(" " + getIntent().getExtras().getString("Age"));
        gender.append(" " + getIntent().getExtras().getString("Gender"));

        createAccount.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // go back to other activity
            }
        });
    }
}
