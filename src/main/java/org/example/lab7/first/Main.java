package org.example.lab7.first;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
public class Main {
    private static final String INPUT_FILE = "roguelike-input.csv";
    private static final String OUTPUT_FILE = "roguelike-output.txt";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("=== РОГАЛИК ===");
        while (running) {
            System.out.println("\n=== ГЛАВНОЕ МЕНЮ ===");
            System.out.println("1. Начать игру");
            System.out.println("2. Сгенерировать новую карту");
            System.out.println("3. Выйти из игры");
            System.out.print("Выберите действие: ");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    if (!Files.exists(Paths.get(INPUT_FILE))) {
                        System.out.println(
                                "Карта не найдена. Сначала создайте новую карту."
                        );
                        break;
                    }
                    startGame();
                    break;
                case "2":
                    try {
                        MapGenerator.generate(INPUT_FILE);
                        startGame();
                    } catch (IOException | IllegalArgumentException e) {
                        System.out.println(
                                "Ошибка: " + e.getMessage()
                        );
                    }
                    break;
                case "3":

                    System.out.println("Спасибо за игру!");
                    running = false;

                    break;
                default:
                    System.out.println(
                            "Неверный выбор. Введите число от 1 до 3."
                    );
            }
        }
        scanner.close();
    }
    private static void startGame() {
        try {
            int[][] map = MapReader.read(INPUT_FILE);
            System.out.println("\n=== ИГРОВАЯ КАРТА ===");
            Game.showMap(map);
            int[][] dp = PathFinder.findMaxCoins(map);
            String path = PathFinder.restorePath(dp);
            int maxCoins = dp[map.length - 1][map[0].length - 1];
            Game.play(map, path);
            ResultWriter.save(
                    OUTPUT_FILE,
                    maxCoins,
                    path
            );
            System.out.println("\n=== РЕЗУЛЬТАТ ИГРЫ ===");
            ResultWriter.read(OUTPUT_FILE);
        } catch (IOException | IllegalArgumentException e) {
            System.out.println(
                    "Не удалось запустить игру: " + e.getMessage()
            );
        }
    }
}

