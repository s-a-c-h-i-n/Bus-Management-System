import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewBookings extends JFrame
{
	public ViewBookings()
	{
		JFrame bn =new JFrame("VIEW BOOKINGS");
		bn.setBounds(150,150,500,400);
		bn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		bn.setVisible(true);
		
		Container c2 = bn.getContentPane();
		c2.setLayout(null);
		
		Font font = new Font("Trebuchet",Font.BOLD,15);
		JLabel cl = new JLabel("ENTER THE BUS NUMBER");
		cl.setBounds(20,50,300,40);
		cl.setFont(font);
		c2.add(cl);

		JTextField ctext = new JTextField();
        ctext.setBounds(20,100,300,40);
		ctext.setForeground(Color.BLACK);
		c2.add(ctext);

		JButton p1 = new JButton("VIEW");
		p1.setBounds(40,150,300,40);
		c2.add(p1);
		//c2.revalidate();
	}
	
}		
		