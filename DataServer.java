import java.io.*;
import java.net.*;
import java.util.*;

public class DataServer 
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        try
        {
            ServerSocket s = new ServerSocket(1883);
            Socket client = s.accept();
            RxThread rThread = new RxThread(client);
            rThread.start();
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            while (true)
            {
            	System.out.println("Enter Message : ");
                dos.writeUTF(scan.nextLine());
            }
        }catch (Exception e) {}
    }
}

class RxThread extends Thread
{
    DataInputStream dis;
    RxThread(Socket s)
    {
        try
        {
            dis = new DataInputStream(s.getInputStream());
        }catch (Exception e) {}
    }
    public void run()
    {
        while (true)
        {
            try
            {
                System.out.println(dis.readUTF());
            }catch (Exception e){}
        }
    }
}