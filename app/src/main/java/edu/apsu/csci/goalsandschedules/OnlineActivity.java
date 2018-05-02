package edu.apsu.csci.goalsandschedules;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class OnlineActivity extends Activity implements View.OnClickListener {

    private DbDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);

        Button b = (Button) findViewById(R.id.goal_button);
        b.setPaintFlags(b.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        b.setOnClickListener(this);

        Button b2 = (Button) findViewById(R.id.schedule_button);
        b2.setPaintFlags(b2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        b2.setOnClickListener(this);

        Button b3 = (Button) findViewById(R.id.online_button);
        b3.setPaintFlags(b3.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        b3.setOnClickListener(this);

        loadForm();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.schedule_button) {
            Intent intent = new Intent(getApplicationContext(), ScheduleActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.goal_button) {
            Intent intent = new Intent(getApplicationContext(), GoalActivity.class);
            startActivity(intent);
        }
    }

    private void loadForm(){
        dataSource = new DbDataSource(getApplicationContext());
        dataSource.open();
        List<LongTermGoal> longTermGoal = dataSource.getAllLongTermGoals();
        LongTermGoal ltg = longTermGoal.get(longTermGoal.size()-1);
        TextView LTG1Title = (TextView) findViewById(R.id.goalListNameData);
        LTG1Title.setText(ltg.getTitle());
        TextView LTGDescription = (TextView) findViewById(R.id.goalListDescData);
        LTGDescription.setText(ltg.getDescription());
        ProgressBar LTGProgress = (ProgressBar) findViewById(R.id.progressBar);
        LTGProgress.setProgress(ltg.getProgress());
        List<ShortTermGoal> shortTermGoal = dataSource.getAllShortTermGoals();
        ShortTermGoal stg = shortTermGoal.get(shortTermGoal.size()-1);
        TextView STGTitle = (TextView) findViewById(R.id.goalListShortData);
        STGTitle.setText(stg.getTitle());

        ltg = longTermGoal.get(longTermGoal.size()-2);
        LTG1Title = (TextView) findViewById(R.id.goalListNameData2);
        LTG1Title.setText(ltg.getTitle());
        LTGDescription = (TextView) findViewById(R.id.goalListDescData2);
        LTGDescription.setText(ltg.getDescription());
        LTGProgress = (ProgressBar) findViewById(R.id.progressBar2);
        LTGProgress.setProgress(ltg.getProgress());
        shortTermGoal = dataSource.getAllShortTermGoals();
        stg = shortTermGoal.get(shortTermGoal.size()-2);
        STGTitle = (TextView) findViewById(R.id.goalListShortData2);
        STGTitle.setText(stg.getTitle());

        ltg = longTermGoal.get(longTermGoal.size()-3);
        LTG1Title = (TextView) findViewById(R.id.goalListNameData3);
        LTG1Title.setText(ltg.getTitle());
        LTGDescription = (TextView) findViewById(R.id.goalListDescData3);
        LTGDescription.setText(ltg.getDescription());
        LTGProgress = (ProgressBar) findViewById(R.id.progressBar3);
        LTGProgress.setProgress(ltg.getProgress());
        shortTermGoal = dataSource.getAllShortTermGoals();
        stg = shortTermGoal.get(shortTermGoal.size()-3);
        STGTitle = (TextView) findViewById(R.id.goalListShortData3);
        STGTitle.setText(stg.getTitle());

        ltg = longTermGoal.get(longTermGoal.size()-4);
        LTG1Title = (TextView) findViewById(R.id.goalListNameData4);
        LTG1Title.setText(ltg.getTitle());
        LTGDescription = (TextView) findViewById(R.id.goalListDescData4);
        LTGDescription.setText(ltg.getDescription());
        LTGProgress = (ProgressBar) findViewById(R.id.progressBar4);
        LTGProgress.setProgress(ltg.getProgress());
        shortTermGoal = dataSource.getAllShortTermGoals();
        stg = shortTermGoal.get(shortTermGoal.size()-4);
        STGTitle = (TextView) findViewById(R.id.goalListShortData4);
        STGTitle.setText(stg.getTitle());

        ltg = longTermGoal.get(longTermGoal.size()-5);
        LTG1Title = (TextView) findViewById(R.id.goalListNameData5);
        LTG1Title.setText(ltg.getTitle());
        LTGDescription = (TextView) findViewById(R.id.goalListDescData5);
        LTGDescription.setText(ltg.getDescription());
        LTGProgress = (ProgressBar) findViewById(R.id.progressBar5);
        LTGProgress.setProgress(ltg.getProgress());
        shortTermGoal = dataSource.getAllShortTermGoals();
        stg = shortTermGoal.get(shortTermGoal.size()-5);
        STGTitle = (TextView) findViewById(R.id.goalListShortData5);
        STGTitle.setText(stg.getTitle());

        List<Schedule> schedule = dataSource.getAllSchedules();
        Schedule sc = schedule.get(schedule.size()-1);
        TextView SC1Time = (TextView) findViewById(R.id.scheduleEntryTimes);
        SC1Time.setText(sc.getDescription());
        TextView SCDate = (TextView) findViewById(R.id.scheduleEntryDate);
        SCDate.setText(sc.getDescription());
        TextView SCShort = (TextView) findViewById(R.id.scheduleEntryShort);
        SCShort.setText(sc.getDescription());
        TextView SCDesc = (TextView) findViewById(R.id.scheduleEntryDesc);
        SCDesc.setText(sc.getDescription());

        sc = schedule.get(schedule.size()-2);
        SC1Time = (TextView) findViewById(R.id.scheduleEntryTimes2);
        SC1Time.setText(sc.getDescription());
        SCDate = (TextView) findViewById(R.id.scheduleEntryDate2);
        SCDate.setText(sc.getDescription());
        SCShort = (TextView) findViewById(R.id.scheduleEntryShort2);
        SCShort.setText(sc.getDescription());
        SCDesc = (TextView) findViewById(R.id.scheduleEntryDesc2);
        SCDesc.setText(sc.getDescription());
    }
}
