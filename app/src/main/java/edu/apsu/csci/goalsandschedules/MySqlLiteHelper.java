package edu.apsu.csci.goalsandschedules;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqlLiteHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="G&S.sqlite";
    private static final int DB_VERSION=1;

    public static final String LONG_TERM_TABLE="LongTerm";
    public static final String SHORT_TERM_TABLE="ShortTerm";
    public static final String SCHEDULE_TABLE="Schedule";

    public enum LongTermColumns {
        longterm_id, title, description, progress;

        public static String[] names() {
            LongTermColumns[] v=values();
            String[] names=new String[v.length];
            for (int i=0; i < v.length; i++) {
                names[i]=v[i].toString();
            }
            return names;
        }
    }

    public enum ShortTermColumns {
        shortterm_id, longterm_id, title, description, order;

        public static String[] names() {
            ShortTermColumns[] v=values();
            String[] names=new String[v.length];
            for (int i=0; i < v.length; i++) {
                names[i]=v[i].toString();
            }
            return names;
        }
    }

    public enum ScheduleColumns {
        schedule_id, shortterm_id, title, date, start, end, description;

        public static String[] names() {
            ScheduleColumns[] v=values();
            String[] names=new String[v.length];
            for (int i=0; i < v.length; i++) {
                names[i]=v[i].toString();
            }
            return names;
        }
    }

    public MySqlLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE " + LONG_TERM_TABLE + " (" +
                LongTermColumns.longterm_id + " INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , " +
                LongTermColumns.title + " TEXT NOT NULL , " +
                LongTermColumns.description + " TEXT NOT NULL , " +
                LongTermColumns.progress + " TEXT NOT NULL )";
        db.execSQL(sql);
        sql="CREATE TABLE " + SHORT_TERM_TABLE + " (" +
                ShortTermColumns.shortterm_id + " INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , " +
                ShortTermColumns.longterm_id + " TEXT  NOT NULL , " +
                ShortTermColumns.title + " TEXT NOT NULL , " +
                ShortTermColumns.description + " TEXT NOT NULL ," +
                ShortTermColumns.order + " TEXT NOT NULL )";
        db.execSQL(sql);
        sql="CREATE TABLE " + SCHEDULE_TABLE + " (" +
                ScheduleColumns.schedule_id + " INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , " +
                ScheduleColumns.shortterm_id + " TEXT  NOT NULL , " +
                ScheduleColumns.title + "  TEXT NOT NULL , " +
                ScheduleColumns.date + "  TEXT NOT NULL , " +
                ScheduleColumns.start + " TEXT NOT NULL , " +
                ScheduleColumns.end + " TEXT NOT NULL , " +
                ScheduleColumns.description + " TEXT NOT NULL )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 1 && newVersion == 2) {
            String sql="alter table " + LONG_TERM_TABLE + " add column extra integer";
            db.execSQL(sql);

            sql="update " + LONG_TERM_TABLE + " set extra = 42";
            db.execSQL(sql);
            sql="alter table " + SHORT_TERM_TABLE + " add column extra integer";
            db.execSQL(sql);

            sql="update " + SHORT_TERM_TABLE + " set extra = 42";
            db.execSQL(sql);
            sql="alter table " + SCHEDULE_TABLE + " add column extra integer";
            db.execSQL(sql);

            sql="update " + SCHEDULE_TABLE + " set extra = 42";
            db.execSQL(sql);
        }
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion == 1 && oldVersion != newVersion) {

            // The reason we need all this code is because
            // SQLite does not support ALTER TABLE ... DROP COLUMN
            try {
                db.beginTransaction();

                // copy table that needs column dropped
                String sql="alter table " + LONG_TERM_TABLE + " rename to tmp";
                db.execSQL(sql);

                // recreate the table in the old schema
                sql="CREATE TABLE " + LONG_TERM_TABLE + " (" +
                        LongTermColumns.longterm_id + " INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , " +
                        LongTermColumns.title + " TEXT NOT NULL , " +
                        LongTermColumns.description + " TEXT NOT NULL , " +
                        LongTermColumns.progress + " TEXT NOT NULL )";
                db.execSQL(sql);

                // copy the data we want from the old table
                sql="insert into " + LONG_TERM_TABLE +
                        " select " +
                        LongTermColumns.longterm_id + ", " +
                        LongTermColumns.title + ", " +
                        LongTermColumns.description + "," +
                        LongTermColumns.progress +
                        " from tmp";
                db.execSQL(sql);
                // copy table that needs column dropped
                sql="alter table " + SHORT_TERM_TABLE + " rename to tmp";
                db.execSQL(sql);

                // recreate the table in the old schema
                sql="CREATE TABLE " + SHORT_TERM_TABLE + " (" +
                        ShortTermColumns.shortterm_id + " INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , " +
                        ShortTermColumns.longterm_id + " TEXT  NOT NULL , " +
                        ShortTermColumns.title + " TEXT NOT NULL , " +
                        ShortTermColumns.description + " TEXT NOT NULL ," +
                        ShortTermColumns.order + " TEXT NOT NULL )";
                db.execSQL(sql);

                // copy the data we want from the old table
                sql="insert into " + SHORT_TERM_TABLE +
                        " select " +
                        ShortTermColumns.shortterm_id + ", " +
                        ShortTermColumns.longterm_id + ", " +
                        ShortTermColumns.title + ", " +
                        ShortTermColumns.description + ", " +
                        ShortTermColumns.order +
                        " from tmp";
                db.execSQL(sql);
                // copy table that needs column dropped
                sql="alter table " + SCHEDULE_TABLE + " rename to tmp";
                db.execSQL(sql);

                // recreate the table in the old schema
                sql="CREATE TABLE " + SCHEDULE_TABLE + " (" +
                        ScheduleColumns.schedule_id + " INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , " +
                        ScheduleColumns.shortterm_id + " TEXT  NOT NULL , " +
                        ScheduleColumns.title + "  TEXT NOT NULL , " +
                        ScheduleColumns.date + "  TEXT NOT NULL , " +
                        ScheduleColumns.start + " TEXT NOT NULL , " +
                        ScheduleColumns.end + " TEXT NOT NULL , " +
                        ScheduleColumns.description + " TEXT NOT NULL )";
                db.execSQL(sql);

                // copy the data we want from the old table
                sql="insert into " + SCHEDULE_TABLE +
                        " select " +
                        ScheduleColumns.schedule_id + ", " +
                        ScheduleColumns.shortterm_id + ", " +
                        ScheduleColumns.title + ", " +
                        ScheduleColumns.date + ", " +
                        ScheduleColumns.start + "," +
                        ScheduleColumns.end + ", " +
                        ScheduleColumns.description +
                        " from tmp";
                db.execSQL(sql);

                // get rid of the temporary table
                sql="drop table tmp";
                db.execSQL(sql);

                db.setTransactionSuccessful();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                db.endTransaction();
            }
        }
    }
}

