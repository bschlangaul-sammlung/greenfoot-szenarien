package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; 


/**
 * Shot by the cannon to kill mario
 *
 * @author (Dylan Powell and Sean Eastley)
 * @version (January 21, 2015)
 */
public class Cannonball extends Jump
{
    private boolean imminentDeath = false; // determines if the cannonball is about to die or not


    /**
     * Moves the cannonball and calls the method to remove the cannonball
     */
    public void act()
    {
        move(-7);
        checkCollisions();
    }

    /**
     * This method will check if the cannonball is colliding with any terrain If it is colliding
     * with terrain, remove the cannonball
     */
    private void checkCollisions()
    {
        if (getOneObjectAtOffset(getImage().getWidth() / 2, 0, Block.class) != null)
        {
            imminentDeath = true;
        }
        if (getOneObjectAtOffset(-getImage().getWidth() / 2, 0, Block.class) != null)
        {
            imminentDeath = true;
        }
        if (getOneObjectAtOffset(getImage().getWidth() / 2, 0, Brick.class) != null)
        {
            imminentDeath = true;
        }
        if (getOneObjectAtOffset(-getImage().getWidth() / 2, 0, Brick.class) != null)
        {
            imminentDeath = true;
        }
        if (getOneObjectAtOffset(getImage().getWidth() / 2, 0, HorPlatform.class) != null)
        {
            imminentDeath = true;
        }
        if (getOneObjectAtOffset(-getImage().getWidth() / 2, 0, HorPlatform.class) != null)
        {
            imminentDeath = true;
        }
        if (getOneObjectAtOffset(getImage().getWidth() / 2, 0, VerPlatform.class) != null)
        {
            imminentDeath = true;
        }
        if (getOneObjectAtOffset(-getImage().getWidth() / 2, 0, VerPlatform.class) != null)
        {
            imminentDeath = true;
        }
        if (getOneObjectAtOffset(getImage().getWidth() / 2, 0, LongBrick.class) != null)
        {
            imminentDeath = true;
        }
        if (getOneObjectAtOffset(-getImage().getWidth() / 2, 0, LongBrick.class) != null)
        {
            imminentDeath = true;
        }
        if (getOneObjectAtOffset(getImage().getWidth() / 2, 0, Pipe.class) != null)
        {
            imminentDeath = true;
        }
        if (getOneObjectAtOffset(-getImage().getWidth() / 2, 0, Pipe.class) != null)
        {
            imminentDeath = true;
        }
        if (imminentDeath == true)
        {
            getWorld().removeObject(this);
        }
    }
}

