import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Shot by the cannon to kill mario
 * 
 * @author (Dylan Powell and Sean Eastley) 
 * @version (January 21, 2015)
 */
public class Bullet extends Jump
{
    private boolean imminentDeath = false; //determines if the cannonball is about to die or not
    /**
     * Moves the cannonball and calls the method to remove the cannonball
     */
    public void act() 
    {
        move(-7);
        setRotation(90);
        checkCollisions();
    }    
    
    /**
     * This method will check if the cannonball is colliding with any terrain
     * If it is colliding with terrain, remove the cannonball
     */
    private void checkCollisions()
    {
        if (getOneObjectAtOffset (getImage().getWidth()/2, 0, Block.class)!= null)
        {
            imminentDeath = true;
        }
        if (getOneObjectAtOffset (-getImage().getWidth()/2, 0, Block.class)!= null)
        {
            imminentDeath = true;
        }
        if (getOneObjectAtOffset (getImage().getWidth()/2, 0, Brick.class)!= null)
        {
            imminentDeath = true;
        }
        if (getOneObjectAtOffset (-getImage().getWidth()/2, 0, Brick.class)!= null)
        {
            imminentDeath = true;
        }
        if (getOneObjectAtOffset (getImage().getWidth()/2, 0, HorPlatform.class)!= null)
        {
            imminentDeath = true;
        }
        if (getOneObjectAtOffset (-getImage().getWidth()/2, 0, HorPlatform.class)!= null)
        {
            imminentDeath = true;
        }
        if (getOneObjectAtOffset (getImage().getWidth()/2, 0, VerPlatform.class)!= null)
        {
            imminentDeath = true;
        }
        if (getOneObjectAtOffset (-getImage().getWidth()/2, 0, VerPlatform.class)!= null)
        {
            imminentDeath = true;
        }
        if (getOneObjectAtOffset (getImage().getWidth()/2, 0, LongBrick.class)!= null)
        {
            imminentDeath = true;
        }
        if (getOneObjectAtOffset (-getImage().getWidth()/2, 0, LongBrick.class)!= null)
        {
            imminentDeath = true;
        }
        if (getOneObjectAtOffset (getImage().getWidth()/2, 0, Pipe.class)!= null)
        {
            imminentDeath = true;
        }
        if (getOneObjectAtOffset (-getImage().getWidth()/2, 0, Pipe.class)!= null)
        {
            imminentDeath = true;
        }
        if (imminentDeath == true)
        {
            getWorld().removeObject(this);
        }
    }
}

