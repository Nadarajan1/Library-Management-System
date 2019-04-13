package Library1;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class adminpage {

	JFrame frame;
	private JButton btnNewButton;
	private JButton btnAvailable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminpage window = new adminpage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public adminpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 102, 255));
		frame.setBounds(100, 100, 450, 332);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnNewButton = new JButton("new book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookDetails x=new BookDetails();
            	frame.setVisible(false);
            	x.frmBookDetails.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(35, 85, 117, 37);
		frame.getContentPane().add(btnNewButton);
		
		btnAvailable = new JButton("available");
		btnAvailable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Book v=new Book();
				frame.setVisible(false);
				v.frame.setVisible(true);
			}
		});
		btnAvailable.setBounds(203, 85, 117, 37);
		frame.getContentPane().add(btnAvailable);
	}
}
