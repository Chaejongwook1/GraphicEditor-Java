package graphic_editor;

import static graphic_editor.ButtonPanel.ButtonNum;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import shape.Circle;
import shape.Rect;
import shape.Shape;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

public class CanvasPanel extends JPanel implements MouseListener, MouseMotionListener{

	private int x, y; // 시작점 x,y좌표
	private int dx, dy; // 드래그 x,y좌표
	private int targetNum = -1;
	private int prex, prey, preX, preY;
	
	Vector<Shape> s;
	
	public CanvasPanel() {
		s = new Vector<Shape>();
		setBackground(Color.white);
		addMouseListener(this);
		addMouseMotionListener(this);
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		if(ButtonNum == 1) {
			if(choiceQuadrant() == 1) {
				g.drawOval(x, dy, dx - x, y - dy);
			} else if( choiceQuadrant() == 2) {
				g.drawOval(dx, dy, x - dx, y - dy);
			} else if( choiceQuadrant() == 3) {
				g.drawOval(dx, y, x - dx, dy - y);
			} else if( choiceQuadrant() == 4) {
				g.drawOval(x, y, dx - x, dy - y);
			}
		} else if(ButtonNum == 2) {
			if(choiceQuadrant() == 1) {
				g.drawRect(x, dy, dx - x, y - dy);
			} else if( choiceQuadrant() == 2) {
				g.drawRect(dx, dy, x - dx, y - dy);
			} else if( choiceQuadrant() == 3) {
				g.drawRect(dx, y, x - dx, dy - y);
			} else if( choiceQuadrant() == 4) {
				g.drawRect(x, y, dx - x, dy - y);
			}
		// Arrow
		} else if(ButtonNum == 3 && targetNum != -1) {
			s.elementAt(targetNum).moveTo(prex+(dx-x),prey+(dy-y),preX+(dx-x),preY+(dy-y));
		}
		
		
		// 그림그리기
		for(int i = 0; i < s.size(); i++) {
			Shape s1 = s.elementAt(i);
			s1.paint(g);
		}
	}
	
	public void add(Shape s1) {
		s.add(s1);
		repaint();
	}
	
	public void resetVector() {
		s.clear();
		repaint();
	}
	
	// 사분면결정
	public int choiceQuadrant() {
		if( dx > x && dy < y) {
			// 1사분면
			return 1;
		} else if( dx < x && dy < y) {
			// 2사분면
			return 2;
		} else if( dx < x && dy > y) {
			// 3사분면
			return 3;
		} else {
			return 4;
		}
	}

	

	@Override
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		if(ButtonNum == 3) {
			for(int i = s.size() - 1; i >= 0; i--) {
				if(s.elementAt(i).isIn(e.getX(), e.getY())) {
					targetNum = i;
					prex = s.elementAt(targetNum).getx();
					prey = s.elementAt(targetNum).gety();
					preX = s.elementAt(targetNum).getX();
					preY = s.elementAt(targetNum).getY();
					break;
				}
			}
		}
	}
	
	public void findIndex(MouseEvent e) {
		for(int i = s.size() - 1; i >= 0; i--) {
			if(s.elementAt(i).isIn(e.getX(), e.getY())) {
				break;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if( ButtonNum == 1) {
			if(choiceQuadrant() == 1) {
				add(new Circle(x, dy, dx - x, y - dy));
			} else if( choiceQuadrant() == 2) {
				add(new Circle(dx, dy, x - dx, y - dy));
			} else if( choiceQuadrant() == 3) {
				add(new Circle(dx, y, x - dx, dy - y));
			} else if( choiceQuadrant() == 4) {
				add(new Circle(x, y, dx-x, dy-y));
			}
		} else if(ButtonNum == 2) {
			if(choiceQuadrant() == 1) {
				add(new Rect(x, dy, dx - x, y - dy));
			} else if( choiceQuadrant() == 2) {
				add(new Rect(dx, dy, x - dx, y - dy));
			} else if( choiceQuadrant() == 3) {
				add(new Rect(dx, y, x - dx, dy - y));
			} else if( choiceQuadrant() == 4) {
				add(new Rect(x, y, dx-x, dy-y));
			}
		}
		
		// 좌표값 초기화
		x = 0;
		y = 0;
		dx = 0;
		dy = 0;
		targetNum = -1;
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		dx = e.getX();
		dy = e.getY();
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	

}
