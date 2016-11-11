package com.example.user.videopoker;

import org.junit.Before;
import org.junit.Test;

public class RandTest {


    @Before
    public void before(){

    }

    @Test
    public void testSomething(){
        int one = Rand.get(1,1);
        assertEquals(1, one);
    }

    private void assertEquals(int i, int one) {
    }

}