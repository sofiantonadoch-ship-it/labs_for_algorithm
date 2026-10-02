package org.example.lab2.first;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 public class Main {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();

            if (n < 1 || n > 100_000) {
                throw new IllegalArgumentException("N должно быть от 1 до 100000");
            }

            List<Integer> nums = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();

                if (Math.abs((long) x) > 1_000_000_000L) {
                    throw new IllegalArgumentException(
                            "Элемент по модулю не должен превосходить 10^9"
                    );
                }

                nums.add(x);
            }

            Sorting<Integer> sorter = new InsertionSort();
            sorter.sort(nums);
            StringBuilder out = new StringBuilder();

            for (int i = 0; i < nums.size(); i++) {
                if (i > 0) {
                    out.append(' ');
                }
                out.append(nums.get(i));
            }

            System.out.println(out);
        }
 }
