package edu.apsu.csci.goalsandschedules;

public class ShortTermGoal {
    private int shortterm_id;
    private int longterm_id;
    private String order;
    private String title;
    private String description;

    public ShortTermGoal(){

    }

    public int getShortterm_id() {
        return shortterm_id;
    }

    public void setShortterm_id(int shortterm_id) {
        this.shortterm_id=shortterm_id;
    }

    public int getLongterm_id() {
        return longterm_id;
    }

    public void setLongterm_id(int longterm_id) {
        this.longterm_id=longterm_id;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order=order;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title=title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description=description;
    }
    @Override
    public String toString() {
        String tmp = title;
        if (tmp.length() > 20) {
            tmp = tmp.substring(0, 20) + "...";
        }
        return tmp;
    }
}
