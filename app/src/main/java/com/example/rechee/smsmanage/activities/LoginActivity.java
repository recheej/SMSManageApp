package com.example.rechee.smsmanage.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.rechee.smsmanage.R;
import com.example.rechee.smsmanage.models.UserInfo;
import com.example.rechee.smsmanage.presenters.LoginPresenter;
import com.example.rechee.smsmanage.views.AbstractView;
import com.example.rechee.smsmanage.views.ILoginView;


public class LoginActivity extends AbstractView implements ILoginView {
    public static final String LOGIN_ACTIVITY = "LOGIN_ACTIVITY";
    private EditText usernameEditText;
    private EditText passwordEditText;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPresenter = new LoginPresenter(this);

        usernameEditText = (EditText) findViewById(R.id.editText_username);
        passwordEditText = (EditText) findViewById(R.id.editText_password);
    }

    public void loginClicked(final View view) {

        final String username = usernameEditText.getText().toString();
        if(username.isEmpty()){
            usernameEditText.setError(getString(R.string.required_field));
            return;
        }

        final String password = passwordEditText.getText().toString();
        if(password.isEmpty()){
            passwordEditText.setError(getString(R.string.required_field));
            return;
        }

        final String baseUrl = getString(R.string.toggleAPIUrl);

        this.loginPresenter.userEnteredLoginInformation(username, password);
    }

    /**
     * Puts the api token in shared preferences.
     * @param userInfo User info model from Toggl
     */
    @Override
    public void loginUser(UserInfo userInfo) {
        SharedPreferences settings = getSharedPreferences(getString(R.string.preference_file_key), 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(getString(R.string.toggl_api_token), userInfo.apiToken);

        // Commit the edits!
        editor.apply();

        startActivity(new Intent(this, MainActivity.class));
    }
}
