package com.example.user.videopoker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class HandRanker {

    Hand hand;
    ArrayList<Integer> countsAllCards;
    boolean jacksOrBetterPossible;


    public HandRanker(Hand hand){
        this.hand = hand;
        this.countsAllCards = new ArrayList<Integer>();
        this.jacksOrBetterPossible = false;
    }

    public void updateHandRanking(){
        checkForMultiples();
    }

    public void checkForMultiples() {

        for (int i = 0; i < 13; i++) {
            countsAllCards.add(0);
        }

        HashMap<String, Integer> countsInHand = new HashMap<>();

        for (Card card : hand.getCards()) {
            int currentCount = 1;
            String key = card.getRank().toString();
            int index = card.getRank().ordinal();
            if (countsInHand.containsKey(key)) {
                currentCount = countsInHand.get(key);
                int newCount = currentCount + 1;
                countsInHand.put(key, newCount);
                countsAllCards.set(index, newCount);
            } else {
                countsInHand.put(key, currentCount);
                countsAllCards.set(index, currentCount);
            }
        }

        calculateIfjacksOrBetterPossible();

        Collections.sort(countsAllCards);
        Collections.reverse(countsAllCards);

        if (countsAllCards.get(0) == 1) {
            hand.setRank(HandRank.NO_PAYOUT);
        }
        else if (countsAllCards.get(0) == 4) {
            hand.setRank(HandRank.FOUR_OF_A_KIND);
        }
        else if (countsAllCards.get(0) == 3){
            if (countsAllCards.get(1) == 2) {
                hand.setRank(HandRank.FULL_HOUSE);
            }
            else {
                hand.setRank(HandRank.THREE_OF_A_KIND);
            }
        }
        else if (countsAllCards.get(0) == 2){
            if (countsAllCards.get(1) == 2) {
                hand.setRank(HandRank.TWO_PAIR);
            }
            else if (jacksOrBetterPossible) {
                hand.setRank(HandRank.JACKS_OR_BETTER);
            }
            else {
                hand.setRank(HandRank.NO_PAYOUT);
            }
        }
    }

    private void calculateIfjacksOrBetterPossible(){
        for (int i = 9; i < 13; i++) {
            if (countsAllCards.get(i) == 2) {
                jacksOrBetterPossible = true;
            }
        }
    }



}
