package gui.elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MainMenu extends JPanel {
	
	private static final long serialVersionUID = -3358895820336739941L;
	private JFrame mainFrame;
	private JLabel simulator;
	private JButton kickOff;
	private JButton options;
	private JButton credits;
	
	private JButton leave;
	
	public MainMenu(){
		this("Fooball Game");
	}
	
	public MainMenu(String title) {
		mainFrame = new JFrame();
		initLayout();
	}

	public void initLayout() {
		JPanel simulatorPanel=new JPanel();
		JPanel kickOffPanel=new JPanel();
		JPanel optionsPanel=new JPanel();
		JPanel creditsPanel=new JPanel();
		JPanel leavePanel=new JPanel();
	
		simulatorPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		kickOffPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		optionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		creditsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		leavePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	
		simulator=new JLabel("FOOTBALL SIMULATOR");
		simulator.setFont(new Font("Arial", Font.PLAIN, 40));
		simulator.setForeground(Color.GREEN);
		simulatorPanel.add(simulator);
		
		kickOff=new JButton("Kick-off");
		kickOff.setSize(new Dimension(300, 100));
		kickOff.setMinimumSize(getSize());
		
		kickOff.addActionListener(new ActionKickOff());
		kickOffPanel.add(kickOff);
		
		options =new JButton("Options");
		options.setSize(300,400);
		options.addActionListener(new ActionOptions());
		optionsPanel.add(options);
		
		credits=new JButton("Credits");
		credits.setSize(300,400);
		credits.addActionListener(new ActionCredits());
		creditsPanel.add(credits);
		
		leave=new JButton("Quit the game");
		leave.addActionListener(new ActionLeave());
		leave.setSize(200,400);
		leavePanel.add(leave);
		
		mainFrame.getContentPane().setLayout(new GridLayout(6,1));
		mainFrame.getContentPane().add(simulatorPanel);
		mainFrame.getContentPane().add(kickOffPanel);
		mainFrame.getContentPane().add(optionsPanel);
		mainFrame.getContentPane().add(creditsPanel);
		mainFrame.getContentPane().add(leavePanel);
        mainFrame.setSize(1300,800);
		mainFrame.setLocation(350,150);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setPreferredSize(null);
		mainFrame.setVisible(true);
	}
	
	public class ActionKickOff implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			mainFrame.getContentPane().removeAll();
			mainFrame.repaint();
			KickOffMenu kick = new KickOffMenu();
			mainFrame.getContentPane().setLayout(new GridLayout(1,1));
			mainFrame.getContentPane().add(kick.createKickOff());	
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainFrame.setPreferredSize(null);
			mainFrame.setVisible(true);
		}
	}
	
	public class ActionOptions implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JOptionPane optionPane=new JOptionPane();
			optionPane.showMessageDialog(null, "Nothing to see right now...", "Options Menu", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public class ActionCredits implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			String message="Produced by : \n ALADDINE BEN ROMDHANE \n LAURA FUSTINONI \n QUITTERIE PILON";
			JOptionPane optionPane=new JOptionPane();
			optionPane.showMessageDialog(null, message, "Credits Menu", JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
	
	public class ActionLeave implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JOptionPane optionPane =new JOptionPane();
			
			int op=optionPane.showConfirmDialog(null, "You sure about that?", "Quit",JOptionPane.YES_NO_OPTION);
			if(op==0) {
				System.exit(0);
			}
		}
		
	}
	
	public JFrame getJFrameMainMenu() {
		return mainFrame;
	}
}


