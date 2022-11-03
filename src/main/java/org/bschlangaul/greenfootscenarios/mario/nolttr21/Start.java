package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; 

/**
 * Write a description of class Start here.
 *
 */
public class Start extends Worlds
{
    /**
     * Act - do whatever the Start wants to do. This method is called whenever the 'Act' or 'Run'
     * button gets pressed in the environment.
     */
    public void act()
    {
        if (isTouching(MapMario.class))
        {
            MapMario.up = false;
            if (Map.unlocked)
                MapMario.down = true;
            MapMario.right = true;
            MapMario.left = false;
        }
    }
}
