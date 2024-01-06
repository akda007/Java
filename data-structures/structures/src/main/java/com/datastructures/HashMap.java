package com.datastructures;

import java.util.Iterator;
import java.util.LinkedList;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

public class HashMap<V> implements Iterable<KeyValuePair<V>>{
    private static final double loadFactor = 0.75;
    private int arraySize, count;
    private LinkedList<KeyValuePair<V>>[] data;

    
    @SuppressWarnings("unchecked")
    public HashMap(int size) {
        count = 0;
        arraySize = size;
        data = new LinkedList[arraySize];

        for (int i = 0; i < arraySize; i++) {
            data[i] = new LinkedList<>();
        }
    }

    public HashMap() {
        this(10);
    }

    private Boolean tooLoaded() {
        return (double)count / (double)arraySize > loadFactor;
    }

    private void resize() {
        HashMap<V> newMap = new HashMap<>(arraySize * 2);

        for (KeyValuePair<V> pair : this) {
            newMap.add(pair.key, pair.value);
        }
        
        this.data = newMap.data;
        this.arraySize = newMap.arraySize;
    }
    
    public void add(String key, V value) {
        if (contains(key))
            throw new IllegalArgumentException();

        if (tooLoaded())
            resize();

        KeyValuePair<V> pair = new KeyValuePair<>(key, value);

        data[getIndex(key)].addLast(pair);
        count++;
    }

    private KeyValuePair<V> findPair(String key) {
        int index = getIndex(key);

        for (KeyValuePair<V> pair : data[index]) {
            if (key.equals(pair.key))
                return pair;
        }

        return null;
    }

    public V get(String key) {
        return findPair(key).value;
    }

    public Boolean contains(String key) {
        return findPair(key) != null;
    }

    private int getIndex(String value) {
        return Math.abs(value.hashCode()) % arraySize;
    }

    @Override
    public Iterator<KeyValuePair<V>> iterator() {
        return new StringHashSetIterator();
    }

    private class StringHashSetIterator implements Iterator<KeyValuePair<V>> {
        Integer current;
        Iterator<KeyValuePair<V>> currentIt;

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
        public KeyValuePair<V> next() {
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
