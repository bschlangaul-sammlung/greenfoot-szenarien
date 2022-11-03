package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;

/**
 * Write a description of class LiveImage here.
 */
public class LiveImage extends Text
{
    public int life = 50;

    /**
     * Act - do whatever the Intro2 wants to do. This method is called whenever the 'Act' or 'Run'
     * button gets pressed in the environment.
     */
    public void act()
    {
        life--;
        getImage().scale(100, 50);
        if (life < 0)
        {
            getWorld().removeObject(this);
        }
    }
}
