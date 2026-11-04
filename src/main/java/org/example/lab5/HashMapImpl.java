package org.example.lab5;
import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImpl<V> implements HashMap<String, V> {
    private static final int TABLE_SIZE = 300007;
    private static final int A = 31;
    private static class Entry<V> {
        String key;
        V value;

        Entry(String key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private final ArrayList<LinkedList<Entry<V>>> table;

    public HashMapImpl() {
        table = new ArrayList<>(TABLE_SIZE);

        // Создаём пустые списки для каждой ячейки
        for (int i = 0; i < TABLE_SIZE; i++) {
            table.add(new LinkedList<>());
        }
    }
    private long hashByString(String value) {
        long hash = 0;

        for (char ch : value.toCharArray()) {
            hash = (hash * A + ch) % TABLE_SIZE;
        }

        return hash;
    }
    @Override
    public void put(String key, V value) {

        int index = (int) hashByString(key);

        LinkedList<Entry<V>> list = table.get(index);

        // Проверяем, существует ли ключ
        for (Entry<V> entry : list) {
            if (entry.key.equals(key)) {
                // Если существует, обновляем значение
                entry.value = value;
                return;
            }
        }

        // Если ключа нет, добавляем новую пару
        list.add(new Entry<>(key, value));
    }
    @Override
    public V getValue(String key) {

        int index = (int) hashByString(key);

        LinkedList<Entry<V>> list = table.get(index);

        for (Entry<V> entry : list) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }
    @Override
    public V delete(String key) {

        int index = (int) hashByString(key);

        LinkedList<Entry<V>> list = table.get(index);

        for (int i = 0; i < list.size(); i++) {

            Entry<V> entry = list.get(i);

            if (entry.key.equals(key)) {
                V deletedValue = entry.value;

                list.remove(i);

                return deletedValue;
            }
        }

        return null;
    }
}
