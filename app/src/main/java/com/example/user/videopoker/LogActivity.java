package com.example.user.videopoker;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import static com.example.user.videopoker.GameLogContract.GameLogTable;


public class LogActivity extends AppCompatActivity {


    TextView mDealView;
    TextView mHeldView;
    TextView mFinalHandView;
    TextView mNetWinnings;
    TextView mHandRankLog;
    ImageView iv;
    ListView mLog;
    static final String[] PROJECTION = new String[] {
            GameLogTable._ID,
            GameLogTable.COLUMN_NAME_DEAL,
//            GameLogContract.GameLogTable.COLUMN_NAME_HELD,
            GameLogTable.COLUMN_NAME_FINAL,
            GameLogTable.COLUMN_NAME_NET,
            GameLogTable.COLUMN_NAME_HANDRANK};
    SimpleCursorAdapter mAdapter;


    static final String SELECTION = "*";
    DbHelper mDbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        mDbHelper = new DbHelper(this);

        //db = mDbHelper.getDatabase();

        //        Log.d("Test", String.valueOf(newRowId));
//


        mDealView = (TextView) findViewById(R.id.deal);
//        mHeldView = (TextView) findViewById(R.id.held);
        mFinalHandView = (TextView) findViewById(R.id.final_hand);
        mNetWinnings = (TextView) findViewById(R.id.net_winnings);
        mHandRankLog = (TextView) findViewById(R.id.hand_rank_log);

        mLog = (ListView) findViewById(R.id.log);
//        iv = (ImageView) findViewById(R.drawable.ace_of_clubs);
//        iv.setImageResource(R.drawable.ace_of_clubs);

        int[] toViews = {R.id.id, R.id.deal, R.id.final_hand, R.id.net_winnings, R.id.hand_rank_log};
        GameLog gameLog = new GameLog();

        mAdapter = gameLog.getAdapterForView(this, toViews);
        mLog.setAdapter(mAdapter);


    }
}
