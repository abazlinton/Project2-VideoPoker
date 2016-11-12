package com.example.user.videopoker;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 12/11/2016.
 */

public class PlayerTest {

    Player player;
    Hand testHand;
    Card jackClubs;
    Card queenClubs;
    Card kingClubs;
    Card tenClubs;
    Card nineClubs;

    @Before
    public void before(){
        player = new Player();
        testHand = new Hand();
        testHand.addCard(nineClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(queenClubs);
        testHand.addCard(jackClubs);
        testHand.addCard(tenClubs);
    }

    @Test
    public void testPlayerStartsWith500Credit(){
        assertEquals(500, player.getCredit());
    }

    @Test
    public void playerCanTakeHand(){
        player.setHand(testHand);
        assertEquals(5, player.getHand().size());
    }

    @Test
    public void playerCanToggleHOLD(){
        player.toggleHold(1);
        player.toggleHold(3);
        player.toggleHold(1);
        assertEquals(false, player.getHolds().get(1).booleanValue());
        assertEquals(true, player.getHolds().get(3).booleanValue());
    }

    @Test
    public void playerHasNoHoldsAtStart(){
        assertEquals(false, player.getHolds().get(0).booleanValue());
        assertEquals(false, player.getHolds().get(1).booleanValue());
        assertEquals(false, player.getHolds().get(2).booleanValue());
        assertEquals(false, player.getHolds().get(3).booleanValue());
        assertEquals(false, player.getHolds().get(4).booleanValue());
    }

    @Test
    public void canGetCountOfHolds(){
        player.toggleHold(1);
        player.toggleHold(3);
        assertEquals(2, player.getHoldCount());
    }

    @Test
    public void canIncreaseCredit(){
        player.increaseCredit(10);
        assertEquals(510, player.getCredit());
    }

    @Test
    public void canDecreaseCredit(){
        player.decreaseCredit(10);
        assertEquals(490, player.getCredit());
    }

    @Test
    public void playerHoldsCanBeReset(){
        player.toggleHold(1);
        player.toggleHold(3);
        player.resetHolds();
        assertEquals(false, player.getHolds().get(0).booleanValue());
        assertEquals(false, player.getHolds().get(1).booleanValue());
        assertEquals(false, player.getHolds().get(2).booleanValue());
        assertEquals(false, player.getHolds().get(3).booleanValue());
        assertEquals(false, player.getHolds().get(4).booleanValue());
    }



}
