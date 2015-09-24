package com.example.hp.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*** Created by GBY9C3HL on 21/09/2015. */
public class PassOrNot {

    public static final String KEY_ROW_ID = "_id";
    public static final String KEY_NAME = "person_name";
    public static final String KEY_SKILL = "person_skill";

    private static final String DATABASE_NAME = "PassOrNotDB";
    private static final String DATABASE_TABLE = "PeopleTable";
    private static final int DATABASE_VERSION = 1;

    private DBHelper dbHelper;
    private final Context context;
    private SQLiteDatabase database;

    private static class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            // Creates the database (Only called the first time the database is created)
            sqLiteDatabase.execSQL("CREATE TABLE " + DATABASE_NAME + " (" +
                    KEY_ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    KEY_NAME + " TEXT NOT NULL, " +
                    KEY_SKILL + " TEXT NOT NULL);"
            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            // If table already exists, this method would be called instead of the 'onCreate' method
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(sqLiteDatabase);
        }
    }

    public PassOrNot(Context context) {
        this.context = context;
    }

    public PassOrNot open () throws SQLException {
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public long createEntry(String name, String skill) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, name);
        contentValues.put(KEY_SKILL, skill);
        return database.insert(DATABASE_TABLE, null, contentValues);
    }
}
