package com.datastructures;

import java.util.Iterator;

public class LinkedList<E>  implements Iterable<E>{
    private ListNode<E> head;
    private ListNode<E> last;

    private int count = 0;
    
    public class ListNode<T>{
        ListNode<T> next;
        T item;

        public ListNode(T listItem) {
           item = listItem;     
        }
    }

    public class LinkedListIterator<T> implements Iterator<T> {
        private ListNode<T> current;
        private ListNode<T> first;

        @Override
        public boolean hasNext() {
            if (first == null)
                return false;

            if (current == null)
                return true;

            return current.next != null;
        }

        @Override
        public T next() {
            if (current == null) {
                current = first;
                return first.item;
            }

            current = current.next;
            return current.item;
        }

        public LinkedListIterator(ListNode<T> first) {
            this.first = first;
        }

    }

    private ListNode<E> createNode(E item) {
        return new ListNode<E>(item);
    }

    private ListNode<E> getNodeAt(int index) {
        ListNode<E> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    public void add(int index, E item) {
        ListNode<E> newNode = createNode(item);

        if (index == 0) {
            addFirst(item);
            return;
        }

        count++;

        ListNode<E> previousNode = getNodeAt(index - 1);
        ListNode<E> nextNode = previousNode.next;
        
        previousNode.next = newNode;
        newNode.next = nextNode;

        if (newNode.next == null) {
            last = newNode;
        }
    }
    
    public void add(E item) {
        ListNode<E> node = createNode(item);
        count++;

        //primeiro elemetno
        if (head == null) {
            head = node;
            last = head;
            return;
        }
        
        last.next = node;
        last = node;
    }

    public E get(int index) {
        return getNodeAt(index).item;
    }

    public E getFirst() {
        return head.item;
    }

    public E getLast() {
        return last.item;
    }

    public void addFirst(E item) {
        count++;

        ListNode<E> node = createNode(item);

        node.next = head;
        head = node;
    }

    public E removeFirst() {
        count--;

        E value = head.item;
        head = head.next;

        return value;            
    }

    public E removeLast() {
        E value = last.item;

        ListNode<E> previous = getNodeAt(count-2);

        last = previous;
        previous.next = null;

        count--;
        return value;                
    }

    public E remove(int index) {
        count--;

        ListNode<E> previous = getNodeAt(index - 1);
        ListNode<E> current = previous.next;

        E value = current.item;

        previous.next = current.next;
        current = null;

        return value;
    }

    public int size() {
        return count;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator<E>(head);
    }
}
