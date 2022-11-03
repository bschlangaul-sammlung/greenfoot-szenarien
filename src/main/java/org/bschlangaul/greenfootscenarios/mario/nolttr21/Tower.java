package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; 

/**
 * Write a description of class Tower here.
 *
 */
public class Tower extends SWorld
{
    private ScoreBoard scoreBoard;
    static GreenfootSound theme = new GreenfootSound("4.mp3");// I can take care of the music
    static GreenfootSound start = new GreenfootSound("Stage.wav");
    public static boolean flag = false;

    /**
     * Constructor for objects of class Tower.
     *
     */
    public Tower()
    {
        super(700, 400, 1, 701, 2000);
        GreenfootImage bg = new GreenfootImage("World4Bg.png");
        setScrollingBackground(bg, 1);
        buildWorld();
        if (!start.isPlaying())
        {
            start.play();
        }

        if (!theme.isPlaying())
        {
            theme.play();
        }
    }

    public void act()
    {
        super.act();
        if (!theme.isPlaying())
        {
            theme.play();
        }
    }

    /**
     * When called, removes all objects in the world and rebuilds it. If lives are less than 0, the
     * world is set to the game over world.
     */
    public void rebuildWorld()
    {
        if (lives < 0)
        {
            stopMusic();
            Greenfoot.setWorld(new StartMenu1());
        }
        ammunition = 0;

        buildWorld();
    }

    /**
     * Stops the music when called
     */
    public void stopMusic()
    {
        theme.stop();
    }

    /**
     * Updates the scoreboard in the world
     */
    public void updateScoreboard()
    {
        scoreBoard.updateScore(lives, ammunition);
    }

    /**
     * Put your stuff in here bricks and ? blocks are 32 pixels tall and wide ground blocks are 200
     * pixels wide and 32 pixels tall
     */
    private void buildWorld()
    {
        if (!flag)
        {
            if (marioGun == true)
            {
                addMainActor(new MarioG(), 50, 1952, 250, 150);
            }
            if (marioBig == true)
            {
                addMainActor(new Mario(), 50, 1952, 250, 150);
            }
            if (marioSmall == true)
            {
                addMainActor(new MarioS(), 50, 1952, 250, 150);
            }
        }
        addScoreboard();
        addObject(new Ground(), 100, 1990);
        addObject(new Ground(), 300, 1990);// the grassy ground
        addObject(new Brick(), 150, 1890);// regular brown brick
        addObject(new Block(), 182, 1890);// ? block
        addObject(new Brick(), 214, 1890);
        addObject(new VerPlatform(), 380, 1770);
        addObject(new HorPlatform(), 157, 1700);
        addObject(new LongBrick(), 523, 1700);
        addObject(new Ghoomba(), 523, 1668);
        addObject(new LongBrick(), 623, 1700);
        addObject(new Ghoomba(), 623, 1668);
        addObject(new Brick(), 459, 1700);
        addObject(new Brick(), 459, 1668);
        addObject(new Brick(), 687, 1668);

        addObject(new VerPlatform(), 380, 1560);
        addObject(new LongBrick(), 523, 1500);
        addObject(new Ghoomba(), 523, 1568);
        addObject(new LongBrick(), 623, 1500);
        addObject(new Ghoomba(), 623, 1468);

        addObject(new Brick(), 16, 1468);
        addObject(new FireFlower(), 16, 1436);

        addObject(new VerPlatform(), 500, 1250);
        addObject(new VerPlatform(false), 600, 1150);
        addObject(new VerPlatform(), 500, 1000);
        addObject(new VerPlatform(false), 600, 950);
        addObject(new VerPlatform(), 500, 750);
        addObject(new VerPlatform(false), 600, 750);

        if (!flag)
            addObject(new CheckPointD(), 300, 462);
        else
            addObject(new CheckPointA(), 300, 462);


        addObject(new LongBrick(), 64, 500);
        addObject(new LongBrick(), 128, 500);
        addObject(new LongBrick(), 196, 500);
        addObject(new LongBrick(), 240, 500);
        addObject(new LongBrick(), 300, 500);
        addObject(new LongBrick(), 400, 500);

        addObject(new Pipe(), 32, 450);


        if (flag)
        {
            if (marioGun == true)
            {
                addMainActor(new MarioG(), 200, 300, 250, 150);
            }
            if (marioBig == true)
            {
                addMainActor(new Mario(), 200, 300, 250, 150);
            }
            if (marioSmall == true)
            {
                addMainActor(new MarioS(), 200, 300, 250, 150);
            }
        }

        addObject(new Block(), 687, 1168);
    }

    /**
     * Adds the scoreboard to the world
     */
    private void addScoreboard()
    {
        scoreBoard = new ScoreBoard();
        addObject(scoreBoard, 30, 15, false);
        scoreBoard.updateScore(lives, ammunition);
    }
}
