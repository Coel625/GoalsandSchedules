package edu.apsu.csci.goalsandschedules;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GoalCreationActivity extends Activity implements View.OnClickListener {

    private LinearLayout mainLayout;
    private DbDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataSource=new DbDataSource(getApplicationContext());
        setContentView(R.layout.activity_goalcreation);

        mainLayout=(LinearLayout) findViewById(R.id.goalcreation_layout);

        Button b=(Button) findViewById(R.id.goalsubmit_button);
        b.setPaintFlags(b.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        b.setOnClickListener(this);

        Button b2=(Button) findViewById(R.id.newSTGoal_button);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //Button b = (Button) findViewById(R.id.goalsubmit_button);
        //Button b2 = (Button) findViewById(R.id.newSTGoal_button);
        if (v.getId() == R.id.goalsubmit_button) {
            finish();
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

    @Override
    public void finish() {
        dataSource = new DbDataSource(getApplicationContext());
        dataSource.open();
        Intent intent=new Intent();
        Integer sortOrder=1;
        Integer currentLongTermID= 1;
        EditText et1=(EditText) findViewById(R.id.goalTitleEdit);
        String et1Str = et1.getText().toString();
        EditText et2=(EditText) findViewById(R.id.goalDescEdit);
        String et2Str = et2.getText().toString();
        String shortGoalString = "";

        EditText et4=(EditText) findViewById(R.id.goalTitleEdit2);
        String et4Str = et4.getText().toString();
        if (!(et4Str.equals(""))) {
            shortGoalString += et4.getText().toString() + " | ";
        }

        EditText et5=(EditText) findViewById(R.id.goalDescEdit2);

        EditText et6=(EditText) findViewById(R.id.goalTitleEdit3);
        String et6Str = et6.getText().toString();
        if (!(et6Str.equals(""))) {
            shortGoalString += et6.getText().toString() + " | ";
        }

        EditText et7=(EditText) findViewById(R.id.goalDescEdit3);

        EditText et8=(EditText) findViewById(R.id.goalTitleEdit4);
        String et8Str = et8.getText().toString();
        if (!(et8Str.equals(""))) {
            shortGoalString += et8.getText().toString() + " | ";
        }

        EditText et9=(EditText) findViewById(R.id.goalDescEdit4);

        EditText et10=(EditText) findViewById(R.id.goalTitleEdit5);
        String et10Str = et10.getText().toString();
        if (!(et10Str.equals(""))) {
            shortGoalString += et10.getText().toString() + " | ";
        }

        EditText et11=(EditText) findViewById(R.id.goalDescEdit5);

        EditText et12=(EditText) findViewById(R.id.goalTitleEdit6);
        String et12Str = et12.getText().toString();
        if (!(et12Str.equals(""))) {
            shortGoalString += et12.getText().toString() + " | ";
        }

        EditText et13=(EditText) findViewById(R.id.goalDescEdit6);
        //dataSource.createShortTermGoal(currentLongTermID.toString(), et4.getText().toString(), et5.getText().toString(), sortOrder.toString());


        /*EditText et6=(EditText) findViewById(R.id.goalTitleEdit3);
        EditText et7=(EditText) findViewById(R.id.goalDescEdit3);
        dataSource.createShortTermGoal(currentLongTermID.toString(), et6.getText().toString(), et7.getText().toString(), sortOrder.toString());
        et6.getText().clear();
        et7.getText().clear(); */
        //sortOrder=+1;
        /*
        EditText et6=(EditText) findViewById(R.id.goalTitleEdit3);
        EditText et7=(EditText) findViewById(R.id.goalDescEdit3);
        dataSource.createShortTermGoal(currentLongTermID.toString(), et6.toString(), et7.toString(), sortOrder.toString());
        et5.getText().clear();
        et7.getText().clear();
        sortOrder=+1;
        EditText et8=(EditText) findViewById(R.id.goalTitleEdit4);
        EditText et9=(EditText) findViewById(R.id.goalDescEdit4);
        dataSource.createShortTermGoal(currentLongTermID.toString(), et8.toString(), et9.toString(), sortOrder.toString());
        et8.getText().clear();
        et9.getText().clear();
        sortOrder=+1;
        EditText et10=(EditText) findViewById(R.id.goalTitleEdit5);
        EditText et11=(EditText) findViewById(R.id.goalDescEdit5);
        dataSource.createShortTermGoal(currentLongTermID.toString(), et10.toString(), et11.toString(), sortOrder.toString());
        et10.getText().clear();
        et11.getText().clear();
        sortOrder=+1;
        EditText et12=(EditText) findViewById(R.id.goalTitleEdit6);
        EditText et13=(EditText) findViewById(R.id.goalDescEdit6);
        dataSource.createShortTermGoal(currentLongTermID.toString(), et12.toString(), et13.toString(), sortOrder.toString());
        et12.getText().clear();
        et13.getText().clear();
        sortOrder=+1;
        EditText et14=(EditText) findViewById(R.id.goalShortNumber);
*/

        String etString = et1.getText().toString();
        String etString2 = et2.getText().toString();
        String etString3 = "0";
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

        EditText et14=(EditText) findViewById(R.id.goalShortNumber);
        String etString14 = et14.getText().toString();

        int subGoalValue;
        if (etString14.equals("")) {
            subGoalValue = 1;
        } else {
            subGoalValue = Integer.parseInt(etString14);
        }

        if (subGoalValue < 1) {
            subGoalValue = 1;
        } else if (subGoalValue > 5) {
            subGoalValue = 5;
        }

        CheckBox checkBox = (CheckBox) findViewById(R.id.subGoalCheck);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.subGoalCheck2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.subGoalCheck3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.subGoalCheck4);
        CheckBox checkBox5 = (CheckBox) findViewById(R.id.subGoalCheck5);

        if (etString.equals("") || etString2.equals("")) {
            Toast.makeText(this, "Please write down the titles and descriptions for the main goal and two subgoals", Toast.LENGTH_LONG).show();
        } else {
            if (!(etString.equals("")) || !(etString2.equals(""))) {
                intent.putExtra(GoalActivity.GOALENTRY1, etString);
                intent.putExtra(GoalActivity.GOALENTRY2, etString2);
                if ((checkBox.isChecked() && !(checkBox2.isChecked()) && !(checkBox3.isChecked()) && !(checkBox4.isChecked()) && !(checkBox5.isChecked())) ||
                        (checkBox2.isChecked() && !(checkBox.isChecked()) && !(checkBox3.isChecked()) && !(checkBox4.isChecked()) && !(checkBox5.isChecked())) ||
                        (checkBox3.isChecked() && !(checkBox.isChecked()) && !(checkBox2.isChecked()) && !(checkBox4.isChecked()) && !(checkBox5.isChecked())) ||
                        (checkBox4.isChecked() && !(checkBox.isChecked()) && !(checkBox2.isChecked()) && !(checkBox3.isChecked()) && !(checkBox5.isChecked())) ||
                        (checkBox5.isChecked() && !(checkBox.isChecked()) && !(checkBox2.isChecked()) && !(checkBox3.isChecked()) && !(checkBox4.isChecked()))) {
                    if (subGoalValue == 1) {
                        etString3 = "100";
                    } else if (subGoalValue == 2) {
                        etString3 = "50";
                    } else if (subGoalValue == 3) {
                        etString3 = "33";
                    } else if (subGoalValue == 4) {
                        etString3 = "25";
                    } else if (subGoalValue == 5) {
                        etString3 = "20";
                    }
                } else if (((checkBox.isChecked() && checkBox2.isChecked()) && !(checkBox3.isChecked()) && !(checkBox4.isChecked()) && !(checkBox5.isChecked())) ||
                        ((checkBox.isChecked() && checkBox3.isChecked()) && !(checkBox2.isChecked()) && !(checkBox4.isChecked()) && !(checkBox5.isChecked())) ||
                        ((checkBox.isChecked() && checkBox4.isChecked()) && !(checkBox2.isChecked()) && !(checkBox3.isChecked()) && !(checkBox5.isChecked())) ||
                        ((checkBox.isChecked() && checkBox5.isChecked()) && !(checkBox2.isChecked()) && !(checkBox4.isChecked()) && !(checkBox3.isChecked())) ||
                        ((checkBox2.isChecked() && checkBox3.isChecked()) && !(checkBox.isChecked()) && !(checkBox4.isChecked()) && !(checkBox5.isChecked())) ||
                        ((checkBox2.isChecked() && checkBox4.isChecked()) && !(checkBox3.isChecked()) && !(checkBox.isChecked()) && !(checkBox5.isChecked())) ||
                        ((checkBox2.isChecked() && checkBox5.isChecked()) && !(checkBox.isChecked()) && !(checkBox4.isChecked()) && !(checkBox3.isChecked())) ||
                        ((checkBox3.isChecked() && checkBox4.isChecked()) && !(checkBox.isChecked()) && !(checkBox2.isChecked()) && !(checkBox5.isChecked())) ||
                        ((checkBox3.isChecked() && checkBox5.isChecked()) && !(checkBox.isChecked()) && !(checkBox4.isChecked()) && !(checkBox2.isChecked())) ||
                        ((checkBox4.isChecked() && checkBox5.isChecked()) && !(checkBox3.isChecked()) && !(checkBox.isChecked()) && !(checkBox2.isChecked()))) {
                    if (subGoalValue == 1) {
                        subGoalValue = 2;
                    }

                    if (subGoalValue == 2) {
                        etString3 = "100";
                    } else if (subGoalValue == 3) {
                        etString3 = "66";
                    } else if (subGoalValue == 4) {
                        etString3 = "50";
                    } else if (subGoalValue == 5) {
                        etString3 = "40";
                    }
                } else if (((checkBox.isChecked() && checkBox2.isChecked() && checkBox3.isChecked()) && !(checkBox4.isChecked()) && !(checkBox5.isChecked())) ||
                        ((checkBox.isChecked() && checkBox2.isChecked() && checkBox4.isChecked()) && !(checkBox3.isChecked()) && !(checkBox5.isChecked())) ||
                        ((checkBox.isChecked() && checkBox2.isChecked() && checkBox5.isChecked()) && !(checkBox3.isChecked()) && !(checkBox4.isChecked())) ||
                        ((checkBox.isChecked() && checkBox3.isChecked() && checkBox4.isChecked()) && !(checkBox2.isChecked()) && !(checkBox5.isChecked())) ||
                        ((checkBox.isChecked() && checkBox3.isChecked() && checkBox5.isChecked()) && !(checkBox4.isChecked()) && !(checkBox2.isChecked())) ||
                        ((checkBox.isChecked() && checkBox4.isChecked() && checkBox5.isChecked()) && !(checkBox2.isChecked()) && !(checkBox3.isChecked())) ||
                        ((checkBox2.isChecked() && checkBox.isChecked() && checkBox3.isChecked()) && !(checkBox4.isChecked()) && !(checkBox5.isChecked())) ||
                        ((checkBox2.isChecked() && checkBox.isChecked() && checkBox4.isChecked()) && !(checkBox3.isChecked()) && !(checkBox5.isChecked())) ||
                        ((checkBox2.isChecked() && checkBox.isChecked() && checkBox5.isChecked()) && !(checkBox3.isChecked()) && !(checkBox4.isChecked())) ||
                        ((checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked()) && !(checkBox.isChecked()) && !(checkBox5.isChecked())) ||
                        ((checkBox2.isChecked() && checkBox3.isChecked() && checkBox5.isChecked()) && !(checkBox4.isChecked()) && !(checkBox.isChecked())) ||
                        ((checkBox2.isChecked() && checkBox4.isChecked() && checkBox5.isChecked()) && !(checkBox.isChecked()) && !(checkBox3.isChecked())) ||
                        ((checkBox3.isChecked() && checkBox.isChecked() && checkBox2.isChecked()) && !(checkBox4.isChecked()) && !(checkBox5.isChecked())) ||
                        ((checkBox3.isChecked() && checkBox.isChecked() && checkBox4.isChecked()) && !(checkBox2.isChecked()) && !(checkBox5.isChecked())) ||
                        ((checkBox3.isChecked() && checkBox.isChecked() && checkBox5.isChecked()) && !(checkBox2.isChecked()) && !(checkBox4.isChecked())) ||
                        ((checkBox3.isChecked() && checkBox2.isChecked() && checkBox4.isChecked()) && !(checkBox.isChecked()) && !(checkBox5.isChecked())) ||
                        ((checkBox3.isChecked() && checkBox2.isChecked() && checkBox5.isChecked()) && !(checkBox.isChecked()) && !(checkBox4.isChecked())) ||
                        ((checkBox3.isChecked() && checkBox4.isChecked() && checkBox5.isChecked()) && !(checkBox.isChecked()) && !(checkBox2.isChecked())) ||
                        ((checkBox4.isChecked() && checkBox.isChecked() && checkBox2.isChecked()) && !(checkBox3.isChecked()) && !(checkBox5.isChecked())) ||
                        ((checkBox4.isChecked() && checkBox.isChecked() && checkBox3.isChecked()) && !(checkBox2.isChecked()) && !(checkBox5.isChecked())) ||
                        ((checkBox4.isChecked() && checkBox.isChecked() && checkBox5.isChecked()) && !(checkBox2.isChecked()) && !(checkBox3.isChecked())) ||
                        ((checkBox4.isChecked() && checkBox2.isChecked() && checkBox3.isChecked()) && !(checkBox.isChecked()) && !(checkBox5.isChecked())) ||
                        ((checkBox4.isChecked() && checkBox2.isChecked() && checkBox5.isChecked()) && !(checkBox.isChecked()) && !(checkBox3.isChecked())) ||
                        ((checkBox4.isChecked() && checkBox3.isChecked() && checkBox5.isChecked()) && !(checkBox.isChecked()) && !(checkBox2.isChecked())) ||
                        ((checkBox5.isChecked() && checkBox.isChecked() && checkBox2.isChecked()) && !(checkBox3.isChecked()) && !(checkBox4.isChecked())) ||
                        ((checkBox5.isChecked() && checkBox.isChecked() && checkBox3.isChecked()) && !(checkBox2.isChecked()) && !(checkBox4.isChecked())) ||
                        ((checkBox5.isChecked() && checkBox.isChecked() && checkBox4.isChecked()) && !(checkBox2.isChecked()) && !(checkBox3.isChecked())) ||
                        ((checkBox5.isChecked() && checkBox2.isChecked() && checkBox3.isChecked()) && !(checkBox.isChecked()) && !(checkBox4.isChecked())) ||
                        ((checkBox5.isChecked() && checkBox2.isChecked() && checkBox4.isChecked()) && !(checkBox.isChecked()) && !(checkBox3.isChecked())) ||
                        ((checkBox5.isChecked() && checkBox3.isChecked() && checkBox4.isChecked()) && !(checkBox.isChecked()) && !(checkBox2.isChecked()))) {
                    if (subGoalValue == 1 || subGoalValue == 2) {
                        subGoalValue = 3;
                    }

                    if (subGoalValue == 3) {
                        etString3 = "100";
                    } else if (subGoalValue == 4) {
                        etString3 = "75";
                    } else if (subGoalValue == 5) {
                        etString3 = "60";
                    }
                } else if ((checkBox.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked() && !(checkBox5.isChecked())) ||
                        (checkBox.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && checkBox5.isChecked() && !(checkBox4.isChecked())) ||
                        (checkBox.isChecked() && checkBox2.isChecked() && checkBox4.isChecked() && checkBox5.isChecked() && !(checkBox3.isChecked())) ||
                        (checkBox.isChecked() && checkBox3.isChecked() && checkBox2.isChecked() && checkBox4.isChecked() && !(checkBox5.isChecked())) ||
                        (checkBox.isChecked() && checkBox3.isChecked() && checkBox2.isChecked() && checkBox5.isChecked() && !(checkBox4.isChecked())) ||
                        (checkBox.isChecked() && checkBox3.isChecked() && checkBox4.isChecked() && checkBox5.isChecked() && !(checkBox2.isChecked())) ||
                        (checkBox.isChecked() && checkBox4.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && !(checkBox5.isChecked())) ||
                        (checkBox.isChecked() && checkBox4.isChecked() && checkBox2.isChecked() && checkBox5.isChecked() && !(checkBox3.isChecked())) ||
                        (checkBox.isChecked() && checkBox4.isChecked() && checkBox3.isChecked() && checkBox5.isChecked() && !(checkBox2.isChecked())) ||
                        (checkBox.isChecked() && checkBox5.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && !(checkBox4.isChecked())) ||
                        (checkBox.isChecked() && checkBox5.isChecked() && checkBox2.isChecked() && checkBox4.isChecked() && !(checkBox3.isChecked())) ||
                        (checkBox.isChecked() && checkBox5.isChecked() && checkBox3.isChecked() && checkBox4.isChecked() && !(checkBox2.isChecked())) ||
                        (checkBox2.isChecked() && checkBox.isChecked() && checkBox3.isChecked() && checkBox4.isChecked() && !(checkBox5.isChecked())) ||
                        (checkBox2.isChecked() && checkBox.isChecked() && checkBox3.isChecked() && checkBox5.isChecked() && !(checkBox4.isChecked())) ||
                        (checkBox2.isChecked() && checkBox.isChecked() && checkBox4.isChecked() && checkBox5.isChecked() && !(checkBox3.isChecked())) ||
                        (checkBox2.isChecked() && checkBox3.isChecked() && checkBox.isChecked() && checkBox4.isChecked() && !(checkBox5.isChecked())) ||
                        (checkBox2.isChecked() && checkBox3.isChecked() && checkBox.isChecked() && checkBox5.isChecked() && !(checkBox4.isChecked())) ||
                        (checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked() && checkBox5.isChecked() && !(checkBox.isChecked())) ||
                        (checkBox2.isChecked() && checkBox4.isChecked() && checkBox.isChecked() && checkBox3.isChecked() && !(checkBox5.isChecked())) ||
                        (checkBox2.isChecked() && checkBox4.isChecked() && checkBox.isChecked() && checkBox5.isChecked() && !(checkBox3.isChecked())) ||
                        (checkBox2.isChecked() && checkBox4.isChecked() && checkBox3.isChecked() && checkBox5.isChecked() && !(checkBox.isChecked())) ||
                        (checkBox2.isChecked() && checkBox5.isChecked() && checkBox.isChecked() && checkBox3.isChecked() && !(checkBox4.isChecked())) ||
                        (checkBox2.isChecked() && checkBox5.isChecked() && checkBox.isChecked() && checkBox4.isChecked() && !(checkBox3.isChecked())) ||
                        (checkBox2.isChecked() && checkBox5.isChecked() && checkBox3.isChecked() && checkBox4.isChecked() && !(checkBox.isChecked())) ||
                        (checkBox3.isChecked() && checkBox2.isChecked() && checkBox.isChecked() && checkBox4.isChecked() && !(checkBox5.isChecked())) ||
                        (checkBox3.isChecked() && checkBox2.isChecked() && checkBox.isChecked() && checkBox5.isChecked() && !(checkBox4.isChecked())) ||
                        (checkBox3.isChecked() && checkBox2.isChecked() && checkBox4.isChecked() && checkBox5.isChecked() && !(checkBox.isChecked())) ||
                        (checkBox3.isChecked() && checkBox.isChecked() && checkBox2.isChecked() && checkBox4.isChecked() && !(checkBox5.isChecked())) ||
                        (checkBox3.isChecked() && checkBox.isChecked() && checkBox2.isChecked() && checkBox5.isChecked() && !(checkBox4.isChecked())) ||
                        (checkBox3.isChecked() && checkBox.isChecked() && checkBox4.isChecked() && checkBox5.isChecked() && !(checkBox2.isChecked())) ||
                        (checkBox3.isChecked() && checkBox4.isChecked() && checkBox2.isChecked() && checkBox.isChecked() && !(checkBox5.isChecked())) ||
                        (checkBox3.isChecked() && checkBox4.isChecked() && checkBox2.isChecked() && checkBox5.isChecked() && !(checkBox.isChecked())) ||
                        (checkBox3.isChecked() && checkBox4.isChecked() && checkBox.isChecked() && checkBox5.isChecked() && !(checkBox2.isChecked())) ||
                        (checkBox3.isChecked() && checkBox5.isChecked() && checkBox2.isChecked() && checkBox.isChecked() && !(checkBox4.isChecked())) ||
                        (checkBox3.isChecked() && checkBox5.isChecked() && checkBox2.isChecked() && checkBox4.isChecked() && !(checkBox.isChecked())) ||
                        (checkBox3.isChecked() && checkBox5.isChecked() && checkBox.isChecked() && checkBox4.isChecked() && !(checkBox2.isChecked())) ||
                        (checkBox4.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && checkBox.isChecked() && !(checkBox5.isChecked())) ||
                        (checkBox4.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && checkBox5.isChecked() && !(checkBox.isChecked())) ||
                        (checkBox4.isChecked() && checkBox2.isChecked() && checkBox.isChecked() && checkBox5.isChecked() && !(checkBox3.isChecked())) ||
                        (checkBox4.isChecked() && checkBox3.isChecked() && checkBox2.isChecked() && checkBox.isChecked() && !(checkBox5.isChecked())) ||
                        (checkBox4.isChecked() && checkBox3.isChecked() && checkBox2.isChecked() && checkBox5.isChecked() && !(checkBox.isChecked())) ||
                        (checkBox4.isChecked() && checkBox3.isChecked() && checkBox.isChecked() && checkBox5.isChecked() && !(checkBox2.isChecked())) ||
                        (checkBox4.isChecked() && checkBox.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && !(checkBox5.isChecked())) ||
                        (checkBox4.isChecked() && checkBox.isChecked() && checkBox2.isChecked() && checkBox5.isChecked() && !(checkBox3.isChecked())) ||
                        (checkBox4.isChecked() && checkBox.isChecked() && checkBox3.isChecked() && checkBox5.isChecked() && !(checkBox2.isChecked())) ||
                        (checkBox4.isChecked() && checkBox5.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && !(checkBox.isChecked())) ||
                        (checkBox4.isChecked() && checkBox5.isChecked() && checkBox2.isChecked() && checkBox.isChecked() && !(checkBox3.isChecked())) ||
                        (checkBox4.isChecked() && checkBox5.isChecked() && checkBox3.isChecked() && checkBox.isChecked() && !(checkBox2.isChecked())) ||
                        (checkBox5.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked() && !(checkBox.isChecked())) ||
                        (checkBox5.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && checkBox.isChecked() && !(checkBox4.isChecked())) ||
                        (checkBox5.isChecked() && checkBox2.isChecked() && checkBox4.isChecked() && checkBox.isChecked() && !(checkBox3.isChecked())) ||
                        (checkBox5.isChecked() && checkBox3.isChecked() && checkBox2.isChecked() && checkBox4.isChecked() && !(checkBox.isChecked())) ||
                        (checkBox5.isChecked() && checkBox3.isChecked() && checkBox2.isChecked() && checkBox.isChecked() && !(checkBox4.isChecked())) ||
                        (checkBox5.isChecked() && checkBox3.isChecked() && checkBox4.isChecked() && checkBox.isChecked() && !(checkBox2.isChecked())) ||
                        (checkBox5.isChecked() && checkBox4.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && !(checkBox.isChecked())) ||
                        (checkBox5.isChecked() && checkBox4.isChecked() && checkBox2.isChecked() && checkBox.isChecked() && !(checkBox3.isChecked())) ||
                        (checkBox5.isChecked() && checkBox4.isChecked() && checkBox3.isChecked() && checkBox.isChecked() && !(checkBox2.isChecked())) ||
                        (checkBox5.isChecked() && checkBox.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && !(checkBox4.isChecked())) ||
                        (checkBox5.isChecked() && checkBox.isChecked() && checkBox2.isChecked() && checkBox4.isChecked() && !(checkBox3.isChecked())) ||
                        (checkBox5.isChecked() && checkBox.isChecked() && checkBox3.isChecked() && checkBox4.isChecked() && !(checkBox2.isChecked()))) {
                    if (subGoalValue == 1 || subGoalValue == 2 || subGoalValue == 3) {
                        subGoalValue = 4;
                    }

                    if (subGoalValue == 4) {
                        etString3 = "100";
                    } else if (subGoalValue == 5) {
                        etString3 = "80";
                    }
                } else if (checkBox.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked() && checkBox5.isChecked()) {
                    if (subGoalValue == 1 || subGoalValue == 2 || subGoalValue == 3 || subGoalValue == 4) {
                        subGoalValue = 5;
                    }

                    if (subGoalValue == 5) {
                        etString3 = "100";
                    }
                }

                intent.putExtra(GoalActivity.GOALENTRY3, etString3);

                String combinedShortString = etString4 + ", " + etString6;
                if (checkBox.isChecked() && !(checkBox2.isChecked())) {
                    combinedShortString = etString6;
                } else if (checkBox2.isChecked() && !(checkBox.isChecked())) {
                    combinedShortString = etString4;
                } else if ((checkBox.isChecked() && checkBox2.isChecked())) {
                    combinedShortString = "";
                } else if (!(checkBox.isChecked()) && !(checkBox2.isChecked())) {
                    combinedShortString = etString4 + " | " + etString6;
                }

                if (!(etString8.equals("")) && !(etString9.equals("")) && etString10.equals("") && etString11.equals("") &&
                        etString12.equals("") && etString13.equals("") && !(checkBox3.isChecked()) && !(checkBox4.isChecked()) && !(checkBox5.isChecked())) {
                    combinedShortString += "| " + etString8;
                } else if (!(etString8.equals("")) && !(etString9.equals("")) && etString10.equals("") && etString11.equals("") &&
                        etString12.equals("") && etString13.equals("") && checkBox3.isChecked() && !(checkBox4.isChecked()) && !(checkBox5.isChecked())) {
                    combinedShortString += " ";
                } else if (!(etString10.equals("")) && !(etString11.equals("")) && etString8.equals("") && etString9.equals("") &&
                        etString12.equals("") && etString13.equals("") && !(checkBox3.isChecked()) && !(checkBox4.isChecked()) && !(checkBox5.isChecked())) {
                    combinedShortString += "| " + etString10;
                } else if (!(etString10.equals("")) && !(etString11.equals("")) && etString8.equals("") && etString9.equals("") &&
                        etString12.equals("") && etString13.equals("") && checkBox4.isChecked() && !(checkBox3.isChecked()) && !(checkBox5.isChecked())) {
                    combinedShortString += " ";
                } else if (!(etString12.equals("")) && !(etString13.equals("")) && etString8.equals("") && etString9.equals("") &&
                        etString10.equals("") && etString11.equals("") && !(checkBox3.isChecked()) && !(checkBox4.isChecked()) && !(checkBox5.isChecked())) {
                    combinedShortString += "| " + etString12;
                } else if (!(etString12.equals("")) && !(etString13.equals("")) && etString8.equals("") && etString9.equals("") &&
                        etString10.equals("") && etString11.equals("") && checkBox5.isChecked() && !(checkBox3.isChecked()) && !(checkBox4.isChecked())) {
                    combinedShortString += " ";
                } else if (!(etString8.equals("")) && !(etString9.equals("")) && !(etString10.equals("")) && !(etString11.equals("")) &&
                        etString12.equals("") && etString13.equals("") && !(checkBox3.isChecked()) && !(checkBox4.isChecked()) && !(checkBox5.isChecked())) {
                    combinedShortString += "| " + etString8 + ", " + etString10;
                } else if (!(etString8.equals("")) && !(etString9.equals("")) && !(etString10.equals("")) && !(etString11.equals("")) &&
                        etString12.equals("") && etString13.equals("") && checkBox3.isChecked() && !(checkBox4.isChecked()) && !(checkBox5.isChecked())) {
                    combinedShortString += "| " + etString10;
                } else if (!(etString8.equals("")) && !(etString9.equals("")) && !(etString10.equals("")) && !(etString11.equals("")) &&
                        etString12.equals("") && etString13.equals("") && checkBox4.isChecked() && !(checkBox3.isChecked()) && !(checkBox5.isChecked())) {
                    combinedShortString += "| " + etString8;
                } else if (!(etString8.equals("")) && !(etString9.equals("")) && !(etString10.equals("")) && !(etString11.equals("")) &&
                        etString12.equals("") && etString13.equals("") && checkBox3.isChecked() && checkBox4.isChecked() && !(checkBox5.isChecked())) {
                    combinedShortString += " ";
                } else if (!(etString8.equals("")) && !(etString9.equals("")) && !(etString12.equals("")) && !(etString13.equals("")) &&
                        etString10.equals("") && etString11.equals("") && !(checkBox3.isChecked()) && !(checkBox4.isChecked()) && !(checkBox5.isChecked())) {
                    combinedShortString += "| " + etString8 + ", " + etString12;
                } else if (!(etString8.equals("")) && !(etString9.equals("")) && !(etString12.equals("")) && !(etString13.equals("")) &&
                        etString10.equals("") && etString11.equals("") && checkBox3.isChecked() && !(checkBox4.isChecked()) && !(checkBox5.isChecked())) {
                    combinedShortString += "| " + etString12;
                } else if (!(etString8.equals("")) && !(etString9.equals("")) && !(etString12.equals("")) && !(etString13.equals("")) &&
                        etString10.equals("") && etString11.equals("") && checkBox5.isChecked() && !(checkBox3.isChecked()) && !(checkBox4.isChecked())) {
                    combinedShortString += "| " + etString8;
                } else if (!(etString8.equals("")) && !(etString9.equals("")) && !(etString12.equals("")) && !(etString13.equals("")) &&
                        etString10.equals("") && etString11.equals("") && checkBox3.isChecked() && checkBox5.isChecked() && !(checkBox4.isChecked())) {
                    combinedShortString += " ";
                } else if (!(etString10.equals("")) && !(etString11.equals("")) && !(etString12.equals("")) && !(etString13.equals("")) &&
                        etString8.equals("") && etString9.equals("") && !(checkBox3.isChecked()) && !(checkBox4.isChecked()) && !(checkBox5.isChecked())) {
                    combinedShortString += "| " + etString10 + ", " + etString12;
                } else if (!(etString10.equals("")) && !(etString11.equals("")) && !(etString12.equals("")) && !(etString13.equals("")) &&
                        etString8.equals("") && etString9.equals("") && checkBox4.isChecked() && !(checkBox3.isChecked()) && !(checkBox5.isChecked())) {
                    combinedShortString += "| " + etString12;
                } else if (!(etString10.equals("")) && !(etString11.equals("")) && !(etString12.equals("")) && !(etString13.equals("")) &&
                        etString8.equals("") && etString9.equals("") && checkBox5.isChecked() && !(checkBox3.isChecked()) && !(checkBox4.isChecked())) {
                    combinedShortString += "| " + etString10;
                } else if (!(etString10.equals("")) && !(etString11.equals("")) && !(etString12.equals("")) && !(etString13.equals("")) &&
                        etString8.equals("") && etString9.equals("") && checkBox4.isChecked() && checkBox5.isChecked() && !(checkBox3.isChecked())) {
                    combinedShortString += " ";
                } else if (!(etString8.equals("")) && !(etString9.equals("")) && !(etString10.equals("")) && !(etString11.equals("")) &&
                        !(etString12.equals("")) && !(etString13.equals("")) && !(checkBox3.isChecked()) && !(checkBox4.isChecked()) && !(checkBox5.isChecked())) {
                    combinedShortString += "| " + etString8 + ", " + etString10 + ", " + etString12;
                } else if (!(etString8.equals("")) && !(etString9.equals("")) && !(etString10.equals("")) && !(etString11.equals("")) &&
                        !(etString12.equals("")) && !(etString13.equals("")) && checkBox3.isChecked() && !(checkBox4.isChecked()) && !(checkBox5.isChecked())) {
                    combinedShortString += "| " + etString10 + ", " + etString12;
                } else if (!(etString8.equals("")) && !(etString9.equals("")) && !(etString10.equals("")) && !(etString11.equals("")) &&
                        !(etString12.equals("")) && !(etString13.equals("")) && checkBox4.isChecked() && !(checkBox3.isChecked()) && !(checkBox5.isChecked())) {
                    combinedShortString += "| " + etString8 + ", " + etString12;
                } else if (!(etString8.equals("")) && !(etString9.equals("")) && !(etString10.equals("")) && !(etString11.equals("")) &&
                        !(etString12.equals("")) && !(etString13.equals("")) && checkBox5.isChecked() && !(checkBox3.isChecked()) && !(checkBox4.isChecked())) {
                    combinedShortString += "| " + etString8 + ", " + etString10;
                } else if (!(etString8.equals("")) && !(etString9.equals("")) && !(etString10.equals("")) && !(etString11.equals("")) &&
                        !(etString12.equals("")) && !(etString13.equals("")) && checkBox3.isChecked() && checkBox4.isChecked() && !(checkBox5.isChecked())) {
                    combinedShortString += "| " + etString12;
                } else if (!(etString8.equals("")) && !(etString9.equals("")) && !(etString10.equals("")) && !(etString11.equals("")) &&
                        !(etString12.equals("")) && !(etString13.equals("")) && checkBox3.isChecked() && checkBox5.isChecked() && !(checkBox4.isChecked())) {
                    combinedShortString += "| " + etString10;
                } else if (!(etString8.equals("")) && !(etString9.equals("")) && !(etString10.equals("")) && !(etString11.equals("")) &&
                        !(etString12.equals("")) && !(etString13.equals("")) && checkBox4.isChecked() && checkBox5.isChecked() && !(checkBox3.isChecked())) {
                    combinedShortString += "| " + etString8;
                } else if (!(etString8.equals("")) && !(etString9.equals("")) && !(etString10.equals("")) && !(etString11.equals("")) &&
                        !(etString12.equals("")) && !(etString13.equals("")) && checkBox3.isChecked() && checkBox4.isChecked() && checkBox5.isChecked()) {
                    combinedShortString += " ";
                }

                if (subGoalValue == 2 && !(etString.equals("100")) && (etString4.equals("") || etString6.equals(""))) {
                    combinedShortString += "| Unspecified";
                } else if (subGoalValue == 3 && !(etString.equals("100")) && (etString4.equals("") ||
                        etString6.equals("") || etString8.equals(""))) {
                    combinedShortString += "| Unspecified";
                } else if (subGoalValue == 4 && !(etString.equals("100")) && (etString4.equals("") ||
                        etString6.equals("") || etString8.equals("") || etString10.equals(""))) {
                    combinedShortString += "| Unspecified";
                } else if (subGoalValue == 5 && !(etString.equals("100")) && (etString4.equals("") ||
                        etString6.equals("") || etString8.equals("") || etString10.equals("") || etString12.equals(""))) {
                    combinedShortString += "| Unspecified";
                }

                dataSource.createLongTermGoal(et1Str, et2Str, combinedShortString, etString3);
                et1.getText().clear();
                et2.getText().clear();
                et4.getText().clear();
                et5.getText().clear();
                et6.getText().clear();
                et7.getText().clear();
                et8.getText().clear();
                et9.getText().clear();
                et10.getText().clear();
                et11.getText().clear();
                et12.getText().clear();
                et13.getText().clear();

                intent.putExtra(GoalActivity.GOALENTRY4, combinedShortString);

                setResult(RESULT_OK);
                //} else {
                //  setResult(RESULT_CANCELED);
                //}

                super.finish();
            }
        }
    }
}
