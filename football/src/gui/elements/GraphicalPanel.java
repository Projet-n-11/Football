package gui.elements;

import datateam.DataTeam;
import process.management.CreaTeam;
import process.management.RecupTeam;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import dataplayer.DataPlayer;
import process.management.RecupTeam;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class GraphicalPanel extends JFrame {
	
	
	/**
	 * 
	 */
	private JFrame mainFrame;
	private static final long serialVersionUID = 1L;
	private JLabel simulator;
	private JButton kickOff;
	private JButton options;
	private JButton credits;
	
	private JButton leave;
	
	public GraphicalPanel() {
		this("Fooball Game");
	}
	
	public GraphicalPanel(String title) {
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

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.pack();
		mainFrame.setPreferredSize(null);
		mainFrame.setVisible(true);
		
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
			
			GridBagLayout grid= new GridBagLayout();
			GridBagConstraints gbc= new GridBagConstraints();
			
            gbc.fill = GridBagConstraints.HORIZONTAL;
			mainFrame.setLayout(grid);
			mainFrame.setTitle("Football Game");
			
			gbc.fill=GridBagConstraints.REMAINDER;
			gbc.gridx= 0;
			gbc.gridy=0;
			gbc.gridwidth=2;
			mainFrame.add(new JLabel("Choose your team:"),gbc);
			
			gbc.fill=GridBagConstraints.HORIZONTAL;
			gbc.gridx=0;
			gbc.gridy=1;
			
			gbc.gridheight=3;
			try {
				ComboBoxModel modelMere = choosingTeams();
				ComboBoxModel modelFrance = playersTitularTeam("France");
				ComboBoxModel modelBrazil = playersTitularTeam("Brazil");
				JComboBox mere=new JComboBox(modelMere);
				JComboBox fille =new JComboBox();
				mere.addItemListener(new ItemListener(){
					public void itemStateChanged(ItemEvent e) {
						
						if(mere.getSelectedItem().equals("France")) {
							
							fille.setModel(modelFrance);
							
						}
						else if(mere.getSelectedItem().equals("Brazil")) {
							
							fille.setModel(modelBrazil);
							
						}
					} 
				});
				mainFrame.add(mere,gbc);
				gbc.fill=GridBagConstraints.HORIZONTAL;
				gbc.gridx=2;
				gbc.gridy=1;
				
				gbc.gridheight=3;
				mainFrame.add(fille,gbc);
			}
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
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
	
	private DefaultComboBoxModel choosingTeams() throws IOException {
		
		DefaultComboBoxModel equipe;
		String [] tabName = new String[50];
		ArrayList<String> nameteam= RecupTeam.getCountriesNames();
		int i=0;
		for(Iterator<String> it= nameteam.iterator(); it.hasNext();) {
			tabName[i]=it.next();
			i++;
		}
		
		equipe=new DefaultComboBoxModel(tabName);
	
		return equipe;
	}
	private void initJFrame(JFrame frame) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//this.pack();
		frame.setPreferredSize(null);
		frame.setVisible(true);
	}
	
	private DefaultComboBoxModel playersTitularTeam(String teamName) throws IOException {
		DefaultComboBoxModel players;
		String [] tabPlayer=new String[23];
		DataTeam team= CreaTeam.creaTeam(teamName);
		HashMap<String,DataPlayer> hm=team.getPlayers();
		
		ArrayList<DataPlayer> values=new ArrayList<>(hm.values());
		int i=0;
		
		for(DataPlayer dp : values) {
			if(dp.getPlayerType().getTitularPlayer()==1) {
				tabPlayer[i]= dp.getPlayerName()+ " : " + dp.getPlayerType().getPlayerTypeName();
				i++;
			}
		}
		players=new DefaultComboBoxModel(tabPlayer);
		
		return players;
		
	}
	
}
