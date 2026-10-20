package org.example.lab3.third;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private final String name;
    private final int age;

    public Student(String name, int age) {
        if (name == null) {
            throw new IllegalArgumentException(
                    "Имя студента не должно быть null"
            );
        }

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Student other) {
        int result = this.name.compareTo(other.name);

        if (result != 0) {
            return result;
        }

        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Student)) {
            return false;
        }

        Student other = (Student) obj;
        return age == other.age
                && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}