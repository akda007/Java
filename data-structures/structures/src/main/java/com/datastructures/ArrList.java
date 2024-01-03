package com.datastructures;

import java.util.Comparator;

@SuppressWarnings("unchecked")

public class ArrList<T> {
    private int count;
    private Object[] arr;

    public ArrList() {
        count = 0;
        arr = new Object[10];
    }

    public Comparator<T> getComparator() {
        if (Integer.class.isAssignableFrom((Class<?>)arr[0].getClass())) {
            return (Comparator<T>)Comparator.naturalOrder();
        } else if (String.class.isAssignableFrom((Class<?>)arr[0].getClass())) {
            return (Comparator<T>)Comparator.naturalOrder();
        }

        return null;
    }

    public void add(T value) {
        if (count == arr.length) {
            Object[] newArr = new Object[2 * arr.length];

            for (int i = 0; i < arr.length; i++)
                newArr[i] = arr[i];

            arr = newArr;
        }

        arr[count] = value;
        count++;
    }

    public int size() {
        return count;
    }

    public T get(int index) {
        if (index >= 0 && index < count)
            return (T) arr[index];

        throw new IndexOutOfBoundsException();
    }

    public void set(int index, T value) {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException();

        arr[index] = value;
    }

    public void clear() {
        count = 0;
        arr = new Object[1];
    }

    public Boolean isEmpty() {
        return count == 0;
    }

    public Boolean contains(T value) {
        for (int i = 0; i < count; i++) {
            if (arr[i].equals(value))
                return true;
        }

        return false;
    }

    public int indexOf(T value) {
        for (int i = 0; i < count; i++) {
            if (arr[i].equals(value))
                return i;
        }

        return -1;
    }

    public ArrList<T> clone() {
        ArrList<T> copy = new ArrList<T>();

        copy.count = this.count;
        copy.arr = new Object[this.arr.length];
        for (int i = 0; i < count; i++)
            copy.arr[i] = this.arr[i];

        return copy;
    }

    public T remove(int index) {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException();
        var removedValue = arr[index];

        for (int i = index + 1; i < count; i++) {
            arr[i - 1] = arr[i];
        }
        count--;

        return (T) removedValue;
    }

    public void remove(T value) {
        int index = indexOf(value);
        if (index == -1)
            return;
        remove(index);
    }

    public void bubbleSort(Comparator<T> comparator) {
        if (comparator == null) return;

        boolean unsorted = true;
        while (unsorted) {
            unsorted = false;

            for (int i = 0; i < count - 1; i++) {

                if (comparator.compare((T) arr[i], (T) arr[i+1]) > 0) {
                    Object tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;

                    unsorted = true;
                }

            }

        }

    }

    private void merge(Comparator<T> comp, Object[] arr, Object[] tmp, int l, int m, int r){
        int i = l, j = m, k = l;

        while(i < m && j < r) {
            int res = comp.compare((T)arr[i], (T)arr[j]);

            if (res < 0) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }

        while (i < m) 
            tmp[k++] = arr[i++];

        while (j < r)
            tmp[k++] = arr[j++];

        for (i = l; i < r; i++) {
            arr[i] = tmp[i];
        }
    }


    private void mSort(Comparator<T> comparator, Object[] arr, Object[] tmp, int l, int r) {
        if (comparator == null || r - l < 2) return;

        if (l < r) {
            int m = (l + r) / 2;

            mSort(comparator, arr, tmp, l, m);
            mSort(comparator, arr, tmp, m, r);
            merge(comparator, arr, tmp, l, m, r);
        }
    }

    public void mergeSort(Comparator<T> comparator) {
        Object []tmp = new Object[count];
        mSort(comparator, this.arr, tmp, 0, count);
    }

}
