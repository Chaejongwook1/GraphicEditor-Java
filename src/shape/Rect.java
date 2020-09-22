package shape;

import java.awt.Graphics;

public class Rect extends Shape{
	public Rect(int x, int y, int w, int h) {
		super(x,y, x+w, y+h);
	}

	public void paint(Graphics g) {
		g.drawRect(x, y, X-x, Y-y);
	}
}
