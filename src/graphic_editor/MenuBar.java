package graphic_editor;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;

import static graphic_editor.MainFrame.canvasPanel;

import java.awt.event.ActionEvent;

public class MenuBar extends JMenuBar{
	
	public MenuBar() {
		
		JMenu fileMenu = new JMenu("File");
		add(fileMenu);
		
		JMenuItem newItem = new JMenuItem("New");
		newItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvasPanel.resetVector();
			}
		});
		fileMenu.add(newItem);
		
		JMenuItem openItem = new JMenuItem("Open");
		fileMenu.add(openItem);
		
		JMenuItem saveItem = new JMenuItem("Save");
		fileMenu.add(saveItem);
		
		JMenuItem loadItem = new JMenuItem("Load");
		fileMenu.add(loadItem);		
		
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		fileMenu.add(exitItem);		
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Help");
		add(mnNewMenu_2);
	}

}
