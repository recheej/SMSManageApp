package com.example.rechee.smsmanage.http.interfaces.toggl;

import com.example.rechee.smsmanage.models.TimeEntry;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Rechee on 5/29/2017.
 */

public interface TimeEntryService extends RetroFitService {
    @GET("time_entries")
    Call<List<TimeEntry>> getTimeEntries(@Query("start_date") String startDate, @Query("end_date") String endDate);
}
