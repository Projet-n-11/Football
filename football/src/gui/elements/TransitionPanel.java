package gui.elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.TransferHandler;

import dataplayer.DataPlayer;
import datateam.DataTeam;
import process.management.CreaTeam;

public class TransitionPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private JFrame frame;
	private JPanel panel, tactics, players, tacticsLabelPanel;
	private JLabel choice, tacticsPlayersLabel, titularLabel, substituteLabel;
	private JButton resumeButton, returnButton;
	private JList<String> filleT, filleS;
	private JScrollPane jsfilleT, jsfilleS;
	private DefaultListModel<String> modelTPlayerTeam, modelSPlayerTeam;
	private ButtonGroup group;
	private JRadioButton tactics343, tactics424, tactics235, tactics352, tactics433;
	private GridBagConstraints gc;
	private DataTeam playerTeam;
	
	private boolean resumed;

	public TransitionPanel(String title, JFrame frame, DataTeam playerTeam) {
		panel = new JPanel();
		this.playerTeam = playerTeam;
		this.frame = frame;
		this.resumed = false;
		panel.setBackground(new Color(245, 235, 200));
	}

	public JPanel createTransitionPanel() {
		try{
			choice = new JLabel("Change your current tactics/players or leave it!");
			resumeButton = new JButton("Resume");
			returnButton = new JButton("Back to Main Menu");

			filleT = new JList<String>();
			filleS = new JList<String>();
			jsfilleT = new JScrollPane();
			jsfilleS = new JScrollPane();
			
			modelTPlayerTeam = playersTitularTeam(playerTeam);
			modelSPlayerTeam = playersSubstituteTeam(playerTeam);
			
			filleT.setModel(modelTPlayerTeam);
			filleS.setModel(modelSPlayerTeam);
			
			group = new ButtonGroup();

			tactics343 = new JRadioButton ("3-4-3");
			tactics343.setBackground(new Color(255, 255, 255));
			tactics424 = new JRadioButton ("4-2-4");
			tactics424.setBackground(new Color(255, 255, 255));
			tactics235 = new JRadioButton ("2-3-5");
			tactics235.setBackground(new Color(255, 255, 255));
			tactics352 = new JRadioButton ("3-5-2");
			tactics352.setBackground(new Color(255, 255, 255));
			tactics433 = new JRadioButton ("4-3-3");
			tactics433.setBackground(new Color(255, 255, 255));
			tactics = new JPanel();
			tactics.setBackground(new Color(245, 235, 200));
			
			tacticsLabelPanel = new JPanel();
			tacticsLabelPanel.setBackground(new Color(245, 235, 200));
			
			players = new JPanel();
			players.setBackground(new Color(245, 235, 200));

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
			jsfilleT.setViewportView(filleT);
			
			resumeButton.setBackground(new Color(255, 255, 255));
			resumeButton.setFocusPainted(false);
			resumeButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					if(filleT.getModel().getSize() == 11 && filleS.getModel().getSize() == 12) {
						boolean everythingFine = false;
						
						DataTeam teamPlayer = playerTeam;
						
						if(tactics343.isSelected()) {
							teamPlayer.setDefaultStrategy(new int[] {3,4,3});
						}
						else if(tactics424.isSelected()) {
							teamPlayer.setDefaultStrategy(new int[] {4,2,4});
						}
						else if(tactics235.isSelected()) {
							teamPlayer.setDefaultStrategy(new int[] {2,3,5});
						}
						else if(tactics352.isSelected()) {
							teamPlayer.setDefaultStrategy(new int[] {3,5,2});
						}
						else if(tactics433.isSelected()) {
							teamPlayer.setDefaultStrategy(new int[] {4,3,3});
						}
						
						Collection<DataPlayer> playersList = teamPlayer.getPlayers().values();
						
						for(DataPlayer players: playersList) {
							for(int nb_elts=0; nb_elts < filleT.getModel().getSize(); nb_elts++) {
								if(filleT.getModel().getElementAt(nb_elts).contains(players.getPlayerName())) {
									players.setPlayerTitular(1);
								}
							}

							for(int nb_elts=0; nb_elts < filleS.getModel().getSize(); nb_elts++) {
								if(filleS.getModel().getElementAt(nb_elts).contains(players.getPlayerName())) {
									players.setPlayerTitular(0);					
								}
							}
						}

						int defenders = 0;
						int midfielders = 0;
						int forward = 0;
						int goalie = 0;

						for(DataPlayer players: playersList) {
							if(players.getPlayerType().getTitularPlayer() == 1 && players.getPlayerType().getPlayerTypeName() == "Defender") {
								defenders++;
							}
							else if(players.getPlayerType().getTitularPlayer() == 1 && players.getPlayerType().getPlayerTypeName() == "Midfielder") {
								midfielders++;
							}
							else if(players.getPlayerType().getTitularPlayer() == 1 && players.getPlayerType().getPlayerTypeName() == "Forward") {
								forward++;
							}
							else if(players.getPlayerType().getTitularPlayer() == 1 && players.getPlayerType().getPlayerTypeName() == "Goalie") {
								goalie++;
							}
						}

						if(goalie == 1 && defenders == 4 && midfielders == 3 && forward == 3 
								&& teamPlayer.getDefaultStrategy(0) == 4 && teamPlayer.getDefaultStrategy(1) == 3 && teamPlayer.getDefaultStrategy(2) == 3) {
							everythingFine = true;
						}
						else if(goalie == 1 && defenders == 3 && midfielders == 5 && forward == 2  
								&& teamPlayer.getDefaultStrategy(0) == 3 && teamPlayer.getDefaultStrategy(1) == 5 && teamPlayer.getDefaultStrategy(2) == 2) {
							everythingFine = true;
						}
						else if(goalie == 1 && defenders == 2 && midfielders == 3 && forward == 5  
								&& teamPlayer.getDefaultStrategy(0) == 2 && teamPlayer.getDefaultStrategy(1) == 3 && teamPlayer.getDefaultStrategy(2) == 5) {
							everythingFine = true;
						}
						else if(goalie == 1 && defenders == 4 && midfielders == 2 && forward == 4  
								&& teamPlayer.getDefaultStrategy(0) == 4 && teamPlayer.getDefaultStrategy(1) == 2 && teamPlayer.getDefaultStrategy(2) == 4) {
							everythingFine = true;
						}
						else if(goalie == 1 && defenders == 3 && midfielders == 4 && forward == 3  
								&& teamPlayer.getDefaultStrategy(0) == 3 && teamPlayer.getDefaultStrategy(1) == 4 && teamPlayer.getDefaultStrategy(2) == 3) {
							everythingFine = true;
						}

						if(everythingFine == true) {
							setResumedTrue();
							playerTeam = teamPlayer;
						}
					}
					else {
						JPanel errorPanel = new JPanel();
						JLabel labERROR = new JLabel("");
						if(filleT.getModel().getSize() != 11 && filleS.getModel().getSize() != 12) {
							labERROR = new JLabel("Either you select a new tactic or not, but you MUST have 11 Titular Players and 12 Substitute Players!"
										, JLabel.CENTER);
						}
						else {
							errorPanel.removeAll();
							errorPanel.repaint();
						}
						
						labERROR.setFont(new Font("", Font.BOLD, 15));
						labERROR.setForeground(Color.RED);
						errorPanel.add(labERROR);
						errorPanel.setBackground(new Color(245, 235, 200));
						errorPanel.repaint();
						gc.gridx = 0;
						gc.gridy = 5;
						panel.add(errorPanel, gc);
						panel.revalidate();
					}
				}
			});

			returnButton.setSize(200,400);
			returnButton.setBackground(new Color(255, 255, 255));
			returnButton.setFocusPainted(false);
			returnButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.removeAll();
					frame.dispose();
					MainMenu mm = new MainMenu();
					panel.setLayout(new BorderLayout());
					panel.setSize(1300,800);
					panel.setLocation(350,150);
					panel.setVisible(true);
					panel.add(mm);
					panel.repaint();
				}
			});
			addObjectstoPanel();
		}
		catch (IOException e1){
			e1.printStackTrace();
		}
		
		return panel;

	}

	public DataTeam actualizedTeam() {
		return playerTeam;
	}
	
	public DefaultListModel<String> playersSubstituteTeam(DataTeam playerTeam) throws IOException {
		DefaultListModel<String> substitute;
		String [] tabPlayer = new String[12];
		DataTeam team = playerTeam;
		HashMap<String,DataPlayer> hm = team.getPlayers();

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

	public DefaultListModel<String> playersTitularTeam(DataTeam playerTeam) throws IOException {
		DefaultListModel<String> players;
		String [] tabPlayer=new String[11];
		DataTeam team = playerTeam;
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
		titularLabel = new JLabel("Titular players : " + filleT.getModel().getSize() + " players");
		substituteLabel = new JLabel("Substitute players : " + filleS.getModel().getSize() + " players");
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
		tacticsPlayersLabel = new JLabel("Select your tactics, and select the right players :");
		tactics.setLayout(new GridBagLayout());
		tacticsLabelPanel.setLayout(new BorderLayout());
		tactics343.setMnemonic(KeyEvent.VK_C);
		tactics343.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				tacticsLabelPanel.removeAll();
				tacticsPlayersLabel = new JLabel("Select 3 defenders, 4 midfielders and 3 fowards");
				tacticsLabelPanel.add(tacticsPlayersLabel);
				tacticsLabelPanel.revalidate();
			}
		});
		tactics424.setMnemonic(KeyEvent.VK_C);
		tactics424.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				tacticsLabelPanel.removeAll();
				tacticsPlayersLabel = new JLabel("Select 4 defenders, 2 midfielders and 4 fowards");
				tacticsLabelPanel.add(tacticsPlayersLabel);
				tacticsLabelPanel.revalidate();
			}
		});
		tactics235.setMnemonic(KeyEvent.VK_C);
		tactics235.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				tacticsLabelPanel.removeAll();
				tacticsPlayersLabel = new JLabel("Select 2 defenders, 3 midfielders and 5 fowards");
				tacticsLabelPanel.add(tacticsPlayersLabel);
				tacticsLabelPanel.revalidate();
			}
		});
		tactics352.setMnemonic(KeyEvent.VK_C);
		tactics352.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				tacticsLabelPanel.removeAll();
				tacticsPlayersLabel = new JLabel("Select 3 defenders, 5 midfielders and 2 fowards");
				tacticsLabelPanel.add(tacticsPlayersLabel);
				tacticsLabelPanel.revalidate();
			}
		});
		tactics433.setMnemonic(KeyEvent.VK_C);
		tactics433.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				tacticsLabelPanel.removeAll();
				tacticsPlayersLabel = new JLabel("Select 4 defenders, 3 midfielders and 3 fowards");
				tacticsLabelPanel.add(tacticsPlayersLabel);
				tacticsLabelPanel.revalidate();
			}
		});
		tacticsLabelPanel.add(tacticsPlayersLabel);
		group.add(tactics343);
		group.add(tactics424);
		group.add(tactics235);
		group.add(tactics352);
		group.add(tactics433);
		gc.fill = GridBagConstraints.VERTICAL;
		gc.gridx = 2;
		gc.gridy = 1;
		panel.add(tacticsLabelPanel, gc);
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridx = 0;
		gc.gridy = 0;
		tactics.add(tactics343, gc);
		gc.gridx = 1;
		gc.gridy = 0;
		tactics.add(tactics424, gc);
		gc.gridx = 2;
		gc.gridy = 0;
		tactics.add(tactics235, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		tactics.add(tactics352, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		tactics.add(tactics433, gc);
	}

	public void addObjectstoPanel() {
		paintPlayers();
		addTactics();
		gc.gridx = 0;
		gc.gridy = 0;
		panel.add(choice, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		panel.add(returnButton, gc);
		gc.gridx = 2;
		gc.gridy = 6;
		panel.add(resumeButton, gc);
		gc.fill = GridBagConstraints.VERTICAL;
		gc.gridx = 2;
		gc.gridy = 3;
		panel.add(tactics, gc);
	}

	public class TransferPlayers extends TransferHandler {

		private static final long serialVersionUID = 1L;
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

			@SuppressWarnings("unchecked")
			JList<String> list = (JList<String>) info.getComponent();
			DefaultListModel<String> listModel = (DefaultListModel<String>) list.getModel();
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
			@SuppressWarnings("unchecked")
			JList<String> list = (JList<String>)c;
			indices = list.getSelectedIndices();
			Object[] values = list.getSelectedValuesList().toArray();

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
				@SuppressWarnings("unchecked")
				JList<String> source = (JList<String>) c;
				DefaultListModel<String> model  = (DefaultListModel<String>)source.getModel();

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

	public boolean isResumed() {
		return resumed;
	}
	
	public void setResumedTrue() {
		resumed = true;
	}
	
	public void setResumedFalse() {
		resumed = false;
	}
}
