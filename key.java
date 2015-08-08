package calci;
import javax.swing.*;
import java.awt.*;

class key extends JButton
{
	key(String s)
	{
		super(s);
		this.setMargin(new Insets(7,7,7,7));
		this.addMouseListener(new click());
		this.addActionListener(new click());
		this.addKeyListener(new click());
		this.setActionCommand(s);
	}
}