package org.bschlangaul.greenfootscenarios.space_invaders.jwilshire;

import greenfoot.*;

/**
 * Write a description of class MysteryInvader here.
 */
public class MysteryInvader extends Actor
{
    private int direction;
    private long lastUpdateTime;
    private long waitTime;
    private GreenfootSound mysteryShipSound;

    public MysteryInvader(int _direction)
    {
        super();
        direction = _direction;
        lastUpdateTime = 0L;
        waitTime = 50L;
        mysteryShipSound = new GreenfootSound("mysteryShipSound.wav");
        mysteryShipSound.playLoop();
    }

    /**
     * Act - do whatever the MysteryInvader wants to do. This method is called whenever the 'Act' or
     * 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (!hitByMissle())
        {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastUpdateTime > waitTime)
            {
                setLocation(getX() + direction, getY());
                lastUpdateTime = currentTime;
                removeIfOffScreen();
            }
        }
    }

    public void removeIfOffScreen()
    {
        if ((getX() < 5 && direction < 0) || (getX() > getWorld().getWidth() - 10 && direction > 0))
        {
            mysteryShipSound.stop();
            getWorld().removeObject(this);
        }
    }

    public boolean hitByMissle()
    {
        Actor missle = getOneIntersectingObject(Missle.class);
        if (missle != null)
        {
            getWorldOfType(MyWorld.class).increaseScore(300);
            mysteryShipSound.stop();
            ((Missle) missle).getSourceShip().readyLaser();
            getWorld().removeObject(missle);
            getWorld().removeObject(this);
            return true;
        }
        return false;
    }

    public void stopSound()
    {
        mysteryShipSound.stop();
    }
}
