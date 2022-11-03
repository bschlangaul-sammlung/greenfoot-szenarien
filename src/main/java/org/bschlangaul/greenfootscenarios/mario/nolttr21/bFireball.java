import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Shoots towards mario to kill him
 * 
 * @author (Dylan Powell and Sean Eastley) 
 * @version (January 21, 2015)
 */
public class bFireball extends NonJump
{
    private boolean imminentDeath; //determines whether or not the fireball is about to be removed
    
    /**
     * This will call the method to move the fireball
     */
    public void act() 
    {
        moveFireball();
    }    
    
    /**
     * This will move the fireball based on the left boolean.
     * It will also destroy the fireball if it runs into a piece of the terrain
     */
    private void moveFireball()
    {
        move(-7);
        if (getOneIntersectingObject(Pipe.class) != null)
        {
            imminentDeath = true;
        }
        if (getOneIntersectingObject(Brick.class) != null)
        {
            imminentDeath = true;
        }
        if (getOneIntersectingObject(Block.class) != null)
        {
            imminentDeath = true;
        }
        if (getOneIntersectingObject(LongBrick.class) != null)
        {
            imminentDeath = true;
        }
        if (getOneIntersectingObject(HorPlatform.class) != null)
        {
            imminentDeath = true;
        }
        if (getOneIntersectingObject(VerPlatform.class) != null)
        {
            imminentDeath = true;
        }
        if (getOneIntersectingObject(Cannon.class) != null)
        {
            imminentDeath = true;
        }
        if (getOneIntersectingObject(Ground.class) != null)
        {
            imminentDeath = true;
        }
        if (imminentDeath == true)
        {
            getWorld().removeObject(this);
        }
    }
} 
