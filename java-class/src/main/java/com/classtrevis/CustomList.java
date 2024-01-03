package com.classtrevis;

public class CustomList<T> {
    private Object dataArray[];
    private int count;

    public CustomList() {
        count = 0;

        dataArray = new Object[10];
    }

    public void add(T value){   
        if (count == dataArray.length) {
            Object nArray[] = new Object[2 * dataArray.length];
            
            for (int i = 0; i < count; i++) {
                nArray[i] = dataArray[i];
            }

            dataArray = nArray;
        }

        dataArray[count++] = value;
    }

    public T get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }

        if (dataArray[index].getClass() == T)

        return (T)dataArray[index];
    }


}