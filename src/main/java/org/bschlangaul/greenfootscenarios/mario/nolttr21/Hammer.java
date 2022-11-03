package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Hammer thrown by a hammerbro to kill mario
 *
 * @author (Dylan Powell and Sean Eastley)
 * @version (January 21, 2015)
 */
public class Hammer extends NonJump
{
    public int ySpeed = -20; // Defines how fast the hammer will move in the y direction
    private boolean imminentDeath = false; // Defines whether or not the hammer is about to be
                                           // destroyed
    private boolean left; // Determines whether the hammer should move left or right
    private int degrees = 0; // Determines how far to rotate the hammer
    GreenfootImage imageR = new GreenfootImage("hammerR.png");

    /**
     * Defines the left variable for the hammer. Dependent on the creator's hitEdge variable, aka
     * whether or not the creator is moving left or right
     */
    public Hammer(boolean hitEdge)
    {
        left = hitEdge;
        if (left == false)
        {
            setImage(imageR);
        }
    }

    /**
     * This will tick up the ySpeed counter and call the method to move the hammer
     */
    public void act()
    {
        ySpeed++;
        moveHammer();
        rotateHammer();
    }

    /**
     * This will rotate the hammer an additional 30 degrees
     */
    private void rotateHammer()
    {
        degrees = degrees + 30;
        setRotation(degrees);
    }

    /**
     * This will move the hammer based on if left is true and the ySpeed of the hammer. (The higher
     * the ySpeed is, the faster the hammer will move down) This will also check if the hammer has
     * collided with any terrain and, if it has, remove the hammer
     */
    public void moveHammer()
    {
        if (left == true)
        {
            setLocation(getX() - 3, getY() + ySpeed);
        }
        if (left == false)
        {
            setLocation(getX() + 3, getY() + ySpeed);
        }

        if (getY() > 600)
        {
            getWorld().removeObject(this);
        }
    }
}
