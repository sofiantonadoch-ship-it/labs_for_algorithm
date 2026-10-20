package org.example.lab3.third;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<>();

        System.out.println("Введите количество строк:");
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите строки:");

        for (int i = 0; i < n; i++) {
            words.add(scanner.nextLine());
        }

        Sorting<String> sorting = new MergeSort<>();
        sorting.sort(words);

        System.out.println("Отсортированный список:");
        words.forEach(System.out::println);

        scanner.close();
    }
}