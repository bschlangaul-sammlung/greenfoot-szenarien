package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;

/**
 * Write a description of class NextWorld here.
 *
 */
public class NextWorld extends SWorld
{

    public int time = 200;
    public static int world = 0;

    /**
     * Constructor for objects of class NextWorld.
     *
     */
    public NextWorld(int next)
    {
        super(700, 400, 1, 700);
        prepare();

        // world = next;
        // world = next;
        // Objects obj = getWorld().getObjects
    }

    public void act()
    {
        MyWorld.flag = false;
        WorldTwo.flag = false;
        WorldThree.flag = false;
        Tower.flag = false;
        Airship.flag = false;
        Fortress.flag = false;
        time--;

    }

    public void prepare()
    {
        addObject(new Luigi(), 0, 100);
    }

    public int World()
    {
        return world;
    }
}
