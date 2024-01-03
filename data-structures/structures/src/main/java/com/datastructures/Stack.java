package com.datastructures;

@SuppressWarnings("unchecked")

public class Stack<E> {
    ArrList<E> data;

    public Stack() {
        data = new ArrList<>();
    }

    public Boolean empty() {
        return data.isEmpty();
    }

    public E peek() {
        return data.get(data.size() - 1);
    }

    public E pop() {
        return data.remove(data.size() - 1);
    }

    public void push(E item) {
        data.add(item);
    }

    public int search(Object o) {
        int listIndex = data.indexOf((E)o);

        return data.size() - listIndex;
    }
}
