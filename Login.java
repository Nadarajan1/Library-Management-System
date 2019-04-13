package Library1;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Login {

	JFrame frmLogin;
	private JTextField u1;
	private JPasswordField p1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.getFrmLogin().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmLogin(new JFrame());
		getFrmLogin().getContentPane().setBackground(new Color(0, 0, 255));
		getFrmLogin().setTitle("Log In");
		getFrmLogin().setBounds(100, 100, 450, 387);
		getFrmLogin().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmLogin().getContentPane().setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUserName.setBounds(64, 83, 163, 23);
		getFrmLogin().getContentPane().add(lblUserName);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(64, 122, 125, 29);
		getFrmLogin().getContentPane().add(lblNewLabel);
		
		u1 = new JTextField();
		u1.setForeground(Color.BLACK);
		u1.setBounds(222, 86, 125, 20);
		getFrmLogin().getContentPane().add(u1);
		u1.setColumns(10);
		
		p1 = new JPasswordField();
		p1.setForeground(Color.BLACK);
		p1.setBounds(222, 128, 125, 20);
		getFrmLogin().getContentPane().add(p1);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try
				{
				
				String u=null,p=null;
				Connection con;
				Statement st;
				ResultSet rs;
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con=DriverManager.getConnection("jdbc:odbc:Library");
				st=con.createStatement();
				 u=u1.getText();
				 p=p1.getText();
				rs=st.executeQuery("select * from Registration where Username= '"+u+"' AND password='"+p+"'");
				
				//rs=st.executeQuery("select name,password from admin where name= '"+u+"' AND password='"+p+"'");
                 if(rs.next())
                  {
                	//System.out.println("hello");
                	HomePage x=new HomePage();
                	frmLogin.setVisible(false);
                	x.frmHomePage.setVisible(true);
                  }
                 else
                 {
                	 
                	 JOptionPane.showMessageDialog(null, "Password Incorrect");
                 }
			}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				p1.setText("");
				
			}});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(64, 212, 89, 23);
		getFrmLogin().getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registration x=new Registration();
				frmLogin.setVisible(false);
				x.frmRegistration.setVisible(true);
			}
			
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(258, 212, 89, 23);
		frmLogin.getContentPane().add(btnNewButton_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				admin x=new admin();
				frmLogin.setVisible(false);
				x.frame.setVisible(true);
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.setBounds(321, 302, 89, 23);
		frmLogin.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel_1 = new JLabel("ADMIN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(321, 271, 74, 14);
		frmLogin.getContentPane().add(lblNewLabel_1);
	}

	public JFrame getFrmLogin() {
		return frmLogin;
	}

	public void setFrmLogin(JFrame frmLogin) {
		this.frmLogin = frmLogin;
		frmLogin.getContentPane().setForeground(Color.WHITE);
	}
}
