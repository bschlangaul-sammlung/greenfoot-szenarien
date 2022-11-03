import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Luigi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Luigi extends Text
{
    public static String characterName;
    public Luigi()
    {
        setImage(new GreenfootImage(characterName, 40, Color.GREEN,new Color(0,0,0,0)));
    }

    /**
     * Act - do whatever the Luigi wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (getX() < 300)
        {
            setLocation(getX() + 20,getY());
        }
        else if (getWorld().getObjects(HasPassed.class).isEmpty())
        {
            getWorld().addObject(new HasPassed(), 0, 150);
        }

    }    
}