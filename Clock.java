import java.io.*;
import java.awt.*;
import java.awt.event.*;

class Draw extends Frame implements WindowListener
{
	Graphics f;
	double htheta=120.0,mtheta=30.0,stheta=90.0;
	double hour,minute=0,second=0;
	static final int ONE_SECOND=1000;
	
	Draw()
	{
		addWindowListener(this);
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.black);
		g.drawOval(100,100,300,300);		
		
		
		//for hour hand
		double ih,jh;
		int xh,yh;
		g.setColor(Color.blue);
		ih=(250+(70*(Math.cos(htheta*0.0174533))));
		jh=(250-(70*(Math.sin(htheta*0.0174533))));
		xh=(int)(Math.round(ih));
		yh=(int)(Math.round(jh));
		g.drawLine(250,250,xh,yh);
		
		
		//for minute hand
		double im,jm;
		int xm,ym;
		g.setColor(Color.red);
		im=(250+(105*(Math.cos(mtheta*0.0174533))));
		jm=(250-(105*(Math.sin(mtheta*0.0174533))));
		xm=(int)(Math.round(im));
		ym=(int)(Math.round(jm));
		g.drawLine(250,250,xm,ym);		
		//to move hour hand by 1 small division every 12 minutes(Total divisions = 60)
		if(minute == 12)
		{
			minute=0;
			htheta-=6;
			
		}
		/*
		//to move hour hand by 5 divisions every 60 minutes.(Total divisions = 60)
		if(minute == 60)
		{
			minute=0;
			htheta-=30;
			
		}
		*/
		
		
		//for second hand
		double is,js;
		int xs,ys;
		g.setColor(Color.black);
		is=(250+(140*(Math.cos(stheta*0.0174533))));
		js=(250-(140*(Math.sin(stheta*0.0174533))));
		xs=(int)(Math.round(is));
		ys=(int)(Math.round(js));
		g.drawLine(250,250,xs,ys);
		try
		{
			Thread.sleep(ONE_SECOND);
		}
		catch(Exception ex){}
		g.setColor(Color.white);
		g.drawLine(250,250,xs,ys);
		stheta-=6;		
		second++;
		if(second == 60)
		{
			second=0;
			minute++;
			mtheta-=6;
			
		}
		
		
		
		repaint();
	}
	
	public void windowClosing(WindowEvent we)
	{
		System.exit(0);
	}
	
	public void windowClosed(WindowEvent we){}
	public void windowOpened(WindowEvent we){}
	public void windowActivated(WindowEvent we){}
	public void windowDeactivated(WindowEvent we){}
	public void windowIconified(WindowEvent we){}
	public void windowDeiconified(WindowEvent we){}
}

class Clock
{
	public static void main(String args[])
	{
		Draw d = new Draw();
		d.setBackground(Color.white);
		d.setTitle("Analog Clock");
		d.setSize(800,550);
		d.setVisible(true);
	}
}
