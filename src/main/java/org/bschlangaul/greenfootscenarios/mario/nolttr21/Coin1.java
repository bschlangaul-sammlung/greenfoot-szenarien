import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin1 extends Worlds
{
    /**
     * Act - do whatever the Coin1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (isTouching(MapMario.class))
        {
            MapMario.up = true;
            MapMario.down = true;
            MapMario.right = false;
            MapMario.left = false;
        }
    }    
}
