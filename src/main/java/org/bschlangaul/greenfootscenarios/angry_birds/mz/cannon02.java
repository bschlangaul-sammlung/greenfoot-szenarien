package org.bschlangaul.greenfootscenarios.angry_birds.mz;

import greenfoot.*; 

/**
 * Write a description of class part02_movable here.
 *
 */
public class cannon02 extends Cannon
{
    double accY = 0.0;
    double rad = 30.0;
    double accX = rad;
    int shootDelay = 0;
    int shots;

    public cannon02(int shots_cannon)
    {
        shots = shots_cannon;
    }

    public void act()
    {
        World myWorld = getWorld();
        Level_s level_s = (Level_s) myWorld;
        Counter birdsCount = level_s.getBirdsCount();
        if ((Greenfoot.isKeyDown("Space")) && (shootDelay == 0) && (birdsCount.score != shots))
        {
            getWorld().addObject(new bird_gray(), 40 * (birdsCount.score + 1), 40);
            getWorld().addObject(new Birb(accX, accY), getX(), getY() - 20);
            Greenfoot.playSound("bird_01_flying.wav");
            Greenfoot.playSound("shoot.wav");
            birdsCount.addScore(1);
            shootDelay = 100;
        }
        if ((Greenfoot.isKeyDown("Up")) && (accY > -24))
        {
            accY -= 0.5;
            turn(-1);
            accX = Math.sqrt(rad * rad - accY * accY);
        }
        if ((Greenfoot.isKeyDown("Down")) && (accY < 20))
        {
            accY += 0.5;
            turn(1);
            accX = Math.sqrt(rad * rad - accY * accY);
        }
        if (shootDelay > 0)
            --shootDelay;
    }
}
