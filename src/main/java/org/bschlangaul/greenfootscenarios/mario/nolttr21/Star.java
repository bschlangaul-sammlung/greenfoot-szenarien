import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Star here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Star extends Decoration
{
    public int speed =  15;
    public Star()
    {
        turn(Greenfoot.getRandomNumber(360));
    }
    
    
    /**
     * Act - do whatever the Star wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        speed--;
        move(speed);
        if(speed == 0)
        {
            getWorld().removeObject(this);
        }
    }    
}