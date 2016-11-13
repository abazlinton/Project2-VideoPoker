package com.example.user.videopoker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class VideoPokerHandRanker {

    private static Hand handPassed;
    private static ArrayList<Integer> countsAllCards;
    private static boolean jacksOrBetterPossible;
    private static boolean cardsFormStraight;
    private static boolean cardsFormFlush;

    public static void updateHandRanking(Hand hand){

        handPassed = hand;

        countsAllCards = new ArrayList<Integer>();
        jacksOrBetterPossible = false;
        cardsFormStraight = false;
        cardsFormFlush = false;

        updateHandRankingMutiples();
        updateHandRankingStraightAndFlush();
        updateHandRankingNoPayoutHand();

    }

    private static void updateHandRankingMutiples() {

        for (int i = 0; i < 13; i++) {
            countsAllCards.add(0);
        }

        HashMap<String, Integer> countsInHand = new HashMap<>();

        for (Card card : handPassed.getCards()) {
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
            handPassed.setRank(HandRank.IN_PROGRESS);
        }
        else if (countsAllCards.get(0) == 4) {
            handPassed.setRank(HandRank.FOUR_OF_A_KIND);
        }
        else if (countsAllCards.get(0) == 3){
            if (countsAllCards.get(1) == 2) {
                handPassed.setRank(HandRank.FULL_HOUSE);
            }
            else {
                handPassed.setRank(HandRank.THREE_OF_A_KIND);
            }
        }
        else if (countsAllCards.get(0) == 2){
            if (countsAllCards.get(1) == 2) {
                handPassed.setRank(HandRank.TWO_PAIR);
            }
            else if (jacksOrBetterPossible) {
                handPassed.setRank(HandRank.JACKS_OR_BETTER);
            }
            else {
                handPassed.setRank(HandRank.PAIR_LESS_THAN_JACKS);
            }
        }
    }

    private static void updateHandRankingStraightAndFlush(){
        if (handPassed.getRank() == HandRank.IN_PROGRESS){
            checkForStraightWhenNoMultiplesFound();
            checkForFlush();
        }

        if (cardsFormFlush && cardsFormStraight && handPassed.containsAce()) {
            handPassed.setRank(HandRank.ROYAL_FLUSH);
        }
        if (cardsFormFlush && cardsFormStraight && !handPassed.containsAce()) {
            handPassed.setRank(HandRank.STRAIGHT_FLUSH);
        }
        if (cardsFormStraight && !cardsFormFlush) {
            handPassed.setRank(HandRank.STRAIGHT);
        }
        if (!cardsFormStraight && cardsFormFlush) {
            handPassed.setRank(HandRank.FLUSH);
        }

    }

    private static void updateHandRankingNoPayoutHand(){
        if (handPassed.getRank() == HandRank.IN_PROGRESS){
            handPassed.setRank(HandRank.JUNK);
        }
    }

    private static void calculateIfjacksOrBetterPossible(){
        for (int i = 9; i < 13; i++) {
            if (countsAllCards.get(i) == 2) {
                jacksOrBetterPossible = true;
            }
        }
    }

    //Todo - average make this more robust - middle value == average / halfway
    private static void checkForStraightWhenNoMultiplesFound(){
        // This works because we already know we have no more than one of each card
        // If we had A2235 this check would detect a straight

        ArrayList<Integer> collectRanks = new ArrayList<Integer>();

        for (Card card : handPassed.getCards()) {
            collectRanks.add(getIntValueOfCard(card));
        }
        Collections.sort(collectRanks);
        int lowCard = collectRanks.get(0);
        int highCard = collectRanks.get(4);
        if (highCard - lowCard == 4) {
            cardsFormStraight = true;
        }
    }

    private static void checkForFlush(){
        ArrayList<Integer> suitCount = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++){
            suitCount.add(0);
        }
        for (Card card : handPassed.getCards()) {
            int index = card.getSuit().ordinal();
            int currentCount = suitCount.get(index);
            currentCount++;
            suitCount.set(index, currentCount);
        }
        Collections.sort(suitCount);
        Collections.reverse(suitCount);
        if (suitCount.get(0) == 5){
            cardsFormFlush = true;
        }
    }

    private static int getIntValueOfCard(Card card){
        if (card.getRank() == Rank.ACE && handPassed.containsTwo()) {
            return -1;
        }
        else return card.getRank().ordinal();
    }
}
