package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A fireball that will shoot at mario to kill him
 * 
 * @author (Dylan Powell and Sean Eastley) 
 * @version (January 21, 2015)
 */
public class Fireball extends NonJump
{
    private boolean left; //determines whether the fireball should move left or right
    private boolean imminentDeath; //determines whether or not the fireball is about to be removed
    
    /**
     * Defines the left variable for the fireball. Dependent on the creator's hitEdge variavble, aka whether or not the creator is moving left or right
     */
    public Fireball(boolean fLeft)
    {
        left = fLeft;
    }
    
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
        if (left == true)
        {
            move(-7);
        }
        else
        {
            move(7);
        }
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
        if (getOneIntersectingObject (FireFlower.class) != null)
        {
            imminentDeath = true;
        }
        if (imminentDeath == true)
        {
            getWorld().removeObject(this);
        }
    }
}
