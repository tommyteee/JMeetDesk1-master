package ui.menubar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class CenterPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private MenuButton audio, video, cursor;

	public CenterPanel() {

		setOpaque(false);
		FlowLayout fl_centerPanel = new FlowLayout(FlowLayout.CENTER, 10, 5);
		setLayout(fl_centerPanel);
		
		audio = new MenuButton("audio") {
			
			@Override
			public void addActionOn() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addActionOff() {
				// TODO Auto-generated method stub
				
			}
		};
		
		add(audio);
		
		video = new MenuButton("video") {
			
			@Override
			public void addActionOn() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addActionOff() {
				// TODO Auto-generated method stub
				
			}
		};
		
		add(video);
		
		cursor = new MenuButton("cursor") {
			
			@Override
			public void addActionOn() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addActionOff() {
				// TODO Auto-generated method stub
				
			}
		};
		
		add(cursor);
		
	}

}
