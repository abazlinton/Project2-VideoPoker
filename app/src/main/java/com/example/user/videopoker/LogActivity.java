package com.example.user.videopoker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class LogActivity extends AppCompatActivity {


    TextView mDealView;
    TextView mHeldView;
    TextView mFinalHandView;
    TextView mNetWinnings;
    ImageView iv;
    ListView mLog;
    static final String[] PROJECTION = new String[] {GameLogContract.GameLogTable._ID,
            GameLogContract.GameLogTable.COLUMN_NAME_DEAL,
//            GameLogContract.GameLogTable.COLUMN_NAME_HELD,
            GameLogContract.GameLogTable.COLUMN_NAME_FINAL,
            GameLogContract.GameLogTable.COLUMN_NAME_NET,
    };
    SimpleCursorAdapter mAdapter;


    static final String SELECTION = "*";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

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
