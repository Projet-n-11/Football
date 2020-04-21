package gui.elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JButton rules;
	private JButton credits;
	private GridBagConstraints c;
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
		c = new GridBagConstraints();
		
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
		simulatorPanel.setBackground(new Color(245, 235, 200));

		kickOff=new JButton("Kick-off");
		kickOff.setPreferredSize(new Dimension(200, 50));
		kickOff.setBackground(new Color(255, 255, 255));
		kickOff.setFocusPainted(false);
		kickOff.addActionListener(new ActionKickOff());
		kickOffPanel.add(kickOff);
		kickOffPanel.setBackground(new Color(245, 235, 200));
		
		rules=new JButton("Rules");
		rules.setPreferredSize(new Dimension(200, 50));
		rules.setBackground(new Color(255, 255, 255));
		rules.setFocusPainted(false);
		rules.addActionListener(new ActionRules());
		optionsPanel.add(rules);
		optionsPanel.setBackground(new Color(245, 235, 200));
		
		credits=new JButton("Credits");
		credits.setPreferredSize(new Dimension(200, 50));
		credits.setBackground(new Color(255, 255, 255));
		credits.setFocusPainted(false);
		credits.addActionListener(new ActionCredits());
		creditsPanel.add(credits);
		creditsPanel.setBackground(new Color(245, 235, 200));
		
		leave=new JButton("Quit the game");
		leave.addActionListener(new ActionLeave());
		leave.setPreferredSize(new Dimension(200, 50));
		leave.setBackground(new Color(255, 255, 255));
		leave.setFocusPainted(false);
		leavePanel.add(leave);
		leavePanel.setBackground(new Color(245, 235, 200));
		
		panelButtons.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panelButtons.add(simulatorPanel, c);
		c.gridx = 0;
		c.gridy = 2;
		panelButtons.add(kickOffPanel, c);
		c.gridx = 0;
		c.gridy = 3;
		panelButtons.add(optionsPanel, c);
		c.gridx = 0;
		c.gridy = 4;
		panelButtons.add(creditsPanel, c);
		c.gridx = 0;
		c.gridy = 5;
		panelButtons.add(leavePanel, c);
		
		mainFrame.getContentPane().setLayout(new BorderLayout());
		panelButtons.setBackground(new Color(245, 235, 200));
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
			KickOffMenu kick = new KickOffMenu("KickOffMenu", getJFrameMainMenu());
			mainFrame.getContentPane().setLayout(new GridLayout(1,1));
			mainFrame.getContentPane().add(kick.createKickOff());	
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainFrame.setPreferredSize(null);
			mainFrame.setVisible(true);
		}
	}
	
	public class ActionRules implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String message= "After launching the kickoff menu, you have to choose a team from the list of the 5 proposed teams.\n" 
					+"You must then choose a tactic. Depending on the tactic you have chosen, you must change the titular and substitute players,\n"
					+"by dragging them from one square to another so that the number of each type of player (goalkeeper, defenders, midfielders and forwards) matches the tactic you have chosen. \n" 
					+"For example, if you choose the 3-4-3 tactic, you will need 1 goalkeeper, 3 defenders, 4 midfielders and 3 forwards in the starting players.\n"
					+"In case the players do not match the chosen tactic, an error message will appear asking you to rectify.\n" 
					+"You must then choose the team you want to play against. All you have to do is start the game by pressing the start button. \n"  
					+"You will then be able to adapt your tactics and change the starting players every 10 minutes (match time, not real time) according to the game progress.\n"
					+"For example, adopt a more defensive tactic in case you are ahead of the game.\n" 
					+"Now it's your turn to play ";
					

				
			JOptionPane.showMessageDialog(null, message, "Options Menu", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public class ActionCredits implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			String message="Produced by :\nALADDINE BEN ROMDHANE\nLAURA FUSTINONI\nQUITTERIE PILON" + "\n Thanks to : TIANXIAO LIU";
			JOptionPane.showMessageDialog(null, message, "Credits Menu", JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
	
	public class ActionLeave implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			int op=JOptionPane.showConfirmDialog(null, "You sure about that?", "Quit",JOptionPane.YES_NO_OPTION);
			if(op==0) {
				System.exit(0);
			}
		}
		
	}
	
	public JFrame getJFrameMainMenu() {
		return mainFrame;
	}
	
}


