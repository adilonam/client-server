

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class Server {
    final static int PORT = 7878;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is waiting for a client...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress());

                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

                // Receive the Personne object from the client
                Personne personne = (Personne) ois.readObject();

                // Calculate the age
                int age = personne.calcul_age(new Date());

                // Send the age back to the client
                oos.writeInt(age);
                oos.flush();

                oos.close();
                ois.close();
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
