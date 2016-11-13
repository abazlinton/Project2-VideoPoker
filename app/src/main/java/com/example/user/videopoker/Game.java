package com.example.user.videopoker;

import java.util.ArrayList;

/**
 * Created by user on 13/11/2016.
 *
 * GAME

 prepare deck
 get random hand
 give hand to player
 calculate hand
 process holds
 give new cards if holds < 5
 calculate hand
 calculate payout
 payout
 REPEAT

 */

public class Game {

    Player player;
    Deck deck;


    public Game(Player player, Deck deck){
        this.player = player;
        this.deck = deck;
        player.setCredit(500);
        HandRank handRank = HandRank.NOT_YET_RANKED;
        Hand hand = new Hand(handRank);
        ArrayList cards = deck.deal(5);
        hand.addCards(cards);
        player.setHand(hand);
        player.addNewCards(cards);
    }

    public Player getPlayer() {
        return this.player;
    }



}
