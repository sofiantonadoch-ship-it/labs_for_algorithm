package org.example.lab6.third;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число a от 1.0 до 10.0");
        System.out.println("Допускается не более 10 знаков после точки:");
        String input = scanner.next();
        if (!input.matches("\\d+(\\.\\d{1,10})?")) {
            System.out.println("Ошибка: неправильный формат числа");
            return;
        }
        double a = Double.parseDouble(input);
        if (a < 1.0 || a > 10.0) {
            return;
        }
        double left = 0.0;
        double right = 4.0;
        double eps = 1e-7;
        while (right - left > eps) {
            double mid = left + (right - left) / 2.0;
            double result = mid * mid - mid + Math.sqrt(mid);
            if (result < a) {
                left = mid;
            } else {
                right = mid;
            }
        }
        double x = (left + right) / 2.0;
        System.out.printf("%.6f%n", x);
        scanner.close();
    }
}

