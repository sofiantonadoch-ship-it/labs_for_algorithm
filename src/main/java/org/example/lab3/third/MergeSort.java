package org.example.lab3.third;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable<? super T>>
        implements Sorting<T> {

    @Override
    public void sort(List<T> nums) {
        if (nums == null) {
            throw new IllegalArgumentException(
                    "Список не должен быть null"
            );
        }

        for (T num : nums) {
            if (num == null) {
                throw new IllegalArgumentException(
                        "Элементы списка не должны быть null"
                );
            }
        }

        if (nums.size() < 2) {
            return;
        }

        List<T> temp = new ArrayList<>(nums);
        mergeSort(nums, temp, 0, nums.size() - 1);
    }

    private void mergeSort(
            List<T> nums,
            List<T> temp,
            int left,
            int right
    ) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(nums, temp, left, mid);
        mergeSort(nums, temp, mid + 1, right);

        merge(nums, temp, left, mid, right);
    }

    private void merge(
            List<T> nums,
            List<T> temp,
            int left,
            int mid,
            int right
    ) {
        for (int i = left; i <= right; i++) {
            temp.set(i, nums.get(i));
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp.get(i).compareTo(temp.get(j)) <= 0) {
                nums.set(k++, temp.get(i++));
            } else {
                nums.set(k++, temp.get(j++));
            }
        }

        while (i <= mid) {
            nums.set(k++, temp.get(i++));
        }

        while (j <= right) {
            nums.set(k++, temp.get(j++));
        }
    }
}