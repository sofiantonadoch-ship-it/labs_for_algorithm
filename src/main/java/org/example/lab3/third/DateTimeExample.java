package org.example.lab3.third;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DateTimeExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<LocalDateTime> dates = new ArrayList<>();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        System.out.println("Введите количество дат:");
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(
                "Введите даты в формате yyyy-MM-dd HH:mm:"
        );

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            dates.add(LocalDateTime.parse(input, formatter));
        }

        Sorting<LocalDateTime> sorting = new MergeSort<>();
        sorting.sort(dates);

        System.out.println("Отсортированные даты:");

        for (LocalDateTime date : dates) {
            System.out.println(date.format(formatter));
        }

        scanner.close();
    }
}
