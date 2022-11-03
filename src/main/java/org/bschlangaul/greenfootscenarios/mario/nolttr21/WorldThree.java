package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; 

/**
 * Write a description of class WorldThree here.
 *
 * @author (Dylan Powell and Sean Eastley)
 * @version (January 21, 2015)
 */
public class WorldThree extends SWorld
{
    private ScoreBoard scoreBoard;
    static GreenfootSound music = new GreenfootSound("1.mp3");
    static GreenfootSound start = new GreenfootSound("Stage.wav");
    private boolean playing = false; // defines if the music is playing or not
    public static boolean flag = false;

    /**
     * Creates the world
     */
    public WorldThree()
    {
        super(700, 400, 1, 7500);
        // setPaintOrder(LiveText.class,LiveImage.class,Intro3.class,Block.class);

        StatT.time = 0;
        StatE.kills = 0;

        GreenfootImage bg = new GreenfootImage("World3Bg.jpg");
        setScrollingBackground(bg);
        WorldN.world = 3;
        if (!start.isPlaying())
        {
            start.play();
        }
        if (!music.isPlaying() && playing == false)
        {
            playing = true;
            music.playLoop();
        }
        buildWorld();
        SWorld.time = 100;
        LiveImage liveimage = new LiveImage();
        addObject(liveimage, 245, 271);
        LiveText livetext = new LiveText();
        addObject(livetext, 369, 289);
        liveimage.setLocation(313, 268);
        liveimage.setLocation(292, 269);
        livetext.setLocation(368, 270);

        Intro3 intro = new Intro3();
        addObject(intro, 350, 200);
        intro.setLocation(350, 200);
    }

    /**
     * Stops the music when called
     */
    public void stopMusic()
    {
        music.stop();
    }

    /**
     * When called, removes all objects in the world and rebuilds it. If lives are less than 0, the
     * world is set to the game over world.
     */
    public void rebuildWorld()
    {
        // ammunition = 0;

        removeObjects(getObjects(null));
        buildWorld();
        decreaseLives();
        music.playLoop();
        if (lives < 0)
        {
            stopMusic();
            Greenfoot.setWorld(new GameOver());
        }

    }

    /**
     * Adds the scoreboard to the world
     */
    private void addScoreboard()
    {
        scoreBoard = new ScoreBoard();
        addObject(scoreBoard, 40, 15, false);
        scoreBoard.updateScore(lives, ammunition);
    }

    /**
     * Updates the scoreboard in the world
     */
    public void updateScoreboard()
    {
        scoreBoard.updateScore(lives, ammunition);
    }

    /**
     * Adds all the ground, marios and calls the methods to add objects to the world
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
        addObject(new Ground(), 155, 390);
        addObject(new Ground(), 285, 390);
        addObject(new Ground(), 855, 390);
        addObject(new Ground(), 1425, 390);
        addObject(new Ground(), 1995, 390);
        addObject(new Ground(), 2565, 390);
        addObject(new Ground(), 3135, 390);
        addObject(new Ground(), 3335, 390);
        addObject(new Ground(), 3905, 390);
        addObject(new Ground(), 4475, 390);
        addObject(new Ground(), 5045, 390);
        addObject(new Ground(), 5615, 390);
        addObject(new Ground(), 6185, 390);
        addObject(new Ground(), 6755, 390);
        addObject(new Ground(), 7325, 390);
        addObject(new Ground(), 7425, 390);
        areaOne();
        areaTwo();
        areaThree();
        areaFour();
        areaFive();
        areaSix();
        areaSeven();
        areaEight();
        addScoreboard();
        SWorld.time = 100;
        LiveImage liveimage = new LiveImage();
        addObject(liveimage, 245, 271);
        LiveText livetext = new LiveText();
        addObject(livetext, 369, 289);
        liveimage.setLocation(313, 268);
        liveimage.setLocation(292, 269);
        livetext.setLocation(368, 270);
        addObject(new Intro3(), 350, 200);
    }

    /**
     * Adds all the objects for area one of the world
     */
    private void areaOne()
    {
        addObject(new Brick(), 285, 358);
        addObject(new Brick(), 285, 326);
        addObject(new Brick(), 285, 294);

        addObject(new Ghoomba(), 392, 358);
        addObject(new Block(), 392, 290);

        addObject(new Brick(), 500, 358);
        addObject(new Brick(), 500, 326);
        addObject(new Brick(), 500, 294);

        addObject(new Block(), 700, 290);
        addObject(new KoopaKid(), 800, 358);
    }

