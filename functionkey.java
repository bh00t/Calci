package calci;
//importing GUI packages of java.
import javax.swing.*;
import java.awt.*;

class functionkey extends JPanel
{
	key MC, MR, MS, Delete, C, CE;

	functionkey()
	{
		MC = new key("MC");
		MR = new key("MR");
		MS = new key("MS");
		Delete = new key("DEL");
		CE = new key("CE");
		C = new key("C");

		this.setLayout(new GridLayout(2,3,6,6));
		this.add(MC);
		this.add(MR);
		this.add(MS);
		this.add(Delete);
		this.add(CE);
		this.add(C);
	}
}