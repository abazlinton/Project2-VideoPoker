package com.example.user.videopoker;

import java.util.ArrayList;


public class Hand {

    protected HandRank handRank;
    protected ArrayList<Card> cards;

    public Hand(){
        this.handRank = null;
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

    public ArrayList<Card> getCards(){
        return cards;
    }


}


