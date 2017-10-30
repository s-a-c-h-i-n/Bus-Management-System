

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteRoute extends JFrame
{
	public void del()
	{
		JFrame cn =new JFrame("DELETE ROUTE");
		cn.setBounds(150,150,500,600);
		cn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cn.setVisible(true);
		
		Container c3 = cn.getContentPane();
		c3.setLayout(null);
		
		Font font = new Font("Trebuchet",Font.BOLD,15);
		JLabel cl = new JLabel("ENTER THE BUS NUMBER");
		cl.setBounds(20,50,300,40);
		cl.setFont(font);
        c3.add(cl);
		
		final JTextField ctext = new JTextField();
        ctext.setBounds(20,100,300,40);
		ctext.setForeground(Color.BLACK);
		c3.add(ctext);

		final JLabel next = new JLabel();
   		next.setBounds(50,250,500,30);
		next.setFont(font);
		c3.add(next);

		JButton bb1 = new JButton("NEXT");
		bb1.setBounds(120,175,200,30);
		bb1.setFont(font);
        c3.add(bb1);
		
		JButton bb2 = new JButton("Clear");
		bb2.setBounds(160,215,100,30);
		bb2.setFont(font);
		c3.add(bb2);
		
		bb2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event)
		{
			ctext.setText("");
		}});
		
		bb1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event)
		{			
			Connection conn=null;
			Statement st = null;
			ResultSet rs = null;
			
			String s1;
			s1=ctext.getText();
			
			try
            {
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
             String msAccDB = "C:/Users/Admin/Desktop/OOPM/MiniProjectFiles/BusManagementSystemDatabase.accdb";
             String dbURL = "jdbc:ucanaccess://" + msAccDB; 
             conn = DriverManager.getConnection(dbURL); 
             st = conn.createStatement();
             String sql = "DELETE FROM BUSES WHERE NUMBER='"+s1+"';";
             st.executeUpdate(sql);
			 next.setEnabled(true);
			 String data1 = "The Deleted Bus is " + ctext.getText();
			 next.setText(data1);
			
			} 
			catch(Exception sqlExcptn)
            {
              System.out.println(sqlExcptn);
            }
							
		}
		});
		//c3.revalidate();
	}
    /*public static void main(String args[])
	{
		new DeleteRoute();
	}*/
} 
	