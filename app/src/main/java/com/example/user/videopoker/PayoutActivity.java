package com.example.user.videopoker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by user on 16/11/2016.
 */

public class PayoutActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payout_activity);

        TextView leftTextView = (TextView) findViewById(R.id.hand_rank_friendly);
        TextView rightTextView = (TextView) findViewById(R.id.hand_rank_payout);

        String rankingsText = "";
        String payoutsText = "";
        HandRank handRank = HandRank.NOT_YET_RANKED;

        for ( int i=0; i< handRank.humanFriendly.size(); i++) {
            rankingsText += handRank.humanFriendly.get(i) + "\n";
            payoutsText += handRank.payouts[i] + "\n";
        }

        leftTextView.setText(rankingsText);
        rightTextView.setText(payoutsText);


    }

}
