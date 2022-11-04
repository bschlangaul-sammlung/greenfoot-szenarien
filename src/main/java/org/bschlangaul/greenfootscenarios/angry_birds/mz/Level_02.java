package org.bschlangaul.greenfootscenarios.angry_birds.mz;

import greenfoot.*; 

/**
 * Write a description of class Level_02 here.
 *
 */
public class Level_02 extends Level_s
{
    boolean levelEnd = false;
    boolean playMusic = true;
    Counter counter = getCounter();
    Counter birdsCount = getBirdsCount();

    public Level_02()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        // super(1280, 720, 1);
        // addObject(new frame(),getWidth()/2,getHeight()/2);
        addObject(new cannon01(), 175, 500);
        addObject(new cannon02(4), 175, 500);
        for (int i = 1; i <= 4; i++)
        {
            addObject(new bird_menu(), 40 * i, 40);
        }
        addObject(new platform_desert(), 0, 620);
        addObject(new platform_desert(), 0, 250);
        addObject(new platform_desert(), 800, 500);
        addObject(new platform_desert(), 200, 800);
        addObject(new platform_desert(), 700, 800);
        addObject(new platform_desert(), 1200, 800);
        addObject(new platform_desert(), 700, 0);

        addObject(new piggy(), 1190, 415);
        addObject(new piggy(), 1100, 640);
        addObject(new piggy(), 750, 260);

        addObject(new crate(), 1270, 425);
        addObject(new crate(), 1270, 366);
        addObject(new crate(), 1270, 307);
        addObject(new crate(), 1170, 640);
        addObject(new crate(), 430, 660);
        addObject(new crate(), 330, 660);

        addObject(new plank_wooden(90), 700, 400);
        addObject(new plank_wooden(60), 655, 395);
        addObject(new plank_wooden(-60), 745, 395);
        addObject(new plank_wooden(0), 700, 300);
        addObject(new plank_wooden(0), 380, 620);
        addObject(new plank_wooden(45), 1210, 530);
        addObject(new plank_wooden(0), 1220, 455);

        addObject(new cactus(), 900, 380);
        addObject(new cactus(), 100, 180);

        addObject(new rock_desert(), 15, 550);
        addObject(new rock_desert(), 550, 680);
        addObject(new rock_desert(), 950, 700);
        addObject(new rock_desert(), 800, 450);

        setPaintOrder(Menu.class, platforms.class, planks.class, crate.class, cannon01.class,
                        cannon02.class, Birb.class, piggy.class, background.class);
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
                        && (birdsCount.score == 4))
        {
            createMenu();
            Greenfoot.playSound("level_failed.mp3");
            levelEnd = true;
        }
    }

    protected void createMenu()
    {
        addObject(new MainFrame(), getWidth() / 2, getHeight() / 2);
        addObject(new RestartButton(new Level_02()), getWidth() / 2 - 125, getHeight() / 2 + 125);
        if ((birdsCount.score <= 4) && (getObjects(piggy.class).size() == 0))
        {
            addObject(new NextButton(new Level_03()), getWidth() / 2 + 125, getHeight() / 2 + 125);
        }
        for (int i = getWidth() / 2 - 125; i <= getWidth() / 2 + 125; i += 125)
        {
            addObject(new Star(), i, getHeight() / 2);
            if ((birdsCount.score <= 4) && (getObjects(piggy.class).size() == 0))
            {
                addObject(new goldStar(), getWidth() / 2 - 125, getHeight() / 2);
            }
            if (birdsCount.score <= 3)
            {
                addObject(new goldStar(), getWidth() / 2, getHeight() / 2);
            }
            if (birdsCount.score <= 1)
            {
                addObject(new goldStar(), getWidth() / 2 + 125, getHeight() / 2);
            }
        }
    }
}
