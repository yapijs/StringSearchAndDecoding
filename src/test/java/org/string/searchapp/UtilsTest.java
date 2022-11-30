package org.string.searchapp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.strings.searchapp.Utils.readDictionary;

public class UtilsTest {

    @Test
    public void shouldReadDictionary() {
        List<String> arrayToTest = new ArrayList<>();
        arrayToTest.add("can");
        arrayToTest.add("cat");
        arrayToTest.add("dog");
        arrayToTest.add("catalog");
        arrayToTest.add("log");
        arrayToTest.add("able");
        arrayToTest.add("of");
        arrayToTest.add("an");
        List<String> returnedArray = readDictionary("input.txt");

        assertEquals(arrayToTest, returnedArray);
    }

    @Test
    public void shouldReadInputFileWrongFilenames() {
        List<String> filenames = new ArrayList<>();
        filenames.add("");
        filenames.add("someotherfile.txt");
        filenames.add("input");
        for ( String name : filenames) {
            assertEquals(0, readDictionary(name).size());
        }
    }
}
