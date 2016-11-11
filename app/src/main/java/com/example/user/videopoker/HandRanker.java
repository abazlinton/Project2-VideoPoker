package com.example.user.videopoker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class HandRanker {

    Hand hand;

    public HandRanker(Hand hand){
        this.hand = hand;
    }


    public HandRank checkForMultiples() {

        ArrayList<Integer> counts = new ArrayList<Integer>();
        for (int i = 0; i < 13; i++) {
            counts.add(0);
        }

        HashMap<String, Integer> cardCounts = new HashMap<>();

        for (Card card : hand.getCards()) {
            int currentCount = 1;
            String key = card.getRank().toString();
            int index = card.getRank().ordinal();
            if (cardCounts.containsKey(key)) {
                currentCount = cardCounts.get(key);
                int newCount = currentCount + 1;
                cardCounts.put(key, newCount);
                counts.set(index, newCount);
            } else {
                cardCounts.put(key, currentCount);
                counts.set(index, currentCount);
            }
        }

        boolean jacksOrBetterPair = false;
        ArrayList<Integer> jacksOrBetter = new ArrayList<Integer>(counts);
        for (int i = 9; i < 13; i++) {
            if (jacksOrBetter.get(i) == 2) {
                jacksOrBetterPair = true;
            }
        }

        Collections.sort(counts);
        Collections.reverse(counts);

        if (counts.get(0) == 1) {
            return HandRank.NO_PAYOUT;
        }
        else if (counts.get(0) == 4) {
            return HandRank.FOUR_OF_A_KIND;
        }
        else if (counts.get(0) == 3){
            if (counts.get(1) == 2) {
                return HandRank.FULL_HOUSE;
            }
            else {
                return HandRank.THREE_OF_A_KIND;
            }
        }
        else if (counts.get(0) == 2){
            if (counts.get(1) == 2) {
                return HandRank.TWO_PAIR;
            }
            else if (jacksOrBetterPair == true) {
                return HandRank.JACKS_OR_BETTER;
            }
            else {
                return HandRank.NO_PAYOUT;
            }
        }
        return null;
    }


}
