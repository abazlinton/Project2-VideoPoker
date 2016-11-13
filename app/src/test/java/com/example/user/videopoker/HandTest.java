package com.example.user.videopoker;


import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;


public class HandTest {

    Hand testHand;
    Card queenHearts;
    Card fourDiamonds;
    Card queenClubs;
    Card kingClubs;
    Card aceClubs;
    Card twoClubs;
    Card threeClubs;
    Card fourClubs;
    HandRank handRank;


    @Before
    public void before() {
        handRank = HandRank.NOT_YET_RANKED;
        testHand = new Hand(handRank);
        queenHearts = new Card(Rank.QUEEN, Suit.HEARTS);

    }

    @Test
    public void canGetSize(){
        testHand.addCard(queenHearts);
        assertEquals(1, testHand.size());
    }

    @Test
    public void rankStartsAsNoPayout() {
        assertEquals(HandRank.NOT_YET_RANKED, testHand.getRank());
    }

    @Test
    public void canAddcard(){
       testHand.addCard(queenHearts);
       assertEquals(Rank.QUEEN, testHand.getCards().get(0).getRank());
    }





}
