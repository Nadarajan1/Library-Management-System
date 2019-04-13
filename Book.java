package Library1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Book {

	JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Book window = new Book();
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
	public Book() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 51, 204));
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 174, 380, 140);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 204));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "", "", "", ""},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"BookName", "Bookno", "Author", "Edition", "cost"
			}
		));
		
		JButton btnNewButton = new JButton("VIEW");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
			
				
				Connection con;
                java.sql.Statement st;		
				ResultSet rs;
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con=DriverManager.getConnection("jdbc:odbc:Library");
               st=con.createStatement();
               ResultSet rs1;
				rs1=st.executeQuery("select * from BookDetails");
				rs=rs1;
				int c=0;
				int i;
				while(rs1.next())
				{
					
					String a[]=new String[6];
					a[0]=rs1.getString("bookname");
					a[1]=rs1.getString("bookno");
					a[2]=rs1.getString("author");
					a[3]=rs1.getString("edition");
					a[4]=rs1.getString("cost");
					
					
					for(i=0;i<=4;i++)
				
					
				
					{
					
					
						
						
						table.setValueAt(a[i],c,i);
						
					}
					c=c+1;
				}
				
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(88, 111, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("Book Details");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(0, 255, 204));
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 25));
		lblNewLabel.setBounds(56, 31, 285, 50);
		frame.getContentPane().add(lblNewLabel);
		
		btnNewButton_1 = new JButton("<<Back");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				admin x=new admin();
				frame.setVisible(false);
				x.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(289, 111, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
