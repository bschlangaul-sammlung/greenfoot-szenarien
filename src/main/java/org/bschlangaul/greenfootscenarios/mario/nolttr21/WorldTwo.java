import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Skyworld
 * 
 * @author (Dylan Powell and Sean Eastley) 
 * @version (January 21, 2015)
 */
public class WorldTwo extends SWorld
{
    private ScoreBoard scoreBoard;
    static GreenfootSound music = new GreenfootSound("1.mp3");
    static GreenfootSound start = new GreenfootSound("Stage.wav");
    private boolean playing = false; //determines if the music is playing or not
    public static boolean flag = false;
    /**
     * Constructs world two
     */
    public WorldTwo()
    {    
        super(700, 400, 1, 8285);
        WorldN.world = 2;
        StatT.time = 0;
        StatE.kills = 0;

        // setPaintOrder(LiveText.class,LiveImage.class,Intro2.class);
        GreenfootImage bg = new GreenfootImage("clouds.jpg");
        setScrollingBackground(bg);
        if(!music.isPlaying() && playing == false)
        {
            music.playLoop();
            playing = true;
            music.setVolume(100);
        }
        buildWorld();
        if(!start.isPlaying())
        {
            start.play();
        }
        SWorld.time = 100;
        LiveImage liveimage = new LiveImage();
        addObject(liveimage,245,271);
        LiveText livetext = new LiveText();
        addObject(livetext,369,289);
        liveimage.setLocation(313,268);
        liveimage.setLocation(292,269);
        livetext.setLocation(368,270);
        
        Intro2 intro = new Intro2();
        addObject(intro, 350,200);
        intro.setLocation(351,200);
    }

    /**
     * Stops the music when called
     */
    public void stopMusic()
    {
        music.stop();
    }

    /**
     * Updates the scoreboard in the world
     */
    public void updateScoreboard()
    {
        scoreBoard.updateScore(lives, ammunition);
    }

    /**
     * When called, removes all objects in the world and rebuilds it.
     * If lives are less than 0, the world is set to the game over world.
     */
    public void rebuildWorld()
    {
        ammunition = 0;
        music.playLoop();

        removeObjects(getObjects(null));
        buildWorld();
        decreaseLives();
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
        addObject(scoreBoard, 30, 15, false);
        scoreBoard.updateScore(lives, ammunition);
    }

