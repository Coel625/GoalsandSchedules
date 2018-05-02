package edu.apsu.csci.goalsandschedules;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ScheduleCreationActivity extends Activity implements View.OnClickListener {

    private LinearLayout mainLayout;
    private DbDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataSource=new DbDataSource(getApplicationContext());
        setContentView(R.layout.activity_schedulecreation);

        mainLayout = (LinearLayout) findViewById(R.id.schedulecreation_layout);

        Button b = (Button) findViewById(R.id.schedulesubmit_button);
        b.setPaintFlags(b.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //Button b = (Button) findViewById(R.id.schedulesubmit_button);
        //Button b2 = (Button) findViewById(R.id.newSTEntry_button);
        if (v.getId() == R.id.schedulesubmit_button) {
            finish();
        }
    }

    @Override
    public void finish() {

        dataSource = new DbDataSource(getApplicationContext());
        dataSource.open();
        Intent intent = new Intent();

        EditText et1 = (EditText) findViewById(R.id.entryStartTimeFirstEdit);
        EditText et2 = (EditText) findViewById(R.id.entryStartTimeLastEdit);
        EditText et3 = (EditText) findViewById(R.id.entryEndTimeFirstEdit);
        EditText et4 = (EditText) findViewById(R.id.entryEndTimeLastEdit);
        Spinner spinner = (Spinner) findViewById(R.id.entryDateSelect);
        Spinner spinner2 = (Spinner) findViewById(R.id.entryShortSelect);
        EditText et5 = (EditText) findViewById(R.id.entryDescEdit);

        String etString = et1.getText().toString();
        String etString2 = et2.getText().toString();
        String etString3 = et3.getText().toString();
        String etString4 = et4.getText().toString();

        int etStartFirstInt;
        if (!(etString.equals(""))) {
            etStartFirstInt = Integer.parseInt(etString);
        } else {
            etStartFirstInt = 99;
        }

        int etStartLastInt;
        if (!(etString2.equals(""))) {
            etStartLastInt = Integer.parseInt(etString2);
        } else {
            etStartLastInt = 99;
        }

        int etEndFirstInt;
        if (!(etString3.equals(""))) {
            etEndFirstInt = Integer.parseInt(etString3);
        } else {
            etEndFirstInt = 99;
        }

        int etEndLastInt;
        if (!(etString4.equals(""))) {
            etEndLastInt = Integer.parseInt(etString4);
        } else {
            etEndLastInt = 99;
        }

        String spinnerString = spinner.getSelectedItem().toString();
        String spinnerString2 = spinner2.getSelectedItem().toString();
        String etString5 = et5.getText().toString();

        if (etString5.equals("") || spinnerString.equals("Select a date:") || spinnerString2.equals("Select one of your short-term goals:") ||
                etStartFirstInt == 99 || etStartLastInt == 99 || etEndFirstInt == 99 || etEndLastInt == 99 ||
                etStartFirstInt >= 24 || etStartLastInt >= 60 || etEndFirstInt >= 24 || etEndLastInt >= 60) {
            Toast.makeText(this, "Please correct the date fields and data for this entry", Toast.LENGTH_LONG).show();
        } else {
            if (!(etString.equals("")) || !(etString2.equals("")) || !(etString3.equals("")) || !(etString4.equals("")) || !(etString5.equals("")) ||
                    !(spinnerString.equals("")) || !(spinnerString2.equals(""))) {

                if (etStartLastInt == 0 || etStartLastInt == 1 || etStartLastInt == 2 || etStartLastInt == 3 ||
                        etStartLastInt == 4 || etStartLastInt == 5 || etStartLastInt == 6 || etStartLastInt == 7 ||
                        etStartLastInt == 8 || etStartLastInt == 9) {
                    etString2 = "0" + etString2;
                }

                if (etEndLastInt == 0 || etEndLastInt == 1 || etEndLastInt == 2 || etEndLastInt == 3 ||
                        etEndLastInt == 4 || etEndLastInt == 5 || etEndLastInt == 6 || etEndLastInt == 7 ||
                        etEndLastInt == 8 || etEndLastInt == 9) {
                    etString4 = "0" + etString4;
                }

                String combinedTimesString = "From " + etString + ":" + etString2 + " to " + etString3 + ":" + etString4;
                String combinedDateString = "on " + spinnerString;
                String combinedShortString = "Short-Term Goals: " + spinnerString2;

                dataSource.createSchedule(combinedShortString, combinedDateString, combinedTimesString, etString5, etString5);
                et5.getText().clear();

                intent.putExtra(ScheduleActivity.SCHEDULEDATA1, combinedTimesString);
                intent.putExtra(ScheduleActivity.SCHEDULEDATA2, combinedDateString);
                intent.putExtra(ScheduleActivity.SCHEDULEDATA3, combinedShortString);
                intent.putExtra(ScheduleActivity.SCHEDULEDATA4, etString5);

                setResult(RESULT_OK, intent);
            } else {
                setResult(RESULT_CANCELED);
            }

            super.finish();
        }
    }
}