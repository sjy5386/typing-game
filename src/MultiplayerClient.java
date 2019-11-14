import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MultiplayerClient extends Multiplayer {
    private InetAddress serverAddress;

    public void setServerAddress(String host) {
        try {
            serverAddress = InetAddress.getByName(host);
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createSocket() {
        try {
            socket = new Socket(serverAddress, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void destroySocket() {
        try {
            if (socket != null)
                socket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        MultiplayerClient client = new MultiplayerClient();
        client.setServerAddress("127.0.0.1");
        client.createSocket();
        while (client.isConnected()) {
            System.out.print(">>");
            String outputMessage = scanner.nextLine().trim();
            client.send(outputMessage);
            if (outputMessage.equalsIgnoreCase("bye"))
                break;
            String inputMessage = client.recv();
            System.out.println("Server: " + inputMessage);
        }
        client.destroySocket();
        scanner.close();
    }
}
