package com.example.rechee.smsmanage.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;

import com.example.rechee.smsmanage.R;
import com.example.rechee.smsmanage.fragments.TimeEntryAdapter;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TimeEntryAdapter timeEntryAdapter;
    private DividerItemDecoration mDividerItemDecoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String preferenceFileKey = getString(R.string.preference_file_key);
        SharedPreferences sharedPref = this.getSharedPreferences(preferenceFileKey, Context.MODE_PRIVATE);
        String togglApiToken = sharedPref.getString(getString(R.string.toggl_api_token), "");
        if(togglApiToken.isEmpty()){
            startActivity(new Intent(this, LoginActivity.class));
        }

//        presenter = new MainPresenter(this);
//        presenter.getTimeEntriesFromLastDay();
//
//        this.recyclerView = (RecyclerView) findViewById(R.id.recyclerViewTimeEntries);
//        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
//            //add divider for api >= 25
//            mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
//                    this.getResources().getConfiguration().orientation);
//            recyclerView.addItemDecoration(mDividerItemDecoration);
//        }
    }

//    @Override
//    public void setUpRecyclerView(List<TimeEntry> timeEntries) {
//        timeEntryAdapter = new TimeEntryAdapter(this, timeEntries);
//        this.recyclerView.setAdapter(timeEntryAdapter);
//    }
}
