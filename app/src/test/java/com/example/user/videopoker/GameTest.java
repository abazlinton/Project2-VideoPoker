package com.example.user.videopoker;

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
        game = new Game(player, deck);

    }

    @Test public void canStartNewGame(){
        assertEquals(500, game.getPlayer().getCredit());
        assertEquals(5, game.getPlayer().getHandSize());
    }


}


