package ui.chatui;

import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;


public class TextPane extends JTextPane {

	private static final long serialVersionUID = 1L;

	public TextPane() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		init_gui();
	}
	
	public void init_gui() {
		setEditable(false);
	}
	

}
