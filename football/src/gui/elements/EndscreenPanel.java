package gui.elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import process.scores.Score;

/*
 * This class will be useful to show after a match the results.
 * 
 * @author Aladdine Ben Romdhane, Quitterie Pilon, Laura Fustinoni
 */

public class EndscreenPanel extends JPanel{

	
	private static final long serialVersionUID = 7460576327009753842L;
	private JLabel endTextLabel, imageEndLabel;
	private JPanel endPanel;
	private GridBagConstraints gc;
	private Score score;

	public EndscreenPanel(Score score) {
		this.score = score;
		this.setBackground(new Color(245, 235, 200));
	}
	
	public JPanel initLayout() {
		endPanel = new JPanel();
		if(score.getScoreTeam1() == score.getScoreTeam2()) {
			endTextLabel = new JLabel("DRAW ! " + score.getScoreTeam1() + " : " + score.getScoreTeam2());
			ImageIcon drawIMG = new ImageIcon("C:\\Users\\aladd\\Desktop\\handshake.jpg");
			imageEndLabel = new JLabel(drawIMG, JLabel.CENTER);
		}
		else if(score.getScoreTeam1() < score.getScoreTeam2()){
			endTextLabel = new JLabel("YOU LOSE ! " + score.getScoreTeam1() + " : " + score.getScoreTeam2());
			ImageIcon drawIMG = new ImageIcon("C:\\Users\\aladd\\Desktop\\thumbsdown.png");
			imageEndLabel = new JLabel(drawIMG, JLabel.CENTER);
		}
		else if(score.getScoreTeam1() > score.getScoreTeam2()){
			endTextLabel = new JLabel("YOU WIN ! " + score.getScoreTeam1() + " : " + score.getScoreTeam2());
			ImageIcon drawIMG = new ImageIcon("C:\\Users\\aladd\\Desktop\\cupwin.jpg");
			imageEndLabel = new JLabel(drawIMG, JLabel.CENTER);
		}
		endPanel.setLayout(new GridBagLayout());
		gc = new GridBagConstraints();
		gc.insets = new Insets(10, 10, 10, 10);
		
		gc.gridx = gc.gridy = 0;
		endPanel.add(imageEndLabel,gc);
		gc.gridx = 0;
		gc.gridy = 1;
		endPanel.add(endTextLabel,gc);
		this.add(endPanel);
		
		return this;
	}
}
