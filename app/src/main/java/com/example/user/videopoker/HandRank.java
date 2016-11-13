package com.example.user.videopoker;


public enum HandRank {
    ROYAL_FLUSH (4000),
    STRAIGHT_FLUSH (250),
    FOUR_OF_A_KIND (125),
    FULL_HOUSE (45),
    FLUSH (30),
    STRAIGHT (20),
    THREE_OF_A_KIND (15),
    TWO_PAIR (10),
    JACKS_OR_BETTER (5),
    PAIR_LESS_THAN_JACKS (0),
    JUNK (0),
    IN_PROGRESS (0),
    NOT_YET_RANKED (0);


    private final int payout;

    HandRank(int payout){
        this.payout = payout;
    }

    public int getPayout() {
        return payout;
    }
}