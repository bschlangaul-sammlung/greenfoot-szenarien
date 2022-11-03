package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;

/**
 * The final world with Bowser
 *
 * @author (Dylan Powell and Sean Eastley)
 * @version (January 21, 2015)
 */
public class BossWorld extends SWorld
{
    private ScoreBoard scoreBoard;
    private BowserLife bowserLife;

    private int hits; // defines how much health to display for bowser
    static GreenfootSound win = new GreenfootSound("Down.mp3");
    static GreenfootSound music = new GreenfootSound("boom.mp3");
    LongBrick l1 = new LongBrick();
    LongBrick l2 = new LongBrick();
    LongBrick l3 = new LongBrick();
    public boolean gameWon = false;

    /**
     * Calls the methods to construct BossWorld
     */
    public BossWorld()
    {
        super(700, 400, 1, 700);
        // setPaintOrder(LiveText.class,LiveImage.class,Intro5.class);
        buildWorld();


        gameWon = false;
        addScoreboards();
        updateScoreboard();
        hits = 40;
        // Bowser.fall = false;
        WorldN.world = 5;
        if (!music.isPlaying())
        {
            music.playLoop();
        }
        SWorld.time = 100;
        LiveImage liveimage = new LiveImage();
        addObject(liveimage, 245, 271);
        LiveText livetext = new LiveText();
        addObject(livetext, 369, 289);
        liveimage.setLocation(313, 268);
        liveimage.setLocation(292, 269);
        livetext.setLocation(368, 270);
        addObject(new Intro5(), 350, 200);
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
        addObject(new Block(), 32, 275);
        addObject(new Block(), 64, 275);

        addObject(new Bowser(), 600, 329);

        addObject(new LongBrick(), -80, 390);
        addObject(new LongBrick(), 80, 390);
        // LongBrick l1 = new LongBrick();
        addObject(l1, 240, 390);
        // LongBrick l2 = new LongBrick();
        addObject(l2, 400, 390);
        // LongBrick l3 = new LongBrick();
        addObject(l3, 560, 390);
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
        // LiveImage liveimage = new LiveImage();
        // addObject(liveimage,245,271);
        // LiveText livetext = new LiveText();
        // addObject(livetext,369,289);
        // liveimage.setLocation(313,268);
        // liveimage.setLocation(292,269);
        // livetext.setLocation(368,270);
        // addObject(new Intro5(), 350,200);

    }

    /**
     * When called, will reset the ammo and make a new WorldFour
     */
    public void rebuildWorld()
    {
        // ammunition = 0;
        // decreaseLives();
        // Greenfoot.setWorld(new WorldFour());
    }

    /**
     * Updates the scoreboards when called
     */
    public void updateScoreboard()
    {
        scoreBoard.updateScore(lives, ammunition);
        bowserLife.updateScore(hits);
    }

    /**
     * Decreases the amount of health bowser has
     */
    public void decreaseHits()
    {
        hits = hits - 1;
        updateScoreboard();
    }

    /**
     * Adds in peach and plays music for winning the game
     */
    public void gameWon()
    {
        if (getObjects(Dummy.class).isEmpty())
        {
            // music.stop();

            // removeObject(bowserLife);
            // // removeObjects(getObjects(Bowser.class));
            // // Greenfoot.delay(500);
            // if(!win.isPlaying())
            // {
            // // Greenfoot.playSound("almost.mp3");
            // // addObject(new Dummy(),650,0);
            // }
        }
        removeObject(l1);
        // Greenfoot.delay(5);
        removeObject(l2);

        // Greenfoot.delay(5);
        removeObject(l3);
        Bowser.part++;
    }

    /**
     * Adds the scoreboards to the world
     */
    private void addScoreboards()
    {
        scoreBoard = new ScoreBoard();
        addObject(scoreBoard, 30, 15, false);
        // scoreBoard.updateScore(lives, ammunition);
        addObject(new P2(), 650, 375);
        bowserLife = new BowserLife();
        addObject(bowserLife, 350, 15, false);
        bowserLife.updateScore(hits);
        removeObject(bowserLife);

    }

    public void play()
    {
        // win.play();
    }
}
