package org.example.lab7.first;
public class Game {
    public static void showMap(int[][] map) {
        System.out.println("=== ИГРОВАЯ КАРТА ===");
        for (int[] row : map) {
            for (int value : row) {
                System.out.printf("%5d", value);
            }
            System.out.println();
        }
    }
    public static void play(int[][] map, String path) {
        int i = 0;
        int j = 0;
        int balance = 0;
        System.out.println("\n=== ПУТЕШЕСТВИЕ ===");
        System.out.println("Начальная позиция: А");
        balance += map[i][j];
        showEvent(map[i][j], balance);
        for (int k = 0; k < path.length(); k++) {
            char step = path.charAt(k);
            if (step == 'R') {
                j++;
            } else if (step == 'D') {
                i++;
            }
            int value = map[i][j];
            balance += value;
            System.out.println("\nШаг " + (k + 1) + ": " + step);
            showEvent(value, balance);
        }
        System.out.println("\nПутешественник добрался до города Б!");
        System.out.println("Итоговый баланс: " + balance);
    }
    private static void showEvent(int value, int balance) {
        if (value > 0) {
            System.out.println(
                    "Нашли сундук! Заработали " + value + " монет."
            );
        } else if (value < 0) {
            System.out.println(
                    "Встретили разбойников! Потеряли "
                            + Math.abs(value) + " монет."
            );
        } else {
            System.out.println(
                    "Дорога чиста, продолжим путь."
            );
        }
        System.out.println("Игровой баланс: " + balance);
    }
}

