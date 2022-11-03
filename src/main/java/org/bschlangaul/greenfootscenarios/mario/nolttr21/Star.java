package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; 

/**
 * Write a description of class Star here.
 *
 */
public class Star extends Decoration
{
    public int speed = 15;

    public Star()
    {
        turn(Greenfoot.getRandomNumber(360));
    }


    /**
     * Act - do whatever the Star wants to do. This method is called whenever the 'Act' or 'Run'
     * button gets pressed in the environment.
     */
    public void act()
    {
        speed--;
        move(speed);
        if (speed == 0)
        {
            getWorld().removeObject(this);
        }
    }
}
