package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; 

/**
 * Write a description of class Map here.
 *
 */
public class Map extends SWorld
{
    public static GreenfootSound map = new GreenfootSound("map.mp3");
    public static int clears = 0;
    public int at = 0;
    public static boolean air = false;
    public static boolean unlocked = false;
    public boolean gotKey = false;
    public boolean switched = false;
    public static boolean firstInit = true;


    /**
     *
     * Constructor for objects of class Map.
     *
     */
    public Map(int LevelsCleared, int LevelAt, boolean clear)
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 400, 1, 700);
        // Greenfoot.stop();
        if (firstInit)
            clears = 0;
        firstInit = false;
        addObject(new Fader(250, true, false), 350, 200);

        setPaintOrder(Fader.class, Key2.class, Key.class);
        if ((LevelsCleared > clears) && clear)
        {
            clears = LevelsCleared;
        }
        setBackground("map.png");
        at = LevelAt;
        start();

        if (!clear)
        {
            decreaseLives();

        }

        if (LevelAt == 3 && clear)
        {
            MapMario.doKey = true;
        }

        // prepare();

        prepare();
    }

    public Map(boolean Airship)
    {
        super(700, 400, 1, 700);

        if (!Airship)
        {
            decreaseLives();
        }

        switched = true;
        Greenfoot.delay(1);
        setBackground("MapAir.png");
        air = true;
        addObject(new Fader(250, true, false), 350, 200);
        addObject(new MapMario(), 37, 217);
        addObject(new A(), 375, 219);
        setPaintOrder(Fader.class, Key2.class, Key.class);
        addObject(new Ball(), 370, 300);
        addObject(new MapAirship(), 350, 300);
        MapMario.right = true;
    }

    public Map()
    {
        super(700, 400, 1, 700);
        // start();
    }

    public void start()
    {

        if (!unlocked)
        {

        }
    }

    public void act()
    {
        // if(getBackground() == null)
        // Greenfoot.delay(10);
        if (lives < 0)
        {
            Greenfoot.setWorld(new GameOver());
        }

        if (air && !switched)
        {

            Greenfoot.setWorld(new Map(true));
        }
        map.play();
    }

    public int clears()
    {
        return clears;
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial objects and add
     * them to the world.
     */
    private void prepare()
    {
        switch (at)
        {
            case 1:
                addObject(new MapMario(), 193, 45);
                break;
            case 2:
                addObject(new MapMario(), 362, 45);
                break;
            case 3:
                addObject(new MapMario(), 195, 211);
                break;
            case 4:
                addObject(new MapMario(), 527, 378);
                break;
            case 5:
                addObject(new MapMario(), 665, 45);
                break;
            default:
                MapMario mapmario = new MapMario();
                addObject(mapmario, 28, 45);
                mapmario.setLocation(25, 40);
                break;
        }

        Start start = new Start();
        addObject(start, 28, 45);
        start.setLocation(25, 45);

        Two two = new Two();
        addObject(two, 362, 45);

        Coin5 coin5 = new Coin5();
        addObject(coin5, 361, 217);
        coin5.setLocation(362, 211);

        Coin6 coin6 = new Coin6();
        addObject(coin6, 527, 212);
        coin6.setLocation(527, 210);

        Coin7 coin7 = new Coin7();
        addObject(coin7, 663, 213);
        coin7.setLocation(663, 210);

        C c = new C();
        addObject(c, 665, 45);

        Coin1 coin1 = new Coin1();
        addObject(coin1, 28, 215);
        coin1.setLocation(24, 210);

        Coin2 coin2 = new Coin2();
        addObject(coin2, 26, 383);
        coin2.setLocation(22, 378);

        F f = new F();
        addObject(f, 195, 211);

        Coin3 coin3 = new Coin3();
        addObject(coin3, 189, 385);
        coin3.setLocation(184, 378);

        One one = new One();
        addObject(one, 193, 45);

        Coin4 coin4 = new Coin4();
        addObject(coin4, 362, 378);

        Three three = new Three();
        addObject(three, 527, 378);

        if (!unlocked)
        {
            Door door = new Door();
            addObject(door, 366, 264);
            door.setLocation(357, 254);
            Door door2 = new Door();
            addObject(door2, 30, 90);
            door2.setLocation(24, 84);
        }
    }
}
