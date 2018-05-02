package edu.apsu.csci.goalsandschedules;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ScheduleActivity extends ListActivity implements View.OnClickListener {

    private DbDataSource dataSource;

    public static final String SCHEDULEDATA1 = "scheduledata1";
    public static final String SCHEDULEDATA2 = "scheduledata2";
    public static final String SCHEDULEDATA3 = "scheduledata3";
    public static final String SCHEDULEDATA4 = "scheduledata4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

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
    }

    @Override
    protected void onStart() {
        super.onStart();

        dataSource.open();

        List<Schedule> schedule = dataSource.getAllSchedules();

        ArrayAdapter<Schedule> adapter = new ArrayAdapter<Schedule>(this,
                R.layout.entry_set2, R.id.scheduleEntryTimes, schedule);
        setListAdapter(new MultipleScheduleAdapter(ScheduleActivity.this, R.layout.entry_set2, schedule));
    }

    @Override
    protected void onStop() {
        super.onStop();
        dataSource.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.schedule_menu, menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (item.getItemId() == R.id.menu_add_schedule) {
            String scheduleShortId = "Short-term Goal: 1";
            String scheduleDateString = "on Sunday";
            String scheduleTimeString = "From 12:00 to 12:00";
            String scheduleDescription = "description";
            Schedule schedule = dataSource.createSchedule(scheduleShortId, scheduleDateString, scheduleTimeString, scheduleDescription);

            ArrayAdapter<Schedule> adapter = (ArrayAdapter<Schedule>) getListAdapter();
            adapter.add(schedule);
            adapter.notifyDataSetChanged();
        }
        return super.onMenuItemSelected(featureId, item);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        Intent intent = new Intent(getApplicationContext(), ScheduleCreationActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.goal_button) {
            Intent intent = new Intent(getApplicationContext(), GoalActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.online_button) {
            Intent intent = new Intent(getApplicationContext(), OnlineActivity.class);
            startActivity(intent);
        }
    }

    private void loadForm(){
        dataSource = new DbDataSource(getApplicationContext());
        dataSource.open();
        List<Schedule> schedule = dataSource.getAllSchedules();
        if (!(schedule.size()-1 < 0)) {
            Schedule sc = schedule.get(schedule.size() - 1);
            TextView SC1Time = (TextView) findViewById(R.id.scheduleEntryTimes);
            SC1Time.setText(sc.getTime());
            TextView SCDate = (TextView) findViewById(R.id.scheduleEntryDate);
            SCDate.setText(sc.getDate());
            TextView SCShort = (TextView) findViewById(R.id.scheduleEntryShort);
            SCShort.setText(sc.getShortterm_id());
            TextView SCDesc = (TextView) findViewById(R.id.scheduleEntryDesc);
            SCDesc.setText(sc.getDescription());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_OK){
            loadForm();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
