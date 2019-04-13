package Library1;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.Statement;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;



public class admin {

	JFrame frame;
	private JTextField t1;
	private JPasswordField t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin window = new admin();
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
	public admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 51, 153));
		frame.setBounds(100, 100, 507, 406);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdminLogin = new JLabel("Admin Login");
		lblAdminLogin.setFont(new Font("Modern No. 20", Font.BOLD | Font.ITALIC, 19));
		lblAdminLogin.setBounds(216, 11, 163, 24);
		frame.getContentPane().add(lblAdminLogin);
		
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblUserName.setBounds(34, 94, 81, 14);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel.setBounds(41, 157, 104, 14);
		frame.getContentPane().add(lblNewLabel);
		
		t1 = new JTextField();
		t1.setBounds(197, 91, 104, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					boolean flag=false;
					String u=null,p=null;
					Connection con;
					java.sql.Statement st;
					ResultSet rs;
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					con=DriverManager.getConnection("jdbc:odbc:Library");
					st=con.createStatement();
					u=t1.getText();
					p=t2.getText();
					rs=st.executeQuery("select name,password from admin where name='"+u+"' AND Password='"+p+"'");
					if(rs.next())
					{
						
						adminpage Update=new adminpage();
						frame.setVisible(false);
						Update.frame.setVisible(true);
					}
				
				else
				{
					JOptionPane.showMessageDialog(null," Name or Password incorrect");
					
				}
				}
				catch(Exception e)
				{
					
				}
				t1.setText("");
				t2.setText("");		
			}
		});
		btnLogin.setBounds(107, 235, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		t2 = new JPasswordField();
		t2.setBounds(197, 153, 104, 22);
		frame.getContentPane().add(t2);
	}
}
