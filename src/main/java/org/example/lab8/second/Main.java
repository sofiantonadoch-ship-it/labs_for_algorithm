package org.example.lab8.second;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );
        String firstLine = reader.readLine();
        if (firstLine == null || firstLine.trim().isEmpty()) {
            throw new IllegalArgumentException("Не указано N");
        }
        int n = Integer.parseInt(firstLine.trim());
        if (n < 1 || n > 100000) {
            throw new IllegalArgumentException(
                    "N должно находиться в диапазоне от 1 до 100000"
            );
        }
        String arrayLine = reader.readLine();
        if (arrayLine == null) {
            throw new IllegalArgumentException("Не указан массив");
        }
        StringTokenizer st = new StringTokenizer(arrayLine);
        if (st.countTokens() != n) {
            throw new IllegalArgumentException(
                    "Количество элементов массива должно быть равно N"
            );
        }
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (value < -10000000 || value > 10000000) {
                throw new IllegalArgumentException(
                        "Элементы массива должны быть от -10000000 до 10000000"
                );
            }
            array[i] = value;
        }
        SegmentTree segmentTree = new SegmentTreeImpl();
        segmentTree.build(array);
        StringBuilder output = new StringBuilder();
        String line;
        int k = 0;
        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) {
                continue;
            }
            st = new StringTokenizer(line);
            if (st.countTokens() != 2) {
                throw new IllegalArgumentException(
                        "Запрос должен содержать два числа"
                );
            }
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            if (left < 0 || right > n || left >= right) {
                throw new IllegalArgumentException(
                        "Некорректные границы запроса"
                );
            }
            k++;
            if (k > 10000000) {
                throw new IllegalArgumentException(
                        "Количество запросов не должно превышать 10000000"
                );
            }
            int result = segmentTree.query(left, right);
            output.append(result).append('\n');
        }
        if (k < 1) {
            throw new IllegalArgumentException(
                    "Количество запросов должно быть не меньше 1"
            );
        }
        System.out.print(output);
    }
}

