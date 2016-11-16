package com.example.user.videopoker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.user.videopoker.GameLogContract.GameLogTable;

public class DbHelper extends SQLiteOpenHelper {
        // If you change the database schema, you must increment the database version.
        public static final int DATABASE_VERSION = 3;
        public static final String DATABASE_NAME = "game_log.db";
        private static final String TEXT_TYPE = " TEXT";
        private static final String INTEGER_TYPE = " INTEGER";
        private static final String COMMA_SEP = ",";

        private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + GameLogTable.TABLE_NAME + " (" +
            GameLogTable._ID + " INTEGER PRIMARY KEY," +
            GameLogTable.COLUMN_NAME_DEAL + TEXT_TYPE + COMMA_SEP +
//            GameLogTable.COLUMN_NAME_HELD + TEXT_TYPE + COMMA_SEP +
            GameLogTable.COLUMN_NAME_FINAL + TEXT_TYPE + COMMA_SEP +
            GameLogTable.COLUMN_NAME_NET + INTEGER_TYPE + COMMA_SEP +
            GameLogTable.COLUMN_NAME_HANDRANK + TEXT_TYPE + " )";

        private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + GameLogTable.TABLE_NAME;

        public DbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ENTRIES);
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
            db.execSQL(SQL_DELETE_ENTRIES);
            onCreate(db);
        }

}
