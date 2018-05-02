package edu.apsu.csci.goalsandschedules;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GoalActivity extends ListActivity implements View.OnClickListener {

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
        setContentView(R.layout.activity_goal);

        dataSource = new DbDataSource(getApplicationContext());

        //dataSource.open();
        //dataSource.createLongTermGoal("0","0","0");
        //dataSource.close();

        //loadForm();

        Button b = (Button) findViewById(R.id.goal_button);
        b.setPaintFlags(b.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        b.setOnClickListener(this);

        Button b2 = (Button) findViewById(R.id.schedule_button);
        b2.setPaintFlags(b2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        b2.setOnClickListener(this);

        Button b3 = (Button) findViewById(R.id.online_button);
        b3.setPaintFlags(b3.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        b3.setOnClickListener(this);

        /*LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.goalEntrySlot);
        linearLayout1.setOnClickListener(this);

        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.goalList2);
        linearLayout2.setOnClickListener(this);

        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.goalList3);
        linearLayout3.setOnClickListener(this);

        LinearLayout linearLayout4 = (LinearLayout) findViewById(R.id.goalList4);
        linearLayout4.setOnClickListener(this);

        LinearLayout linearLayout5 = (LinearLayout) findViewById(R.id.goalList5);
        linearLayout5.setOnClickListener(this); */
    }

    @Override
    protected void onStart() {
        super.onStart();

        dataSource.open();

        List<LongTermGoal> longTermGoal = dataSource.getAllLongTermGoals();

        ArrayAdapter<LongTermGoal> adapter = new ArrayAdapter<LongTermGoal>(this,
                R.layout.entry_set, R.id.goalListNameData, longTermGoal);
        setListAdapter(new MultipleGoalAdapter(GoalActivity.this, R.layout.entry_set, longTermGoal));
    }

    @Override
    protected void onStop() {
        super.onStop();
        dataSource.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.goal_menu, menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (item.getItemId() == R.id.menu_add_goal) {
            //Intent intent = new Intent(getApplicationContext(), GoalCreationActivity.class);
            //startActivityForResult(intent, GOAL_TASK1);
            String longTermTitleString = "title";
            String longTermDescString = "description";
            String longTermSubString = "subgoal";
            String longTermProgressString = "0";
            LongTermGoal longTermGoal = dataSource.createLongTermGoal(longTermTitleString, longTermDescString, longTermSubString, longTermProgressString);

            ArrayAdapter<LongTermGoal> adapter = (ArrayAdapter<LongTermGoal>) getListAdapter();
            adapter.add(longTermGoal);
            adapter.notifyDataSetChanged();
        }
        return super.onMenuItemSelected(featureId, item);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //Toast.makeText(this, "Id: " + id , Toast.LENGTH_LONG).show();

        //final List<LongTermGoal> longTermGoal = dataSource.getAllLongTermGoals();

        //ArrayAdapter<LongTermGoal> adapter = (ArrayAdapter<LongTermGoal>) getListAdapter();
        //adapter.remove(longTermGoal);
        //adapter.notifyDataSetChanged();

        //final List<LongTermGoal> longTermGoal = dataSource.getAllLongTermGoals();
        //ListView lv = (ListView) findViewById(android.R.id.list);
        //lv.invalidateViews();

        //final ArrayAdapter<LongTermGoal> adapter = new ArrayAdapter<LongTermGoal>(this,
        //        R.layout.entry_set, R.id.goalListNameData, longTermGoal);
        //adapter.clear();
        //adapter.setNotifyOnChange(true);
        //lv.setAdapter(adapter);
        Intent intent = new Intent(getApplicationContext(), GoalCreationActivity.class);
        startActivity(intent);
        //updateView(position);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.schedule_button) {
            Intent intent = new Intent(getApplicationContext(), ScheduleActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.online_button) {
            Intent intent = new Intent(getApplicationContext(), OnlineActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.goalEntrySlot) {
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

    private void updateView(int index){
        View v = getListView().getChildAt(index -
                getListView().getFirstVisiblePosition());

        if(v == null)
            return;


        //if (index == 0) {
            dataSource = new DbDataSource(getApplicationContext());
            dataSource.open();
            List<LongTermGoal> longTermGoal = dataSource.getAllLongTermGoals();
           // if (!(longTermGoal.size()-1 < 0)) {
                LongTermGoal ltg = longTermGoal.get(longTermGoal.size()-1);
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
           // }
       // } else if (index == 1) {
       //     TextView someText2 = (TextView) v.findViewById(R.id.goalListDescData);
       //     someText2.setText("Hi! I sussed you manually!");
       // }

        /*ProgressBar LTGProgress = (ProgressBar) findViewById(R.id.progressBar);
        LTGProgress.setProgress(60);

        TextView someText3 = (TextView) v.findViewById(R.id.goalListShortData);
        someText3.setText("Hi! I updated you manually!"); */
    }

    private void loadForm(){

        dataSource = new DbDataSource(getApplicationContext());
        dataSource.open();
        List<LongTermGoal> longTermGoal = dataSource.getAllLongTermGoals();
        //if(!(longTermGoal.size()-1 < 0)) {
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
            //ArrayAdapter<LongTermGoal> adapter = (ArrayAdapter<LongTermGoal>) getListAdapter();
            //adapter.add(ltg);
            //adapter.notifyDataSetChanged();

            /*if (!(longTermGoal.size() - 2 < 0)) {
                ltg = longTermGoal.get(longTermGoal.size() - 2);
                LTG1Title = (TextView) findViewById(R.id.goalListNameData2);
                LTG1Title.setText(ltg.getTitle());
                LTGDescription = (TextView) findViewById(R.id.goalListDescData2);
                LTGDescription.setText(ltg.getDescription());
                LTGProgress = (ProgressBar) findViewById(R.id.progressBar2);
                LTGProgress.setProgress(ltg.getProgress());
                shortTermGoal = dataSource.getAllShortTermGoals();
                stg = shortTermGoal.get(shortTermGoal.size() - 2);
                STGTitle = (TextView) findViewById(R.id.goalListShortData2);
                STGTitle.setText(stg.getTitle());
            }

            if (!(longTermGoal.size() - 3 < 0)) {
                ltg = longTermGoal.get(longTermGoal.size() - 3);
                LTG1Title = (TextView) findViewById(R.id.goalListNameData3);
                LTG1Title.setText(ltg.getTitle());
                LTGDescription = (TextView) findViewById(R.id.goalListDescData3);
                LTGDescription.setText(ltg.getDescription());
                LTGProgress = (ProgressBar) findViewById(R.id.progressBar3);
                LTGProgress.setProgress(ltg.getProgress());
                shortTermGoal = dataSource.getAllShortTermGoals();
                stg = shortTermGoal.get(shortTermGoal.size() - 3);
                STGTitle = (TextView) findViewById(R.id.goalListShortData3);
                STGTitle.setText(stg.getTitle());
            }

            if (!(longTermGoal.size() - 4 < 0)) {
                ltg = longTermGoal.get(longTermGoal.size() - 4);
                LTG1Title = (TextView) findViewById(R.id.goalListNameData4);
                LTG1Title.setText(ltg.getTitle());
                LTGDescription = (TextView) findViewById(R.id.goalListDescData4);
                LTGDescription.setText(ltg.getDescription());
                LTGProgress = (ProgressBar) findViewById(R.id.progressBar4);
                LTGProgress.setProgress(ltg.getProgress());
                shortTermGoal = dataSource.getAllShortTermGoals();
                stg = shortTermGoal.get(shortTermGoal.size() - 4);
                STGTitle = (TextView) findViewById(R.id.goalListShortData4);
                STGTitle.setText(stg.getTitle());
            }

            if (!(longTermGoal.size() - 5 < 0)) {
                ltg = longTermGoal.get(longTermGoal.size() - 5);
                LTG1Title = (TextView) findViewById(R.id.goalListNameData5);
                LTG1Title.setText(ltg.getTitle());
                LTGDescription = (TextView) findViewById(R.id.goalListDescData5);
                LTGDescription.setText(ltg.getDescription());
                LTGProgress = (ProgressBar) findViewById(R.id.progressBar5);
                LTGProgress.setProgress(ltg.getProgress());
                shortTermGoal = dataSource.getAllShortTermGoals();
                stg = shortTermGoal.get(shortTermGoal.size() - 5);
                STGTitle = (TextView) findViewById(R.id.goalListShortData5);
                STGTitle.setText(stg.getTitle());
            } */
       // }
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
