package com.revature;

import java.util.*;
import java.util.regex.Pattern;

// Given two words in a string of words, count the number of other words between the two words you are given.
// 5 unit tests
public class InterveningVerbiage {

    public static int countWords(String sentence, String leftBoundWord, String rightBoundWord) {
        // Create an array of Strings for each word
        String[] words = sentence.split(" ");
        List<String> wordsList = new ArrayList<>();

        // Move actual words (non spaces) to a list
        for (String s:
             words) {
            if (!s.equals("")) {
                wordsList.add(s);
            }
        }

        // Find the left word and clear
        int leftBound = wordsList.indexOf(leftBoundWord);
        wordsList.subList(0, leftBound + 1).clear();

        // Find the right word and clear
        int rightBound = wordsList.indexOf(rightBoundWord);
        try {
            wordsList.subList(rightBound, wordsList.size()).clear();
        } catch (IndexOutOfBoundsException e) {
            return -1;
        }

        if (wordsList.size() > 0) {
            return wordsList.size();
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {

//        Scanner userInput = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("Enter a sentence:");
//            String sentence = userInput.nextLine();
//
//            System.out.println("Enter the word to count from:");
//            String leftBoundWord = userInput.nextLine();
//
//            System.out.println("Enter the word to count to:");
//            String rightBoundWord = userInput.nextLine();
//
//            int countedWords = countWords(sentence, leftBoundWord, rightBoundWord);
//            if (countedWords > -1) {
//                System.out.println("There are " + countedWords + " words between " + leftBoundWord + " and " + rightBoundWord);
//            } else {
//                System.out.println("One or both of those words are not in the sentence.");
//            }
//
//            System.out.println("Try again? (y/n)");
//            String choice = userInput.nextLine().toLowerCase();
//            if (choice.charAt(0) == 'y') {
//                // continue loop
//            } else {
//                break;
//            }
//        }

        String test = "word1 word2    word3 word4 word5 word6";
        System.out.println(countWords(test, "word5", "word2"));
    }
}
