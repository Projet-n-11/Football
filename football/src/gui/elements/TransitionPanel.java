package gui.elements;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import datateam.DataTeam;

public class TransitionPanel extends JPanel{
	private JLabel textLabel;
	private JPanel panel, tactics, players, tacticsLabelPanel;
	private ListModel<String> modelT,modelS;
	private JRadioButton tactics343, tactics424, tactics235, tactics352, tactics433;
	private JList<String> filleT, filleS;
	private JScrollPane jsfilleT, jsfilleS;
	private GridBagConstraints gc;
	private JButton resume;
	
	public TransitionPanel() {
		this("Tactics changes");
	}
	
	public TransitionPanel(String title) {
		panel=new JPanel();
		panel.setBackground(new Color(80, 206, 89));
	}
	
	public JPanel changementTactics(DataTeam team) throws IOException {
		
		textLabel=new JLabel("Select your new tactic");
		resume=new JButton("Resume");
		
		jsfilleT = new JScrollPane();
		jsfilleS = new JScrollPane();
		KickOffMenu kick=new KickOffMenu();
		modelT=kick.playersTitularTeam(team.getTeamName());
		modelS=kick.playersSubstituteTeam(team.getTeamName());
		
		filleT = new JList<String>(modelT);
		filleS = new JList<String>(modelS);
		
		return kick;
		
	}
}
