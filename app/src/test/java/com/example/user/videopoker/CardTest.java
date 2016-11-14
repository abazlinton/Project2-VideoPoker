package com.example.user.videopoker;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;


public class CardTest {

    Card card, card2;

    @Before
    public void before() {
        card = new Card(Rank.KING, Suit.HEARTS);
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
        card2 = new Card(Rank.TWO, Suit.DIAMONDS);
        assertEquals("2d", card2.toString());
    }

    @Test
    public void testToStringKh() {
        assertEquals("Kh", card.toString());
    }

    @Test
    public void testToStringTd() {
        card2 = new Card(Rank.TEN, Suit.DIAMONDS);
        assertEquals("Td", card2.toString());
    }

    @Test
    public void testToFileStringTd(){
        card2 = new Card(Rank.TEN, Suit.DIAMONDS);
        assertEquals("i10_of_diamonds", card2.toFileString());
    }

    @Test
    public void testToFileString2s(){
        card2 = new Card(Rank.TWO, Suit.SPADES);
        assertEquals("i2_of_spades", card2.toFileString());
    }

    @Test
    public void testToFileStringAh(){
        card2 = new Card(Rank.ACE, Suit.HEARTS);
        assertEquals("ace_of_hearts", card2.toFileString());
    }

}
