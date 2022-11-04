package org.bschlangaul.greenfootscenarios.angry_birds.mz;

import greenfoot.*; 

/**
 * Write a description of class RestartButton here.
 *
 */
public class RestartButton extends Menu
{
    /**
     * Act - do whatever the RestartButton wants to do. This method is called whenever the 'Act' or
     * 'Run' button gets pressed in the environment.
     */
    private World level;

    RestartButton(World lvl)
    {
        getImage().scale(100, 100);
        this.level = lvl;
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(this.level);
        }
    }
}
