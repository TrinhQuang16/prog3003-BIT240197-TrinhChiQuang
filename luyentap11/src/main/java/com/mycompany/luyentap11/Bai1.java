package com.mycompany.luyentap11;

public class Bai1 {

  
    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
       
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.print("Mảng Integer: ");
        printArray(intArray);

        String[] stringArray = {"Java", "Generic", "Method"};
        System.out.print("Mảng String: ");
        printArray(stringArray);
    }
}