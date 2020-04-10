package gui.elements;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;
import javax.swing.*;

import databall.DataBall;
import dataplayer.DataPlayer;
import datateam.DataTeam;
import process.management.ConstantPosition;
import process.management.CreaTeam;
import process.management.RecupTeam;
import process.scores.Score;

public class KickOffMenu extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanel panel, tactics, players, tacticsLabelPanel;
	private JLabel choiceP, choiceIA, tacticsPlayersLabel;
	private JButton startButton, returnButton;
	private JList<String> filleT, filleS;
	private JScrollPane jsfilleT, jsfilleS;
	private ComboBoxModel<String> modelP, modelIA;
	private ListModel<String> modelTFrance, modelTBrazil, modelSFrance, modelSBrazil;
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
			choiceP = new JLabel("Choose your team :");
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
			modelSFrance = playersSubstituteTeam("France");
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
			tacticsLabelPanel = new JPanel();
			players = new JPanel();

			gc = new GridBagConstraints();

			filleT.setDragEnabled(true);
			filleT.setTransferHandler(new TransferPlayers());
			filleT.setDropMode(DropMode.INSERT);
			filleS.setDragEnabled(true);
			filleS.setTransferHandler(new TransferPlayers());
			filleS.setDropMode(DropMode.INSERT);

			gc.fill = GridBagConstraints.HORIZONTAL;
			gc.insets = new Insets(10, 10, 10, 10);;
			panel.setLayout(new GridBagLayout());
			players.setLayout(new GridBagLayout());
			jsfilleS.setViewportView(filleS);

			Pteams.addItemListener(new ItemListener(){

				public void itemStateChanged(ItemEvent e) {
					players.removeAll();
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
						final DefaultListModel<String> modelTitular = new DefaultListModel<String>();
						final DefaultListModel<String> modelSubstitute = new DefaultListModel<String>();
						filleT.setModel(modelTitular);
						filleS.setModel(modelSubstitute);
						paintPlayers();
					}
				}
			});

			startButton.setSize(200,400);
			startButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					if(modelP.getSelectedItem().toString() != "Choose your team..." && modelIA.getSelectedItem().toString() != "Choose your team..." 
							&& group.getSelection() != null && filleT.getModel().getSize() == 11 && filleS.getModel().getSize() == 12) {
						panel.removeAll();
						panel.setBorder(BorderFactory.createTitledBorder(""));

						DataTeam teamPlayer = CreaTeam.creaTeam(modelP.getSelectedItem().toString());
						DataTeam teamIA = CreaTeam.creaTeam(modelIA.getSelectedItem().toString());

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
						Score score = new Score(teamPlayer, teamIA);
						MatchScreen match = new MatchScreen(teamPlayer, teamIA, ball, score);

						panel.setLayout(new BorderLayout());
						panel.setSize(1300,800);
						panel.setLocation(350,150);
						panel.setVisible(true);
						panel.add(match);
						panel.repaint();
					}
					else {
						JPanel errorPanel = new JPanel();
						JLabel labERROR = new JLabel("");
						if(modelP.getSelectedItem().toString() == "Choose your team..." && modelIA.getSelectedItem().toString() == "Choose your team..." 
								&& group.getSelection() == null && filleT.getModel().getSize() != 11 && filleS.getModel().getSize() != 12) {
							labERROR = new JLabel("Select your team, IA's team, your tactics and adjust your players to have 11 Titular players!");
						}
						else if(modelP.getSelectedItem().toString() == "Choose your team..." && group.getSelection() == null
								&& filleT.getModel().getSize() != 11 && filleS.getModel().getSize() != 12) {
							labERROR = new JLabel("Select your team, your tactics and adjust your players to have 11 Titular players!");
						}
						else if(modelIA.getSelectedItem().toString() == "Choose your team..." 
								&& group.getSelection() == null && filleT.getModel().getSize() != 11 && filleS.getModel().getSize() != 12) {
							labERROR = new JLabel("Select IA's team, your tactics and adjust your players to have 11 Titular players!");
						}
						else if(group.getSelection() == null && filleT.getModel().getSize() != 11 && filleS.getModel().getSize() != 12) {
							labERROR = new JLabel("Select your tactics and adjust your players to have 11 Titular players!");
						}
						else if(modelP.getSelectedItem().toString() == "Choose your team..." && modelIA.getSelectedItem().toString() == "Choose your team...") {
							labERROR = new JLabel("Select your team and the IA's one!");
						}
						else if(group.getSelection() == null && modelIA.getSelectedItem().toString() == "Choose your team...") {
							labERROR = new JLabel("Select your tactics and select the IA's team !");
						}
						else if(modelP.getSelectedItem().toString() == "Choose your team..." && filleT.getModel().getSize() != 11 && filleS.getModel().getSize() != 12) {
							labERROR = new JLabel("Select your team and adjust your players to have 11 Titular players!");
						}
						else if(filleT.getModel().getSize() != 11 && filleS.getModel().getSize() != 12) {
							labERROR = new JLabel("Adjust your players to have 11 Titular players!");
						}
						else if(group.getSelection() == null) {
							labERROR = new JLabel("Please select your tactics !");
						}
						else if(modelP.getSelectedItem().toString() == "Choose your team...") {
							labERROR = new JLabel("Select your team !");
						}
						else if(modelIA.getSelectedItem().toString() == "Choose your team...") {
							labERROR = new JLabel("Select the IA's team !");
						}
						else {
							errorPanel.removeAll();
							errorPanel.repaint();
						}
						errorPanel.add(labERROR);
						errorPanel.repaint();
						gc.gridx = 0;
						gc.gridy = 5;
						panel.add(errorPanel, gc);
						panel.revalidate();
					}
				}
			});

			returnButton.setSize(200,400);
			returnButton.addActionListener(new ActionReturn());
			addObjectstoPanel();
			panel.setBorder(BorderFactory.createTitledBorder("Select your team"));
		}
		catch (IOException e1){
			e1.printStackTrace();
		}
		return panel;

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

	public DefaultListModel<String> playersSubstituteTeam(String teamName) throws IOException {
		DefaultListModel<String> substitute;
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
		substitute=new DefaultListModel<String>();
		for(int tabLength = 0; tabLength<tabPlayer.length; tabLength++) {
			substitute.addElement(tabPlayer[tabLength]);
		}

		return substitute;
	}

	public DefaultListModel<String> playersTitularTeam(String teamName) throws IOException {
		DefaultListModel<String> players;
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
		players=new DefaultListModel<String>();
		for(int tabLength = 0; tabLength<tabPlayer.length; tabLength++) {
			players.addElement(tabPlayer[tabLength]);
		}

		return players;
	}

	public void paintPlayers(){
		JLabel titularLabel = new JLabel("Titular players : " + filleT.getModel().getSize() + " players");
		JLabel substituteLabel = new JLabel("Substitute players : " + filleS.getModel().getSize() + " players");
		gc.gridx = 0;
		gc.gridy = 1;
		players.add(titularLabel, gc);
		gc.gridx = 0;
		gc.gridy = 0;
		players.add(jsfilleT, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		players.add(substituteLabel, gc);
		gc.gridx = 1;
		gc.gridy = 0;
		players.add(jsfilleS, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		panel.add(players, gc);
		panel.revalidate();
	}

	public void addTactics() {
		tacticsPlayersLabel = new JLabel("Select your tactics, and choose the right players :");
		tactics.setLayout(new GridBagLayout());
		tacticsLabelPanel.setLayout(new BorderLayout());
		tactics343.setMnemonic(KeyEvent.VK_C);
		tactics343.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				tacticsLabelPanel.removeAll();
				tacticsPlayersLabel = new JLabel("Choose 3 defenders, 4 midfielders and 3 fowards");
				tacticsLabelPanel.add(tacticsPlayersLabel);
				tacticsLabelPanel.revalidate();
			}
		});
		tactics424.setMnemonic(KeyEvent.VK_C);
		tactics424.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				tacticsLabelPanel.removeAll();
				tacticsPlayersLabel = new JLabel("Choose 4 defenders, 2 midfielders and 4 fowards");
				tacticsLabelPanel.add(tacticsPlayersLabel);
				tacticsLabelPanel.revalidate();
			}
		});
		tactics235.setMnemonic(KeyEvent.VK_C);
		tactics235.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				tacticsLabelPanel.removeAll();
				tacticsPlayersLabel = new JLabel("Choose 2 defenders, 3 midfielders and 5 fowards");
				tacticsLabelPanel.add(tacticsPlayersLabel);
				tacticsLabelPanel.revalidate();
			}
		});
		tactics442.setMnemonic(KeyEvent.VK_C);
		tactics442.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				tacticsLabelPanel.removeAll();
				tacticsPlayersLabel = new JLabel("Choose 4 defenders, 4 midfielders and 2 fowards");
				tacticsLabelPanel.add(tacticsPlayersLabel);
				tacticsLabelPanel.revalidate();
			}
		});
		tactics433.setMnemonic(KeyEvent.VK_C);
		tactics433.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				tacticsLabelPanel.removeAll();
				tacticsPlayersLabel = new JLabel("Choose 4 defenders, 3 midfielders and 3 fowards");
				tacticsLabelPanel.add(tacticsPlayersLabel);
				tacticsLabelPanel.revalidate();
			}
		});
		tacticsLabelPanel.add(tacticsPlayersLabel);
		group.add(tactics343);
		group.add(tactics424);
		group.add(tactics235);
		group.add(tactics442);
		group.add(tactics433);
		gc.gridx = 2;
		gc.gridy = 1;
		panel.add(tacticsLabelPanel, gc);
		gc.gridx = 0;
		gc.gridy = 0;
		tactics.add(tactics343, gc);
		gc.gridx = 1;
		gc.gridy = 0;
		tactics.add(tactics424, gc);
		gc.gridx = 2;
		gc.gridy = 0;
		tactics.add(tactics235, gc);
		jsfilleT.setViewportView(filleT);
		gc.gridx = 0;
		gc.gridy = 1;
		tactics.add(tactics442, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		tactics.add(tactics433, gc);
	}

	public void addObjectstoPanel() {
		paintPlayers();
		addTactics();
		gc.gridx = 0;
		gc.gridy = 0;
		panel.add(choiceP, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		panel.add(Pteams,gc);
		gc.gridx = 0;
		gc.gridy = 6;
		panel.add(returnButton, gc);
		gc.gridx = 2;
		gc.gridy = 6;
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

	public class TransferPlayers extends TransferHandler {
		private int[] indices = null;
		private int addIndex = -1; //Location where items were added
		private int addCount = 0;  //Number of items added.

		public boolean canImport(TransferHandler.TransferSupport info) {
			// Check for String flavor
			if (!info.isDataFlavorSupported(DataFlavor.stringFlavor)) {
				return false;
			}
			return true;
		}

		protected Transferable createTransferable(JComponent c) {
			return new StringSelection(exportString(c));
		}

		public int getSourceActions(JComponent c) {
			return TransferHandler.COPY_OR_MOVE;
		}

		public boolean importData(TransferHandler.TransferSupport info) {

			if (!info.isDrop()) {
				return false;
			}

			JList list = (JList)info.getComponent();
			DefaultListModel listModel = (DefaultListModel)list.getModel();
			JList.DropLocation dl = (JList.DropLocation)info.getDropLocation();
			int index = dl.getIndex();
			boolean insert = dl.isInsert();

			// Get the string that is being dropped.
			Transferable t = info.getTransferable();
			String data;
			try {
				data = (String)t.getTransferData(DataFlavor.stringFlavor);
			} 
			catch (Exception e) { 
				return false; 
			}

			// Perform the actual import.  
			if (insert) {
				listModel.add(index, data);
			} else {
				listModel.set(index, data);
			}
			return true;
		}

		protected void exportDone(JComponent c, Transferable data, int action) {
			cleanup(c, action == TransferHandler.MOVE);
		}

		//Bundle up the selected items in the list
		//as a single string, for export.

		protected String exportString(JComponent c) {
			JList list = (JList)c;
			indices = list.getSelectedIndices();
			Object[] values = list.getSelectedValues();

			StringBuffer buff = new StringBuffer();

			for (int i = 0; i < values.length; i++) {
				Object val = values[i];
				buff.append(val == null ? "" : val.toString());
				if (i != values.length - 1) {
					buff.append("\n");
				}
			}

			return buff.toString();
		}

		//If the remove argument is true, the drop has been
		//successful and it's time to remove the selected items 
		//from the list. If the remove argument is false, it
		//was a Copy operation and the original list is left
		//intact.
		protected void cleanup(JComponent c, boolean remove) {
			if (remove && indices != null) {
				JList source = (JList)c;
				DefaultListModel model  = (DefaultListModel)source.getModel();

				//If we are moving items around in the same list, we
				//need to adjust the indices accordingly, since those
				//after the insertion point have moved.

				if (addCount > 0) {
					for (int i = 0; i < indices.length; i++) {
						if (indices[i] > addIndex) {
							indices[i] += addCount;
						}
					}
				}
				for (int i = indices.length - 1; i >= 0; i--) {
					model.remove(indices[i]);
				}
			}
			indices = null;
			addCount = 0;
			addIndex = -1;
		}
	}

}	