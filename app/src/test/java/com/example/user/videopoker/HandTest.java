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

    @Before
    public void before() {
        testHand = new Hand();
        queenHearts = new Card(Suit.HEARTS, Rank.QUEEN);

    }

    @Test
    public void rankStartsAsNoPayout() {
        assertEquals(HandRank.NOT_STARTED, testHand.getRank());
    }

    @Test
    public void canAddcard(){
       testHand.addCard(queenHearts);
       assertEquals(Rank.QUEEN, testHand.getCards().get(0).getRank());
    }

    @Test
    public void testToString(){
        testHand.addCard(fourDiamonds);
        testHand.addCard(queenClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(aceClubs);
        testHand.addCard(twoClubs);
        assertEquals("Ac Kc Qc 4d 2c", testHand.toString());

    }



}
