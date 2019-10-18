import java.io.*;
import java.net.*;
import java.util.*;

public class DataClient 
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        try
        {
        	System.out.println("Enter IP Address...");
        	String ip = scan.nextLine();
        	System.out.println("Enter port address...");
        	int port = scan.nextInt();
            Socket s = new Socket(ip, port);
            RvThread rThread = new RvThread(s);
            rThread.start();
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            while (true)
            {
                dos.writeUTF(scan.nextLine());
            }
        }catch (Exception e) {}
    }
}

class RvThread extends Thread
{
    DataInputStream dis;
    RvThread(Socket s)
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