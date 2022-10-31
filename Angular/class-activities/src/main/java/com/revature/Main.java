package com.revature;

import java.util.Arrays;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        String test = "There was an old lady who lived in an outhouse";
        String start = "an";
        String end = "outhouse";
        System.out.println(countWordsBetween(test, start, end));
        
    }

    // Returns the word count or -1 if start or end is missing or if start is not before end
    public static int countWordsBetween(String wholeSentence, String start, String end){
        List<String> sentenceArray = Arrays.asList(wholeSentence.split(" "));
        int startIndex = sentenceArray.indexOf(start);
        int endIndex = sentenceArray.indexOf(end);
        if (endIndex<0||startIndex<0||startIndex>=endIndex) return -1;
        return endIndex-startIndex - 1; 
    }
}

