package com.revature.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.InterveningVerbiage;

public class CountWordsTest {
    public String testSentence = "word1 word2 word3 word4 word5";
    private InterveningVerbiage tc;

    @Test
    // Test back-to-back words
    public void backToBackCounterTest() {
        tc = new InterveningVerbiage();
        int result = tc.countWords(testSentence, "word1", "word2");
        Assertions.assertEquals(0, result, "Incorrect");
        System.out.println(result);
    }

    @Test
    // Test invalid left-bound
    public void leftBoundCounterTest() {
        tc = new InterveningVerbiage();
        int result = tc.countWords(testSentence, "word", "word5");
        Assertions.assertEquals(-1, result, "Incorrect");
        System.out.println(result);
    }

    @Test
    // Test invalid right-bound
    public void rightBoundCounterTest() {
        tc = new InterveningVerbiage();
        int result = tc.countWords(testSentence, "word1", "word");
        Assertions.assertEquals(-1, result, "Incorrect");
        System.out.println(result);
    }

    @Test
    // Test swapped bounds
    public void swappedBoundsCounterTest() {
        tc = new InterveningVerbiage();
        int result = tc.countWords(testSentence, "word5", "word1");
        Assertions.assertEquals(-1, result, "Incorrect");
        System.out.println(result);
    }

    @Test
    // Test invalid bounds (spelling..)
    public void invalidBoundsCounterTest() {
        tc = new InterveningVerbiage();
        int result = tc.countWords(testSentence, "word", "word");
        Assertions.assertEquals(-1, result, "Incorrect");
        System.out.println(result);
    }

    @Test
    // Test correct case
    public void idealCounterTest() {
        tc = new InterveningVerbiage();
        int result = tc.countWords(testSentence, "word1", "word5");
        Assertions.assertEquals(3, result, "Incorrect");
        System.out.println(result);
    }
}
