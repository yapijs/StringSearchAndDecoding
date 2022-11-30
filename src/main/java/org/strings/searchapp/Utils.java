package org.strings.searchapp;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {
    public static List<String> readDictionary(String input) {
        List<String> result = new ArrayList<>();
        try {
            Path path = Paths.get(Objects.requireNonNull(Application.class.getClassLoader()
                    .getResource(input)).toURI());
            Stream<String> lines = Files.lines(path);
            result = lines.collect(Collectors.toList());
            lines.close();
        } catch (URISyntaxException | NullPointerException | IOException e) {
            if (input == null) {
                input = "file";
            }
            System.out.println("Problems accessing \"" + input + "\". Check the file and start the app again.");
        }
        return result;
    }

    public static String getUserInput(Scanner scanner) {
        return scanner.nextLine();
    }

    static boolean getUserInputIfCaseSensitive(Scanner scanner) {
        boolean value = false;
        do {
            String inputValue = getUserInput(scanner);
            if (inputValue.equalsIgnoreCase("y")) {
                value = true;
                break;
            } else if (inputValue.equalsIgnoreCase("n"))
                break;
            else {
                System.out.println("Invalid input! Valid values are [y\\n]");
            }
        } while (true);
        return value;
    }

    public static void writeFile(String filename, String content) throws IOException {
        Path path = Paths.get("src/main/resources/" + filename);
        Files.write(path, content.getBytes(StandardCharsets.UTF_8));
    }
}
