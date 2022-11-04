package org.bschlangaul.greenfootscenarios.angry_birds.mz;

import greenfoot.*; 

/**
 * Write a description of class NextButton here.
 *
 */
public class NextButton extends Menu
{
    /**
     * Act - do whatever the NextButton wants to do. This method is called whenever the 'Act' or
     * 'Run' button gets pressed in the environment.
     */
    private World level;

    NextButton(World lvl)
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
