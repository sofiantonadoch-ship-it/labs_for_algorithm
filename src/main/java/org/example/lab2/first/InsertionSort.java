package org.example.lab2.first;
import java.util.List;
 public class InsertionSort implements Sorting<Integer> {
        @Override
        public void sort(List<Integer> nums) {
            for (int i = 1; i < nums.size(); i++) {
                Integer N = nums.get(i);
                int j = i - 1;

                // Сдвигаем элементы, которые больше N, вправо
                while (j >= 0 && nums.get(j).compareTo(N) > 0) {
                    nums.set(j + 1, nums.get(j));
                    j--;
                }

                // Вставляем N на нужное место
                nums.set(j + 1, N);
            }
        }
}
