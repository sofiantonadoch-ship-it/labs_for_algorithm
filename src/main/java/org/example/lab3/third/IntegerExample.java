package org.example.lab3.third;
import java.util.Arrays;
import java.util.List;

public class IntegerExample {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(5, 2, 8, 1, 3);

        Sorting<Integer> sorting = new MergeSort<>();
        sorting.sort(nums);

        System.out.println(nums);
    }
}