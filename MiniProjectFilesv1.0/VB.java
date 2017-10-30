import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class VB extends JFrame
{
	public static void main(String args[])
	{
	   Vector columnNames = new Vector();
       Vector data = new Vector();
	   
	   JFrame bn =new JFrame("BOOKINGS");
	   bn.setBounds(150,150,500,400);
	   bn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   bn.setVisible(true);
	
	   Container c2 = bn.getContentPane();
	   c2.setLayout(null);
       
	   try{
         Connection conn=null;
         Statement st = null;
		 ResultSet rs = null;
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
         String msAccDB = "E:/OOPM/MiniProjectFiles/BusManagementSystemDatabase.accdb";
         String dbURL = "jdbc:ucanaccess://" + msAccDB; 
         conn = DriverManager.getConnection(dbURL); 
         st = conn.createStatement();
         String sql = "SELECT * FROM BOOKINGS WHERE NUMBER = '"+s1+"';";
		 rs =  rs = stmt.executeQuery( sql );
         ResultSetMetaData md = rs.getMetaData();
         int columns = md.getColumnCount();
         for (int i = 1; i <= columns; i++)
		 {
          columnNames.addElement( md.getColumnName(i) );
         }
         while (rs.next()) {
         Vector row = new Vector(columns);
         for (int i = 1; i <= columns; i++)
		 {
          row.addElement( rs.getObject(i) );
         }
         data.addElement( row );
        }
       }
        catch(Exception e){
       System.out.println(e);
       }
       JTable table = new JTable(data, columnNames);
       TableColumn col;
       for (int i = 0; i < table.getColumnCount(); i++) {
       col = table.getColumnModel().getColumn(i);
       col.setMaxWidth(250);
      }  
      JScrollPane scrollPane = new JScrollPane( table );
      p.add( scrollPane );
      JFrame f=new JFrame();
      f.add(p);
      f.setSize(600,400);
      f.setVisible(true);
    }
}

		 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	