package org.example.lab3.third;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n===== МЕНЮ СОРТИРОВКИ =====");
            System.out.println("1. Сортировка Integer");
            System.out.println("2. Сортировка String");
            System.out.println("3. Сортировка LocalDateTime");
            System.out.println("4. Сортировка Student");
            System.out.println("5. Сортировка UUID");
            System.out.println("0. Выход");
            System.out.print("Выберите пункт меню: ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        sortIntegers();
                        break;
                    case "2":
                        sortStrings();
                        break;
                    case "3":
                        sortDateTimes();
                        break;
                    case "4":
                        sortStudents();
                        break;
                    case "5":
                        sortUUIDs();
                        break;
                    case "0":
                        running = false;
                        System.out.println("Программа завершена.");
                        break;
                    default:
                        System.out.println(
                                "Ошибка: выберите пункт от 0 до 5."
                        );
                }
            } catch (IllegalArgumentException |
                     java.time.format.DateTimeParseException e) {
                System.out.println("Ошибка ввода: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static int readCount() {
        System.out.print("Введите количество элементов: ");
        int count = Integer.parseInt(scanner.nextLine());

        if (count < 0) {
            throw new IllegalArgumentException(
                    "Количество не может быть отрицательным."
            );
        }

        return count;
    }

    private static void sortIntegers() {
        int n = readCount();
        List<Integer> nums = new ArrayList<>();

        System.out.println("Введите целые числа:");

        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(scanner.nextLine()));
        }

        Sorting<Integer> sorting = new MergeSort<>();
        sorting.sort(nums);

        System.out.println("Отсортированный список:");
        System.out.println(nums);
    }

    private static void sortStrings() {
        int n = readCount();
        List<String> words = new ArrayList<>();

        System.out.println("Введите строки:");

        for (int i = 0; i < n; i++) {
            words.add(scanner.nextLine());
        }

        Sorting<String> sorting = new MergeSort<>();
        sorting.sort(words);

        System.out.println("Отсортированный список:");
        words.forEach(System.out::println);
    }

    private static void sortDateTimes() {
        int n = readCount();
        List<LocalDateTime> dates = new ArrayList<>();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        System.out.println(
                "Введите дату и время (yyyy-MM-dd HH:mm):"
        );

        for (int i = 0; i < n; i++) {
            dates.add(
                    LocalDateTime.parse(
                            scanner.nextLine(), formatter
                    )
            );
        }

        Sorting<LocalDateTime> sorting = new MergeSort<>();
        sorting.sort(dates);

        System.out.println("Отсортированные даты:");
        dates.forEach(date ->
                System.out.println(date.format(formatter))
        );
    }

    private static void sortStudents() {
        int n = readCount();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Студент №" + (i + 1));

            System.out.print("Введите имя: ");
            String name = scanner.nextLine();

            System.out.print("Введите возраст: ");
            int age = Integer.parseInt(scanner.nextLine());

            students.add(new Student(name, age));
        }

        Sorting<Student> sorting = new MergeSort<>();
        sorting.sort(students);

        System.out.println(
                "Студенты, отсортированные по имени и возрасту:"
        );
        students.forEach(System.out::println);
    }

    private static void sortUUIDs() {
        int n = readCount();
        List<UUID> ids = new ArrayList<>();

        System.out.println("Введите UUID:");

        for (int i = 0; i < n; i++) {
            ids.add(UUID.fromString(scanner.nextLine()));
        }

        Sorting<UUID> sorting = new MergeSort<>();
        sorting.sort(ids);

        System.out.println("Отсортированные UUID:");
        ids.forEach(System.out::println);
    }
}
