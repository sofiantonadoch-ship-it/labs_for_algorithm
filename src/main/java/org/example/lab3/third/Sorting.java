package org.example.lab3.third;

import java.util.List;

public interface Sorting<T extends Comparable<? super T>> {
    void sort(List<T> nums);
}