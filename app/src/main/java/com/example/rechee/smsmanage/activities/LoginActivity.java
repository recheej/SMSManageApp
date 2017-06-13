package com.example.rechee.smsmanage.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.rechee.smsmanage.R;


public class LoginActivity extends AppCompatActivity {
    public static final String LOGIN_ACTIVITY = "LOGIN_ACTIVITY";
    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = (EditText) findViewById(R.id.editText_username);
        passwordEditText = (EditText) findViewById(R.id.editText_password);
    }
}
