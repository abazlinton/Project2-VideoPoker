package com.example.user.videopoker;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 12/11/2016.
 */

public class PlayerTest {

    Player player;
    Hand testHand;
    Card twoClubs;
    Card queenClubs;
    Card kingClubs;
    Card tenClubs;
    Card aceClubs;
    Card twoDiamonds;
    Card nineClubs;
    Card jackClubs;
    HandRank handRank;

    @Before
    public void before(){
        player = new Player();
        handRank = HandRank.NOT_YET_RANKED;
        testHand = new Hand(handRank);
        queenClubs = new Card(Rank.QUEEN, Suit.CLUBS);
        kingClubs = new Card(Rank.KING, Suit.CLUBS);
        aceClubs = new Card(Rank.ACE, Suit.CLUBS);
        tenClubs = new Card(Rank.TEN, Suit.CLUBS);
        twoClubs = new Card(Rank.TWO, Suit.CLUBS);
        twoDiamonds = new Card(Rank.TWO, Suit.DIAMONDS);
        jackClubs = new Card(Rank.JACK, Suit.CLUBS);
        nineClubs = new Card(Rank.NINE, Suit.CLUBS);
        testHand.addCard(queenClubs);
        testHand.addCard(kingClubs);
        testHand.addCard(aceClubs);
        testHand.addCard(tenClubs);
        testHand.addCard(twoClubs);

        player.setHand(testHand);
    }

    @Test
    public void testPlayerStartsWith0Credit(){
        assertEquals(0, player.getCredit());
    }

    @Test
    public void playerCanTakeHand(){
        assertEquals(5, player.getHand().size());
    }

    @Test
    public void playerCanToggleHOLD(){
        player.toggleHold(1);
        player.toggleHold(3);
        player.toggleHold(1);
        assertEquals(false, player.getHolds().get(1).booleanValue());
        assertEquals(true, player.getHolds().get(3).booleanValue());
    }

    @Test
    public void playerHasNoHoldsAtStart(){
        assertEquals(false, player.getHolds().get(0).booleanValue());
        assertEquals(false, player.getHolds().get(1).booleanValue());
        assertEquals(false, player.getHolds().get(2).booleanValue());
        assertEquals(false, player.getHolds().get(3).booleanValue());
        assertEquals(false, player.getHolds().get(4).booleanValue());
    }

    @Test
    public void canGetCountOfHolds(){
        player.toggleHold(1);
        player.toggleHold(3);
        assertEquals(2, player.getHoldCount());
    }

    @Test
    public void canIncreaseCredit(){
        player.setCredit(500);
        player.increaseCredit(10);
        assertEquals(510, player.getCredit());
    }

    @Test
    public void canDecreaseCredit(){
        player.setCredit(500);
        player.decreaseCredit(10);
        assertEquals(490, player.getCredit());
    }

    @Test
    public void playerHoldsCanBeReset(){
        player.toggleHold(1);
        player.toggleHold(3);
        player.resetHolds();
        assertEquals(false, player.getHolds().get(0).booleanValue());
        assertEquals(false, player.getHolds().get(1).booleanValue());
        assertEquals(false, player.getHolds().get(2).booleanValue());
        assertEquals(false, player.getHolds().get(3).booleanValue());
        assertEquals(false, player.getHolds().get(4).booleanValue());
    }
    @Test
    public void getNumberOfSpacesInHand(){
        player.toggleHold(1);
        player.toggleHold(3);
        assertEquals(3, player.spacesInHand());
    }

    @Test (expected = IllegalArgumentException.class)
    public void cannotAddMoreCardsThanSpaceInHand(){
        ArrayList<Card> testCard = new ArrayList<Card>();
        testCard.add(tenClubs);
        player.addNewCards(testCard);
    }


    @Test
    public void canIntegrateNewCardsIntoHand(){
        Card origCard0 = player.getHand().getCards().get(0);
        Card origCard1 = player.getHand().getCards().get(1);
        player.toggleHold(1);
        Deck deck = new Deck();
        ArrayList<Card> newCards = new ArrayList<Card>();
        newCards = deck.deal(player.spacesInHand());
        player.addNewCards(newCards);
        Card newCard0 = player.getHand().getCards().get(0);
        boolean card0EqualCheck = (origCard0 == newCard0);
        assertEquals(origCard1, player.getHand().getCards().get(1));
        assertEquals(false, card0EqualCheck);
    }



}
