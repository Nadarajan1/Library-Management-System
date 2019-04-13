package Library1;


import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;


public class searchh {

	JFrame frmHomepage;
	private JTextField n;
	private JTextField i;
	private JTextField l;
	private JTextField p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchh window = new searchh();
					window.frmHomepage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public searchh() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHomepage = new JFrame();
		frmHomepage.getContentPane().setBackground(new Color(0, 204, 255));
		frmHomepage.getContentPane().setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 26));
		frmHomepage.setBounds(100, 100, 591, 429);
		frmHomepage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHomepage.getContentPane().setLayout(null);
		
		JLabel lblLoanRequestes = new JLabel("BOOK DETAILS");
		lblLoanRequestes.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 22));
		lblLoanRequestes.setBounds(200, 22, 313, 23);
		frmHomepage.getContentPane().add(lblLoanRequestes);
		
		final JComboBox c = new JComboBox();
		c.setBounds(20, 79, 96, 30);
		frmHomepage.getContentPane().add(c);
		
		JButton btnNames = new JButton("Names");
		btnNames.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Connection con;
					Statement st;
					ResultSet rs;
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					con=DriverManager.getConnection("jdbc:odbc:Library");
					st=con.createStatement();
					rs=st.executeQuery("select bookname from BookDetails");
					while(rs.next())
					{
						c.addItem(rs.getString("bookname"));
						c.getSelectedItem();
					}}
					catch(Exception q)
					{
					
					}
			}
		});
		btnNames.setBounds(20, 45, 96, 23);
		frmHomepage.getContentPane().add(btnNames);
		
		JButton btnNewButton = new JButton("View");
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Connection con;
					Statement st;
					ResultSet rs;
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					con=DriverManager.getConnection("jdbc:odbc:Library");
					st=con.createStatement();
					String m=(String)c.getSelectedItem();
					rs=st.executeQuery("select bookname,author,edition,cost from BookDetails where bookname='"+m+"'" );
					while(rs.next())
					{
						System.out.println(m);
						String ii=rs.getString("author");
						String ll=rs.getString("edition");
						String pp=rs.getString("cost");
						n.setText(m);
						i.setText(ii);
						l.setText(ll);
						p.setText(pp);
					}
					
				}
				catch(Exception ee)
				{
					ee.printStackTrace();
				}
			
			}
		});
		btnNewButton.setBounds(231, 97, 89, 23);
		frmHomepage.getContentPane().add(btnNewButton);
		
		n = new JTextField();
		n.setEditable(false);
		n.setBounds(13, 182, 86, 20);
		frmHomepage.getContentPane().add(n);
		n.setColumns(10);
		
		i = new JTextField();
		i.setEditable(false);
		i.setBounds(145, 182, 86, 20);
		frmHomepage.getContentPane().add(i);
		i.setColumns(10);
		
		l = new JTextField();
		l.setEditable(false);
		l.setBounds(269, 182, 86, 20);
		frmHomepage.getContentPane().add(l);
		l.setColumns(10);
		
		p = new JTextField();
		p.setEditable(false);
		p.setBounds(407, 182, 106, 20);
		frmHomepage.getContentPane().add(p);
		p.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Book Name");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel.setBounds(20, 152, 79, 14);
		frmHomepage.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Author");
		lblNewLabel_1.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_1.setBounds(145, 152, 86, 14);
		frmHomepage.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Edition");
		lblNewLabel_2.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_2.setBounds(269, 152, 92, 14);
		frmHomepage.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cost");
		lblNewLabel_3.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_3.setBounds(423, 152, 114, 14);
		frmHomepage.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("<<Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomePage x=new HomePage();
				frmHomepage.setVisible(false);
				x.frmHomePage.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Rockwell", Font.BOLD, 11));
		btnNewButton_1.setBounds(448, 344, 89, 23);
		frmHomepage.getContentPane().add(btnNewButton_1);
	}

	public JComponent getHomePage() {
		// TODO Auto-generated method stub
		return null;
	}
}
