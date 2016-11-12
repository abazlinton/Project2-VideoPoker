package com.example.user.videopoker;

/**
 * Created by user on 12/11/2016.
 */

public class Player {

    private Hand hand;
    protected int credit;

    public Player(){
        this.credit = 500;
    }

    public Hand getHand(){
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public int getCredit() {
        return credit;
    }
}
