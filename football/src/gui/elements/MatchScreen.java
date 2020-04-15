package gui.elements;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import databall.DataBall;
import datateam.DataTeam;
import process.scores.Score;

public class MatchScreen extends JPanel implements KeyListener{

	private static final long serialVersionUID = 2301016752658769684L;
	
	public MatchScreen(DataTeam team, DataTeam team2, DataBall ball, Score score) {
		initLayout(team, team2, ball, score);
	}
	
	public void initLayout(DataTeam team, DataTeam team2, DataBall ball, Score score) {
		GraphicalField field = new GraphicalField(team, team2, ball, score);
		ChronometerGUI chrono = new ChronometerGUI();
		ScoresGUI scores = new ScoresGUI(score, team, team2);
		Thread matchgui = new Thread(field);
		ListPlayerPanel lppteam1 = new ListPlayerPanel(team);
		ListPlayerPanel lppteam2 = new ListPlayerPanel(team2);
		this.addKeyListener(this);
		matchgui.start();
		
        this.setLayout(new BorderLayout());
        this.add(chrono,BorderLayout.NORTH);
       	this.add(field, BorderLayout.CENTER);
        this.add(scores,BorderLayout.SOUTH);
        this.add(lppteam2,BorderLayout.EAST);
        this.add(lppteam1,BorderLayout.WEST);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
	    {  
			try {
				wait();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }

	    if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
	    {
	    	System.out.println("GTFO");
	    }
	}
}
