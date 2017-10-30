import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class User implements ActionListener
{	
	JFrame fr=new JFrame();
	Color clr1=new Color(211,211,211);
	Color clr2=new Color(192,192,192);
	Cursor cr=new Cursor(Cursor.HAND_CURSOR);
	Font fh=new Font("Trebuchet MS",Font.BOLD,30);
	Font fs=new Font("Trebuchet MS",Font.BOLD,13);
	Font fl=new Font("Trebuchet MS",Font.BOLD,14);
	Font fi=new Font("Trebuchet MS",Font.ITALIC,12);
	Container c=fr.getContentPane();
	JLabel lbl1=new JLabel();
	JLabel lbl2=new JLabel();
	JLabel lbl3=new JLabel();
	JLabel lbl4=new JLabel();
	JTextField txt=new JTextField();
	JPasswordField pass=new JPasswordField();
	JButton btn=new JButton();
	JButton btn1=new JButton();
	public static String user;
	
	public void usr()
	{
		
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setBounds(430,120,435,420);
		fr.setTitle("Customer Login");
		fr.setResizable(false);
		c.setBackground(clr1);
		c.setLayout(null);
		lbl1.setBounds(30,30,350,50);
		lbl1.setText("Customer Login");
		lbl1.setFont(fh);
		lbl1.setForeground(Color.BLACK);
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setBounds(33,192,110,25);
		lbl2.setText("Password:");
		lbl2.setForeground(Color.BLACK);
		lbl2.setFont(fs);
		lbl2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl3.setBounds(33,130,110,25);
		lbl3.setText("Username:");
		lbl3.setForeground(Color.BLACK);
		lbl3.setFont(fs);
		lbl3.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl4.setBounds(68,305,275,28);
		lbl4.setText("If you don't have an existing Account");	
		lbl4.setFont(fi);
		lbl4.setForeground(Color.BLACK);
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		txt.setBounds(194,127,155,30);
		txt.setFont(fs);
		txt.setForeground(Color.BLACK);
		pass.setBounds(194,190,155,30);
		pass.setFont(fs);
		pass.setEchoChar('*');	
		pass.setForeground(Color.BLACK);
		btn.setBounds(155,255,100,28);
		btn.setText("Log In");
		btn.setFont(fl);
		btn.setBackground(clr2);
		btn.setForeground(Color.BLACK);
		btn.setCursor(cr);
		btn.addActionListener(this);
		btn1.setBounds(117,336,175,28);
		btn1.setText("Create a New Account");
		btn1.setBackground(clr2);
		btn1.setForeground(Color.BLACK);
		btn1.setCursor(cr);
		btn1.addActionListener(this);
		c.add(lbl1);
		c.add(lbl2);
		c.add(lbl3);
		c.add(lbl4);
		c.add(txt);
		c.add(pass);
		c.add(btn);
		c.add(btn1);
		
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
			
			String password;
            user=txt.getText();
            password=pass.getText();
				
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
             String msAccDB = "C:/Users/Jayesh/Desktop/MiniProjectFiles/BusManagementSystemDatabase.accdb";
             String dbURL = "jdbc:ucanaccess://" + msAccDB; 
             conn = DriverManager.getConnection(dbURL); 
             
				String sql = "select * from UserSignIn where Username='"+user+"' and Password='"+password+"'";
				
				st = conn.prepareStatement(sql);
				rs=st.executeQuery();
				
				if(rs.next())
				{
					System.out.println(user);
					MyProject obj=new MyProject();
					obj.vbs();
				}else 
					JOptionPane.showMessageDialog(null,"User Not Found, Access Denied!");
			}
			
			if(evt.getSource()==btn1)
			{
				fr.dispose();
				new SignUp();
			}
			
			}catch(Exception e)
			{}
	}
	
	public static void main(String[] args)
	{
		User u = new User();
		u.usr();
	}
}
