package com.example.user.videopoker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import static com.example.user.videopoker.GameLogContract.GameLogTable;


public class GameLog extends AppCompatActivity {

    DbHelper mDbHelper;
    SQLiteDatabase db;
    SimpleCursorAdapter mAdapter;
    static final String[] PROJECTION = new String[] {GameLogTable._ID,
            GameLogTable.COLUMN_NAME_DEAL,
            GameLogTable.COLUMN_NAME_HELD,
            GameLogTable.COLUMN_NAME_FINAL,
            GameLogTable.COLUMN_NAME_NET,
            GameLogTable.DUMMY_IMAGE
    };

    static final String SELECTION = "*";

    TextView mDealView;
    TextView mHeldView;
    TextView mFinalHandView;
    TextView mNetWinnings;
    ImageView iv;
    ListView mLog;

    @Override
    protected void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//
//        mDbHelper = new DbHelper(this);
//
//        db = mDbHelper.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//
//        values.put(GameLogTable.COLUMN_NAME_DEAL, "10h Jh Qh Kh Ah");
//        values.put(GameLogTable.COLUMN_NAME_HELD, "held");
//        values.put(GameLogTable.COLUMN_NAME_FINAL, "final");
//        values.put(GameLogTable.COLUMN_NAME_NET, "-50");
//        values.put(GameLogTable.DUMMY_IMAGE, "android.resource://com.example.user.sqltest/2130837587");
//
//
//        long newRowId = db.insert(GameLogTable.TABLE_NAME, null, values);
//        Log.d("Test", String.valueOf(newRowId));
//
//        String fromColumns[] = {
//                GameLogTable._ID,
//                GameLogTable.COLUMN_NAME_DEAL,
//                GameLogTable.COLUMN_NAME_HELD,
//                GameLogTable.COLUMN_NAME_FINAL,
//                GameLogTable.COLUMN_NAME_NET,
//                GameLogTable.DUMMY_IMAGE
//        };
//
//        mDealView = (TextView) findViewById(R.id.deal);
//        mHeldView = (TextView) findViewById(R.id.held);
//        mFinalHandView = (TextView) findViewById(R.id.final_hand);
//        mNetWinnings = (TextView) findViewById(R.id.net_winnings);
//        mLog = (ListView) findViewById(R.id.log);
//        iv = (ImageView) findViewById(R.drawable.ace_of_clubs);
////        iv.setImageResource(R.drawable.ace_of_clubs);
//
//        int[] toViews = {R.id.id, R.id.deal, R.id.held, R.id.final_hand, R.id.net_winnings, R.id.iv};
//
//        mAdapter = new SimpleCursorAdapter(this, R.layout.main, null, fromColumns, toViews, 0);
//        Cursor c = db.query(
//                GameLogTable.TABLE_NAME,                     // The table to query
//                PROJECTION,                               // The columns to return
//                null,                                // The columns for the WHERE clause
//                null,                            // The values for the WHERE clause
//                null,                                     // don't group the rows
//                null,                                     // don't filter by row groups
//                null                                 // The sort order
//        );
//        mAdapter.swapCursor(c);
//        mLog.setAdapter(mAdapter);

    }
}
