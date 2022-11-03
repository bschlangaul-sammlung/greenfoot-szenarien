package org.bschlangaul.greenfootscenarios.space_invaders.jwilshire;

import greenfoot.*; 

/**
 * Write a description of class MyWorld here. No static variables
 *
 */
public class MyWorld extends World
{
    private static final int ROW_HEIGHT = 5;
    private Ship ship;
    private int topPosition;
    private int leftWall;
    private int rightWall;
    private int rowMoving;
    private long lastUpdateTime;
    private long alienWaitTime;
    private long lastAlienShotTime;
    private long alienShotWaitTime;
    private long mysteryInvaderWaitTime;
    private long lastMysteryInvaderTime;
    private java.util.ArrayList<ShipCounter> extraLives;
    private GreenfootSound invaderDestroyedSound;
    private GreenfootSound invaderStepSound;
    private GreenfootImage backGround;
    private int score;
    private int wave;
    private boolean firstStart; // prevents resart after pausing
    private static final int GROUND_HEIGHT = 74;

    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public MyWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(100, 80, 8);
        firstStart = true;
        Greenfoot.setSpeed(50);
        ship = new Ship();
        topPosition = 19;
        leftWall = 10;
        rowMoving = 4;
        lastAlienShotTime = 0;
        alienShotWaitTime = 1200L;

