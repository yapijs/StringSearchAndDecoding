package org.strings.searchapp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search {

    public static int searchForWords(List<String> dictionary, String input) {
        List<String> stringList = new ArrayList<>(dictionary);
        stringList.sort(Comparator.comparingInt(String::length));
        int count = 0;

        for(String word: stringList) {
            Pattern pattern = Pattern.compile(word);
            Matcher matcher = pattern.matcher(input);
            while(matcher.find()) {
                count++;
            }
            input = matcher.replaceAll(" ");
        }
        return count;
    }
}
