package com.revature.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.revature.SingleAndReadyToMingle;

import java.util.Arrays;


public class SingleAndReadyToMingleTest {
    private SingleAndReadyToMingle s;
    int[] uniquesEnd = {3, 4, 3, 6, 4, 5, 7, 6, 7, 9};
    int[] uniquesMiddle = {3, 4, 3, 6, 4, 5, 9, 7, 6, 7};
    int[] uniquesStart = {9, 3, 4, 3, 6, 4, 5, 7, 6, 7};
    int[] onlyDuplicates = {3, 4, 3, 6, 4, 7, 6, 7};

    @Test
    // No Uniques
    public void noUniques() {
        s = new SingleAndReadyToMingle();
        Integer[] result = s.findUniqueIntsWithMap(onlyDuplicates);
        Integer[] resultArr = {};
        Assertions.assertEquals(Arrays.toString(resultArr), Arrays.toString(result), "Incorrect");
        System.out.println(Arrays.toString(result) + ", " + Arrays.toString(resultArr));
    }

    @Test
    // Uniques at the end
    public void uniquesAtEnd() {
        s = new SingleAndReadyToMingle();
        Integer[] result = s.findUniqueIntsWithMap(uniquesEnd);
        Integer[] resultArr = {9, 5};
        Assertions.assertEquals(Arrays.toString(resultArr), Arrays.toString(result), "Incorrect");
        System.out.println(Arrays.toString(result) + ", " + Arrays.toString(resultArr));
    }

    @Test
    // Uniques at the beginning
    public void uniquesAtBeginning() {
        s = new SingleAndReadyToMingle();
        Integer[] result = s.findUniqueIntsWithMap(uniquesStart);
        Integer[] resultArr = {9, 5};
        Assertions.assertEquals(Arrays.toString(resultArr), Arrays.toString(result), "Incorrect");
        System.out.println(Arrays.toString(result) + ", " + Arrays.toString(resultArr));
    }

    @Test
    // Uniques in the middle
    public void uniquesAtMiddle() {
        s = new SingleAndReadyToMingle();
        Integer[] result = s.findUniqueIntsWithMap(uniquesMiddle);
        Integer[] resultArr = {9, 5};
        Assertions.assertEquals(Arrays.toString(resultArr), Arrays.toString(result), "Incorrect");
        System.out.println(Arrays.toString(result) + ", " + Arrays.toString(resultArr));
    }
}
