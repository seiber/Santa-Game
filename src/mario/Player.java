package mario;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Player extends Creature
{

	
	public Player(Handler handler, float x, float y) 
	{
		super(handler,x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
		bounds.x=16;
		bounds.y=32;
		bounds.width=20;
		bounds.height=32;

	
	}


	public void tick()
	{
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput()
	{
		xMove=0;
		yMove=0;
		
		
		if(handler.getKeyManager().up)
		{
			yMove=-speed;
		}
		
		if(handler.getKeyManager().down)
		{
			yMove=speed;
		}
		
		if(handler.getKeyManager().left)
		{
			xMove=-speed;
		}
		if(handler.getKeyManager().right)
		{
			xMove=speed;
		}
	}

	
	public void render(Graphics g) 
	{
		//type casting x,y to ints from orginial protected floats that extended from Entity class.
	
		g.drawImage(Assets.santa1,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()), width, height, null);
		
//		g.setColor(Color.red);
//		g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
//				(int)(y + bounds.y - handler.getGameCamera().getyOffset()),
//				bounds.width,bounds.height);
		
		
	}
	
	

}
