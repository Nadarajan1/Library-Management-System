package Library1;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.apache.commons.validator.*;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Registration {

	JFrame frmRegistration;
	private JTextField name1;
	private JTextField address1;
	private JTextField ph1;
	private JTextField email1;
	private JTextField ad;
	private JTextField dp;
	private JTextField u1;
	private JPasswordField p1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.getFrmRegistration().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmRegistration(new JFrame());
		getFrmRegistration().setTitle("Registration");
		getFrmRegistration().setBounds(100, 100, 485, 481);
		getFrmRegistration().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistration.getContentPane().setLayout(null);
		
		JButton button = new JButton("<< Back");
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login x = new Login();;
				frmRegistration.setVisible(false);
           	 x.getFrmLogin().setVisible(true);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBounds(361, 402, 98, 29);
		frmRegistration.getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(41, 57, 79, 24);
		frmRegistration.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Address");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(41, 108, 79, 24);
		frmRegistration.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(41, 143, 79, 24);
		frmRegistration.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(41, 175, 79, 24);
		frmRegistration.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Adhar");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(41, 231, 79, 29);
		frmRegistration.getContentPane().add(lblNewLabel_4);
		
		name1 = new JTextField();
		name1.setBounds(224, 59, 119, 20);
		frmRegistration.getContentPane().add(name1);
		name1.setColumns(10);
		
		address1 = new JTextField();
		address1.setBounds(224, 98, 119, 20);
		frmRegistration.getContentPane().add(address1);
		address1.setColumns(10);
		
		ph1 = new JTextField();
		ph1.setBounds(224, 139, 119, 20);
		frmRegistration.getContentPane().add(ph1);
		ph1.setColumns(10);
		
		email1 = new JTextField();
		email1.setBounds(224, 178, 119, 20);
		frmRegistration.getContentPane().add(email1);
		email1.setColumns(10);
		
		ad = new JTextField();
		ad.setBounds(224, 231, 119, 20);
		frmRegistration.getContentPane().add(ad);
		ad.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Deposit");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(40, 281, 62, 14);
		frmRegistration.getContentPane().add(lblNewLabel_5);
		
		dp = new JTextField();
		dp.setBounds(224, 279, 119, 20);
		frmRegistration.getContentPane().add(dp);
		dp.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{Connection con;
				Statement st;
				@SuppressWarnings("unused")
				ResultSet rs;
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con=DriverManager.getConnection("jdbc:odbc:Library");
				st=con.createStatement();
				String regex="^[0-9]{10}$";
				String name=name1.getText();
				String address=address1.getText();
				String num=ph1.getText();
				int phno=Integer.parseInt(num);
				String email_id=email1.getText();
				
				 @SuppressWarnings("deprecation")
				boolean isValidEmail = EmailValidator.getInstance().isValid(email_id);
			    String aadhar=ad.getText();
			    String deposit=dp.getText();  
			    int d = Integer.parseInt(deposit);
			    String Username=u1.getText();
			    String password=p1.getText();  
			    
			    System.out.println(name);
			    System.out.println(address);
			    System.out.println(phno);
			    System.out.println(aadhar);
			    System.out.println(deposit);
			    System.out.println(email_id);
			    System.out.println(Username);
			    System.out.println(password);
			    boolean a= num.matches(regex);
			    boolean b=aadhar.matches(regex);
			    
			    
			    if(name==null||name==""||name.length()<3)				{
					JOptionPane.showMessageDialog(null, "please enter correct name.");
                  name1.setText(" ");
				}
			    else if (address==null||address==""||address.length()<10)
			    {
			    	JOptionPane.showMessageDialog(null,"Please Enter Valid address.");
			    	address1.setText("");
					
			    }
			    else if (isValidEmail==false)
			    {
			    	JOptionPane.showMessageDialog(null,"Please Enter Valid email address.");
			    	email1.setText("");
					
			    }
			    else if (a==false)
			    {
			    	JOptionPane.showMessageDialog(null,"Please Enter Valid phone numbers.");
			    	ph1.setText("");
					
			    }
			    else if (a==false)
			    {
			    	JOptionPane.showMessageDialog(null,"Please Enter Valid aadhar number.");
			    	ad.setText("");
					
			    }
			    else if (d <500)
			    {
			    	JOptionPane.showMessageDialog(null,"Deposit too low");
			    	dp.setText("");
					
			    }
			    st.executeQuery("insert into Registration(name,address,phno,email_id,aadhar,deposit,Username,password)values('"+name+"','"+address+"','"+phno+"','"+email_id+"','"+aadhar+"','"+deposit+"','"+Username+"','"+password+"')");
			    
			    
				}
				
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				/*JOptionPane.showMessageDialog(null, "Registration Completed");
				Loginn n=new Loginn();
				frmRegistration.setVisible(false);
				n.frmLogin.setVisible(true);
				name1.setText("");
				address1.setText("");
				ph1.setText("");
				email1.setText("");
				ad.setText("");
				dp.setText("");
				u1.setText("");
				p1.setText("");
				*/
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(41, 408, 89, 23);
		frmRegistration.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("User Name");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(26, 306, 139, 24);
		frmRegistration.getContentPane().add(lblNewLabel_6);
		
		u1 = new JTextField();
		u1.setBounds(222, 309, 121, 20);
		frmRegistration.getContentPane().add(u1);
		u1.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(26, 348, 139, 24);
		frmRegistration.getContentPane().add(lblPassword);
		
		p1 = new JPasswordField();
		p1.setBounds(224, 350, 119, 20);
		frmRegistration.getContentPane().add(p1);
	}

	public JFrame getFrmRegistration() {
		return frmRegistration;
	}

	public void setFrmRegistration(JFrame frmRegistration) {
		this.frmRegistration = frmRegistration;
		frmRegistration.getContentPane().setBackground(new Color(0, 102, 255));
	}
}
