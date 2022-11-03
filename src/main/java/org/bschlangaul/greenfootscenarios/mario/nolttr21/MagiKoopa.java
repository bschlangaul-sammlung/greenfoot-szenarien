package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * An enemy that will shoot at mario
 *
 * @author (Dylan Powell and Sean Eastley)
 * @version (January 20, 2015)
 */
public class MagiKoopa extends MovingEnemies
{
    private int stability; // Defines how many hits the MagiKoopa will take before dying
    private boolean imminentDeath; // Determines whether or not the MagiKoopa is about to die
    private int fireDelayCount; // Ticks up to decide when the MagiKoopa should shoot
    private int fireDelayTime; // The time that the delaycount must pass before the MagiKoopa shoots
    private int scrolled; // This is how far the main actor has moved on the screen
    private boolean hitEdge; // This defines whether or not the MagiKoopa has hit the edge or not
    GreenfootImage imageL = new GreenfootImage("MagikoopaL.png");
    GreenfootImage imageR = new GreenfootImage("MagikoopaR.png");

    /**
     * This will initialize the variables for the MagiKoopa
     */
    public MagiKoopa()
    {
        stability = 1;
        fireDelayTime = 100;
        imminentDeath = false;
        fireDelayCount = 0;
    }

    /**
     * This will call the appropriate methods to run the MagiKoopa, as well as tick up the
     * delayCount
     */
    public void act()
    {
        if (moveable)
        {
            fireDelayCount++;
            moveMagiKoopa();
            fire();
        }
    }

    /**
     * This will move the MagiKoopa based on whether or not it has hit an object and switch the
     * image according to which direction it is moving
     */
    public void moveMagiKoopa()
    {
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
        if (getOneObjectAtOffset(getImage().getWidth() / 2 + 1, 0, LongBrick.class) != null)
        {
            move(-2);
            hitEdge = true;
            setImage(imageL);
        }
        if (getOneObjectAtOffset(-getImage().getWidth() / 2 - 1, 0, LongBrick.class) != null)
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
     * This method is called by mario's bullet when it collides with the MagiKoopa. It will subtract
     * the bullet's damage from the stability of the MagiKoopa. If the stability is less than or
     * equal to 0, the MagiKoopa will be removed
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
     * This will shoot a fireball if the fireDelayCount passes the fireDelayTime. It will spawn the
     * fireball at the MagiKoopa's location
     */
    private void fire()
    {
        scrolled = ((SWorld) getWorld()).getUnivX(getX());
        int y = ((SWorld) getWorld()).getUnivY(getY());
        if (fireDelayCount >= fireDelayTime)
        {
            ((SWorld) getWorld()).addObject(new mFireball(hitEdge), scrolled, y, true);
            fireDelayCount = 0;
        }
    }
}
