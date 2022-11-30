package org.strings.searchapp;

import java.util.ArrayList;
import java.util.Scanner;

import static org.strings.searchapp.Search.searchForWords;
import static org.strings.searchapp.Utils.*;

public class Application {
    static final String INPUT_FILE_NAME = "input.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi! This app will check how many words from dictionary will be in your input string.");
        System.out.println("Please enter the string to check against dictionary: ");
        int maxNumOfWords = searchForWords(readDictionary(INPUT_FILE_NAME), getUserInput(scanner));

        System.out.printf("The maximum number of words from dictionary in your input string is %d.", maxNumOfWords);
    }


}
