package edu.apsu.csci.goalsandschedules;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GoalCreationActivity extends Activity implements View.OnClickListener {

    private LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goalcreation);

        mainLayout = (LinearLayout) findViewById(R.id.goalcreation_layout);

        Button b = (Button) findViewById(R.id.goalsubmit_button);
        b.setPaintFlags(b.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        b.setOnClickListener(this);

        Button b2 = (Button) findViewById(R.id.newSTGoal_button);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) findViewById(R.id.goalsubmit_button);
        Button b2 = (Button) findViewById(R.id.newSTGoal_button);
        if (v.getId() == R.id.goalsubmit_button) {
            Intent intent = new Intent(getApplicationContext(), GoalActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.newSTGoal_button) {
            mainLayout.addView(createNewTextView("Temp"));
            mainLayout.removeView(b2);
            mainLayout.addView(b2);
            mainLayout.removeView(b);
            mainLayout.addView(b);
        }
    }

    private TextView createNewTextView(String text) {
        final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        final TextView textView = new TextView(this);
        textView.setLayoutParams(lparams);
        textView.setText("New text: " + text);
        return textView;
    }
}