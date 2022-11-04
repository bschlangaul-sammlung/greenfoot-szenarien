package org.bschlangaul.greenfootscenarios.angry_birds.mz;

import greenfoot.*; 
// import java.awt.Color;

/**
 * Write a description of class score here.
 *
 */
public class Counter extends Dynamic
{
    int score = 0;

    public void act()
    {
        setImage(new GreenfootImage("Score: " + score, 40, Color.BLACK, Color.WHITE));
    }

    public void addScore(int n)
    {
        for (int i = 0; i < n; i++)
        {
            score++;
        }
    }
}
