package org.bschlangaul.greenfootscenarios.pong.paggos_ichor;

import greenfoot.*;

/**
 * Write a description of class Player here.
 *
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever the 'Act' or 'Run'
     * button gets pressed in the environment.
     */
    public Player()
    {

    }

    public void act()
    {
        if (Greenfoot.mouseMoved(null))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(getX(), mouse.getY());
        }

    }
}
