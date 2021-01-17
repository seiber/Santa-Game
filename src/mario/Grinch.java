package mario;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Grinch extends Creature
{
//	Rectangle boundingBox1 = new Rectangle();
//	Rectangle boundingBox2 = new Rectangle();
//	Rectangle boundingBox3 = new Rectangle();
//	Rectangle boundingBox4 = new Rectangle();

		
	EnemyWanderBounds e1,e2,e3,e4;
	Rectangle grinch = new Rectangle();
	
	

	public Grinch(Handler handler, float x, float y) 
	{
		super(handler, x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
		
		
		e1 = new EnemyWanderBounds(handler,x,y,width,height);
		
		e2 = new EnemyWanderBounds(handler,400,400,width,height);
		//e3= new EnemyWanderBounds(handler, 700, 500, 200, 200);
		
		//creating grinch collision bounds
		bounds.x=16;
		bounds.y=32;
		bounds.width=20;
		bounds.height=32;
	}
	
	
	
	public void tick()
	{
		
			checkBounds();

	}
	
	
//	public void createBounds()
//	{
//		//bounding box where grinch can wander
//		boundingBox1.setBounds(400,500,70,70);
//		boundingBox2.setBounds(650,500,70,70);
//		boundingBox3.setBounds(400,430,400,70);
//		boundingBox4.setBounds(430,500,270,70);
//				
//		//our grinch character basically has an invisible rectangle surrounding him
//		grinch.setBounds((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),width,height);
//	}
	
	//checking the bounds to make sure grinch is in the correct location
	public void checkBounds()
	{	
		grinch.setBounds((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),width,height);
		e1.createBounds(400,500,70,70);
		e2.createBounds(400,400,70,70);
		//e2.createBounds((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),470,500);
		
		// if the bonding box area and grinch intersect, grinch is in the proper wandering space
		
		if (e1.boundingBox1.contains(grinch))
		{	//wander
			y-=65;
			System.out.println("bbox1");
		}
		
		else if (e2.boundingBox1.contains(grinch))
		{
			y+=65;
			System.out.println("bbox2");
		}
//		else if (e1.boundingBox3.contains(grinch))
//		{
//			x--;
//			System.out.println("bbox3");
//		}
//		
//		else if (e1.boundingBox4.contains(grinch))
//		{
//			System.out.println("bbox4");
//			x++;
//		}
//		else
//		{
//			moveToBoundingBox();
//		}
	}
	
	


	public void render(Graphics g)
	{
		
		//grinch
		g.drawImage(Assets.grinch, (int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),width,height, null);
		//grinch rectangle
		g.drawRect((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height);
		e1.render(g);
		e2.render(g);
		
//		//start box 1
//		g.drawRect(400,500,70,70);
//		//g.drawRect((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),300,400);
//		//end box 2
//		g.drawRect(650,500,70,70);
//		//box3
//		g.drawRect(400,430,400,70);
//		//box4
//		g.drawRect(430,500,270,70);
		
		
	}



	
	public void die() 
	{
			System.err.println("Grinch down");
			handler.getWorld().getItemManager().addItem(Item.santaHat.createNew((int)x,(int)y));	
	}


	
}
