package com.example.user.videopoker;


import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;


public class HandTest {

    Hand testHand;
    Card queenHearts;

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




}
