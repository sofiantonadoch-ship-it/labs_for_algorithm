package org.example.lab2.first;
import java.util.List;
 public class InsertionSort implements Sorting<Integer> {
        @Override
        public void sort(List<Integer> nums) {
            for (int i = 1; i < nums.size(); i++) {
                Integer N = nums.get(i);
                int j = i - 1;
                while (j >= 0 && nums.get(j).compareTo(N) > 0) {
                    nums.set(j + 1, nums.get(j));
                    j--;
                }
                nums.set(j + 1, N);
            }
        }
}
