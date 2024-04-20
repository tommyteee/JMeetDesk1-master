package ui.menubar;

import javax.swing.JPanel;

import base.Config;

import java.awt.FlowLayout;
import javax.swing.JButton;

public class RightPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public void init_gui() {
		setOpaque(false);
	}

	public RightPanel() {
		init_gui();
	
		setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		MenuButton btnNewButton = new MenuButton("audio") {

			@Override
			public void addActionOn() {
				Config.eastPanelMainMenu.display(true);
			}

			@Override
			public void addActionOff() {
				Config.eastPanelMainMenu.display(false);
			}
			
		};
		add(btnNewButton);
	}
}
