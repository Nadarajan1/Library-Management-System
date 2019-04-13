package Library1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.text.*;
import java.text.SimpleDateFormat;  
import java.sql.*;
/**
 *
 * @author  dk
 */
public class home extends javax.swing.JFrame implements ActionListener,ItemListener{
    JLabel j1,j2,j3,j4,j5,j6;
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2,b3,b4,b5;
   
    ResultSet rs,rs1,rs2;
    JComboBox c2;
    String ss;
    Statement st,st1,st2;
    Font f=new Font("Times New Roman",Font.ITALIC ,34);
    Font f1=new Font("Times New Roman",Font.ITALIC ,16);
    /** Creates new form HDM */
    public home() {
        super("HRA, MA, DA Setup Form" );
        Container con=getContentPane();
        con.setLayout(null);
        setSize(800,570);
        j1=new JLabel("GUPTA BAKER'S AND CONFECTIONER'S");
        j1.setFont(f);
        j1.setForeground(Color.BLUE);
        
        j2=new JLabel("EID");
        j2.setFont(f1);
        j3=new JLabel("BASIC");
        j3.setFont(f1);
        j4=new JLabel("HRA");
        j4.setFont(f1);
        j5=new JLabel("DA");
        j5.setFont(f1);
        j6=new JLabel("MA");
        j6.setFont(f1);
            
        c2=new JComboBox();
        c2.setFont(f1);
        c2.addItemListener(this);
        c2.addItem("");
        
        t1=new JTextField();
        t1.setFont(f1);
        t2=new JTextField();
        t2.setFont(f1);
        t3=new JTextField();
        t3.setFont(f1);
        t4=new JTextField();
        t4.setFont(f1);
              
                
            
                
        b1=new JButton("INSERT");
        b1.setFont(f1);
        b2=new JButton("UPDATE");
        b2.setFont(f1);
        b3=new JButton("DISPLAY");
        b3.setFont(f1);
        b4=new JButton("REFRESH");
        b4.setFont(f1);
        b5=new JButton("EXIT");
        b5.setFont(f1);
       
               
        j1.setBounds(120,20,700,50);
        j2.setBounds(200,100,100,25);
        j3.setBounds(200,150,300,25);
        j4.setBounds(200,200,300,25);
        j5.setBounds(200,250,300,25);
        j6.setBounds(200,300,300,25);
        
        
        
        c2.setBounds(350,100,150,25);
        t1.setBounds(350,150,150,25);
        t2.setBounds(350,200,150,25);
        t3.setBounds(350,250,150,25);
        t4.setBounds(350,300,150,25);
               
        b1.setBounds(130,400,100,30);
        b2.setBounds(230,400,110,30);
        b3.setBounds(340,400,110,30);
        b4.setBounds(450,400,110,30);
        b5.setBounds(560,400,80,30);
        
                
        b1.setActionCommand("INSERT");
        b2.setActionCommand("UPDATE");
        b3.setActionCommand("DISPLAY");
        b4.setActionCommand("REFRESH");
        b5.setActionCommand("EXIT");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        
           
        con.add(c2);
        con.add(j1);
        con.add(j2);
        con.add(j3);
        con.add(j4);
        con.add(j5);
        con.add(j6);
        con.add(t1);
        con.add(t2);
        con.add(t3);
        con.add(t4);
        con.add(b1);
        con.add(b2);
        con.add(b3);
        con.add(b4);
        con.add(b5);
       
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection c1=DriverManager.getConnection("Jdbc:Odbc:deepak");
            st1=c1.createStatement();
            rs1=st1.executeQuery("select EID from EMPMASTER");
                 while(rs1.next())
                    {
                        c2.addItem(rs1.getString("EID"));
                    }
        }catch( Exception eee)
            {
                JOptionPane.showMessageDialog(this,eee);
            }

