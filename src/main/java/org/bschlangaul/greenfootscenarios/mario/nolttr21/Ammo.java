package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A powerup that, when collected, will turn big mario into marioG and add ammo to the counter. If
 * mario is already marioG or is small mario, it will add ammo to the counter.
 *
 * @author (Dylan Powell and Sean Eastley)
 * @version (January 21, 2015)
 */
public class Ammo extends Powerups
{
    private int ySpeed; // determines how fast the ammo is falling
    private boolean terrainLeft = false; // determines if the terrain below mario is moving left or
                                         // right
    private boolean hitEdge = false; // determines if the ammo should be moving left or right
    GreenfootSound collected = new GreenfootSound("Reload.wav");
    public int spawning = 0;

    /**
     * Calls the methods to move the ammo and see if it is colliding with mario.
     */
    public void act()
    {
        if (spawning > 25)
        {
            moveAmmo();
            checkHit();
        }
        else
        {
            setLocation(getX(), getY() - 1);
            spawning++;
        }
    }

    /**
     * Do something if the ammo Collides with mario, dependent on which type of mario is in the
     * world. If the ammo collides with marioG, add ammunition and play a noise. If the ammo
     * collides with mario, call a method in mario that will turn him into marioG. If the ammo
     * collides with marioS, add ammunition and play a noise.
     */
    private void checkHit()
    {
        MarioG g = (MarioG) getOneIntersectingObject(MarioG.class);
        Mario m = (Mario) getOneIntersectingObject(Mario.class);
        MarioS s = (MarioS) getOneIntersectingObject(MarioS.class);
        if (g != null)
        {
            collected.play();
            g.addAmmo();
            getWorld().removeObject(this);
        }
        if (m != null)
        {
            m.grow();
            getWorld().removeObject(this);
        }
        if (s != null)
        {
            s.grow2();
            getWorld().removeObject(this);
        }
    }

    /**
     * This method will move the ammo. If there is a block to the right of the ammo, it will move
     * left until it hits another object. If there is a block to the left of the ammo, it will move
     * left until it hits another object. If there is no object below the ammo, it will fall until
     * there is an object underneath the ammo.
     */
    public void moveAmmo()
    {
        ySpeed++;
        setLocation(getX(), getY() + ySpeed / 2);
        if (getX() < 20)
        {
            hitEdge = false;
            move(5);
        }
        if (getX() > ((SWorld) getWorld()).getScrollingWidth())
        {
            hitEdge = true;
            move(-5);
        }
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
            move(-1);
            hitEdge = true;
        }
        while (getOneObjectAtOffset(-getImage().getWidth() / 2 - 1, 0, Block.class) != null)
        {
            move(1);
            hitEdge = false;
        }
        while (getOneObjectAtOffset(getImage().getWidth() / 2 + 1, 0, Brick.class) != null)
        {
            move(-1);
            hitEdge = true;
        }
        while (getOneObjectAtOffset(-getImage().getWidth() / 2 - 1, 0, Brick.class) != null)
        {
            move(1);
            hitEdge = false;
        }
        while (getOneObjectAtOffset(getImage().getWidth() / 2 + 1, 0, HorPlatform.class) != null)
        {
            move(-1);
            hitEdge = true;
        }
        while (getOneObjectAtOffset(-getImage().getWidth() / 2 - 1, 0, HorPlatform.class) != null)
        {
            move(1);
            hitEdge = false;
        }
        while (getOneObjectAtOffset(getImage().getWidth() / 2 + 1, 0, VerPlatform.class) != null)
        {
            move(-1);
            hitEdge = true;
        }
        while (getOneObjectAtOffset(-getImage().getWidth() / 2 - 1, 0, VerPlatform.class) != null)
        {
            move(1);
            hitEdge = false;
        }
        while (getOneObjectAtOffset(getImage().getWidth() / 2 + 1, 0, LongBrick.class) != null)
        {
            move(-1);
            hitEdge = true;
        }
        while (getOneObjectAtOffset(-getImage().getWidth() / 2 - 1, 0, LongBrick.class) != null)
        {
            move(1);
            hitEdge = false;
        }
        // if (hitEdge == false)
        // {
        // move(1);
        // }
        // else if (hitEdge == true)
        // {
        // move(-1);
        // }
    }
}
