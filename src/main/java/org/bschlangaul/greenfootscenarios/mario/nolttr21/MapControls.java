package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MapControls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MapControls extends World
{
    public int delay = 20;
    /**
     * Constructor for objects of class MapControls.
     * 
     */
    public MapControls()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 400, 1); 
    }
    
    
    public void act()
    {
        delay--;
        if (delay < 0)
        {
            if (Greenfoot.isKeyDown("enter"))
            {
                Greenfoot.setWorld(new Map(0,0,false));
            }
        }
    }
}
