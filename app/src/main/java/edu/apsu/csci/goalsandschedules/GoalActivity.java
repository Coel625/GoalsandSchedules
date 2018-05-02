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
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class GoalActivity extends ListActivity implements View.OnClickListener {

    private DbDataSource dataSource;

    public static final String GOALENTRY1 = "goalentry1";
    public static final String GOALENTRY2 = "goalentry2";
    public static final String GOALENTRY3 = "goalentry3";
    public static final String GOALENTRY4 = "goalentry4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

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
        Intent intent = new Intent(getApplicationContext(), GoalCreationActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.schedule_button) {
            Intent intent = new Intent(getApplicationContext(), ScheduleActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.online_button) {
            Intent intent = new Intent(getApplicationContext(), OnlineActivity.class);
            startActivity(intent);
        }
    }

    private void loadForm(){

        dataSource = new DbDataSource(getApplicationContext());
        dataSource.open();
        List<LongTermGoal> longTermGoal = dataSource.getAllLongTermGoals();
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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            loadForm();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
