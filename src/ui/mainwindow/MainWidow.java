package ui.mainwindow;

import javax.swing.*;
import base.Config;
import ui.menubar.MenuBar;
import java.awt.*;


public class MainWidow extends JPanel {

	private static final long serialVersionUID = 1L;
	public MainScreen mainScreen;
	private MenuBar menubar;
	private EastPanel eastPanel;

	public MainWidow() {
		setLayout(new BorderLayout(0, 0));
		setBackground(Config.BLACK_BACK_COLOR);
		
		mainScreen = new MainScreen();

		eastPanel = new EastPanel();
		eastPanel.setOpaque(false);
		
		menubar = new MenuBar();
		menubar.setOpaque(false);
		

		add(menubar, BorderLayout.SOUTH);
		add(eastPanel, BorderLayout.EAST);
		add(mainScreen, BorderLayout.CENTER);

	}
	
	public JPanel getScreenPanel() {
		return mainScreen;
	}

}
