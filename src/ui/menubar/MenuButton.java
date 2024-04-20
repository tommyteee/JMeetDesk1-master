package ui.menubar;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import base.*;

public abstract class MenuButton extends JButton{
	private String icon_name;
	private Color bg_on = Config.BLACK_FRONT_COLOR;
	private Color bg_off = Config.RED_OFF_COLOR;
	private Boolean isOn = false;
	private String suffix = "_off";
	public static int RADIUS = 40;
	
	public MenuButton(String icon_name) {
		this.icon_name = icon_name;
		init_gui();
       
	}
	
	private void init_gui() {
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setOpaque(false);
        setPreferredSize(new Dimension(RADIUS, RADIUS));
        this.setMaximumSize(new Dimension(RADIUS,RADIUS));
        this.setBackground(bg_off);
        
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(isOn) {
            		setBackground(bg_off);
            		suffix = "_off";
            		isOn = false;
            		addActionOff();
            	}else {
               		setBackground(bg_on);
               		suffix = "_on";
            		isOn = true;
            		addActionOn();
            	}
            	
            }
        });
	}
	
	public abstract void addActionOn();
	public abstract void addActionOff();
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(getBackground());

        Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, getWidth(), getHeight());

        g2d.fill(circle);
        
        ImageIcon icon = new ImageIcon("./src/images/" + icon_name + suffix + ".png");
       

        if (icon != null) {
            int x = (getWidth() - icon.getIconWidth()) / 2;
            int y = (getHeight() - icon.getIconHeight()) / 2;
            icon.paintIcon(this, g2d, x, y);
        }
    }
	
	}