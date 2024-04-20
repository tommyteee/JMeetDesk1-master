package server;


import java.awt.Rectangle;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

import javax.swing.JPanel;

import utils.Tuple;

public class Server extends ServerSocket{
	
	private ArrayList<Tuple<Socket, Rectangle>> ConnectedUsersList = new ArrayList<Tuple<Socket, Rectangle>>();
	JPanel screenPanel;
	
	public Server(int port) throws IOException {
		super(port);
	}
	
	private void add(Tuple<Socket, Rectangle> user_tuple) {
		ConnectedUsersList.add(user_tuple);
	}
	
	public BufferedReader getReader(Socket user) throws IOException {
		InputStream is = user.getInputStream();
		InputStreamReader ipsr=new InputStreamReader(is);		
		return new BufferedReader(ipsr);
	}
	
	public PrintWriter getPrinter(Socket user) throws IOException {
		OutputStream os = user.getOutputStream();
		return new PrintWriter(os,true);
	}
	
	public void sendMessageToAllUsers(Socket sender) {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					BufferedReader reader = getReader(sender);
					String msg;
					PrintWriter printer; 
				
					while(true) {
						
						msg = reader.readLine();
						
						if(msg!=null) {
						
							for(var user_tuple : ConnectedUsersList) {
																	
								if(sender != user_tuple.getFirst()) {
									
									printer = getPrinter(user_tuple.getFirst());
									
									printer.println(msg);
								}		            
					            
							}
						}						
					}
				
				} catch (IOException e) {e.printStackTrace();}
				
			}
		}).start();
		
	}
	
	public void setScreenPanel(JPanel screenPanel) {
		this.screenPanel = screenPanel;
	}
	
	
	public void acceptUsers() {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				ObjectInputStream ois = null;
				while(true) {
					
					try {
						Socket client = accept();
						
						ois = new ObjectInputStream(client.getInputStream());
						
				        Rectangle screendim = (Rectangle) ois.readObject();
						Tuple<Socket, Rectangle> user_tuple = new Tuple<Socket, Rectangle>(client, screendim);
						add(user_tuple);
						
						sendMessageToAllUsers(user_tuple.getFirst());
						
			            new ClientScreenReciever(ois,screenPanel).start();
			            //Start sending events to the client
			            new ClientCommandsSender(client,screenPanel,screendim);
						
						System.out.println("client is connected");
						
					} catch (IOException | ClassNotFoundException e) {
						System.out.println("Some thing happened");
					}
			}
		}}).start();
		
	}

	public static void main(String[] args) throws IOException {
		
		Server server = new Server(12345);
		System.out.println("server is waiting !!!!");
		server.acceptUsers();
	
	
	}
}






