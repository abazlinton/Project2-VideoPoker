package com.example.user.videopoker;

import android.util.Log;

import java.util.ArrayList;


public class Game {

    private Player player;
    private Deck deck;
    private int roundCount;
    private int sizeOfStartingHand;



    public Game(Player player, Deck deck, int sizeOfStartingHand){
        this.player = player;
        this.deck = deck;
        roundCount = 0;
        this.sizeOfStartingHand = sizeOfStartingHand;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Deck getDeck() {
        return deck;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public void startNewRound(){
        roundCount++;
        HandRank handRank = HandRank.NOT_YET_RANKED;
        Hand hand = new Hand(handRank);
        deck.resetWithShuffle();
        ArrayList cards = deck.deal(sizeOfStartingHand);
        hand.addCards(cards);
        player.setHand(hand);
        player.resetHolds();
        player.decreaseCredit(5);
    }

//    public void actOnHolds(){
//        if (player.getHoldCount() == 5){
//            processPayout();
//        }
//    }


    public void processSpinOne(){
        VideoPokerHandRanker.updateHandRanking(player.getHand());

    }

    public void doSpinTwo(){
        int cardsRequired = player.cardsReqToRefillTo(5);
        ArrayList<Card> newCards = deck.deal(cardsRequired);
        player.addNewCards(newCards);

    }
    public void processSpinTwo(){
        VideoPokerHandRanker.updateHandRanking(player.getHand());
        player.increaseCredit(player.getHand().getRank().getPayout());

    }

}
