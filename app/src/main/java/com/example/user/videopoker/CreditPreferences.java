package com.example.user.videopoker;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class CreditPreferences {
    private static final String KEY_CREDITS = "credits";

    public static void setStoredCredits(Context context, int credits){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_CREDITS, credits);
        editor.apply();
    }

    public static int getStoredCredits(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        int credits = sharedPreferences.getInt(KEY_CREDITS, 999);
        return credits;
    }

}


