package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class One here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
