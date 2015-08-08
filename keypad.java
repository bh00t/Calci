package calci;
//importing GUI packages of java.
import javax.swing.*;
import java.awt.*;

class keypad extends JPanel
{
	numkey n1;
	functionkey f1;
	keypad()
	{
		this.setLayout(new BorderLayout(0,4));
		f1 = new functionkey();
		n1 = new numkey();
		this.add(f1,BorderLayout.NORTH);
		this.add(n1,BorderLayout.CENTER);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
}