package com.example.user.videopoker;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


import static com.example.user.videopoker.GameLogContract.GameLogTable;


public class GameLog {

    private DbHelper mDbHelper;
    private Context context;
    private SQLiteDatabase db;

    public GameLog(){

    }


    protected void addToDb(Context context, String dealString, String finalHandString, int winnings){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//
        this.context = context;
        mDbHelper = new DbHelper(this.context);

        db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(GameLogTable.COLUMN_NAME_DEAL, dealString);
//        values.put(GameLogTable.COLUMN_NAME_HELD, "held");
        values.put(GameLogTable.COLUMN_NAME_FINAL, finalHandString);
        values.put(GameLogTable.COLUMN_NAME_NET, winnings);

        long newRowId = db.insert(GameLogTable.TABLE_NAME, null, values);
        db.close();



    }
}
