package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class F here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class F extends Worlds
{
    /**
     * Act - do whatever the F wants to do. This method is called whenever the 'Act' or 'Run' button
     * gets pressed in the environment.
     */
    public void act()
    {
        if (isTouching(MapMario.class))
        {
            MapMario.up = false;
            MapMario.down = false;
            MapMario.right = true;
            MapMario.left = false;
        }
    }
}
