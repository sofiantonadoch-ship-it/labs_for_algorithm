package org.example.lab2.third;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
 public class Main {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String firstLine = br.readLine();
            if (firstLine == null) {
                return;
            }

            int n = Integer.parseInt(firstLine.trim());

            if (n < 1 || n > 100000) {
                throw new IllegalArgumentException("число может быть от 1 до 100000");
            }

            List<Student> students = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }

                line = line.trim();

                int lastSpace = line.lastIndexOf(' ');
                String name = line.substring(0, lastSpace).trim();
                int age = Integer.parseInt(line.substring(lastSpace + 1).trim());

                students.add(new Student(name, age));
            }

            new StudentSort().sort(students);

            StringBuilder sb = new StringBuilder();
            for (Student student : students) {
                sb.append(student.getName())
                        .append(' ')
                        .append(student.getAge())
                        .append('\n');
            }

            System.out.print(sb);
        }
 }

