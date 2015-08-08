package calci;
//importing GUI packages of java.
import java.awt.*;
import java.awt.event.*;

class click implements ActionListener,MouseListener,KeyListener
{
	String s;
	static calculation c1=new calculation();
	private Color previousColor;
	
	// ActionListener function
	public void actionPerformed(ActionEvent a)
	{
		s=c1.input(a.getActionCommand());
		display.input.setText(s);
	}

	//  MouseListener functions
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

	// KeyListener functions
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
		 				break;
		 		case 115:
		 		case 83:
		 		case 45:
		 				s=c1.input("-");
		 				break;
		 		case 109:
		 		case 77:
		 		case 42:
		 				s=c1.input("*");
		 				break;
		 		case 100:
		 		case 68:
		 		case 47:
		 				s=c1.input("/");
		 				break;
		 		case 112:
		 		case 37:
		 		case 80:
		 				s=c1.input("%");
		 				break;
		 		case 67:
		 		case 99:
		 				s=c1.input("C");
		 				break;
		 		case 127:
		 				s=c1.input("CE");
		 				break;
		 		case 8:
		 				s=c1.input("D");
		 				break;
		 		case 46:
		 				s=c1.input(".");
		 				break;
		 		case 61:
		 		case 10:
		 				s=c1.input("=");
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