package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; 

/**
 * Write a description of class P2 here.
 *
 */
public class P2 extends Items
{
    public boolean depressed = false;
    public int time = 200;

    /**
     * Act - do whatever the P2 wants to do. This method is called whenever the 'Act' or 'Run'
     * button gets pressed in the environment.
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
            if (!MarioS.gotHit)
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


        }
        if (depressed)
        {
            win();
            Greenfoot.playSound("fell.mp3");
            setImage("D.png");



            time--;
            getWorld().removeObject(this);
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

    public void win()
    {
        // BossWorld.win.play();
        Bowser.gameWon = true;

    }
}
