package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Platforms, ground and holes
 * 
 * @author (Dylan Powell and Sean Eastley) 
 * @version (January 29, 2015)
 */
public class MyWorld extends SWorld
{
    private ScoreBoard scoreBoard;
    public int maxX;
    public static boolean flag = false;
    static GreenfootSound theme = new GreenfootSound("1.mp3");
    static GreenfootSound start = new GreenfootSound("Stage.wav");
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(700, 400, 1, 6350,401);
        justInit = true;
        StatT.time = 0;
        StatE.kills = 0;

        WorldN.world = 1;
        addObject(new Intro1(), 350,200);
        maxX = 6350;
        // setBackground("dsjkh.mod");
        GreenfootImage bg = new GreenfootImage("mariobackground.jpg");
        setScrollingBackground(bg);
        // ammunition = 0;
        // marioSmall = true;
        // if (!theme.isPl9aying())
        {
            theme.playLoop();
        }
        rebuildWorld();
        
        
        if(!start.isPlaying())
        {
            start.play();
        }

        prepare();
    }
    
    /**
     * When called, removes all objects in the world and rebuilds it.
     * If lives are less than 0, the world is set to the game over world.
     */
    public void rebuildWorld()
    {
        // decreaseLives();
        // Greenfoot.start();
        // if (lives < 0)
        // {
            // stopMusic();
            // Greenfoot.setWorld(new GameOver());
        // }

        // ammunition = 0;
        // addObject(new LongBrick(),0,200);
       
        // Greenfoot.delay(17);
        buildWorld();
        
        LiveImage liveimage = new LiveImage();
        addObject(liveimage,245,271);
        LiveText livetext = new LiveText();
        addObject(livetext,369,289);
        liveimage.setLocation(313,268);
        liveimage.setLocation(292,269);
        livetext.setLocation(368,270);
        
        Intro1 intro = new Intro1();
        addObject(intro, 350,200);
        intro.setLocation(351,200);
        
        addObject(new Black(),6000,-200);
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
     * Calls all the methods to add the objects to the world
     */
    private void buildWorld()
    {
        startingArea();
        areaTwo();
        areaThree();
        areaFour();
        areaFive();
        areaSix();
        endingArea();
        addScoreboard();
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
     * Adds all the objects for the first area of the world
     */
    private void startingArea()
    {
        if (!flag)
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
                addMainActor(new MarioS(), 50, 200, 250, 300);
            }
        }
        
        addObject(new LongBrick(),0,125);
        addObject(new Ground(), 100, 390);
        addObject(new Ground(), 300, 390);
        addObject(new Ghoomba(), 182, 358);
        addObject(new Ghoomba(), 332, 358);

        addObject(new Brick(), 150, 290);
        addObject(new Block(), 182, 290);
        addObject(new Brick(), 214, 290);
        addObject(new Brick(), 225, 170);
        addObject(new Block(), 257, 170);
        addObject(new Brick(), 289, 170);
        addObject(new Brick(), 300, 290);
        addObject(new Block(), 332, 290);
        addObject(new Brick(), 364, 290);

        addObject(new Brick(), 456, 358);
        addObject(new Brick(), 488, 358);
        addObject(new Brick(), 520, 358);
        addObject(new Brick(), 552, 358);
        addObject(new Brick(), 584, 358);
        addObject(new Brick(), 488, 326);
        addObject(new Brick(), 520, 326);
        addObject(new Brick(), 552, 326);
        addObject(new Brick(), 584, 326);
        addObject(new Brick(), 520, 294);
        addObject(new Brick(), 552, 294);
        addObject(new Brick(), 584, 294);
        addObject(new Brick(), 552, 262);
        addObject(new Brick(), 584, 262);
        addObject(new Brick(), 584, 230);
    }

    /**
     * Adds all the objects for area two of the world
     */
    private void areaTwo()
    {
        addObject(new Ground(), 1100, 390);

        addObject(new Brick(), 950, 358);
        addObject(new Brick(), 950, 326);
        addObject(new Brick(), 950, 294);

        addObject(new Ghoomba(), 1050, 358);
        addObject(new Ghoomba(), 1200, 358);

        addObject(new Brick(), 1050, 170);
        addObject(new Block(), 1125, 294);
        addObject(new Brick(), 1200, 170);

        addObject(new Brick(), 1300, 358);
        addObject(new Brick(), 1300, 326);
        addObject(new Brick(), 1300, 294);
    }

    /**
     * Adds all the objects for area three of the world
     */
    private void areaThree()
    {
        addObject(new Brick(), 1500, 294);

        addObject(new Ground(), 1900, 390);

        addObject(new Brick(), 1615, 358);

        addObject(new Block(), 1868, 290);
        addObject(new Brick(), 1900, 290);
        addObject(new Block(), 1932, 290);

        addObject(new Ghoomba(), 1800, 358);
        addObject(new HammerBro(), 2000, 358);

        addObject(new Brick(), 2185, 358);
    }    

    /**
     * Adds all the objects for area four of the world
     */
    private void areaFour()
    {
        addObject(new Ground(), 2632, 390);
        addObject(new Ground(), 3200, 390);

        addObject(new Brick(), 2347, 358);

        addObject(new Brick(), 2550, 290);
        addObject(new Brick(), 2582, 290);
        addObject(new Brick(), 2614, 290);
        addObject(new Brick(), 2646, 290);
        addObject(new Brick(), 2678, 290);
        addObject(new Brick(), 2710, 290);
        addObject(new Brick(), 2742, 290);
        addObject(new Brick(), 2742, 258);
        addObject(new Brick(), 2550, 258);
        addObject(new Brick(), 2550, 226);
        addObject(new Brick(), 2550, 194);
        addObject(new Brick(), 2550, 162);
        addObject(new Brick(), 2550, 130);
        addObject(new Brick(), 2550, 98);
        addObject(new Brick(), 2550, 66);
        addObject(new Brick(), 2582, 66);
        addObject(new Brick(), 2614, 66);
        addObject(new Brick(), 2646, 66);
        addObject(new Brick(), 2678, 66);
        addObject(new Brick(), 2710, 66);
        addObject(new Brick(), 2742, 66);
        addObject(new Brick(), 2742, 258);
        addObject(new Block(), 2630, 162);
        addObject(new Block(), 2662, 162);
        addObject(new Ghoomba(), 2582, 258);
        addObject(new Ghoomba(), 2710, 258);

        addObject(new KoopaKid(), 2700, 358);

        addObject(new Brick(), 2840, 290);
        addObject(new Brick(), 2872, 290);

        addObject(new Brick(), 3000, 358);
        addObject(new Brick(), 3000, 326);
        addObject(new Brick(), 3000, 294);

        addObject (new HammerBro(), 3100, 358);

        addObject(new Brick(), 3485, 358);
        addObject(new Brick(), 3485, 326);
        addObject(new Brick(), 3485, 294);
        addObject(new Brick(), 3453, 358);
        addObject(new Brick(), 3453, 326);
        addObject(new Brick(), 3421, 358);
    } 

    /**
     * Adds all the objects for area five of the world
     */
    private void areaFive()
    {
        if (flag)
        {
            if (marioGun == true)
            {
                addMainActor(new MarioG(), 3665, 0, 250, 300);
            }
            if (marioBig == true)
            {
                addMainActor(new Mario(), 3665, 0, 250, 300);
            }
            if (marioSmall == true)
            {
                addMainActor(new MarioS(), 3665, 200, 250, 300);
            }
        }

        addObject(new Ground(), 3950, 390);
        addObject(new Ground(), 4244, 390);

        addObject(new Brick(), 3665, 358);
        addObject(new Brick(), 3665, 326);
        addObject(new Brick(), 3665, 294);
        addObject(new Brick(), 3697, 358);
        addObject(new Brick(), 3697, 326);
        addObject(new Brick(), 3729, 358);

        addObject(new KoopaKid(), 3950, 358);

        addObject(new Block(), 3929, 290);

        addObject(new Brick(), 4129, 358);
        addObject(new Brick(), 4129, 326);
        addObject(new Brick(), 4129, 294);

        addObject(new Brick(), 4129, 0);
        addObject(new Brick(), 4129, 32);
        addObject(new Brick(), 4129, 64);
        addObject(new Brick(), 4129, 96);
        addObject(new Brick(), 4129, 128);
        addObject(new Brick(), 4129, 160);
        addObject(new Brick(), 4129, 192);

        if (!flag)addObject(new CheckPointD(), 4129, 254);
        else addObject(new CheckPointA(), 4129, 254);

        addObject(new Ghoomba(), 4200, 358);
        addObject(new Ghoomba(), 4300, 358);
        addObject(new Ghoomba(), 4400, 358);
        addObject(new Ghoomba(), 4495, 358);
        addObject(new Block(), 4329, 290);

        addObject(new Brick(), 4529, 358);
        addObject(new Brick(), 4529, 326);
        addObject(new Brick(), 4529, 294);
    }    

    /**
     * Adds all the objects for area six of the world
     */
    private void areaSix()
    {
        addObject(new Ground(), 5000, 390);
        addObject(new Ground(), 5315, 390);

        addObject(new Brick(), 4865, 358);
        addObject(new Brick(), 4865, 326);
        addObject(new FireFlower(), 4865, 298);

        addObject(new Brick(), 5155, 358);
        addObject(new Brick(), 5155, 326);
        addObject(new FireFlower(), 5155, 298);

        addObject(new Brick(), 5450, 358);
        addObject(new Brick(), 5450, 326);
        addObject(new FireFlower(), 5450, 298);
    }  

    /**
     * 
     * Adds all the objects for the last area of the world
     */
    private void endingArea()
    {
        addObject(new Ground(), 6065, 390);
        addObject(new Ground(), 6200, 390);

        addObject(new Block(), 6049, 290);
        addObject(new Block(), 6081, 290);

        addObject(new Pole(), 6280, 252);

    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        LiveImage liveimage = new LiveImage();
        addObject(liveimage,245,271);
        LiveText livetext = new LiveText();
        addObject(livetext,369,289);
        liveimage.setLocation(313,268);
        liveimage.setLocation(292,269);
        livetext.setLocation(368,270);
    }

    public int MaxX()
    {
        return maxX;
    }

    public void stopped()
    {
        // getObjects(Bowser.class).get(1);
        
    }

    public void hitwall1()
    {

    }
}
