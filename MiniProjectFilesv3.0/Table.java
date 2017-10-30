import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

class Table extends JFrame
{
	public void table(String s1)
	{
		JFrame q =new JFrame("VIEW BOOKINGS");
		q.setBounds(150,150,800,500);
		q.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		q.setVisible(true);
		
		String column[] = {};
		String data[][] = {}; 
		
		JTable jt = new JTable(data,column);
		JScrollPane sp = new JScrollPane(jt); 
	    q.add(sp); 
	
     	Connection conn=null;
		PreparedStatement pst = null,pst1 = null;
		ResultSet rs = null,rs1 = null;
		
		//String st = "";
		
		try
		{
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 String msAccDB = "C:/Users/Jayesh/Desktop/MiniProjectFiles/BusManagementSystemDatabase.accdb";
		 String dbURL = "jdbc:ucanaccess://" + msAccDB; 
		 conn = DriverManager.getConnection(dbURL); 
		 String sql = "select Source,Destination,Day,Months,Seats from BookTickets where Username='"+s1+"' ";
		 pst = conn.prepareStatement(sql);
		 rs = pst.executeQuery();
		 jt.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception sqlExcptn)
		{
		  System.out.println(sqlExcptn);
		}
		
	}	
	/*public static void main(String args[])
	{
	 new Table();
	}*/
}	