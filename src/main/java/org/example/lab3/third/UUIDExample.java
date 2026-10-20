package org.example.lab3.third;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class UUIDExample {
    public static void main(String[] args) {
        List<UUID> ids = Arrays.asList(
                UUID.fromString(
                        "ffffffff-ffff-ffff-ffff-ffffffffffff"
                ),
                UUID.fromString(
                        "00000000-0000-0000-0000-000000000001"
                ),
                UUID.fromString(
                        "12345678-1234-1234-1234-123456789abc"
                )
        );

        Sorting<UUID> sorting = new MergeSort<>();
        sorting.sort(ids);

        ids.forEach(System.out::println);
    }
}