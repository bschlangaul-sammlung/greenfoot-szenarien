import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Castle level
 * 
 * @author (Dylan Powell and Sean Eastley) 
 * @version (January 21, 2015)
 */
public class Fortress extends SWorld
{
    private ScoreBoard scoreBoard;
    public static boolean flag = false;
    static GreenfootSound music = new GreenfootSound("4.mp3");
    static GreenfootSound start = new GreenfootSound("Stage.wav");
    /**
     * Constructs world four
     */
    public Fortress()
    {    
        super(700, 400, 1, 5240);
        // setPaintOrder(LiveText.class,LiveImage.class,Intro4.class);
        GreenfootImage bg = new GreenfootImage("World4Bg.jpg");
        setScrollingBackground(bg,1);
        buildWorld();
        WorldN.world = 4;
        if(!music.isPlaying())
        {
            music.playLoop();
        }
        if(!start.isPlaying())
        {
            start.play();
        }
        if (lives < 0)
        {
            stopMusic();
            Greenfoot.setWorld(new GameOver());
        }
        SWorld.time = 100;
        LiveImage liveimage = new LiveImage();
        addObject(liveimage,245,271);
        LiveText livetext = new LiveText();
        addObject(livetext,369,289);
        liveimage.setLocation(313,268);
        liveimage.setLocation(292,269);
        livetext.setLocation(368,270);
        addObject(new Intro4(), 350,200);
    }

    /**
     * Stops the music when called
     */
    public void stopMusic()
    {
        music.stop();
    }

