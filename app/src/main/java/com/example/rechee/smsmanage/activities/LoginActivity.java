package com.example.rechee.smsmanage.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.rechee.smsmanage.fragments.ErrorDialogFragment;
import com.example.rechee.smsmanage.R;
import com.example.rechee.smsmanage.http.ToggleServiceGenerator;
import com.example.rechee.smsmanage.http.models.toggl.UserInfoResponse;
import com.example.rechee.smsmanage.http.services.toggl.UserInfoService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends Activity {
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

    public void loginClicked(final View view) {

        String username = usernameEditText.getText().toString();
        if(username.isEmpty()){
            usernameEditText.setError(getString(R.string.required_field));
            return;
        }

        String password = passwordEditText.getText().toString();
        if(password.isEmpty()){
            passwordEditText.setError(getString(R.string.required_field));
            return;
        }

        final String baseUrl = getString(R.string.toggleAPIUrl);
        UserInfoService userInfoService = (UserInfoService) new ToggleServiceGenerator
                .Builder<UserInfoService, UserInfoResponse>(UserInfoService.class, UserInfoResponse.class, baseUrl)
                .username(username)
                .password(password)
                .build();

        Call<UserInfoResponse> call = userInfoService.userInformation();

        call.enqueue(new Callback<UserInfoResponse>() {
            @Override
            public void onResponse(Call<UserInfoResponse> call, Response<UserInfoResponse> response) {
                InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

                if (response.isSuccessful()) {
                    // use response data and do some fancy stuff :)
                } else {
                    ErrorDialogFragment errorDialogFragment = ErrorDialogFragment
                            .getErrorDialog(R.string.invalid_login, R.string.toggl_authentication_error, LoginActivity.this);
                    errorDialogFragment.show(getFragmentManager(), LOGIN_ACTIVITY);
                }
            }

            @Override
            public void onFailure(Call<UserInfoResponse> call, Throwable t) {
                Log.e(LOGIN_ACTIVITY, t.toString());
            }
        });
    }
}
