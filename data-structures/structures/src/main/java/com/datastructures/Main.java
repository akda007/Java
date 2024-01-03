package com.datastructures;

import java.util.Comparator;

import com.datastructures.LinkedList.ListNode;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("Teste");
        list.add("Teste2");
        list.add("Teste3");
        list.addFirst("primeiro");

        list.removeLast();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.getItem(i));
        }
    }
}