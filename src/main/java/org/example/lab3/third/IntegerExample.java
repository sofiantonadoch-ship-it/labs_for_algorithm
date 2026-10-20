package org.example.lab3.third;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntegerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();

        System.out.println("Введите количество чисел:");
        int n = scanner.nextInt();

        System.out.println("Введите " + n + " целых чисел:");

        for (int i = 0; i < n; i++) {
            nums.add(scanner.nextInt());
        }

        Sorting<Integer> sorting = new MergeSort<>();
        sorting.sort(nums);

        System.out.println("Отсортированный список:");
        System.out.println(nums);

        scanner.close();
    }
}