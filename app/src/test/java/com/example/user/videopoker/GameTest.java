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
        System.out.println(player.getCredit());
        game.processSpinOne();
        String handString = " Dealt ";
        for (Card card: player.getHand().getCards()){
            handString += card.toString() + " ";
        }
        System.out.println(handString);
        System.out.println(player.getHand().getRank().toString());
        player.toggleHold(1);
        game.doSpinTwo();
        game.processSpinTwo();
        handString = " Final ";
        for (Card card: player.getHand().getCards()){
            handString += card.toString() + " ";
        }
        System.out.println(handString);
        System.out.println(player.getHand().getRank().toString());
        System.out.println(player.getHand().getRank().getPayout());
        System.out.println(player.getCredit());
    }


    @Test
    public void playerIsPaidOut(){
        game.startNewRound();
        Card tenHearts = new Card(Rank.TEN, Suit.HEARTS);
        Card jackHearts = new Card(Rank.JACK, Suit.HEARTS);
        Card queenHearts = new Card(Rank.QUEEN, Suit.HEARTS);
        Card kingHearts = new Card(Rank.KING, Suit.HEARTS);
        Card aceHearts = new Card(Rank.ACE, Suit.HEARTS);
        Hand hand = new Hand(HandRank.NOT_YET_RANKED);
        hand.addCard(tenHearts);
        hand.addCard(jackHearts);
        hand.addCard(queenHearts);
        hand.addCard(kingHearts);
        hand.addCard(aceHearts);
        player.setHand(hand);
        game.processSpinTwo();
        assertEquals(4495, player.getCredit());

    }




}


