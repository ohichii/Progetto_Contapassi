package com.example.zineb.progetto_contapassi;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by azmah on 05/02/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "DataBase.db";
    public static final String TABLE_NAME = "JasonFileTable";
    public static final String ID = "ID";
    public static final String NAME = "NAME";
    public static final String JASON_FILE = "JASON_FILE";
    public static final String DATE_SESSION = "DATE_SESSION";
    public static final String SPEED = "SPEED";
    public static final String STEPS = "STEPS";
    public static final String X_SPEED = "X_SPEED";
    public static final String X_STEPS = "X_STEPS";


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, JASON_FILE TEXT," +
                    " DATE_SESSION DATE, SPEED DOUBLE, STEPS INTEGER, X_SPEED DOUBLE, X_STEPS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String js, String date, double speed, int steps, double x_speed, int x_steps){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(JASON_FILE, js);
        contentValues.put(DATE_SESSION, date);
        contentValues.put(SPEED, speed);
        contentValues.put(STEPS, steps);
        contentValues.put(X_SPEED, x_speed);
        contentValues.put(X_STEPS, x_steps);

        long result = db.insert(TABLE_NAME,null, contentValues);
        if(result == -1)
            return false;
        else
            return true;

    }
}
