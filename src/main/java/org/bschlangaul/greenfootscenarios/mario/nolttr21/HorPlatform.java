import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Moves back and forth and can transport mario.
 * 
 * @author (Dylan Powell and Sean Eastley) 
 * @version (January 21, 2015)
 */
public class HorPlatform extends Solid
{
    public int horpDelayCount; //ticks up to determine whether or not the platform should turn around
    public int horpTime; //the time that the delay count must pass before the platform turns around
    public boolean horpLeft; //this determines whether the platform is moving left or right
    
    /**
     * Initializes the variables for the horizontal platform
     */
    public HorPlatform()
    {
        horpTime = 150;
        horpLeft = false;
    }
    
    /**
     * Ticks up the turn around delay count and the move delay count, as well as calls the method to move the platform
     */
    public void act() 
    {
        horpDelayCount ++;
        movePlatform();
        moveMario();
    }    
    
    /**
     * This will move the platform left or right dependent on the horpLeft boolean and if the move delay count has ticked up to reach the move delay time yet
     * It will also change the direction of the platform when the horp delay count reaches the horp time
     */
    private void movePlatform()
    {
        if (horpLeft == true)
        {
            move(-1);
        }
        if (horpLeft == false)
        {
            move(1);
        }
        if (horpDelayCount == horpTime && horpLeft == true)
        {
            horpLeft = false;
            horpDelayCount = 0;
        }
        if (horpDelayCount == horpTime && horpLeft == false)
        {
            horpLeft = true;
            horpDelayCount = 0;
        }
    }
    
    /**
     * This will move mario around if he is standing on the platform, based on which direction the platform is moving
     */
    private void moveMario()
    {
        setLocation(getX(), getY()-1); //moving up to detect mario
        Actor marioS = getOneIntersectingObject (MarioS.class);
        Actor mario = getOneIntersectingObject (Mario.class);
        Actor marioG = getOneIntersectingObject (MarioG.class);
        setLocation(getX(), getY()+1);
        if (marioS != null)
        {
            if (horpLeft == false)
            {
                marioS.setLocation(marioS.getX()+1, marioS.getY());
            }
            if (horpLeft == true)
            {
                marioS.setLocation(marioS.getX()-1, marioS.getY());
            }
        }
        if (mario != null)
        {
            if (horpLeft == false)
            {
                mario.setLocation(mario.getX()+1, mario.getY());
            }
            if (horpLeft == true)
            {
                mario.setLocation(mario.getX()-1, mario.getY());
            }
        }
        if (marioG != null)
        {
            if (horpLeft == false)
            {
                marioG.setLocation(marioG.getX()+1, marioG.getY());
            }
            if (horpLeft == true)
            {
                marioG.setLocation(marioG.getX()-1, marioG.getY());
            }
        }
    }
    
    /**
     * When called, this will return whether the platform is moving left or right
     */
    public boolean getLeft()
    {
        return horpLeft;
    }
}
