package test;

import java.io.IOException;

import java.util.Iterator;

import javax.swing.JFrame;

import databall.DataBall;
import dataplayer.DataPlayer;
import datateam.DataTeam;
import gui.elements.DrawField;
import gui.elements.EndscreenPanel;
import process.management.CreaTeam;
import process.management.Map;
import process.management.Match;
import process.scores.Score;

public class TestMatch {

	public static void main(String[] args) throws IOException {
		
		JFrame frame = new JFrame();
		Score score = new Score(1, 0);
		EndscreenPanel ep = new EndscreenPanel(score);
		
		frame.add(ep.initLayout());
		frame.setVisible(true);
		frame.setSize(500, 500);
	}

}
