

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class Client {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int SERVER_PORT = 7878;

        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            // Create a Personne object and send it to the server
            Personne personne = new Personne("Nom", "Prénom", new Date(90, 4, 23)); // Example birthdate: May 23, 1990
            oos.writeObject(personne);

            // Receive the age from the server
            int age = ois.readInt();
            System.out.println("L'âge calculé est: " + age);

            oos.close();
            ois.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

