package graphic_editor;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ButtonPanel extends JPanel implements ActionListener {

	private JButton CircleButton;
	private JButton RectButton;
	private JButton CursorButton;
	private JButton CopyButton;
	public static int ButtonNum = 1;
	
	
	public ButtonPanel() {
		
		setLayout(new GridLayout(4,1));
		setButton();
	}
	
	public void setButton() {
		
		CircleButton = new JButton("");
		CircleButton.setIcon(new ImageIcon("./images/CircleButton.png"));
		CircleButton.setBorderPainted(false);
		CircleButton.addActionListener(this);
		add(CircleButton);

		RectButton = new JButton("");
		RectButton.setIcon(new ImageIcon("./images/RectButton.png"));
		RectButton.setBorderPainted(false);
		RectButton.addActionListener(this);
		add(RectButton);
		
		CursorButton = new JButton("");
		CursorButton.setIcon(new ImageIcon("./images/CursorButton.png"));
		CursorButton.setBorderPainted(false);
		CursorButton.addActionListener(this);
		add(CursorButton);
		
		CopyButton = new JButton("");
		CopyButton.setIcon(new ImageIcon("./images/CopyButton.png"));
		CopyButton.setBorderPainted(false);
		CopyButton.addActionListener(this);
		add(CopyButton);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(CircleButton)) {
			System.out.println("Circle");
			ButtonNum = 1;
		} else if(e.getSource().equals(RectButton)) {
			System.out.println("Rect");
			ButtonNum = 2;
		} else if(e.getSource().equals(CursorButton)) {
			System.out.println("Cursor");
			ButtonNum = 3;
		} else if(e.getSource().equals(CopyButton)) {
			ButtonNum = 4;
		}
	}
	
	public int getButtonNum() {
		return ButtonNum;
	}
	
}
