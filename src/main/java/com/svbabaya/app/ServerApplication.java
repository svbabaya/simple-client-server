package com.svbabaya.app;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApplication {
    public static void main(String[] args) {
        try {
            // Занять порт 8189
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Server started...");

            // Создать точку соединения и ждать запрос, операция блокирует дальнейшее выполнение программы
            Socket socket = serverSocket.accept();
            System.out.println("Client connected...");

            // Считывать информацию из входящего потока
            while (true) {
                int n = socket.getInputStream().read();
                if (n == -1) break;
                System.out.print((char) n);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
