import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin5 extends Worlds
{
    /**
     * Act - do whatever the Coin5 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (isTouching(MapMario.class))
        {
            MapMario.up = true;
            if (Map.unlocked) MapMario.down = true;
            else MapMario.down = false;
            MapMario.right = false;
            MapMario.left = true;
        }
    }    
}
