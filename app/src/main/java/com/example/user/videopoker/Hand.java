package com.example.user.videopoker;

import java.util.ArrayList;


public class Hand {

    protected HandRank handRank;
    protected ArrayList<Card> cards;

    public Hand(){
        this.handRank = HandRank.NOT_STARTED;
        this.cards = new ArrayList<Card>();
    }

    public HandRank getRank(){
        return this.handRank;
    }

    public void setRank(HandRank handRank){
        this.handRank = handRank;
    }

    public void addCard( Card card ){
        this.cards.add( card );
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public boolean containsAce() {
        for (Card card : this.cards){
            if (card.getRank() == Rank.ACE){
                return true;
            }
        }
        return false;
    }

    public boolean containsTwo() {
        for (Card card : this.cards){
            if (card.getRank() == Rank.TWO){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


