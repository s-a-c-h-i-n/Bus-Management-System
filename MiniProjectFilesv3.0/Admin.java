import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Admin implements ActionListener
{
	JFrame fr=new JFrame();
	Color clr1=new Color(211,211,211);
	Color clr2=new Color(192,192,192);
	JTextField txt1=new JTextField();
	JPasswordField pass=new JPasswordField();
	JLabel lbl=new JLabel();	
	JLabel lbl1=new JLabel();	
	JLabel lbl2=new JLabel();	
	JButton btn=new JButton();
	Cursor cr=new Cursor(Cursor.HAND_CURSOR);
	Font fh=new Font("Trebuchet MS",Font.BOLD,30);
	Font fs=new Font("Trebuchet MS",Font.BOLD,13);
	Container c=fr.getContentPane();
	
		public Admin()
	{
		
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setBounds(430,120,425,375);
		fr.setTitle("Administrator Login");
		fr.setResizable(false);
		
		
		c.setBackground(clr1);
		c.setLayout(null);
		
		txt1.setBounds(192,127,160,30);
		txt1.setFont(fs);
		txt1.setForeground(Color.BLACK);
		
		pass.setBounds(192,188,160,30);
		pass.setFont(fs);
		pass.setEchoChar('*');	
		pass.setForeground(Color.BLACK);
		
		lbl.setBounds(30,32,350,50);
		lbl.setText("Administrator Login");
		lbl.setFont(fh);
		lbl.setForeground(Color.BLACK);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		lbl1.setBounds(43,130,110,25);
		lbl1.setText("Admin Username:");
		lbl1.setForeground(Color.BLACK);
		lbl1.setFont(fs);
		lbl1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lbl2.setBounds(43,192,110,25);
		lbl2.setText("Password:");
		lbl2.setForeground(Color.BLACK);
		lbl2.setFont(fs);
		lbl2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		btn.setBounds(155,270,100,28);
		btn.setText("Log In");
		btn.setBackground(clr2);
		btn.setForeground(Color.BLACK);
		btn.setCursor(cr);
		btn.addActionListener(this);
		
		c.add(lbl);
		c.add(lbl1);
		c.add(lbl2);
		c.add(btn);
		c.add(txt1);
		c.add(pass);
		fr.setVisible(true);
	}
	
		public void actionPerformed(ActionEvent evt)
		{
		try
		{  
				if(evt.getSource()==btn)
			{
			
				Connection conn=null;
			PreparedStatement st = null;
			ResultSet rs = null;
			
			String user,password;
            user=txt1.getText();
            password=pass.getText();
				
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
             String msAccDB = "C:/Users/Jayesh/Desktop/MiniProjectFiles/BusManagementSystemDatabase.accdb";
             String dbURL = "jdbc:ucanaccess://" + msAccDB; 
             conn = DriverManager.getConnection(dbURL); 
             
				String sql = "select * from AdminSection where AdminUsername='"+user+"' and Password='"+password+"'";
				
				st = conn.prepareStatement(sql);
				rs=st.executeQuery();
				
				if(rs.next())
				{	//JOptionPane.showMessageDialog(null,"User Found, Access Granted!");
					Admin1 obj=new Admin1();
					obj.adm();
				}else 
					JOptionPane.showMessageDialog(null,"User Not Found, Access Denied!");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}	
	}

	public static void main(String[] args)
	{
		new Admin();
	}
	
	
	}