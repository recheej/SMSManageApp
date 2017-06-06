package com.example.rechee.smsmanage.presenters;

import com.example.rechee.smsmanage.DateUtilities;
import com.example.rechee.smsmanage.http.ToggleServiceGenerator;
import com.example.rechee.smsmanage.http.interfaces.toggl.TimeEntryService;
import com.example.rechee.smsmanage.http.interfaces.toggl.UserInfoService;
import com.example.rechee.smsmanage.models.TimeEntry;
import com.example.rechee.smsmanage.views.IMainView;

import org.joda.time.DateTimeUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rechee on 6/3/2017.
 */

public class MainPresenter {
    private final IMainView view;

    public MainPresenter(IMainView view){
        this.view = view;
    }

    public void getTimeEntriesFromLastDay(){
        TimeEntryService timeEntryService = new ToggleServiceGenerator
                .Builder<TimeEntryService>(TimeEntryService.class, this.view.getBaseUrl())
                .authToken(this.view.getApiToken())
                .build();

        timeEntryService.getTimeEntries(DateUtilities.getDate24HoursAgo(), DateUtilities.getCurrentTime())
            .enqueue(new Callback<List<TimeEntry>>() {
                @Override
                public void onResponse(Call<List<TimeEntry>> call, Response<List<TimeEntry>> response) {
                    if(response.isSuccessful()){
                        view.setUpRecyclerView(response.body());
                    }
                }

                @Override
                public void onFailure(Call<List<TimeEntry>> call, Throwable t) {

                }
            });
    }
}
