package base;
import java.awt.Color;
import java.net.Socket;

import ui.chatui.ChatPanelBase;
import ui.mainwindow.EastPanel;

public class Config {

	public static double mainWinEastPanelCoef = 0.3;
	public static double chatSendButtonCoef = 0.3;
	public static double messageFieldCoef = 0.07;
	public static double menuBarHeightCoef = 0.1;
	public static int menuBarHeight = 60;
	public static int Radius = 10; 
	
	/* Colors : */
	public static Color RED_OFF_COLOR = new Color(230, 56, 45);
	public static Color BLACK_FRONT_COLOR = new Color(51, 55, 59);
	public static Color BLACK_BACK_COLOR = new Color(29, 29, 34);
	public static Color messageBoxColor = new Color(235, 235, 235);
	
	/* Component */
	public static EastPanel eastPanelMainMenu = null;
	
	/* User */
	public static Socket user;
	
	public static ChatPanelBase chatPanel;
	
}






