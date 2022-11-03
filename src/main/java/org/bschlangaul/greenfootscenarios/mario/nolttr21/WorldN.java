import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldN here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldN extends Text
{
    public static int world;
    public int time = 200;
    public WorldN()
    {
        
    }

    /**
     * Act - do whatever the WorldN wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (world == 1)
        {
            setImage(new GreenfootImage("1-1", 90, Color.GREEN,new Color(0,0,0,0)));
        }
        else if (world == 2)
        {
            setImage(new GreenfootImage("1-2", 90, Color.GREEN,new Color(0,0,0,0)));
        }
        else if (world == 3)
        {
            setImage(new GreenfootImage("1-3", 90, Color.GREEN,new Color(0,0,0,0)));
        }
        else if (world == 4)
        {
            setImage(new GreenfootImage("1-4", 90, Color.GREEN,new Color(0,0,0,0)));
        }
        if(getX() > 420)
        {
            setLocation(getX() - 10,getY());
        }
        else if (getWorld().getObjects(StatT.class).isEmpty())
        {
            getWorld().addObject(new StatT(),350,400);
        }
        
        time--;
        if (time == 0)
        {
            switch( world)//my first switch statement!
            {
                case 1: Greenfoot.setWorld(new Map(1,1,true));break;
                case 2: Greenfoot.setWorld(new Map(2,2,true));break;
                case 3: Greenfoot.setWorld(new Map(4,4,true));break;
                case 4: Greenfoot.setWorld(new Map(5,5,true));break;
                
                
            }
            
        }
    }    
}
