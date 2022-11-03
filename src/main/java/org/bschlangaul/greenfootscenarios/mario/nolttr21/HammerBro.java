package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An enemy that will throw hammers at mario
 *
 * @author (Dylan Powell and Sean Eastley)
 * @version (January 20, 2015)
 */
public class HammerBro extends MovingEnemies
{
    private int stability; // Defines how many hits the HammerBro will take before dying
    private boolean imminentDeath; // Determines whether or not the HammerBro is about to die
    private int fireDelayCount; // Ticks up to decide when the HammerBro should throw a hammer
    private int fireDelayTime; // The time that the delaycount must pass before the HammerBro throws
                               // a hammer
    private int scrolled; // This is how far the main actor has moved on the screen
    private boolean hitEdge; // This defines whether or not the HammerBro has hit the edge or not
    private int imageChangeDelayCount = 0; // This ticks up to determine when the image switches
    private int imageChangeTime = 5; // This is the number the delay count must pass to switch the
                                     // image
    GreenfootImage imageL = new GreenfootImage("hammerbroL.png");
    GreenfootImage imageML = new GreenfootImage("hammerbroML.png");
    GreenfootImage imageR = new GreenfootImage("hammerbroR.png");
    GreenfootImage imageMR = new GreenfootImage("hammerbroMR.png");
    public int numFires = Greenfoot.getRandomNumber(3) + 4;

    /**
     * This will initialize the variables for the HammerBro
     */
    public HammerBro()
    {
        stability = 1;
        fireDelayTime = 20;
        imminentDeath = false;
        fireDelayCount = 0;
    }

    /**
     * This will call the appropriate methods to run the HammerBro, as well as tick up the
     * delayCount for firing and switching the image
     */
    public void act()
    {
        imageChangeDelayCount++;
        fireDelayCount++;
        if (moveable)
        {
            if (numFires == 0)
                moveHammerBro();
            fire();
        }

    }

    /**
     * This will move the HammerBro based on whether or not it has hit an object.
     */
    public void moveHammerBro()
    {
        switchImage();

        if (getOneObjectAtOffset(getImage().getWidth() / 2 + 1, 0, Brick.class) != null)
        {
            move(-2);
            hitEdge = true;
            setImage(imageL);
        }
        if (getOneObjectAtOffset(-getImage().getWidth() / 2 - 1, 0, Brick.class) != null)
        {
            move(2);
            hitEdge = false;
            setImage(imageR);
        }
        if (hitEdge == false)
        {
            move(2);
        }
        else if (hitEdge == true)
        {
            move(-2);
        }
    }

    /**
     * This will animate the hammerbro based on which direction it is moving and whether or not the
     * imageChangeDelayCount has reached the imageChangeTime
     */
    public void switchImage()
    {
        if (hitEdge == true && imageChangeDelayCount >= imageChangeTime)
        {
            if (getImage() == imageL)
            {
                setImage(imageML);
                imageChangeDelayCount = 0;
            }
            else
            {
                setImage(imageL);
                imageChangeDelayCount = 0;
            }
        }
        if (hitEdge == false && imageChangeDelayCount >= imageChangeTime)
        {
            if (getImage() == imageR)
            {
                setImage(imageMR);
                imageChangeDelayCount = 0;
            }
            else
            {
                setImage(imageR);
                imageChangeDelayCount = 0;
            }
        }
    }

    /**
     * This method is called by mario's bullet when it collides with the HammerBro. It will subtract
     * the bullet's damage from the stability of the HammerBro. If the stability is less than or
     * equal to 0, the HammerBro will be removed
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
     * HammerBro will throw a hammer if the fireDelayCount passes the fireDelayTime. It will spawn
     * the fireball at the HammerBro's location
     */
    private void fire()
    {
        scrolled = ((SWorld) getWorld()).getUnivX(getX());
        if (numFires == 0 && Greenfoot.getRandomNumber(100) == 1)
        {
            numFires = Greenfoot.getRandomNumber(3) + 4;
        }
        if (fireDelayCount >= fireDelayTime && numFires > 0)
        {
            ((SWorld) getWorld()).addObject(new Hammer(hitEdge), scrolled, getY(), true);
            fireDelayCount = 0;
            numFires--;
        }
    }
}
