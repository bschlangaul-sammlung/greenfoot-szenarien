import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * turns bowser jr
 * 
 * @author (Dylan Powell and Sean Eastley) 
 * @version (January 21, 2015)
 */
public class turner extends Unneeded
{
    boolean turnable = true;//can we turn bowser jr?
    public int time;
    /**
     * Defines the image for the brick
     */
    public turner()
    {
        GreenfootImage im = getImage();
        im.scale(1,1);
    }
    
    /**
     * If the world is world four or five, the image will be changed to the bricks image.
     */
    public void act() 
    {
        if(isTouching(Bowserjr.class) && turnable)
        {
            // Bowserjr.turn();
            turnable = false;
            time = 10;
        }
        time--;
        if(time == 0)
        {
            turnable = true;
        }
        
    }    
}
