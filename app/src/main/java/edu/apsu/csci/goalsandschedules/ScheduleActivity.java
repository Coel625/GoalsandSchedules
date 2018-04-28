package edu.apsu.csci.goalsandschedules;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ScheduleActivity extends Activity implements View.OnClickListener {

    private static final int SCHEDULE_FIELD1 = 1000;
    private static final int SCHEDULE_FIELD2 = 2000;
    private static final int SCHEDULE_FIELD3 = 3000;
    private static final int SCHEDULE_FIELD4 = 4000;
    private static final int SCHEDULE_FIELD5 = 5000;

    public static final String SCHEDULEDATA1 = "scheduledata1";
    public static final String SCHEDULEDATA2 = "scheduledata2";
    public static final String SCHEDULEDATA3 = "scheduledata3";
    public static final String SCHEDULEDATA4 = "scheduledata4";

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

        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.scheduleEntry);
        linearLayout1.setOnClickListener(this);

        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.scheduleEntry2);
        linearLayout2.setOnClickListener(this);

        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.scheduleEntry3);
        linearLayout3.setOnClickListener(this);

        LinearLayout linearLayout4 = (LinearLayout) findViewById(R.id.scheduleEntry4);
        linearLayout4.setOnClickListener(this);

        LinearLayout linearLayout5 = (LinearLayout) findViewById(R.id.scheduleEntry5);
        linearLayout5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.goal_button) {
            Intent intent = new Intent(getApplicationContext(), GoalActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.online_button) {
            Intent intent = new Intent(getApplicationContext(), OnlineActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.scheduleEntry) {
            Intent intent = new Intent(getApplicationContext(), ScheduleCreationActivity.class);
            startActivityForResult(intent, SCHEDULE_FIELD1);
        } else if (v.getId() == R.id.scheduleEntry2) {
            Intent intent = new Intent(getApplicationContext(), ScheduleCreationActivity.class);
            startActivityForResult(intent, SCHEDULE_FIELD2);
        } else if (v.getId() == R.id.scheduleEntry3) {
            Intent intent = new Intent(getApplicationContext(), ScheduleCreationActivity.class);
            startActivityForResult(intent, SCHEDULE_FIELD3);
        } else if (v.getId() == R.id.scheduleEntry4) {
            Intent intent = new Intent(getApplicationContext(), ScheduleCreationActivity.class);
            startActivityForResult(intent, SCHEDULE_FIELD4);
        } else if (v.getId() == R.id.scheduleEntry5) {
            Intent intent = new Intent(getApplicationContext(), ScheduleCreationActivity.class);
            startActivityForResult(intent, SCHEDULE_FIELD5);
        } else if (v.getId() == R.id.scheduleadd_button) {
            Intent intent = new Intent(getApplicationContext(), ScheduleCreationActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == SCHEDULE_FIELD1) {
            if (resultCode == RESULT_OK) {
                String scheduleTimes = "";
                if (data.hasExtra(SCHEDULEDATA1)) {
                    scheduleTimes = data.getStringExtra(SCHEDULEDATA1);
                }

                String scheduleDate = "";
                if (data.hasExtra(SCHEDULEDATA2)) {
                    scheduleDate = data.getStringExtra(SCHEDULEDATA2);
                }

                String scheduleShort = "";
                if (data.hasExtra(SCHEDULEDATA3)) {
                    scheduleShort = data.getStringExtra(SCHEDULEDATA3);
                }

                String scheduleDesc = "";
                if (data.hasExtra(SCHEDULEDATA4)) {
                    scheduleDesc = data.getStringExtra(SCHEDULEDATA4);
                }

                TextView tv1 = (TextView) findViewById(R.id.scheduleEntryTimes);
                tv1.setText(scheduleTimes);

                TextView tv2 = (TextView) findViewById(R.id.scheduleEntryDate);
                tv2.setText(scheduleDate);

                TextView tv3 = (TextView) findViewById(R.id.scheduleEntryShort);
                tv3.setText(scheduleShort);

                TextView tv4 = (TextView) findViewById(R.id.scheduleEntryDesc);
                tv4.setText(scheduleDesc);
            }
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Request cancelled", Toast.LENGTH_LONG).show();
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }

        if (requestCode == SCHEDULE_FIELD2) {
            if (resultCode == RESULT_OK) {
                String scheduleTimes = "";
                if (data.hasExtra(SCHEDULEDATA1)) {
                    scheduleTimes = data.getStringExtra(SCHEDULEDATA1);
                }

                String scheduleDate = "";
                if (data.hasExtra(SCHEDULEDATA2)) {
                    scheduleDate = data.getStringExtra(SCHEDULEDATA2);
                }

                String scheduleShort = "";
                if (data.hasExtra(SCHEDULEDATA3)) {
                    scheduleShort = data.getStringExtra(SCHEDULEDATA3);
                }

                String scheduleDesc = "";
                if (data.hasExtra(SCHEDULEDATA4)) {
                    scheduleDesc = data.getStringExtra(SCHEDULEDATA4);
                }

                TextView tv1 = (TextView) findViewById(R.id.scheduleEntryTimes2);
                tv1.setText(scheduleTimes);

                TextView tv2 = (TextView) findViewById(R.id.scheduleEntryDate2);
                tv2.setText(scheduleDate);

                TextView tv3 = (TextView) findViewById(R.id.scheduleEntryShort2);
                tv3.setText(scheduleShort);

                TextView tv4 = (TextView) findViewById(R.id.scheduleEntryDesc2);
                tv4.setText(scheduleDesc);
            }
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Request cancelled", Toast.LENGTH_LONG).show();
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }

        if (requestCode == SCHEDULE_FIELD3) {
            if (resultCode == RESULT_OK) {
                String scheduleTimes = "";
                if (data.hasExtra(SCHEDULEDATA1)) {
                    scheduleTimes = data.getStringExtra(SCHEDULEDATA1);
                }

                String scheduleDate = "";
                if (data.hasExtra(SCHEDULEDATA2)) {
                    scheduleDate = data.getStringExtra(SCHEDULEDATA2);
                }

                String scheduleShort = "";
                if (data.hasExtra(SCHEDULEDATA3)) {
                    scheduleShort = data.getStringExtra(SCHEDULEDATA3);
                }

                String scheduleDesc = "";
                if (data.hasExtra(SCHEDULEDATA4)) {
                    scheduleDesc = data.getStringExtra(SCHEDULEDATA4);
                }

                TextView tv1 = (TextView) findViewById(R.id.scheduleEntryTimes3);
                tv1.setText(scheduleTimes);

                TextView tv2 = (TextView) findViewById(R.id.scheduleEntryDate3);
                tv2.setText(scheduleDate);

                TextView tv3 = (TextView) findViewById(R.id.scheduleEntryShort3);
                tv3.setText(scheduleShort);

                TextView tv4 = (TextView) findViewById(R.id.scheduleEntryDesc3);
                tv4.setText(scheduleDesc);
            }
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Request cancelled", Toast.LENGTH_LONG).show();
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }

        if (requestCode == SCHEDULE_FIELD4) {
            if (resultCode == RESULT_OK) {
                String scheduleTimes = "";
                if (data.hasExtra(SCHEDULEDATA1)) {
                    scheduleTimes = data.getStringExtra(SCHEDULEDATA1);
                }

                String scheduleDate = "";
                if (data.hasExtra(SCHEDULEDATA2)) {
                    scheduleDate = data.getStringExtra(SCHEDULEDATA2);
                }

                String scheduleShort = "";
                if (data.hasExtra(SCHEDULEDATA3)) {
                    scheduleShort = data.getStringExtra(SCHEDULEDATA3);
                }

                String scheduleDesc = "";
                if (data.hasExtra(SCHEDULEDATA4)) {
                    scheduleDesc = data.getStringExtra(SCHEDULEDATA4);
                }

                TextView tv1 = (TextView) findViewById(R.id.scheduleEntryTimes4);
                tv1.setText(scheduleTimes);

                TextView tv2 = (TextView) findViewById(R.id.scheduleEntryDate4);
                tv2.setText(scheduleDate);

                TextView tv3 = (TextView) findViewById(R.id.scheduleEntryShort4);
                tv3.setText(scheduleShort);

                TextView tv4 = (TextView) findViewById(R.id.scheduleEntryDesc4);
                tv4.setText(scheduleDesc);
            }
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Request cancelled", Toast.LENGTH_LONG).show();
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }

        if (requestCode == SCHEDULE_FIELD5) {
            if (resultCode == RESULT_OK) {
                String scheduleTimes = "";
                if (data.hasExtra(SCHEDULEDATA1)) {
                    scheduleTimes = data.getStringExtra(SCHEDULEDATA1);
                }

                String scheduleDate = "";
                if (data.hasExtra(SCHEDULEDATA2)) {
                    scheduleDate = data.getStringExtra(SCHEDULEDATA2);
                }

                String scheduleShort = "";
                if (data.hasExtra(SCHEDULEDATA3)) {
                    scheduleShort = data.getStringExtra(SCHEDULEDATA3);
                }

                String scheduleDesc = "";
                if (data.hasExtra(SCHEDULEDATA4)) {
                    scheduleDesc = data.getStringExtra(SCHEDULEDATA4);
                }

                TextView tv1 = (TextView) findViewById(R.id.scheduleEntryTimes5);
                tv1.setText(scheduleTimes);

                TextView tv2 = (TextView) findViewById(R.id.scheduleEntryDate5);
                tv2.setText(scheduleDate);

                TextView tv3 = (TextView) findViewById(R.id.scheduleEntryShort5);
                tv3.setText(scheduleShort);

                TextView tv4 = (TextView) findViewById(R.id.scheduleEntryDesc5);
                tv4.setText(scheduleDesc);
            }
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Request cancelled", Toast.LENGTH_LONG).show();
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
