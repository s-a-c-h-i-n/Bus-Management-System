import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class ViewBookings extends Table
{
	JFrame bn =new JFrame("VIEW BOOKINGS");
	
	public void VB()
	{
		bn.setBounds(150,150,500,500);
		bn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		bn.setVisible(true);
		
		Container c2 = bn.getContentPane();
		c2.setLayout(null);
		
		Font font = new Font("Trebuchet",Font.BOLD,15);
		JLabel cl = new JLabel("ENTER USERNAME");
		cl.setBounds(50,50,300,40);
		cl.setFont(font);
		c2.add(cl);
        
		
		JTextField ctext = new JTextField();
        ctext.setBounds(50,100,300,40);
		ctext.setForeground(Color.BLACK);
		c2.add(ctext);
        
		JButton p1 = new JButton("VIEW");
		p1.setBounds(160,150,100,40);
		c2.add(p1);
		c2.revalidate();
		
		JButton p2 = new JButton("Clear");
		p2.setBounds(160,200,100,40);
		c2.add(p2);
		
		p1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event) 
		{
			Connection conn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			
			String s2;
			s2 = ctext.getText();
			
			try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String msAccDB = "C:/Users/Jayesh/Desktop/MiniProjectFiles/BusManagementSystemDatabase.accdb";
			String dbURL = "jdbc:ucanaccess://" + msAccDB; 
			conn = DriverManager.getConnection(dbURL); 
			String sql = "select * from BookTickets where Username='"+s2+"' ";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			if(s2.equals(""))
		    {
			  JOptionPane.showMessageDialog(null,"Enter Username!"); 
		    }
			else if(rs.next())
			{
			  Table t = new Table();
			  t.table(s2);	
			}
			else
			{
			  JOptionPane.showMessageDialog(null,"Username not Found!");
			}
			}
			catch(Exception e)
			{}
		}});
		
		p2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event) 
		{
			ctext.setText("");
		}});		
		
	}
	public static void main(String args[])
	{
		ViewBookings vb = new ViewBookings();
		vb.VB();
	} 
	
}		
