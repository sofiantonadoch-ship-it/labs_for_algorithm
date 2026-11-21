package org.example.lab8.second;
public class SegmentTreeImpl implements SegmentTree {
    private int[] tree;
    private int size;
    @Override
    public void build(int[] array) {
        int n = array.length;
        size = 1;
        while (size < n) {
            size *= 2;
        }
        tree = new int[2 * size];
        for (int i = 0; i < n; i++) {
            tree[size + i] = array[i];
        }
        for (int i = n; i < size; i++) {
            tree[size + i] = Integer.MAX_VALUE;
        }
        for (int i = size - 1; i >= 1; i--) {
            tree[i] = Math.min(
                    tree[2 * i],
                    tree[2 * i + 1]
            );
        }
    }
    @Override
    public int query(int left, int right) {
        left += size;
        right += size;
        int result = Integer.MAX_VALUE;
        while (left < right) {
            if (left % 2 == 1) {
                result = Math.min(result, tree[left]);
                left++;
            }
            if (right % 2 == 1) {
                right--;
                result = Math.min(result, tree[right]);
            }
            left /= 2;
            right /= 2;
        }
        return result;
    }
}

