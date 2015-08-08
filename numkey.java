package calci;
import javax.swing.*;
import java.awt.*;

class numkey extends JPanel
{
	key[] digit;
	key plus, minus, multiplication, division, percentage, squaretroot, dot, pm,equal, reciprocal;

	numkey()
	{
		digit = new key[10];
		for(int i=0;i<10;i++)
		{
			digit[i] = new key(""+i);
		}	
		
		plus = new key("+");
		minus = new key("-");
		multiplication = new key("*");
		division = new key("/");
		squaretroot = new key(new String("\u221A"));
		percentage = new key("%");
		equal = new key("=");
		reciprocal = new key("1/x");
		dot = new key(".");
		pm = new key(new String("\u00B1"));

		this.setLayout(new GridLayout(4,5,5,5));
		this.add(digit[7]);
		this.add(digit[8]);
		this.add(digit[9]);
		this.add(plus);
		this.add(pm);
		this.add(digit[4]);
		this.add(digit[5]);
		this.add(digit[6]);
		this.add(minus);
		this.add(percentage);
		this.add(digit[1]);
		this.add(digit[2]);
		this.add(digit[3]);
		this.add(multiplication);
		this.add(squaretroot);
		this.add(digit[0]);
		this.add(dot);
		this.add(equal);
		this.add(division);
		this.add(reciprocal);
	}
}