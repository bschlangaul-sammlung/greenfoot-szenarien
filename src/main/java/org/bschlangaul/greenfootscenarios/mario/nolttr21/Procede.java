package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; 

/**
 * Write a description of class Procede here.
 *
 */
public class Procede extends Text
{
    public Procede()
    {
        setImage(new GreenfootImage("Ready For Next Level?", 30, Color.WHITE,
                        new Color(0, 0, 0, 0)));
    }

    /**
     * Act - do whatever the Procede wants to do. This method is called whenever the 'Act' or 'Run'
     * button gets pressed in the environment.
     */
    public void act()
    {
        if (getY() > 260)
        {
            setLocation(getX(), getY() - 10);
        }
    }
}
