package com.geekbrains.chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Network {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public Network(int port) throws IOException {
        socket = new Socket("localhost", port);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
    }

    public void sendMsg(String msg) throws IOException {
        out.writeUTF(msg);
        if(msg.equalsIgnoreCase("/end")){
            /*
            Использую System.exit(0), так как только так смог закрыть FX-окно. Если использовать вместо
            этого метод close(), то соединение разрывается со стороны клиента (процесс со стороны сервера
            соответственно закрывается по исключению), а окно чата остается работающим.
             */
            System.out.println("Окно чата закрывается");
            System.exit(0);
        }
    }

    public String readMsg() throws IOException {

        return in.readUTF();
    }

    public void close() {
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
