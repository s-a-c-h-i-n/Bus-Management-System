import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddRoute extends JFrame
{
	public void add()
	{
		JFrame an = new JFrame("ADD ROUTE");
		an.setBounds(300,100,600,500);
		an.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		an.setVisible(true);
		
		Container c1 =an.getContentPane();
        c1.setLayout(null);
		
		Font font = new Font("Trebuchet",Font.BOLD,15);
		Font font1 = new Font("Butler",Font.BOLD,15);
		
		JLabel b1 = new JLabel("Bus Number");
		b1.setBounds(30,50,200,40);
		c1.add(b1);
		JLabel b2 = new JLabel("Source");
		b2.setBounds(30,130,200,40);
		c1.add(b2);
		JLabel b3 = new JLabel("Destination");
		b3.setBounds(300,130,200,40);
		c1.add(b3);
		JLabel b4 = new JLabel("Bus Type");
		b4.setBounds(30,210,200,40);
		c1.add(b4);
		JLabel b5 = new JLabel("Fare(INR)");
		b5.setBounds(300,210,200,40);
		c1.add(b5);	
		
		
		b1.setFont(font);
		b2.setFont(font);
		b3.setFont(font);
		b4.setFont(font);
		b5.setFont(font);
		
		JTextField t1 = new JTextField();
        t1.setBounds(30,80,200,30);
		c1.add(t1);
		JTextField t2 = new JTextField();
        t2.setBounds(30,160,200,30);
		c1.add(t2);
		JTextField t3 = new JTextField();
        t3.setBounds(300,160,200,30);
		c1.add(t3);
		JTextField t4 = new JTextField();
        t4.setBounds(30,240,200,30);
		c1.add(t4);
		JTextField t5 = new JTextField();
        t5.setBounds(300,240,200,30);
		c1.add(t5);

		JButton bb1 = new JButton("ENTER");
		bb1.setBounds(140,325,200,30);
		bb1.setFont(font);
		c1.add(bb1);
		
		JButton bb2 = new JButton("Clear");
		bb2.setBounds(190,390,100,30);
		bb2.setFont(font);
		c1.add(bb2);
		
		bb2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event)
		{
			t1.setText("");
            t2.setText("");
            t3.setText(""); 			
		    t4.setText("");
			t5.setText("");
		}});

		
		bb1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event) 
		{
			Connection conn=null;
			Statement st = null;
			ResultSet rs = null;
			
			String s1,s2,s3,s4,s5;
            s1=t1.getText();
            s2=t2.getText();
            s3=t3.getText();
            s4=t4.getText();
			s5=t5.getText();
            
			try
            {
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
             String msAccDB = "C:/Users/Jayesh/Desktop/MiniProjectFiles/BusManagementSystemDatabase.accdb";
             String dbURL = "jdbc:ucanaccess://" + msAccDB; 
             conn = DriverManager.getConnection(dbURL); 
             st = conn.createStatement();
             String sql = "INSERT INTO BUSES VALUES('"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s1+"');";
             st.executeUpdate(sql);
			}
            catch(Exception sqlExcptn)
            {
              System.out.println(sqlExcptn);
            }
		}});
		c1.revalidate();  
	}
	public static void main(String args[])
	{
		AddRoute a = new AddRoute();
		a.add();
	}
}		