import java.net.*;
 class InetAddressTest
{ 
 public static void main(String args[])throws UnknownHostException
  {
    InetAddress test = InetAddress.getLocalHost();
    System.out.println("IP Address is:"+test);
    InetAddress test1 = InetAddress.getByName("www.google.com");
    System.out.println("IP Address of the website is:" + test1);
  }
}