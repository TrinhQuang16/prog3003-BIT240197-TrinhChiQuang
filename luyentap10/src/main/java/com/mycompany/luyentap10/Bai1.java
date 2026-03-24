package com.mycompany.luyentap10;

import java.util.HashMap;

public class Bai1 {
    public static void main(String[] args) {
        
        HashMap<Integer, String> employees = new HashMap<>();

        employees.put(101, "Anna");
        employees.put(102, "Peter");
        employees.put(103, "Mary");

        System.out.println("Nhân viên ID 102: " + employees.get(102));

        if (!employees.containsKey(105)) {
            employees.put(105, "Unknown");
            System.out.println("Đã thêm nhân viên 105.");
        }
        
        System.out.println("Danh sách nhân viên: " + employees);
    }
}
