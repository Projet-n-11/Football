package gui.elements;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import databall.DataBall;
import dataplayer.DataPlayer;
import datateam.DataTeam;
import process.management.ConstantPosition;
import process.management.CreaTeam;
import process.management.RecupTeam;

public class KickOffMenu extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	public KickOffMenu() {
		this("Configuration");
	}
	
	public KickOffMenu(String title) {
		panel= new JPanel();
		
	}
	
	public JPanel createKickOff() {
		try{
			JLabel choice=new JLabel("Choose your team :");
			JButton startButton = new JButton("Start");
			JButton returnButton = new JButton("Back to Main Menu");
			JList<String> filleT =new JList<String>();
			JScrollPane jsfilleT = new JScrollPane();
			JList<String> filleS= new JList<String>();
			JScrollPane jsfilleS = new JScrollPane();
			ComboBoxModel<String> modelMere = choosingTeams();
			ComboBoxModel<String> modelTFrance = playersTitularTeam("France");
			ComboBoxModel<String> modelTBrazil = playersTitularTeam("Brazil");
			ComboBoxModel<String> modelSFrance= playersSubstituteTeam("France");
			ComboBoxModel<String> modelSBrazil = playersSubstituteTeam("Brazil");
			JComboBox<String> mere=new JComboBox(modelMere);
			ButtonGroup group = new ButtonGroup();
			JRadioButton  tactics343 = new JRadioButton ("3-4-3");
			JRadioButton  tactics424 = new JRadioButton ("4-2-4");
			JRadioButton  tactics235 = new JRadioButton ("2-3-5");
			JPanel tactics = new JPanel();
			JLabel tacticsLabel = new JLabel("Select your tactics !");
			GridBagConstraints gc = new GridBagConstraints();
			
	        gc.fill = GridBagConstraints.CENTER;
	        gc.insets = new Insets(10, 10, 10, 10);;
			panel.setLayout(new GridBagLayout());
			tactics.setLayout(new GridBagLayout());
			tactics343.setMnemonic(KeyEvent.VK_C); 
			tactics343.setSelected(true);
			tactics424.setMnemonic(KeyEvent.VK_C); 
			tactics424.setSelected(false);
			tactics235.setMnemonic(KeyEvent.VK_C); 
			tactics235.setSelected(false);
			group.add(tactics343);
			group.add(tactics424);
			group.add(tactics235);
			gc.gridx = 0;
	        gc.gridy = 0;
			tactics.add(tacticsLabel, gc);
			gc.gridx = 0;
	        gc.gridy = 1;
			tactics.add(tactics343, gc);
			gc.gridx = 1;
	        gc.gridy = 1;
			tactics.add(tactics424, gc);
			gc.gridx = 2;
	        gc.gridy = 1;
			tactics.add(tactics235, gc);
			jsfilleT.setViewportView(filleT);
			jsfilleS.setViewportView(filleS);
			
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
					else {
						String TitularPlayers[] = {"Choose", "Your", "Team", "To", "Get", "Titular", "Players..."};
						final DefaultComboBoxModel<String> modelTitular = new DefaultComboBoxModel<String>(TitularPlayers);
						String SubstitutePlayers[] = {"Choose", "Your", "Team", "To", "Get", "Substitute", "Players..."};
						final DefaultComboBoxModel<String> modelSubstitute = new DefaultComboBoxModel<String>(SubstitutePlayers);
						filleT.setModel(modelTitular);
						filleS.setModel(modelSubstitute);
					}
				} 
			});
			
			startButton.setSize(200,400);
			startButton.addActionListener(new ActionStart());
			returnButton.setSize(200,400);
			returnButton.addActionListener(new ActionReturn());
			gc.fill = GridBagConstraints.HORIZONTAL;
			
			gc.gridx = 0;
	        gc.gridy = 0;
			panel.add(choice, gc);
			gc.gridx = 0;
	        gc.gridy = 1;
			panel.add(mere,gc);
			gc.gridx = 0;
	        gc.gridy = 2;
			panel.add(new JLabel("Joueurs Titulaires"), gc);
			gc.gridx = 0;
	        gc.gridy = 3;
			panel.add(jsfilleT, gc);
			gc.gridx = 0;
	        gc.gridy = 4;
			panel.add(new JLabel("Joueurs Remplaçants"), gc);
			gc.gridx = 0;
	        gc.gridy = 5;
			panel.add(jsfilleS, gc);
			gc.gridx = 0;
	        gc.gridy = 6;
			panel.add(returnButton, gc);
			gc.gridx = 0;
	        gc.gridy = 7;
			panel.add(startButton, gc);
			gc.gridx = 2;
	        gc.gridy = 3;
			panel.add(tactics, gc);
		}
		catch (IOException e1){
			System.err.println("erreur");
		}
		return panel;
		
	}
	
	public class ActionStart implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			panel.removeAll();
			DataTeam team1 = null;
			DataTeam team2 = null;
			try {
				team1 = CreaTeam.creaTeam("France");
				team2 = CreaTeam.creaTeam("Brazil");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			DataBall ball = new DataBall(ConstantPosition.ENGAGEMENTX, ConstantPosition.ENGAGEMENTY);
			MatchScreen match = new MatchScreen(team1, team2, ball);
			
			panel.setLayout(new BorderLayout());
			panel.setSize(1300,800);
			panel.setLocation(350,150);
			panel.setVisible(true);
			panel.add(match);
			panel.repaint();
		}
			
	}
	public class ActionReturn implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			MainMenu mm = new MainMenu();
			
			panel.setLayout(new BorderLayout());
			panel.setSize(1300,800);
			panel.setLocation(350,150);
			panel.setVisible(true);
			panel.add(mm);
			panel.repaint();
		}
			
	}
	
	private void initJFrame(JFrame frame) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.pack();
		frame.setPreferredSize(null);
		frame.setVisible(true);
	}
	
	private DefaultComboBoxModel<String> choosingTeams() throws IOException {
		
		DefaultComboBoxModel<String>equipe;
		
		ArrayList<String> nameteam= RecupTeam.getCountriesNames();
		String [] tabName = new String[nameteam.size()+1];
		int i=0;
		tabName[i] = "Choose your team...";
		i++;
		for(Iterator<String> it= nameteam.iterator(); it.hasNext();) {
			tabName[i]=it.next();
			i++;
		}
	
	
		equipe=new DefaultComboBoxModel<String>(tabName);

		return equipe;
	}
	
	private DefaultComboBoxModel<String> playersSubstituteTeam(String teamName) throws IOException {
		DefaultComboBoxModel<String> substitute;
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
		substitute=new DefaultComboBoxModel<String>(tabPlayer);
		
		return substitute;
	}
	
	private DefaultComboBoxModel<String> playersTitularTeam(String teamName) throws IOException {
		DefaultComboBoxModel<String> players;
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
		players=new DefaultComboBoxModel<String>(tabPlayer);
		
		return players;
		
	}
}	
	

	