package com.datastructures;

import java.util.Iterator;
import java.util.LinkedList;

public class StringHashSet implements Iterable<String>{
    private int arraySize;
    private LinkedList<String>[] data;

    
    @SuppressWarnings("unchecked")
    public StringHashSet(int size) {
        arraySize = size;
        data = new LinkedList[size];

        for (int i = 0; i < size; i++) {
            data[i] = new LinkedList<>();
        }
    }

    public void add(String value) {
        data[getIndex(value)].addLast(value);
    }

    public Boolean contains(String value) {
        int index = getIndex(value);

        return data[index].contains(value);
    }

    private int getIndex(String value) {
        return Math.abs(value.hashCode()) % arraySize;
    }

    @Override
    public Iterator<String> iterator() {
        return new StringHashSetIterator();
    }

    private class StringHashSetIterator implements Iterator<String> {
        Integer current;
        Iterator<String> currentIt;

        @Override
        public boolean hasNext() {
            if (currentIt.hasNext())
                return true;

            for (int i = current+1;  i < arraySize; i++){
                if (!data[i].isEmpty()) {
                    return true;
                }
            }

            return false;
        }
        
        private void findNextIterator() {
            current++;

            while (data[current].isEmpty()) {
                if (current == arraySize - 1)
                    break;

                current++;
            }

            currentIt = data[current].iterator();
        }
        
        @Override
        public String next() {
            if (!currentIt.hasNext())
                findNextIterator();

            return currentIt.next(); 
        }
        
        public StringHashSetIterator() {
            current = 0;
            currentIt = data[current].iterator();
        }
    }
}