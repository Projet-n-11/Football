package gui.elements;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GraphicalPanel extends JFrame {

	public GraphicalPanel() throws IOException {
		super("Football Simulator V.0.0.1");
		this.setTitle("Ma première fenêtre Java");
	    this.setSize(900, 602);
	    this.setContentPane(new JLabel(new ImageIcon(new ImageIcon("C:\\Users\\aladd\\Desktop\\menuimg.png").getImage().getScaledInstance(this.getWidth(),this.getHeight(), Image.SCALE_DEFAULT))));
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
	    this.setVisible(true);
	    this.setResizable(true);
	    
	    JButton kickoff = new JButton("Kick-off");
	    kickoff.setBounds(50,100,95,30);
	    this.add(kickoff, BorderLayout.CENTER);
	}
	public static void main(String[] args) throws IOException {
		GraphicalPanel fen = new GraphicalPanel();
	}
}
