package edu.apsu.csci.goalsandschedules;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static edu.apsu.csci.goalsandschedules.MySqlLiteHelper.LONG_TERM_TABLE;
import static edu.apsu.csci.goalsandschedules.MySqlLiteHelper.LongTermColumns.longTerm_id;
import static edu.apsu.csci.goalsandschedules.MySqlLiteHelper.ScheduleColumns.time;

public class DbDataSource {
    private SQLiteDatabase database;
    private MySqlLiteHelper databaseHelper;

    public DbDataSource(Context context) {
        databaseHelper = new MySqlLiteHelper(context);
    }

    public void open() {
        database = databaseHelper.getWritableDatabase();
    }

    public void close() {
        database.close();
    }

    //Long Term Goal
    public LongTermGoal createLongTermGoal(String titleStr, String descriptionStr, String subGoal, String progressStr) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(MySqlLiteHelper.LongTermColumns.title.toString(), titleStr);
        contentValues.put(MySqlLiteHelper.LongTermColumns.description.toString(), descriptionStr);
        contentValues.put(MySqlLiteHelper.LongTermColumns.subgoal.toString(), subGoal);
        contentValues.put(MySqlLiteHelper.LongTermColumns.progress.toString(), progressStr);

        long id = database.insert(MySqlLiteHelper.LONG_TERM_TABLE,
                null, contentValues);

        String[] columnNames = MySqlLiteHelper.LongTermColumns.names();

        Cursor cursor = database.query(MySqlLiteHelper.LONG_TERM_TABLE,
                columnNames,
                MySqlLiteHelper.LongTermColumns.longTerm_id + " = " + id,
                null, null, null, null
        );

        cursor.moveToFirst();
        LongTermGoal longtermgoal = cursorToLongTermGoal(cursor);
        cursor.close();

