import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends Text
{
    public int gravity = 0;
    public boolean up = false;
    public int bounce = 0;
    public int time;
    public int addY;
    public int addX;
    public int world;
    public Title()
    {
        // Greenfoot.setSpeed(45);
        

    }

    /**
     * Act - do whatever the Black wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        addX = getX() - 350;
        time++;
        if (time == 2)
        {
            Greenfoot.delay(100);
        }
        //time % 2 == 1
        if(true)
        {
            if (!up)
            {
                gravity ++;
                setLocation(getX(),getY() + gravity);
                if (getY() > 100)
                {
                    setLocation(getX(),100);
                    up = true;
                    bounce++;
                }
            }

            if (up && bounce < 3) 
            {
                gravity--;
                gravity--;
                setLocation(getX(),getY() - gravity);
                if (gravity < 0)
                {
                    up = false;

                }
            }
            else
            {

            }
        }

        if(bounce == 3)
        {
            // Greenfoot.setSpeed(65);
            bounce++;
            if(getWorld().getObjects(PressEnter.class).isEmpty()) getWorld().addObject(new PressEnter(),350,250);
        }

        
    }
    
    
    
}
