package org.example;

import java.util.ArrayList;

class CustomStack {
    private ArrayList<String> stack;
    private int maxSize;
    private int top;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new ArrayList<>();
        top = -1;
    }

    public void push(String message) {
        if (isFull()) {
            System.out.println("Ngăn xếp đã đầy.");
            return;
        }
        stack.add(++top, message);
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Ngăn xếp rỗng. ");
            return null;
        }
        String message = stack.get(top);
        stack.remove(top--);
        return message;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public ArrayList<String> getAllMessages() {
        return stack;
    }
}