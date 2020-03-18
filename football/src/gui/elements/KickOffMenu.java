package gui.elements;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dataplayer.DataPlayer;
import datateam.DataTeam;
import gui.elements.MainMenu.ActionOptions;
import process.management.CreaTeam;
import process.management.RecupTeam;

public class KickOffMenu extends JFrame {
	private JFrame mainFrame;
	
	public KickOffMenu() {
		this("Configuration");
	}
	
	public KickOffMenu(String title) {
		mainFrame= new JFrame();
		
	}
	
	public void createKickOff(JFrame mainFrame) {
		
		try {
		mainFrame.getContentPane().setLayout(new GridLayout(4,1));
		mainFrame.setSize(1000,500);
		System.out.println("essai2");
		JLabel choice=new JLabel("Choose your team :");
		JButton start = new JButton("Start");

		mainFrame.getContentPane().add(choice);
		mainFrame.getContentPane().add(new JLabel(""));
		
		GridLayout grid1=new GridLayout(1,2);
		GridLayout grid2=new GridLayout(1,2);
				
			ComboBoxModel modelMere = choosingTeams();
			ComboBoxModel modelTFrance = playersTitularTeam("France");
			ComboBoxModel modelTBrazil = playersTitularTeam("Brazil");
			ComboBoxModel modelSFrance= playersSubstituteTeam("France");
			ComboBoxModel modelSBrazil = playersSubstituteTeam("Brazil");
			
			JComboBox mere=new JComboBox(modelMere);
			JComboBox filleT =new JComboBox();
			JComboBox filleS= new JComboBox();
			mere.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent e) {
					
					if(mere.getSelectedItem().equals("France")) {
						
						filleT.setModel(modelTFrance);
						filleS.setModel(modelSFrance);
						
					}
					else if(mere.getSelectedItem().equals("Brazil")) {
						
						filleT.setModel(modelTBrazil);
						filleS.setModel(modelSBrazil);
						
					}
				} 
			});
			start.setSize(200,400);
			start.addActionListener(new ActionStart());
			
			mainFrame.getContentPane().add(mere,grid1);
			mainFrame.getContentPane().add(new JLabel(""),grid1);
			mainFrame.getContentPane().add(filleT,grid2);
			mainFrame.getContentPane().add(filleS,grid2);
			mainFrame.getContentPane().add(start, grid1);
			initJFrame(mainFrame);
			
		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			System.err.println("erreur");
		}
			
		
	
	}
	
	private void initJFrame(JFrame frame) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.pack();
		frame.setPreferredSize(null);
		frame.setVisible(true);
	}
	
	public class ActionStart implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			mainFrame.getContentPane().removeAll();
			mainFrame.repaint();
			MatchScreen match = new MatchScreen();
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
	private DefaultComboBoxModel playersSubstituteTeam(String teamName) throws IOException {
		DefaultComboBoxModel substitute;
		String [] tabPlayer=new String[23];
		DataTeam team= CreaTeam.creaTeam(teamName);
		HashMap<String,DataPlayer> hm=team.getPlayers();
		
		ArrayList<DataPlayer> values=new ArrayList<>(hm.values());
		int i=0;
		
		for(DataPlayer dp : values) {
			if(dp.getPlayerType().getTitularPlayer()==0) {
				tabPlayer[i]= dp.getPlayerName()+ " : " + dp.getPlayerType().getPlayerTypeName();
				i++;
			}
		}
		substitute=new DefaultComboBoxModel(tabPlayer);
		
		return substitute;
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
	

	