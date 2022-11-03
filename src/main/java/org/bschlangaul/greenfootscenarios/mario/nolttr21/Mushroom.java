package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A powerup that, when collected, will turn small mario into big mario. If mario is already big
 * mario or is mario with a gun, the mushroom will be removed
 *
 * @author (Dylan Powell and Sean Eastley)
 * @version (January 21, 2015)
 */
public class Mushroom extends Powerups
{
    private int ySpeed; // determines how fast the Mushroom is falling
    private boolean terrainLeft = false; // determines if the terrain below mario is moving left or
                                         // right
    private boolean hitEdge = false; // determines if the Mushroom should be moving left or right
    public int spawning = 0;

    /**
     * Calls the methods to move the Mushroom and see if it is colliding with mario.
     */
    public void act()
    {
        if (spawning > 25)
        {
            moveMushroom();
            checkHit();
        }
        else
        {
            setLocation(getX(), getY() - 1);
            spawning++;
        }



    }

    /**
     * Do something if the Mushroom Collides with mario, dependent on which type of mario is in the
     * world. If the Mushroom collides with marioG, remove the mushroom If the Mushroom collides
     * with mario, remove the mushroom If the Mushroom collides with marioS, call a method that will
     * turn marioS into mario
     */
    private void checkHit()
    {
        MarioG g = (MarioG) getOneIntersectingObject(MarioG.class);
        Mario m = (Mario) getOneIntersectingObject(Mario.class);
        MarioS s = (MarioS) getOneIntersectingObject(MarioS.class);
        if (g != null)
        {
            getWorld().removeObject(this);
        }
        if (m != null)
        {
            getWorld().removeObject(this);
        }
        if (s != null)
        {
            s.grow();
            getWorld().removeObject(this);
        }
    }

    /**
     * This method will move the Mushroom. If there is a block to the right of the Mushroom, it will
     * move left until it hits another object. If there is a block to the left of the Mushroom, it
     * will move left until it hits another object. If there is no object below the Mushroom, it
     * will fall until there is an object underneath the Mushroom.
     */
    public void moveMushroom()
    {
        ySpeed++;
        setLocation(getX(), getY() + ySpeed / 2);
        while (getOneObjectAtOffset(0, getImage().getHeight() / 2 - 2, Ground.class) != null)
        {
            setLocation(getX(), getY() - 1);
            ySpeed = 0;
        }
        while (getOneObjectAtOffset(0, getImage().getHeight() / 2 - 2, Brick.class) != null)
        {
            setLocation(getX(), getY() - 1);
            ySpeed = 0;
        }
        while (getOneObjectAtOffset(0, getImage().getHeight() / 2 - 2, LongBrick.class) != null)
        {
            setLocation(getX(), getY() - 1);
            ySpeed = 0;
        }
        while (getOneObjectAtOffset(0, getImage().getHeight() / 2 - 2, Block.class) != null)
        {
            setLocation(getX(), getY() - 1);
            ySpeed = 0;
        }
        while (getOneObjectAtOffset(0, getImage().getHeight() / 2 - 2, VerPlatform.class) != null)
        {
            setLocation(getX(), getY() - 1);
            ySpeed = 0;
        }
        while (getOneObjectAtOffset(0, getImage().getHeight() / 2 - 2, HorPlatform.class) != null)
        {
            setLocation(getX(), getY() - 1);
            ySpeed = 0;
            terrainLeft = ((HorPlatform) getOneIntersectingObject(HorPlatform.class)).getLeft();
            if (terrainLeft == true)
            {
                move(-2);
            }
            if (terrainLeft == false)
            {
                move(2);
            }
        }
        while (getOneObjectAtOffset(getImage().getWidth() / 2 + 1, 0, Block.class) != null)
        {
            move(-3);
            hitEdge = true;
        }
        while (getOneObjectAtOffset(-getImage().getWidth() / 2 - 1, 0, Block.class) != null)
        {
            move(3);
            hitEdge = false;
        }
        while (getOneObjectAtOffset(getImage().getWidth() / 2 + 1, 0, Brick.class) != null)
        {
            move(-3);
            hitEdge = true;
        }
        while (getOneObjectAtOffset(-getImage().getWidth() / 2 - 1, 0, Brick.class) != null)
        {
            move(3);
            hitEdge = false;
        }
        while (getOneObjectAtOffset(getImage().getWidth() / 2 + 1, 0, HorPlatform.class) != null)
        {
            move(-3);
            hitEdge = true;
        }
        while (getOneObjectAtOffset(-getImage().getWidth() / 2 - 1, 0, HorPlatform.class) != null)
        {
            move(3);
            hitEdge = false;
        }
        while (getOneObjectAtOffset(getImage().getWidth() / 2 + 1, 0, VerPlatform.class) != null)
        {
            move(-3);
            hitEdge = true;
        }
        while (getOneObjectAtOffset(-getImage().getWidth() / 2 - 1, 0, VerPlatform.class) != null)
        {
            move(3);
            hitEdge = false;
        }
        while (getOneObjectAtOffset(getImage().getWidth() / 2 + 1, 0, LongBrick.class) != null)
        {
            move(-3);
            hitEdge = true;
        }
        while (getOneObjectAtOffset(-getImage().getWidth() / 2 - 1, 0, LongBrick.class) != null)
        {
            move(3);
            hitEdge = false;
        }
        if (hitEdge == false)
        {
            move(3);
        }
        else if (hitEdge == true)
        {
            move(-3);
        }
    }
}
