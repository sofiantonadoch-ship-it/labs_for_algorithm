package org.example.lab7.second;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        try {
            String input = Files.readString(
                    Path.of("lis-input.txt"),
                    StandardCharsets.UTF_8
            );
            String[] data = input.trim().split("\\s+");
            int n = Integer.parseInt(data[0]);
            if (n < 1 || n > 20) {
                throw new IllegalArgumentException(
                        "Количество элементов должно быть от 1 до 20"
                );
            }
            if (data.length != n + 1) {
                throw new IllegalArgumentException(
                        "Количество чисел не соответствует n"
                );
            }
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(data[i + 1]);
                if (a[i] < 0 || a[i] > 20) {
                    throw new IllegalArgumentException(
                            "Элементы должны находиться от 0 до 20"
                    );
                }
            }
            int[] dp = new int[n];
            int[] prev = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                prev[i] = -1;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {

                    if (a[j] < a[i] && dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            int maxLength = 0;
            int lastIndex = -1;
            for (int i = 0; i < n; i++) {
                if (dp[i] > maxLength) {
                    maxLength = dp[i];
                    lastIndex = i;
                }
            }
            List<Integer> result = new ArrayList<>();
            while (lastIndex != -1) {
                result.add(a[lastIndex]);
                lastIndex = prev[lastIndex];
            }
            Collections.reverse(result);
            StringBuilder output = new StringBuilder();
            output.append(maxLength).append("\n");
            for (int i = 0; i < result.size(); i++) {
                if (i > 0) {
                    output.append(" ");
                }
                output.append(result.get(i));
            }
            Files.writeString(
                    Path.of("lis-output.txt"),
                    output.toString(),
                    StandardCharsets.UTF_8
            );
            String fileResult = Files.readString(
                    Path.of("lis-output.txt"),
                    StandardCharsets.UTF_8
            );
            System.out.println("Результат из lis-output.txt:");
            System.out.println(fileResult);
        } catch (IOException e) {
            System.out.println("Ошибка работы с файлом: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: входные данные должны быть числами");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
