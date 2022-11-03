package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; 

/**
 * Write a description of class SelectedLuigi here.
 *
 */
public class SelectedLuigi extends Characters
{
    public int time;
    public int imageNumber;

    /**
     * Act - do whatever the SelectedLuigi wants to do. This method is called whenever the 'Act' or
     * 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        time++;

        if (getX() < 430)
        {
            setLocation(getX() + 10, getY());
        }
        else
        {
            setLocation(430, getY());
        }

        if (time == 1)
        {
            setLocation(getX() - 200, 348);
        }
        if (time % 6 == 1)
        {
            imageNumber++;
            if (imageNumber == 3)
            {
                imageNumber = 1;
            }
            setImage("luigimarioR" + imageNumber + ".png");
        }
    }
}
