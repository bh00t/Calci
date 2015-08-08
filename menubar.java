package calci;
//importing GUI packages of java.
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class menubar extends JMenuBar implements ActionListener
{
	JMenu m;
	JMenuItem mi;
	JDialog d;

	menubar(JFrame f)
	{

		String s="About Calculator";

		m = new JMenu("Help",false);							
		mi = new JMenuItem(s);
		mi.addActionListener(this);
		mi.setActionCommand(s);

		d = new JDialog(f,s,true);									// Creating modal dialog window.
		d.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		d.setBounds(593,358,360,120);								// Setting dimension of dialog window
		d.setResizable(false);
		ImageIcon calicon=new ImageIcon("calci/calculator.gif");
		d.setIconImage(calicon.getImage());							// Setting icon of dialog window
		d.setLayout(new BorderLayout());

		JButton ok = new JButton("OK");
		ok.addActionListener(this);
		ok.setActionCommand("OK");
		JPanel pb = new JPanel();
		pb.setLayout(new FlowLayout());
		pb.add(ok);

		JPanel pabout = new JPanel();
		JLabel a = new JLabel("CalCi 1.0 is open source calculator created for education purpose",JLabel.LEFT);
		JLabel b = new JLabel("by Rishabh Tripathi. It's all files and codes are open source.",JLabel.LEFT);
		JLabel o = new JLabel("Creator will not resposible for any wrong calculation by calculator (if any).",JLabel.LEFT);
		Font font=new Font(a.getFont().getName(),a.getFont().getStyle(),9);
		a.setFont(font);
		b.setFont(font);
		o.setFont(font);
		pabout.add(a);
		pabout.add(b);
		pabout.add(o);

		d.add(pabout,BorderLayout.CENTER);				// adding Panel containg text in dialog window
		d.add(pb,BorderLayout.SOUTH);					// adding OK Button in dialog window

		m.add(mi);										// adding MenuItem in Menu
		this.add(m);									// adding Menu in MenuBar
	}

	public void actionPerformed(ActionEvent a)
	{
		String s=a.getActionCommand();
		if(s.compareTo("About Calculator")==0)
			d.show();
		else if(s.compareTo("OK")==0)
			d.dispose();
	}

}