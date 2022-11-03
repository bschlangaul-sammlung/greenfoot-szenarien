package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; 

/**
 * Appears after the boss battle
 *
 * @author (Dylan Powell and Sean Eastley)
 * @version (January 21, 2015)
 */
public class Peach extends Actor
{
    public int ySpeed = 2; // determines how fast peach is falling
    private boolean added = false; // determines if the victory object has been added yet

    /**
     * Moves peach down two until she collides with a brick as well as calls the method for a
     * collision with mario
     */
    public void act()
    {
        setLocation(getX(), getY() + ySpeed);
        while (getOneIntersectingObject(LongBrick.class) != null)
        {
            ySpeed = 0;
            setLocation(getX(), getY() - 1);
        }
        checkCollision();
    }

    /**
     * Checks if peach is colliding with mario and if she is, add in the winning object
     */
    public void checkCollision()
    {
        if (getOneIntersectingObject(MarioG.class) != null && added == false)
        {
            added = true;
            Greenfoot.setWorld(new GameWon());
        }
        if (getOneIntersectingObject(Mario.class) != null && added == false)
        {
            added = true;
            Greenfoot.setWorld(new GameWon());
        }
        if (getOneIntersectingObject(MarioS.class) != null && added == false)
        {
            added = true;
            Greenfoot.setWorld(new GameWon());
        }
    }
}
