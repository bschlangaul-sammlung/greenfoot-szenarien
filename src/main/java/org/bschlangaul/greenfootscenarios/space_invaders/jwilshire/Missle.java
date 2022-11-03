package org.bschlangaul.greenfootscenarios.space_invaders.jwilshire;

import greenfoot.*; 

/**
 * Write a description of class Missle here.
 *
 */
public class Missle extends Actor
{
    private Ship sourceShip;

    public Missle(Ship ship)
    {
        super();
        sourceShip = ship;
        new GreenfootSound("laserSound.wav").play();
    }

    /**
     * Act - do whatever the Missle wants to do. This method is called whenever the 'Act' or 'Run'
     * button gets pressed in the environment.
     */
    public void act()
    {
        flyUp();// Add your action code here.
        boolean onEdge = removeIfOnEdge();
        if (!onEdge)
        {
            checkForAlienFireCollision();
        }
    }

    public void checkForAlienFireCollision()
    {
        Actor invaderFire = getOneIntersectingObject(AlienFire.class);
        if (invaderFire != null)
        {
            sourceShip.readyLaser();
            getWorld().removeObject(invaderFire);
            getWorld().removeObject(this);
        }
    }

    public boolean removeIfOnEdge()
    {
        if (isAtEdge())
        {
            sourceShip.readyLaser();
            getWorld().removeObject(this);
            return true;
        }
        return false;
    }

    public void flyUp()
    {
        setLocation(getX(), getY() - 1);
    }

    public Ship getSourceShip()
    {
        return sourceShip;
    }
}
