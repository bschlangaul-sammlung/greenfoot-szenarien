package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;

/**
 * Write a description of class StatE here.
 */
public class StatE extends Text
{
    public static int kills;

    public StatE()
    {
        setImage(new GreenfootImage("Enemys Killed: " + kills, 30, Color.WHITE,
                        new Color(0, 0, 0, 0)));
    }

    /**
     * Act - do whatever the StatE wants to do. This method is called whenever the 'Act' or 'Run'
     * button gets pressed in the environment.
     */
    public void act()
    {
        if (getY() > 230)
        {
            setLocation(getX(), getY() - 10);
        }
        else
        {
            if (getWorld().getObjects(Procede.class).isEmpty())
            {
                getWorld().addObject(new Procede(), 350, 400);
            }
        }
    }
}
