package org.bschlangaul.greenfootscenarios.angry_birds.mz;

import greenfoot.*; 

/**
 * Write a description of class Level_01 here.
 *
 */
public class Level_01 extends Level_s
{
    boolean levelEnd = false;
    boolean playMusic = true;
    Counter counter = getCounter();
    Counter birdsCount = getBirdsCount();

    public Level_01()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        // super(1280, 720, 1);
        // addObject(new frame(),getWidth()/2,getHeight()/2);
        addObject(new cannon01(), 100, 580);
        addObject(new cannon02(3), 100, 580);
        for (int i = 1; i <= 3; i++)
        {
            addObject(new bird_menu(), 40 * i, 40);
        }
        // addObject(new platform_forest(),1280,500);
        for (int i = 0; i < 2; i++)
        {
            addObject(new platform_forest(), 1200 - i * 1000, 700);
        }
        addObject(new platform_forest(), 700, 600);
        addObject(new platform_forest(), 650, 300);
        addObject(new platform_forest(), 700, 50);

        addObject(new plank_wooden_bg(-45), 680, 360);
        addObject(new plank_wooden_bg(45), 720, 360);

        addObject(new plank_wooden(90), 600, 150);
        addObject(new plank_wooden(90), 800, 150);
        addObject(new plank_wooden(90), 1270, 600);
        addObject(new plank_wooden(0), 700, 440);

        addObject(new crate(), 1270, 465);
        addObject(new crate(), 380, 620);
        addObject(new crate(), 500, 220);
        addObject(new crate(), 670, 220);
        addObject(new crate(), 730, 220);
        addObject(new crate(), 720, 160);

        addObject(new piggy(), 1100, 615);
        addObject(new piggy(), 700, 400);

        addObject(new bush(), 1240, 600);
        addObject(new bush(), 50, 600);
        addObject(new bush(), 300, 650);
        addObject(new bush(), 600, 200);
        addObject(new bush(), 800, 500);
        addObject(new bush(), 700, 550);

        addObject(new rock_forest(), 220, 670);
        addObject(new rock_forest(), 610, 550);

        setPaintOrder(Menu.class, platforms.class, planks.class, crate.class, cannon01.class,
                        cannon02.class, Birb.class, piggy.class, background.class);
        Greenfoot.start();
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
                        && (birdsCount.score == 3))
        {
            createMenu();
            Greenfoot.playSound("level_failed.mp3");
            levelEnd = true;
        }
    }

    protected void createMenu()
    {
        addObject(new MainFrame(), getWidth() / 2, getHeight() / 2);
        addObject(new RestartButton(new Level_01()), getWidth() / 2 - 125, getHeight() / 2 + 125);
        if ((birdsCount.score <= 3) && (getObjects(piggy.class).size() == 0))
        {
            addObject(new NextButton(new Level_02()), getWidth() / 2 + 125, getHeight() / 2 + 125);
        }

        for (int i = getWidth() / 2 - 125; i <= getWidth() / 2 + 125; i += 125)
        {
            addObject(new Star(), i, getHeight() / 2);
            if ((birdsCount.score <= 3) && (getObjects(piggy.class).size() == 0))
            {
                addObject(new goldStar(), getWidth() / 2 - 125, getHeight() / 2);
            }
            if (birdsCount.score <= 2)
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
