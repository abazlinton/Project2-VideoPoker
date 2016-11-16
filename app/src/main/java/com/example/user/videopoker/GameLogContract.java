package com.example.user.videopoker;


import android.provider.BaseColumns;

public final class GameLogContract {

    private GameLogContract() {}

    /* Inner class that defines the table contents */
    public static class GameLogTable implements BaseColumns {
        public static final String TABLE_NAME = "log";
        public static final String COLUMN_NAME_DEAL = "deal";
//        public static final String COLUMN_NAME_HELD = "held";
        public static final String COLUMN_NAME_FINAL = "final";
        public static final String COLUMN_NAME_NET = "net_winnings";
        public static final String COLUMN_NAME_HANDRANK = "hand_rank";
//        public static final String DUMMY_IMAGE = "dummy_image";

    }

}
