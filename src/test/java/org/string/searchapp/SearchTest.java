package org.string.searchapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.strings.searchapp.Search;

import java.util.ArrayList;
import java.util.List;

public class SearchTest {
    @Test
    public void shouldFindWordsInString() {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("ab");
        dictionary.add("abba");
        dictionary.add("efg");
        String input = "866abbaefaba";

        int foundWords = Search.searchForWords(dictionary, input);
        Assertions.assertEquals(2, foundWords);
    }
}
