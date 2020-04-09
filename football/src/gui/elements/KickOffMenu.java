package gui.elements;

import java.awt.BorderLayout;
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
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
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
			
			filleT.setDragEnabled(true);
			filleT.setTransferHandler(new TransferPlayers());
			filleS.setDragEnabled(true);
			filleS.setTransferHandler(new TransferPlayers());
			
			
	        gc.fill = GridBagConstraints.HORIZONTAL;
	        gc.insets = new Insets(10, 10, 10, 10);;
			panel.setLayout(new GridBagLayout());
			addTactics();
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
						panel.setBorder(BorderFactory.createTitledBorder(""));
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
							panel.add(new JLabel("Choose 3 defenders, 4 midfielders and 3 fowards"), gc);
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
			addObjectstoPanel();
			panel.setBorder(BorderFactory.createTitledBorder("Select your team"));
		}
		catch (IOException e1){
			e1.printStackTrace();
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
	
	public class TransferPlayers extends TransferHandler{
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
        DefaultListModel listModel = (DefaultListModel) list.getModel();
        JList.DropLocation dl = (JList.DropLocation)info.getDropLocation();
        int index = dl.getIndex();
        boolean insert = dl.isInsert();
 
        // Get the string that is being dropped.
        Transferable t = info.getTransferable();
        String data;
        try {
            data = (String)t.getTransferData(DataFlavor.stringFlavor);
        } 
        catch (Exception e) { return false; }
                                 
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
 
    //Take the incoming string and wherever there is a
    //newline, break it into a separate item in the list.
    protected void importString(JComponent c, String str) {
        JList target = (JList)c;
        DefaultListModel listModel = (DefaultListModel)target.getModel();
        int index = target.getSelectedIndex();
 
        //Prevent the user from dropping data back on itself.
        //For example, if the user is moving items #4,#5,#6 and #7 and
        //attempts to insert the items after item #5, this would
        //be problematic when removing the original items.
        //So this is not allowed.
        if (indices != null && index >= indices[0] - 1 &&
              index <= indices[indices.length - 1]) {
            indices = null;
            return;
        }
 
        int max = listModel.getSize();
        if (index < 0) {
            index = max;
        } else {
            index++;
            if (index > max) {
                index = max;
            }
        }
        addIndex = index;
        String[] values = str.split("\n");
        addCount = values.length;
        for (int i = 0; i < values.length; i++) {
            listModel.add(index++, values[i]);
        }
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
	
	public DefaultComboBoxModel<String> playersTitularTeam(String teamName) throws IOException {
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
	
	public void addTactics() {
		tactics.setLayout(new GridBagLayout());
		tactics343.setMnemonic(KeyEvent.VK_C);
		tactics343.setSelected(true);
		tactics424.setMnemonic(KeyEvent.VK_C); 
		tactics235.setMnemonic(KeyEvent.VK_C);
		tactics442.setMnemonic(KeyEvent.VK_C);
		tactics433.setMnemonic(KeyEvent.VK_C);
		group.add(tactics343);
		group.add(tactics424);
		group.add(tactics235);
		group.add(tactics442);
		group.add(tactics433);
		gc.gridx = 2;
        gc.gridy = 0;
		panel.add(tacticsLabel, gc);
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
	}
	
	public void addObjectstoPanel() {
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
}	