package calci;
import java.awt.*;

class calculation extends function
{
	StringBuffer in=new StringBuffer("0");
	StringBuffer result = new StringBuffer("");
	byte flag=0;
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
			if((flag>>0 & 1)==1 || (flag>>1 & 1)==1 || (flag>>3 & 1)==1)
			{
				in=new StringBuffer("0");

				if((flag>>3 & 1)==1)
				{
					result = new StringBuffer("");
					display.result.setText("");
				}
				flag = (byte)(flag & 4);
			}
			if (in.length()>=16)
			{	
				if(in.charAt(0)=='-' && in.length()<17)
					in.append(clk);
				else
					Toolkit.getDefaultToolkit().beep();	
			}
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
					if((flag>>2 & 1)==1)
						Toolkit.getDefaultToolkit().beep();
					else 
					{
						if((flag>>0 & 1)==1 || (flag>>1 & 1)==1)
						{
							in=new StringBuffer("0");
							flag = (byte)(flag & 12);
						}
						in.append(clk);
						flag = (byte) (flag | 4); 
					}
						break;

				case '+':
				case '-':
				case '*':
				case '/':
				case '%' :
					if(result.length()==0 )
						{
							flag = (byte)(flag|1);
							a=in.toString();
							operation = clk.charAt(0);

							result=result.append(" "+a+" "+clk);
							display.result.setText(result.toString());
							b=new String();
						}
					else if((flag>>0 & 1)==0)
					{
						if((flag>>0 & 1)==0)
						if(((flag>>3)&1)==1 && a.length()==0)
						{
							a=in.toString();
							result = result.append(" "+clk);
							if(result.length()>31)
								result=result.replace(0,result.length()-31,"<< ");

							display.result.setText(result.toString());
							flag = (byte)(flag & 7);
							operation = clk.charAt(0);
						}
						else
						{
							b=in.toString();
							
							if((flag>>3 & 1)==0)
							result=result.append(" "+b+" "+clk);
							else
								result=result.append(" "+clk);
							
							if(result.length()>31)
								result=result.replace(0,result.length()-31,"<< ");

							display.result.setText(result.toString());
							System.out.println(a+" a "+operation+" b "+b);
							ans=binary(a,operation,b);
							operation = clk.charAt(0);
							in =new StringBuffer(ans);
							a=in.toString();
							b=new String();
							flag = (byte)(flag & 7);
						}

						flag = (byte)(flag | 1);
					}
					else
					{
						operation = clk.charAt(0);
						if(result.charAt(result.length()-1)!=')')
							result.deleteCharAt(result.length()-1);

						result.append(clk);
						display.result.setText(result.toString());
					}
					if(result.length()>31)
						result=result.replace(0,result.length()-31,"<< ");

						flag = (byte)(flag & 11);
						break;
				
				case '1' :
						ans = unary(in.toString(),clk.charAt(0));
						in = new StringBuffer(ans);
						flag = (byte)(flag & 11);
						flag = (byte)(flag | 2);
						break;

				case '\u221A' :
						if((flag>>3 & 1)==1)
						{
							int z=result.length();
							while(result.charAt(--z)!='\u221A');
							System.out.println(z);
							result.delete(z,result.length());
						}
						ans=unary(in.toString(),clk.charAt(0));
						flag = (byte)(flag & 14);
						flag = (byte)(flag | 8);
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
					if(in.length()>1)
					{
						if(in.charAt(0)=='-')
							in=in.deleteCharAt(0);
						else
							in=in.insert(0,"-");
					}
					else if(in.charAt(0)!='0')
					{	
						if(in.charAt(0)=='-')
							in=in.deleteCharAt(0);
						else
							in=in.insert(0,"-");
					}
					flag = (byte)(flag & 14);
					break;

				case '=' :	
					flag = (byte)(flag | 2);
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
					flag = (byte)(flag & 3);
					break;

				case 'C':
						if(clk.length()==1)
						{
							a=new String();
							b=new String();
							in=new StringBuffer("0");
							result=new StringBuffer("");
							operation=(char)0;
							display.result.setText("");
						}
						else
						{
							flag = (byte)(flag | 1);
							in=new StringBuffer("0");
						}
						flag = (byte)(flag & 11);
						break;

				case 'D':
						if((flag & 1)==0)
						{
							if(in.length()>1)
							{
								if(in.charAt(in.length()-1)=='.')
									flag = (byte)(flag & 11);
								in.deleteCharAt(in.length()-1);
							}
							else if(in.length()==1 && in.charAt(0)!='0')
							{
								if(result.length()>0)
									flag = (byte)(flag | 1);

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
						flag = (byte)(flag & 14);
					}
					else
					{
						flag = (byte)(flag | 2);
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