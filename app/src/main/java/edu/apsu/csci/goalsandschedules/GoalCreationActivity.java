package edu.apsu.csci.goalsandschedules;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GoalCreationActivity extends Activity implements View.OnClickListener {

    public static final String GOALENTRY1 = "goalentry1";
    public static final String GOALENTRY2 = "goalentry2";
    public static final String GOALENTRY3 = "goalentry3";
    public static final String GOALENTRY4 = "goalentry4";
    public static final String GOALENTRY5 = "goalentry5";

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
        //Button b = (Button) findViewById(R.id.goalsubmit_button);
        //Button b2 = (Button) findViewById(R.id.newSTGoal_button);
        if (v.getId() == R.id.goalsubmit_button) {
            EditText et1 = (EditText) findViewById(R.id.goalTitleEdit);
            EditText et2 = (EditText) findViewById(R.id.goalDescEdit);
            EditText et3 = (EditText) findViewById(R.id.goalProgressEdit);
            EditText et4 = (EditText) findViewById(R.id.goalTitleEdit2);
            EditText et5 = (EditText) findViewById(R.id.goalDescEdit2);
            EditText et6 = (EditText) findViewById(R.id.goalTitleEdit3);
            EditText et7 = (EditText) findViewById(R.id.goalDescEdit3);
            EditText et8 = (EditText) findViewById(R.id.goalTitleEdit4);
            EditText et9 = (EditText) findViewById(R.id.goalDescEdit4);
            EditText et10 = (EditText) findViewById(R.id.goalTitleEdit5);
            EditText et11 = (EditText) findViewById(R.id.goalDescEdit5);
            EditText et12 = (EditText) findViewById(R.id.goalTitleEdit6);
            EditText et13 = (EditText) findViewById(R.id.goalDescEdit6);

            String etString = et1.getText().toString();
            String etString2 = et2.getText().toString();
            String etString3 = et3.getText().toString();
            String etString4 = et4.getText().toString();
            String etString5 = et5.getText().toString();
            String etString6 = et6.getText().toString();
            String etString7 = et7.getText().toString();
            String etString8 = et8.getText().toString();
            String etString9 = et9.getText().toString();
            String etString10 = et10.getText().toString();
            String etString11 = et11.getText().toString();
            String etString12 = et12.getText().toString();
            String etString13 = et13.getText().toString();

            if (etString.equals("") || etString2.equals("") || etString3.equals("") ||
                    etString4.equals("") || etString5.equals("") || etString6.equals("") ||
                    etString7.equals("")) {
                etString3 = "0";
                Toast.makeText(getApplicationContext(), "Please add titles and descriptions for the main goal and two subgoals", Toast.LENGTH_LONG).show();
            } else {
                Intent intent = new Intent(getApplicationContext(), GoalActivity.class);
                intent.putExtra(etString, GOALENTRY1);
                intent.putExtra(etString2, GOALENTRY2);
                intent.putExtra(etString3, GOALENTRY3);
                intent.putExtra(etString4, GOALENTRY4);
                intent.putExtra(etString6, GOALENTRY5);
                startActivity(intent);
            }
        } else if (v.getId() == R.id.newSTGoal_button) {
            /*mainLayout.addView(createNewTextView("Temp"));
            mainLayout.removeView(b2);
            mainLayout.addView(b2);
            mainLayout.removeView(b);
            mainLayout.addView(b); */
        }
    }

    /*private TextView createNewTextView(String text) {
        final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        final TextView textView = new TextView(this);
        textView.setLayoutParams(lparams);
        textView.setText("New text: " + text);
        return textView;
    } */
}
