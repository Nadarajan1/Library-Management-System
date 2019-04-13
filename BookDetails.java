package Library1;

import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;

@SuppressWarnings("unused")
public class BookDetails {

	JFrame frmBookDetails;
	private JTextField bn;
	private JTextField bno;
	private JTextField an;
	private JTextField ed;
	private JTextField bc;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookDetails window = new BookDetails();
					window.frmBookDetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BookDetails() {
		initialize();
	//	Connection =connection.dbConnector();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBookDetails = new JFrame();
		frmBookDetails.getContentPane().setBackground(new Color(51, 204, 204));
		frmBookDetails.setTitle("Book Details");
		frmBookDetails.setBounds(100, 100, 482, 433);
		frmBookDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBookDetails.getContentPane().setLayout(null);
		
		JButton button = new JButton("<< Back");
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 admin x = new admin();
				 frmBookDetails.setVisible(false);
            	 x.frame.setVisible(true);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBounds(358, 348, 98, 35);
		frmBookDetails.getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("Book Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(39, 41, 80, 14);
		frmBookDetails.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book No");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(39, 87, 74, 14);
		frmBookDetails.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Author Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(39, 143, 98, 14);
		frmBookDetails.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Book Cost");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(39, 244, 80, 14);
		frmBookDetails.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Edition");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(39, 190, 74, 14);
		frmBookDetails.getContentPane().add(lblNewLabel_4);
		
		bn = new JTextField();
		bn.setBounds(245, 38, 86, 20);
		frmBookDetails.getContentPane().add(bn);
		bn.setColumns(10);
		
		bno = new JTextField();
		bno.setBounds(245, 84, 86, 20);
		frmBookDetails.getContentPane().add(bno);
		bno.setColumns(10);
		
		an = new JTextField();
		an.setBounds(245, 137, 86, 20);
		frmBookDetails.getContentPane().add(an);
		an.setColumns(10);
		
		ed = new JTextField();
		ed.setBounds(245, 187, 86, 20);
		frmBookDetails.getContentPane().add(ed);
		ed.setColumns(10);
		
		bc = new JTextField();
		bc.setBounds(245, 241, 86, 20);
		frmBookDetails.getContentPane().add(bc);
		bc.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 102, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{Connection con;
				Statement st;
				ResultSet rs;
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con=DriverManager.getConnection("jdbc:odbc:Library");
				st=con.createStatement();
				String bookname=bn.getText();
				String bookno=bno.getText();
				String author=an.getText();
				String edition=ed.getText();
				String cost=bc.getText();
				System.out.println(bookname);
				System.out.println(bookno);
				System.out.println(author);
				System.out.println(edition);
				System.out.println(cost);
				refresh();
			   st.executeQuery("insert into BookDetails(bookname,bookno,author,edition,cost)values('"+bookname+"','"+bookno+"','"+author+"','"+edition+"','"+cost+"')");
				}
				catch(Exception e)
				{
					
				}
			JOptionPane.showMessageDialog(null, "Boook Upadate Completed");
			Book x=new Book();
			frmBookDetails.setVisible(false);
			x.frame.setVisible(true);
			bn.setText("");
			bno.setText("");
			an.setText("");
			ed.setText("");
			bc.setText("");
			
			}
		});
		btnNewButton.setBounds(39, 348, 89, 35);
		frmBookDetails.getContentPane().add(btnNewButton);
		
	}

	protected void refresh() {
		// TODO Auto-generated method stub
		
	}
}
