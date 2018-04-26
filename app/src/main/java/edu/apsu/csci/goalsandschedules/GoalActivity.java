package edu.apsu.csci.goalsandschedules;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class GoalActivity extends Activity implements View.OnClickListener {

    public static final int GOALLIST1 = 1000;

    //private int progressStatus = 0;
    //private Handler handler1 = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

        Intent intent = getIntent();

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

        final ProgressBar progressBar1 = (ProgressBar) findViewById(R.id.progressBar);
        progressBar1.setProgress(0);
        if (intent.getStringExtra(GoalCreationActivity.GOALENTRY3) != null) {
            int etInt = Integer.parseInt(intent.getStringExtra(GoalCreationActivity.GOALENTRY3));
            progressBar1.setProgress(etInt);
        }

        final ProgressBar progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
        progressBar2.setProgress(0);
        if (intent.getStringExtra(GoalCreationActivity.GOALENTRY3) != null) {
            int etInt = Integer.parseInt(intent.getStringExtra(GoalCreationActivity.GOALENTRY3));
            progressBar1.setProgress(etInt);
        }

        final ProgressBar progressBar3 = (ProgressBar) findViewById(R.id.progressBar3);
        progressBar3.setProgress(0);
        if (intent.getStringExtra(GoalCreationActivity.GOALENTRY3) != null) {
            int etInt = Integer.parseInt(intent.getStringExtra(GoalCreationActivity.GOALENTRY3));
            progressBar1.setProgress(etInt);
        }

        final ProgressBar progressBar4 = (ProgressBar) findViewById(R.id.progressBar4);
        progressBar4.setProgress(0);
        if (intent.getStringExtra(GoalCreationActivity.GOALENTRY3) != null) {
            int etInt = Integer.parseInt(intent.getStringExtra(GoalCreationActivity.GOALENTRY3));
            progressBar1.setProgress(etInt);
        }

        final ProgressBar progressBar5 = (ProgressBar) findViewById(R.id.progressBar5);
        progressBar5.setProgress(0);
        if (intent.getStringExtra(GoalCreationActivity.GOALENTRY3) != null) {
            int etInt = Integer.parseInt(intent.getStringExtra(GoalCreationActivity.GOALENTRY3));
            progressBar1.setProgress(etInt);
        }

        TextView tv1 = (TextView) findViewById(R.id.goalListNameData);
        if (intent.getStringExtra(GoalCreationActivity.GOALENTRY1) != null) {
            tv1.setText(intent.getStringExtra(GoalCreationActivity.GOALENTRY1));
        }

        TextView tv2 = (TextView) findViewById(R.id.goalListDescData);
        if (intent.getStringExtra(GoalCreationActivity.GOALENTRY2) != null) {
            tv2.setText(intent.getStringExtra(GoalCreationActivity.GOALENTRY2));
        }

        TextView tv3 = (TextView) findViewById(R.id.goalListNameData2);
        if (intent.getStringExtra(GoalCreationActivity.GOALENTRY4) != null) {
            tv3.setText(intent.getStringExtra(GoalCreationActivity.GOALENTRY4));
        }

        TextView tv4 = (TextView) findViewById(R.id.goalListNameData3);
        if (intent.getStringExtra(GoalCreationActivity.GOALENTRY5) != null) {
            tv4.setText(intent.getStringExtra(GoalCreationActivity.GOALENTRY5));
        }

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
            startActivity(intent);
            //startActivityForResult(intent, GOALLIST1);
        } else if (v.getId() == R.id.goalList2) {
            Intent intent = new Intent(getApplicationContext(), GoalCreationActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.goalList3) {
            Intent intent = new Intent(getApplicationContext(), GoalCreationActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.goalList4) {
            Intent intent = new Intent(getApplicationContext(), GoalCreationActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.goalList5) {
            Intent intent = new Intent(getApplicationContext(), GoalCreationActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.goaladd_button) {
            Intent intent = new Intent(getApplicationContext(), GoalCreationActivity.class);
            startActivity(intent);
        }
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageURI = data.getData();
                drawableView.setImageURI(selectedImageURI);
            }
        }
    } */
}
