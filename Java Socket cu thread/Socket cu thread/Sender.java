import java.io.*;
import java.net.*;
import java.util.Random;

public class Sender {
    public static void main(String[] args) {
        String destinationIP = args[0];
        int destinationPort = Integer.parseInt(args[1]);

        try (Socket socket = new Socket(destinationIP, destinationPort);
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            System.out.println("Sender online! Sending 100 packets...");
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                int value = random.nextInt(100);
                String packet = " " + value;
                out.writeBytes(packet + "\n");
                out.flush();
                System.out.println("Sent to the RelayNode: " + packet);
                String response = inFromServer.readLine();
                System.out.println("Received response from RelayNode: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
