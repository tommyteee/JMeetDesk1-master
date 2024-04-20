package ui.chatui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

public class MessagePanel extends JPanel {
    private JLabel senderLabel;
    private JLabel messageLabel;
    
    public void init_gui() {
		setBackground(Color.WHITE);
	}

    public MessagePanel(String sender, String message) {
    	init_gui();
    	
    	
        senderLabel = new JLabel(sender);
        senderLabel.setFont(new Font("Dialog", Font.BOLD, 11));
        messageLabel = new JLabel(message);
        messageLabel.setFont(new Font("Open Sans Light", Font.BOLD, 12));

        setLayout(new BorderLayout());
        add(senderLabel, BorderLayout.NORTH);
        add(messageLabel, BorderLayout.CENTER);      
        
        // Add some padding between message components
        setBorder(BorderFactory.createEmptyBorder(10, 5, 5, 10));
    }
}
