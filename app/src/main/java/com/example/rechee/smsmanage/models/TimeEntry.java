package com.example.rechee.smsmanage.models;

import java.util.Date;

/**
 * Created by Rechee on 5/29/2017.
 */

public class TimeEntry {
    public String description;
    public int wid;
    public int pid;
    public int tid;
    public boolean billable;
    public Date start;
    public Date stop;
    public int duration;
    public String createdWith;
    public String[] tags;
    public boolean duronly;
    public Date at;
}
