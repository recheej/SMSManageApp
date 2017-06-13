package com.example.rechee.smsmanage.views;

import com.example.rechee.smsmanage.models.TimeEntry;
import com.example.rechee.smsmanage.presenters.MainPresenter;

import java.util.List;

/**
 * Created by Rechee on 6/3/2017.
 */

public interface MainView extends BaseView {
    void setUpRecyclerView(List<TimeEntry> timeEntries);
}
