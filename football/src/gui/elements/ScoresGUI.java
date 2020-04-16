package gui.elements;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import datateam.DataTeam;
import process.management.ConstantValues;
import process.scores.Score;

public class ScoresGUI extends JPanel implements Runnable{

	private static final long serialVersionUID = 1L;
	private static Font font = new Font(Font.SANS_SERIF, Font.BOLD, 20);
	private DataTeam PTeam, IATeam;
	private ScoresGUI instance = this;
	private JLabel PTeamLabel, IATeamLabel;
	private Score score;
	private static final int SCORESPEED = ConstantValues.GAME_SPEED;
	private boolean endgame = false;
	public ScoresGUI(Score score, DataTeam PTeam, DataTeam IATeam) {
		this.PTeam = PTeam;
		this.IATeam = IATeam;
		this.score = score;
		init(score, PTeam, IATeam);
		Thread scoreThread = new Thread(instance);
		scoreThread.start();
		updateValues();
	}
	
	private void init(Score score, DataTeam PTeam, DataTeam IATeam) {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		PTeamLabel = new JLabel("");
		PTeamLabel.setFont(font);
		this.add(PTeamLabel);
		
		IATeamLabel = new JLabel("");
		IATeamLabel.setFont(font);
		this.add(IATeamLabel);
		this.setBackground(new Color(245, 235, 200));
		this.setVisible(true);
	}

	private void updateValues() {
		PTeamLabel.setText(PTeam.getTeamName() + " : " + score.getScoreTeam2());
		IATeamLabel.setText(" -  " + IATeam.getTeamName() + " : " + score.getScoreTeam1());
	}
	
	@Override
	public void run() {
		while(!endgame) {
			try {
				Thread.sleep(SCORESPEED);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			updateValues();
			this.repaint();
		}
	}
}
