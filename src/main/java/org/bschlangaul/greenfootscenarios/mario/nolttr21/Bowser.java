package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mario's final enemy. Cannot be jumped on to be killed, must be shot.
 * 
 * @author (Dylan Powell and Sean Eastley) 
 * @version (January 21, 2015)
 */
public class Bowser extends NonJumpable
{
    private boolean onGround; //Defines if bowser is on the ground or not
    private int stability = 9; //Defines how much health bowser has
    private int ySpeed; //Determines how fast bowser is moving dow
    private int jCoordinate; //Determines where bowser will jump
    private int itemDelayCount; //Ticks up to determine when an item will be added to the world
    private int itemDelayTime; //The number that the itemDelayCount must pass to add an item to the world
    private int itemX; //Determines where the item will be added to the world
    private int fireDelayTime; //The number that the fireDelayCount must pass to shoot
    private int fireDelayCount; //Ticks up to determine when bowser will shoot
    GreenfootSound shoot = new GreenfootSound("Fire.wav");
    GreenfootSound ouch = new GreenfootSound("Hit.wav");
    GreenfootSound roar = new GreenfootSound("Roar.wav");
    // GreenfootSound roar = new GreenfootSound(null);
    public boolean back = true;
    public static boolean gameWon = false;
    public boolean fall = false;
    public int delay1 = 50;
    public int delay2 = 350;
    public static int part = 0;

    /**
     * Initializes the values for the variables in Bowser
     */
    public Bowser()
    {
        onGround = true;
        part = 0;
        gameWon = false;
        jCoordinate = Greenfoot.getRandomNumber(500);
        itemDelayTime = Greenfoot.getRandomNumber(300);
        itemX = Greenfoot.getRandomNumber(668);
        fall = false;
        fireDelayTime = Greenfoot.getRandomNumber(90);
    }

    /**
     * Sets the variables to appropriate ones when they are not appropriate.
     * Ticks up the variables for Bowser to work
     * Calls the appropriate methods for Bowser to operate
     * Updates the scoreboards
     */
    public void act() 
    {
        if (!fall) 
        {
            if (stability > 0)
            {
                while (jCoordinate < 250)
                {
                    jCoordinate = Greenfoot.getRandomNumber(250) + 251;
                }
                while (itemDelayTime < 150)
                {
                    itemDelayTime = Greenfoot.getRandomNumber(150) + 151;
                }
                while (itemX < 32)
                {
                    itemX = Greenfoot.getRandomNumber(628) + 32;
                }
                while (fireDelayTime < 25)
                {
                    fireDelayTime = Greenfoot.getRandomNumber(75) + 25;
                }
                ySpeed ++;
                itemDelayCount ++;
                fireDelayCount ++;
                if(stability > 0) moveBowser();
                addItems();
                fire();
            }
            
            {
                BossWorld bossWorld = (BossWorld)getWorld();
                bossWorld.updateScoreboard();
                if(stability <= 0) 
                {

                    setRotation(180);
                    setLocation(getX(),getY()+5);
                    if(getX() > 800)
                    {
                        bossWorld.gameWon();
                    }
                    // getWorld().removeObject(this);
                    // GameWon.winning.play();
                }


                if(gameWon)
                {
                    bossWorld.gameWon();
                }
            }
        }
        death();
    }

    /**
     * Moves bowser forward if there is a block below him and makes him jump as well as move backwards if the jCoordinate has been reached
     */
    private void moveBowser()
    {
        Actor brick = getOneObjectAtOffset(0, getImage().getHeight()/2, LongBrick.class);
        if (brick != null)
        {
            onGround = true;
        }
        else
        {
            onGround = false;
        }
        if (onGround == true)
        {
            move(-1);
            ySpeed = 0;
        }

        while (getOneObjectAtOffset (getImage().getWidth()/2, 0, Brick.class)!= null)
        {
            setLocation(getX()-1, getY());
        }
        if (back && !onGround)
        {
            move(5);
        }
        if (getX() == jCoordinate && onGround == true)
        {
            jump();
        }
        setLocation(getX(), getY() + ySpeed);
        if(onGround && !back)
        {
            back = true;
        }
    }

    /**
     * Makes bowser jump and redefines the jCoordinate
     */
    private void jump()
    {
        roar.play();
        onGround = false;
        ySpeed = -26;
        jCoordinate = Greenfoot.getRandomNumber(500);
    }

    /**
     * Adds a powerup to the world based on what type of mario is in the world.
     */
    private void addItems()
    {
        // if (itemDelayCount == itemDelayTime)
        // {
        // if ( ! getWorld().getObjects(MarioS.class).isEmpty() )
        // {
        // ((SWorld)getWorld()).addObject(new Mushroom(), itemX, 0, true);
        // }
        // else
        // {
        // ((SWorld)getWorld()).addObject(new Ammo(), itemX, 0, true);
        // }
        // itemDelayCount = 0;
        // itemX = 0;
        // }
    }

    /**
     * Makes bowser shoot and play a noise on the condition that the fireDelayCount has reached the fireDelayTime.
     * It will also reset the variables.
     */
    private void fire()
    {
        if (fireDelayCount == fireDelayTime)
        {
            shoot.play();
            fireDelayTime = 0;
            fireDelayCount = 0;
            ((SWorld)getWorld()).addObject(new bFireball(), getX(), getY() + 5, true);
        }
    }

    /**
     * This method is called by mario's bullet when it collides with Bowser. It will subtract the bullet's damage from the stability of Bowser.
     * If the stability is less than or equal to 0, Bowser will be removed and the gameWon method will be called
     */
    public void hit(int damage) 
    {
        ouch.play();
        BossWorld bossWorld = (BossWorld)getWorld();
        bossWorld.decreaseHits();
        stability = stability - damage;
        if(stability <= 0) 
        {
            jump();
            stability = 10;
            back = false;
            // bossWorld.play();
            // setRotation(180);
            // setLocation(getX(),getY()-1);
            // bossWorld.gameWon();
            // getWorld().removeObject(this);

            // GameWon.winning.play();
        }
    }

    public void death()
    {
        if (part == 1)
        {
            BossWorld.music.stop();
            fall = true;
            if(getX() > 550)
            {
                setLocation(550,getY());
            }
            GreenfootImage image = getImage();
            image.mirrorHorizontally();
            part++;

        }
        else if (part == 2)
        {
            Greenfoot.delay(100);
            Greenfoot.playSound("Roar.wav");
            Greenfoot.delay(100);
            setImage("GhoombaL.png");
            Greenfoot.delay(50);
            part++;
        }
        else if (part == 3)
        {
            delay1--;

            ySpeed++;
            setLocation(getX(),getY() + ySpeed/2);

            if(delay1 == 0)
            {
                part++;
            }
        }
        else if (part == 4)
        {
            delay2--;

            ySpeed++;
            setLocation(getX(),getY() + ySpeed/2);
            if(delay2 == 299)
                {
                    Greenfoot.playSound("Down.mp3");
                    Greenfoot.playSound(Mario.characterName + "/winC.mp3");
                }
                
            if(delay2 < 0)
            {
                part++;
            }
        }
        else if (part == 5)
        {
            Greenfoot.playSound("almost.mp3");
            getWorld().addObject(new Dummy(),100,0);
            part++;

        }

    }
}

