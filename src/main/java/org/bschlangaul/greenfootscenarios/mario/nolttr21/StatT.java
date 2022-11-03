package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StatT here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StatT extends Text
{
    public static int time;
    public static int finalTime;
    StatT()
    {
        // finalTime = time;
        
        
        setImage(new GreenfootImage("Time: " + time/60 + " Seconds", 30, Color.WHITE,new Color(0,0,0,0)));
    }
    
    /**
     * Act - do whatever the StatT wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (getY() > 200)
        {
            setLocation(getX(),getY() - 10);
        }
        else
        {
            if(getWorld().getObjects(StatE.class).isEmpty())
            {
                getWorld().addObject(new StatE(),350,400);
            }
        }
    }    
}
