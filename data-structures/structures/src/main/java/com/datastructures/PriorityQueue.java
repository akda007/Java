package com.datastructures;

import java.util.Comparator;
import java.util.Iterator;


public class PriorityQueue<E> extends LinkedList<E>{
    private Comparator<E> cmp;
    
    public PriorityQueue(Comparator<E> comparator) {
        super();

        cmp = comparator;
    }

    public void add(E value) {
        if (super.size() == 0) {
            super.add(value);
            return;
        }

        Iterator<E> it = super.iterator();

        int index = 0;
        while (it.hasNext()) {
            E nextValue = it.next();

            if (cmp.compare(value, nextValue) < 0) {
                break;
            }

            index++;
        }

        super.add(index, value);
    }

    public E peek() {
        return super.getLast(); 
    } 

    public E pool() {
        return super.removeLast();
    }

    public int size() {
        return super.size();
    }
}
