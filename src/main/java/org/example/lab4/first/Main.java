package org.example.lab4.first;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        MinStackImpl stack = new MinStackImpl();
        StringBuilder output = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            line = line.trim();

            if (line.isEmpty()) {
                continue;
            }

            if (line.equals("pop")) {
                stack.pop();

            } else if (line.equals("top")) {
                output.append(stack.top()).append('\n');

            } else if (line.equals("min")) {
                output.append(stack.min()).append('\n');

            } else if (line.startsWith("push ")) {
                String valueStr = line.substring(5).trim();

                try {
                    int value = Integer.parseInt(valueStr);
                    stack.push(value);
                } catch (NumberFormatException e) {
                    System.err.println(
                            "Ошибка: после push необходимо указать целое число"
                    );
                }
            }
        }

        System.out.print(output);
    }
}

