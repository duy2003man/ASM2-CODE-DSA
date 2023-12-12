package org.example;

import java.util.Scanner;

public class Main {
    private static CustomStack messageStack;
    private static CustomQueue messageQueue;

    public static void main(String[] args) {
        messageStack = new CustomStack(5);
        messageQueue = new CustomQueue(5);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Nhập tin nhắn");
            System.out.println("2. Kiểm tra và đẩy tin nhắn vào hàng chờ");
            System.out.println("3. Hiển thị tin nhắn");
            System.out.println("4. Kết thúc");

            System.out.print("Chọn hành động (1-4): ");
            int choice = scanner.nextInt();


            switch (choice) {
                case 1:
                    System.out.print("Nhập tin nhắn: ");
                    String message = scanner.next();

                    if (isValidMessage(message)) {
                        messageQueue.enqueue(message);
                        System.out.println("Tin nhắn đã được thêm vào hàng chờ.");
                    } else {
                        System.out.println("Tin nhắn không hợp lệ. Vui lòng nhập lại.");
                    }
                    break;

                case 2:
                    if (messageQueue.isFull()) {
                        while (!messageQueue.isEmpty()) {
                            String msg = messageQueue.dequeue().toString();
                            messageStack.push(msg);
                            System.out.println("Đã dequeue từ hàng chờ và đẩy vào ngăn xếp: " + msg);
                        }
                    } else {
                        System.out.println("Hàng chờ chưa đầy. Quay lại nhập tin nhắn.");
                    }
                    break;

                case 3:
                    System.out.println("Hiển thị tin nhắn từ hàng chờ:");
                    while (!messageQueue.isEmpty()) {
                        String msg = messageQueue.dequeue().toString();
                        System.out.println("Tin nhắn: " + msg);
                        messageQueue.enqueue(msg);
                    }
                    System.out.println("Hiển thị tin nhắn từ ngăn xếp:");
                    while (!messageStack.isEmpty()) {
                        String msg = messageStack.pop();
                        System.out.println("Tin nhắn: " + msg);
                    }
                    break;

                case 4:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }

    public static boolean isValidMessage(String message) {
        if (message.length() > 250) {
            System.out.println("Tin nhắn không được vượt quá 250 ký tự.");
            return false;
        }

        if (message.matches(".*(.)\\1{2,}.*")) {
            System.out.println("Tin nhắn chứa ký tự spam. Vui lòng nhập lại.");
            return false;
        }

        return true;
    }
}