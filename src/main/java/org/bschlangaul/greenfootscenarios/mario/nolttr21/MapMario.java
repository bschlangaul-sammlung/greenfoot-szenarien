import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MapMario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MapMario extends AllMarios
{
    

    public static boolean doKey = false;
    public static boolean alreadyKey = false;
    public static int goingBackTo = 0;
    public int time;
    public int imageNum = 1;
    public int delay = 50;
    public static String characterName = "mario";
    public static boolean up = false;
    public static boolean down = false;
    public static boolean left = false;
    public static boolean right = false;
    public static boolean goingUp = false;
    public static boolean goingDown = false;
    public static boolean goingLeft = false;
    public static boolean goingRight = false;
    public boolean onTheMove = false;
    public int level;
    public int wait = -5;
    public MapMario()
    {

        setImage(characterName + "map0.png");
    }

    /**
     * Act - do whatever the MapMario wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        delay--;
        time++;
        if(delay == 20 && doKey && !alreadyKey)
        {
            getWorld().addObject(new Key(),getX(),getY()+Greenfoot.getRandomNumber(50));
            Greenfoot.delay(20);
            getWorld().addObject(new Key(),getX()+Greenfoot.getRandomNumber(50),getY());
            Greenfoot.delay(100);
            delay = 50;
            alreadyKey = true;
        }

        if (up && !onTheMove && Greenfoot.isKeyDown("up"))
        {
            goingUp = true;
            onTheMove = true;
        }

        if (down && !onTheMove && Greenfoot.isKeyDown("down"))
        {
            goingDown = true;
            onTheMove = true;
        }

        if (left && !onTheMove && Greenfoot.isKeyDown("left"))
        {
            goingLeft = true;
            onTheMove = true;
        }

        if (right && !onTheMove && Greenfoot.isKeyDown("right"))
        {
            goingRight = true;
            onTheMove = true;
        }

        if (goingUp)
        {
            setLocation(getX(),getY()-3);
            wait--;
            
        }

        if (goingDown)
        {
            setLocation(getX(),getY()+3);
            wait--;
            
        }

        if (goingLeft)
        {
            setLocation(getX()-3,getY());
            wait--;
            
        }

        if (goingRight)
        {
            setLocation(getX()+3,getY());
            wait--;
            
        }
        
        if (Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.delay(10);
            switch (level)
            {
                case 1:Greenfoot.playSound(characterName + "go.mp3");Greenfoot.setWorld(new MyWorld());Map.map.stop();break;
                case 2:Greenfoot.playSound(characterName + "go.mp3");Greenfoot.setWorld(new WorldTwo());Map.map.stop();break;
                case 3:Greenfoot.playSound(characterName + "castle.mp3");Greenfoot.setWorld(new Tower());Map.map.stop();break;
                case 4:Greenfoot.playSound(characterName + "go.mp3");Greenfoot.setWorld(new WorldThree());Map.map.stop();break;
                case 5:Greenfoot.playSound(characterName + "castle.mp3");Greenfoot.setWorld(new Fortress());Map.map.stop();break;
                case 6:Greenfoot.playSound(characterName + "castle.mp3");Greenfoot.setWorld(new Airship());Map.map.stop();break;
            }
        }
        
        if (goingRight || goingLeft || goingUp || goingDown)
        {
            if (time % 10 == 0)
            {
                imageNum++;
                if (imageNum > 2)
                {
                    imageNum = 1;
                }
                setImage(characterName + "map" + imageNum + ".png");
            }
        }

        // if (getObjectsInRange(5,Worlds.class) != null && wait < 0)
        // {
            
        // }
        
        
        Actor Worlds = getOneObjectAtOffset(0,0,Worlds.class);
        if (Worlds != null && wait < 0)
        {
            goingUp = false;
            goingDown = false;
            goingLeft = false;
            goingRight = false;
            onTheMove = false;
            if (Worlds != null)
            setLocation(Worlds.getX(),Worlds.getY());
            wait = 10;
            
            setImage(characterName + "map0.png");
            if (Worlds instanceof One)
            {
                level = 1;
                
            }
            else if (Worlds instanceof Two)
            {
                level = 2;
                
            }
            else if (Worlds instanceof F)
            {
                level = 3;
            }
            else if (Worlds instanceof Three)
            {
                level = 4;
            }
            else if (Worlds instanceof C)
            {
                level = 5;
            }
            else if (Worlds instanceof A)
            {
                level = 6;
            }
            else
            {
                level = 0;
            }
        }

        
        
    }  

   
}
