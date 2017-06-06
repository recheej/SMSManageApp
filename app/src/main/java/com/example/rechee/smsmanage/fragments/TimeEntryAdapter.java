package com.example.rechee.smsmanage.fragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rechee.smsmanage.R;
import com.example.rechee.smsmanage.models.TimeEntry;

import java.util.List;

/**
 * Created by Rechee on 6/4/2017.
 */

public class TimeEntryAdapter extends RecyclerView.Adapter<TimeEntryViewHolder> {

    private final Context context;
    private final List<TimeEntry> timeEntries;

    public TimeEntryAdapter(Context context, List<TimeEntry> timeEntries) {
        this.context = context;
        this.timeEntries = timeEntries;
    }

    @Override
    public TimeEntryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_time_entry, parent, false);

        return new TimeEntryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TimeEntryViewHolder holder, int position) {
        holder.bindTimeEntry(this.timeEntries.get(position));
    }

    @Override
    public int getItemCount() {
        return this.timeEntries.size();
    }
}
