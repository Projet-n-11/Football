package gui.elements;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import javax.swing.JComboBox;
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
	
	private static final long serialVersionUID = 1L;
	
	private JPanel panel, tactics;
	private JLabel choiceP, choiceIA, tacticsLabel;
	private JButton startButton, returnButton;
	private JList<String> filleT, filleS;
	private JScrollPane jsfilleT, jsfilleS;
	private ComboBoxModel<String> modelP, modelTFrance, modelTBrazil, modelSFrance, modelSBrazil, modelIA;
	private JComboBox<String> Pteams, IAteams;
	private ButtonGroup group;
	private JRadioButton tactics343, tactics424, tactics235, tactics442, tactics433;
	
	private GridBagConstraints gc;
	
	public KickOffMenu() {
		this("Configuration");
	}
	
	public KickOffMenu(String title) {
		panel= new JPanel();
	}
	
	public JPanel createKickOff() {
		try{
			choiceP=new JLabel("Choose your team :");
			choiceIA = new JLabel("Choose the IA team : ");
			startButton = new JButton("Start");
			returnButton = new JButton("Back to Main Menu");
			filleT = new JList<String>();
			filleS= new JList<String>();
			jsfilleT = new JScrollPane();
			jsfilleS = new JScrollPane();
			modelP = choosingTeams();
			modelTFrance = playersTitularTeam("France");
			modelTBrazil = playersTitularTeam("Brazil");
			modelSFrance= playersSubstituteTeam("France");
			modelSBrazil = playersSubstituteTeam("Brazil");
			modelIA = choosingTeams();
			Pteams= new JComboBox<String>(modelP);
			IAteams = new JComboBox<String>(modelIA);
			group = new ButtonGroup();
			tactics343 = new JRadioButton ("3-4-3");
			tactics424 = new JRadioButton ("4-2-4");
			tactics235 = new JRadioButton ("2-3-5");
			tactics442 = new JRadioButton ("4-4-2");
			tactics433 = new JRadioButton ("4-3-3");
			tactics = new JPanel();
			tacticsLabel = new JLabel("Select your tactics !");
			gc = new GridBagConstraints();
			
	        gc.fill = GridBagConstraints.HORIZONTAL;
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
			group.add(tactics442);
			group.add(tactics433);
			gc.gridx = 0;
	        gc.gridy = 0;
			tactics.add(tacticsLabel, gc);
			gc.gridx = 1;
	        gc.gridy = 0;
			tactics.add(tactics343, gc);
			gc.gridx = 1;
	        gc.gridy = 1;
			tactics.add(tactics424, gc);
			gc.gridx = 1;
	        gc.gridy = 2;
			tactics.add(tactics235, gc);
			jsfilleT.setViewportView(filleT);
			gc.gridx = 2;
	        gc.gridy = 0;
			tactics.add(tactics442, gc);
			gc.gridx = 2;
	        gc.gridy = 1;
			tactics.add(tactics433, gc);
			jsfilleS.setViewportView(filleS);
			
			Pteams.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent e) {
					if(Pteams.getSelectedItem().equals("France")) {
						filleT.setModel(modelTFrance);
						filleS.setModel(modelSFrance);
						paintPlayers();	
					}
					else if(Pteams.getSelectedItem().equals("Brazil")) {
						filleT.setModel(modelTBrazil);
						filleS.setModel(modelSBrazil);
						paintPlayers();
					}
					else {
						String TitularPlayers[] = {"Choose your team to get Titular players..."};
						String SubstitutePlayers[] = {"Choose your team to get Substitute players..."};
						
						final DefaultComboBoxModel<String> modelTitular = new DefaultComboBoxModel<String>(TitularPlayers);
						final DefaultComboBoxModel<String> modelSubstitute = new DefaultComboBoxModel<String>(SubstitutePlayers);
						
						filleT.setModel(modelTitular);
						filleS.setModel(modelSubstitute);
					}
				}
			});
			
			startButton.setSize(200,400);
			startButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					if(modelP.getSelectedItem().toString() != "Choose your team..." && modelIA.getSelectedItem().toString() != "Choose your team...") {
						panel.removeAll();
						DataTeam teamPlayer = null;
						DataTeam teamIA = null;
						try {
							teamPlayer = CreaTeam.creaTeam(modelP.getSelectedItem().toString());
							teamIA = CreaTeam.creaTeam(modelIA.getSelectedItem().toString());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
						if(tactics343.isSelected()) {
							teamPlayer.setDefaultStrategy(new int[] {3,4,3});
						}
						else if(tactics424.isSelected()) {
							teamPlayer.setDefaultStrategy(new int[] {4,2,4});
						}
						else if(tactics235.isSelected()) {
							teamPlayer.setDefaultStrategy(new int[] {2,3,5});
						}
						else if(tactics442.isSelected()) {
							teamPlayer.setDefaultStrategy(new int[] {4,4,2});
						}
						else if(tactics433.isSelected()) {
							teamPlayer.setDefaultStrategy(new int[] {4,3,3});
						}
						
						DataBall ball = new DataBall(ConstantPosition.ENGAGEMENTX, ConstantPosition.ENGAGEMENTY);
						MatchScreen match = new MatchScreen(teamPlayer, teamIA, ball);
						
						panel.setLayout(new BorderLayout());
						panel.setSize(1300,800);
						panel.setLocation(350,150);
						panel.setVisible(true);
						panel.add(match);
						panel.repaint();
					}
				}
			});
			
			returnButton.setSize(200,400);
			returnButton.addActionListener(new ActionReturn());
			
			gc.gridx = 0;
	        gc.gridy = 0;
			panel.add(choiceP, gc);
			gc.gridx = 0;
	        gc.gridy = 1;
			panel.add(Pteams,gc);
			gc.gridx = 0;
	        gc.gridy = 6;
			panel.add(returnButton, gc);
			gc.gridx = 0;
	        gc.gridy = 7;
			panel.add(startButton, gc);
			gc.gridx = 2;
	        gc.gridy = 3;
			panel.add(tactics, gc);
			gc.gridx = 2;
			gc.gridy = 4;
			panel.add(choiceIA, gc);
			gc.gridx = 2;
			gc.gridy = 5;
			panel.add(IAteams, gc);
		}
		catch (IOException e1){
			System.err.println("erreur");
		}
		return panel;
		
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
	
	public DefaultComboBoxModel<String> choosingTeams() throws IOException {
		
		DefaultComboBoxModel<String> equipe;
		
		ArrayList<String> nameteam= RecupTeam.getCountriesNames();
		String [] tabName = new String[nameteam.size()+1];
		
		tabName[0] = "Choose your team...";
		int i=1;
		for(Iterator<String> it= nameteam.iterator(); it.hasNext();) {
			tabName[i]=it.next();
			i++;
		}
	
	
		equipe=new DefaultComboBoxModel<String>(tabName);

		return equipe;
	}
	
	public DefaultComboBoxModel<String> playersSubstituteTeam(String teamName) throws IOException {
		DefaultComboBoxModel<String> substitute;
		String [] tabPlayer=new String[12];
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
	
	public DefaultComboBoxModel<String> playersTitularTeam(String teamName) throws IOException {
		DefaultComboBoxModel<String> players;
		String [] tabPlayer=new String[11];
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
	
	public void paintPlayers() {
		gc.gridx = 0;
        gc.gridy = 2;
		panel.add(new JLabel("Joueurs Titulaires : " + filleT.getModel().getSize() + " joueurs"), gc);
		gc.gridx = 0;
        gc.gridy = 3;
		panel.add(jsfilleT, gc);
		gc.gridx = 0;
        gc.gridy = 4;
		panel.add(new JLabel("Joueurs Remplaçants : " + filleS.getModel().getSize() + " joueurs"), gc);
		gc.gridx = 0;
        gc.gridy = 5;
		panel.add(jsfilleS, gc);
		panel.revalidate();
	}
}	