    /**
     * Adds all the objects for area two of the world
     */
    private void areaTwo()
    {
        addObject(new Brick(), 1000, 358);
        addObject(new Brick(), 1000, 326);
        addObject(new Brick(), 1000, 294);

        addObject(new Brick(), 1200, 358);
        addObject(new Brick(), 1200, 326);
        addObject(new Brick(), 1200, 294);
        addObject(new Brick(), 1200, 262);
        addObject(new Brick(), 1200, 230);
        addObject(new Brick(), 1200, 198);

        addObject(new Block(), 1300, 290);
        addObject(new Ghoomba(), 1300, 358);

        addObject(new Brick(), 1400, 358);
        addObject(new Brick(), 1400, 326);
        addObject(new Brick(), 1400, 294);
        addObject(new Brick(), 1400, 262);
        addObject(new Brick(), 1400, 230);
        addObject(new Brick(), 1400, 198);
        addObject(new Brick(), 1400, 166);
        addObject(new Brick(), 1400, 134);
        addObject(new Brick(), 1400, 102);
        if (flag)
        {
            if (marioGun == true)
            {
                addMainActor(new MarioG(), 1400, 352, 250, 300);
            }
            if (marioBig == true)
            {
                addMainActor(new Mario(), 1400, 352, 250, 300);
            }
            if (marioSmall == true)
            {
                addMainActor(new MarioS(), 1400, 352, 250, 300);
            }
        }


        addObject(new Ghoomba(), 1450, 358);
        addObject(new HammerBro(), 1650, 358);
        addObject(new Ghoomba(), 1850, 358);
        addObject(new Ghoomba(), 2050, 358);

        addObject(new HorPlatform(), 1650, 200);

        addObject(new Block(), 1768, 100);
        addObject(new Block(), 1800, 100);
        if (!flag)
        {
            addObject(new CheckPointD(), 1791, 60);
        }
        else
        {
            addObject(new CheckPointA(), 1791, 60);
        }

        addObject(new Ghoomba(), 2250, 358);
    }

    /**
     * Adds all the objects for area three of the world
     */
    private void areaThree()
    {
        addObject(new Brick(), 2300, 280);
        // addObject(new Brick(), 2300, 312);
        addObject(new LongBrick(), 2332, 312);
        // addObject(new Brick(), 2364, 312);
        // addObject(new Brick(), 2396, 312);
        addObject(new LongBrick(), 2428, 312);
        // addObject(new Brick(), 2460, 312);
        // addObject(new Brick(), 2492, 312);
        addObject(new LongBrick(), 2524, 312);
        // addObject(new Brick(), 2556, 312);
        // addObject(new Brick(), 2588, 312);

        addObject(new LongBrick(), 2620, 312);
        // addObject(new Brick(), 2652, 312);
        addObject(new Brick(), 2652, 280);
        addObject(new Block(), 2460, 190);
        addObject(new Block(), 2492, 190);
        addObject(new Ghoomba(), 2350, 280);
        addObject(new Ghoomba(), 2450, 280);
        addObject(new Ghoomba(), 2550, 280);
    }

    /**
     * Adds all the objects for area four of the world
     */
    private void areaFour()
    {
        addObject(new Brick(), 2900, 358);
        addObject(new Brick(), 2900, 326);
        addObject(new Brick(), 2900, 294);

        addObject(new Block(), 3000, 290);
        addObject(new HammerBro(), 3000, 358);

        addObject(new Brick(), 3100, 358);
        addObject(new Brick(), 3100, 326);
        addObject(new Brick(), 3100, 294);
    }

