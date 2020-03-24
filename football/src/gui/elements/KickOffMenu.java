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

public class KickOffMenu extends JPanel {
	
	private JPanel panel;
	public KickOffMenu() {
		this("Configuration");
	}
	
	public KickOffMenu(String title) {
		panel= new JPanel();
		
	}
	
	public JPanel createKickOff() {
		
		try {
		
		
		JLabel choice=new JLabel("Choose your team :");
		JButton start = new JButton("Start");
		panel.setLayout(new GridLayout(4,1));
		panel.add(choice);
		panel.add(new JLabel(""));
		
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
			
			panel.add(mere,grid1);
			panel.add(new JLabel(""),grid1);
			panel.add(filleT,grid2);
			panel.add(filleS,grid2);
			panel.add(start, grid1);
		
			
		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			System.err.println("erreur");
		}
			
		return panel;
	
	}
	
	
	
	public class ActionStart implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			panel.removeAll();
			MatchScreen match = new MatchScreen();
			panel= match.initLayout();
			
		}
			
	}
	private void initJFrame(JFrame frame) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.pack();
		frame.setPreferredSize(null);
		frame.setVisible(true);
	}
	private DefaultComboBoxModel choosingTeams() throws IOException {
		
		DefaultComboBoxModel equipe;
		
		ArrayList<String> nameteam= RecupTeam.getCountriesNames();
		String [] tabName = new String[nameteam.size()];
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
	

	