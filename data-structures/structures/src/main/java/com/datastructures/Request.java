package com.datastructures;

public class Request {
    private String value;
    private int priority;

    public Request(String value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public String getValue() {
        return value;
    }

    public int getPriority() {
        return priority;
    }

    public static int compare(Request a, Request b) {
        return Integer.compare(a.priority, b.priority);
    }

    @Override
    public String toString() {
        return String.format("Priority: %6d | Value: %s", priority, value); 
    } 
}
