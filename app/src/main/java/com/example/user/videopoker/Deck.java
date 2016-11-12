package com.example.user.videopoker;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
        this.resetWithShuffle();
    }

    public int size() {
        return cards.size();
    }

    public void resetNoShuffle() {

        if (!cards.isEmpty()) {
                cards.clear();
        }

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(suit, rank);
                this.cards.add(card);
            }
        }
    }

    public void resetWithShuffle(){
        resetNoShuffle();
        shuffle();
    }

    public ArrayList<Card> deal(int dealSize){
        ArrayList<Card> returnCards = new ArrayList<>();
        for (int i=0; i < dealSize; i++) {
            returnCards.add(cards.remove(0));
        }
        return returnCards;
    }

    private void shuffle(){
        Collections.shuffle(cards);
    }

}
