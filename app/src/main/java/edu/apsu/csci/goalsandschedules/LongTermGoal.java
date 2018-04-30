package edu.apsu.csci.goalsandschedules;

public class LongTermGoal {
    private int longterm_id;
    private String title;
    private String description;
    private int progress;

    public LongTermGoal() {
    }
    public int getLongterm_id(){return longterm_id;}
    public void setLongterm_id(int longterm_id){this.longterm_id = longterm_id;}

    public String getTitle(){return title;}
    public void setTitle(String title){this.title = title;}

    public String getDescription(){return description;}
    public void setDescription(String description){this.description=description;}

    public int getProgress(){return progress;}
    public void setProgress(int progress) {this.progress=progress;}

    @Override
    public String toString() {
        String tmp = title;
        if (tmp.length() > 20) {
            tmp = tmp.substring(0, 20) + "...";
        }
        return tmp;
    }
}
