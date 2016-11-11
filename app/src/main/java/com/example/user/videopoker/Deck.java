package com.example.user.videopoker;

import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
        this.make();
    }

    public int size() {
        return cards.size();
    }

    public Card getCardAt(int index) {
        return cards.get(index);
    }

    public Card pick() {
        int position = Rand.get(0, (size() - 1));
        return cards.remove(position);
    }

    private void make() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(suit, rank);
                this.cards.add(card);
            }
        }
    }

}
