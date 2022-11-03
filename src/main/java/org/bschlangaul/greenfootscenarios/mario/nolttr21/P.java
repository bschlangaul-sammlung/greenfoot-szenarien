package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; 

/**
 * Write a description of class P here.
 *
 */
public class P extends Items
{
    public boolean depressed = false;
    public int time = 200;

    /**
     * Act - do whatever the P wants to do. This method is called whenever the 'Act' or 'Run' button
     * gets pressed in the environment.
     */
    public void act()
    {
        if (isTouching(Mario.class))
        {
            depressed = true;
        }

        if (isTouching(MarioG.class))
        {
            depressed = true;
        }

        if (isTouching(MarioS.class))
        {
            depressed = true;
        }

        while (depressed && !isTouching(LongBrick.class))
        {
            setLocation(getX(), getY() + 3);
        }

        while (isTouching(Cannon2.class))
        {
            setLocation(getX() - 3, getY());
        }

        if (time == 199)
        {
            setLocation(Greenfoot.getRandomNumber(500) + 50, getY());
            Cannon2.shoot = true;

        }
        if (depressed)
        {

            setImage("D.png");


            time--;
        }
        else
        {
            setImage("P.png");
            while (isTouching(LongBrick.class))
            {
                setLocation(getX(), getY() - 3);
            }
        }

        if (time == 0)
        {
            depressed = false;
            time = 200;
        }
    }
}
