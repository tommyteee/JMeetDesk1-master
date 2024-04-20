package ui.menubar;

import javax.swing.JPanel;

import base.Config;
import ui.mainwindow.EastPanel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

public class MenuBar extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private CenterPanel centerPanel;
	
	public MenuBar() {
		setLayout(new BorderLayout(0, 0));
		
		
		RightPanel rightPanel = new RightPanel();
		add(rightPanel, BorderLayout.EAST);
		
		JPanel leftpanel = new JPanel();
		leftpanel.setOpaque(false);
		add(leftpanel, BorderLayout.WEST);
		
		
		centerPanel = new CenterPanel();
		
		add(centerPanel, BorderLayout.CENTER);
		
	}
	
	public Dimension getPreferredSize() {
		//(int) (Config.menuBarHeightCoef*getParent().getHeight())
		return new Dimension(getParent().getWidth(), Config.menuBarHeight);
	}

}
