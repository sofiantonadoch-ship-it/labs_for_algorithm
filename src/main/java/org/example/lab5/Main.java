package org.example.lab5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMapImpl<String> map = new HashMapImpl<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] parts = line.split(" ");
            String command = parts[0];
            String key = parts[1];
            switch (command) {
                case "put":
                    String value = parts[2];
                    map.put(key, value);
                    break;
                case "get":
                    System.out.println(map.getValue(key));
                    break;
                case "delete":
                    map.delete(key);
                    break;
            }
        }
        scanner.close();
    }
}

