import java.io.*;
import java.net.*;
import java.util.Date;

public class MulticastDateServer{
    public static void main(String[] args) throws IOException, InterruptedException{
        DatagramSocket Socket = new DatagramSocket(5050);
        
        for (int i = 0; i < 500; i++) {
            byte[] buf = new Date().toString().getBytes();
            InetAddress group = InetAddress.getByName("230.0.0.1");
            DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 1313);
            Socket.send(packet);
            Thread.sleep(1500);
        }

        Socket.close();
    }
}  