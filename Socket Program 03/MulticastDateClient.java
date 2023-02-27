import java.io.*;
import java.net.*;
import java.util.Date;

public class MulticastDateClient {
    public static void main(String[] args) throws IOException{
        MulticastSocket Socket = new MulticastSocket(1313);
        InetAddress group = InetAddress.getByName("230.0.0.1");
        Socket.joinGroup(group);

        for (int i = 0; i < 500; i++) {
            byte[] buf = new byte[256];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            Socket.receive(packet);
            String received = new String(packet.getData());
            System.out.println("Current Server Time: " + received);    
        }

        Socket.leaveGroup(group);
        Socket.close();
    }
}