        return longtermgoal;
    }

    public String currentLongTermID(){
        String currentLongTermID;
        currentLongTermID = database.rawQuery("SELECT MAX(longTerm_id) FROM LONG_TERM_TABLE ", null ).toString();
        return currentLongTermID;
    }
    public List<LongTermGoal> getAllLongTermGoals() {
        List<LongTermGoal> longtermgoals = new ArrayList<>();

        String columns[] = MySqlLiteHelper.LongTermColumns.names();

        Cursor cursor = database.query(LONG_TERM_TABLE,
                columns,
                null, null, null, null, null);

        cursor.moveToNext();
        while (!cursor.isAfterLast()) {
            LongTermGoal longtermgoal = cursorToLongTermGoal(cursor);
            longtermgoals.add(longtermgoal);
            cursor.moveToNext();
        }
        cursor.close();

        return longtermgoals;
    }

    private LongTermGoal cursorToLongTermGoal(Cursor cursor) {
        LongTermGoal longtermgoal = new LongTermGoal();

        int longtermId = cursor.getInt(longTerm_id.ordinal());
        longtermgoal.setLongterm_id(longtermId);

        String title = cursor.getString(MySqlLiteHelper.LongTermColumns.title.ordinal());
        longtermgoal.setTitle(title);

        String description = cursor.getString(MySqlLiteHelper.LongTermColumns.description.ordinal());
        longtermgoal.setDescription(description);

        String subgoal = cursor.getString(MySqlLiteHelper.LongTermColumns.subgoal.ordinal());
        longtermgoal.setSubgoal(subgoal);

        int progress = cursor.getInt(MySqlLiteHelper.LongTermColumns.progress.ordinal());
        longtermgoal.setProgress(progress);

        return longtermgoal;
    }

    //Short Term Goal
    public ShortTermGoal createShortTermGoal(String longterm_idStr, String titleStr, String descriptionStr , String orderStr) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(MySqlLiteHelper.ShortTermColumns.longTerm_id.toString(), longterm_idStr);
        contentValues.put(MySqlLiteHelper.ShortTermColumns.title.toString(), titleStr);
        contentValues.put(MySqlLiteHelper.ShortTermColumns.description.toString(), descriptionStr);
        contentValues.put(MySqlLiteHelper.ShortTermColumns.sortOrder.toString(), orderStr);

        long id = database.insert(MySqlLiteHelper.SHORT_TERM_TABLE,
                null, contentValues);

        String[] columnNames = MySqlLiteHelper.ShortTermColumns.names();

        Cursor cursor = database.query(MySqlLiteHelper.SHORT_TERM_TABLE,
                columnNames,
                MySqlLiteHelper.ShortTermColumns.shortTerm_id + " = " + id,
                null, null, null, null
        );

        cursor.moveToFirst();
        ShortTermGoal shorttermgoal = cursorToShortTermGoal(cursor);
        cursor.close();

        return shorttermgoal;
    }

    public List<ShortTermGoal> getAllShortTermGoals() {
        List<ShortTermGoal> shorttermgoals = new ArrayList<>();

        String columns[] = MySqlLiteHelper.ShortTermColumns.names();

        Cursor cursor = database.query(MySqlLiteHelper.SHORT_TERM_TABLE,
                columns,
                null, null, null, null, null);

        cursor.moveToNext();
        while (!cursor.isAfterLast()) {
            ShortTermGoal shorttermgoal = cursorToShortTermGoal(cursor);
            shorttermgoals.add(shorttermgoal);
            cursor.moveToNext();
        }
        cursor.close();

        return shorttermgoals;
    }

    private ShortTermGoal cursorToShortTermGoal(Cursor cursor) {
        ShortTermGoal shorttermgoal = new ShortTermGoal();

        int shorttermId = cursor.getInt(MySqlLiteHelper.ShortTermColumns.shortTerm_id.ordinal());
        shorttermgoal.setShortterm_id(shorttermId);

        int longtermId = cursor.getInt(MySqlLiteHelper.ShortTermColumns.longTerm_id.ordinal());
        shorttermgoal.setLongterm_id(longtermId);

        String title = cursor.getString(MySqlLiteHelper.ShortTermColumns.title.ordinal());
        shorttermgoal.setTitle(title);

        String description = cursor.getString(MySqlLiteHelper.ShortTermColumns.description.ordinal());
        shorttermgoal.setDescription(description);

        String order = cursor.getString(MySqlLiteHelper.ShortTermColumns.sortOrder.ordinal());
        shorttermgoal.setOrder(order);

        return shorttermgoal;
    }

    //Schedule
    public Schedule createSchedule(String shortterm_idStr, String dateStr, String timeStr, String descriptionStr) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(MySqlLiteHelper.ScheduleColumns.shortTerm_id.toString(), shortterm_idStr);
        contentValues.put(MySqlLiteHelper.ScheduleColumns.date.toString(), dateStr);
        contentValues.put(time.toString(), timeStr);
        contentValues.put(MySqlLiteHelper.ScheduleColumns.description.toString(), descriptionStr);

        long id = database.insert(MySqlLiteHelper.SCHEDULE_TABLE,
                null, contentValues);

        String[] columnNames = MySqlLiteHelper.ScheduleColumns.names();

        Cursor cursor = database.query(MySqlLiteHelper.SCHEDULE_TABLE,
                columnNames,
                MySqlLiteHelper.ScheduleColumns.schedule_id + " = " + id,
                null, null, null, null
        );

        cursor.moveToFirst();
        Schedule schedule = cursorToSchedule(cursor);
        cursor.close();

        return schedule;
    }

    public List<Schedule> getAllSchedules() {
        List<Schedule> schedules = new ArrayList<>();

        String columns[] = MySqlLiteHelper.ScheduleColumns.names();

        Cursor cursor = database.query(MySqlLiteHelper.SCHEDULE_TABLE,
                columns,
                null, null, null, null, null);

        cursor.moveToNext();

        while (!cursor.isAfterLast()) {
            Schedule schedule = cursorToSchedule(cursor);
            schedules.add(schedule);
            cursor.moveToNext();
        }
        cursor.close();

        return schedules;
    }

    private Schedule cursorToSchedule(Cursor cursor) {
        Schedule schedule = new Schedule();

        int scheduleId = cursor.getInt(MySqlLiteHelper.ScheduleColumns.schedule_id.ordinal());
        schedule.setSchedule_id(scheduleId);

        String shorttermId = cursor.getString(MySqlLiteHelper.ScheduleColumns.shortTerm_id.ordinal());
        schedule.setShortterm_id(shorttermId);

        String dateStr = cursor.getString(MySqlLiteHelper.ScheduleColumns.date.ordinal());

        DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);

        schedule.setDate(dateStr);

        String timeStr = cursor.getString(time.ordinal());
        schedule.setTime(timeStr);

        String description = cursor.getString(MySqlLiteHelper.ScheduleColumns.description.ordinal());
        schedule.setDescription(description);

        return schedule;
    }


}
