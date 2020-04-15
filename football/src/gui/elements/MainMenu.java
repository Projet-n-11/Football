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

import process.management.ConstantValues;


public class MainMenu extends JPanel {
	
	private static final long serialVersionUID = -3358895820336739941L;
	private JFrame mainFrame;
	private JPanel panelButtons, simulatorPanel, kickOffPanel, optionsPanel, creditsPanel, leavePanel;
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
		panelButtons = new JPanel();
		simulatorPanel = new JPanel();
		kickOffPanel = new JPanel();
		optionsPanel = new JPanel();
		creditsPanel = new JPanel();
		leavePanel = new JPanel();
	
		simulatorPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		kickOffPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		optionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		creditsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		leavePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
		ImageIcon img = new ImageIcon(".\\src\\ressources\\menu-img.png");
		simulator=new JLabel("", img, JLabel.CENTER);
		simulator.setFont(new Font("Arial", Font.PLAIN, 40));
		simulator.setForeground(Color.GREEN);
		simulatorPanel.add(simulator);
		simulatorPanel.setBackground(new Color(80, 206, 89));

		kickOff=new JButton("Kick-off");
		kickOff.setSize(new Dimension(300, 100));
		kickOff.setMinimumSize(getSize());
		kickOff.addActionListener(new ActionKickOff());
		kickOffPanel.add(kickOff);
		kickOffPanel.setBackground(new Color(80, 206, 89));
		
		options =new JButton("Options");
		options.setSize(300,400);
		options.addActionListener(new ActionOptions());
		optionsPanel.add(options);
		optionsPanel.setBackground(new Color(80, 206, 89));
		
		credits=new JButton("Credits");
		credits.setSize(300,400);
		credits.addActionListener(new ActionCredits());
		creditsPanel.add(credits);
		creditsPanel.setBackground(new Color(80, 206, 89));
		
		leave=new JButton("Quit the game");
		leave.addActionListener(new ActionLeave());
		leave.setSize(200,400);
		leavePanel.add(leave);
		leavePanel.setBackground(new Color(80, 206, 89));
		
		panelButtons.setLayout(new GridLayout(6,1));
		panelButtons.add(simulatorPanel);
		panelButtons.add(kickOffPanel);
		panelButtons.add(optionsPanel);
		panelButtons.add(creditsPanel);
		panelButtons.add(leavePanel);
		
		mainFrame.getContentPane().setLayout(new BorderLayout());
		panelButtons.setBackground(new Color(80, 206, 89));
		mainFrame.getContentPane().add(panelButtons);
        mainFrame.setSize(ConstantValues.SCREEN_WIDTH,ConstantValues.SCREEN_HEIGHT);
		mainFrame.setLocation(200,130);
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


