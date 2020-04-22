package gui.elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import dataplayer.DataPlayer;
import datateam.DataTeam;
import process.management.ConstantValues;

public class ListPlayerPanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 8160466410842954737L;
	private GridBagConstraints c = new GridBagConstraints();
	private JPanel playersteam1panel = new JPanel();
	private JScrollPane jsteam1 = new JScrollPane();
	private DataTeam team;
	
	private ListPlayerPanel instance = this;
	
	public ListPlayerPanel(DataTeam team) {
		this.team = team;
		playersteam1panel.setLayout(new GridBagLayout());
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = c.weighty = 1.0;

		updateValuesList();
		
		jsteam1.setPreferredSize(new Dimension(340, 300));
		jsteam1.setViewportView(playersteam1panel);
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(245, 235, 200));
		this.add(jsteam1);
		Thread actualizeList = new Thread(instance);
		actualizeList.start();
	}

	public void updateValuesList() {
		int i = 0;
		playersteam1panel.removeAll();
		for(DataPlayer dp: team.getPlayers().values()) {
			c.gridx = 0;
			c.gridy = i;
			PlayerPanel pp = new PlayerPanel(dp, team.getTeamName());
			playersteam1panel.add(pp, c);
			i++;
			c.gridx = 0;
			c.gridy = i;
			playersteam1panel.add(new JSeparator(SwingConstants.HORIZONTAL), c);
			i++;
		}
		playersteam1panel.setBackground(new Color(245, 235, 200));
	}
	
	@Override
	public void run() {
		while(true) {
			updateValuesList();
			try {
				Thread.sleep(ConstantValues.GAME_SPEED+40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
