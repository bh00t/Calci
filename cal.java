package calci;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class display extends JPanel
{
	static JLabel result, input;

	display()
	{
		super(false);
		this.setLayout(new GridLayout(2,1,1,6));
		result = new JLabel("",JLabel.LEFT);
		input = new JLabel("0",JLabel.RIGHT);
		Font inputFont=new Font(input.getFont().getName(),input.getFont().getStyle(),15);
		Font resultFont=new Font(result.getFont().getName(),result.getFont().getStyle(),11);
		input.setFont(inputFont);
		result.setFont(resultFont);
		this.add(result);
		this.add(input);
		this.setBorder(BorderFactory.createLoweredBevelBorder());
	}

}

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

class functionkey extends JPanel
{
	key MC, MR, MS, Delete, C, CE;

	functionkey()
	{
		MC = new key("MC");
		//MC.setActionCommand("MC");
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
		//squaretroot.setActionCommand("S");
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
		//this.setSize(180,200);
	}
}

class click implements ActionListener,MouseListener,KeyListener
{
	String s;
	static calculation c1=new calculation();
	private Color previousColor;
	
	public void actionPerformed(ActionEvent a)
	{
		s=c1.input(a.getActionCommand());
		display.input.setText(s);
	}

	public void mouseEntered(MouseEvent e)
	{
		Component component = (Component) e.getSource();
		previousColor = component.getBackground();
		component.setBackground(Color.CYAN);
	}
	public void mouseExited(MouseEvent e)
	{
		Component component = (Component) e.getSource();
		component.setBackground(previousColor);
	}

