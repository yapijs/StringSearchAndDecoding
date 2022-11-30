package org.strings.searchapp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Search {

    public static int searchForWords(List<String> dictionary, String input, boolean caseSensitive) {
        List<String> stringList = new ArrayList<>(dictionary);
        stringList.sort(Comparator.comparingInt(String::length));
        if (!caseSensitive) {
            input = input.toLowerCase();
            stringList = stringList.stream().map(String::toLowerCase).collect(Collectors.toList());
        }
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
