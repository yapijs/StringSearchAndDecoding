package org.strings.searchapp;

import java.util.Scanner;

import static org.strings.searchapp.Search.searchForWords;
import static org.strings.searchapp.Utils.*;

public class Application {
    static final String INPUT_FILE_NAME = "input.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi! This app will check how many words from dictionary will be in your input string.");
        System.out.println("Please enter the string to check against dictionary: ");
        String stringToCheck = getUserInput(scanner);

        System.out.println("Should search be case sensitive or not? [y\\n]");
        boolean isCaseSensitive = getUserInputIfCaseSensitive(scanner);

        int maxNumOfWords = searchForWords(readDictionary(INPUT_FILE_NAME), stringToCheck, isCaseSensitive);
        System.out.printf("The maximum number of words from dictionary in your input string is %d.", maxNumOfWords);
    }


}
