package com.example.user.videopoker;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 12/11/2016.
 */

public class Player {

    private Hand hand;
    private int credit;
    private HashMap<Integer, Boolean> holds;

    public Player() {
        this.setCredit(0);
        this.holds = new HashMap<Integer, Boolean>();
    }

    public void resetHolds() {
        for (int i = 0; i < getHandSize(); i++) {
            this.holds.put(i, false);
        }
    }

    public Hand getHand() {
        return hand;
    }

    public void toggleHold(int slot) {
        boolean flippedHoldStatus = !holds.get(slot);
        holds.put(slot, flippedHoldStatus);
    }

    public HashMap<Integer, Boolean> getHolds() {
        return holds;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
        resetHolds();
    }

    public int getCredit() {
        return credit;
    }

    public int getHandSize() {
        return hand.getCards().size();
    }

    public int getHoldCount() {
        int holdCount = 0;
        for (int i = 0; i < holds.size(); i++) {
            if (holds.get(i) == true) {
                holdCount++;
            }
        }
        return holdCount;
    }

    public void setCredit(int newCredit) {
        this.credit = newCredit;
    }

    public void increaseCredit(int change) {
        int newCredit = getCredit() + change;
        setCredit(newCredit);
    }

    public void decreaseCredit(int change) {
        increaseCredit(change * -1);
    }

    public int cardsReqToRefillTo(int goal) {
        return goal - getHoldCount();
    }

    public void addNewCards(ArrayList<Card> newCards) {

        for (int holdsKey=0; holdsKey < getHandSize(); holdsKey++) {
            if (holds.get(holdsKey) == false) {
                hand.setCardAtIndexTo(holdsKey, newCards.remove(0));
            }
        }
    }
}
