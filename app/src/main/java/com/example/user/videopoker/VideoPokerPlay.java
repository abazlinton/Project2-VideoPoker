package com.example.user.videopoker;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user on 13/11/2016.
 */

public class VideoPokerPlay extends AppCompatActivity {

    ImageView mCard1;
    ImageView mCard2;
    ImageView mCard3;
    ImageView mCard4;
    ImageView mCard5;
    Game game;
    Player player;
    Deck deck;
    Button start;
    TextView mHandRank;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        player = new Player();
        deck = new Deck();
        game = new Game(player, deck, 5);

        mCard1 = (ImageView) findViewById(R.id.card1);
        mCard2 = (ImageView) findViewById(R.id.card2);
        mCard3 = (ImageView) findViewById(R.id.card3);
        mCard4 = (ImageView) findViewById(R.id.card4);
        mCard5 = (ImageView) findViewById(R.id.card5);

        mHandRank = (TextView) findViewById(R.id.hand_rank);

        start = (Button) findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start();

//                start.setVisibility(View.GONE);
            }
        });


        mCard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSelection(mCard1);
            }
        });

        mCard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSelection(mCard2);
            }
        });

        mCard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSelection(mCard3);
            }
        });

        mCard4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSelection(mCard4);
            }
        });

        mCard5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSelection(mCard5);
            }
        });
    }

    protected void toggleSelection(ImageView card){
        int currentPadding = card.getPaddingLeft();
        if (currentPadding == 0){
            card.setPadding(2,2,2,2);
            card.setBackgroundColor(Color.BLUE);
        }
        else {
            card.setPadding(0,0,0,0);
            card.setBackgroundColor(Color.WHITE);
        }
    }

    protected void start(){
        game.startNewRound();
        game.processSpinOne();
        String drawableName = game.getPlayer().getHand().getCards().get(0).toFileString();
        int drawableResourceId = this.getResources().getIdentifier(drawableName, "drawable", this.getPackageName());
        mCard1.setImageResource(drawableResourceId);
        drawableName = game.getPlayer().getHand().getCards().get(1).toFileString();
        drawableResourceId = this.getResources().getIdentifier(drawableName, "drawable", this.getPackageName());
        mCard2.setImageResource(drawableResourceId);
        drawableName = game.getPlayer().getHand().getCards().get(2).toFileString();
        drawableResourceId = this.getResources().getIdentifier(drawableName, "drawable", this.getPackageName());
        mCard3.setImageResource(drawableResourceId);
        drawableName = game.getPlayer().getHand().getCards().get(3).toFileString();
        drawableResourceId = this.getResources().getIdentifier(drawableName, "drawable", this.getPackageName());
        mCard4.setImageResource(drawableResourceId);
        drawableName = game.getPlayer().getHand().getCards().get(4).toFileString();
        drawableResourceId = this.getResources().getIdentifier(drawableName, "drawable", this.getPackageName());
        mCard5.setImageResource(drawableResourceId);
        mHandRank.setText(player.getHand().getRank().toString());
    }





}
