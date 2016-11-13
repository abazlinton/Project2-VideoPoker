package com.example.user.videopoker;

import java.util.ArrayList;


public class Hand {

    private HandRank handRank;
    private ArrayList<Card> cards;

    public Hand(){
        this.handRank = HandRank.NOT_STARTED;
        this.cards = new ArrayList<Card>();
    }

    public HandRank getRank(){
        return this.handRank;
    }

    public int size(){
        return cards.size();
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

//    public void sortByRank(){
//
//    }
//
//    @Override
//    public String toString() {
//        return super.toString();
//    }
}


