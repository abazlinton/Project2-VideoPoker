package com.example.user.videopoker;

import org.junit.Before;
import org.junit.Test;

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


}
