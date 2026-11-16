package org.example.lab7.first;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
public class MapReader {
    private static final int MIN_VALUE = -15;
    private static final int MAX_VALUE = 15;
    public static int[][] read(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(
                Paths.get(fileName)
        );
        if (lines.isEmpty()) {
            throw new IllegalArgumentException(
                    "Файл с картой пуст."
            );
        }
        int rows = lines.size();
        if (lines.get(0).trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Первая строка файла пустая."
            );
        }
        String[] firstRow = lines.get(0).trim().split(";", -1);
        int columns = firstRow.length;
        int[][] map = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            if (lines.get(i).trim().isEmpty()) {
                throw new IllegalArgumentException(
                        "Пустая строка: " + (i + 1)
                );
            }
            String[] numbers = lines.get(i).trim().split(";", -1);
            if (numbers.length != columns) {
                throw new IllegalArgumentException(
                        "Неверное количество столбцов в строке "
                                + (i + 1)
                );
            }
            for (int j = 0; j < columns; j++) {
                int value;
                try {
                    value = Integer.parseInt(numbers[j].trim());
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(
                            "Некорректное число в строке "
                                    + (i + 1)
                    );
                }
                if (value < MIN_VALUE || value > MAX_VALUE) {
                    throw new IllegalArgumentException(
                            "Число должно быть от -15 до 15."
                    );
                }
                map[i][j] = value;
            }
        }
        return map;
    }
}

