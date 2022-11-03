import greenfoot.*;


/**
 * SWorld scrolls its subworlds
 * @author (Dylan Powell, danpost, Sean Eastley) 
 * @version (January 21, 2015)
 */
public  class SWorld extends World
{
    private int scrollingWidth, scrollingHeight; //defines where the main actor can move in the universal coordinates
    private int actorMinX, actorMaxX, actorMinY, actorMaxY; //defines where the main actor can move in the world coordinates
    private int scrolledX, scrolledY; //how much the world has scrolled
    
    private int scrollType; //determines direction of scrolling
    Actor mainActor = null; //The actor the screen centers on
    
    private GreenfootImage background = null;
    static int ammunition = 0; //defines how much ammo the player has
    static int lives = 5; //defines how many lives the player has
    private ScoreBoard scoreBoard;
    public boolean marioL = false; //determines whether mario is moving left or right
    static boolean marioGun = false; //determines what kind of mario is in the world
    static boolean marioBig = false; //determines what kind of mario is in the world
    static boolean marioSmall = true; //determines what kind of mario is in the world
    public static int time = 100;
    public static int remove = 100;
    public boolean justInit = true;
    
    public int characterNum;
    public int characterMoved;
    /**
     * Defines the variables needed for creating the scrolling world
     */
    public SWorld(int wide, int high, int cellSize, int scrollWide, int scrollHigh)
    {
        super(cellSize==1?wide:(wide/2)*2+1, cellSize==1?high:(high/2)*2+1, cellSize, false);
        scrollType=(scrollWide>wide?1:0)+(scrollHigh>high?2:0);
        scrollingWidth=scrollType%2==1?scrollWide:wide;
        
        scrollingHeight=scrollType/2==1?scrollHigh:high;
                setPaintOrder(Fader.class,LiveText.class,LiveImage.class,Intros.class,Luigi.class,HasPassed.class,StatE.class,StatT.class,Procede.class,Black.class,AllMarios.class,Block.class);
    }

    /**
     * Makes the world a horizontal scroller
     */
    public SWorld(int wide, int high, int cellSize, int scrollWide)
    {
        this(wide, high, cellSize, scrollWide, high);
        
        setPaintOrder(Fader.class,LiveText.class,LiveImage.class,Intros.class,Luigi.class,HasPassed.class,StatE.class,StatT.class,Procede.class,Black.class,AllMarios.class,Block.class);
    }

    /**
     * This will set the appropriate variables for marioG existing
     */
    public void marioHasGun()
    {
        marioBig = false;
        marioSmall = false;
        marioGun = true;
    }

    /**
     * This will set the appropriate variables for mario existing
     */
    public void marioIsBig()
    {
        marioBig = true;
        marioSmall = false;
        marioGun = false;
    }

    /**
     * When called, makes the ammo value zero
     */
    public void resetAmmo()
    {

    }

    /**
     * This will set the appropriate variables for marioS existing
     */
    public void marioIsSmall()
    {
        marioBig = false;
        marioSmall = true;
        marioGun = false;
    }

    /**
     * When called, sets marioL to false
     */
    public void marioRight()
    {
        marioL = false;
        
    }

    /**
     * When called, sets marioL to true
     */
    public void marioLeft()
    {
        marioL = true;
    }

    /**
     * When called, increases the player's ammunition
     */
    public void increaseAmmunition()
    {
        ammunition = ammunition + 3;
    }

    /**
     * When called, decreases the player's ammunition
     */
    public void decreaseAmmunition()
    {
        ammunition = ammunition - 1;
    }

    /**
     * When called, decreases the player's lives
     */
    public void decreaseLives()
    {
        lives--;
    }

    /**
     * When called, increases the player's lives
     */
    public void increaseLives()
    {
        lives = lives + 1;
    }

    /**
     * When called, returns the player's ammunition
     */
    public int getAmmo()
    {
        return ammunition;
    }

    /**
     * When called, returns the player's lives
     */
    public int getLives()
    {
        return lives;
    }

    /**
     * Adds the main actor into the world at the center of the screen
     * Sets the coordinate for the screen to scroll within the world, and determines how far the actor can move
     */
    public void addMainActor(Actor main, int xLoc, int yLoc, int xRange, int yRange)
    {
        super.addObject(main, xLoc-scrolledX, yLoc-scrolledY);
        mainActor = main;
        xRange= 0;
        yRange=(int)Math.min(yRange, getHeight());
        actorMinX=getWidth()/2-xRange/2;
        actorMaxX=getWidth()/2+xRange/2;
        actorMinY=getHeight()/2-yRange/2;
        actorMaxY=getHeight()/2+yRange/2;
        act();
    }

    /**
     * Adds a scrolling background to the world based off a picture
     */
    public void setScrollingBackground(GreenfootImage scrollingBackground)    
    {
        // if(!justInit)
        {
            background = new GreenfootImage(scrollingBackground);
            background.scale(scrollingWidth*getCellSize(), scrollingHeight*getCellSize());
            scrollBackground();
        }
    }
    
    /**
     * Adds a scrolling background to the world based off a picture
     */
    public void setScrollingBackground(GreenfootImage scrollingBackground,int odd)    
    {
        {
            background = new GreenfootImage(scrollingBackground);

            scrollBackground();
        }
    }

