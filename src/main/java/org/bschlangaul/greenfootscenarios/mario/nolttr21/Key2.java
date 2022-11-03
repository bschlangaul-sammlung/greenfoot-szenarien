package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Key2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Key2 extends Items
{
    public int gravity = 10;
    public int time;

    /**
     * Act - do whatever the Key2 wants to do. This method is called whenever the 'Act' or 'Run'
     * button gets pressed in the environment.
     */
    public void act()
    {
        time++;
        if (time % 6 == 0)
        {
            if (gravity != 0)
                gravity--;
        }
        setLocation(getX(), getY() + gravity);
        // Greenfoot.delay(2);
        KoopaWorld.music.stop();
        if (getOneObjectAtOffset(0, 0, AllMarios.class) != null)
        {
            Greenfoot.playSound("done.mp3");
            Greenfoot.playSound(Mario.characterName + "/winC.mp3");
            Greenfoot.delay(300);

            Greenfoot.setWorld(new Map(3, 3, true));
        }
    }
}
