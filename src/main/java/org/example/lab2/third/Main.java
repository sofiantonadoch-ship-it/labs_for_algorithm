package org.example.lab2.third;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Не указано количество студентов");
        }

        int n;
        try {
            n = Integer.parseInt(line.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Количество студентов должно быть целым числом", e);
        }

        if (n < 1 || n > 100000) {
            throw new IllegalArgumentException(
                    "Количество студентов должно быть от 1 до 100000");
        }

        List<Student> students = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            line = br.readLine();

            if (line == null || line.trim().isEmpty()) {
                throw new IllegalArgumentException(
                        "Отсутствуют данные студента №" + (i + 1));
            }

            line = line.trim();
            int pos = line.lastIndexOf(' ');

            if (pos <= 0 || pos == line.length() - 1) {
                throw new IllegalArgumentException(
                        "Некорректный формат строки №" + (i + 1));
            }

            String name = line.substring(0, pos).trim();
            int studentAge;

            try {
                studentAge = Integer.parseInt(
                        line.substring(pos + 1).trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(
                        "Некорректный возраст студента №" + (i + 1), e);
            }

            if (name.isEmpty() || studentAge < 0) {
                throw new IllegalArgumentException(
                        "Некорректное имя или возраст студента №" + (i + 1));
            }

            students.add(new Student(name, studentAge));
        }

        new StudentSort().sort(students);

        StringBuilder result = new StringBuilder();
        for (Student s : students) {
            result.append(s.getName())
                    .append(' ')
                    .append(s.getAge())
                    .append('\n');
        }

        System.out.print(result);
    }
}