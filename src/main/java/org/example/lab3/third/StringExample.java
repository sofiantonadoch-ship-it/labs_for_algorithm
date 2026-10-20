package org.example.lab3.third;
import java.util.Arrays;
import java.util.List;

public class StringExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "Orange", "Apple", "Banana", "Cherry"
        );

        Sorting<String> sorting = new MergeSort<>();
        sorting.sort(words);

        System.out.println(words);
        // [Apple, Banana, Cherry, Orange]
    }
}