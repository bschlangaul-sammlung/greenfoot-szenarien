package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class to create your world
 *
 * in the next line insert what would theme you would like this level to be
 * (insert here) Grass, Desert, Ice,Water, Forest, Cliff, Sky, Dark(lava)
 *
 * @author (your name) I will put you in the credits
 * @version (1)
 */
public class Airship extends SWorld
{
    private ScoreBoard scoreBoard;
    // static GreenfootSound theme = new GreenfootSound("World1 theme.mp3");//I can take care of the music
    static GreenfootSound start = new GreenfootSound("Stage.wav");
    static GreenfootSound theme = new GreenfootSound("airship.mp3");
    public static boolean flag = false;
    /**
     * Constructor for objects of class Airship.
     *
     */
    public Airship()
    {
        super(700, 400, 1, 3300);//change the last number to make your world bigger

        GreenfootImage bg = new GreenfootImage("mariobackground.jpg");
        setScrollingBackground(bg);

        theme.playLoop();

        buildWorld();

        // if(!start.isPlaying())
        // {
            // start.play();
        // }
    }

    /**
     * When called, removes all objects in the world and rebuilds it.
     * If lives are less than 0, the world is set to the game over world.
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
     * Put your stuff in here
     * bricks and ? blocks are 32 pixels tall and wide
     * ground blocks are 200 pixels wide and 32 pixels tall
     */
    private void buildWorld()
    {
        if (!flag)
        {
        if (marioGun == true)
        {
            addMainActor(new MarioG(), 50, 352, 250, 300);
        }
        if (marioBig == true)
        {
            addMainActor(new Mario(), 50, 352, 250, 300);
        }
        if (marioSmall == true)
        {
            addMainActor(new MarioS(), 50, 352, 250, 300);
        }
    }
        addScoreboard();

        addObject(new Brick(), 150, 290);//regular brown brick
        addObject(new Block(), 182, 290);//? block
        addObject(new Brick(), 214, 290);

        addObject(new LongBrick(), 0, 390);
        addObject(new LongBrick(), 100, 390);
        addObject(new LongBrick(), 200, 390);
        addObject(new LongBrick(), 300, 390);

        addObject(new LongBrick(), 400, 390);
        addObject(new LongBrick(), 400, 358);
        addObject(new Cannon(),300,348);

        addObject(new LongBrick(), 500, 390);
        addObject(new LongBrick(), 500, 358);

        addObject(new LongBrick(), 600, 390);
        addObject(new LongBrick(), 600, 358);
        addObject(new Cannon(),600,316);

        addObject(new LongBrick(), 700, 390);
        addObject(new LongBrick(), 700, 358);
        addObject(new LongBrick(), 700, 326);

        addObject(new LongBrick(), 800, 390);
        addObject(new LongBrick(), 800, 358);
        addObject(new LongBrick(), 800, 326);

        addObject(new LongBrick(), 900, 390);
        addObject(new LongBrick(), 900, 358);
        addObject(new LongBrick(), 900, 326);
        addObject(new Cannon(),900,284);

        addObject(new LongBrick(), 1000, 390);
        addObject(new LongBrick(), 1000, 358);
        addObject(new LongBrick(), 1000, 326);
        addObject(new LongBrick(), 1000, 294);

        addObject(new LongBrick(), 1100, 390);
        addObject(new LongBrick(), 1100, 358);
        addObject(new LongBrick(), 1100, 326);
        addObject(new LongBrick(), 1100, 294);

        addObject(new LongBrick(), 1200, 390);
        addObject(new LongBrick(), 1200, 358);
        addObject(new LongBrick(), 1200, 326);
        addObject(new LongBrick(), 1200, 294);

        addObject(new VerPlatform(),1350,194);
        addObject(new VerPlatform(),1550,194);
        addObject(new VerPlatform(),1750,194);

        addObject(new HorPlatform(),1950,194);

        addObject(new Brick(),2200,390);
        addObject(new Brick(),2200,358);
        addObject(new Brick(),2200,326);
        addObject(new Brick(),2200,294);
        addObject(new Brick(),2200,262);
        addObject(new Brick(),2200,230);
        addObject(new FireFlower(),2200,199);

        // addObject(new Brick(),2264,390);
        // addObject(new Brick(),2264,358);
        // addObject(new Brick(),2264,326);

        addObject(new Brick(),2274,294);
        addObject(new Brick(),2274,262);
        addObject(new Brick(),2274,230);
        addObject(new FireFlower(),2274,199);

        addObject(new LongBrick(),2338,294);
        addObject(new LongBrick(),2438,294);

            addObject(new Brick(),2492,262);
            addObject(new Brick(),2492,230);
            addObject(new Brick(),2492,198);
            addObject(new Brick(),2492,166);
            addObject(new Brick(),2492,134);

        addObject(new LongBrick(),2264,390);
        addObject(new LongBrick(),2364,390);
        addObject(new LongBrick(),2464,390);
        addObject(new LongBrick(),2564,390);

        addObject(new VerPlatform(),2764,190);
        if (!flag)addObject(new CheckPointD(),2914,158);
        else addObject(new CheckPointA(),2914,158);

        if (flag)
        {
        if (marioGun == true)
        {
            addMainActor(new MarioG(), 2914, 0, 250, 300);
        }
        if (marioBig == true)
        {
            addMainActor(new Mario(), 2914, 0, 250, 300);
        }
        if (marioSmall == true)
        {
            addMainActor(new MarioS(), 2914, 0, 250, 300);
        }
    }

        if (!flag)addObject(new CheckPointD(),2914,158);
        else addObject(new CheckPointA(),2914,158);

        addObject(new LongBrick(),2914,190);
        addObject(new LongBrick(),3014,190);
        addObject(new LongBrick(),3114,190);
        addObject(new Pipe(),3150,142);

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