	public void mouseReleased(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
//////////////////////////////////////////////////////////////////////////////

	public void keyTyped(KeyEvent e) 
	{
	 	int key = (int)e.getKeyChar();

	 	if(key >= 48 && key<=57)
	 	{
	 		s=c1.input(Character.toString((char)key));
	 		
	 	}
	 	else
		 	switch(key)
		 	{
		 		case 97:
		 		case 65:
		 		case 43:
		 				s=c1.input("+");
		 			//	display.input.setText("+");
		 				break;
		 		case 115:
		 		case 83:
		 		case 45:
		 				s=c1.input("-");
		 			//	display.input.setText("-");
		 				break;
		 		case 109:
		 		case 77:
		 		case 42:
		 				s=c1.input("*");
		 			//	display.input.setText("*");
		 				break;
		 		case 100:
		 		case 68:
		 		case 47:
		 				s=c1.input("/");
		 			//	display.input.setText("/");
		 				break;
		 		case 112:
		 		case 37:
		 		case 80:
		 				s=c1.input("%");
		 			//	display.input.setText("%");
		 				break;
		 		case 67:
		 		case 99:
		 				s=c1.input("C");
		 			//	display.input.setText("C");
		 				break;
		 		case 127:
		 				s=c1.input("CE");
		 				//display.input.setText("CE");
		 				break;
		 		case 8:
		 				s=c1.input("D");
		 				//display.input.setText("D");
		 				break;
		 		case 46:
		 				s=c1.input(".");
		 				//display.input.setText(".");
		 				break;
		 		case 61:
		 		case 10:
		 				s=c1.input("=");
		 				display.input.setText("=");
		 				break;
		 		case 105:
		 		case 73:
		 				s=c1.input("\u00B1");
		 				break;
		 		case 114:
		 		case 82:
		 				s=c1.input("1/x");
		 				break;
		 		case 117:
		 		case 85:
		 				s=c1.input("\u221A");
		 				break;
		 		default : break;

		 	}
		 	display.input.setText(s);
		 	
    }

      public void keyPressed(KeyEvent e){}

      public void keyReleased(KeyEvent e){}



}

class calculation extends function
{
	StringBuffer in=new StringBuffer("0");
	StringBuffer result = new StringBuffer("");
	byte op=0,e=0,dot=0,sr=0;
	static byte stop=0;
	String a=new String();
	String ans;
	double M=0;
	String b=new String();
	char operation=(int)0;
	String input(String clk)
	{
		if(stop==0)
		if(clk.charAt(0)>=48 && clk.charAt(0)<=57 && clk.length()==1)
		{
			if(op==1 || e==1)
			{
				in=new StringBuffer("0");
				System.out.println("equal caught");
				op=0;
				e=0;
			}
			if (in.length()==16)
				Toolkit.getDefaultToolkit().beep();
			else if(in.length()==1 )
			{
				if(in.charAt(0)=='0')
					in.deleteCharAt(0);
				in.append(clk);
			}
			else 
				in.append(clk);
		}

		else
		{
			switch(clk.charAt(0))
			{
				case '.':
					if(dot==1)
						Toolkit.getDefaultToolkit().beep();
					else 
					{
						if(e==1 || op==1)
						{
							in=new StringBuffer("0");
							e=0;
							op=0;
						}
						in.append(clk);
						dot=1;
					}
						break;

				case '+':
				case '-':
				case '*':
				case '/':
				case '%' :
					if(result.length()==0 )
						{
							if(op==0)
							System.out.println("op=0 rlen=0");
							op=1;
							a=in.toString();
							operation = clk.charAt(0);

							result=result.append(" "+a+" "+clk);
							display.result.setText(result.toString());
							b=new String();
						}
					else if(op==0)
					{
						if(op==0)
						System.out.println("HERE");
						if(sr==1 && a.length()==0)
						{
							a=in.toString();
							result = result.append(" "+clk);
							if(result.length()>31)//31
								result=result.replace(0,result.length()-31,"<< ");
							sr=0;
						}
						else
						{
							b=in.toString();
							System.out.println("HERE  s and al "+b+" "+result);
							if(sr!=1)
							result=result.append(" "+b+" "+clk);
							else
								result=result.append(" "+clk);
							if(result.length()>31)//31
								result=result.replace(0,result.length()-31,"<< ");
							//System.out.println("NOW "+b+" "+result);
							display.result.setText(result.toString());
							ans=binary(a,operation,b);
							operation = clk.charAt(0);
							in =new StringBuffer(ans);
							a=in.toString();
							b=new String();
							sr=0;
						}
						op=1;
					}
					else
					{
						if(op==1)
						System.out.println("op=1");
						operation = clk.charAt(0);
						if(result.charAt(result.length()-1)!=')')
						{
							System.out.println("WE not Found sqrt");
							result.deleteCharAt(result.length()-1);
						}
						result.append(clk);
						display.result.setText(result.toString());
					}
					if(result.length()>31)//31
						result=result.replace(0,result.length()-31,"<< ");
					dot=0;
						break;
				
				case '1' :
						ans = unary(in.toString(),clk.charAt(0));
						in = new StringBuffer(ans);
						e=1;
						dot=0;
						break;
				case '\u221A' :
						ans=unary(in.toString(),clk.charAt(0));
						op=0;
						sr=1;
						//operation=clk.charAt(0);
						if(ans=="NaN")
						{
							Toolkit.getDefaultToolkit().beep();
							stop=1;
							result=new StringBuffer();
							ans="Please enter +ve number";
						}
						else
						result.append(clk+"("+in.toString()+")");
						in = new StringBuffer(ans);
						display.result.setText(result.toString());
						break;
				case '\u00B1':
				System.out.println("i m in.");
					if(in.length()>1)
					{
						System.out.println("more than 1");
						if(in.charAt(0)=='-')
							in=in.deleteCharAt(0);
						else
							in=in.insert(0,"-");
					}
					else if(in.charAt(0)!='0')
					{	
						System.out.println("equal to 1");
						if(in.charAt(0)=='-')
							in=in.deleteCharAt(0);
						else
							in=in.insert(0,"-");
					}
					op=0;
					break;

				case '=' :	
					e=1;
					if(a.length()!=0 && (int)operation>0)
						{
							if(b.length()==0)
								b=in.toString();
							else
								a=in.toString();

						 	display.result.setText("");
						 	ans=binary(a,operation,b);
						 	in =new StringBuffer(ans);
						}
					result=new StringBuffer();
					dot=0;
					sr=0;
					break;

				case 'C':
						if(clk.length()==1)
						{
							a=new String();
							b=new String();
							in=new StringBuffer("0");
							result=new StringBuffer();
							operation=(char)0;
							display.result.setText("");
						}
						else
						{
							op=1;
							in=new StringBuffer("0");
						}
						dot=0;
						break;

				case 'D':
						if(op!=1)
						{
							if(in.length()>1)
							{
								if(in.charAt(in.length()-1)=='.')
									dot=0;
								in.deleteCharAt(in.length()-1);
							}
							else if(in.length()==1 && in.charAt(0)!='0')
							{
								if(result.length()>0)
									op=1;
								in=new StringBuffer("0");
							}
							else
								Toolkit.getDefaultToolkit().beep();
						}
						else
							Toolkit.getDefaultToolkit().beep();
						break;
				case 'M':
					if(clk.charAt(1)=='C')
						M=0;
					else if(clk.charAt(1)=='R')
					{
						if(M==(long)M)
							in=new StringBuffer(Long.toString((long)M));
						else
						{
							in=new StringBuffer(Double.toString(M));
						}
						op=0;
					}
					else
					{
						e=1;
						M=Double.parseDouble(in.toString());
					}

				default : break;
			}
		}
		else
		{
			if(clk.charAt(0)=='C')
			{
				a=new String();
				b=new String();
				in=new StringBuffer("0");
				operation=(char)0;
				display.result.setText("");
				stop=0;
			}
			else
				Toolkit.getDefaultToolkit().beep();
		}

		return in.toString();
	}
}

class function
{
	 static double z=0.0;
	//private static long z1=0;
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
				return Double.toString(z);
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

		if(x==0)
		{
			Toolkit.getDefaultToolkit().beep();
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

class simple
{
	JFrame f;
	display d1;
	keypad k1;
	simple()
	{
		ImageIcon calicon=new ImageIcon("D:/java/code/gui/calci/calculator.gif");
		//ImageIcon calicon = new ImageIcon("/media/napstor/r!$#@6h/java/code/gui/calci/calculator.gif"); 
		f=new JFrame("Calculator");
		
		f.setIconImage(calicon.getImage());
		Container maincntnr = f.getContentPane();
		maincntnr.setLayout(new BorderLayout());

		d1=new display();
		f.add(d1,BorderLayout.NORTH);

		k1 = new keypad();
		f.add(k1,BorderLayout.CENTER);
		
		f.setBounds(593,258,220,295);
		//f.setSize(220,300);
		//f.pack();
		f.setResizable(false);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	public static void main(String[] args)
	{
		simple a=new simple();
	}
}