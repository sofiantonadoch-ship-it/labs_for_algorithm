package org.example.lab6.second;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long w = scanner.nextLong();
        long h = scanner.nextLong();
        if (n < 1 || n > 1_000_000_000L ||
                w < 1 || w > 1_000_000_000L ||
                h < 1 || h > 1_000_000_000L)
        {
            throw new IllegalArgumentException(
                    "Значения n, w и h должны находиться в диапазоне от 1 до 10^9"
            );
        }
        long left = Math.max(w, h);
        long right = n * Math.max(w, h);
        while (left < right) {
            long mid = left + (right - left) / 2;
            long countW = mid / w;
            long countH = mid / h;
            if (countW >= (n + countH - 1) / countH) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }
}
