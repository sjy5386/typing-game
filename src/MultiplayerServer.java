import java.io.*;
import java.net.ServerSocket;
import java.util.Scanner;

public class MultiplayerServer extends Multiplayer {
    private ServerSocket listener = null;

    public void createSocket() {
        try {
            listener = new ServerSocket(port);
            socket = listener.accept();
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
            listener.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        MultiplayerServer server = new MultiplayerServer();
        server.createSocket();
        while (server.isConnected()) {
            String inputMessage = server.recv();
            if (inputMessage.equalsIgnoreCase("bye"))
                break;
            System.out.println("Client: " + inputMessage);
            System.out.print(">>");
            String outputMessage = scanner.nextLine().trim();
            server.send(outputMessage);
        }
        server.destroySocket();
        scanner.close();
    }
}
