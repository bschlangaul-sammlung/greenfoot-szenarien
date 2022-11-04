package org.bschlangaul.greenfootscenarios.angry_birds.mz;

import greenfoot.*; 

/**
 * Write a description of class piggy here.
 *
 */
public class piggy extends Dynamic
{
    private boolean CheckHit()
    {
        if (getOneIntersectingObject(Birb.class) == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public void act()
    {
        if (onGround() == true)
        {
            move(1);
        }
        if (CheckHit() == true)
        {
            World myWorld = getWorld();
            getWorld().addObject(new dust_cloud(), getX(), getY());
            Level_s level_s = (Level_s) myWorld;
            Counter counter = level_s.getCounter();
            counter.addScore(50);
            getWorld().removeObject(this);
            Greenfoot.playSound("piglette_destroyed.wav");
        }
    }
}
