package com.example.user.videopoker;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 11/11/2016.
 */

public class DeckTest {

    Deck deck;


    @Before
    public void before() {
        deck = new Deck();
    }

    @Test
    public void checkDeckStartsWith52Cards() {
        assertEquals(52, deck.size());
    }

    @Test
    public void checkCard13Is2D() {
        Card compareCard = new Card( Suit.DIAMONDS, Rank.TWO );
        assertEquals( compareCard.getSuit(), deck.getCardAt(13).getSuit() );
        assertEquals( compareCard.getRank(), deck.getCardAt(13).getRank() );
    }

    @Test
    public void pickReturnsACard() {
        assertEquals( Card.class, deck.pick().getClass() );
    }

//    @Test
//    public void testShuffle() {
//        //will fail 1/13 times - confirmed
//        Card testCard = deck.getCardAt(0);
//        deck.shuffle();
//        Card shuffledCard = deck.getCardAt(0);
//        boolean testChange = (testCard.getRank() != shuffledCard.getRank());
//        assertEquals(true, testChange);
//    }

}
