package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; 

/**
 * Write a description of class Luigi here.
 *
 */
public class Luigi extends Text
{
    public static String characterName;

    public Luigi()
    {
        setImage(new GreenfootImage(characterName, 40, Color.GREEN, new Color(0, 0, 0, 0)));
    }

    /**
     * Act - do whatever the Luigi wants to do. This method is called whenever the 'Act' or 'Run'
     * button gets pressed in the environment.
     */
    public void act()
    {
        if (getX() < 300)
        {
            setLocation(getX() + 20, getY());
        }
        else if (getWorld().getObjects(HasPassed.class).isEmpty())
        {
            getWorld().addObject(new HasPassed(), 0, 150);
        }

    }
}
