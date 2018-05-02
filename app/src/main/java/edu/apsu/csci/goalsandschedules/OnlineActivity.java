package edu.apsu.csci.goalsandschedules;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class OnlineActivity extends ListActivity implements View.OnClickListener {

    private DbDataSource dataSource;

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);

        dataSource = new DbDataSource(getApplicationContext());

        Button b = (Button) findViewById(R.id.goal_button);
        b.setPaintFlags(b.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        b.setOnClickListener(this);

        Button b2 = (Button) findViewById(R.id.schedule_button);
        b2.setPaintFlags(b2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        b2.setOnClickListener(this);

        Button b3 = (Button) findViewById(R.id.online_button);
        b3.setPaintFlags(b3.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        b3.setOnClickListener(this);

        Button b4 = (Button) findViewById(R.id.onlinegoal_button);
        b4.setOnClickListener(this);

        Button b5 = (Button) findViewById(R.id.onlineschedule_button);
        b5.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        dataSource.open();

        if (counter == 0) {
            List<LongTermGoal> longTermGoal = dataSource.getAllLongTermGoals();

            ArrayAdapter<LongTermGoal> adapter = new ArrayAdapter<LongTermGoal>(this,
                    R.layout.entry_set, R.id.goalListNameData, longTermGoal);
            setListAdapter(new MultipleGoalAdapter(OnlineActivity.this, R.layout.entry_set, longTermGoal));
        } else if (counter == 1) {
            List<Schedule> schedule = dataSource.getAllSchedules();

            ArrayAdapter<Schedule> adapter2 = new ArrayAdapter<Schedule>(this,
                    R.layout.entry_set2, R.id.scheduleEntryTimes, schedule);
            setListAdapter(new MultipleScheduleAdapter(OnlineActivity.this, R.layout.entry_set2, schedule));
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        dataSource.close();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.schedule_button) {
            Intent intent = new Intent(getApplicationContext(), ScheduleActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.goal_button) {
            Intent intent = new Intent(getApplicationContext(), GoalActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.onlinegoal_button) {
            TextView textView = (TextView) findViewById(R.id.online_tv);
            textView.setText("Goals");
            counter = 0;
            onStart();
        } else if (v.getId() == R.id.onlineschedule_button) {
            TextView textView = (TextView) findViewById(R.id.online_tv);
            textView.setText("Schedules");
            counter = 1;
            onStart();
        }
    }

    private void loadForm(){
        dataSource = new DbDataSource(getApplicationContext());
        dataSource.open();
        List<LongTermGoal> longTermGoal = dataSource.getAllLongTermGoals();
        if (!(longTermGoal.size()-1 < 0)) {
            LongTermGoal ltg = longTermGoal.get(longTermGoal.size() - 1);
            TextView LTG1Title = (TextView) findViewById(R.id.goalListNameData);
            LTG1Title.setText(ltg.getTitle());
            TextView LTGDescription = (TextView) findViewById(R.id.goalListDescData);
            LTGDescription.setText(ltg.getDescription());
            ProgressBar LTGProgress = (ProgressBar) findViewById(R.id.progressBar);
            LTGProgress.setProgress(ltg.getProgress());
            List<ShortTermGoal> shortTermGoal = dataSource.getAllShortTermGoals();
            ShortTermGoal stg = shortTermGoal.get(shortTermGoal.size() - 1);
            TextView STGTitle = (TextView) findViewById(R.id.goalListShortData);
            STGTitle.setText(stg.getTitle());
        }

        List<Schedule> schedule = dataSource.getAllSchedules();
        if (!(schedule.size()-1 < 0)) {
            Schedule sc = schedule.get(schedule.size() - 1);
            TextView SC1Time = (TextView) findViewById(R.id.scheduleEntryTimes);
            SC1Time.setText(sc.getDescription());
            TextView SCDate = (TextView) findViewById(R.id.scheduleEntryDate);
            SCDate.setText(sc.getDescription());
            TextView SCShort = (TextView) findViewById(R.id.scheduleEntryShort);
            SCShort.setText(sc.getDescription());
            TextView SCDesc = (TextView) findViewById(R.id.scheduleEntryDesc);
            SCDesc.setText(sc.getDescription());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            loadForm();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
