package base;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPanel;

public abstract class RoundPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	private int radius = Config.Radius;
	
	public void setRadius(int r) {
		this.radius = r;
		revalidate();
	}
	public RoundPanel() {

	}
	
	abstract public Color getColor();
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Config.BLACK_BACK_COLOR);
        int w = getWidth();
        int h = getHeight();
        
        Graphics2D g2d = (Graphics2D) g;
        RoundRectangle2D roundedRect = new RoundRectangle2D.Double(5,5, w-10, h-5, radius, radius);
        g2d.setColor(getColor());
        g2d.fill(roundedRect);
    }
    

}
