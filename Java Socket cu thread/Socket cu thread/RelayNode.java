import java.io.*;
import java.net.*;

public class RelayNode {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(Integer.parseInt(args[0]));
            System.out.println("RelayNode running on port: " + Integer.parseInt(args[0]));
            while (true) {
                new Worker1(serverSocket.accept(), args[1], Integer.parseInt(args[2])).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Worker1 extends Thread {
    private Socket socket = null;
    private String nextHopIP;
    private int nextHopPort;

    public Worker1(Socket socket, String nextHopIP, int nextHopPort) {
        super("Worker");
        this.socket = socket;
        this.nextHopIP = nextHopIP;
        this.nextHopPort = nextHopPort;
        System.out.println("Socket info from server: " + socket);
    }

    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                Socket nextHopSocket = new Socket(nextHopIP, nextHopPort);
                DataOutputStream nextHopOut = new DataOutputStream(nextHopSocket.getOutputStream());
                BufferedReader nextHopIn = new BufferedReader(new InputStreamReader(nextHopSocket.getInputStream()))
        ) {
            String line;
            while ((line = in.readLine())!= null
            ) {
                System.out.println("Received from client: " + line);
                String[] parts = line.split(" ");
                String targetIP = parts[0];
                int value = Integer.parseInt(parts[1]);

                if (socket.getLocalPort()==8083) {
                    System.out.println("Packet arrived at destination: " + value);
                    out.writeBytes(line + "\n");
                    out.flush();
                } else {
                    // Increment the value before forwarding the packet
                    value++;
                    String updatedLine = targetIP + " " + value;
                    nextHopOut.writeBytes(updatedLine + "\n");
                    nextHopOut.flush();
                    System.out.println("Forwarded to the next hop: " + updatedLine);
                    String response = nextHopIn.readLine();
                    System.out.println("Received response from next hop: " + response);
                    out.writeBytes(response + "\n");
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getLocalIP() {
        // Get the local IP address of this node
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }
}