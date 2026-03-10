package baitapluyen2;

import java.util.TreeSet;

public class Bai1 {
    public static void main(String[] args) {
        TreeSet<String> names = new TreeSet<>();
        names.add("John");
        names.add("Alice");
        names.add("Zack");
        names.add("Bob");

        System.out.println("Danh sách tên trong TreeSet: " + names);
        System.out.println("Phần tử đầu tiên (nhỏ nhất): " + names.first());
        System.out.println("Phần tử cuối cùng (lớn nhất): " + names.last());
    }
}