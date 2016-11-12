package com.example.user.videopoker;

import java.util.HashMap;

/**
 * Created by user on 12/11/2016.
 */

public class Player {

    private Hand hand;
    protected int credit;
    protected HashMap<Integer, Boolean> holds;

    public Player(){
        this.setCredit(500);
        this.holds = new HashMap<Integer, Boolean>();
        resetHolds();
    }

    public void resetHolds(){
        for (int i=0; i < 5; i++){
            this.holds.put(i, false);
        }
    }

    public Hand getHand(){
        return hand;
    }

    public void toggleHold(int slot){
        boolean flippedHoldStatus = !holds.get(slot);
        holds.put(slot, flippedHoldStatus);
    }

    public HashMap<Integer, Boolean> getHolds() {
        return holds;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public int getCredit() {
        return credit;
    }

    public int getHoldCount(){
        int holdCount = 0;
        for (int i=0; i < holds.size(); i++){
            if (holds.get(i) == true) {
                holdCount++;
            }
        }
        return holdCount;
    }

    public void setCredit(int newCredit){
        this.credit = newCredit;
    }

    public void increaseCredit(int change){
        int newCredit = getCredit() + change;
        setCredit(newCredit);
    }

    public void decreaseCredit(int change){
        increaseCredit(change * -1);
    }
}