        rightWall = getWidth() - leftWall;
        lastUpdateTime = System.currentTimeMillis();
        alienWaitTime = 300L;
        mysteryInvaderWaitTime = 20000L;
        score = 0;
        wave = 0;
        addObject(ship, 50, 70);
        prepareExtraLives();
        prepareScoreboard();
        invaderDestroyedSound = new GreenfootSound("invaderDestroyedSound.wav");
        invaderStepSound = new GreenfootSound("invaderStepSound.wav");
    }

    public void increaseScore(int increaseAmt)
    {
        score += increaseAmt;
        updateScoreboard();
    }

    @Override
    public void started()
    {
        if (firstStart)
        {
            firstStart = false;
            beginWave();
        }
    }

    public void stopAnyMysterySounds()
    {
        if (getObjects(MysteryInvader.class).size() != 0)
        {
            getObjects(MysteryInvader.class).get(0).stopSound();
        }
    }

    public void beginWave()
    {
        wave++;
        lastMysteryInvaderTime = System.currentTimeMillis();// set to zero to debug
        alienWaitTime = Math.max(330 - wave * 30, 200);
        alienShotWaitTime = Math.max(1200 - wave * 100, 300);
        topPosition = 22 + wave;
        removeObjects(getObjects(AlienFire.class));
        GreenfootImage bg = getBackground();
        bg.drawString("Wave " + wave, 325, 300);
        Greenfoot.delay(100);
        updateScoreboard();
        prepareAliens();
        removeOldShields();
        prepareShields();
    }

    public void prepareScoreboard()
    {
        Font font = new Font(40);
        backGround = getBackground();
        backGround.setFont(font);
        backGround.drawString("Score " + score, 300, 50);
    }

    public void updateScoreboard()
    {
        setBackground("space1.jpg");
        Font font = new Font(40);
        backGround = getBackground();
        backGround.setFont(font);
        backGround.drawString("Score " + score, 250, 50);
    }

    public void prepareExtraLives()
    {
        extraLives = new java.util.ArrayList<>();
        ShipCounter one = new ShipCounter();
        addObject(one, 15, 75);
        ShipCounter two = new ShipCounter();
        addObject(two, 10, 75);
        ShipCounter three = new ShipCounter();
        addObject(three, 5, 75);
        extraLives.add(one);
        extraLives.add(two);
        extraLives.add(three);
    }

    public void removeLife()
    {
        removeObject(extraLives.get(0));
        extraLives.remove(0);
    }

    public void prepareShields()
    {
        int shieldSpace = 20;
        for (int s = 0; s < 4; s++)
        {
            for (int i = 0; i < 6; i++)
            {
                for (int k = 0; k < 7; k++)
                {
                    if ((i == 1 && k > 0 && k < 6) || (i == 2 || i == 3)
                                    || (i == 4 && (k < 2 || k > 4)) || (i == 5 && (k < 1 || k > 5)))
                    {
                        ShieldPart part = new ShieldPart();
                        addObject(part, 15 + (s * shieldSpace) + k, 60 + i);
                    }
                }
            }
        }
    }

    public void removeOldShields()
    {
        removeObjects(getObjects(ShieldPart.class));
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial objects and add
     * them to the world.
     */
    private void prepareAliens()
    {
        for (int i = 0; i < 5; i++)
        {
            for (int k = 0; k < 11; k++)
            {
                Alien alien = null;
                if (i == 3 || i == 4)
                {
                    alien = new JellyAlien(i);
                }
                else if (i == 1 || i == 2)
                {
                    alien = new CrabAlien(i);
                }
                else
                {
                    alien = new SquidAlien(i);
                }
                addObject(alien, leftWall + k * 6, topPosition + i * ROW_HEIGHT);
            }
        }

    }

    public void act()
    {
        boolean alienHit = false;
        boolean needToChangeDirection = false;
        boolean movementMade = false;
        for (int i = 0; i < getObjects(Alien.class).size(); i++)
        {
            Alien alien = getObjects(Alien.class).get(i);
            if (alien.getX() < leftWall && alien.isMovingLeft()
                            || alien.getX() + 1 > rightWall && !alien.isMovingLeft())
            {
                needToChangeDirection = true;
            }
            if (alien.isTouchingMissle())
            {
                invaderDestroyedSound.play();
                if (alien instanceof JellyAlien)
                {
                    score += 10;
                }
                else if (alien instanceof CrabAlien)
                {
                    score += 20;
                }
                else
                {
                    score += 30;
                }
                InvaderExplosion exp = new InvaderExplosion();
                addObject(exp, alien.getX(), alien.getY());
                removeObject(alien);
                ship.readyLaser();
                alienHit = true;
                updateScoreboard();
            }
        }
        long currentTime = System.currentTimeMillis();
        moveInvadersIfTime(currentTime);
        invadersFireIfTime(currentTime);
        sendMysteryInvaderIfTime(currentTime);
        if (needToChangeDirection)
        {
            moveDownAndChangeDirection();
        }
        if (alienHit)
        {
            if (getObjects(Alien.class).size() > 1)
            {
                alienWaitTime -= 5L;
                alienShotWaitTime -= 10L;
            }
            else if (getObjects(Alien.class).size() == 1)
            {
                Alien x = getObjects(Alien.class).get(0);
                alienWaitTime = 5L;
            }
            else
            {
                beginWave();
            }
        }
    }

    public void sendMysteryInvaderIfTime(long currentTime)
    {
        if (currentTime - lastMysteryInvaderTime > mysteryInvaderWaitTime)
        {
            if (Greenfoot.getRandomNumber(2) == 1)
            {
                MysteryInvader mi = new MysteryInvader(1);
                addObject(mi, 10, 15);
                // System.out.println("mystery 1 at time " + currentTime);
            }
            else
            {
                MysteryInvader mi = new MysteryInvader(-1);
                addObject(mi, getWidth() - 5, 15);
                // System.out.println("mystery 2 at time " + currentTime);
            }
            lastMysteryInvaderTime = currentTime;
        }
    }

    public void moveRow(int row)
    {
        java.util.List<Alien> aliens = getObjects(Alien.class);
        for (int i = 0; i < aliens.size(); i++)
        {
            Alien alien = aliens.get(i);
            if (alien.getRow() == row || (aliens.size() < 20 && alien.getRow() % 2 == row % 2)
                            || aliens.size() < 3)
            {
                alien.moveSideToSide();
            }
        }
    }

    public void invadersFireIfTime(long currentTime)
    {
        // wait time is doubled if the size is less than half
        long wait = alienShotWaitTime;
        if (getObjects(Alien.class).size() < 55 / 2)
        {
            wait *= 2;
        }
        if (currentTime - lastAlienShotTime > wait)
        {
            fireShot();
            lastAlienShotTime = currentTime;
        }
    }

    public void fireShot()
    {
        java.util.List<Alien> aliens = getObjects(Alien.class);
        if (aliens.size() > 0)
        {
            int randomIndex = Greenfoot.getRandomNumber(aliens.size());
            aliens.get(randomIndex).fire();
        }

    }

    public void moveDownAndChangeDirection()
    {
        for (int i = 0; i < getObjects(Alien.class).size(); i++)
        {
            Alien alien = (Alien) getObjects(Alien.class).get(i);
            alien.setLocation(alien.getX(), alien.getY() + ROW_HEIGHT);
            alien.changeDirection();
            if (alien.getY() > GROUND_HEIGHT)
            {
                gameOver(0);
            }
        }
    }

    public void gameOver(int type)
    {
        if (type == 1)
        {
            getBackground().drawString("GAME OVER!", 250, 125);
            stopAnyMysterySounds();
        }
        else
        {
            getBackground().drawString("MISSION FAILURE, GAME OVER!", 50, 125);
            stopAnyMysterySounds();
        }
        Greenfoot.delay(200);
        removeObjects(getObjects(Alien.class));
        updateScoreboard();
        removeObject(ship);
        if (UserInfo.isStorageAvailable())
        {
            UserInfo myInfo = UserInfo.getMyInfo();
            if (score > myInfo.getScore())
            {
                myInfo.setScore(score);
                myInfo.store(); // write back to server
            }
        }
        getBackground().setFont(new Font(20));
        java.util.List<UserInfo> topTen = UserInfo.getTop(10);
        int leftMarginList = 200;
        if (topTen != null)
        {
            getBackground().drawString("TOP TEN", leftMarginList, 100);
            for (int i = 0; i < topTen.size(); i++)
            {
                if (topTen.get(i) != null && !topTen.get(i).getUserName().equals(""))
                {
                    getBackground().drawString(
                                    topTen.get(i).getRank() + " " + topTen.get(i).getUserName()
                                                    + " " + topTen.get(i).getScore(),
                                    leftMarginList, 140 + 20 * i);
                }
                else
                {
                    getBackground().drawString((i + 1) + " " + "A. Player", leftMarginList,
                                    140 + 20 * i);
                }
            }
        }
        else
        {
            getBackground().drawString("TOP TEN", leftMarginList, 100);
            for (int i = 0; i < 10; i++)
            {
                getBackground().drawString((i + 1) + " " + "A. Player", leftMarginList,
                                140 + 20 * i);
            }
        }
        if (UserInfo.isStorageAvailable())
        {
            UserInfo myInfo = UserInfo.getMyInfo();
            getBackground().drawString("Your rank " + myInfo.getRank(), leftMarginList, 430);
        }
        Greenfoot.delay(500);
        Greenfoot.stop();
    }

    public void moveInvadersIfTime(long currentTime)
    {
        if (currentTime - lastUpdateTime > alienWaitTime && getObjects(Alien.class).size() > 0)
        {
            invaderStepSound.play();
            moveRow(rowMoving);
            lastUpdateTime = currentTime;
            rowMoving = rowMoving - 1;
            if (rowMoving < 0)
            {
                rowMoving = 4;
            }
        }
    }
}
