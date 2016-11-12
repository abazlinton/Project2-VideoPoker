package com.example.user.videopoker;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;


public class CardTest {

    Card card, card2;

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

    @Test
    public void testToString2d() {
        card2 = new Card(Suit.DIAMONDS, Rank.TWO);
        assertEquals("2d", card2.toString());
    }

    @Test
    public void testToStringKh() {
        assertEquals("Kh", card.toString());
    }

    @Test
    public void testToStringTd() {
        card2 = new Card(Suit.DIAMONDS, Rank.TEN);
        assertEquals("Td", card2.toString());
    }

}
