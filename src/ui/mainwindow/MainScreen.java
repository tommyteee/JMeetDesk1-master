package ui.mainwindow;

import java.awt.Color;


import base.Config;
import base.RoundPanel;

public class MainScreen extends RoundPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public MainScreen() {

	}

	@Override
	public Color getColor() {
		return Config.BLACK_FRONT_COLOR;
	}

}
