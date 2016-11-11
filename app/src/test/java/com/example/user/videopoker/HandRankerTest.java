package com.example.user.videopoker;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 11/11/2016.
 */

public class HandRankerTest {

    Hand testHand;
    Card jackClubs;
    Card queenClubs;
    Card kingClubs;
    Card aceClubs;
    Card tenClubs;
    Card twoClubs;

    @Before
    public void before() {
        testHand = new Hand();
        jackClubs = new Card(Suit.CLUBS, Rank.JACK);
        queenClubs = new Card(Suit.CLUBS, Rank.QUEEN);
        kingClubs = new Card(Suit.CLUBS, Rank.KING);
        aceClubs = new Card(Suit.CLUBS, Rank.ACE);
        tenClubs = new Card(Suit.CLUBS, Rank.TEN);
        twoClubs = new Card(Suit.CLUBS, Rank.TWO);
    }

    @Test
    public void testPairTens() {
        HandRanker handRanker = new HandRanker(testHand);
        testHand.addCard(tenClubs);
        testHand.addCard(tenClubs);
        testHand.addCard(queenClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(aceClubs);
        assertEquals(HandRank.NO_PAYOUT, handRanker.checkForMultiples()
    );
}

    @Test
    public void testPairJacks(){
        HandRanker handRanker = new HandRanker(testHand);
        testHand.addCard(jackClubs);
        testHand.addCard(jackClubs);
        testHand.addCard(queenClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(aceClubs);
        assertEquals(HandRank.JACKS_OR_BETTER, handRanker.checkForMultiples());
    }

    @Test
    public void testPairQueens(){
        HandRanker handRanker = new HandRanker(testHand);
        testHand.addCard(queenClubs);
        testHand.addCard(tenClubs);
        testHand.addCard(queenClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(aceClubs);
        assertEquals(HandRank.JACKS_OR_BETTER, handRanker.checkForMultiples());
    }

    @Test
    public void testTwoPairQQJJ(){
        HandRanker handRanker = new HandRanker(testHand);
        testHand.addCard(jackClubs);
        testHand.addCard(jackClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(queenClubs);
        testHand.addCard(queenClubs);
        assertEquals(HandRank.TWO_PAIR, handRanker.checkForMultiples());
    }

    @Test
    public void testThreeJacks(){
        HandRanker handRanker = new HandRanker(testHand);
        testHand.addCard(jackClubs);
        testHand.addCard(jackClubs);
        testHand.addCard(jackClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(aceClubs);
        assertEquals(HandRank.THREE_OF_A_KIND, handRanker.checkForMultiples());
    }

    @Test
    public void testJacksFullOfQueens(){
        HandRanker handRanker = new HandRanker(testHand);
        testHand.addCard(jackClubs);
        testHand.addCard(jackClubs);
        testHand.addCard(jackClubs);
        testHand.addCard(queenClubs);
        testHand.addCard(queenClubs);
        assertEquals(HandRank.FULL_HOUSE, handRanker.checkForMultiples());
    }

    @Test
    public void testFourTwos(){
        HandRanker handRanker = new HandRanker(testHand);
        testHand.addCard(twoClubs);
        testHand.addCard(twoClubs);
        testHand.addCard(twoClubs);
        testHand.addCard(twoClubs);
        testHand.addCard(aceClubs);
        assertEquals(HandRank.FOUR_OF_A_KIND, handRanker.checkForMultiples());
    }

    @Test
    public void testJunk(){
        HandRanker handRanker = new HandRanker(testHand);
        testHand.addCard(jackClubs);
        testHand.addCard(queenClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(aceClubs);
        testHand.addCard(twoClubs);
        assertEquals(HandRank.NO_PAYOUT, handRanker.checkForMultiples());
    }





}