    /**
     * Makes the background just the picture by stretching it where appropriate
     */
    public void fillScrollingBackground(GreenfootImage fillImage)
    {
        if (fillImage.getWidth()<getWidth() && fillImage.getHeight()<getHeight())
        {
            setBackground(new GreenfootImage(fillImage));
            fillImage = getBackground();
        }
        World world = new World(scrollingWidth*getCellSize(), scrollingHeight*getCellSize(), 1){};
        world.setBackground(fillImage);
        background = new GreenfootImage(world.getBackground());
        scrollBackground();
    }

    /**
     * Adds an object into the world and determines whether or not the object will scroll or not
     */
    public void addObject(Actor obj, int xLoc, int yLoc, boolean scroller)
    {
        if (!scroller)
        {
            super.addObject(obj, xLoc, yLoc);
            if (obj == mainActor)
            {
                act();
            }
            return;
        }
        super.addObject(obj, xLoc-scrolledX, yLoc-scrolledY);
        
    }

    /**
     * Removes objects from the world
     */
    public void removeObject(Actor obj)
    {
        if(obj==null)
        {
            return;
        }
        if(obj.equals(mainActor))
        {
            mainActor=null;
        }
        else 
        {
           
        }
        super.removeObject(obj);
    }

    /**
     * Adds a scrollable actor to the world based on an x and y location
     */
    public void addObject(Actor obj, int xLoc, int yLoc)
    {
        addObject(obj, xLoc, yLoc, true);
    }

    /**
     * Runs the scrolling.
     */
    public void act()
    {
        scrollBackground();
        scrollObjects();
        remove--;
        if (lives < 0)
        {
            Greenfoot.setWorld(new GameOver());
        }
        time = time - 1;
        if(Greenfoot.getKey() != null)
        {
            removeObjects(getObjects(LiveText.class));
            removeObjects(getObjects(LiveImage.class));
            removeObjects(getObjects(Intro1.class));
            removeObjects(getObjects(Intro2.class));
            removeObjects(getObjects(Intro3.class));
            removeObjects(getObjects(Intro4.class));
            removeObjects(getObjects(Intro5.class));
            removeObjects(getObjects(Intro6.class));
            justInit = false;
        }
    }

    /**
     * Scrolls the background image.
     */
    private void scrollBackground()
    {
        if (background==null) 
        {
            return;
        }
        int c = getCellSize();
        getBackground().drawImage(background, (-scrolledX*c)/2, (-scrolledY*c)/2);
    }

    /**
     * Scrolls all objects which hae been defined as scrollable when they were added in based on where the main actor is in the window
     */
    private void scrollObjects()
    {

        if (mainActor==null) 
        {
            return;
        }
        int dx=0, dy=0;
        if(mainActor.getX()<actorMinX) 
        {
            dx=actorMinX-mainActor.getX();
        }
        if(mainActor.getX()>actorMaxX) 
        {
            dx=actorMaxX-mainActor.getX();
        }
        if(mainActor.getY()<actorMinY) 
        {
            dy=actorMinY-mainActor.getY();
        }
        if(mainActor.getY()>actorMaxY) 
        {
            dy=actorMaxY-mainActor.getY();
        }
        if(dx==0 && dy==0) 
        {
            return;
        }
        int dxSum = dx, dySum = dy;
        scrolledX-=dx; scrolledY-=dy;
        mainActor.setLocation(mainActor.getX()+dx, mainActor.getY()+dy);
        dx=0; dy=0;
        if(scrolledX > scrollingWidth-getWidth())
        {
            dx=scrolledX-(scrollingWidth-getWidth());
        }
        if(scrolledX < 0) 
        {
            dx=scrolledX;
        }
        if(scrolledY > scrollingHeight-getHeight()) 
        {
            dy=scrolledY-(scrollingHeight-getHeight());
        }
        if(scrolledY < 0) 
        {
            dy=scrolledY;
        }
        dxSum+=dx; dySum+=dy;
        scrolledX-=dx; scrolledY-=dy;
        characterNum = getObjects(null).size();
        mainActor.setLocation(mainActor.getX()+dx, mainActor.getY()+dy);
        while(characterMoved < characterNum)
        {
            try 
            {Actor obj = getObjects(Actor.class).get(characterMoved);
                 if (obj == mainActor) dx=dx;
                 else
                 obj.setLocation(obj.getX()+dxSum, obj.getY()+dySum);
            }
            catch (IndexOutOfBoundsException e)
            {
                
            }
            characterMoved++;

        }
        dx=0; dy=0;
        characterMoved = 0;
        if(mainActor.getX() < 0) 
        {
            dx=0-mainActor.getX();
        }
        if(mainActor.getX() > getWidth()-1) 
        {
            dx=(getWidth()-1)-mainActor.getX();
        }
        if(mainActor.getY() < 0) 
        {
            dy=0-mainActor.getY();
        }
        if(mainActor.getY() > getHeight()-1) 
        {
            dy=(getHeight()-1)-mainActor.getY();
        }
        if(dx==0 && dy==0) 
        {
            return;
        }
        mainActor.setLocation(mainActor.getX()+dx, mainActor.getY()+dy);

    }

    /**
     * We had to edit this code to make our objects spawn in properly. Determines how far the main actor has moved overall
     */
    public int getUnivX(int worldX)
    {
        return worldX+scrolledX;
    }
    
    /**
     * We had to edit this code to make our objects spawn in properly. Determines how far the main actor has moved overall
     */
    public int getUnivY(int worldY)
    {
        return worldY+scrolledY;
    }

    /**
     * When called, returns the scrolling area width
     */
    public int getScrollingWidth()
    {
        return scrollingWidth;
    }

    public int time()
    {
        return time;
    }
}