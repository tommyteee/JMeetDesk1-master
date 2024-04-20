package ui.chatui;

import javax.swing.*;
import javax.swing.text.*;

import base.Config;
import base.RoundPanel;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.border.EmptyBorder;

public abstract class ChatPanelBase extends RoundPanel {
    private TextPane chatPane;
    private JTextField messageField;
    private JButton sendButton;

    public ChatPanelBase() {
    	setBorder(new EmptyBorder(15, 5, 5, 5));
    	
        chatPane = new TextPane();
        chatPane.setBorder(new EmptyBorder(0, 10, 0, 10));

        messageField = new JTextField(20);
        messageField.setOpaque(false);
        messageField.setBorder(null);
        sendButton = new JButton("Send");
        sendButton.setBorder(null);
        sendButton.setOpaque(false);
        sendButton.setBackground(Config.messageBoxColor);

        RoundPanel inputPanel = new RoundPanel() {
			
			@Override
			public Color getColor() {
				setBackground(Color.white);
				return Config.messageBoxColor;
			}
		};
		inputPanel.setRadius(5);
        inputPanel.setBorder(new EmptyBorder(15, 20, 10, 10));
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					addMessage();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane(chatPane);
        scrollPane.setBorder(null);
        add(scrollPane);
        add(inputPanel, BorderLayout.SOUTH);

    }

	public void addMessage() throws IOException {
		String message = getMsg();
        if (!message.isEmpty()) {
            addMsg("Moussa Jamor", message);
            send(message);
            messageField.setText(""); // Clear the message field
        }
        
        // add logic to send for all users : 
	}

    public void addMsg(String sender, String message) {
        MessagePanel messagePanel = new MessagePanel(sender, message);
        StyledDocument doc = chatPane.getStyledDocument();

        Style style = chatPane.addStyle("Style", null);
        StyleConstants.setComponent(style, messagePanel);
        
        StyleConstants.setSpaceAbove(style, 10);
        StyleConstants.setSpaceBelow(style, 10);

        try {
            doc.insertString(doc.getLength(), "\n", style);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
    
    public Color getColor() {
    	return Color.WHITE;
    }
    
    public String getMsg() {
    	return messageField.getText();
    }
    
    public abstract void send(String message);
    
    
}






