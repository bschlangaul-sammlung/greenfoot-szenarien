package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HasPassed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HasPassed extends Text
{
    public HasPassed()
    {
        setImage(new GreenfootImage("Has Passed", 40, Color.GREEN,new Color(0,0,0,0)));
    }

    /**
     * Act - do whatever the HasPassed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (getX() < 250)
        {
            setLocation(getX() + 20,getY());
        }
        else if (getWorld().getObjects(WorldN.class).isEmpty())
        {
            setLocation(getX() - 10,getY());
            getWorld().addObject(new WorldN(), 700, 120);
        }
        
    }    
}
