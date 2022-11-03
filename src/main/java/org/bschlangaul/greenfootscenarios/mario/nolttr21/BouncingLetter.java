package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; 

/**
 * A BouncingLetter that bounces
 *
 */
public class BouncingLetter extends Text
{
    public int gravity = 0;
    public boolean up = false;
    public int bounce = 0;
    public boolean launch = false;
    public int maxBounce = Greenfoot.getRandomNumber(10) + 1;
    public int yValue;

    public BouncingLetter(int size, String letter, greenfoot.Color text, int y)
    {
        setImage(new GreenfootImage(letter, size, text, new Color(0, 0, 0, 0)));
        yValue = y;
    }

    /**
     * makes it bounce
     */
    public void act()
    {
        if (Greenfoot.getRandomNumber(10) == 0)
        {
            launch = true;
        }
        if (launch)
        {
            if (!up)
            {
                gravity++;
                setLocation(getX(), getY() + gravity);
                if (getY() > yValue)
                {
                    setLocation(getX(), yValue);
                    up = true;
                    bounce++;
                }
            }

            if (up && bounce < maxBounce)
            {
                gravity--;
                gravity--;
                setLocation(getX(), getY() - gravity);
                if (gravity < 0)
                {
                    up = false;

                }
            }
        }
    }
}
