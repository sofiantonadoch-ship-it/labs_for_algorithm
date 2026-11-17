package org.example.lab7.third;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("lcs-input.txt"))) {
            String x = reader.readLine();
            String y = reader.readLine();
            if (x == null || y == null) {
                throw new IllegalArgumentException(
                        "Файл должен содержать две строки"
                );
            }
            int result = LCS.findLCS(x, y);
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}
