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

	private int x, y; // ������ x,y��ǥ
	private int dx, dy; // �巡�� x,y��ǥ
	private int targetNum = -1;
	private int prex, prey, preX, preY;
	
	// �巡���� ��, ������ �׸��� ���� Ʈ����
	boolean dragPaintTrigger = false;
	
	Vector<Shape> s;
	
	public CanvasPanel() {
		s = new Vector<Shape>();
		setBackground(Color.white);
		addMouseListener(this);
		addMouseMotionListener(this);
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		if(dragPaintTrigger == true) {
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
			// Arrows
			} else if(ButtonNum == 3 && targetNum != -1) {
				s.elementAt(targetNum).moveTo(prex+(dx-x),prey+(dy-y),preX+(dx-x),preY+(dy-y));
			// copy
			} else if(ButtonNum == 4 && targetNum != -1) {
				s.elementAt(targetNum).moveTo(prex+(dx-x),prey+(dy-y),preX+(dx-x),preY+(dy-y));
			}
		}
		
		// �׸��׸���
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
	
	// ��и����
	public int choiceQuadrant() {
		if( dx > x && dy < y) {
			// 1��и�
			return 1;
		} else if( dx < x && dy < y) {
			// 2��и�
			return 2;
		} else if( dx < x && dy > y) {
			// 3��и�
			return 3;
		} else {
			return 4;
		}
	}

	

	@Override
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		targetNum = findIndex(x, y);
		if(ButtonNum == 3) { // Cursor
			if(targetNum != -1) { //ã�����
				prex = s.elementAt(targetNum).getx();
				prey = s.elementAt(targetNum).gety();
				preX = s.elementAt(targetNum).getX();
				preY = s.elementAt(targetNum).getY();
			} else if( targetNum == -1) { // ��ã�� ���
				System.out.println("��ã��");
				return;
			}
		} else if(ButtonNum == 4) { //Copy
			if(targetNum != -1) { //ã�����
				prex = s.elementAt(targetNum).getx();
				prey = s.elementAt(targetNum).gety();
				preX = s.elementAt(targetNum).getX();
				preY = s.elementAt(targetNum).getY();
				
				if(s.elementAt(targetNum) instanceof Circle) {
					add(new Circle(s.elementAt(targetNum).getx(),s.elementAt(targetNum).gety(),s.elementAt(targetNum).getX()-s.elementAt(targetNum).getx(),s.elementAt(targetNum).getY()-s.elementAt(targetNum).gety()));
				} else if(s.elementAt(targetNum) instanceof Rect) {
					add(new Rect(s.elementAt(targetNum).getx(),s.elementAt(targetNum).gety(),s.elementAt(targetNum).getX()-s.elementAt(targetNum).getx(),s.elementAt(targetNum).getY()-s.elementAt(targetNum).gety()));
				}
			} else if( targetNum == -1) { // ��ã�� ���
				System.out.println("��ã��");
				return;
			}
		}
	}
	
	
	//���콺 Ŭ�� �� ���� ã�� �Լ�
	public int findIndex(int dx, int dy) {
		for(int i = s.size() - 1; i >= 0; i--) {
			if(s.elementAt(i).isIn(dx, dy)) {
				return i; // ã���� ã�� ������ �ε��� ��ȯ
			}
		}
		return -1; // ��ã�� ���
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
		// ����Ʈ Ʈ���Ű� false;
		dragPaintTrigger = false;
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
		dragPaintTrigger = true;
		
		dx = e.getX();
		dy = e.getY();
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	

}
