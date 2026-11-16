package org.example.lab7.first;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class MapGenerator {
    private static final int SIZE = 5;
    private static final int MIN_VALUE = -15;
    private static final int MAX_VALUE = 15;
    public static void generate(String fileName) throws IOException {
        Random random = new Random();
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < SIZE; j++) {
                int value = random.nextInt(
                        MAX_VALUE - MIN_VALUE + 1
                ) + MIN_VALUE;
                if (j > 0) {
                    row.append(";");
                }
                row.append(value);
            }
            lines.add(row.toString());
        }
        Files.write(Paths.get(fileName), lines);
        System.out.println("Новая карта успешно создана!");
    }
}

