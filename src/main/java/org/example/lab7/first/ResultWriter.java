package org.example.lab7.first;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
public class ResultWriter {
    public static void save(
            String fileName,
            int maxCoins,
            String path
    ) throws IOException {
        List<String> result = Arrays.asList(
                String.valueOf(maxCoins),
                path
        );
        Files.write(Paths.get(fileName), result);
        System.out.println(
                "\nРезультат сохранён в " + fileName
        );
    }
    public static void read(String fileName) throws IOException {
        List<String> result = Files.readAllLines(
                Paths.get(fileName)
        );
        for (String line : result) {
            System.out.println(line);
        }
    }
}