    /**
     * When called, removes all objects in the world and rebuilds it.
     * If lives are less than 0, the world is set to the game over world.
     */
    public void rebuildWorld()
    {
        // ammunition = 0;
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
     * Updates the scoreboard in the world
     */
    public void updateScoreboard()
    {
        scoreBoard.updateScore(lives, ammunition);
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
     * Adds all the objects to the world
     */
    private void buildWorld()
    {
        if (!flag)
        {
            if (marioGun == true)
            {
                addMainActor(new MarioG(), 50, 352, 250, 300); // the last two int parameters are centered window x and y ranges
            }
            if (marioBig == true)
            {
                addMainActor(new Mario(), 50, 352, 250, 300); // the last two int parameters are centered window x and y ranges
            }
            if (marioSmall == true)
            {
                addMainActor(new MarioS(), 50, 352, 250, 300); // the last two int parameters are centered window x and y ranges
            }
        }
        top();
        addObject(new LongBrick(), 16, 390);
        addObject(new LongBrick(), 80, 390);
        addObject(new Block(), 200, 290);
        addObject(new Ghoomba(), 200, 358);
        addObject(new Ghoomba(), 300, 358);
        addObject(new LongBrick(), 240, 390);
        addObject(new LongBrick(), 400, 390);
        addObject(new LongBrick(), 400, 358);
        addObject(new LongBrick(), 560, 390);
        addObject(new LongBrick(), 560, 358);
        addObject(new LongBrick(), 560, 326);

        addObject(new jFireball(), 720, 391);
        addObject(new Lava(), 710, 390);
        addObject(new Lava(), 740, 390);

        addObject(new LongBrick(), 880, 390);
        addObject(new LongBrick(), 880, 358);
        addObject(new LongBrick(), 880, 326);

        addObject(new jFireball(), 1040, 391);
        addObject(new Lava(), 1030, 390);
        addObject(new Lava(), 1060, 390);

        addObject(new LongBrick(), 1200, 390);
        addObject(new LongBrick(), 1200, 358);
        addObject(new LongBrick(), 1200, 326);

        addObject(new LongBrick(), 1360, 390);
        addObject(new LongBrick(), 1520, 390);
        addObject(new LongBrick(), 1680, 390);

        addObject(new MagiKoopa(), 1400, 353);
        addObject(new MagiKoopa(), 1600, 353);

        addObject(new LongBrick(), 1840, 390);
        addObject(new Brick(), 1776, 358);
        addObject(new Brick(), 1808, 358);
        addObject(new Brick(), 1840, 358);
        addObject(new Brick(), 1872, 358);
        addObject(new Brick(), 1904, 358);

        // addObject(new LongBrick(), 1840, 326);

        addObject(new Brick(), 1776, 326);
        addObject(new Brick(), 1808, 326);
        addObject(new Brick(), 1840, 326);
        addObject(new Brick(), 1872, 326);
        addObject(new Brick(), 1904, 326);

        addObject(new LongBrick(), 1840, 294);
        addObject(new LongBrick(), 2000, 390);
        addObject(new LongBrick(), 2000, 358);
        addObject(new LongBrick(), 2000, 326);
        addObject(new LongBrick(), 2000, 294);

        addObject(new LongBrick(), 2160, 390);

        addObject(new LongBrick(), 2320, 390);
        // addObject(new LongBrick(), 2320, 358);
        addObject(new Brick(), 2256, 358);
        addObject(new Brick(), 2288, 358);
        addObject(new Brick(), 2320, 358);
        addObject(new Brick(), 2352, 358);
        addObject(new Brick(), 2384, 358);

        
        // addObject(new LongBrick(), 2320, 326);
        addObject(new Brick(), 2256, 326);
        addObject(new Brick(), 2288, 326);
        addObject(new Brick(), 2320, 326);
        addObject(new Brick(), 2352, 326);
        addObject(new Brick(), 2384, 326);

        
        addObject(new LongBrick(), 2320, 294);
        addObject(new LongBrick(), 2480, 390);
        addObject(new LongBrick(), 2480, 358);
        addObject(new LongBrick(), 2480, 326);
        addObject(new LongBrick(), 2480, 294);

        addObject(new Cannon(), 2700, 252);
        addObject(new Brick(), 2732, 262);
        addObject(new Cannon(), 2732, 220);

        addObject(new LongBrick(), 2600, 390);
        addObject(new LongBrick(), 2600, 358);
        addObject(new LongBrick(), 2600, 326);
        addObject(new LongBrick(), 2600, 294);
        addObject(new LongBrick(), 2760, 390);
        addObject(new LongBrick(), 2760, 358);
        addObject(new LongBrick(), 2760, 326);
        addObject(new LongBrick(), 2760, 294);

        addObject(new jFireball(), 2948, 391);
        addObject(new Lava(), 2910, 390);
        addObject(new Lava(), 3000, 390);

        addObject(new LongBrick(), 3136, 390);
        addObject(new LongBrick(), 3136, 358);
        addObject(new LongBrick(), 3136, 326);
        addObject(new LongBrick(), 3200, 390);
        addObject(new LongBrick(), 3200, 358);
        addObject(new LongBrick(), 3200, 326);

        addObject(new jFireball(), 3375, 391);
        addObject(new jFireball(), 3375, 370);
        addObject(new Lava(), 3350, 390);
        addObject(new Lava(), 3450, 390);

        addObject(new LongBrick(), 3550, 390);
        addObject(new LongBrick(), 3550, 358);
        addObject(new LongBrick(), 3550, 326);

        addObject(new jFireball(), 3675, 391);
        addObject(new jFireball(), 3750, 391);
        addObject(new Lava(), 3700, 390);
        addObject(new Lava(), 3800, 390);

        addObject(new LongBrick(), 3900, 390);
        addObject(new LongBrick(), 3900, 358);
        addObject(new LongBrick(), 3900, 326);

        addObject(new jFireball(), 4070, 391);
        addObject(new Lava(), 4050, 390);
        addObject(new Lava(), 4150, 390);

        addObject(new LongBrick(), 4240, 390);
        addObject(new LongBrick(), 4240, 358);
        addObject(new LongBrick(), 4240, 326);

        addObject(new Brick(), 4320, 294);
        addObject(new Brick(), 4320, 262);
        addObject(new Block(), 4500, 230);

        addObject(new Cannon(), 5000, 284);

        addObject(new LongBrick(), 4360, 390);
        addObject(new LongBrick(), 4360, 358);
        addObject(new LongBrick(), 4360, 326);
        addObject(new LongBrick(), 4520, 390);
        addObject(new LongBrick(), 4520, 358);
        addObject(new LongBrick(), 4520, 326);
        addObject(new LongBrick(), 4680, 390);
        addObject(new LongBrick(), 4680, 358);
        addObject(new LongBrick(), 4680, 326);
        addObject(new LongBrick(), 4840, 390);
        addObject(new LongBrick(), 4840, 358);
        addObject(new LongBrick(), 4840, 326);
        addObject(new LongBrick(), 5000, 390);
        addObject(new LongBrick(), 5000, 358);
        addObject(new LongBrick(), 5000, 326);
        addObject(new LongBrick(), 5160, 390);
        addObject(new LongBrick(), 5160, 358);
        addObject(new LongBrick(), 5160, 326);
        addObject(new LongBrick(), 5224, 390);
        addObject(new LongBrick(), 5224, 358);
        addObject(new LongBrick(), 5224, 326);

        if (flag)
        {
            if (marioGun == true)
            {
                addMainActor(new MarioG(), 4800, 352, 250, 300); // the last two int parameters are centered window x and y ranges
            }
            if (marioBig == true)
            {
                addMainActor(new Mario(), 4800, 352, 250, 300); // the last two int parameters are centered window x and y ranges
            }
            if (marioSmall == true)
            {
                addMainActor(new MarioS(), 4800, 352, 250, 300); // the last two int parameters are centered window x and y ranges
            }
        }

        
        if (!flag)addObject(new CheckPointD(),4800,282);
        else addObject(new CheckPointA(),4800,282);
        addObject(new Pipe(), 5230, 278);

        
        
        addScoreboard();
        SWorld.time = 100;
        LiveImage liveimage = new LiveImage();
        addObject(liveimage,245,271);
        LiveText livetext = new LiveText();
        addObject(livetext,369,289);
        liveimage.setLocation(313,268);
        liveimage.setLocation(292,269);
        livetext.setLocation(368,270);
        addObject(new Intro4(), 350,200);
    }

    /**
     * Adds the bricks to the top of the world
     */
    private void top()
    {
        addObject(new LongBrick(), 80, 0);
        addObject(new LongBrick(), 240, 0);
        addObject(new LongBrick(), 80, 32);
        addObject(new LongBrick(), 240, 32);
        addObject(new LongBrick(), 80,64);
        addObject(new LongBrick(), 240, 64);
        addObject(new LongBrick(), 80, 96);
        addObject(new LongBrick(), 240, 96);
        addObject(new LongBrick(), 400, 0);
        addObject(new LongBrick(), 560, 0);
        addObject(new LongBrick(), 400, 32);
        addObject(new LongBrick(), 560, 32);
        addObject(new LongBrick(), 400, 64);
        addObject(new LongBrick(), 720, 0);
        addObject(new LongBrick(), 880, 0);
        addObject(new LongBrick(), 1040, 0);
        addObject(new LongBrick(), 1200, 0);
        addObject(new LongBrick(), 1360, 0);
        addObject(new LongBrick(), 1520, 0);
        addObject(new LongBrick(), 720, 32);
        addObject(new LongBrick(), 880, 32);
        addObject(new LongBrick(), 1040, 32);
        addObject(new LongBrick(), 1200, 32);
        addObject(new LongBrick(), 1360, 32);
        addObject(new LongBrick(), 1520, 32);
        addObject(new LongBrick(), 1360, 64);
        addObject(new LongBrick(), 1360, 96);
        addObject(new LongBrick(), 1520, 64);
        addObject(new LongBrick(), 1520, 96);
        addObject(new LongBrick(), 1680, 0);
        addObject(new LongBrick(), 1680, 32);
        addObject(new LongBrick(), 1680, 64);
        addObject(new LongBrick(), 1680, 96);
        addObject(new LongBrick(), 1360, 128);
        addObject(new LongBrick(), 1520, 128);
        addObject(new LongBrick(), 1680, 128);
        addObject(new LongBrick(), 1360, 160);
        addObject(new LongBrick(), 1520, 160);
        addObject(new LongBrick(), 1680, 160);
        addObject(new Brick(), 1520, 192);
        addObject(new Brick(), 1520, 224);
        addObject(new Brick(), 1520, 256);
        addObject(new Brick(), 1520, 288);
        addObject(new LongBrick(), 1840, 0);
        addObject(new LongBrick(), 1840, 32);
        addObject(new LongBrick(), 1840, 64);
        addObject(new LongBrick(), 1840, 96);
        addObject(new LongBrick(), 1840, 128);
        addObject(new LongBrick(), 1840, 160);
        addObject(new LongBrick(), 2000, 0);
        addObject(new LongBrick(), 2000, 32);
        addObject(new LongBrick(), 2000, 64);
        addObject(new LongBrick(), 2000, 96);
        addObject(new LongBrick(), 2000, 128);
        addObject(new LongBrick(), 2000, 160);
        addObject(new LongBrick(), 2160, 0);
        addObject(new LongBrick(), 2160, 32);
        addObject(new LongBrick(), 2160, 64);
        addObject(new LongBrick(), 2160, 96);
        addObject(new LongBrick(), 2160, 128);
        addObject(new LongBrick(), 2160, 160);
        addObject(new LongBrick(), 2320, 0);
        addObject(new LongBrick(), 2320, 32);
        addObject(new LongBrick(), 2320, 64);
        addObject(new LongBrick(), 2320, 96);
        addObject(new LongBrick(), 2320, 128);
        addObject(new LongBrick(), 2320, 160);
        addObject(new LongBrick(), 2480, 0);
        addObject(new LongBrick(), 2480, 32);
        addObject(new LongBrick(), 2480, 64);
        addObject(new LongBrick(), 2480, 96);
        addObject(new LongBrick(), 2480, 128);
        addObject(new LongBrick(), 2480, 160);
        addObject(new LongBrick(), 2640, 0);
        addObject(new LongBrick(), 2640, 32);
        addObject(new LongBrick(), 2800, 0);
        addObject(new LongBrick(), 2800, 32);
        addObject(new LongBrick(), 2960, 0);
        addObject(new LongBrick(), 2960, 32);
        addObject(new LongBrick(), 3120, 0);
        addObject(new LongBrick(), 3120, 32);
        addObject(new LongBrick(), 3280, 0);
        addObject(new LongBrick(), 3280, 32);
        addObject(new LongBrick(), 3440, 0);
        addObject(new LongBrick(), 3440, 32);
        addObject(new LongBrick(), 3600, 0);
        addObject(new LongBrick(), 3600, 32);
        addObject(new LongBrick(), 3760, 0);
        addObject(new LongBrick(), 3760, 32);
        addObject(new LongBrick(), 3920, 0);
        addObject(new LongBrick(), 3920, 32);
        addObject(new LongBrick(), 4080, 0);
        addObject(new LongBrick(), 4080, 32);
        addObject(new LongBrick(), 4240, 0);
        addObject(new LongBrick(), 4240, 32);
        addObject(new Brick(), 4320, 64);
        addObject(new Brick(), 4320, 96);
        addObject(new Brick(), 4320, 128);
        addObject(new Brick(), 4320, 160);
        addObject(new LongBrick(), 4360, 0);
        addObject(new LongBrick(), 4360, 32);
        addObject(new LongBrick(), 4520, 0);
        addObject(new LongBrick(), 4520, 32);
        addObject(new LongBrick(), 4680, 0);
        addObject(new LongBrick(), 4680, 32);
        addObject(new LongBrick(), 4840, 0);
        addObject(new LongBrick(), 4840, 32);
        addObject(new LongBrick(), 5000, 0);
        addObject(new LongBrick(), 5000, 32);
        addObject(new LongBrick(), 5160, 0);
        addObject(new LongBrick(), 5160, 32);
    }
}
