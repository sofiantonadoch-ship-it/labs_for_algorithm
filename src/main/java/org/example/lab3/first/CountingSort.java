package org.example.lab3.first;
import java.util.List;
public class CountingSort implements Sorting<Integer> {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 127;
    private static final int MAX_SIZE = 200_000;
    @Override
    public void sort(List<Integer> nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Список не должен быть пустой");
        }

        if (nums.isEmpty() || nums.size() > MAX_SIZE) {
            throw new IllegalArgumentException(
                    "Количество элементов должно быть от 1 до 200000"
            );
        }

        int[] count = new int[MAX_VALUE + 1];

        for (Integer num : nums) {
            if (num == null) {
                throw new IllegalArgumentException(
                        "Элементы списка не должны быть пусты"
                );
            }

            if (num < MIN_VALUE || num > MAX_VALUE) {
                throw new IllegalArgumentException(
                        "Элементы должны быть в диапазоне от 0 до 127"
                );
            }

            count[num]++;
        }

        int index = 0;

        for (int value = MIN_VALUE; value <= MAX_VALUE; value++) {
            for (int i = 0; i < count[value]; i++) {
                nums.set(index++, value);
            }
        }
    }
}