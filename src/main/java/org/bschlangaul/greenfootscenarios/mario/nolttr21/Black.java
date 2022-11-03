import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Black here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Black extends Decoration
{
    public int gravity = 0;
    public boolean up = false;
    public int bounce = 0;
    public static boolean launch = false;
    public int addY;
    public int addX;
    public int world;
    public Black()
    {
        launch = false;
        Greenfoot.delay(3);

    }

    /**
     * Act - do whatever the Black wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        addX = getX() - 350;
        if (launch)
        {
            if (!up)
            {
                gravity ++;
                setLocation(getX(),getY() + gravity);
                if (getY() > 200)
                {
                    setLocation(getX(),200);
                    up = true;
                    bounce++;
                }
            }

            if (up && bounce < 7) 
            {
                gravity--;
                gravity--;
                setLocation(getX(),getY() - gravity);
                if (gravity < 0)
                {
                    up = false;

                }
            }
            else if (up)  
            {
                if (getWorld() instanceof MyWorld)
                {
                    world = 1;
                    Greenfoot.setWorld(new NextWorld(world));
                }
                if (getWorld() instanceof WorldTwo)
                {
                    world = 2;
                    Greenfoot.setWorld(new NextWorld(world));
                }
                if (getWorld() instanceof WorldThree)
                {
                    world = 3;
                    Greenfoot.setWorld(new NextWorld(world));
                }
                if (getWorld() instanceof Fortress)
                {
                    world = 4;
                    Greenfoot.setWorld(new NextWorld(world));
                }
                else if (getWorld() instanceof SWorld)
                {
                    world = 5;
                    Greenfoot.setWorld(new NextWorld(world));
                }
                else
                {
                    Greenfoot.setWorld(new NextWorld(6));
                }

            }
        }
    }

    public static void launch()
    {
        launch = true;
    }
}
