package app;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

import server.Server;
import ui.mainwindow.MainWidow;
import client.Client;

public class JMeetDesk extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try{
					
					JMeetDesk frame = new JMeetDesk();
					frame.setMinimumSize(new Dimension(800, 500));
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JMeetDesk() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		
		// main window :
		MainWidow mainwin = new MainWidow();
		contentPane.add(mainwin, BorderLayout.CENTER);
		
		/*
		 * Server server; try {
		 * 
		 * server = new Server(12345); server.setScreenPanel(mainwin.getScreenPanel());
		 * server.acceptUsers();
		 * 
		 * } catch (IOException e) {e.printStackTrace();}
		 */
		
		
		try {
			Client client = new Client("100.91.178.175", 12345, mainwin.mainScreen);
			client.sendScreenToServer();
			client.getCommadsFromServer();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		setContentPane(contentPane);
	}

}



