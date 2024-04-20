/*
 * Author Ahmed Abdelhalim - 2009
 * Email: englemo@hotmail.com
 * Please do not remove the above lines
 */

package client;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.ImageIcon;

import ui.mainwindow.MainScreen;

/**
 * This class is responisble for sending sreenshot every predefined duration
 */
class ScreenSender extends Thread {

    Socket socket = null; 
    Robot robot = null; // Used to capture screen
    Rectangle rectangle = null; //Used to represent screen dimensions
    boolean continueLoop = true; //Used to exit the program
    MainScreen screen;
    
    public ScreenSender(Socket socket, Robot robot,Rectangle rect, MainScreen screen) {
        this.socket = socket;
        this.robot = robot;
        this.screen = screen;
        rectangle = rect;
    }

    public void run(){
        ObjectOutputStream oos = null; //Used to write an object to the streem


        try{
            //Prepare ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            /*
             * Send screen size to the server in order to calculate correct mouse
             * location on the server's panel
             */
            oos.writeObject(rectangle);
        }catch(IOException ex){
            ex.printStackTrace();
        }

       while(continueLoop){
            //Capture screen
            BufferedImage image = robot.createScreenCapture(rectangle);
            /* I have to wrap BufferedImage with ImageIcon because BufferedImage class
             * does not implement Serializable interface
             */
            ImageIcon imageIcon = new ImageIcon(image);
            
            try {
            	Image image_panel = imageIcon.getImage();
            	image_panel = image_panel.getScaledInstance(screen.getWidth(),screen.getHeight()
            			,Image.SCALE_FAST);
            	//Draw the recieved screenshot
            	Graphics graphics = screen.getGraphics();
            	graphics.drawImage(image, 0, 0, screen.getWidth(),screen.getHeight(),screen);
				
			} catch (java.lang.IllegalArgumentException e) {
				// TODO: handle exception
			}
            

            //Send captured screen to the server
            try {
                System.out.println("before sending image");
                oos.writeObject(imageIcon);
                oos.reset(); //Clear ObjectOutputStream cache
                System.out.println("New screenshot sent");
            } catch (IOException ex) {
               ex.printStackTrace();
            }

            //wait for 100ms to reduce network traffic
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

    }

}
