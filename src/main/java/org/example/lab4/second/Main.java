package org.example.lab4.second;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueueImpl queue = new PriorityQueueImpl();

        while (scanner.hasNext()) {
            String command = scanner.next();

            switch (command) {
                case "enqueue": {
                    int value = scanner.nextInt();
                    queue.enqueue(value);
                    break;
                }

                case "dequeue-max": {
                    Integer value = queue.dequeueMax();

                    if (value == null) {
                        System.out.println("*");
                    } else {
                        System.out.println(
                                queue.getLastRemovedOperation() + " " + value
                        );
                    }
                    break;
                }

                case "inc": {
                    long operation = scanner.nextLong();
                    int addition = scanner.nextInt();

                    queue.increment(operation, addition);
                    break;
                }

                default:
                    throw new IllegalArgumentException(
                            "Неизвестная команда: " + command
                    );
            }
        }

        scanner.close();
    }
}
