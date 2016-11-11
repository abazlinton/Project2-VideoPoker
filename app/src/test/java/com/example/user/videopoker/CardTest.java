package com.example.user.videopoker;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;


public class CardTest {

    Card card;

    @Before
    public void before() {
        card = new Card(Suit.HEARTS, Rank.KING);
    }

    @Test
    public void canGetSuit() {
        assertEquals(Suit.HEARTS, card.getSuit());
    }

    @Test
    public void canGetRank() {
        assertEquals(Rank.KING, card.getRank());
    }

}
