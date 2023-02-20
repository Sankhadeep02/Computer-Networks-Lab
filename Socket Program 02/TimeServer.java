import java.net.*;
import java.io.*;
import java.util.Date;
public class TimeServer {
    public static void main(String[] args) throws IOException{
        ServerSocket servSock = null;
        try{
            servSock = new ServerSocket(1313);
        }
        catch(IOException e){
            System.err.println("Could not listen to port 1313");
            System.exit(1);
        }
        Socket clntSock = null;
        for(;;)
        {
            try{
                clntSock = servSock.accept();
            }
            catch(IOException e)
            {
                System.err.println("Accept failed");
                System.exit(1);
            }
            ObjectOutputStream timeOut = null;
            timeOut = new ObjectOutputStream(clntSock.getOutputStream());
            timeOut.writeObject(new Date());
            timeOut.close();
            clntSock.close();
        }
    }
}
