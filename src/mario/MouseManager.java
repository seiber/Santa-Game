package mario;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener
{

	private boolean leftPressed, rightPressed;
	private int mouseX,mouseY;
	private UIManager uiManager;
	
	public MouseManager()
	{
		
	}
	
	public void setUIManager(UIManager uiManager)
	{
		this.uiManager = uiManager;
	}
	
	public boolean isLeftPressed()
	{
		return leftPressed;
	}
	public boolean isRightPressed()
	{
		return rightPressed;
	}
	
	public int getMouseX()
	{
		return mouseX;
	}
	
	public int getMouseY()
	{
		return mouseY;
	}
	
	public void mouseDragged(MouseEvent e) 
	{
			
	}


	public void mouseMoved(MouseEvent e) 
	{
		mouseX = e.getX();
		mouseY = e.getY();
		if (uiManager !=null)
		{
			uiManager.onMouseMoved(e);
			System.out.println("Mouse moved");
		}
	}

	
	public void mouseClicked(MouseEvent e) 
	{
			
	}

	
	public void mousePressed(MouseEvent e)
	{
		//left mouse button
		if (e.getButton()== MouseEvent.BUTTON1)
		{
			leftPressed = true;
			System.out.println("left press");
		}
		//right mouse button
		else if (e.getButton()==MouseEvent.BUTTON3)
		{
			rightPressed = true;
		}
	}

	
	public void mouseReleased(MouseEvent e)
	{
				//left mouse button
				if (e.getButton()== MouseEvent.BUTTON1)
				{
					leftPressed = false;
				}
				//right mouse button
				else if (e.getButton()==MouseEvent.BUTTON3)
				{
					rightPressed = false;
				}	
				
				if (uiManager !=null)
				{
					uiManager.onMouseRelease(e);
				}
	}


	public void mouseEntered(MouseEvent e) 
	{
		
	}


	public void mouseExited(MouseEvent e) 
	{
		
	}
		
	
	
}
