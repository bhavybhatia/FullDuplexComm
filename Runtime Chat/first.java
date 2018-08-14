import java.util.*;
import java.io.*;
import java.net.*;

// Client side code for sharing runtime data/Chat bot;
class receive extends Thread
{
	String read;
	Socket s2 =null;
	public receive(Socket s)
	{
		s2=s;
	}
	public void run()
	{
		try
		{
			DataInputStream dis=new DataInputStream(s2.getInputStream());
			while(true)
			{
				read=dis.readUTF();
				System.out.println("                                                         "+read);
			}
			
		}
		catch(Exception e){}
		
	}
	
	
}
/*class send extends Thread
{
	Socket s3=null;
	
	public send(Socket s1)
	{
		s3=s1;
	}
	public void run()
	{
		try
		{
			DataOutputStream dos=new DataOutputStream(s3.getOutputStream());
			while(true)
			{
				System.out.print("Enter Message : ");
				String message=sc.nextLine();
				dos.writeUTF(message);
				
				System.out.println("                                                      ...");
			}
			
		}
		catch(Exception e){}
	}
}
*/
public class first 
{
	private static Socket s;
	private static Socket s1;

	public static void main(String[] args) 
	{
		
		try
		{
			Scanner sc=new Scanner(System.in);
			String ip,username;
			System.out.println("Enter IP address of the device to be connected (for eg. 192.168.20.5) : ");
			ip=sc.nextLine();
			System.out.println("Enter port address of the device : (for eg: 1111)");
			int port=sc.nextInt();
			System.out.println("Enter UserName : ");
			username=sc.nextLine();
			s = new Socket(ip,port);
	//		s1=new Socket(ip,1473);
			receive thd=new receive(s);
			//		send thd1=new send(s1);
			thd.start();
					
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			while(true)
			{
				System.out.print("Enter Message : ");
				String message=sc.nextLine();
				dos.writeUTF(username+" : "+message);
				
				System.out.println("                                                      ...");
			
	//		thd1.start();
			
		}
		}
		catch(Exception e){}
	}
}


