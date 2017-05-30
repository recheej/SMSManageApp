package com.example.rechee.smsmanage.http.services.toggl;

import com.example.rechee.smsmanage.http.models.toggl.TimeEntry;
import com.example.rechee.smsmanage.http.models.toggl.UserInfoResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Rechee on 5/29/2017.
 */

public interface TimeEntryService {
    @GET("time_entries")
    Call<List<TimeEntry>> getTimeEntries(@Query("start_date") String startDate, @Query("end_date") String endDate);
}
