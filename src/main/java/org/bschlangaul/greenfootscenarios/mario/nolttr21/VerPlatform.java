import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Moves up and down and can transport mario
 * 
 * @author (Dylan Powell and Sean Eastley) 
 * @version (January 21, 2015)
 */
public class VerPlatform extends Solid
{
    public int verpDelayCount; //ticks up to determine whether or not the platform should turn around
    public int verpTime; //the time that the delay count must pass before the platform turns around
    public boolean verpDown; //determines whether the platform is moving up or down
    
    /**
     * Initializes the values for the vertical platform
     */
    public VerPlatform()
    {
        verpTime = 150;
        verpDown = true;
    }
    
    /**
     * Initializes the values for the vertical platform
     */
    public VerPlatform(int time)
    {
        verpTime = time;
        verpDown = true;
    }
    
    /**
     * Initializes the values for the vertical platform
     */
    public VerPlatform(boolean down)
    {
        verpTime = 150;
        verpDown = down;
    }
    
    /**
     * Initializes the values for the vertical platform
     */
    public VerPlatform(boolean down,int time)
    {
        verpTime = time;
        verpDown = down;
    }
    
    /**
     * Ticks up the delay count for turning the platform and calls the method to move the platform
     */
    public void act() 
    {
        verpDelayCount ++;
        movePlatform();
    }  
    
    /**
     * This will move the platform up or down based on the verpDown boolean
     * If the delay count has reached the delay time, the platform will switch directions
     */
    private void movePlatform()
    {
        if (verpDown == true)
        {
            setLocation(getX(), getY()+1);
        }
        if (verpDown == false)
        {
            setLocation(getX(), getY()-1);
        }
        if (verpDelayCount == verpTime && verpDown == true)
        {
            verpDown = false;
            verpDelayCount = 0;
        }
        if (verpDelayCount == verpTime && verpDown == false)
        {
            verpDown = true;
            verpDelayCount = 0;
        }
    }
}
