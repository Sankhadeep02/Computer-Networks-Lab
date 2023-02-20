import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class dateclient {
    public static void main(String[] args) throws IOException {
        Socket timSocket = null;
        ObjectInputStream timeIn = null;
        try {
            timSocket = new Socket("localhost", 1313); // use 127.0.0.1 (loopback address insted of "localhost" if DNS
                                                       // is not installed in the machine)
            timeIn = new ObjectInputStream(timSocket.getInputStream());
        } catch (UnknownHostException e) {
            System.out.println("Server 'localhost' is unknown");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Error during connection to 'localhost'");
            System.exit(1);
        }
        try {
            Date ServerDate = (Date) timeIn.readObject();
            System.out.println("Current Server time: " + ServerDate);
        } catch (ClassNotFoundException e) {
            System.err.println("Not a date object returned");
            System.exit(1);
        }
        timeIn.close();
        timSocket.close();
    }
}