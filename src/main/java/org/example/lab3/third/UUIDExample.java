package org.example.lab3.third;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class UUIDExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<UUID> ids = new ArrayList<>();

        System.out.println("Введите количество UUID:");
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите UUID (каждый с новой строки):");

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            ids.add(UUID.fromString(input));
        }

        Sorting<UUID> sorting = new MergeSort<>();
        sorting.sort(ids);

        System.out.println("Отсортированные UUID:");

        ids.forEach(System.out::println);

        scanner.close();
    }
}