package com.example.user.videopoker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.SimpleCursorAdapter;


import static com.example.user.videopoker.GameLogContract.GameLogTable;
import static com.example.user.videopoker.LogActivity.PROJECTION;


public class GameLog {

    private DbHelper mDbHelper;
    private Context context;
    private SQLiteDatabase db;
    private int[] toViews;

    public GameLog(){

    }


    protected void addToDb(Context context, String dealString, String finalHandString, int winnings, String handRank){
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
        values.put(GameLogTable.COLUMN_NAME_HANDRANK, handRank);

        long newRowId = db.insert(GameLogTable.TABLE_NAME, null, values);
        db.close();
    }

    protected SimpleCursorAdapter getAdapterForView(Context context, int[] toViews){

        this.toViews = toViews;
        this.context = context;

        String fromColumns[] = {
                GameLogTable._ID,
                GameLogTable.COLUMN_NAME_DEAL,
//                GameLogTable.COLUMN_NAME_HELD,
                GameLogTable.COLUMN_NAME_FINAL,
                GameLogTable.COLUMN_NAME_NET,
                GameLogTable.COLUMN_NAME_HANDRANK
//                GameLogTable.DUMMY_IMAGE
        };

        this.context = context;
        mDbHelper = new DbHelper(this.context);

        db = mDbHelper.getReadableDatabase();

        SimpleCursorAdapter mAdapter;

        mAdapter = new SimpleCursorAdapter(context, R.layout.activity_log, null, fromColumns, toViews, 0);
        Cursor c = db.query(
                GameLogTable.TABLE_NAME,                     // The table to query
                PROJECTION,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
        mAdapter.swapCursor(c);
        return mAdapter;
    }
}
