package gui.elements;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

import process.management.ConstantValues;
import process.scores.Chronometer;
import process.scores.CyclicCounter;

/**
 * Main GUI class for chronometer.
 * 
 * @author Tianxiao.Liu@u-cergy.fr modified by Aladdine Ben Romdhane
 **/

public class ChronometerGUI extends JPanel implements Runnable {
	//private static final Dimension IDEAL_MAIN_DIMENSION = new Dimension(800, 400);

	private static Font font = new Font(Font.SANS_SERIF, Font.BOLD, 20);

	//The normal speed is 1000, e.q. one refresh per second (1000 milliseconds).

	private static final int CHRONO_SPEED = ConstantValues.GAME_SPEED;

	private static final long serialVersionUID = 1L;


	//The core functional part : the chronometer.
	private Chronometer chronometer = new Chronometer();

	private JLabel minuteLabel = new JLabel("m");
	private JLabel beetweenLabel = new JLabel(":");
	private JLabel secondLabel = new JLabel("s");

	private JLabel minuteValue = new JLabel("");
	private JLabel secondValue = new JLabel("");

	//This instance is used in the inner classes for different action listeners.

	private ChronometerGUI instance = this;

	private boolean paused = false;
	private boolean stop = false;

	public ChronometerGUI() {
		init();
		Thread chronoThread = new Thread(instance);
		chronoThread.start();
		updateValues();
	}

	private void init() {
		updateValues();

		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		minuteValue.setFont(font);
		this.add(minuteValue);
		minuteLabel.setFont(font);
		this.add(minuteLabel);

		beetweenLabel.setFont(font);
		this.add(beetweenLabel);

		secondValue.setFont(font);
		this.add(secondValue);
		secondLabel.setFont(font);
		this.add(secondLabel);
		this.setBackground(new Color(245, 235, 200));
		setVisible(true);

	}

	private void updateValues() {

		CyclicCounter minute = chronometer.getMinute();
		minuteValue.setText(minute.toString() + " ");

		CyclicCounter second = chronometer.getSecond();
		secondValue.setText(second.toString() + " ");
	}

	/**
	 * Defines what to do for each time unit (by default 1 second) : it increments the chronometer
	 */
	public void pause() {
		paused = true;
	}

	public void resume() {
		paused = false;
	}

	public int getMinute() {
		return chronometer.getMinute().getValue();
	}
	
	public void run() {
		while (!stop) {
			if(paused == false){
				if(chronometer.getMinute().getValue() == 90) {
					stop = true;
				}
				try {
					Thread.sleep(CHRONO_SPEED);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				chronometer.increment();
				updateValues();
			}
			else {
				updateValues();
			}
		}
	}
}
