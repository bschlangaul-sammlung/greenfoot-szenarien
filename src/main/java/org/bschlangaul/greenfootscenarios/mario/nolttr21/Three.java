import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Three here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Three extends Worlds
{
    /**
     * Act - do whatever the Three wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (isTouching(MapMario.class))
        {
            if (Map.clears > 2) MapMario.up = true;
            else MapMario.up = false;
            MapMario.down = false;
            MapMario.right = false;
            MapMario.left = true;
        }
    }    
}
