package org.bschlangaul.greenfootscenarios.space_invaders.jwilshire;

import greenfoot.*; 

/**
 * Write a description of class Bomb here.
 *
 */
public class AlienFire extends Actor
{
    private int speed;
    private long lastUpdateTime;
    private long waitTime;

    public AlienFire()
    {
        super();
        speed = 1;
        lastUpdateTime = 0L;
        waitTime = 40L;
    }

    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever the 'Act' or 'Run'
     * button gets pressed in the environment.
     */
    public void act()
    {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastUpdateTime > waitTime)
        {
            setLocation(getX(), getY() + speed);
            if (getY() > getWorld().getHeight() - 5)
            {
                getWorld().removeObject(this);
            }
            lastUpdateTime = currentTime;
        }
    }
}
