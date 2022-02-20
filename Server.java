import java.net.ServerSocket;
import java.util.Set;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.HashSet;
import java.io.FileReader;
import java.util.Objects;
import java.net.Socket;
import java.io.*;
import java.net.Socket;

/**
 * @author  Sultan Alahmadi
 * 11/18/2019
 */
public final class Server {

    private ServerSocket serverSocket;


    public Server(File file) throws NullPointerException, IOException {
        this.serverSocket = new ServerSocket(5000);
    }


    public void serveClients() {
        Socket clientSocket;
        Thread handlerThread;
        int clientCount = 0;
        System.out.printf("port is : 5000", this.serverSocket.getLocalPort());
        while (true) {
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            clientCount++;
        }
    }

}

class runner {

    public static void main(String[] args) {
        Server server;

        try {
            server = new Server(new File("PA.txt"));
        } catch (Exception e) {
            e.printStackTrace();

            return;
        }

        server.serveClients();
    }
}
