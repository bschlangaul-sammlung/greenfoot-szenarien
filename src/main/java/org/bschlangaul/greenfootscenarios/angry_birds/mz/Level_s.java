package org.bschlangaul.greenfootscenarios.angry_birds.mz;

import greenfoot.*; 

/**
 * Write a description of class Level_s here.
 *
 */
public class Level_s extends World
{
    Counter counter = new Counter();
    Counter birdsCount = new Counter();

    /**
     * Constructor for objects of class Level_s.
     *
     */
    public Level_s()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        addObject(counter, 1200, 45);
        setPaintOrder(bird_gray.class, bird_menu.class);
    }

    public Counter getCounter()
    {
        return counter;
    }

    public Counter getBirdsCount()
    {
        return birdsCount;
    }
}
