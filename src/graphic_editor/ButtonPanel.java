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
	private JButton ArrowButton;
	public static int ButtonNum = 1;
	
	
	public ButtonPanel() {
		
		setLayout(new GridLayout(3,1));
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
		
		ArrowButton = new JButton("");
		ArrowButton.setIcon(new ImageIcon("./images/ArrowButton.png"));
		ArrowButton.setBorderPainted(false);
		ArrowButton.addActionListener(this);
		add(ArrowButton);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(CircleButton)) {
			System.out.println("Circle");
			ButtonNum = 1;
		} else if(e.getSource().equals(RectButton)) {
			System.out.println("Rect");
			ButtonNum = 2;
		} else if(e.getSource().equals(ArrowButton)) {
			System.out.println("Arrow");
			ButtonNum = 3;
		}
	}
	
	public int getButtonNum() {
		return ButtonNum;
	}
	
}
