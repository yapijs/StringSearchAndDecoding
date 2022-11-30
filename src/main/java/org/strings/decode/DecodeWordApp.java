package org.strings.decode;

import org.strings.searchapp.Utils;

import java.io.IOException;
import java.util.List;

public class DecodeWordApp {
    private static final int MAX_CHAR_COUNT = 26;
    private static final int STARTING_CHARACTER = 'A' - 1;

    private static final String FILENAME_INPUT = "decode.in";
    private static final String FILENAME_OUTPUT = "decode.out";

    public static void main(String[] args) throws IOException {
        List<String> inputData = Utils.readDictionary(FILENAME_INPUT);

        char[] rowCoded = fillArray(inputData.get(0), Integer.parseInt(inputData.get(1)));
        char[] rowOriginal = fillArray("", 1);

        StringBuilder decodedWord = decryptWord(rowOriginal, rowCoded, inputData.get(2));
        Utils.writeFile(FILENAME_OUTPUT, decodedWord.toString());
    }

    private static StringBuilder decryptWord(char[] rowOriginal, char[] rowCoded, String encryptedWord) {
        StringBuilder decodedWord = new StringBuilder();
        for (int i = 0; i < encryptedWord.length(); i++) {
            int positionOfCodedChar = searchForChar(encryptedWord.charAt(i), rowCoded);
            decodedWord.append(rowOriginal[positionOfCodedChar]);
        }
        return decodedWord;
    }

    private static char[] fillArray(String key, int offset) {
        StringBuilder keyToUse = new StringBuilder(key);
        char currentLetter = STARTING_CHARACTER;
        char[] result = new char[MAX_CHAR_COUNT];
        int i = offset - 1;
        while (isArrayNotFull(result)) {
            if (keyToUse.length() != 0) {
                result[i] = keyToUse.charAt(0);
                keyToUse.deleteCharAt(0);
            } else {
                int charFound = 1;
                while (charFound >= 0) {
                    currentLetter++;
                    charFound = searchForChar(currentLetter, result);
                }
                result[i] = currentLetter;
            }
            i++;
            if (i >= MAX_CHAR_COUNT) {
                i = 0;
            }
        }
        return result;
    }

    private static int searchForChar(char currentLetter, char[] charArray) {
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == currentLetter) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isArrayNotFull(char[] array) {
        boolean isNotFull = false;
        for (char s : array) {
            if (s == '\u0000') {
                isNotFull = true;
                break;
            }
        }
        return isNotFull;
    }
}
