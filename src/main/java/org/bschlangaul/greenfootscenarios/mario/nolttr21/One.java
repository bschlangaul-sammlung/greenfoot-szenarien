package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;

/**
 * Write a description of class One here.
 */
public class One extends Worlds
{
    /**
     * Act - do whatever the One wants to do. This method is called whenever the 'Act' or 'Run'
     * button gets pressed in the environment.
     */
    public void act()
    {
        if (isTouching(MapMario.class))
        {
            MapMario.up = false;
            MapMario.down = false;
            if (Map.clears > 0)
                MapMario.right = true;
            else
                MapMario.right = false;
            MapMario.left = true;
        }
    }
}
