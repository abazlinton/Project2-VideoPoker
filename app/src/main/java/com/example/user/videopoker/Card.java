package com.example.user.videopoker;

/**
 * Created by user on 11/11/2016.
 */

public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Rank rank, Suit suit){
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit(){
        return this.suit;
    }

    public Rank getRank(){
        return this.rank;
    }

    @Override
    public String toString() {
        String stringRank = "";
        String stringSuit = "";
        if (rank.ordinal() < 8) {
            stringRank = Integer.toString(rank.ordinal() + 2);
        }
        else {
            stringRank = (String) rank.toString().substring(0,1);
        }
        stringSuit = suit.toString().substring(0,1).toLowerCase();
        return stringRank + stringSuit;
    }

    public String toFileString()
    {
        String startNumbers = "i";
        String stringRank = "";
        String stringSuit = "";
        String middle = "_of_";
        if (rank.ordinal() < 9) {
            stringRank = startNumbers + Integer.toString(rank.ordinal() + 2);
        }
        else {
            stringRank = (String) rank.toString().toLowerCase();
        }
        stringSuit = suit.toString().toLowerCase();
        return stringRank + middle + stringSuit;

    }
}


