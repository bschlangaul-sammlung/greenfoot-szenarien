package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The final world with Bowser
 *
 * @author (Dylan Powell and Sean Eastley)
 * @version (January 21, 2015)
 */
public class BossWorld2 extends SWorld
{
    private ScoreBoard scoreBoard;
    // private BowserLife bowserLife;
    private int hits; // defines how much health to display for bowser
    // GreenfootSound win = new GreenfootSound("Won.wav");
    static GreenfootSound music = new GreenfootSound("boss2.mp3");

    /**
     * Calls the methods to construct BossWorld2
     */
    public BossWorld2()
    {
        super(700, 400, 1, 700);
        setPaintOrder(LiveText.class, LiveImage.class, Intro6.class, Block.class);
        buildWorld();
        addScoreboards();
        updateScoreboard();
        // hits = 50;
        if (!music.isPlaying())
        {
            music.playLoop();
        }
        prepare();
        SWorld.time = 100;
        LiveImage liveimage = new LiveImage();
        addObject(liveimage, 245, 271);
        LiveText livetext = new LiveText();
        addObject(livetext, 369, 289);
        liveimage.setLocation(313, 268);
        liveimage.setLocation(292, 269);
        livetext.setLocation(368, 270);
        addObject(new Intro6(), 350, 200);
        addObject(new Block(), 32, 275);
        addObject(new Block(), 64, 275);
    }

    /**
     * When called, stops the music
     */
    public void stopMusic()
    {
        music.stop();

    }

    /**
     * Will build the world with the appropriate mario and call the method to add the scoreboards
     */
    private void buildWorld()
    {
        if (marioGun == true)
        {
            addMainActor(new MarioG(), 50, 0, 250, 300);
        }
        if (marioBig == true)
        {
            addMainActor(new Mario(), 50, 0, 250, 300);
        }
        if (marioSmall == true)
        {
            addMainActor(new MarioS(), 50, 0, 250, 300);
        }

        addObject(new Bowserjr(), 600, 100);

        addObject(new LongBrick(), -80, 390);
        addObject(new LongBrick(), 80, 390);
        addObject(new LongBrick(), 240, 390);
        addObject(new LongBrick(), 400, 390);
        addObject(new LongBrick(), 560, 390);
        addObject(new LongBrick(), 720, 390);
        addObject(new Brick(), 700, 358);
        addObject(new Brick(), 700, 326);
        addObject(new Brick(), 700, 294);
        addObject(new Brick(), 700, 262);
        addObject(new Brick(), 700, 230);
        addObject(new Brick(), 700, 198);
        addObject(new Brick(), 700, 166);
        addObject(new Brick(), 700, 134);
        addObject(new Brick(), 700, 102);
        addObject(new Brick(), 700, 70);
        addObject(new Brick(), 700, 38);
        addObject(new Brick(), 700, 6);
        addObject(new Brick(), 0, 358);
        addObject(new Brick(), 0, 326);
        addObject(new Brick(), 0, 294);
        addObject(new Brick(), 0, 262);
        addObject(new Brick(), 0, 230);
        addObject(new Brick(), 0, 198);
        addObject(new Brick(), 0, 166);
        addObject(new Brick(), 0, 134);
        addObject(new Brick(), 0, 102);
        addObject(new Brick(), 0, 70);
        addObject(new Brick(), 0, 38);
        addObject(new Brick(), 0, 6);
        SWorld.time = 100;
        LiveImage liveimage = new LiveImage();
        addObject(liveimage, 245, 271);
        LiveText livetext = new LiveText();
        addObject(livetext, 369, 289);
        liveimage.setLocation(313, 268);
        liveimage.setLocation(292, 269);
        livetext.setLocation(368, 270);
        addObject(new Intro6(), 350, 200);
    }

    /**
     * When called, will reset the ammo and make a new WorldFour
     */
    public void rebuildWorld()
    {
        // ammunition = 0;

        music.playLoop();

        removeObjects(getObjects(null));
        buildWorld();

        decreaseLives();


    }

    /**
     * Updates the scoreboards when called
     */
    public void updateScoreboard()
    {
        scoreBoard.updateScore(lives, ammunition);
        // bowserLife.updateScore(hits);
    }

    /**
     * Adds the scoreboards to the world
     */
    private void addScoreboards()
    {
        scoreBoard = new ScoreBoard();
        addObject(scoreBoard, 30, 15, false);

    }

    /**
     * Prepare the world for the start of the program. That is: create the initial objects and add
     * them to the world.
     */
    private void prepare()
    {
        P p = new P();
        addObject(p, 662, 356);
        p.setLocation(657, 351);
        p.setLocation(639, 360);
        Cannon2 cannon2 = new Cannon2();
        addObject(cannon2, 339, 353);
        cannon2.setLocation(339, 360);
        turner turner = new turner();
        addObject(turner, 44, 90);
        turner turner2 = new turner();
        addObject(turner2, 664, 110);
    }
}
