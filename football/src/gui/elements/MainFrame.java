package gui.elements;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MainFrame extends JFrame {
	
	private JFrame mainFrame;

	public MainFrame() {
		MainMenu menu = new MainMenu();
		mainFrame = menu.getJFrameMainMenu();
	}
	
	public static void main(String args[]) {
		new MainFrame();
	}
}