    /**
     * Adds all the objects to the world
     */
    private void buildWorld()
    {   

        addObject(new Ground(), 0, 390);

        addObject(new Brick(), 332, 290);
        addObject(new Brick(), 364, 290);
        addObject(new Brick(), 396, 290);

        addObject(new Brick(), 464, 200);
        addObject(new Brick(), 496, 200);
        addObject(new Brick(), 528, 200);

        addObject(new Brick(), 600, 100);
        addObject(new Brick(), 632, 100);
        addObject(new Brick(), 664, 100);

        
        addObject(new VerPlatform(), 750, 125);
        addObject(new HorPlatform(), 850, 200);
        addObject(new VerPlatform(), 1150, 150);

        addObject(new Brick(), 1314, 100);
        addObject(new Brick(), 1346, 100);
        addObject(new Brick(), 1378, 100);

        addObject(new Ground(), 1735, 150);
        addObject(new Brick(), 1450, 118);
        addObject(new Ghoomba(), 1550, 118);
        addObject(new Block(), 1719, 50);
        addObject(new Ghoomba(), 1700, 118);
        addObject(new Ghoomba(), 1920, 118);
        addObject(new Brick(), 2020, 118);

        addObject(new VerPlatform(), 2150, 200);
        addObject(new VerPlatform(), 2350, 200);
        addObject(new VerPlatform(), 2550, 200);
        addObject(new VerPlatform(), 2750, 200);
        addObject(new VerPlatform(), 2950, 200);

        addObject(new HorPlatform(), 3000, 250);
        addObject(new Brick(), 3200, 200);
        addObject(new Brick(), 3232, 200);

        addObject(new Brick(), 3288, 150);
        addObject(new Brick(), 3320, 150);

        addObject(new Ground(), 3685, 100);
        addObject(new KoopaKid(), 3685, 68);
        addObject(new Brick(), 3400, 68);
        addObject(new Brick(), 3970, 68);
        addObject(new Brick(), 3717, 132);
        addObject(new Brick(), 3717, 164);
        addObject(new Brick(), 3717, 196);
        addObject(new Brick(), 3717, 228);
        addObject(new Brick(), 3717, 260);
        addObject(new Brick(), 3717, 292);
        addObject(new Brick(), 3717, 324);
        addObject(new Brick(), 3717, 356);
        addObject(new Brick(), 3717, 388);

        addObject(new HorPlatform(), 4200, 350);

        addObject(new Brick(), 4432, 360);
        addObject(new Brick(), 4464, 360);

        addObject(new HorPlatform(), 4600, 350);

        addObject(new Brick(), 4832, 360);
        addObject(new Brick(), 4864, 360);
        addObject(new Cannon(), 4848, 318);

        addObject(new HorPlatform(), 5000, 350);

        addObject(new VerPlatform(), 5250, 175);

        if (flag)
        {
            if (marioGun == true)
            {
                addMainActor(new MarioG(), 5432, 0, 250, 300);
            }
            if (marioBig == true)
            {
                addMainActor(new Mario(), 5432, 0, 250, 300);
            }
            if (marioSmall == true)
            {
                addMainActor(new MarioS(), 5432, 0, 250, 300);
            }
        }
        addObject(new Brick(), 5400, 175);
        addObject(new Brick(), 5432, 175);
        addObject(new Brick(), 5464, 175);

        addObject(new Brick(), 5496, 175);
        addObject(new Brick(), 5528, 175);

        addObject(new Brick(), 5600, 290);
        addObject(new Brick(), 5632, 290);
        if (!flag) addObject(new CheckPointD(),5632,250);
        else addObject(new CheckPointA(),5632,250);
        addObject(new Brick(), 5664, 290);

        addObject(new Brick(), 5800, 180);
        addObject(new Brick(), 5832, 180);
        addObject(new Block(), 5832, 80);
        addObject(new Brick(), 5864, 180);

        addObject(new Brick(), 5800, 380);
        addObject(new Brick(), 5832, 380);
        addObject(new Brick(), 5864, 380);

        addObject(new VerPlatform(), 6000, 200);

        addObject(new Brick(), 6200, 192);
        addObject(new Brick(), 6232, 192);
        addObject(new Brick(), 6264, 192);
        addObject(new Brick(), 6296, 192);
        addObject(new Brick(), 6322, 192);

        addObject(new Brick(), 6410, 192);
        addObject(new Brick(), 6410, 160);
        addObject(new Brick(), 6410, 128);
        addObject(new Brick(), 6410, 96);
        addObject(new Brick(), 6410, 64);
        addObject(new Brick(), 6410, 32);
        addObject(new Brick(), 6410, 0);

        addObject(new HorPlatform(), 6300, 380);

        addObject(new VerPlatform(), 6550, 200);

        addObject(new Brick(), 6700, 150);
        addObject(new Brick(), 6700, 342);
        addObject(new Brick(), 6732, 150);
        addObject(new Brick(), 6764, 150);
        addObject(new Brick(), 6796, 150);
        addObject(new Brick(), 6828, 150);
        addObject(new Brick(), 6860, 150);
        addObject(new Brick(), 6892, 150);
        addObject(new Brick(), 6924, 150);
        addObject(new Brick(), 6924, 182);
        addObject(new Brick(), 6924, 214);
        addObject(new Brick(), 6924, 246);
        addObject(new Brick(), 6924, 278);
        addObject(new Brick(), 6924, 310);
        addObject(new Brick(), 6924, 342);
        addObject(new Brick(), 6924, 374);
        addObject(new Brick(), 6892, 374);
        addObject(new Brick(), 6700, 374);
        addObject(new Brick(), 6732, 374);
        addObject(new Brick(), 6764, 374);
        addObject(new Brick(), 6796, 374);
        addObject(new Brick(), 6828, 374);
        addObject(new Brick(), 6860, 374);
        addObject(new Block(), 6800, 270);
        addObject(new MagiKoopa(), 6800, 337);

        addObject(new HorPlatform(), 7100, 300);

        addObject(new HorPlatform(), 7300, 300);

        addObject(new VerPlatform(), 7600, 200);

        addObject(new Ground(), 8000, 390);

        addObject(new Brick(), 7968, 290);
        addObject(new Block(), 8000, 290);
        addObject(new Brick(), 8032, 290);

        addObject(new Ground(), 8100, 390);

        addObject(new Pole(), 8200, 252);

        addScoreboard();
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

        SWorld.time = 100;
        LiveImage liveimage = new LiveImage();
        addObject(liveimage,245,271);
        LiveText livetext = new LiveText();
        addObject(livetext,369,289);
        liveimage.setLocation(313,268);
        liveimage.setLocation(292,269);
        livetext.setLocation(368,270);
        addObject(new Intro2(), 350,200);
        addObject(new Black(),7935,-200);
    }
}
