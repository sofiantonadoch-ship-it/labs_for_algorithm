package org.example.lab6.first;
import java.util.Scanner;
public class Main {
    private static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        if (!isSorted(array)) {
            throw new IllegalArgumentException(
                    "Массив должен быть отсортирован"
            );
        }
        int m = scanner.nextInt();
        int[] queries = new int[m];
        for (int i = 0; i < m; i++) {
            queries[i] = scanner.nextInt();
        }
        ApproximateSearch search = new ApproximateSearchImpl();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int closest = search.findClosest(array, queries[i]);
            if (i > 0) {
                result.append(" ");
            }
            result.append(closest);
        }
        System.out.println(result);
        scanner.close();
    }
}