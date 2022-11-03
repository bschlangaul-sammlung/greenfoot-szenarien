package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This will shoot cannonballs at mario and is not destroyable
 *
 * @author (Dylan Powell and Sean Eastley)
 * @version (January 21, 2015)
 */
public class Cannon extends Solid
{
    public int cannonDelayCount; // ticks up to delay shooting
    public int cannonDelayTime; // determines how long the cannon has to wait to shoot
    private int scrolled; // determines where to place the cannonball in the world
    GreenfootSound shot = new GreenfootSound("Explosion.wav");
    public int volume;

    /**
     * Initializes the delay time for the cannon
     */
    public Cannon()
    {
        cannonDelayTime = 200;
    }

    /**
     * This will tick up the delay count for the cannon and call the method to add it.
     */
    public void act()
    {
        shot.setVolume(100);
        addCannonball();
        cannonDelayCount++;
    }

    /**
     * Will add a cannonball to the world at the cannon's location as well as play a sound if the
     * delay count is greater than or equal to the delay time.
     */
    public void addCannonball()
    {
        SWorld sWorld = (SWorld) getWorld();
        scrolled = sWorld.getUnivX(getX());
        if (cannonDelayCount >= cannonDelayTime)
        {
            if (getX() < 0)
            {
                shot.setVolume(99);
            }

            if (getX() < -100)
            {
                shot.setVolume(98);
            }

            if (getX() < -200)
            {
                shot.setVolume(97);
            }

            if (getX() < -300)
            {
                shot.setVolume(96);
            }

            if (getX() < -400)
            {
                shot.setVolume(95);
            }

            if (getX() < -500)
            {
                shot.setVolume(90);
            }

            // if (getX() < 0)
            // {
            // shot.setVolume(95);
            // }

            if (getX() > 700)
            {
                shot.setVolume(99);
            }

            if (getX() > 800)
            {
                shot.setVolume(98);
            }

            if (getX() > 900)
            {
                shot.setVolume(97);
            }

            if (getX() > 1000)
            {
                shot.setVolume(96);
            }

            if (getX() > 1100)
            {
                shot.setVolume(95);
            }

            ((SWorld) getWorld()).addObject(new Cannonball(), scrolled, getY() - 10, true);
            cannonDelayCount = 0;
            shot.play();
        }
    }
}
