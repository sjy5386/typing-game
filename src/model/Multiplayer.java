package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;

public abstract class Multiplayer {
    protected Socket socket = null;
    protected int port = 16920;
    protected BufferedReader in = null;
    protected BufferedWriter out = null;

    public abstract void createSocket();
    public abstract void destroySocket();

    public String recv() {
        if (in == null)
            return null;
        String str = null;
        try {
            str = in.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return str;
    }

    public void send(String str) {
        if (out == null)
            return;
        try {
            out.write(str + "\n");
            out.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isConnected() {
        if (socket == null)
            return false;
        return socket.isConnected();
    }
}
