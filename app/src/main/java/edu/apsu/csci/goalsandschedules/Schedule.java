package edu.apsu.csci.goalsandschedules;

import java.util.Date;

public class Schedule {
    private int schedule_id;
    private int shortterm_id;
    private Date date;
    private int start;
    private int end;
    private String description;

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id=schedule_id;
    }

    public int getShortterm_id() {
        return shortterm_id;
    }

    public void setShortterm_id(int shortterm_id) {
        this.shortterm_id=shortterm_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date=date;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start=start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end=end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description=description;
    }
}