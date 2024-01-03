package com.datastructures;

public class LinkedList<E> {
    private ListNode<E> head;
    private ListNode<E> last;

    private int count = 0;
    
    public static class ListNode<E>{
        E item;
        ListNode<E> next;

        public ListNode(E listItem) {
           item = listItem;     
        }
    }

    private ListNode<E> createNode(E item) {
        return new ListNode<E>(item);
    }
    
    public void add(E item) {
        ListNode<E> node = createNode(item);
        count++;

        if (head == null) {
            head = node;
            last = head;
            return;
        }
        
        last.next = node;
        last = node;
    }

    private ListNode<E> getNodeAt(int index) {
        ListNode<E> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    public E getItem(int index) {
        return getNodeAt(index).item;
    }

    public E getFirst() {
        return head.item;
    }

    public E getLast() {
        return last.item;
    }

    public void insertAt(int index, E item) {
        ListNode<E> node = getNodeAt(index - 1);
        ListNode<E> nodeNext = node.next;
        
        node.next = createNode(item);
        node.next.next = nodeNext;
        count++;
    }

    public void addFirst(E item) {
        ListNode<E> node = createNode(item);

        node.next = head;
        head = node;

        count++;
    }

    public E removeFirst() {
        E value = head.item;

        head = head.next;
        count--;

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

    public E removeAt(int index) {
        ListNode<E> current = getNodeAt(index);
        ListNode<E> previous = getNodeAt(index - 1);

        E value = current.item;

        previous.next = current.next;
        current = null;

        count--;

        return value;
    }

    public int size() {
        return count;
    }
}
