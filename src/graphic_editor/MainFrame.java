package graphic_editor;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame{

	public final static CanvasPanel canvasPanel = new CanvasPanel();
	
	public static void main(String[] args) {
		
		// ���� ������
		MainFrame mainFrame = new MainFrame();
		
		// �޴��� �߰�
		MenuBar menuBar = new MenuBar();
		mainFrame.setJMenuBar(menuBar);
		
		//��ư �г� �߰�
		ButtonPanel buttonPanel = new ButtonPanel();
		mainFrame.add(buttonPanel, BorderLayout.WEST);
		
		// ĵ���� �г� �߰�
		mainFrame.add(canvasPanel, BorderLayout.CENTER);
		mainFrame.setVisible(true);
		
	}
	
	public MainFrame() {
		setTitle("GraphicEditor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 800);
		setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
	}
}
