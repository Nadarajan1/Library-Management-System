package Library1;

import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Return {

	private JFrame frmReturn;
	private JTextField n;
	private JTextField bn;
	private JTextField bno;
	private JTextField id;
	private JTextField im;
	private JTextField iy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Return window = new Return();
					window.getFrmReturn().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Return() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmReturn(new JFrame());
		getFrmReturn().setTitle("Return");
		getFrmReturn().setBounds(100, 100, 458, 396);
		getFrmReturn().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReturn.getContentPane().setLayout(null);
		
		JButton button = new JButton("<< Back");
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					 HomePage x = new HomePage();
					 frmReturn.setVisible(false);
                	 x.getFrmHomePage().setVisible(true);
				}
				catch(Exception e)
				{
					
				}
				
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBounds(334, 313, 98, 33);
		frmReturn.getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(50, 64, 90, 14);
		frmReturn.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(50, 95, 90, 14);
		frmReturn.getContentPane().add(lblNewLabel_1);
		
		n = new JTextField();
		n.setBounds(249, 61, 86, 20);
		frmReturn.getContentPane().add(n);
		n.setColumns(10);
		
		bn = new JTextField();
		bn.setBounds(249, 93, 86, 20);
		frmReturn.getContentPane().add(bn);
		bn.setColumns(10);
		
		bno = new JTextField();
		bno.setBounds(249, 131, 86, 20);
		frmReturn.getContentPane().add(bno);
		bno.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Book No");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(50, 134, 89, 14);
		frmReturn.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
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
					String name=n.getText();
					String bookname=bn.getText();
					String bookno=bno.getText();
					String pdate=id.getText();
					int pd=Integer.parseInt(pdate);
					String pmonth=im.getText(); 
					int pm=Integer.parseInt(pmonth);
					String pyear=iy.getText();
					int py=Integer.parseInt(pyear);
					System.out.println(name);
					rs=st.executeQuery("select * from Issue where name= '"+name+"' and bookname= '"+bookname+"' and bookno= '"+bookno+"'");
					if(rs.next())
					{
						String d=rs.getString("returnd");
						int date=Integer.parseInt(d);
						String m=rs.getString("returnm");
						int month=Integer.parseInt(m);
						String y=rs.getString("returny");
						int year=Integer.parseInt(y);
						
						int a=pd-date;
					    int b=(pm-month)*30;
						int c=(py-year)*365;
						
						int z=(a+b+c-30)*5;
						System.out.println();
						if(z>0)
						{
						JOptionPane.showMessageDialog(null, "The Fine Is Rs: "+z);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "There Is No Fine");
						}
					}
					System.out.println();
					st.executeUpdate("delete * from issued where  bookno='"+bookno+"'");
					
				}
				catch(Exception e)
				{
					
				}
				JOptionPane.showMessageDialog(null,"Book Returned");
				n.setText("");
				bn.setText("");
				bno.setText("");
				id.setText("");
				im.setText("");
				iy.setText("");
			}
		});
		btnNewButton.setBounds(51, 313, 89, 23);
		frmReturn.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Present Date");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(36, 186, 90, 14);
		frmReturn.getContentPane().add(lblNewLabel_3);
		
		id = new JTextField();
		id.setBounds(141, 184, 23, 20);
		frmReturn.getContentPane().add(id);
		id.setColumns(10);
		
		im = new JTextField();
		im.setBounds(174, 184, 23, 20);
		frmReturn.getContentPane().add(im);
		im.setColumns(10);
		
		iy = new JTextField();
		iy.setBounds(207, 184, 49, 20);
		frmReturn.getContentPane().add(iy);
		iy.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("dd       mm      yyyy");
		lblNewLabel_4.setBounds(141, 162, 115, 14);
		frmReturn.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\nOK");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int day, month, year;
			      
			      GregorianCalendar date = new GregorianCalendar();
			 
			      day = date.get(Calendar.DAY_OF_MONTH);
			      month = date.get(Calendar.MONTH);
			        month=month+1;
			       year = date.get(Calendar.YEAR);
			       System.out.println(day);	
			       System.out.println(month);
			       System.out.println(year);
			       id.setText(""+day);
			       im.setText(""+month);
			       iy.setText(""+year);
			}
		});
		btnNewButton_1.setBounds(295, 183, 89, 23);
		frmReturn.getContentPane().add(btnNewButton_1);
	}

	public JFrame getFrmReturn() {
		return frmReturn;
	}

	public void setFrmReturn(JFrame frmReturn) {
		this.frmReturn = frmReturn;
		frmReturn.getContentPane().setBackground(new Color(153, 204, 255));
	}
}

