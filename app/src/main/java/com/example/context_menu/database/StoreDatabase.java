package com.example.context_menu.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StoreDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "lessonDatabase.db";
    public static final String TABLE_NAME_SERIAL = "serials_table";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_USERS = "users";

    public static final String COLUMN_USER_NAME = "user_name";
    public static final String COLUMN_USER_EMAIL= "user_email";
    public static final String COLUMN_USER_PASSWORD = "user_password";
    public static final String COLUMN_USER_PHONE = "user_phone";

    public static final String COL_1_s = "SERIES_NAME";
    public static final String COL_2_s = "SERIES_BUDGET";
    public static final String COL_3_s = "SERIES_RATING";

    Context context;

    public StoreDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL("CREATE TABLE " + TABLE_USERS + "(" +
                COLUMN_USER_NAME + " TEXT, " +
                COLUMN_USER_EMAIL + " TEXT , " +
                COLUMN_USER_PASSWORD + " TEXT , " +
                COLUMN_USER_PHONE + " INTIGER)");

        db.execSQL("CREATE TABLE " + TABLE_NAME_SERIAL + "(" +
                COL_1_s + " TEXT, " +
                COL_2_s + " INTEGER , " +
                COL_3_s + " TEXT)");

        initGroups(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_SERIAL);

        onCreate(db);
    }

    public void initGroups(SQLiteDatabase db){
        ContentValues monthSeries = new ContentValues();
        monthSeries.put(COL_1_s, "Sherlock");
        monthSeries.put(COL_2_s, 155000);
        monthSeries.put(COL_3_s, "Steven Moffat");

        db.insert(TABLE_NAME_SERIAL, null, monthSeries);

        ContentValues weekSeries = new ContentValues();
        weekSeries.put(COL_1_s, "Peaky Blinders");
        weekSeries.put(COL_2_s, 93000);
        weekSeries.put(COL_3_s, "Tim Mielants");

        db.insert(TABLE_NAME_SERIAL, null, weekSeries);

        ContentValues yearSeries = new ContentValues();
        yearSeries.put(COL_1_s, "The good doctor");
        yearSeries.put(COL_2_s, 70000);
        yearSeries.put(COL_3_s, "David Shore");

        db.insert(TABLE_NAME_SERIAL, null, yearSeries);
    }
}
