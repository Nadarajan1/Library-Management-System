package Library1;



import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("unused")
public class Issue {

	private JFrame frmIssue;
	private JTextField id;
	private JTextField im;
	private JTextField iy;
	private JTextField rd;
	private JTextField rm;
	private JTextField ry;
	private JTextField bn;
	private JTextField bno;
	private JTextField name1;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Issue window = new Issue();
					window.getFrmIssue().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Issue() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmIssue(new JFrame());
		getFrmIssue().setTitle("Issue");
		getFrmIssue().setBounds(100, 100, 471, 408);
		getFrmIssue().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIssue.getContentPane().setLayout(null);
		
		JButton button = new JButton("<< Back");
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(0, 0, 205));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 HomePage x = new HomePage();
				 frmIssue.setVisible(false);
            	 x.getFrmHomePage().setVisible(true);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBounds(347, 326, 98, 32);
		frmIssue.getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("Book Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(46, 80, 80, 14);
		frmIssue.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book No");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(46, 111, 80, 14);
		frmIssue.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Issue Date");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(46, 182, 80, 14);
		frmIssue.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Return Date");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(46, 249, 80, 14);
		frmIssue.getContentPane().add(lblNewLabel_3);
		
		id = new JTextField();
		id.setBounds(135, 179, 26, 20);
		frmIssue.getContentPane().add(id);
		id.setColumns(10);
		
		im = new JTextField();
		im.setColumns(10);
		im.setBounds(171, 179, 26, 20);
		frmIssue.getContentPane().add(im);
		
		iy = new JTextField();
		iy.setBounds(213, 179, 53, 20);
		frmIssue.getContentPane().add(iy);
		iy.setColumns(10);
		
		JButton btnNewButton = new JButton("ok");
		btnNewButton.setBackground(new Color(204, 255, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Connection con;
					Statement st;
					ResultSet rs;
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					con=DriverManager.getConnection("jdbc:odbc:Library");
					st=con.createStatement();
					int day, month, year;
			      
			      GregorianCalendar date = new GregorianCalendar();
			 
			      day = date.get(Calendar.DAY_OF_MONTH);
			      month = date.get(Calendar.MONTH);
			      year = date.get(Calendar.YEAR);
			       month=month+1;
			       System.out.println(day);	
			       System.out.println(month);
			       System.out.println(year);
			       id.setText(""+day);
			       im.setText(""+month);
			       iy.setText(""+year);
			       rd.setText(""+day);
			       if(month<12)
			       {month=month+1;
			    	   rm.setText(""+month);
			    	   ry.setText(""+year);
			       }
			       else
			       {
			    	   month=1;
			    	   rm.setText(""+month);
			    	   year=year+1;
			    	   ry.setText(""+year);
			       }
			       String a=bno.getText();
			       
			       rs=st.executeQuery("select * from BookDetails where bookno= '"+a+"'");
			       while(rs.next())
			        {
			    	 String bkn=rs.getString("bookname");
			    	 String bno=rs.getString("bookno");
			    	 String au=rs.getString("author");
			    	 String ed=rs.getString("edition");
			    	 String c=rs.getString("cost");
			    	 System.out.println(bkn);
			    	 System.out.println(bno);
			    	 System.out.println(au);
			    	 System.out.println(ed);
			    	 System.out.println(c);
			    	 
			    	 System.out.println(); 
			    	 st.executeQuery("insert into issued(bookname,bookno,author,edition,cost)values('"+bkn+"','"+bno+"','"+au+"','"+ed+"','"+c+"')");
			    	 
			    	   }
			       
			    	   }
				catch(Exception e){
					e.printStackTrace();
					
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(313, 178, 53, 23);
		frmIssue.getContentPane().add(btnNewButton);
		
		rd = new JTextField();
		rd.setColumns(10);
		rd.setBounds(135, 246, 26, 20);
		frmIssue.getContentPane().add(rd);
		
		rm = new JTextField();
		rm.setColumns(10);
		rm.setBounds(171, 246, 26, 20);
		frmIssue.getContentPane().add(rm);
		
		ry = new JTextField();
		ry.setColumns(10);
		ry.setBounds(213, 246, 53, 20);
		frmIssue.getContentPane().add(ry);
		
		JLabel lblNewLabel_4 = new JLabel("   dd      mm         yyyy");
		lblNewLabel_4.setBounds(134, 152, 120, 14);
		frmIssue.getContentPane().add(lblNewLabel_4);
		
		bn = new JTextField();
		bn.setColumns(10);
		bn.setBounds(190, 77, 86, 20);
		frmIssue.getContentPane().add(bn);
		
		bno = new JTextField();
		bno.setColumns(10);
		bno.setBounds(190, 108, 86, 20);
		frmIssue.getContentPane().add(bno);
		
		JLabel lblNewLabel_5 = new JLabel("Name");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(46, 49, 46, 14);
		frmIssue.getContentPane().add(lblNewLabel_5);
		
		name1 = new JTextField();
		name1.setEditable(true);
		name1.setColumns(10);
		name1.setBounds(190, 46, 86, 20);
		frmIssue.getContentPane().add(name1);
		
		
		btnNewButton_1 = new JButton("Issue");
		btnNewButton_1.setBackground(new Color(0, 0, 205));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{Connection con;
				Statement st;
				ResultSet rs;
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con=DriverManager.getConnection("jdbc:odbc:Library");
				st=con.createStatement();
				String bookname=bn.getText();
				String bookno=bno.getText();
				String name=name1.getText();
				String issued=id.getText();
				String issuem=im.getText();
				String issuey=iy.getText();
				String returnd=rd.getText();
				String returnm=rm.getText();
				String returny=ry.getText();
				System.out.println(name);
				System.out.println(bookname);
				System.out.println(bookno);
				System.out.println(issued);
				System.out.println(issuem);
				System.out.println(issuey);
				System.out.println(returnd);
				System.out.println(returnm);
				System.out.println(returny);
			   st.executeQuery("insert into issue(name,bookname,bookno,returnd,returnm,returny)values('"+name+"','"+bookname+"','"+bookno+"','"+returnd+"','"+returnm+"','"+returny+"')");
			   
				}
				catch(Exception b)
				{
					b.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Issued");
				bn.setText("");
				id.setText("");
				im.setText("");
				iy.setText("");
				rd.setText("");
				rm.setText("");
				ry.setText("");
				bno.setText("");
				name1.setText("");
			
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(108, 326, 89, 23);
		frmIssue.getContentPane().add(btnNewButton_1);
	}

	public JFrame getFrmIssue() {
		return frmIssue;
	}

	public void setFrmIssue(JFrame frmIssue) {
		this.frmIssue = frmIssue;
		frmIssue.setBackground(Color.LIGHT_GRAY);
		frmIssue.getContentPane().setBackground(new Color(30, 144, 255));
	}

}
