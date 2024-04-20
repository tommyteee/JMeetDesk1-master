package ui.mainwindow;

import base.Config;
import ui.chatui.ChatPanel;

import javax.swing.*;
import java.awt.*;

public class EastPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField msgField;
	private double coef = Config.mainWinEastPanelCoef;
	public ChatPanel chat;

	/**
	 * Create the panel.
	 */
	public EastPanel() {
		/* init GUI */
		init_gui();
		
		setLayout(new BorderLayout(0, 0));
		
		chat = new ChatPanel();
		add(chat, BorderLayout.CENTER);

	}
	
	public void init_gui() {
		display(false);
		Config.eastPanelMainMenu = this;
	}
	
	public Dimension getPreferredSize() {
		return new Dimension((int) (coef*getParent().getWidth()),getParent().getHeight());
	}
	
	public void setWdidthPercentage(double w_per) {
		coef = w_per;
		revalidate();
	}
	
	public void display(Boolean d) {
		if(d)
			setWdidthPercentage(Config.mainWinEastPanelCoef);
		else
			setWdidthPercentage(0);
	}

}











