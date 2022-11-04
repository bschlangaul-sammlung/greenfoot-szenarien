package org.bschlangaul.greenfootscenarios.angry_birds.mz;

import greenfoot.*; 

/**
 * Write a description of class Ball here.
 *
 */
public class Birb extends Dynamic
{
    int life = 200;

    public Birb(double accX, double accY)
    {
        setMass(5);
        setElast(1.35);
        setVerticalSpeed(accY);
        setHorizontalSpeed(accX);
        setBlockingClasses(new Class[] {Walls.class});
    }

    public void act()
    {
        World myWorld = getWorld();
        Level_s level_s = (Level_s) myWorld;
        Counter birdsCount = level_s.getBirdsCount();
        doGravity();
        if (life > 0)
        {
            --life;
        }
        else
        {
            getWorld().addObject(new dust_cloud(), getX(), getY());
            Greenfoot.playSound("bird_destroyed.wav");
            getWorld().removeObject(this);
        }
    }
}
