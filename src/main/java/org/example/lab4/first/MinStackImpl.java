package org.example.lab4.first;
public class MinStackImpl implements MinStack<Integer> {

    private static class Node {
        int value;
        int min;
        Node next;

        Node(int value, int min, Node next) {
            this.value = value;
            this.min = min;
            this.next = next;
        }
    }

    private Node head;

    @Override
    public void push(Integer value) {
        if (value == null) {
            throw new IllegalArgumentException(
                    "Элемент не должен быть null"
            );
        }

        if (head == null) {
            head = new Node(value, value, null);
        } else {
            head = new Node(
                    value,
                    Math.min(value, head.min),
                    head
            );
        }
    }

    @Override
    public Integer pop() {
        if (head == null) {
            return null;
        }

        int value = head.value;
        head = head.next;

        return value;
    }

    @Override
    public Integer top() {
        if (head == null) {
            return null;
        }

        return head.value;
    }

    @Override
    public Integer min() {
        if (head == null) {
            return null;
        }

        return head.min;
    }
}

