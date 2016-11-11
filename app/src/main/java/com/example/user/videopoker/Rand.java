package com.example.user.videopoker;


import java.util.Random;

public class Rand {

    public static int get(int min, int max){
        Random rand = new Random();
        int result = rand.nextInt((max - min) + 1) + min;
        return result;
    }

}