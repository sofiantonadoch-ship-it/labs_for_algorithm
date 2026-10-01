package org.example.lab3.second;
import java.math.BigInteger;
import java.util.List;
public class RadixSort implements Sorting<BigInteger>
 {
        @Override
        public void sort(List<BigInteger> nums) {
            if (nums == null || nums.size() < 2) {
                return;
            }

            int n = nums.size();
            BigInteger[] arr = nums.toArray(new BigInteger[0]);
            BigInteger[] buffer = new BigInteger[n];

            BigInteger max = arr[0];

            for (BigInteger x : arr) {
                if (x == null) {
                    throw new IllegalArgumentException("List contains null");
                }

                if (x.signum() < 0) {
                    throw new IllegalArgumentException(
                            "RadixSort supports only non-negative BigInteger values"
                    );
                }

                if (x.compareTo(max) > 0) {
                    max = x;
                }
            }

            BigInteger base = BigInteger.TEN;

            for (BigInteger exp = BigInteger.ONE;
                 exp.compareTo(max) <= 0;
                 exp = exp.multiply(base)) {

                int[] count = new int[10];

                for (BigInteger x : arr) {
                    int digit = x.divide(exp).mod(base).intValue();
                    count[digit]++;
                }

                for (int i = 1; i < 10; i++) {
                    count[i] += count[i - 1];
                }

                for (int i = n - 1; i >= 0; i--) {
                    int digit = arr[i].divide(exp).mod(base).intValue();
                    buffer[--count[digit]] = arr[i];
                }

                System.arraycopy(buffer, 0, arr, 0, n);
            }

            for (int i = 0; i < n; i++) {
                nums.set(i, arr[i]);
            }
        }
 }

