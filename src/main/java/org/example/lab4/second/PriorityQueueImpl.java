package org.example.lab4.second;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class PriorityQueueImpl implements PriorityQueue<Integer> {

    private static class Node {
        int value;
        long operation;

        Node(int value, long operation) {
            this.value = value;
            this.operation = operation;
        }
    }

    private final List<Node> heap = new ArrayList<>();
    private final Map<Long, Integer> positions = new HashMap<>();

    private long operationCounter = 0;
    private long lastRemovedOperation = -1;

    @Override
    public void enqueue(Integer value) {
        if (value == null) {
            throw new IllegalArgumentException("Значение не должно быть null");
        }

        operationCounter++;

        Node node = new Node(value, operationCounter);
        heap.add(node);

        int index = heap.size() - 1;
        positions.put(node.operation, index);

        siftUp(index);
    }

    @Override
    public Integer dequeueMax() {
        if (heap.isEmpty()) {
            lastRemovedOperation = -1;
            return null;
        }

        Node max = heap.get(0);
        lastRemovedOperation = max.operation;

        positions.remove(max.operation);

        int lastIndex = heap.size() - 1;
        Node last = heap.remove(lastIndex);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            positions.put(last.operation, 0);
            siftDown(0);
        }

        return max.value;
    }

    @Override
    public void increment(long operation, Integer addition) {
        if (addition == null) {
            throw new IllegalArgumentException("Прибавляемое значение не должно быть null");
        }

        Integer index = positions.get(operation);

        // Элемент уже извлечён или такой вставки нет.
        if (index == null) {
            return;
        }

        Node node = heap.get(index);
        node.value += addition;

        // Если значение увеличилось, элемент поднимается вверх.
        siftUp(index);
    }

    public long getLastRemovedOperation() {
        return lastRemovedOperation;
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;

            if (heap.get(parent).value >= heap.get(index).value) {
                break;
            }

            swap(parent, index);
            index = parent;
        }
    }

    private void siftDown(int index) {
        int size = heap.size();

        while (true) {
            int largest = index;
            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (left < size
                    && heap.get(left).value > heap.get(largest).value) {
                largest = left;
            }

            if (right < size
                    && heap.get(right).value > heap.get(largest).value) {
                largest = right;
            }

            if (largest == index) {
                break;
            }

            swap(index, largest);
            index = largest;
        }
    }

    private void swap(int i, int j) {
        Node first = heap.get(i);
        Node second = heap.get(j);

        heap.set(i, second);
        heap.set(j, first);

        positions.put(first.operation, j);
        positions.put(second.operation, i);
    }
}

