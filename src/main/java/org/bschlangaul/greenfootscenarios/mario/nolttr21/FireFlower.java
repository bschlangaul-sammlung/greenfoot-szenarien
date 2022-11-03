package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; 

/**
 * An enemy that will shoot at mario
 *
 * @author (Dylan Powell and Sean Eastley)
 * @version (January 21, 2015)
 */
public class FireFlower extends NonJumpable
{
    private int stability; // Defines how many hits the fireflower will take before dying
    private boolean imminentDeath; // Determines whether or not the fireflower is about to die
    private boolean fLeft; // Determines whether the fireflower should shoot left or right
    private int fireDelayCount; // Ticks up to decide when the fireflower should shoot
    private int fireDelayTime; // The time that the delaycount must pass before the fireflower
                               // shoots
    private int scrolled; // This is how far the mainactor has moved on the screen

    /**
     * This will initialize the variables for the fireflower
     */
    public FireFlower()
    {
        stability = 1;
        fireDelayTime = 100;
        imminentDeath = false;
        fireDelayCount = 0;
        fLeft = true;
    }

    /**
     * This will call the appropriate methods to run the fireflower, as well as tick up the
     * delayCount
     */
    public void act()
    {
        fireDelayCount++;
        turnFlower();
        fire();
    }

    /**
     * This method is called by mario's bullet when it collides with the fireflower. It will
     * subtract the bullet's damage from the stability of the fireflower. If the stability is less
     * than or equal to 0, the fireflower will be removed
     */
    public void hit(int damage)
    {
        stability = stability - damage;
        if (stability <= 0)
        {
            getWorld().removeObject(this);
        }
    }

    /**
     * This will turn the fireflower depending on where mario is relative to the fireflower. The
     * larger if statements prevent null pointer exceptions by first checking which mario is in the
     * world
     */
    public void turnFlower()
    {
        if (!getWorld().getObjects(MarioG.class).isEmpty())
        {
            MarioG marioG = (MarioG) getWorld().getObjects(MarioG.class).get(0);
            if (marioG.getXCoord() > getX())
            {
                fLeft = false;
            }
            if (marioG.getXCoord() < getX())
            {
                fLeft = true;
            }
        }
        if (!getWorld().getObjects(Mario.class).isEmpty())
        {
            Mario mario = (Mario) getWorld().getObjects(Mario.class).get(0);
            if (mario.getXCoord() > getX())
            {
                fLeft = false;
            }
            if (mario.getXCoord() < getX())
            {
                fLeft = true;
            }
        }
        if (!getWorld().getObjects(MarioS.class).isEmpty())
        {
            MarioS marioS = (MarioS) getWorld().getObjects(MarioS.class).get(0);
            if (marioS.getXCoord() > getX())
            {
                fLeft = false;
            }
            if (marioS.getXCoord() < getX())
            {
                fLeft = true;
            }
        }
    }

    /**
     * This will shoot a fireball if the fireDelayCount passes the fireDelayTime. It will spawn the
     * fireball at the FireFlower's location
     */
    private void fire()
    {
        if (fLeft == true)
        {
            scrolled = ((SWorld) getWorld()).getUnivX(getX()) - 18;
        }
        if (fLeft == false)
        {
            scrolled = ((SWorld) getWorld()).getUnivX(getX()) + 18;
        }
        int Y = ((SWorld) getWorld()).getUnivY(getY());
        if (fireDelayCount >= fireDelayTime)
        {
            ((SWorld) getWorld()).addObject(new Fireball(fLeft), scrolled, Y, true);
            fireDelayCount = 0;
        }
    }
}
