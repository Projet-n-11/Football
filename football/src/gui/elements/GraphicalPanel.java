package gui.elements;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GraphicalPanel extends JFrame {
	
	
	private JLabel simulator;
	private JButton kickOff;
	private JButton options;
	private JButton credits;
	private JButton leave;
	
	public GraphicalPanel() {
		this("Fooball Game");
	}
	
	public GraphicalPanel(String title) {
		
		this.getContentPane().setLayout(new GridLayout(6,1));
		this.setSize(1000,500);
		
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		JPanel jp3=new JPanel();
		JPanel jp4=new JPanel();
		JPanel jp5=new JPanel();
	
		jp1.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp3.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp4.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp5.setLayout(new FlowLayout(FlowLayout.CENTER));
	
		simulator=new JLabel("FOOTBALL SIMULATOR");
		simulator.setForeground(Color.RED);
		jp1.add(simulator);
		
		kickOff=new JButton("Coup d'envoi");
		kickOff.setMinimumSize(getSize());
		
		kickOff.addActionListener(new ActionKickOff());
		jp2.add(kickOff);
		
		options =new JButton("Options");
		options.setSize(200,400);
		options.addActionListener(new ActionOptions());
		jp3.add(options);
		
		credits=new JButton("Credits");
		credits.setSize(200,400);
		credits.addActionListener(new ActionCredits());
		jp4.add(credits);
		
		leave=new JButton("Quitter le jeu");
		leave.addActionListener(new ActionLeave());
		leave.setSize(200,400);
		jp5.add(leave);
		
		this.getContentPane().add(jp1);
		this.getContentPane().add(jp2);
		this.getContentPane().add(jp3);
		this.getContentPane().add(jp4);
		this.getContentPane().add(jp5);

		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//this.pack();
		this.setPreferredSize(null);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GraphicalPanel();
	
	}
	/*public void paint(Graphics g)
    {
        try
        {
            Image img=ImageIO.read(new File ("\ressources\icone.jpeg"));
            g.drawImage(img, 0, 0, 1440, 900, this);
            ImageLoader Image=new ImageLoader();
            ImageLoader Image2=new ImageLoader();
            this.add(Image);
            this.add(Image2);
        }
        catch (Exception e )
        {
             
        }
    }*/

	public class ActionKickOff implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	public class ActionOptions implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	public class ActionCredits implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JOptionPane jop1=new JOptionPane();
			String message="Producing by : \n ALADDINE BEN ROMHDAM, LAURA FUSTINONI, QUITTERIE PILON";
			 try {
		            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		            UIManager.put("OptionPane.background", Color.BLACK);
		            UIManager.put("Panel.background", Color.BLACK);
		            UIManager.put("OptionPane.messageForeground", Color.WHITE);JOptionPane.showMessageDialog(null, message);
		           
				} catch (ClassNotFoundException ex) {
		            System.err.println(ex.getMessage());
		        } catch (InstantiationException ex) {
		        	System.err.println(ex.getMessage());
		        } catch (IllegalAccessException ex) {
		        	System.err.println(ex.getMessage());
		        } catch (UnsupportedLookAndFeelException ex) {
		        	System.err.println(ex.getMessage());
		        }
			
		}
	}
	
	public class ActionLeave implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JOptionPane optionPane =new JOptionPane();
			
			int op=optionPane.showConfirmDialog(null, "Etes vous sur de vouoir quitter le jeu?", "Quitter",JOptionPane.YES_NO_OPTION );
			if(op==0) {
				dispose();
			}
		}
		
	}
	
	
}
