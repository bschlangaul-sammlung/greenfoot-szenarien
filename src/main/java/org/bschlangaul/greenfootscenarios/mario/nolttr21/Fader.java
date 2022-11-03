package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; 

/**
 * Write a description of class Fader here.
 *
 */
public class Fader extends Decoration
{
    public static int bill = 0;
    public int time;
    public boolean toWhite;
    public boolean toBlack;
    public GreenfootImage fade = new GreenfootImage(700, 400);

    public Fader(int init, boolean white, boolean black)
    {
        bill = init;
        toWhite = white;
        toBlack = black;

    }

    /**
     * Act - do whatever the Fade wants to do. This method is called whenever the 'Act' or 'Run'
     * button gets pressed in the environment.
     */
    public void act()
    {
        time++;

        fade.drawRect(0, 0, 700, 400);

        fade.setColor(new Color(0, 0, 0, bill));
        fade.clear();
        fade.fill();

        if (getWorld() instanceof BossWorld)
        {
            setLocation(350, getY());
        }

        if (getWorld() instanceof BossWorld2)
        {
            setLocation(350, getY());
        }

        if (getWorld() instanceof KoopaWorld)
        {
            setLocation(350, getY());
        }


        // if(time % 2==1)

        if (toWhite)
        {
            // fade.clear();
            if (bill > 0)
                bill--;
            if (bill > 0)
                bill--;
            if (bill > 0)
                bill--;
            if (bill > 0)
                bill--;
            if (bill > 0)
                bill--;
            if (bill > 0)
                bill--;
            if (bill > 0)
                bill--;
            if (bill > 0)
                bill--;
        }
        else if (toBlack)
        {
            if (bill < 255)
                bill++;
            if (bill < 255)
                bill++;
            if (bill < 255)
                bill++;
            if (bill < 255)
                bill++;
        }

        setImage(fade);
    }

    public int scale()
    {
        // for diagnostics
        return bill;
    }
}
