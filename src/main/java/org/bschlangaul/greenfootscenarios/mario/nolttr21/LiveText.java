package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tells how many lives you have
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LiveText extends Text
{
    String Number = "" + ScoreBoard.Lives;

    public LiveText()
    {
        setImage(new GreenfootImage(Number, 80, Color.RED, new Color(0, 0, 0, 0)));
    }

    public int life = 50;

    /**
     * Act - do whatever the Intro2 wants to do. This method is called whenever the 'Act' or 'Run'
     * button gets pressed in the environment.
     */
    public void act()
    {
        life--;
        if (life < 0)
        {
            getWorld().removeObject(this);
        }
    }
}
