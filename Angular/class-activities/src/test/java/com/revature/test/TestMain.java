package com.revature.test;

import com.revature.Main;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestMain {

    @Test
    public void test1(){
        String testSentence = "There was an old lady who lived in an outhouse";
        String start = "lady";
        String end = "outhouse";
        Assertions.assertEquals(Main.countWordsBetween(testSentence,start,end), 4);
    }
    @Test
    public void test2(){
        String testSentence = "There was an old lady who lived in an outhouse";
        String start = "lady";
        String end = "lady";
        Assertions.assertEquals(Main.countWordsBetween(testSentence,start,end), -1);
    }
    @Test
    public void test3(){
        String testSentence = "There was an old lady who lived in an outhouse";
        String start = "an";
        String end = "outhouse";
        Assertions.assertEquals(Main.countWordsBetween(testSentence,start,end), 6);
    }
    @Test
    public void test4(){
        String testSentence = "There was an old lady who lived in an outhouse";
        String start = "outhouse";
        String end = "lady";
        Assertions.assertEquals(Main.countWordsBetween(testSentence,start,end), -1);
    }
    @Test
    public void test5(){
        String testSentence = "There was an old lady who lived in an outhouse";
        String start = "lady";
        String end = "hello";
        Assertions.assertEquals(Main.countWordsBetween(testSentence,start,end), -1);
    }
    @Test
    public void test6(){
        String testSentence = "There was an old lady who lived in an outhouse";
        String start = "was";
        String end = "an";
        Assertions.assertEquals(Main.countWordsBetween(testSentence,start,end), 0);
    }
}
