package calci;
//importing GUI packages of java.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class cal extends JFrame
{
	simple s;
	menubar m;

	cal()
	{
		super("Calculator");
		
		ImageIcon calicon=new ImageIcon("calci/calculator.gif");
		this.setIconImage(calicon.getImage());
		Container maincntnr = this.getContentPane();
		maincntnr.setLayout(new BorderLayout());

		m = new menubar(this);
		this.setJMenuBar(m);
		s=new simple();
		this.add(s,BorderLayout.CENTER);
		
		this.setBounds(593,258,219,313);
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);

	} 

	public static void main(String[] args)
	{
		cal c = new cal();
	}
}