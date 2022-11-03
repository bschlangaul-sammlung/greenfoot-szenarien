package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Two here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Two extends Worlds
{
    /**
     * Act - do whatever the Two wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (isTouching(MapMario.class))
        {
            MapMario.up = false;
            if (Map.clears > 1) MapMario.down = true;
            else MapMario.down = false;
            MapMario.right = false;
            MapMario.left = true;
        }
    }   
    
    public boolean canGoRight()
    {
        return false;
    }
    
    public boolean canGoLeft()
    {
        return true;
    }
    
    public boolean canGoUp()
    {
        return false;
    }
    
    public boolean canGoDown()
    {
        return true;
    }
}
