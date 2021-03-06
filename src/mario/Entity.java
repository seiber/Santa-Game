package mario;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public abstract class Entity 
{
	//classes that extend this class can use these variables
	protected float x,y;
	protected int width, height;
	protected Handler handler;
	protected Rectangle bounds;
	protected int health;
	protected boolean active = true;
	public static final int DEFAULT_HEALTH = 10;

	

	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract void die();

	
	public Entity(Handler handler,float x, float y,int width,int height)
	{
		
		this.handler=handler;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		bounds = new Rectangle(0,0,width,height);
		health = DEFAULT_HEALTH;
		
		
	}
	
	
	
	public void hurt(int amt)
	{
		health -= amt;
		//entity dies
		if (health <= 0)
		{
			active = false;
			die();
		}
		
	}
	
	public boolean checkEntityCollisions(float xOffset, float yOffset)
	{
		//looping through all entities, searching for the one that is currently being interacted with
		for (Entity e : handler.getWorld().getEntityManager().getEntities())
				{
		
			//System.out.println(handler.getWorld().getEntityManager().getEntities().get(3));
					if (e.equals(this))
					{
						
						continue;
					}
					if (e.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xOffset,yOffset)))
					{
									//shopkeeper 
							if (e.equals(handler.getWorld().getEntityManager().getEntities().get(3)))
							{
						
								System.out.println("shopkeeper collision and t press");
							}
						
						
						return true;
					}
					
				}
						return false;
	}
	
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset)
	{
		return new Rectangle ((int)(x + bounds.x + xOffset),(int)(y + bounds.y + yOffset) , bounds.width, bounds.height);
	}
	
	public float getX() 
	{
		return x;
	}


	public void setX(float x) 
	{
		this.x = x;
	}


	public float getY()
	{
		return y;
	}


	public void setY(float y)
	{
		this.y = y;
	}


	public int getWidth() 
	{
		return width;
	}


	public void setWidth(int width) 
	{
		this.width = width;
	}


	public int getHeight()
	{
		return height;
	}


	public void setHeight(int height)
	{
		this.height = height;
	}
	
	public int getHealth()
	{
		return health;
	}
	public void setHealth(int health) 
	{
		this.health = health;
	}
	public boolean isActive()
	{
		return active;
	}
	public void setActive(boolean active)
	{
		this.active = active;
	}

	
}
