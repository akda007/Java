package com.datastructures;

import java.util.Comparator;

public class PriorityQueue<E> {
    private LinkedList<E> queue;
    private Comparator<E> cmp;
    
    public PriorityQueue(Comparator<E> comparator) {
        queue = new LinkedList<>();
        cmp = comparator;
    }

    public void add(E value) {
        if (queue.size() == 0) {
            queue.add(value);
            return;
        }

        int index = 0;
        while (cmp.compare(value, queue.get(index)) >= 0){
            index++;
            if (index == queue.size()) break;
        }

        queue.add(index, value);
    }

    public E peek() {
        return queue.getLast(); 
    } 

    public E pool() {
        return queue.removeLast();
    }

    public int size() {
        return queue.size();
    }
}
