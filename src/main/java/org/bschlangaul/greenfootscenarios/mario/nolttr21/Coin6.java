package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;

/**
 * Write a description of class Coin6 here.
 *
 */
public class Coin6 extends Worlds
{
    /**
     * Act - do whatever the Coin6 wants to do. This method is called whenever the 'Act' or 'Run'
     * button gets pressed in the environment.
     */
    public void act()
    {
        if (isTouching(MapMario.class))
        {
            MapMario.up = false;
            MapMario.down = true;
            MapMario.right = true;
            MapMario.left = false;
        }
    }
}
