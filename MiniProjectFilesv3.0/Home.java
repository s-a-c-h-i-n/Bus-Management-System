import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener
{
	JFrame fr=new JFrame();
		
	Color clr1=new Color(211,211,211);
	Color clr2=new Color(192,192,192);
		
	Cursor cr=new Cursor(Cursor.HAND_CURSOR);
		
	Font fh=new Font("Trebuchet MS",Font.BOLD,30);
	Font fl=new Font("Trebuchet MS",Font.BOLD,14);
		
	Container c=fr.getContentPane();
		
	JLabel lbl1=new JLabel();
			
	JButton btn=new JButton();
	JButton btn1=new JButton();
	JButton btn2=new JButton();
	
	public Home()
	{
				fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				fr.setBounds(467,50,475,625);
				fr.setTitle("Home Page");
				fr.setResizable(false);
			
				c.setBackground(clr1);
				c.setLayout(null);
				
				lbl1.setBounds(57,40,350,100);
				lbl1.setText("Welcome to BMS Portal!");
				lbl1.setFont(fh);
				lbl1.setForeground(Color.BLACK);
				lbl1.setHorizontalAlignment(SwingConstants.CENTER);
				
				btn.setBounds(150,195,125,50);
				btn.setText("Admin Login");
				btn.setBackground(clr2);
				btn.setForeground(Color.BLACK);
				btn.setFont(fl);
				btn.setCursor(cr);
				btn.addActionListener(this);
				
				btn1.setBounds(150,295,125,50);
				btn1.setText("User Login");
				btn1.setBackground(clr2);
				btn1.setForeground(Color.BLACK);
				btn1.setFont(fl);
				btn1.setCursor(cr);
				btn1.addActionListener(this);
				
				btn2.setBounds(150,395,125,50);
				btn2.setText("User Sign Up");
				btn2.setBackground(clr2);
				btn2.setForeground(Color.BLACK);
				btn2.setFont(fl);
				btn2.setCursor(cr);
				btn2.addActionListener(this);
				
				c.add(lbl1);
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
			fr.dispose();
			new Admin();
		}
		
		if(evt.getSource()==btn1)
		{
			fr.dispose();
			User obbj =new User();
			obbj.usr();
		}
		
		if(evt.getSource()==btn2)
		{
			fr.dispose();
			new SignUp();
		}
		}
		catch(Exception e)
		{}
	}
	
	public static void main(String [] args)
	{
		new Home();
	}
}