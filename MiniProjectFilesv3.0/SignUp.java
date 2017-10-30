import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class SignUp extends User implements ActionListener
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
	JLabel lbl5=new JLabel();
	JLabel lbl6=new JLabel();
	JLabel lbl7=new JLabel();
		
	JTextField txt1=new JTextField();
	JTextField txt2=new JTextField();
	JTextField txt3=new JTextField();
	JTextField txt4=new JTextField();
	JPasswordField pass=new JPasswordField();
		
	JButton btn=new JButton();
	JButton btn1=new JButton();
	JButton btn2=new JButton();
	
	 Connection connection = null;
     Statement statement = null;
     ResultSet resultSet = null;
	
	public SignUp() 
	{
	
				fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				fr.setBounds(467,50,475,625);
				fr.setTitle("Customer Sign Up");
				fr.setResizable(false);
			
				c.setBackground(clr1);
				c.setLayout(null);
		
				/*try
				{
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				}
				catch(ClassNotFoundException cnfex) {
 
					System.out.println("Problem in loading or "
                    + "registering MS Access JDBC driver");
					cnfex.printStackTrace();
				}
				
				String msAccDB = "C:/Users/Admin/Desktop/OOPM/MiniProjectFiles/BusManagementSystemDatabase.accdb";
				String dbURL = "jdbc:ucanaccess://" + msAccDB; 
			
				connection = DriverManager.getConnection(dbURL); 
				
				statement = connection.createStatement();
			*/
			
			lbl1.setBounds(57,30,350,50);
			lbl1.setText("User Sign Up");
			lbl1.setFont(fh);
			lbl1.setForeground(Color.BLACK);
			lbl1.setHorizontalAlignment(SwingConstants.CENTER);
			lbl2.setBounds(75,125,100,30);
			lbl2.setText("First Name:");
			lbl2.setFont(fs);
			lbl2.setForeground(Color.BLACK);
			lbl2.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl3.setBounds(75,195,100,30);
			lbl3.setText("Last Name:");
			lbl3.setFont(fs);
			lbl3.setForeground(Color.BLACK);
			lbl3.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl4.setBounds(75,335,100,30);
			lbl4.setText("Username:");
			lbl4.setFont(fs);
			lbl4.setForeground(Color.BLACK);
			lbl4.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl5.setBounds(75,405,100,30);
			lbl5.setText("Password:");
			lbl5.setFont(fs);
			lbl5.setForeground(Color.BLACK);
			lbl5.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl6.setBounds(75,265,100,30);
			lbl6.setText("Mobile Number:");
			lbl6.setFont(fs);
			lbl6.setForeground(Color.BLACK);
			lbl6.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl7.setBounds(96,510,275,30);
			lbl7.setText("If you already have an Account");
			lbl7.setFont(fi);
			lbl7.setForeground(Color.BLACK);
			lbl7.setHorizontalAlignment(SwingConstants.CENTER);
		
			txt1.setBounds(245,123,133,30);
			txt1.setFont(fs);
			txt1.setForeground(Color.BLACK);
			txt1.setHorizontalAlignment(SwingConstants.LEFT);
			txt2.setBounds(245,193,133,30);
			txt2.setFont(fs);
			txt2.setForeground(Color.BLACK);
			txt2.setHorizontalAlignment(SwingConstants.LEFT);
			txt3.setBounds(245,263,133,30);
			txt3.setFont(fs);
			txt3.setForeground(Color.BLACK);
			txt3.setHorizontalAlignment(SwingConstants.LEFT);  
			txt3.setColumns(10);
			txt4.setBounds(245,333,133,30);
			txt4.setFont(fs);
			txt4.setForeground(Color.BLACK);
			txt4.setHorizontalAlignment(SwingConstants.LEFT);
			pass.setBounds(245,403,133,30);
			pass.setFont(fs);
			pass.setEchoChar('*');	
			pass.setForeground(Color.BLACK);
		
			txt3.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent e)
				{
					char c = e.getKeyChar();
					if (((c < '0') || (c > '9'))
                        && (c != '\b')) 
					{
						e.consume();
					}
				}
			});
		
			btn.setBounds(120,463,100,28);
			btn.setText("Sign Up");
			btn.setBackground(clr2);
			btn.setForeground(Color.BLACK);
			btn.setFont(fl);
			btn.setCursor(cr);
			btn.addActionListener(this);
			btn1.setBounds(140,540,200,28);
			btn1.setText("Login to existing Account");
			btn1.setBackground(clr2);
			btn1.setForeground(Color.BLACK);
			btn1.setFont(fl);
			btn1.setCursor(cr);
			btn1.addActionListener(this);
			btn2.setBounds(275,463,100,28);
			btn2.setText("Clear");
			btn2.setBackground(clr2);
			btn2.setForeground(Color.BLACK);
			btn2.setFont(fl);
			btn2.setCursor(cr);
			btn2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event)
		{
			txt1.setText("");
            txt2.setText("");
            txt3.setText(""); 			
		    txt4.setText("");
			pass.setText("");
		}});
			c.add(lbl1);
			c.add(lbl2);
			c.add(lbl3);
			c.add(lbl4);
			c.add(lbl5);
			c.add(lbl6);
			c.add(lbl7);
			c.add(txt1);
			c.add(txt2);
			c.add(txt3);
			c.add(txt4);
			c.add(pass);
			c.add(btn);
			c.add(btn1);
			c.add(btn2);
			fr.setVisible(true);
	
		}
		
	
	public void actionPerformed(ActionEvent evt)
	{
		try
		{
			if(evt.getSource()==btn)
			{
				Connection conn=null;
			Statement st = null;
			ResultSet rs = null;
			
			String s1,s2,s3,s4,s5;
            s1=txt1.getText();
            s2=txt2.getText();
            s3=txt3.getText();
            s4=txt4.getText();
			s5=pass.getText();
            
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
             String msAccDB = "C:/Users/Jayesh/Desktop/MiniProjectFiles/BusManagementSystemDatabase.accdb";
             String dbURL = "jdbc:ucanaccess://" + msAccDB; 
             conn = DriverManager.getConnection(dbURL); 
             st = conn.createStatement();
             String sql = "INSERT INTO USER SECTION VALUES('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"');";
             String sql1= "INSERT INTO USERSIGNIN VALUES('"+s5+"','"+s4+"');";
			 st.executeUpdate(sql);
			 st.executeUpdate(sql1);	
			}	
				
			try
			{
				if(evt.getSource()==btn1)
			{
				fr.dispose();
				User us = new User();
				us.usr();
			}}
			catch(NullPointerException ex)
			{}
		}
		catch(Exception exc)
            {
              System.out.println(exc);
            }
		
	}
	
	public static void main(String[] args)
	{
		new SignUp();
	}
}