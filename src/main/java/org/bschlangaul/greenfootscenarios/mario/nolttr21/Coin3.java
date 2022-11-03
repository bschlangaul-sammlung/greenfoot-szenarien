package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;

/**
 * Write a description of class Coin3 here.
 */
public class Coin3 extends Worlds
{
    /**
     * Act - do whatever the Coin3 wants to do. This method is called whenever the 'Act' or 'Run'
     * button gets pressed in the environment.
     */
    public void act()
    {
        if (isTouching(MapMario.class))
        {
            MapMario.up = false;
            MapMario.down = false;
            MapMario.right = true;
            MapMario.left = true;
        }
    }
}
