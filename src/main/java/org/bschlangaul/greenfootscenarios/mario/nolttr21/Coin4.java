package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;

/**
 * Write a description of class Coin4 here.
 *
 */
public class Coin4 extends Worlds
{
    /**
     * Act - do whatever the Coin4 wants to do. This method is called whenever the 'Act' or 'Run'
     * button gets pressed in the environment.
     */
    public void act()
    {
        if (isTouching(MapMario.class))
        {
            MapMario.up = true;
            MapMario.down = false;
            MapMario.right = true;
            MapMario.left = true;
        }
    }
}
