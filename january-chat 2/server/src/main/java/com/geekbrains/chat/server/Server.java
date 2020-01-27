package com.geekbrains.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private AuthManager authManager;
    private List<ClientHandler> clients;

    public AuthManager getAuthManager() {
        return authManager;
    }

    public Server(int port) {
        clients = new ArrayList<>();
        authManager = new BasicAuthManager();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен. Ожидаем подключения клиентов...");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(this, socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void recipientMsg(String nickRecipient, String nickname, String msg) {

        String tmp = "";
        for (ClientHandler nr : clients) {
            if (nr.getNickname().equals(nickRecipient)) {
                tmp = msg.replace(("/w " + nickRecipient), " ");
                nr.sendMsg(tmp);
            }
        }
        if (tmp.equals("")){
            for (ClientHandler n : clients) {
                if (n.getNickname().equals(nickname)) {
                    n.sendMsg(nickRecipient + " в офф-лайне");
                }
            }
        }

    }

    public void broadcastMsg(String msg) {
        for (ClientHandler o : clients) {
            o.sendMsg(msg);
        }
    }

    public boolean isNickBusy(String nickname) {
        for (ClientHandler o : clients) {
            if (o.getNickname().equals(nickname)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void subscribe(ClientHandler clientHandler) {

        clients.add(clientHandler);
        broadcastMsg(clientHandler.getNickname() + " зашел в чат");

    }

    public synchronized void unsubscribe(ClientHandler clientHandler) {

        clients.remove(clientHandler);
        broadcastMsg(clientHandler.getNickname() + " вышел из чата");
    }
}
