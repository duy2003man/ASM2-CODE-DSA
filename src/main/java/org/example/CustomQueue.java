package org.example;

import java.util.ArrayList;

public class CustomQueue<T> {
    private ArrayList<T> queue;
    private int maxSize;

    public CustomQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new ArrayList<>();
    }

    public void enqueue(T element) {
        if (isFull()) {
            System.out.println("Hàng chờ đã đầy. Không thể thêm phần tử mới.");
            return;
        }
        queue.add(element);
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Hàng chờ rỗng. Không thể lấy phần tử.");
            return null;
        }
        T element = queue.get(0);
        queue.remove(0);
        return element;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean isFull() {
        return queue.size() == maxSize;
    }

    public ArrayList<T> getAllElements() {
        return queue;
    }

    public String[] getAllMessages() {
        return new String[0];
    }
}