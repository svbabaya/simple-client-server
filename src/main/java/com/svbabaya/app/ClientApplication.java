package com.svbabaya.app;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ClientApplication {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            Socket socket = new Socket("localhost", 8189);

            // Запросить исходящий поток
//            socket.getOutputStream().write(65);
            while (true) {
                String message = scanner.nextLine();
                if (message.equals("/exit")) break;
                socket.getOutputStream().write(message.getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
