package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;

/**
 * Write a description of class Key here.
 *
 */
public class Key extends Items
{
    public static int num = -1;
    public int door;

    public Key()
    {
        num++;
        num = door;
    }

    /**
     * Act - do whatever the Key wants to do. This method is called whenever the 'Act' or 'Run'
     * button gets pressed in the environment.
     */
    public void act()
    {


        try
        {
            Actor Door = getWorld().getObjects(Door.class).get(door);
            turnTowards(Door.getX(), Door.getY());
        } catch (IndexOutOfBoundsException exception)
        {
            getWorld().removeObject(this);
            return;
        }
        move(10);
        if (isTouching(Door.class))
        {
            removeTouching(Door.class);
            Map.unlocked = true;
            getWorld().removeObject(this);
        }


    }
}
