package org.example.lab2.second;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
interface Sorting<T> {
    void sort(List<T> nums);
}
public class Merge_sort {
    public static class MergeSort implements Sorting<Integer> {

        private void slice(List<Integer> nums, int start, int end) {
            if (start >= end) {
                return;
            }

            int middle = start + (end - start) / 2;

            slice(nums, start, middle);
            slice(nums, middle + 1, end);
            merge(nums, start, middle, end);
        }

        private void merge(List<Integer> nums, int start, int middle, int end) {
            List<Integer> left = new ArrayList<>(middle - start + 1);
            List<Integer> right = new ArrayList<>(end - middle);

            for (int i = start; i <= middle; i++) {
                left.add(nums.get(i));
            }

            for (int i = middle + 1; i <= end; i++) {
                right.add(nums.get(i));
            }

            int i = 0;
            int j = 0;
            int k = start;

            while (i < left.size() && j < right.size()) {
                if (left.get(i) <= right.get(j)) {
                    nums.set(k++, left.get(i++));
                } else {
                    nums.set(k++, right.get(j++));
                }
            }

            while (i < left.size()) {
                nums.set(k++, left.get(i++));
            }

            while (j < right.size()) {
                nums.set(k++, right.get(j++));
            }
        }

        @Override
        public void sort(List<Integer> nums) {
            if (nums == null || nums.size() < 2) {
                return;
            }

            slice(nums, 0, nums.size() - 1);
        }
    }

    class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            if (!sc.hasNextInt()) {
                return;
            }

            int n = sc.nextInt();

            if (n < 1 || n > 100_000) {
                throw new IllegalArgumentException(
                        "N должно быть от 1 до 100000"
                );
            }

            List<Integer> nums = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                int value = sc.nextInt();

                if (Math.abs((long) value) > 1_000_000_000L) {
                    throw new IllegalArgumentException(
                            "Элемент массива выходит за допустимый диапазон"
                    );
                }

                nums.add(value);
            }

            new MergeSort().sort(nums);

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < nums.size(); i++) {
                if (i > 0) {
                    sb.append(' ');
                }

                sb.append(nums.get(i));
            }

            System.out.println(sb);
        }
    }
}
