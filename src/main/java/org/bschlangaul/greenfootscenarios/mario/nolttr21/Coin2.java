package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coin2 extends Worlds
{
    /**
     * Act - do whatever the Coin2 wants to do. This method is called whenever the 'Act' or 'Run'
     * button gets pressed in the environment.
     */
    public void act()
    {
        if (isTouching(MapMario.class))
        {
            MapMario.up = true;
            MapMario.down = false;
            MapMario.right = true;
            MapMario.left = false;
        }
    }
}
