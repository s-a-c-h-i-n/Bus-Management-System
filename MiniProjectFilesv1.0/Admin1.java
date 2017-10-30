import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Admin1
{
		public void adm()
		{
			JFrame f =new JFrame("ADMIN PANEL");
		    f.setBounds(100,100,800,600);
		    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		    Container c = f.getContentPane();
		    c.setLayout(null);
	
		/*Creating labels */
		JLabel label1 = new JLabel("ADMINISTRATION PAGE");
		label1.setBounds(200,20,700,150);
		c.add(label1);
		
		JButton bb2 = new JButton("ADD ROUTE");
		bb2.setBounds(100,200,500,40);
	    c.add(bb2);
		
		bb2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event)
		{
			AddRoute a=new AddRoute();
			a.add();
		}
		});
		
		JButton bb3 = new JButton("DELETE ROUTE");
		bb3.setBounds(100,300,500,40);
        c.add(bb3);
		bb3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event)
		{
			DeleteRoute d=new DeleteRoute();
			d.del();
		}
		});
		
		Font f1 = new Font("Trebuchet MS",Font.BOLD,30);
		label1.setFont(f1);
		Font f2 = new Font("Trebuchet MS",Font.BOLD,20);
		bb2.setFont(f2);
		bb3.setFont(f2);
		
		f.setVisible(true);
		//f.setBackground(Color.WHITE);
	
}
	/*public static void main(String [] args)
		{			
			new Admin1();
		}*/
}		
		