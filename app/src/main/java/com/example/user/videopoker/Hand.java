package com.example.user.videopoker;

import java.util.ArrayList;


public class Hand {

    private HandRank handRank;
    private ArrayList<Card> cards;

    public Hand(HandRank handRank){
        this.handRank = handRank;
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

    public void setCardAtIndexTo(int index, Card card){
        this.cards.set(index, card);
    }

    public void addCards(ArrayList<Card> cards){
        for (Card card : cards){
            addCard(card);
        }
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
    public String toString(){
        String handString = "";
        for( Card card : cards){
            handString += card.toString() + " ";
        }
        handString = handString.substring(0, handString.length()-1);
        return handString;
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


