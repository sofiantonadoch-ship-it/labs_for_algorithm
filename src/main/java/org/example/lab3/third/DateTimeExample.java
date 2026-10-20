package org.example.lab3.third;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class DateTimeExample {
    public static void main(String[] args) {
        List<LocalDateTime> dates = Arrays.asList(
                LocalDateTime.of(2025, 5, 10, 12, 0),
                LocalDateTime.of(2023, 1, 15, 9, 30),
                LocalDateTime.of(2024, 8, 20, 18, 0)
        );

        Sorting<LocalDateTime> sorting = new MergeSort<>();
        sorting.sort(dates);

        dates.forEach(System.out::println);
    }
}
