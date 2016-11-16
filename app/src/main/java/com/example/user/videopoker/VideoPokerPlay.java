package com.example.user.videopoker;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TimingLogger;
import android.view.View;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by user on 13/11/2016.
 */

public class VideoPokerPlay extends AppCompatActivity {

//    ArrayList<ImageView> mCards;
    ImageView mCard1;
    ImageView mCard2;
    ImageView mCard3;
    ImageView mCard4;
    ImageView mCard5;
    Game game;
    Player player;
    Deck deck;
    Button deal, view_log;
    Button draw;
    TextView mHandRank;
    TimingLogger timings;
    enum Spin {DEAL, DRAW};
    Spin mSpin;
    TextView credit;
    TextView game_over;
    Animation pulse;
    GameLog gameLog;
    String dealString, finalHandString;
    int winnings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        gameLog = new GameLog();
        //gameLog.addToDb(this);
        player = new Player();
        deck = new Deck();
        game = new Game(player, deck, 5);
//        game.startNewRound();

        mCard1 = (ImageView) findViewById(R.id.card1);
        mCard2 = (ImageView) findViewById(R.id.card2);
        mCard3 = (ImageView) findViewById(R.id.card3);
        mCard4 = (ImageView) findViewById(R.id.card4);
        mCard5 = (ImageView) findViewById(R.id.card5);

        credit = (TextView) findViewById(R.id.credit);
        game_over = (TextView) findViewById(R.id.game_over);

        pulse = AnimationUtils.loadAnimation(this, R.anim.pulse);


//        mCards.add(mCard1);
//        mCards.add(mCard2);
//        mCards.add(mCard3);
//        mCards.add(mCard4);
//        mCards.add(mCard5);


        mHandRank = (TextView) findViewById(R.id.hand_rank);

        deal = (Button) findViewById(R.id.deal);

        deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deal();

//                start.setVisibility(View.GONE);
            }
        });



        draw = (Button) findViewById(R.id.draw);

        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                draw();

//                draw.setVisibility(View.GONE);
            }
        });

//
//        for (int i=0; i < 5 ; i++) {
//            final int j=i;
//            mCards.get(j).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    toggleSelection(mCards.get(j));
//                }
//            });
//        }

        mCard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSelection(mCard1, 0);
            }
        });

        mCard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSelection(mCard2, 1);
            }
        });

        mCard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSelection(mCard3, 2);
            }
        });

        mCard4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSelection(mCard4, 3);
            }
        });

        mCard5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSelection(mCard5, 4);
            }
        });

        view_log = (Button) findViewById(R.id.view_log);

        view_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VideoPokerPlay.this, LogActivity.class);
                startActivity(intent);

            }
        });

        deal.performClick();
    }


    protected void toggleSelection(ImageView card, int cardInt){
        if (mSpin == Spin.DEAL) {
            player.toggleHold(cardInt);

            int currentPadding = card.getPaddingLeft();
            if (currentPadding == 0) {
                card.setPadding(2, 2, 2, 2);
                card.setBackgroundColor(Color.BLUE);
            } else {
                card.setPadding(0, 0, 0, 0);
                card.setBackgroundColor(Color.WHITE);
            }
        }

    }

    protected void drawCards(){

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
    }




    protected void deal(){
        mSpin = Spin.DEAL;
        clearSelection();
        game.startNewRound();
        credit.setText(Integer.toString(player.getCredit()));
        game_over.setVisibility(View.INVISIBLE);
        view_log.setVisibility(View.INVISIBLE);
        drawCards();
        game.processSpinOne();
        HandRank tempHandRank = player.getHand().getRank();
        mHandRank.setText(tempHandRank.humanFriendly.get(tempHandRank.ordinal()));
        deal.setVisibility(View.INVISIBLE);
        draw.setVisibility(View.VISIBLE);
        dealString = player.getHand().toString();
        ;

    }

    protected void draw(){
        mSpin = Spin.DRAW;
        game.doSpinTwo();
        drawCards();
        int beforeCredit = player.getCredit();
        game.processSpinTwo();
        int afterCredit = player.getCredit();
//        credit.setText(Integer.toString(player.getCredit()));
        startCreditAnimation(beforeCredit, afterCredit, 2000);
        credit.startAnimation(pulse);
        game_over.startAnimation(pulse);
        game_over.setVisibility(View.VISIBLE);
        HandRank tempHandRank = player.getHand().getRank();
        String handRankString = tempHandRank.humanFriendly.get(tempHandRank.ordinal());
        game_over.setText(handRankString);
        deal.setVisibility(View.VISIBLE);
        draw.setVisibility(View.INVISIBLE);
        view_log.setVisibility(View.VISIBLE);
        finalHandString = player.getHand().toString();
        winnings = player.getHand().getRank().getPayout();
        gameLog.addToDb(this, dealString, finalHandString, (winnings - 5), handRankString );
    }

    protected void clearSelection(){

        mCard1.setPadding(0,0,0,0);
        mCard1.setBackgroundColor(Color.WHITE);
        mCard2.setPadding(0,0,0,0);
        mCard2.setBackgroundColor(Color.WHITE);
        mCard3.setPadding(0,0,0,0);
        mCard3.setBackgroundColor(Color.WHITE);
        mCard4.setPadding(0,0,0,0);
        mCard4.setBackgroundColor(Color.WHITE);
        mCard5.setPadding(0,0,0,0);
        mCard5.setBackgroundColor(Color.WHITE);

    }

    private void startCreditAnimation(int start, int stop, int duration) {
        ValueAnimator animator = new ValueAnimator();
        animator.setObjectValues(start, stop);
        animator.setDuration(duration);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                TextView creditText = (TextView) findViewById(R.id.credit);
                creditText.setText("" + (int) animation.getAnimatedValue());
            }
        });
        animator.start();
    }



}
