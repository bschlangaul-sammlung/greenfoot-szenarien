package org.bschlangaul.greenfootscenarios.space_invaders.jwilshire;

import greenfoot.*; 

/**
 * Write a description of class ShieldPart here.
 *
 */
public class ShieldPart extends Actor
{
    private int hits;

    public ShieldPart()
    {
        super();
        hits = 0;
    }

    /**
     * Act - do whatever the ShieldPart wants to do. This method is called whenever the 'Act' or
     * 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        Actor missle = getOneIntersectingObject(Missle.class);
        Actor alienFire = getOneIntersectingObject(AlienFire.class);
        Actor alienShip = getOneIntersectingObject(Alien.class);
        if (missle != null || alienFire != null)
        {
            if (hits > 0)
            {
                if (missle != null)
                {
                    ((Missle) missle).getSourceShip().readyLaser();
                    getWorld().removeObject(missle);
                }
                else
                {
                    setImage("shieldPart1.png");
                    getWorld().removeObject(alienFire);
                }
                getWorld().removeObject(this);
            }
            else
            {
                if (missle != null)
                {
                    setImage("shieldPart2.png");
                    ((Missle) missle).getSourceShip().readyLaser();
                    getWorld().removeObject(missle);
                }
                else
                {
                    setImage("shieldPart1.png");
                    getWorld().removeObject(alienFire);
                }
                hits++;
            }
        }
        else if (alienShip != null)
        {
            getWorld().removeObject(this);
        }

    }
}
