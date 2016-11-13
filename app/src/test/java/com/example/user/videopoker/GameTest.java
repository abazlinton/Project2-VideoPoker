package com.example.user.videopoker;

import android.util.Log;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 13/11/2016.
 */

public class GameTest {

    Game game;
    Player player;
    Deck deck;
    Hand hand;
    HandRank handRank;

    @Before
    public void before(){
        deck = new Deck();
        player = new Player();
        game = new Game(player, deck, 5);

    }

    @Test
    public void canStartNewGame(){
        assertEquals(0, game.getRoundCount());
        assertEquals(500, game.getPlayer().getCredit());
//        assertEquals(0, game.getPlayer().getHandSize());
    }

    @Test
    public void canStartNewRound(){
        game.startNewRound();
        assertEquals(1, game.getRoundCount());
        assertEquals(47, game.getDeck().size());
        assertEquals(5, game.getPlayer().getHandSize());
        assertEquals(0, game.getPlayer().getHoldCount());
    }

    @Test
    public void canProcessFirstSpin(){
        game.startNewRound();
        game.processSpinOne();
        boolean handRanked = (player.getHand().getRank() != HandRank.IN_PROGRESS);
        assertEquals(true, handRanked);
        handRanked = (player.getHand().getRank() != HandRank.NOT_YET_RANKED);
        assertEquals(true, handRanked);
        assertEquals(495, game.getPlayer().getCredit());
    }

    @Test
    public void canFinalizeRound(){
        game.startNewRound();
        game.processSpinOne();
//        String handString = " Dealt ";
//        for (Card card: player.getHand().getCards()){
//            handString += card.toString() + " ";
//        }
//        System.out.println(handString);
//        System.out.println(player.getHand().getRank().toString());
//        player.toggleHold(1);
//        player.toggleHold(2);
        game.doSpinTwo();
        game.processSpinTwo();
        String handString = " Final ";
        for (Card card: player.getHand().getCards()){
            handString += card.toString() + " ";
        }
        System.out.println(handString);
        System.out.println(player.getHand().getRank().toString());
        System.out.println(player.getHand().getRank().getPayout());
    }


    @Test
    public void payoutCorrrect(){

    }




}


