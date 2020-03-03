package gui.elements;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



import java.awt.Color;
import java.awt.FlowLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GraphicalPanel extends JFrame {
	
	
	/**
	 * 
	 */
	private JFrame mainFrame;
	private static final long serialVersionUID = 1L;
	private JLabel simulator;
	private JButton kickOff;
	private JButton options;
	private JButton credits;
	
	private JButton leave;
	
	public GraphicalPanel() {
		this("Fooball Game");
	}
	
	public GraphicalPanel(String title) {
		mainFrame=new JFrame();
		mainFrame.getContentPane().setLayout(new GridLayout(6,1));
		mainFrame.setSize(1000,500);
		
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
		
		mainFrame.getContentPane().add(jp1);
		mainFrame.getContentPane().add(jp2);
		mainFrame.getContentPane().add(jp3);
		mainFrame.getContentPane().add(jp4);
		mainFrame.getContentPane().add(jp5);

		
		
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//this.pack();
		mainFrame.setPreferredSize(null);
		mainFrame.setVisible(true);
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
			mainFrame.removeAll();
			
		}
	}
	
	public class ActionOptions implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	public class ActionCredits implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			String message="Produced by : \n ALADDINE BEN ROMDHANE \n LAURA FUSTINONI \n QUITTERIE PILON";
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
