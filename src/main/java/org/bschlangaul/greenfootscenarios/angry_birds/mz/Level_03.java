package org.bschlangaul.greenfootscenarios.angry_birds.mz;

import greenfoot.*; 

/**
 * Write a description of class Level_03 here.
 *
 */
public class Level_03 extends Level_s
{
    boolean levelEnd = false;
    boolean playMusic = true;
    Counter counter = getCounter();
    Counter birdsCount = getBirdsCount();

    public Level_03()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        // super(1280, 720, 1);
        // addObject(new frame(),getWidth()/2,getHeight()/2);
        addObject(new cannon01(), 200, 280);
        addObject(new cannon02(5), 200, 280);
        addObject(new platform_snow(), 0, 380);
        addObject(new platform_snow(), 1700, 380);
        addObject(new platform_snow(), 1700, 10);
        for (int i = 1; i <= 5; i++)
        {
            addObject(new bird_menu(), 40 * i, 40);
        }
        for (int i = 0; i < 2; i++)
        {
            addObject(new platform_snow(), 1200 - i * 1000, 700);
        }
        addObject(new platform_snow(), 700, 500);

        addObject(new crate(), 1150, 310);
        addObject(new crate(), 1150, 250);
        addObject(new crate(), 1090, 310);
        addObject(new crate(), 500, 440);
        addObject(new crate(), 560, 440);
        addObject(new crate(), 680, 440);
        addObject(new crate(), 500, 380);

        addObject(new piggy(), 1220, 300);
        addObject(new piggy(), 100, 630);
        addObject(new piggy(), 1000, 630);

        addObject(new rock_snow(), 50, 280);
        addObject(new rock_snow(), 120, 600);
        addObject(new rock_snow(), 1250, 280);
        addObject(new rock_snow(), 1100, 660);
        addObject(new rock_snow(), 1200, 600);

        setPaintOrder(Menu.class, Counter.class, cannon01.class, cannon02.class, planks.class,
                        crate.class, Birb.class, piggy.class, platforms.class, background.class);
        // Greenfoot.start();
        // Greenfoot.playSound("level_start.mp3");
    }

    public void act()
    {
        if (playMusic == true)
        {
            Greenfoot.playSound("level_start.mp3");
            playMusic = false;
        }
        if ((getObjects(piggy.class).size() == 0) && (levelEnd == false))
        {
            createMenu();
            Greenfoot.playSound("level_clear.mp3");
            levelEnd = true;
        }
        else if ((getObjects(Birb.class).size() == 0) && (levelEnd == false)
                        && (birdsCount.score == 5))
        {
            createMenu();
            Greenfoot.playSound("level_failed.mp3");
            levelEnd = true;
        }
    }

    protected void createMenu()
    {
        addObject(new MainFrame(), getWidth() / 2, getHeight() / 2);
        addObject(new RestartButton(new Level_03()), getWidth() / 2 - 125, getHeight() / 2 + 125);
        for (int i = getWidth() / 2 - 125; i <= getWidth() / 2 + 125; i += 125)
        {
            addObject(new Star(), i, getHeight() / 2);
            if ((birdsCount.score <= 5) && (getObjects(piggy.class).size() == 0))
            {
                addObject(new goldStar(), getWidth() / 2 - 125, getHeight() / 2);
            }
            if (birdsCount.score <= 4)
            {
                addObject(new goldStar(), getWidth() / 2, getHeight() / 2);
            }
            if (birdsCount.score <= 3)
            {
                addObject(new goldStar(), getWidth() / 2 + 125, getHeight() / 2);
            }
        }
    }
}
