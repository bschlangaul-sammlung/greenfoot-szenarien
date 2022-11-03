package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartGround here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StartGround extends Decoration
{
    public static int time;
    public GreenfootImage brick = new GreenfootImage("brick.png");
    public GreenfootImage ground = new GreenfootImage("Ground.png");
    public static boolean beBrick;

    public StartGround()
    {
        time++;
        if (beBrick)
        {
            setImage(brick);
        }
        else
        {
            setImage(ground);
        }
    }

    /**
     * Act - do whatever the StartGround wants to do. This method is called whenever the 'Act' or
     * 'Run' button gets pressed in the environment.
     */
    public void act()
    {

        if (time > 30)
        {
            setLocation(getX() - 5, getY());
        }

        if (getY() != 388)
        {
            setLocation(getX(), 388);
        }

        if (time % 50 == 1)
        {
            beBrick = false;
        }
        else if (time % 70 == 1)
        {
            beBrick = true;
        }

    }


}