        //initComponents();
    }
       public void actionPerformed(ActionEvent ae)
         {
                String s=ae.getActionCommand();
                try
                {
                     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                     Connection c= DriverManager.getConnection("Jdbc:Odbc:deepak");
                     st=c.createStatement();

             
        try
        {
             if(s.equals("INSERT"))
             {
                 try
                 {
                     String i=ss;
                     int i1=Integer.parseInt(t1.getText());
                     int i2=Integer.parseInt(t2.getText());
                     int i3=Integer.parseInt(t3.getText());
                     int i4=Integer.parseInt(t4.getText());

                     int rec=st.executeUpdate("insert into HDM values('"+i+"','"+i1+"','"+i2+"','"+i3+"','"+i4+"')");
                     // int uu1=st.executeUpdate("update EMPMASTER set Basic='"+i3+"' where EID ='"+i+"'");
                     JOptionPane.showMessageDialog(this,rec + " Record Inserted succesfully ");
                 }catch(Exception exe)
                     {
                         JOptionPane.showMessageDialog(this,exe);
                     }
                 
             }
                 
            else
                 {
                     if(s.equals("UPDATE"))
                     {
                         try
                         {
                             String u=ss;
                             int u2=Integer.parseInt(t1.getText());
                             int u3=Integer.parseInt(t2.getText());
                             int u4=Integer.parseInt(t3.getText());
                             int u5=Integer.parseInt(t4.getText());
                             int uu=st.executeUpdate("update HDM set BASIC='"+u2+"',HRA='"+u3+"',Da='"+u4+"',Ma='"+u5+"' where EID ='"+u+"'");
                             JOptionPane.showMessageDialog(this, uu + " Record Updated successfully ");
                         }catch(Exception o)
                             {
                                 JOptionPane.showMessageDialog(this, o );
                             }
                     }
                     else
                     {
                         if(s.equals("DISPLAY"))
                         {
                                 String dip =ss;
                                 rs=st.executeQuery("select * from HDM where EID='"+dip+"'");
                                 while(rs.next())
                                 {
                                     try
                                     {
                                     
                                         t1.setText(rs.getString("BASIC"));
                                         t2.setText(rs.getString("HRA"));
                                         t3.setText(rs.getString("DA"));
                                         t4.setText(rs.getString("MA"));

                                     }catch(Exception oo)
                                         {
                                             JOptionPane.showMessageDialog(this,oo);
                                         }
                                 }
                                   
                         }
                         else
                             {
                                 if(s.equals("REFRESH"))
                                   {
                                        t1.setText("");
                                        t2.setText("");
                                        t3.setText("");
                                        t4.setText("");
                                    }
                                     else
                                     {
                                         if(s.equals("EXIT"))
                                         {
                                             this.disable();
                                             this.dispose();
                                         }
                                     }
                             }
                         }
                     }
                 
            
           }catch(Exception e)
            {
                 System.out.println(e);
            }
     }catch(Exception aa)
        {
            JOptionPane.showMessageDialog(this,aa);
        }
        
    }
    public void itemStateChanged(ItemEvent ie) 
    {
        try
        {
              Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
              Connection c4= DriverManager.getConnection("Jdbc:Odbc:deepak");
              st2=c4.createStatement();
              ss=ie.getItem().toString();
              rs2=st2.executeQuery("select EID,Basic from EMPMASTER");
          while(rs2.next())
              {
              if (ss.equals(rs2.getString("EID")))
                  {
                      t1.setText(rs2.getInt("Basic")+"");
                      t3.setText("");
                     //JOptionPane.showMessageDialog(this,t2);
                  }
            }
         
        }catch(Exception oo)
           {
              JOptionPane.showMessageDialog(this,oo);
            }
           
        //initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
   // private void initComponents() {
        
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
       /* org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(0, 400, Short.MAX_VALUE)
                );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(0, 300, Short.MAX_VALUE)
                );
        pack();
    }
    */
    // </editor-fold>//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}

