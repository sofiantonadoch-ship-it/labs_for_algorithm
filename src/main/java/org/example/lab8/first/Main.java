package org.example.lab8.first;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка: необходимо ввести N");
            return;
        }
        int n = scanner.nextInt();
        if (n < 1 || n > 100000) {
            System.out.println("Ошибка: N должно быть от 1 до 100000");
            return;
        }
        long[] prefix = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: введено недостаточно элементов");
                return;
            }
            int number = scanner.nextInt();
            if (number < -128 || number >= 127) {
                System.out.println("Ошибка: элементы должны быть от -128 до 126");
                return;
            }
            prefix[i] = prefix[i - 1] + number;
        }
        int k = 0;
        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: отсутствует второй индекс");
                return;
            }
            int j = scanner.nextInt();
            k++;
            if (k > 10000000) {
                System.out.println("Ошибка: количество запросов превышает 10000000");
                return;
            }
            if (i < 0 || i >= n || j < 0 || j >= n) {
                System.out.println("Ошибка: индекс выходит за границы массива");
                return;
            }
            if (i > j) {
                System.out.println("Ошибка: i не может быть больше j");
                return;
            }
            long sum = prefix[j + 1] - prefix[i];
            System.out.println(sum);
        }
        if (k < 1) {
            System.out.println("Ошибка: необходимо ввести хотя бы один запрос");
        }
        scanner.close();
    }
}

