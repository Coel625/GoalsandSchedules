package edu.apsu.csci.goalsandschedules;

public class Schedule {
    private int schedule_id;
    private String short_term;
    private String date;
    private String time;
    private String description;

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id=schedule_id;
    }

    public String getShortterm_id() {
        return short_term;
    }

    public void setShortterm_id(String short_term) {
        this.short_term=short_term;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date=date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String start) {
        this.time=start;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description=description;
    }
}