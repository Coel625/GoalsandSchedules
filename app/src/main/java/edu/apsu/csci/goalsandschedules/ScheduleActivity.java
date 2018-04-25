package edu.apsu.csci.goalsandschedules;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ScheduleActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        Button b = (Button) findViewById(R.id.goal_button);
        b.setPaintFlags(b.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        b.setOnClickListener(this);

        Button b2 = (Button) findViewById(R.id.schedule_button);
        b2.setPaintFlags(b2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        b2.setOnClickListener(this);

        Button b3 = (Button) findViewById(R.id.online_button);
        b3.setPaintFlags(b3.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        b3.setOnClickListener(this);

        Button b4 = (Button) findViewById(R.id.scheduleadd_button);
        b4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.goal_button) {
            Intent intent = new Intent(getApplicationContext(), GoalActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.online_button) {
            Intent intent = new Intent(getApplicationContext(), OnlineActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.scheduleadd_button) {
            Intent intent = new Intent(getApplicationContext(), ScheduleCreationActivity.class);
            startActivity(intent);
        }
    }
}