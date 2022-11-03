package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;

/**
 * Write a description of class A here.
 */
public class A extends Worlds
{
    /**
     * Act - do whatever the A wants to do. This method is called whenever the 'Act' or 'Run' button
     * gets pressed in the environment.
     */
    public void act()
    {
        if (isTouching(MapMario.class))
        {
            MapMario.up = false;
            MapMario.down = false;
            MapMario.right = false;
            MapMario.left = false;
        }
    }
}
