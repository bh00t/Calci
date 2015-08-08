package calci;
//importing GUI packages of java.
import java.awt.*;
import java.awt.event.*;

// operation defined in this class for calculation (binary and unary)
class function
{
	 static double z=0.0;
	String binary(String a,char operation,String b)
	{
		double x = Double.parseDouble(a);
		double y = Double.parseDouble(b);
		switch(operation)
		{
			case '+':
					z=x+y;
					break;

			case '-':	
					z=x-y;
					break;

			case '*':
					z=x*y;
					break;

			case '/':
					z=x/y;
					break;

			case '%' :
					z=x*100/y;
					break;
			default: break;
		}
		if(Double.toString(z).compareTo("Infinity")==0)
		{
			Toolkit.getDefaultToolkit().beep();
			calculation.stop=1;
			if(y!=0)
				return "Overflow";
			else
				return "Cannot divide by zero";
		}
		else if(Double.toString(z).compareTo("NaN")==0)
		{
			Toolkit.getDefaultToolkit().beep();
			calculation.stop=1;
			return "Not define";
		}
		else if(z==(long)z)
			return Long.toString((long)z);
		else
			return Double.toString(z);
	}

	String unary(String a,char operation)
	{
		double x = Double.parseDouble(a);
		switch(operation)
		{
			
			case '1' :
				z=1/x;
				break;

			case '\u221A' :
				z=Math.sqrt(x);
				break;

			default:break;
		}

		if(x==0 && operation=='1')
		{
			Toolkit.getDefaultToolkit().beep();		// for beep sound
			calculation.stop=1;
			return "Cannot divide by zero";
		}
		else if(Double.toString(z)=="NaN")
		{
			Toolkit.getDefaultToolkit().beep();
			calculation.stop=1;
			return "Not define";
		}
		else if(z==(long)z)
			return Long.toString((long)z);
		else
			return Double.toString(z);
	}
}