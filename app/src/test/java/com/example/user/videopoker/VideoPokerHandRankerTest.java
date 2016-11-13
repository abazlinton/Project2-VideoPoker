package com.example.user.videopoker;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class VideoPokerHandRankerTest {

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
    HandRank handRank;

    @Before
    public void before() {
        handRank = HandRank.NOT_YET_RANKED;
        testHand = new Hand(handRank);
        jackHearts = new Card(Rank.JACK, Suit.HEARTS);
        queenClubs = new Card(Rank.QUEEN, Suit.CLUBS);
        kingClubs = new Card(Rank.KING, Suit.CLUBS);
        aceClubs = new Card(Rank.ACE, Suit.CLUBS);
        tenClubs = new Card(Rank.TEN, Suit.CLUBS);
        twoClubs = new Card(Rank.TWO, Suit.CLUBS);
        threeHearts = new Card(Rank.THREE, Suit.HEARTS);
        fourDiamonds = new Card(Rank.FOUR, Suit.DIAMONDS);
        fiveSpades = new Card(Rank.FIVE, Suit.SPADES);
        twoDiamonds = new Card(Rank.TWO, Suit.DIAMONDS);
        jackClubs = new Card(Rank.JACK, Suit.CLUBS);
        nineClubs = new Card(Rank.NINE, Suit.CLUBS);
    }

    @Test
    public void testPairTens() {
      
        testHand.addCard(tenClubs);
        testHand.addCard(tenClubs);
        testHand.addCard(queenClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(jackHearts);
        VideoPokerHandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.PAIR_LESS_THAN_JACKS, testHand.getRank());
}

    @Test
    public void testPairJacks(){
      
        testHand.addCard(jackHearts);
        testHand.addCard(jackHearts);
        testHand.addCard(queenClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(aceClubs);
        VideoPokerHandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.JACKS_OR_BETTER, testHand.getRank());
    }

    @Test
    public void testPairQueens(){
      
        testHand.addCard(queenClubs);
        testHand.addCard(tenClubs);
        testHand.addCard(queenClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(jackHearts);
        VideoPokerHandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.JACKS_OR_BETTER, testHand.getRank());
    }

    @Test
    public void testTwoPairQQJJ(){
      
        testHand.addCard(jackHearts);
        testHand.addCard(jackHearts);
        testHand.addCard(kingClubs);
        testHand.addCard(queenClubs);
        testHand.addCard(queenClubs);
        VideoPokerHandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.TWO_PAIR, testHand.getRank());
    }

    @Test
    public void testTwoPair22JJ(){
      
        testHand.addCard(twoClubs);
        testHand.addCard(twoClubs);
        testHand.addCard(jackHearts);
        testHand.addCard(queenClubs);
        testHand.addCard(queenClubs);
        VideoPokerHandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.TWO_PAIR, testHand.getRank());
    }

    @Test
    public void testThreeJacks(){
      
        testHand.addCard(jackHearts);
        testHand.addCard(jackHearts);
        testHand.addCard(jackHearts);
        testHand.addCard(kingClubs);
        testHand.addCard(aceClubs);
        VideoPokerHandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.THREE_OF_A_KIND, testHand.getRank());
    }

    @Test
    public void testJacksFullOfQueens(){
      
        testHand.addCard(jackHearts);
        testHand.addCard(jackHearts);
        testHand.addCard(jackHearts);
        testHand.addCard(queenClubs);
        testHand.addCard(queenClubs);
        VideoPokerHandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.FULL_HOUSE, testHand.getRank());
    }

    @Test
    public void testFourTwos(){
      
        testHand.addCard(twoClubs);
        testHand.addCard(twoClubs);
        testHand.addCard(twoClubs);
        testHand.addCard(twoClubs);
        testHand.addCard(jackHearts);
        VideoPokerHandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.FOUR_OF_A_KIND, testHand.getRank());
    }

    @Test
    public void testJunk(){
      
        testHand.addCard(fourDiamonds);
        testHand.addCard(queenClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(aceClubs);
        testHand.addCard(twoClubs);
        VideoPokerHandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.JUNK, testHand.getRank());
    }

    @Test
    public void testOffSuitStraight(){
      
        testHand.addCard(jackHearts);
        testHand.addCard(queenClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(aceClubs);
        testHand.addCard(tenClubs);
        VideoPokerHandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.STRAIGHT, testHand.getRank());
    }

    @Test
    public void testAceLowStraight(){
      
        testHand.addCard(aceClubs);
        testHand.addCard(twoClubs);
        testHand.addCard(threeHearts);
        testHand.addCard(fourDiamonds);
        testHand.addCard(fiveSpades);
        VideoPokerHandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.STRAIGHT, testHand.getRank());
    }

    @Test
    public void testStraightNotDetectedByMistake(){
      
        testHand.addCard(aceClubs);
        testHand.addCard(twoClubs);
        testHand.addCard(twoDiamonds);
        testHand.addCard(fourDiamonds);
        testHand.addCard(fiveSpades);
        VideoPokerHandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.PAIR_LESS_THAN_JACKS, testHand.getRank());

    }

    @Test
    public void testStandardFlush(){
      
        testHand.addCard(aceClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(queenClubs);
        testHand.addCard(twoClubs);
        testHand.addCard(tenClubs);
        VideoPokerHandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.FLUSH, testHand.getRank());
    }

    @Test
    public void testRoyalFlush(){
      
        testHand.addCard(aceClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(queenClubs);
        testHand.addCard(jackClubs);
        testHand.addCard(tenClubs);
        VideoPokerHandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.ROYAL_FLUSH, testHand.getRank());
    }

    @Test
    public void testStraightFlush(){
      
        testHand.addCard(nineClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(queenClubs);
        testHand.addCard(jackClubs);
        testHand.addCard(tenClubs);
        VideoPokerHandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.STRAIGHT_FLUSH, testHand.getRank());
    }

    @Test
    public void testCannotLoopStraight(){
      
        testHand.addCard(twoClubs);
        testHand.addCard(aceClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(queenClubs);
        testHand.addCard(jackHearts);
        VideoPokerHandRanker.updateHandRanking(testHand);
        assertEquals(HandRank.JUNK, testHand.getRank());
    }






}
