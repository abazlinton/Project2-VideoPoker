package com.example.user.videopoker;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

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
        handRanker.updateHandRanking();
        assertEquals(HandRank.NO_PAYOUT, testHand.getRank());
}

    @Test
    public void testPairJacks(){
        HandRanker handRanker = new HandRanker(testHand);
        testHand.addCard(jackClubs);
        testHand.addCard(jackClubs);
        testHand.addCard(queenClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(aceClubs);
        handRanker.updateHandRanking();
        assertEquals(HandRank.JACKS_OR_BETTER, testHand.getRank());
    }

    @Test
    public void testPairQueens(){
        HandRanker handRanker = new HandRanker(testHand);
        testHand.addCard(queenClubs);
        testHand.addCard(tenClubs);
        testHand.addCard(queenClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(aceClubs);
        handRanker.updateHandRanking();
        assertEquals(HandRank.JACKS_OR_BETTER, testHand.getRank());
    }

    @Test
    public void testTwoPairQQJJ(){
        HandRanker handRanker = new HandRanker(testHand);
        testHand.addCard(jackClubs);
        testHand.addCard(jackClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(queenClubs);
        testHand.addCard(queenClubs);
        handRanker.updateHandRanking();
        assertEquals(HandRank.TWO_PAIR, testHand.getRank());
    }

    @Test
    public void testThreeJacks(){
        HandRanker handRanker = new HandRanker(testHand);
        testHand.addCard(jackClubs);
        testHand.addCard(jackClubs);
        testHand.addCard(jackClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(aceClubs);
        handRanker.updateHandRanking();
        assertEquals(HandRank.THREE_OF_A_KIND, testHand.getRank());
    }

    @Test
    public void testJacksFullOfQueens(){
        HandRanker handRanker = new HandRanker(testHand);
        testHand.addCard(jackClubs);
        testHand.addCard(jackClubs);
        testHand.addCard(jackClubs);
        testHand.addCard(queenClubs);
        testHand.addCard(queenClubs);
        handRanker.updateHandRanking();
        assertEquals(HandRank.FULL_HOUSE, testHand.getRank());
    }

    @Test
    public void testFourTwos(){
        HandRanker handRanker = new HandRanker(testHand);
        testHand.addCard(twoClubs);
        testHand.addCard(twoClubs);
        testHand.addCard(twoClubs);
        testHand.addCard(twoClubs);
        testHand.addCard(aceClubs);
        handRanker.updateHandRanking();
        assertEquals(HandRank.FOUR_OF_A_KIND, testHand.getRank());
    }

    @Test
    public void testJunk(){
        HandRanker handRanker = new HandRanker(testHand);
        testHand.addCard(jackClubs);
        testHand.addCard(queenClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(aceClubs);
        testHand.addCard(twoClubs);
        handRanker.updateHandRanking();
        assertEquals(HandRank.NO_PAYOUT, testHand.getRank());
    }





}
