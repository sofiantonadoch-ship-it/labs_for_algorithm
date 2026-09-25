package org.example.lab2.first;
import java.util.List;
public interface Sorting<T extends Comparable<T>> {
    void sort(List<T> nums);
}