    /**
     * Adds all the objects for area five of the world
     */
    private void areaFive()
    {

        addObject(new Ghoomba(), 3200, 358);
        addObject(new Ghoomba(), 4700, 358);

        addObject(new LongBrick(), 3320, 358);
        addObject(new LongBrick(), 3480, 358);
        addObject(new LongBrick(), 3640, 358);
        addObject(new LongBrick(), 3800, 358);
        addObject(new LongBrick(), 3960, 358);
        addObject(new LongBrick(), 4120, 358);
        addObject(new LongBrick(), 4280, 358);
        addObject(new LongBrick(), 4440, 358);
        addObject(new LongBrick(), 4600, 358);

        addObject(new LongBrick(), 3480, 326);
        addObject(new LongBrick(), 3640, 326);
        addObject(new LongBrick(), 3800, 326);
        addObject(new LongBrick(), 3960, 326);
        addObject(new LongBrick(), 4120, 326);
        addObject(new LongBrick(), 4280, 326);
        addObject(new LongBrick(), 4440, 326);

        addObject(new LongBrick(), 3640, 294);
        addObject(new LongBrick(), 3800, 294);
        addObject(new LongBrick(), 3960, 294);
        addObject(new LongBrick(), 4120, 294);
        addObject(new LongBrick(), 4280, 294);

        addObject(new LongBrick(), 3800, 262);
        addObject(new LongBrick(), 3960, 262);
        addObject(new LongBrick(), 4120, 262);

        addObject(new LongBrick(), 3960, 230);
        // Happy Face
        addObject(new Block(), 3832, 262);
        addObject(new Block(), 4088, 262);
        addObject(new Block(), 3896, 294);
        addObject(new Block(), 3928, 294);
        addObject(new Block(), 3928, 326);
        addObject(new Block(), 3960, 326);
        addObject(new Block(), 3992, 326);
        addObject(new Block(), 3992, 294);
        addObject(new Block(), 4024, 294);
        // End Happy Face
        addObject(new Block(), 3960, 130);
    }

    /**
     * Adds all the objects for area six of the world
     */
    private void areaSix()
    {
        addObject(new LongBrick(), 5180, 358);
        addObject(new LongBrick(), 5180, 326);
        addObject(new LongBrick(), 5180, 294);
        addObject(new LongBrick(), 5340, 358);
        addObject(new LongBrick(), 5340, 326);
        addObject(new LongBrick(), 5340, 294);
        addObject(new Brick(), 5244, 262);
        addObject(new Brick(), 5244, 230);
        addObject(new Brick(), 5244, 198);
        addObject(new Brick(), 5212, 262);
        addObject(new Brick(), 5212, 230);
        addObject(new Brick(), 5212, 198);
        addObject(new Brick(), 5276, 262);
        addObject(new Brick(), 5276, 230);
        addObject(new Brick(), 5276, 198);
        addObject(new Brick(), 5308, 262);
        addObject(new Brick(), 5308, 230);
        addObject(new Brick(), 5308, 198);
        addObject(new Block(), 5260, 100);
        addObject(new Ghoomba(), 5100, 358);
    }

    /**
     * Adds all the objects for area seven of the world
     */
    private void areaSeven()
    {
        addObject(new MagiKoopa(), 5500, 358);
        addObject(new Brick(), 5700, 358);
        addObject(new Brick(), 5700, 326);
        addObject(new Brick(), 5700, 294);

        addObject(new Brick(), 5700, 0);
        addObject(new Brick(), 5700, 32);
        addObject(new Brick(), 5700, 64);
        addObject(new Brick(), 5700, 96);
        addObject(new Brick(), 5700, 128);
        addObject(new Brick(), 5700, 160);
        addObject(new Brick(), 5700, 192);

        addObject(new Brick(), 6000, 358);
        addObject(new Brick(), 6000, 326);
        addObject(new FireFlower(), 6000, 294);

        addObject(new Block(), 6270, 290);
    }

    /**
     * Adds all the objects for area eight of the world
     */
    private void areaEight()
    {
        addObject(new Brick(), 6768, 248);
        addObject(new LongBrick(), 6800, 280);
        addObject(new LongBrick(), 6960, 280);
        addObject(new Brick(), 7040, 0);
        addObject(new Brick(), 7040, 32);
        addObject(new Brick(), 7040, 64);
        addObject(new Brick(), 7040, 96);
        addObject(new Brick(), 7040, 128);
        addObject(new Brick(), 7040, 160);
        addObject(new Brick(), 7040, 192);
        addObject(new Brick(), 7040, 224);
        addObject(new Brick(), 7040, 256);
        addObject(new Brick(), 7040, 280);
        addObject(new Block(), 6960, 190);
        addObject(new MagiKoopa(), 6960, 243);

        addObject(new Block(), 7200, 290);
        addObject(new Black(), 7150, -200);
        addObject(new Pole(), 7400, 252);

    }
}
