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


public class MainMenu extends JFrame {
	private JFrame mainFrame;
	
	private JLabel simulator;
	private JButton kickOff;
	private JButton options;
	private JButton credits;
	
	private JButton leave;
	
	public MainMenu() {
		this("Fooball Game");
	}
	
	public MainMenu(String title) {
		mainFrame=new JFrame();
		mainFrame.getContentPane().setLayout(new GridLayout(6,1));
		mainFrame.setSize(1000,500);
		
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
		options.setSize(200,400);
		options.addActionListener(new ActionOptions());
		jp3.add(options);
		
		credits=new JButton("Credits");
		credits.setSize(200,400);
		credits.addActionListener(new ActionCredits());
		jp4.add(credits);
		
		leave=new JButton("Quit the game");
		leave.addActionListener(new ActionLeave());
		leave.setSize(200,400);
		jp5.add(leave);
		
		mainFrame.getContentPane().add(jp1);
		mainFrame.getContentPane().add(jp2);
		mainFrame.getContentPane().add(jp3);
		mainFrame.getContentPane().add(jp4);
		mainFrame.getContentPane().add(jp5);

		initJFrame(mainFrame);
		
	}
	
	public static void main(String[] args) {
		new GraphicalPanel();
	
	}
	/*public void paint(Graphics g)
    {
        try
        {
            Image img=ImageIO.read(new File ("\ressources\icone.jpeg"));
            g.drawImage(img, 0, 0, 1440, 900, this);
            ImageLoader Image=new ImageLoader();
            ImageLoader Image2=new ImageLoader();
            this.add(Image);
            this.add(Image2);
        }
        catch (Exception e )
        {
             
        }
    }*/

	public class ActionKickOff implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			mainFrame.getContentPane().removeAll();
			mainFrame.repaint();
			mainFrame.setSize(1000,500);
			KickOffMenu kick=new KickOffMenu();
			
			mainFrame.getContentPane().setLayout(new GridLayout(1,1));
			mainFrame.getContentPane().add(kick.createKickOff());	
			initJFrame(mainFrame);
		}
		
		
	}
	
	public class ActionOptions implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	public class ActionCredits implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			String message="Produced by : \n ALADDINE BEN ROMDHANE \n LAURA FUSTINONI \n QUITTERIE PILON";
			JOptionPane optionPane=new JOptionPane();
			optionPane.showMessageDialog(null, message, "Credits", JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
	
	public class ActionLeave implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JOptionPane optionPane =new JOptionPane();
			
			int op=optionPane.showConfirmDialog(null, "You sure about that?", "Quit",JOptionPane.YES_NO_OPTION );
			if(op==0) {
				System.exit(0);
			}
		}
		
	}
	
	
	private void initJFrame(JFrame frame) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//this.pack();
		frame.setPreferredSize(null);
		frame.setVisible(true);
		frame.setLocation(450,300);
	}
	
	public JFrame getJFrameMainMenu() {
		return mainFrame;
	}
}


