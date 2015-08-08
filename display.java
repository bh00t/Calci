package calci;
//importing GUI packages of java.
import javax.swing.*;
import java.awt.*;

class display extends JPanel
{
	static JLabel result, input;

	display()
	{
		super(false);
		this.setLayout(new GridLayout(2,1,1,6));
		result = new JLabel("",JLabel.LEFT);
		input = new JLabel("0",JLabel.RIGHT);

		// fontsize setting for labels
		Font inputFont=new Font(input.getFont().getName(),input.getFont().getStyle(),16);		
		Font resultFont=new Font(result.getFont().getName(),result.getFont().getStyle(),12);
		input.setFont(inputFont);
		result.setFont(resultFont);

		this.add(result);											// adding result Label in Panel
		this.add(input);											// adding input Label in Panel
		this.setBorder(BorderFactory.createLoweredBevelBorder());	// Border setting of Panel
	}

}