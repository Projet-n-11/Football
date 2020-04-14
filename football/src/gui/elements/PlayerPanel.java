package gui.elements;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import dataplayer.DataPlayer;
import process.management.ConstantValues;

public class PlayerPanel extends JPanel{

	private JPanel playerImagePanel, staminaPanel, stressPanel, barsPanel, speedPanel;
	private GridBagConstraints c;
	private JProgressBar staminaBar, stressBar;
	private ImageIcon teamFaceFrance, teamFaceBrazil, teamFaceTunisie, teamFaceGermany, emptyStar, fullStar, overchargedStar;
	private JLabel teamFaceLabel, overchargedstarLabel, speedStarsFull, speedStarsEmpty;
	private DataPlayer player;
	private String teamname;

	public PlayerPanel(DataPlayer player, String teamname) {
		this.player = player;
		this.teamname = teamname;
		initLayout();
	}

	public void initLayout() {
		this.setPreferredSize(new Dimension(100, 200));
		this.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		staminaBar = new JProgressBar(0, 100);
		stressBar = new JProgressBar(0, 100);
		teamFaceFrance = new ImageIcon(".\\src\\ressources\\france.png");
		teamFaceBrazil = new ImageIcon(".\\src\\ressources\\brazil.png");
		teamFaceTunisie = new ImageIcon(".\\src\\ressources\\tunisie.png");
		teamFaceGermany = new ImageIcon(".\\src\\ressources\\germany.png");
		emptyStar = new ImageIcon(".\\src\\ressources\\emptystar.png");
		fullStar = new ImageIcon(".\\src\\ressources\\fullstar.png");
		overchargedStar = new ImageIcon(".\\src\\ressources\\overchargedstar.png");

		if(teamname.contains("France")) {
			teamFaceLabel = new JLabel(teamFaceFrance, JLabel.CENTER);
		}
		else if(teamname.contains("Brazil")) {
			teamFaceLabel = new JLabel(teamFaceBrazil, JLabel.CENTER);
		}
		else if(teamname.contains("Tunisie")) {
			teamFaceLabel = new JLabel(teamFaceTunisie, JLabel.CENTER);
		}
		else if(teamname.contains("Germany")) {
			teamFaceLabel = new JLabel(teamFaceGermany, JLabel.CENTER);
		}
		else {
			teamFaceLabel = new JLabel("Image not found", JLabel.CENTER);
		}

		overchargedstarLabel = new JLabel(overchargedStar, JLabel.CENTER);
		speedStarsFull = new JLabel(fullStar, JLabel.CENTER);
		speedStarsEmpty = new JLabel(emptyStar, JLabel.CENTER);
		playerImagePanel = new JPanel();
		staminaPanel = new JPanel();
		stressPanel = new JPanel();
		barsPanel = new JPanel();
		speedPanel = new JPanel();



		staminaPanel.setLayout(new GridBagLayout());
		stressPanel.setLayout(new GridBagLayout());
		barsPanel.setLayout(new GridBagLayout());
		speedPanel.setLayout(new GridBagLayout());
		playerImagePanel.setLayout(new GridBagLayout());

		staminaBar.setValue(player.getPlayerType().getStamina());
		staminaBar.setStringPainted(true);
		stressBar.setValue(player.getPlayerType().getStress());
		stressBar.setStringPainted(true);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = c.weighty = 1.0;
		c.gridx = 0;
		c.gridy = 0;
		playerImagePanel.add(teamFaceLabel, c);
		c.gridx = 0;
		c.gridy = 1;
		playerImagePanel.add(new JLabel(player.getPlayerName(), JLabel.CENTER), c);

		c.gridx = 0;
		c.gridy = 0;
		staminaPanel.add(new JLabel("Stamina", JLabel.CENTER), c);
		stressPanel.add(new JLabel("Stress", JLabel.CENTER), c);
		c.gridx = 0;
		c.gridy = 1;
		staminaPanel.add(staminaBar, c);
		stressPanel.add(stressBar, c);

		c.gridx = 0;
		c.gridy = 0;
		barsPanel.add(staminaPanel, c);
		c.gridx = 0;
		c.gridy = 1;
		barsPanel.add(stressPanel, c);	

		if(player.getPlayerType().getSpeed().getSpeedX() == 1) {
			c.gridx = 0;
			c.gridy = 0;
			speedPanel.add(new JLabel(fullStar, JLabel.CENTER), c);
			for(int i=1; i<=4; i++) {
				c.gridx = i;
				c.gridy = 0;
				speedPanel.add(new JLabel(emptyStar, JLabel.CENTER), c);
			}
		}
		else if(player.getPlayerType().getSpeed().getSpeedX() == 2) {
			c.gridx = 0;
			c.gridy = 0;
			speedPanel.add(new JLabel(fullStar, JLabel.CENTER), c);
			c.gridx = 1;
			c.gridy = 0;
			speedPanel.add(new JLabel(fullStar, JLabel.CENTER), c);
			for(int i=2; i<5; i++) {
				c.gridx = i;
				c.gridy = 0;
				speedPanel.add(new JLabel(emptyStar, JLabel.CENTER), c);
			}
		}
		else if(player.getPlayerType().getSpeed().getSpeedX() == 3) {
			for(int i=0; i<3; i++) {
				c.gridx = i;
				c.gridy = 0;
				speedPanel.add(new JLabel(fullStar, JLabel.CENTER), c);
			}
			c.gridx = 3;
			c.gridy = 0;
			speedPanel.add(new JLabel(emptyStar, JLabel.CENTER), c);
			c.gridx = 4;
			c.gridy = 0;
			speedPanel.add(new JLabel(emptyStar, JLabel.CENTER), c);
		}
		else if(player.getPlayerType().getSpeed().getSpeedX() == 4) {
			for(int i=0; i<4; i++) {
				c.gridx = i;
				c.gridy = 0;
				speedPanel.add(new JLabel(fullStar, JLabel.CENTER), c);
			}
			c.gridx = 4;
			c.gridy = 0;
			speedPanel.add(new JLabel(emptyStar, JLabel.CENTER), c);
		}
		else if(player.getPlayerType().getSpeed().getSpeedX() == 5) {
			for(int i=0; i<5; i++) {
				c.gridx = i;
				c.gridy = 0;
				speedPanel.add(new JLabel(fullStar, JLabel.CENTER), c);
			}
		}
		else {
			for(int i=0; i<5; i++) {
				c.gridx = i;
				c.gridy = 0;
				speedPanel.add(new JLabel(overchargedStar, JLabel.CENTER), c);
			}
		}
		
		c.gridx = 0;
		c.gridy = 0;
		this.add(playerImagePanel, c);
		c.gridx = 1;
		c.gridy = 0;
		this.add(barsPanel, c);
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 4;
		c.gridheight = 1;
		this.add(speedPanel, c);
	}
}
