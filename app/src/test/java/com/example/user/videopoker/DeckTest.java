package com.example.user.videopoker;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

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
    public void canBeDealtCards() {
        assertEquals( Card.class, deck.deal(5).get(0).getClass() );
    }

    @Test
    public void dealtRightNoOfCards(){
        ArrayList<Card> returnedCards = deck.deal(5);
        assertEquals(5, returnedCards.size());
    }

    @Test
    public void deckCanBeReset(){
        deck.deal(20);
        deck.resetNoShuffle();
        assertEquals(52, deck.size());
    }
}
