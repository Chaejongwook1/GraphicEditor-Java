package shape;

import java.awt.Graphics;

public class Circle extends Shape {
	
	public Circle(int x, int y, int w, int h) {
		super(x,y, x+w, y+h);
	}
	
	public void paint(Graphics g) {
		g.drawOval(x, y, X-x, Y-y);
	}
}
