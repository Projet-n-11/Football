package gui.elements;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		mainFrame=new JFrame();
		initLayout();
	}

	public void initLayout() {
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		JPanel jp3=new JPanel();
		JPanel jp4=new JPanel();
		JPanel jp5=new JPanel();
	
		jp1.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp3.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp4.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp5.setLayout(new FlowLayout(FlowLayout.CENTER));
	
		simulator=new JLabel("FOOTBALL SIMULATOR");
		simulator.setForeground(Color.RED);
		jp1.add(simulator);
		
		kickOff=new JButton("Kick-off");
		kickOff.setMinimumSize(getSize());
		
		kickOff.addActionListener(new ActionKickOff());
		jp2.add(kickOff);
		
		options =new JButton("Options");
		options.setSize(300,400);
		options.addActionListener(new ActionOptions());
		jp3.add(options);
		
		credits=new JButton("Credits");
		credits.setSize(300,400);
		credits.addActionListener(new ActionCredits());
		jp4.add(credits);
		
		leave=new JButton("Quit the game");
		leave.addActionListener(new ActionLeave());
		leave.setSize(200,400);
		jp5.add(leave);
		
		mainFrame.getContentPane().setLayout(new GridLayout(6,1));
		mainFrame.getContentPane().add(jp1);
		mainFrame.getContentPane().add(jp2);
		mainFrame.getContentPane().add(jp3);
		mainFrame.getContentPane().add(jp4);
		mainFrame.getContentPane().add(jp5);
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
			KickOffMenu kick=new KickOffMenu();
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


