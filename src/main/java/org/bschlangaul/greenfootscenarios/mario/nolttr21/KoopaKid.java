package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; 

/**
 * An enemy that will shoot shells at mario
 *
 * @author (Dylan Powell and Sean Eastley)
 * @version (January 20, 2015)
 */
public class KoopaKid extends MovingEnemies
{
    private int stability; // Defines how many hits the KoopaKid will take before dying
    private boolean imminentDeath; // Determines whether or not the KoopaKid is about to die
    private int fireDelayCount; // Ticks up to decide when the KoopaKid should shoot a shell
    private int fireDelayTime; // The time that the delaycount must pass before the KoopaKid shoots
                               // a shell
    private int scrolled; // This is how far the main actor has moved on the screen
    private boolean hitEdge; // This defines whether or not the KoopaKid has hit the edge or not
    private int imageChangeDelayCount = 0; // This ticks up to determine when the image switches
    private int imageChangeTime = 8; // This is the number the delay count must pass to switch the
                                     // image
    GreenfootImage imageL = new GreenfootImage("koopaL.png");
    GreenfootImage imageML = new GreenfootImage("koopaML.png");
    GreenfootImage imageR = new GreenfootImage("koopaR.png");
    GreenfootImage imageMR = new GreenfootImage("koopaMR.png");

    /**
     * This will initialize the variables for the KoopaKid
     */
    public KoopaKid()
    {
        stability = 1;
        fireDelayTime = 100;
        imminentDeath = false;
        fireDelayCount = 0;
    }

    /**
     * This will call the appropriate methods to run the KoopaKid, as well as tick up the delayCount
     */
    public void act()
    {
        imageChangeDelayCount++;
        fireDelayCount++;
        if (moveable)
        {
            moveKoopaKid();
            fire();
        }
        switchImage();
    }

    /**
     * This will move the KoopaKid based on whether or not it has hit an object.
     */
    public void moveKoopaKid()
    {
        if (getOneObjectAtOffset(getImage().getWidth() / 2 + 1, 0, Brick.class) != null)
        {
            move(-2);
            hitEdge = true;
        }
        if (getOneObjectAtOffset(-getImage().getWidth() / 2 - 1, 0, Brick.class) != null)
        {
            move(2);
            hitEdge = false;
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
     * This method is called by mario's bullet when it collides with the KoopaKid. It will subtract
     * the bullet's damage from the stability of the KoopaKid. If the stability is less than or
     * equal to 0, the KoopaKid will be removed
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
     * This will animate the koopakid based on which direction it is moving and whether or not the
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
     * KoopaKid will throw a shell if the fireDelayCount passes the fireDelayTime. It will spawn the
     * fireball at the KoopaKid's location
     */
    private void fire()
    {
        scrolled = ((SWorld) getWorld()).getUnivX(getX());
        if (fireDelayCount >= fireDelayTime)
        {
            ((SWorld) getWorld()).addObject(new Shell(hitEdge), scrolled, getY(), true);
            fireDelayCount = 0;
        }
    }
}
