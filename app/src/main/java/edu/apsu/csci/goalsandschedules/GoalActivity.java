package edu.apsu.csci.goalsandschedules;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class GoalActivity extends Activity implements View.OnClickListener {

    private DbDataSource dataSource;
    private static final int GOAL_TASK1 = 1000;
    private static final int GOAL_TASK2 = 2000;
    private static final int GOAL_TASK3 = 3000;
    private static final int GOAL_TASK4 = 4000;
    private static final int GOAL_TASK5 = 5000;

    public static final String GOALENTRY1 = "goalentry1";
    public static final String GOALENTRY2 = "goalentry2";
    public static final String GOALENTRY3 = "goalentry3";
    public static final String GOALENTRY4 = "goalentry4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //dataSource = new DbDataSource(getApplicationContext());
        //dataSource.open();
        //dataSource.createLongTermGoal("0","0","0");
        //dataSource.close();
        setContentView(R.layout.activity_goal);

        Button b = (Button) findViewById(R.id.goal_button);
        b.setPaintFlags(b.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        b.setOnClickListener(this);

        Button b2 = (Button) findViewById(R.id.schedule_button);
        b2.setPaintFlags(b2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        b2.setOnClickListener(this);

        Button b3 = (Button) findViewById(R.id.online_button);
        b3.setPaintFlags(b3.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        b3.setOnClickListener(this);

        Button b4 = (Button) findViewById(R.id.goaladd_button);
        b4.setOnClickListener(this);

        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.goalList);
        linearLayout1.setOnClickListener(this);

        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.goalList2);
        linearLayout2.setOnClickListener(this);

        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.goalList3);
        linearLayout3.setOnClickListener(this);

        LinearLayout linearLayout4 = (LinearLayout) findViewById(R.id.goalList4);
        linearLayout4.setOnClickListener(this);

        LinearLayout linearLayout5 = (LinearLayout) findViewById(R.id.goalList5);
        linearLayout5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.schedule_button) {
            Intent intent = new Intent(getApplicationContext(), ScheduleActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.online_button) {
            Intent intent = new Intent(getApplicationContext(), OnlineActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.goalList) {
            Intent intent = new Intent(getApplicationContext(), GoalCreationActivity.class);
            startActivityForResult(intent, GOAL_TASK1);
        } else if (v.getId() == R.id.goalList2) {
            Intent intent = new Intent(getApplicationContext(), GoalCreationActivity.class);
            startActivityForResult(intent, GOAL_TASK2);
        } else if (v.getId() == R.id.goalList3) {
            Intent intent = new Intent(getApplicationContext(), GoalCreationActivity.class);
            startActivityForResult(intent, GOAL_TASK3);
        } else if (v.getId() == R.id.goalList4) {
            Intent intent = new Intent(getApplicationContext(), GoalCreationActivity.class);
            startActivityForResult(intent, GOAL_TASK4);
        } else if (v.getId() == R.id.goalList5) {
            Intent intent = new Intent(getApplicationContext(), GoalCreationActivity.class);
            startActivityForResult(intent, GOAL_TASK5);
        } else if (v.getId() == R.id.goaladd_button) {
            Intent intent = new Intent(getApplicationContext(), GoalCreationActivity.class);
            startActivity(intent);
        }
    }
    /*
    protected void onStart() {
        super.onStart();

        dataSource.open();
    }
    @Override
    protected void onStop() {
        super.onStop();
        dataSource.close();
    }*/
    private void loadForm(){
        dataSource = new DbDataSource(getApplicationContext());
        dataSource.open();
        List<LongTermGoal> longTermGoal = dataSource.getAllLongTermGoals();
        LongTermGoal ltg = longTermGoal.get(longTermGoal.size()-1);
        TextView LTG1Title = (TextView) findViewById(R.id.goalListNameData);
        LTG1Title.setText(ltg.getTitle());
        TextView LTGDescription = (TextView) findViewById(R.id.goalListDescData);
        LTGDescription.setText(ltg.getDescription());
        List<ShortTermGoal> shortTermGoal = dataSource.getAllShortTermGoals();
        ShortTermGoal stg = shortTermGoal.get(shortTermGoal.size()-1);
        TextView STGTitle = (TextView) findViewById(R.id.goalListShortData);
        STGTitle.setText(stg.getTitle());

        ltg = longTermGoal.get(longTermGoal.size()-2);
        LTG1Title = (TextView) findViewById(R.id.goalListNameData2);
        LTG1Title.setText(ltg.getTitle());
        LTGDescription = (TextView) findViewById(R.id.goalListDescData2);
        LTGDescription.setText(ltg.getDescription());
        shortTermGoal = dataSource.getAllShortTermGoals();
        stg = shortTermGoal.get(shortTermGoal.size()-2);
        STGTitle = (TextView) findViewById(R.id.goalListShortData2);
        STGTitle.setText(stg.getTitle());
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if(resultCode == RESULT_OK){

            loadForm();

        }







        /*
        if (requestCode == GOAL_TASK1) {
            if (resultCode == RESULT_OK) {
                String goalName = "";
                if (data.hasExtra(GOALENTRY1)) {
                    goalName = data.getStringExtra(GOALENTRY1);
                }

                String goalDesc = "";
                if (data.hasExtra(GOALENTRY2)) {
                    goalDesc = data.getStringExtra(GOALENTRY2);
                }

                String progressValue = "";
                if (data.hasExtra(GOALENTRY3)) {
                    progressValue = data.getStringExtra(GOALENTRY3);
                }

                String subGoalTitle = "";
                if (data.hasExtra(GOALENTRY4)) {
                    subGoalTitle = data.getStringExtra(GOALENTRY4);
                }

                int progressValueInt = 0;
                if (!(progressValue.equals(""))) {
                    progressValueInt = Integer.parseInt(progressValue);
                }

                TextView tv1 = (TextView) findViewById(R.id.goalListNameData);
                tv1.setText(goalName);

                TextView tv2 = (TextView) findViewById(R.id.goalListDescData);
                tv2.setText(goalDesc);

                final ProgressBar progressBar1 = (ProgressBar) findViewById(R.id.progressBar);
                progressBar1.setProgress(progressValueInt);

                TextView tv3 = (TextView) findViewById(R.id.goalListShortData);
                tv3.setText(subGoalTitle);
            }
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Request cancelled", Toast.LENGTH_LONG).show();
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }

        if (requestCode == GOAL_TASK2) {
            if (resultCode == RESULT_OK) {
                String goalName = "";
                if (data.hasExtra(GOALENTRY1)) {
                    goalName = data.getStringExtra(GOALENTRY1);
                }

                String goalDesc = "";
                if (data.hasExtra(GOALENTRY2)) {
                    goalDesc = data.getStringExtra(GOALENTRY2);
                }

                String progressValue = "";
                if (data.hasExtra(GOALENTRY3)) {
                    progressValue = data.getStringExtra(GOALENTRY3);
                }

                String subGoalTitle = "";
                if (data.hasExtra(GOALENTRY4)) {
                    subGoalTitle = data.getStringExtra(GOALENTRY4);
                }

                int progressValueInt = 0;
                if (!(progressValue.equals(""))) {
                    progressValueInt = Integer.parseInt(progressValue);
                }

                TextView tv1 = (TextView) findViewById(R.id.goalListNameData2);
                tv1.setText(goalName);

                TextView tv2 = (TextView) findViewById(R.id.goalListDescData2);
                tv2.setText(goalDesc);

                final ProgressBar progressBar1 = (ProgressBar) findViewById(R.id.progressBar2);
                progressBar1.setProgress(progressValueInt);

                TextView tv3 = (TextView) findViewById(R.id.goalListShortData2);
                tv3.setText(subGoalTitle);
            }
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Request cancelled", Toast.LENGTH_LONG).show();
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }

        if (requestCode == GOAL_TASK3) {
            if (resultCode == RESULT_OK) {
                String goalName = "";
                if (data.hasExtra(GOALENTRY1)) {
                    goalName = data.getStringExtra(GOALENTRY1);
                }

                String goalDesc = "";
                if (data.hasExtra(GOALENTRY2)) {
                    goalDesc = data.getStringExtra(GOALENTRY2);
                }

                String progressValue = "";
                if (data.hasExtra(GOALENTRY3)) {
                    progressValue = data.getStringExtra(GOALENTRY3);
                }

                String subGoalTitle = "";
                if (data.hasExtra(GOALENTRY4)) {
                    subGoalTitle = data.getStringExtra(GOALENTRY4);
                }

                int progressValueInt = 0;
                if (!(progressValue.equals(""))) {
                    progressValueInt = Integer.parseInt(progressValue);
                }

                TextView tv1 = (TextView) findViewById(R.id.goalListNameData3);
                tv1.setText(goalName);

                TextView tv2 = (TextView) findViewById(R.id.goalListDescData3);
                tv2.setText(goalDesc);

                final ProgressBar progressBar1 = (ProgressBar) findViewById(R.id.progressBar3);
                progressBar1.setProgress(progressValueInt);

                TextView tv3 = (TextView) findViewById(R.id.goalListShortData3);
                tv3.setText(subGoalTitle);
            }
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Request cancelled", Toast.LENGTH_LONG).show();
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }

        if (requestCode == GOAL_TASK4) {
            if (resultCode == RESULT_OK) {
                String goalName = "";
                if (data.hasExtra(GOALENTRY1)) {
                    goalName = data.getStringExtra(GOALENTRY1);
                }

                String goalDesc = "";
                if (data.hasExtra(GOALENTRY2)) {
                    goalDesc = data.getStringExtra(GOALENTRY2);
                }

                String progressValue = "";
                if (data.hasExtra(GOALENTRY3)) {
                    progressValue = data.getStringExtra(GOALENTRY3);
                }

                String subGoalTitle = "";
                if (data.hasExtra(GOALENTRY4)) {
                    subGoalTitle = data.getStringExtra(GOALENTRY4);
                }

                int progressValueInt = 0;
                if (!(progressValue.equals(""))) {
                    progressValueInt = Integer.parseInt(progressValue);
                }

                TextView tv1 = (TextView) findViewById(R.id.goalListNameData4);
                tv1.setText(goalName);

                TextView tv2 = (TextView) findViewById(R.id.goalListDescData4);
                tv2.setText(goalDesc);

                final ProgressBar progressBar1 = (ProgressBar) findViewById(R.id.progressBar4);
                progressBar1.setProgress(progressValueInt);

                TextView tv3 = (TextView) findViewById(R.id.goalListShortData4);
                tv3.setText(subGoalTitle);
            }
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Request cancelled", Toast.LENGTH_LONG).show();
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }

        if (requestCode == GOAL_TASK5) {
            if (resultCode == RESULT_OK) {
                String goalName = "";
                if (data.hasExtra(GOALENTRY1)) {
                    goalName = data.getStringExtra(GOALENTRY1);
                }

                String goalDesc = "";
                if (data.hasExtra(GOALENTRY2)) {
                    goalDesc = data.getStringExtra(GOALENTRY2);
                }

                String progressValue = "";
                if (data.hasExtra(GOALENTRY3)) {
                    progressValue = data.getStringExtra(GOALENTRY3);
                }

                String subGoalTitle = "";
                if (data.hasExtra(GOALENTRY4)) {
                    subGoalTitle = data.getStringExtra(GOALENTRY4);
                }

                int progressValueInt = 0;
                if (!(progressValue.equals(""))) {
                    progressValueInt = Integer.parseInt(progressValue);
                }

                TextView tv1 = (TextView) findViewById(R.id.goalListNameData5);
                tv1.setText(goalName);

                TextView tv2 = (TextView) findViewById(R.id.goalListDescData5);
                tv2.setText(goalDesc);

                final ProgressBar progressBar1 = (ProgressBar) findViewById(R.id.progressBar5);
                progressBar1.setProgress(progressValueInt);

                TextView tv3 = (TextView) findViewById(R.id.goalListShortData5);
                tv3.setText(subGoalTitle);
            }
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Request cancelled", Toast.LENGTH_LONG).show();
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }*/
        super.onActivityResult(requestCode, resultCode, data);
    }
}
