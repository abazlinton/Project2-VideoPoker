package com.example.user.videopoker;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 11/11/2016.
 */

public class HandRankerTest {

    Hand testHand;
    Card card1;
    Card card2;
    Card card3;
    Card card4;
    Card card5;

    @Before
    public void before(){
        testHand = new Hand();
        card1 = new Card(Suit.CLUBS, Rank.EIGHT);
        card2 = new Card(Suit.HEARTS, Rank.EIGHT);
        card3 = new Card(Suit.CLUBS, Rank.NINE);
        card4 = new Card(Suit.CLUBS, Rank.TWO);
        card5 = new Card(Suit.CLUBS, Rank.THREE);

        testHand.addCard(card1);
        testHand.addCard(card2);
        testHand.addCard(card3);
        testHand.addCard(card4);
        testHand.addCard(card5);
    }

    //Todo: Remove
    @Test
    public void dummyTestReturnsFlush(){
        assertEquals(HandRank.FLUSH, HandRanker.rank(testHand));
    }



}
