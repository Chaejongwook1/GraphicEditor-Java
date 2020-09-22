package shape;

import java.awt.Graphics;

public abstract class Shape {
	
	
	// x,y = 마우스 시작 좌표 X,Y = 마우스 드래그 좌표
	int x, y, X, Y;
	
	public Shape(int x, int y,int X, int Y) {
		this.x = x;
		this.y = y;
		this.X = X;
		this.Y = Y;
	}
	
	public abstract void paint(Graphics g);
	
	public void moveBy(int dx, int dy) {
		x = x + dx;
		y = y + dy;
	}
	
	public void moveTo(int newx, int newy, int newX, int newY) {
		x = newx;
		y = newy;
		X = newX;
		Y = newY;
	}
	
	public boolean isIn(int tx, int ty) {
		if(x <= tx && tx <= X) {
			if(y <= ty && ty <= Y) {
				return true;
			}
		}
		return false;
	}
	
	public int getx() {
		return x;
	}
	
	public int gety() {
		return y;
	}
	
	public int getX() {
		return X;
	}
	
	public int getY() {
		return Y;
	}
	
	public void setx(int x) {
		this.x = x;
	}
	
	public void sety(int y) {
		this.y = y;
	}
	
	public void setX(int X) {
		this.X = X;
	}

	public void setY(int Y) {
		this.Y = Y;
	}
}
