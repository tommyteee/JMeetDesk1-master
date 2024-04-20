package ui.chatui;


import java.io.IOException;

import client.Client;

public class ChatPanel extends ChatPanelBase {

	private static final long serialVersionUID = 1L;
	
	public ChatPanel() {
		
	}
	
	public void showMessage(String msg){
		addMsg("Moussa", msg);
	}

	@Override
	public void send(String message) {
		//client.SendMessage(message);
	}

}




