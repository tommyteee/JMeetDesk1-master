package client;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.*;
import java.net.*;

import javax.swing.JPanel;

import ui.chatui.ChatPanel;
import ui.mainwindow.MainScreen;

public class Client extends Socket {
	private Rectangle rectangle;
	ObjectOutputStream oos;
	private Robot robot;
	InputStream is= getInputStream();
	public MainScreen screen;
	
	public Client(String IP, int port, MainScreen screen) throws UnknownHostException, IOException {
		super(IP, port);
		this.screen = screen;
		
		try {
			
			robot = new Robot(getScreenDevice());
			
			
		} catch (AWTException e) {e.printStackTrace();}
	}
	public ObjectOutputStream getObjectOut() throws IOException {
		return new ObjectOutputStream(getOutputStream());
	}    

	public  BufferedReader getReader() throws IOException {
		return  new BufferedReader(new InputStreamReader(is));			
	}

	
	public  PrintWriter getWriter() throws IOException {
		OutputStream os= getOutputStream();
		return new PrintWriter(os,true);
	}
	
	public void RecieverMessage(ChatPanel chat){
		
		new Thread( new Runnable(){
			String msg;			

			public void run() 
			{
				try 
				{
					BufferedReader reader = getReader();
					while ( true ) 
					{
						msg=reader.readLine();
						if(msg!=null) {
							System.out.println("message is received");
							chat.showMessage(msg);
							}
					}
				}catch (IOException e){
			
				}
			}
		}).start();
	}
	
	public void sendScreenToServer() {
		new ScreenSender(this, robot, getScreenDim(), screen).start();
	}
	
	public void getCommadsFromServer() {
		new ServerDelegate(this, robot);
	}
	
	public Rectangle getScreenDim() {
		return new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	}
	
	public GraphicsDevice getScreenDevice() {
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	}


	public void SendMessage(String message) {
		
		try { 
			PrintWriter writer =  getWriter();
			writer.println(message);
			System.out.println("message is sended");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	

}
