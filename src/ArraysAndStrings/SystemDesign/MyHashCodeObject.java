package src.ArraysAndStrings.SystemDesign;

import java.util.Arrays;
import java.util.Objects;

public class MyHashCodeObject {
    private int id;
    private String name;
    private int[] data;

    public MyHashCodeObject(int id, String name, int[] data) {
        this.id = id;
        this.name = name;
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyHashCodeObject myHashCodeObject = (MyHashCodeObject) o;
        return id == myHashCodeObject.id && Objects.equals(name, myHashCodeObject.name) && Arrays.equals(data, myHashCodeObject.data);
    }

    @Override
    public int hashCode() {
        int result = 17; // Initial prime
        result = 31 * result + id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
    // Example Usage
    public static void main(String[] args) {
        MyHashCodeObject obj1 = new MyHashCodeObject(1, "Test", new int[]{1, 2, 3});
        MyHashCodeObject obj2 = new MyHashCodeObject(1, "Test", new int[]{1, 2, 3});
        MyHashCodeObject obj3 = new MyHashCodeObject(2, "Test", new int[]{1, 2, 3});
        System.out.println("obj1 hash: " + obj1.hashCode());
        System.out.println("obj2 hash: " + obj2.hashCode());
        System.out.println("obj3 hash: " + obj3.hashCode());
        System.out.println("obj1.equals(obj2): " + obj1.equals(obj2));
    }
}