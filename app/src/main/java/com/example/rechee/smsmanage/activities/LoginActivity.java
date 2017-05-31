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
import com.example.rechee.smsmanage.models.TimeEntry;
import com.example.rechee.smsmanage.models.TogglResponse;
import com.example.rechee.smsmanage.models.UserInfoResponse;
import com.example.rechee.smsmanage.http.interfaces.toggl.TimeEntryService;
import com.example.rechee.smsmanage.http.interfaces.toggl.UserInfoService;

import java.util.List;

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
        UserInfoService userInfoService = new ToggleServiceGenerator
                .Builder<UserInfoService>(UserInfoService.class, baseUrl)
                .username(username)
                .password(password)
                .build();

        Call<TogglResponse<UserInfoResponse>> call = userInfoService.userInformation();

        call.enqueue(new Callback<TogglResponse<UserInfoResponse>>() {
            @Override
            public void onResponse(Call<TogglResponse<UserInfoResponse>> call, Response<TogglResponse<UserInfoResponse>> response) {
                InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

                if (response.isSuccessful()) {
                    TimeEntryService timeEntryService = new ToggleServiceGenerator
                            .Builder<TimeEntryService>(TimeEntryService.class, baseUrl)
                            .username(username)
                            .password(password)
                            .build();

                    Call<List<TimeEntry>> timeEntryCall = timeEntryService.getTimeEntries(null, null);

                    timeEntryCall.enqueue(new Callback<List<TimeEntry>>() {
                        @Override
                        public void onResponse(Call<List<TimeEntry>> call, Response<List<TimeEntry>> response) {
                            Log.i(LOGIN_ACTIVITY, "we got success");
                        }

                        @Override
                        public void onFailure(Call<List<TimeEntry>> call, Throwable t) {
                            Log.i(LOGIN_ACTIVITY, "we got failure");
                        }
                    });
                } else {
                    ErrorDialogFragment errorDialogFragment = ErrorDialogFragment
                            .getErrorDialog(R.string.invalid_login, R.string.toggl_authentication_error, LoginActivity.this);
                    errorDialogFragment.show(getFragmentManager(), LOGIN_ACTIVITY);
                }
            }

            @Override
            public void onFailure(Call<TogglResponse<UserInfoResponse>> call, Throwable t) {
                Log.e(LOGIN_ACTIVITY, t.toString());
            }
        });
    }
}
