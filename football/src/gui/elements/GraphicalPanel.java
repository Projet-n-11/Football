package gui.elements;

import datateam.DataTeam;
import process.management.CreaTeam;
import process.management.RecupTeam;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import dataplayer.DataPlayer;
import process.management.RecupTeam;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class GraphicalPanel extends JFrame {
	
	
	/**
	 * 
	 */
	private JFrame mainFrame;

	public GraphicalPanel() {
		
			MainMenu menu = new MainMenu();
			mainFrame= menu.getJFrameMainMenu();
	}
	
	public static void main(String args[]) {
		new GraphicalPanel();
	}

}
