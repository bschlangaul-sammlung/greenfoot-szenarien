package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * On the Main menu, allows you to select mario as your character
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectedMario extends Characters
{
    public int time;
    public int imageNumber;
    /**
     * Act - do whatever the SelectedLuigi wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        time++;
        if (getX() < 275)
        {
            setLocation(getX()+10,getY());
        }
        else
        {
            setLocation(280,getY());
        }
        
        
        if (time == 1)
        {
            setLocation(getX()-220,350);
        }
        
        if(time % 6 == 1)
        {
            imageNumber++;
            if (imageNumber == 3)
            {
                imageNumber = 1;
            }
            setImage("mariomarioR" + imageNumber + ".png");
        }
    }    
}
