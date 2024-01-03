package com.datastructures;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrList<String> strList = new ArrList<>();
        ArrList<Integer> intList = new ArrList<>();

        strList.add("Joao");
        strList.add("Andrey");
        
        intList.add(240);
        intList.add(510);
        intList.add(450);
        intList.add(240);
        intList.add(440);
        intList.add(40);


        strList.bubbleSort(strList.getComparator());
        intList.mergeSort((a, b) -> a > b ? 1 : a == b ? 0 : -1);

        for (int i = 0; i < strList.size(); i++) {
            System.out.println(strList.get(i));
        }

        for (int i = 0; i < intList.size(); i++) {
            System.out.println(intList.get(i));
        }

    }
}