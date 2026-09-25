package org.example.lab2.third;
import java.util.List;
import java.util.Random;
 public class StudentSort implements Sorting<Student> {
        private final Random random = new Random();

        @Override
        public void sort(List<Student> students) {
            if (students == null || students.size() < 2) {
                return;
            }
            quickSortByAge(students, 0, students.size() - 1);
            stableMergeSortByName(students);
        }
        private void quickSortByAge(List<Student> a, int lo, int hi) {
            if (lo >= hi) {
                return;
            }

            int pivotAge = a.get(lo + random.nextInt(hi - lo + 1)).getAge();

            int lt = lo;
            int i = lo;
            int gt = hi;

            while (i <= gt) {
                int age = a.get(i).getAge();

                if (age < pivotAge) {
                    swap(a, lt++, i++);
                } else if (age > pivotAge) {
                    swap(a, i, gt--);
                } else {
                    i++;
                }
            }

            quickSortByAge(a, lo, lt - 1);
            quickSortByAge(a, gt + 1, hi);
        }

        private void swap(List<Student> a, int i, int j) {
            Student tmp = a.get(i);
            a.set(i, a.get(j));
            a.set(j, tmp);
        }
        private void stableMergeSortByName(List<Student> a) {
            Student[] tmp = new Student[a.size()];
            mergeSortByName(a, tmp, 0, a.size() - 1);
        }

        private void mergeSortByName(List<Student> a, Student[] tmp, int left, int right) {
            if (left >= right) {
                return;
            }

            int mid = (left + right) >>> 1;

            mergeSortByName(a, tmp, left, mid);
            mergeSortByName(a, tmp, mid + 1, right);

            int i = left;
            int j = mid + 1;
            int k = left;

            while (i <= mid && j <= right) {
                if (a.get(i).getName().compareTo(a.get(j).getName()) <= 0) {
                    tmp[k++] = a.get(i++);
                } else {
                    tmp[k++] = a.get(j++);
                }
            }

            while (i <= mid) {
                tmp[k++] = a.get(i++);
            }

            while (j <= right) {
                tmp[k++] = a.get(j++);
            }

            for (int p = left; p <= right; p++) {
                a.set(p, tmp[p]);
            }
        }
    }
