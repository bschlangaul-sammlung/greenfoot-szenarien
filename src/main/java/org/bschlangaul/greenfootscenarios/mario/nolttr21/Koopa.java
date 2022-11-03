import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Koopa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Koopa extends Jumpable
{
    public int time;
    public int number = 1;
    public boolean left = true;
    public static GreenfootImage one = new GreenfootImage("k1.png");
    public static GreenfootImage two = new GreenfootImage("k2.png");
    public static GreenfootImage three = new GreenfootImage("k3.png");
    public int speed = 5;
    public static int health = 3;
    public static int invince = 70;
    public int ySpeed;
    public boolean onGround = false;
    public static boolean getHit = false;
    public Koopa()
    {
        health = 3;
        one = new GreenfootImage("k1.png");
        two = new GreenfootImage("k2.png");
        three = new GreenfootImage("k3.png");
        invince = 70;

    }

    public Koopa(int hp)
    {
        health = hp;
        one = new GreenfootImage("k1.png");
        two = new GreenfootImage("k2.png");
        three = new GreenfootImage("k3.png");
        
    }

    /**
     * Act - do whatever the Koopa wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        

        if(invince == 100)
        {
            ySpeed = 0;
        }
        time++;
        ySpeed ++;
        Actor brick = getOneObjectAtOffset(0, getImage().getHeight()/2, LongBrick.class);
        if (brick != null)
        {
            onGround = true;
        }
        else
        {
            onGround = false;
        }
        while (getOneObjectAtOffset(getImage().getWidth()/2,getImage().getHeight()/2, LongBrick.class) != null)
        {
            setLocation(getX(), getY()-1);
            onGround = true;
            ySpeed = 0;
        }
        setLocation(getX(), getY() + ySpeed/2);
        if (onGround && time % 2 == 1 && invince < 0)
        {
            ySpeed = -(Greenfoot.getRandomNumber(10) + 10);

        }

        if (getOneObjectAtOffset (getImage().getWidth()/2, 0, Brick.class)!= null)
        {
            setLocation(getX()-1, getY());
        }

        if (health != 0)speed = 16 / health;
        // else

        // Actor brick = getOneObjectAtOffset(0, getImage().getHeight()/2, LongBrick.class);
        // while(brick != null)
        // {
        // ySpeed = 20;
        // setLocation(getX(),getY() - 1);

        // }
        // while (getOneObjectAtOffset (14, getImage().getHeight()/2 - 2, LongBrick.class)!= null)
        // {
        // setLocation(getX(), getY()-1);
        // onGround = true;
        // ySpeed = 0;
        // }
        if(invince == 99)
        {
            getWorld().addObject(new Star(),getX(),getY());
            getWorld().addObject(new Star(),getX(),getY());
            getWorld().addObject(new Star(),getX(),getY());
            getWorld().addObject(new Star(),getX(),getY());
            getWorld().addObject(new Star(),getX(),getY());
            getWorld().addObject(new Star(),getX(),getY());
            getWorld().addObject(new Star(),getX(),getY());
            getWorld().addObject(new Star(),getX(),getY());
            getWorld().addObject(new Star(),getX(),getY());
            getWorld().addObject(new Star(),getX(),getY());
            getWorld().addObject(new Star(),getX(),getY());
            getWorld().addObject(new Star(),getX(),getY());
            getWorld().addObject(new Star(),getX(),getY());
            getWorld().addObject(new Star(),getX(),getY());
            getWorld().addObject(new Star(),getX(),getY());
            getWorld().addObject(new Star(),getX(),getY());
            getWorld().addObject(new Star(),getX(),getY());
            getWorld().addObject(new Star(),getX(),getY());
            getWorld().addObject(new Star(),getX(),getY());
            getWorld().addObject(new Star(),getX(),getY());
            getWorld().addObject(new Star(),getX(),getY());
            getWorld().addObject(new Star(),getX(),getY());
            getWorld().addObject(new Star(),getX(),getY());
            getWorld().addObject(new Star(),getX(),getY());
            getWorld().addObject(new Star(),getX(),getY());
            getWorld().addObject(new Star(),getX(),getY());
            getWorld().addObject(new Star(),getX(),getY());

        }
        // Actor brick1 = getOneObjectAtOffset(0, (getImage().getHeight()/2) - 4 , LongBrick.class);

        // if(brick1 != null)
        // {

        // {
        // ySpeed = -Greenfoot.getRandomNumber(20);
        // }
        // }

        invince--;
        if (invince < 0)
        {
            if(time % 10 == 1)
            {
                number++;
                if(number == 4)
                {
                    number = 1;
                }
                if(number == 1)
                {
                    setImage(one);
                }
                if(number == 2)
                {
                    setImage(two);
                }
                if(number == 3)
                {
                    setImage(three);
                }
            }

            if(left)
            {
                move(-speed);
            }
            else
            {
                move(speed);
            }
        }

        if(isTouching(Brick.class))
        {
            one.mirrorHorizontally();
            two.mirrorHorizontally();
            three.mirrorHorizontally();
            left = !left;
        }

        if(health <= 0)
        {
            if(getX() > 350)
                getWorld().addObject(new Key2(),getX()-250,0);
            else
                getWorld().addObject(new Key2(),getX()+250,0);
            getWorld().removeObject(this);
            return;
            // Greenfoot.delay(100);

        }

        if (getHit)
        {
            getHit = false;
            if (health > 0)
            {
                invince = 20;
                SWorld world = (SWorld)getWorld();
                Greenfoot.playSound("inShell.mp3");
                world.addObject(new BossShell(health),world.getUnivX(getX()),world.getUnivY(getY()));
                world.removeObject(this);
                return;
            }
        }
    }  
    
    public static void lose()
    {
        health--;
        invince = 100;
        getHit = true;
        
    }

}
