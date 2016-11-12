package com.example.user.videopoker;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class HandRankerTest {

    Hand testHand;
    Card jackHearts;
    Card jackClubs;
    Card queenClubs;
    Card kingClubs;
    Card aceClubs;
    Card tenClubs;
    Card twoClubs;
    Card threeHearts;
    Card fourDiamonds;
    Card fiveSpades;
    Card twoDiamonds;
    Card nineClubs;

    @Before
    public void before() {
        testHand = new Hand();
        jackHearts = new Card(Suit.HEARTS, Rank.JACK);
        queenClubs = new Card(Suit.CLUBS, Rank.QUEEN);
        kingClubs = new Card(Suit.CLUBS, Rank.KING);
        aceClubs = new Card(Suit.CLUBS, Rank.ACE);
        tenClubs = new Card(Suit.CLUBS, Rank.TEN);
        twoClubs = new Card(Suit.CLUBS, Rank.TWO);
        threeHearts = new Card(Suit.HEARTS, Rank.THREE);
        fourDiamonds = new Card(Suit.DIAMONDS, Rank.FOUR);
        fiveSpades = new Card(Suit.SPADES, Rank.FIVE);
        twoDiamonds = new Card(Suit.DIAMONDS, Rank.TWO);
        jackClubs = new Card(Suit.CLUBS, Rank.JACK);
        nineClubs = new Card(Suit.CLUBS, Rank.NINE);
    }

    @Test
    public void testPairTens() {
      
        testHand.addCard(tenClubs);
        testHand.addCard(tenClubs);
        testHand.addCard(queenClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(jackHearts);
        HandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.PAIR_LESS_THAN_JACKS, testHand.getRank());
}

    @Test
    public void testPairJacks(){
      
        testHand.addCard(jackHearts);
        testHand.addCard(jackHearts);
        testHand.addCard(queenClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(aceClubs);
        HandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.JACKS_OR_BETTER, testHand.getRank());
    }

    @Test
    public void testPairQueens(){
      
        testHand.addCard(queenClubs);
        testHand.addCard(tenClubs);
        testHand.addCard(queenClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(jackHearts);
        HandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.JACKS_OR_BETTER, testHand.getRank());
    }

    @Test
    public void testTwoPairQQJJ(){
      
        testHand.addCard(jackHearts);
        testHand.addCard(jackHearts);
        testHand.addCard(kingClubs);
        testHand.addCard(queenClubs);
        testHand.addCard(queenClubs);
        HandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.TWO_PAIR, testHand.getRank());
    }

    @Test
    public void testTwoPair22JJ(){
      
        testHand.addCard(twoClubs);
        testHand.addCard(twoClubs);
        testHand.addCard(jackHearts);
        testHand.addCard(queenClubs);
        testHand.addCard(queenClubs);
        HandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.TWO_PAIR, testHand.getRank());
    }

    @Test
    public void testThreeJacks(){
      
        testHand.addCard(jackHearts);
        testHand.addCard(jackHearts);
        testHand.addCard(jackHearts);
        testHand.addCard(kingClubs);
        testHand.addCard(aceClubs);
        HandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.THREE_OF_A_KIND, testHand.getRank());
    }

    @Test
    public void testJacksFullOfQueens(){
      
        testHand.addCard(jackHearts);
        testHand.addCard(jackHearts);
        testHand.addCard(jackHearts);
        testHand.addCard(queenClubs);
        testHand.addCard(queenClubs);
        HandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.FULL_HOUSE, testHand.getRank());
    }

    @Test
    public void testFourTwos(){
      
        testHand.addCard(twoClubs);
        testHand.addCard(twoClubs);
        testHand.addCard(twoClubs);
        testHand.addCard(twoClubs);
        testHand.addCard(jackHearts);
        HandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.FOUR_OF_A_KIND, testHand.getRank());
    }

    @Test
    public void testJunk(){
      
        testHand.addCard(fourDiamonds);
        testHand.addCard(queenClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(aceClubs);
        testHand.addCard(twoClubs);
        HandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.JUNK, testHand.getRank());
    }

    @Test
    public void testOffSuitStraight(){
      
        testHand.addCard(jackHearts);
        testHand.addCard(queenClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(aceClubs);
        testHand.addCard(tenClubs);
        HandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.STRAIGHT, testHand.getRank());
    }

    @Test
    public void testAceLowStraight(){
      
        testHand.addCard(aceClubs);
        testHand.addCard(twoClubs);
        testHand.addCard(threeHearts);
        testHand.addCard(fourDiamonds);
        testHand.addCard(fiveSpades);
        HandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.STRAIGHT, testHand.getRank());
    }

    @Test
    public void testStraightNotDetectedByMistake(){
      
        testHand.addCard(aceClubs);
        testHand.addCard(twoClubs);
        testHand.addCard(twoDiamonds);
        testHand.addCard(fourDiamonds);
        testHand.addCard(fiveSpades);
        HandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.PAIR_LESS_THAN_JACKS, testHand.getRank());

    }

    @Test
    public void testStandardFlush(){
      
        testHand.addCard(aceClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(queenClubs);
        testHand.addCard(twoClubs);
        testHand.addCard(tenClubs);
        HandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.FLUSH, testHand.getRank());
    }

    @Test
    public void testRoyalFlush(){
      
        testHand.addCard(aceClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(queenClubs);
        testHand.addCard(jackClubs);
        testHand.addCard(tenClubs);
        HandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.ROYAL_FLUSH, testHand.getRank());
    }

    @Test
    public void testStraightFlush(){
      
        testHand.addCard(nineClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(queenClubs);
        testHand.addCard(jackClubs);
        testHand.addCard(tenClubs);
        HandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.STRAIGHT_FLUSH, testHand.getRank());
    }

    @Test
    public void testCannotLoopStraight(){
      
        testHand.addCard(twoClubs);
        testHand.addCard(aceClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(queenClubs);
        testHand.addCard(jackHearts);
        HandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.JUNK, testHand.getRank());
    }






}
