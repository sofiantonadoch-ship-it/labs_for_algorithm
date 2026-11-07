package org.example.lab6.first;
public class ApproximateSearchImpl implements ApproximateSearch {
    @Override
    public int findClosest(int[] array, int target) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException(
                    "Массив не должен быть пустым или null"
            );
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return array[mid];
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right < 0) {
            return array[0];
        }
        if (left >= array.length) {
            return array[array.length - 1];
        }
        long leftDistance = Math.abs((long) target - array[right]);
        long rightDistance = Math.abs((long) array[left] - target);
        if (leftDistance <= rightDistance) {
            return array[right];
        } else {
            return array[left];
        }
    }
}