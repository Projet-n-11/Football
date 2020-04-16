package gui.elements;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;


public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 8003631464118687027L;

	public MainFrame() {
		MainMenu menu = new MainMenu();
		menu.getJFrameMainMenu();
	}
}