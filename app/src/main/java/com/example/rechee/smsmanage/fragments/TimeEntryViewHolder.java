package com.example.rechee.smsmanage.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.rechee.smsmanage.R;
import com.example.rechee.smsmanage.models.TimeEntry;

/**
 * Created by Rechee on 6/4/2017.
 */

public class TimeEntryViewHolder extends RecyclerView.ViewHolder {

    private TextView textViewDescription;
    private TextView textViewRawDuration;

    public TimeEntryViewHolder(View itemView) {
        super(itemView);

        this.textViewDescription = (TextView) itemView.findViewById(R.id.textViewDescription);
        this.textViewRawDuration = (TextView) itemView.findViewById(R.id.textViewRawDuration);
    }

    public void bindTimeEntry(TimeEntry timeEntryToBind){
        this.textViewDescription.setText(timeEntryToBind.description);
        this.textViewRawDuration.setText(Integer.toString(timeEntryToBind.duration));
    }
}
