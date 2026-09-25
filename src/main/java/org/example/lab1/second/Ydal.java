package org.example.lab1.second;
public class Ydal {
    public int removeElementInPlace(int[] arr, int val)
    {
        if (arr == null)
        {
            throw new IllegalArgumentException("нет последовательности для проверки!");
        }
        if (arr.length == 0 || arr.length > 100)
        {
            throw new IllegalArgumentException("длина не соответствует требованиям");
        }
        if (val < 0 || val > 100) {
            throw new IllegalArgumentException("значение для удаления не соответствует требованиям");
        }
        for (int j : arr) {
            if (j < 0 || j > 50) {
                throw new IllegalArgumentException(
                        "значение элемента массива не соответствует требованиям"
                );
            }
        }
        int k = 0;
        for (int x : arr)
        {
            if (x != val)
            {
                arr[k++] = x;
            }
        }
        return k;
    }
}
