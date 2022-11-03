package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;

/**
 * Write a description of class C here.
 *
 */
public class C extends Worlds
{
    /**
     * Act - do whatever the C wants to do. This method is called whenever the 'Act' or 'Run' button
     * gets pressed in the environment.
     */
    public void act()
    {
        if (isTouching(MapMario.class))
        {
            MapMario.up = false;
            MapMario.down = true;
            MapMario.right = false;
            MapMario.left = false;
        }
    }
}
