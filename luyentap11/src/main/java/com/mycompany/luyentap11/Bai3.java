package com.mycompany.luyentap11;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }
}

public class Bai3 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Anh", 1200),
            new Employee(2, "Bình", 800),
            new Employee(3, "Dũng", 1500),
            new Employee(4, "Cường", 950)
        );

        List<String> resultNames = employees.stream()
            .filter(e -> e.getSalary() > 1000)      
            .map(Employee::getName)                
            .sorted()                              
            .collect(Collectors.toList());         

        System.out.println("Danh sách nhân viên lương > 1000 (đã sắp xếp):");
        resultNames.forEach(System.out::println);
    }
}
