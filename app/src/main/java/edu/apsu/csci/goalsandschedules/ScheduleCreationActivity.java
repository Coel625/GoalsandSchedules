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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        Intent intent = new Intent();

        EditText et1 = (EditText) findViewById(R.id.entryStartEdit);
        EditText et2 = (EditText) findViewById(R.id.entryEndEdit);
        EditText et3 = (EditText) findViewById(R.id.entryDescEdit);
        Spinner spinner = (Spinner) findViewById(R.id.entryDateSelect);
        Spinner spinner2 = (Spinner) findViewById(R.id.entryShortSelect);

        String etString = et1.getText().toString();
        String etString2 = et2.getText().toString();
        String spinnerString = spinner.getSelectedItem().toString();
        String spinnerString2 = spinner2.getSelectedItem().toString();
        String etString3 = et3.getText().toString();

        if (etString.equals("") || etString2.equals("") || etString3.equals("") ||
                spinnerString.equals("Select a date:") || spinnerString2.equals("Select one of your short-term goals:")) {
            Toast.makeText(this, "Please fill in the date and data fields for this entry", Toast.LENGTH_LONG).show();
        } else {
            if (!(etString.equals("")) || !(etString2.equals("")) || !(etString3.equals("")) ||
                    !(spinnerString.equals("")) || !(spinnerString2.equals(""))) {
                String combinedTimesString = "From " + etString + " to " + etString2;
                intent.putExtra(ScheduleActivity.SCHEDULEDATA1, combinedTimesString);

                String combinedDateString = "on " + spinnerString;
                intent.putExtra(ScheduleActivity.SCHEDULEDATA2, combinedDateString);

                String combinedShortString = "Short-Term Goals: " + spinnerString2;
                intent.putExtra(ScheduleActivity.SCHEDULEDATA3, combinedShortString);

                intent.putExtra(ScheduleActivity.SCHEDULEDATA4, etString3);

                /*String combinedShortString = etString4 + ", " + etString6;
                if (!(etString8.equals("")) && !(etString9.equals("")) && etString10.equals("") && etString11.equals("") &&
                        etString12.equals("") && etString13.equals("")) {
                    combinedShortString += ", " + etString8;
                } else if (!(etString10.equals("")) && !(etString11.equals("")) && etString8.equals("") && etString9.equals("") &&
                        etString12.equals("") && etString13.equals("")) {
                    combinedShortString += ", " + etString10;
                } else if (!(etString12.equals("")) && !(etString13.equals("")) && etString8.equals("") && etString9.equals("") &&
                        etString10.equals("") && etString11.equals("")) {
                    combinedShortString += ", " + etString12;
                } else if (!(etString8.equals("")) && !(etString9.equals("")) && !(etString10.equals("")) && !(etString11.equals("")) &&
                        etString12.equals("") && etString13.equals("")) {
                    combinedShortString += ", " + etString8 + ", " + etString10;
                } else if (!(etString8.equals("")) && !(etString9.equals("")) && !(etString12.equals("")) && !(etString13.equals("")) &&
                        etString10.equals("") && etString11.equals("")) {
                    combinedShortString += ", " + etString8 + ", " + etString12;
                } else if (!(etString10.equals("")) && !(etString11.equals("")) && !(etString12.equals("")) && !(etString13.equals("")) &&
                        etString8.equals("") && etString9.equals("")) {
                    combinedShortString += ", " + etString10 + ", " + etString12;
                } else if (!(etString8.equals("")) && !(etString9.equals("")) && !(etString10.equals("")) && !(etString11.equals("")) &&
                        !(etString12.equals("")) && !(etString13.equals(""))) {
                    combinedShortString += ", " + etString8 + ", " + etString10 + ", " + etString12;
                } */

                setResult(RESULT_OK, intent);
            } else {
                setResult(RESULT_CANCELED);
            }

            super.finish();
        }
    }
}