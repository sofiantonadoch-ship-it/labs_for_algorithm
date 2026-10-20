package org.example.lab3.third;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.println("Введите количество студентов:");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Студент №" + (i + 1));

            System.out.println("Введите имя:");
            String name = scanner.nextLine();

            System.out.println("Введите возраст:");
            int age = Integer.parseInt(scanner.nextLine());

            students.add(new Student(name, age));
        }

        Sorting<Student> sorting = new MergeSort<>();
        sorting.sort(students);

        System.out.println("\nОтсортированный список студентов:");

        for (Student student : students) {
            System.out.println(student);
        }

        scanner.close();
    }
}