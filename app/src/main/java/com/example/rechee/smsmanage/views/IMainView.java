package com.example.rechee.smsmanage.views;

import com.example.rechee.smsmanage.models.TimeEntry;

import java.util.List;

/**
 * Created by Rechee on 6/3/2017.
 */

public interface IMainView extends IView {
    void setUpRecyclerView(List<TimeEntry> timeEntries);
}
