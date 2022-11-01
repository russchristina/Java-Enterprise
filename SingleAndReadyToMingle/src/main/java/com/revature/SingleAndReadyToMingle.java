package com.revature;

// Given an array of integers in which two elements appear exactly once and all other
// elements appear exactly twice, find the two elements that appear only once.

/*
 * You can assume that the input will **always** include at least two and exactly two elements that appear only once.
 * You may not assume that the list will be sorted ahead of time.
 * Extra Challenge: Can you complete this puzzle in linear time and constant space?
 * Extra Extra Challenge: Can you make your solution generic over other input types?
 */

import java.util.*;

// An array full of duplicates except for two elements
public class SingleAndReadyToMingle {

    // Sort, then remove duplicates
    // Should be O(n log(n)) + O(n) at best
    public static int[] findUniqueInts(int[] arr) {
        // Sort
        Arrays.sort(arr);

        // Find uniques
        int[] uniques = {0, 0};
        int uniqueIndex = 0;
        for (int i = 0; i < arr.length; i++) {

            if (i == arr.length - 1) {
                uniques[uniqueIndex] = arr[i];
                break;
            }

            if (arr[i] != arr[i + 1] && uniqueIndex < 2) {
                uniques[uniqueIndex] = arr[i];
                uniqueIndex++;
            } else if (uniqueIndex < 2) {
                i++;
            } else {
                break;
            }

        }

        return uniques;
    }

    // Sort into a Map, find uniques
    // Should be O(n)
    public static Integer[] findUniqueIntsWithMap(int[] arr) {
        Map<Integer, Integer> intCount = new HashMap<>(arr.length / 2 + 2);

        // Populate Map, indicating duplicates with the values
        for (int i = 0; i < arr.length; i++) {
            if (intCount.containsKey(arr[i])) {
                intCount.remove(arr[i]);
            } else {
                intCount.put(arr[i], null);
            }
        }

        return intCount.keySet().toArray(new Integer[intCount.size()]);
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 3, 6, 4, 5, 7, 6, 7, 9};
        System.out.println(Arrays.toString(findUniqueIntsWithMap(array)));
    }
}
