package com.classtrevis;

public class Main {
    public static void main(String[] args) {
        int arr[] = {3, 4, 5};

        arr = new int[4];

        arr[3] = 1;

        for (Object i : arr) {
            System.out.println(i);
        }
    }
}