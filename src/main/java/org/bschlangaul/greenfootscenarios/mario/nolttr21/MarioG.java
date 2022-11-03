package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;


/**
 * MarioG is the ultimate mario character, equipped with a gun. He is the main actor. If he is hit,
 * he will turn into regular mario
 *
 * @author (Dylan Powell, Sean Eastley)
 * @version (January 21, 2015)
 */
public class MarioG extends AllMarios
{
    private int invincibilityTime; // this is the number that the invincibilityDelayCount must pass
                                   // before invincibility runs out
    private int invincibilityDelayCount; // this number ticks up to determine how long you are
                                         // invincible
    private int gunReloadTime; // this is the number that the reloadDelayCount must pass before the
                               // gun shoots
    private int reloadDelayCount; // this number ticks up to time the gun
    private int imageTime; // this is the number that the imagedDelayCount must pass before the
                           // image switches
    private int imageDelayCount; // this number ticks up to time the image switch
    public int bullets; // this number determines how many bullets you have
    final int jSpeed = 23; // this number determines how high you jump
    private int ySpeed = 0; // this number determines how fast you are moving up and down
    private int xSpeed; // this int determines how fast mario is moving in the x direction
    private boolean onGround; // this boolean shows whether or not you are on the ground
    private boolean gotHit; // this boolean shows whether or not mario was hit
    private boolean mLeft; // this boolean shows whether or not mario is left
    private boolean terrainLeft; // this boolean shows whether or not the platform below mario is
                                 // moving left or right
    public boolean marioSetAsGun = false; // this boolean shows whether or not sWorld has had its
                                          // variables set for mario having a gun
    private boolean fell = false; // this boolean determines whether or not mario has fallen off of
                                  // the world
    private int scrolled; // this int determines how far mario has moved in the x direction
    private int livesLeft; // this number stores how many lives the player has
    private GreenfootImage imageL1;
    private GreenfootImage imageR1;
    private GreenfootImage imageL2;
    private GreenfootImage imageL3;
    private GreenfootImage imageR2;
    private GreenfootImage imageR3;
    GreenfootSound die = new GreenfootSound("hit.mp3");
    GreenfootSound shot = new GreenfootSound("Shoot.mp3");
    GreenfootSound jump = new GreenfootSound("Jump.wav");
    GreenfootSound squish = new GreenfootSound("Squish.wav");
    GreenfootSound bounce = new GreenfootSound("Shell.wav");
    // GreenfootSound down = new GreenfootSound("win2.mp3");
    // GreenfootSound dryfire = new GreenfootSound("NoBullets.wav");
    public boolean pulling = false;
    public boolean won = false;
    public int delay = 340;
    public int position = 0;
    public boolean played = false;
    public boolean lose = false;
    public int delayTime = 200;
    public int img = 1;
    public int imageNumber = 1;
    public static String characterName = "mario";
    public int time;
    public int swaps;
    public int imgBackTo = 0;
    public boolean powerDown = false;
    public boolean changedToSmall = false;
    public boolean growing = false;
    public boolean countUp = true;

    /**
     * This will define variables for MarioG.
     */
    public MarioG()
    {
        imageL1 = new GreenfootImage(characterName + "mariogunL1.png");
        imageR1 = new GreenfootImage(characterName + "mariogunR1.png");
        imageL2 = new GreenfootImage(characterName + "mariogunL2.png");
        imageL3 = new GreenfootImage(characterName + "mariogunL3.png");
        imageR2 = new GreenfootImage(characterName + "mariogunR2.png");
        imageR3 = new GreenfootImage(characterName + "mariogunR3.png");
        gunReloadTime = 20;
        setImage(imageL1);
        reloadDelayCount = 0;
        imageTime = 10;
        imageDelayCount = 0;

        xSpeed = 0;
        invincibilityTime = 50;
        invincibilityDelayCount = 0;
        MovingEnemies.moveable = true;
    }

    /**
     * This will define variables for MarioG.
     */
    public MarioG(int Yspeed)
    {
        imageL1 = new GreenfootImage(characterName + "mariogunL1.png");
        imageR1 = new GreenfootImage(characterName + "mariogunR1.png");
        imageL2 = new GreenfootImage(characterName + "mariogunL2.png");
        imageR2 = new GreenfootImage(characterName + "mariogunR2.png");
        gunReloadTime = 20;
        setImage(imageL1);
        reloadDelayCount = 0;
        imageTime = 10;
        imageDelayCount = 0;
        xSpeed = 0;
        invincibilityTime = 50;
        invincibilityDelayCount = 0;
        MovingEnemies.moveable = true;
        ySpeed = Yspeed;
    }

    /**
     * Ticks up the DelayCounts and calls the methods for mario
     */
    public void act()
    {
        reloadDelayCount++;
        invincibilityTime--;
        time++;

        if (time == 3)
        {
            MovingEnemies.moveable = true;
        }

        checkWin();
        if (won)
        {
            return;
        }

        if (fell)
        {
            setLocation(getX(), getY() + 50);
            fall();
            return;
        }

        if (gotHit)
        {
            powerDown();
            return;
        }

        moveVertically();
        moveHorizontally();

        if (marioSetAsGun == false)
        {
            setMarioWithGun();
        }

        if (Bowser.part == 3)
        {
            won = true;
        }

        if (invincibilityTime < 0)
            removeMario();
        StatT.time++;
    }

    /**
     * Sets the SWorld booleans to the appropriate ones for Mario Having a Gun
     */
    private void setMarioWithGun()
    {
        SWorld sWorld = (SWorld) getWorld();
        sWorld.marioHasGun();
        marioSetAsGun = true;
    }

    /**
     * check if we are touching the goal posts if we are, play the winning sound and set the world
     * back to the map
     */
    public void checkWin()
    {
        if (getOneObjectAtOffset(0, 0, Pole.class) != null || won)
        {
            won = true;
            setImage(characterName + "winning.png");
            moveVertically();
            if (delay == 200)
                Greenfoot.playSound(characterName + "/winL.mp3");
            if (getWorld() instanceof MyWorld)
            {
                MyWorld myWorld = (MyWorld) getWorld();
                myWorld.stopMusic();
                delay--;
                if (getWorld().getObjects(Fader.class).isEmpty())
                {
                    getWorld().addObject(new Fader(0, false, true), 6000, 200);
                    Greenfoot.playSound("Clear.mp3");
                }
                if (delay < 250)
                    Black.launch = true;
                if (delay == 0)
                    Greenfoot.setWorld(new Map(1, 1, true));
            }

            if (getWorld() instanceof WorldTwo)
            {
                WorldTwo worldTwo = (WorldTwo) getWorld();
                worldTwo.stopMusic();
                delay--;
                if (getWorld().getObjects(Fader.class).isEmpty())
                {
                    getWorld().addObject(new Fader(0, false, true), 7935, 200);
                    Greenfoot.playSound("Clear.mp3");
                }
                if (delay == 250)
                    Black.launch = true;
                if (delay == 0)
                    Greenfoot.setWorld(new Map(2, 2, true));
            }

            if (getWorld() instanceof WorldThree)
            {
                WorldThree worldThree = (WorldThree) getWorld();
                worldThree.stopMusic();
                delay--;
                if (getWorld().getObjects(Fader.class).isEmpty())
                {
                    getWorld().addObject(new Fader(0, false, true), 7150, 200);
                    Greenfoot.playSound("Clear.mp3");
                }
                if (delay == 250)
                    Black.launch = true;
                if (delay == 0)
                    Greenfoot.setWorld(new Map(4, 4, true));
            }

            if (getWorld() instanceof Fortress)
            {
                Fortress worldFour = (Fortress) getWorld();
                worldFour.stopMusic();
                delay--;
                if (delay == 0)
                    Greenfoot.setWorld(new Map(5, 5, true));
            }
            else
            {

            }
        }
    }

    /**
     * do the things associated with falling
     */
    public void fall()
    {

        SWorld sWorld = (SWorld) getWorld();
        // sWorld.resetAmmo();
        scrolled = ((SWorld) getWorld()).getUnivX(getX());

        // scrolled = ((SWorld)getWorld()).getUnivX(getX());
        if (!lose)
        {
            Greenfoot.playSound("lose.mp3");
            // ySpeed = -15;
            // Greenfoot.delay(30);
            lose = true;
        }
        if (getWorld() instanceof MyWorld)
        {
            MyWorld.theme.stop();
        }
        if (getWorld() instanceof WorldTwo)
        {
            WorldTwo.music.stop();
        }
        if (getWorld() instanceof WorldThree)
        {
            WorldThree.music.stop();
        }
        if (getWorld() instanceof Fortress)
        {
            Fortress.music.stop();
        }
        if (getWorld() instanceof BossWorld)
        {
            BossWorld.music.stop();
            // Greenfoot.setWorld(new Fortress());
        }
        if (getWorld() instanceof Airship)
        {
            Airship.theme.stop();
        }
        Tower.theme.stop();
        delayTime--;
        // SWorld sWorld = (SWorld)getWorld();
        if (delayTime == 100)
        {
            sWorld.addObject(new Fader(0, false, true), scrolled > 350 ? scrolled : 350, 200);
        }
        if (delayTime != 0)
            return;
        if (getWorld() instanceof MyWorld)
        {

            Greenfoot.setWorld(new Map(1, 1, false));
        }
        if (getWorld() instanceof WorldTwo)
        {
            Greenfoot.setWorld(new Map(2, 2, false));
        }
        if (getWorld() instanceof WorldThree)
        {
            Greenfoot.setWorld(new Map(4, 4, false));
        }
        if (getWorld() instanceof Tower)
        {
            Greenfoot.setWorld(new Map(3, 3, false));
        }
        if (getWorld() instanceof Fortress)
        {
            Greenfoot.setWorld(new Map(5, 5, false));
        }
        if (getWorld() instanceof BossWorld)
        {
            Greenfoot.setWorld(new Map(5, 5, false));
        }

        if (getWorld() instanceof Airship)
        {
            Greenfoot.setWorld(new Map(false));
        }
    }

    /**
     * This will move mario based on whether or not there are objects around mario and keys are
     * pressed. If the w key is pressed while an object is underneath mario, he will jump. If the d
     * key is pressed and there is no block to the right of mario, he will move right. If the a key
     * is pressed and there is no block to the left of mario, he will move left.
     */
    public void moveHorizontally()
    {
        setLocation(getX() + (xSpeed), getY());

        while (getOneObjectAtOffset(getImage().getWidth() / 2, 0, Solid.class) != null)
        {
            setLocation(getX() - 1, getY());

            xSpeed = 0;
        }

        while (getOneObjectAtOffset(-getImage().getWidth() / 2, 0, Solid.class) != null)
        {
            setLocation(getX() + 1, getY());

            xSpeed = 0;
        }


        animateMario();
        if (Greenfoot.isKeyDown("right"))
        {

            if (xSpeed < 5 && time % 3 == 0)
            {
                xSpeed = xSpeed + 1;
            }
            SWorld sWorld = (SWorld) getWorld();
            sWorld.marioL = false;

        }

        if (Greenfoot.isKeyDown("left"))
        {

            if (xSpeed > -5 && time % 3 == 0)
            {
                xSpeed = xSpeed - 1;
            }

            SWorld sWorld = (SWorld) getWorld();
            sWorld.marioL = true;
        }
        if (!Greenfoot.isKeyDown("left") && !Greenfoot.isKeyDown("right"))
        {
            if (time % 3 == 0 && xSpeed != 0)
                if (xSpeed > 0)
                    xSpeed--;
                else if (xSpeed < 0)
                {
                    xSpeed++;
                }

        }
        if (Greenfoot.isKeyDown("up"))
        {
            jump();
            getWorld().removeObjects(getWorld().getObjects(LiveText.class));
            getWorld().removeObjects(getWorld().getObjects(LiveImage.class));
            getWorld().removeObjects(getWorld().getObjects(Intro1.class));
            getWorld().removeObjects(getWorld().getObjects(Intro2.class));
            getWorld().removeObjects(getWorld().getObjects(Intro3.class));
            getWorld().removeObjects(getWorld().getObjects(Intro4.class));
            getWorld().removeObjects(getWorld().getObjects(Intro5.class));
            getWorld().removeObjects(getWorld().getObjects(Intro6.class));
        }
        if (Greenfoot.isKeyDown("shift"))
        {
            shoot();
        }


        Actor checkPoint = getOneIntersectingObject(CheckPointD.class);

        if (checkPoint != null)
        {
            switch (getWorld().getClass().getName())
            {
                case "MyWorld":
                    MyWorld.flag = true;
                    break;
                case "WorldTwo":
                    WorldTwo.flag = true;
                    break;
                case "WorldThree":
                    WorldThree.flag = true;
                    break;
                case "Fortress":
                    Fortress.flag = true;
                    break;
                case "Tower":
                    Tower.flag = true;
                    break;
                case "Airship":
                    Airship.flag = true;
                    break;
            }
            SWorld world = (SWorld) getWorld();
            getWorld().addObject(new CheckPointA(), world.getUnivX(checkPoint.getX()),
                            world.getUnivY(checkPoint.getY()));
            getWorld().removeObject(checkPoint);

        }
    }

    /**
     * This method will move mario vertically and then check if he should be removed because he is
     * out of the world. It will also check if mario should kill an enemy which he is standing on.
     * If the s key is pressed and there is a pipe below mario, the world will change.
     */
    private void moveVertically()
    {
        ySpeed++;
        setLocation(getX(), getY() + ySpeed / 2);
        onGround = false;
        while (getOneObjectAtOffset(14, getImage().getHeight() / 2 - 2, Solid.class) != null)
        {
            setLocation(getX(), getY() - 1);
            onGround = true;
            ySpeed = 0;
        }

        while (getOneObjectAtOffset(14, getImage().getHeight() / 2 - 2, Solid.class) != null)
        {
            setLocation(getX(), getY() - 1);
            onGround = true;
            ySpeed = 0;
        }

        while (getOneObjectAtOffset(-14, getImage().getHeight() / 2 - 2, Solid.class) != null)
        {
            setLocation(getX(), getY() - 1);
            onGround = true;
            ySpeed = 0;
        }

        while (getOneObjectAtOffset(0, -getImage().getHeight() / 2 + 1, Solid.class) != null)
        {
            setLocation(getX(), getY() + 1);
            ySpeed = 0;
        }
        if (getY() >= 395)
        {
            fell = true;
            SWorld sWorld = (SWorld) getWorld();
            // sWorld.decreaseLives();
            sWorld.marioIsSmall();
            // sWorld.increaseLives();

        }

        Actor jumpable = getOneObjectAtOffset(0, getImage().getHeight() / 2, Jumpable.class);

        Actor jump = getOneObjectAtOffset(0, getImage().getHeight() / 2, Jump.class);

        Actor koopa = getOneObjectAtOffset(0, getImage().getHeight() / 2, Koopa.class);
        if (koopa != null)
        {
            ySpeed = -20;
            squish.play();


            Koopa.lose();

            return;
        }

        if (jumpable != null)
        {
            ySpeed = -20;
            squish.play();
            StatE.kills++;
            getWorld().removeObject(jumpable);
        }

        if (jump != null)
        {
            ySpeed = -20;
            bounce.play();
            getWorld().removeObject(jump);
        }


    }

    /**
     * This will animate mario based on these factors: Whether the boolean mLeft is true or false If
     * mario is currently moving If the DelayCounteer is higher than the image switch time
     */
    private void animateMario()
    {

        imageDelayCount++;

        if (Greenfoot.isKeyDown("left"))
        {
            if (imageDelayCount >= imageTime)// if it's time to change the image
            {
                if (countUp)
                    imageNumber++;
                else
                    imageNumber--;
                if (imageNumber == 4)// so we don't get an error
                {
                    imageNumber = 2;
                    countUp = false;
                }

                if (imageNumber == 0)// so we don't get an error
                {
                    imageNumber = 2;
                    countUp = true;
                }

                setImage(characterName + "mariogunL" + imageNumber + ".png");// it looks like we're
                                                                             // walking
                img = imageNumber;// so we can see what image we have
                imageDelayCount = 0;
            }

            if (getImage() == imageR1)
            {
                setImage(imageL1);
                imageDelayCount = 0;
            }
            if (getImage() == imageR2)
            {
                setImage(imageL1);
                imageDelayCount = 0;
            }
        }

        if (img == 2 && Greenfoot.isKeyDown("left") == false)// true
        {
            setImage(imageL1);
            img = 1;
        }

        if (img == 3 && Greenfoot.isKeyDown("left") == false)// true
        {
            setImage(imageL1);
            img = 1;
        }

        if (Greenfoot.isKeyDown("right"))
        {
            if (imageDelayCount >= imageTime)
            {
                imageNumber++;
                if (imageNumber == 4)
                {
                    imageNumber = 1;
                }
                setImage(characterName + "mariogunR" + imageNumber + ".png");
                img = imageNumber + 3;
                imageDelayCount = 0;
            }

            if (img == 1)
            {
                setImage(imageR1);
                img = 4;
                imageDelayCount = 0;
            }
            if (img == 2)
            {
                setImage(imageR1);
                img = 4;
                imageDelayCount = 0;
            }

            if (img == 3)
            {
                setImage(imageR1);
                img = 4;
                imageDelayCount = 0;
            }

        }

        if (img == 5 && !Greenfoot.isKeyDown("right"))// false
        {
            setImage(imageR1);
            img = 4;
        }

        if (img == 6 && !Greenfoot.isKeyDown("right"))// false
        {
            setImage(imageR1);
            img = 4;
        }

        // user added
        // if(Greenfoot.isKeyDown("left"))
        // {
        // sWorld.marioLeft();
        // }
        // if(Greenfoot.isKeyDown("right"))
        // {
        // sWorld.marioRight();
        // }
    }

    /**
     * This will remove mario if he is hit by an enemy or an enemy projectile. It will also add a
     * regular mario in the same place as MarioG was at. If mario is at the bottom of the world, it
     * will call the rebuildWorld method in whatever world mario is currently in. This will also
     * decrease the lives of the player
     */
    public void removeMario()
    {
        if (getY() >= 395)
        {
            fell = true;
            SWorld sWorld = (SWorld) getWorld();
            sWorld.marioIsSmall();
            // sWorld.decreaseLives();
        }
        if (getOneObjectAtOffset(-getImage().getWidth() / 2, 0, Jumpable.class) != null)
        {
            gotHit = true;
        }
        if (getOneObjectAtOffset(getImage().getWidth() / 2, 0, Jumpable.class) != null)
        {
            gotHit = true;
        }
        if (getOneObjectAtOffset(-getImage().getWidth() / 2, 0, Jump.class) != null)
        {
            gotHit = true;
        }
        if (getOneObjectAtOffset(0, -getImage().getHeight() / 2, Jump.class) != null)
        {
            gotHit = true;
        }

        if (getOneIntersectingObject(NonJumpable.class) != null)
        {
            if (!(getOneIntersectingObject(NonJumpable.class) instanceof BossShell)
                            || BossShell.hurtable)
                gotHit = true;
        }
        if (getOneIntersectingObject(NonJump.class) != null)
        {
            gotHit = true;
        }

        if (gotHit == true)
        {
            die.play();

        }

    }

    /**
     * This will cause mario to jump if he is on the ground (ySpeed set to -23)
     */
    private void jump()
    {
        if (onGround == true)
        {
            jump.play();
            ySpeed -= jSpeed;
        }
    }

    /**
     * This will add ammo to mario's gun and update the scoreboard based on which world mario is in
     */
    public void addAmmo()
    {
        // SWorld sWorld = (SWorld)getWorld();
        // sWorld.increaseAmmunition();
        // if (getWorld() instanceof MyWorld)
        // {
        // MyWorld myWorld = (MyWorld)sWorld;
        // myWorld.updateScoreboard();
        // }
        // if (getWorld() instanceof WorldTwo)
        // {
        // WorldTwo worldTwo = (WorldTwo)sWorld;
        // worldTwo.updateScoreboard();
        // }
        // if (getWorld() instanceof WorldThree)
        // {
        // WorldThree worldThree = (WorldThree)sWorld;
        // worldThree.updateScoreboard();
        // }
        // if (getWorld() instanceof Fortress)
        // {
        // Fortress Fortress = (Fortress)sWorld;
        // Fortress.updateScoreboard();
        // }
        // if (getWorld() instanceof BossWorld)
        // {
        // BossWorld bossWorld = (BossWorld)sWorld;
        // bossWorld.updateScoreboard();
        // }
    }

    /**
     * This will take ammo away from mario's gun and update the scoreboard based on which world
     * mario is in
     */
    public void decreaseAmmo()
    {
        // SWorld sWorld = (SWorld)getWorld();
        // sWorld.decreaseAmmunition();
        // if (getWorld() instanceof MyWorld)
        // {
        // MyWorld myWorld = (MyWorld)sWorld;
        // myWorld.updateScoreboard();
        // }
        // if (getWorld() instanceof WorldTwo)
        // {
        // WorldTwo worldTwo = (WorldTwo)sWorld;
        // worldTwo.updateScoreboard();
        // }
        // if (getWorld() instanceof WorldThree)
        // {
        // WorldThree worldThree = (WorldThree)sWorld;
        // worldThree.updateScoreboard();
        // }
        // if (getWorld() instanceof Fortress)
        // {
        // Fortress Fortress = (Fortress)sWorld;
        // Fortress.updateScoreboard();
        // }
        // if (getWorld() instanceof BossWorld)
        // {
        // BossWorld bossWorld = (BossWorld)sWorld;
        // bossWorld.updateScoreboard();
        // }
    }

    /**
     * This will shoot a bullet from mario's gun if the delay count is greater than or equal to the
     * reload time and if the gun has bullets to shoot
     */
    public void shoot()
    {
        SWorld sWorld = (SWorld) getWorld();
        bullets = sWorld.getAmmo();
        scrolled = ((SWorld) getWorld()).getUnivX(getX());
        if (reloadDelayCount >= gunReloadTime)
        {
            shot.play();
            int Y = ((SWorld) getWorld()).getUnivY(getY());
            ((SWorld) getWorld()).addObject(new FriendlyBullet(), scrolled, Y, true);
            reloadDelayCount = 0;
            decreaseAmmo();
        }

    }

    /**
     * When called, how many bullets mario has will be sent
     */
    public int getBullets()
    {
        return bullets;
    }

    /**
     * When called, the X coordinate of mario will be sent
     */
    public int getXCoord()
    {
        return getX();
    }

    public boolean getPulling()
    {
        return pulling;
    }

    public boolean getWon()
    {
        return won;
    }

    public void powerDown()
    {
        if (swaps < 6)
        {
            if (img == 9)
            {
                if (changedToSmall)
                {
                    if (imgBackTo == 1)
                    {
                        setImage(characterName + "marioL1.png");
                    }

                    if (imgBackTo == 2)
                    {
                        setImage(characterName + "marioL2.png");
                    }

                    if (imgBackTo == 3)
                    {
                        setImage(characterName + "marioR1.png");
                    }

                    if (imgBackTo == 4)
                    {
                        setImage(characterName + "marioR2.png");
                    }
                    img = 0;
                    changedToSmall = false;
                    swaps++;
                }
            }
            else
            {
                if (img == 1 || imgBackTo == 1)
                {
                    imgBackTo = 1;
                    setImage(characterName + "mariogunL1.png");
                    imgBackTo = 1;
                    img = 9;
                }

                if (img == 2 || imgBackTo == 2)
                {
                    imgBackTo = 2;
                    setImage(characterName + "mariogunL2.png");
                    imgBackTo = 2;
                    img = 9;
                }

                if (img == 3 || imgBackTo == 3)
                {
                    imgBackTo = 2;
                    setImage(characterName + "mariogunL3.png");
                    imgBackTo = 3;
                    img = 9;
                }

                if (img == 4 || imgBackTo == 4)
                {
                    imgBackTo = 4;
                    setImage(characterName + "mariogunR1.png");
                    imgBackTo = 4;
                    img = 9;
                }

                if (img == 5 || imgBackTo == 5)
                {
                    imgBackTo = 5;
                    setImage(characterName + "mariogunR2.png");
                    img = 9;
                    imgBackTo = 5;
                }

                if (img == 6 || imgBackTo == 6)
                {
                    imgBackTo = 6;
                    setImage(characterName + "mariogunR3.png");
                    img = 9;
                    imgBackTo = 6;
                }
                swaps++;

                changedToSmall = true;
            }
        }
        else
        {
            SWorld world = (SWorld) getWorld();
            Actor futureMain = new Mario(ySpeed);
            world.addObject(futureMain, getX(), getY(), false);
            world.mainActor = futureMain;
            setLocation(getX(), getY());
            gotHit = false;
            invincibilityDelayCount = 0;
            world.removeObject(this);
        }
        Greenfoot.delay(5);
        MovingEnemies.moveable = false;
        if (getWorld() == null)
            return;
        growHelp();
    }

    public void growHelp()
    {
        if (onGround)
            setLocation(getX(), getY() + 10);
        while (getOneObjectAtOffset(14, getImage().getHeight() / 2 - 2, Solid.class) != null)
        {
            setLocation(getX(), getY() - 1);
            onGround = true;
            ySpeed = 0;
        }

        while (getOneObjectAtOffset(14, getImage().getHeight() / 2 - 2, Solid.class) != null)
        {
            setLocation(getX(), getY() - 1);
            onGround = true;
            ySpeed = 0;
        }

        while (getOneObjectAtOffset(-14, getImage().getHeight() / 2 - 2, Solid.class) != null)
        {
            setLocation(getX(), getY() - 1);
            onGround = true;
            ySpeed = 0;
        }

        while (getOneObjectAtOffset(0, -getImage().getHeight() / 2 + 1, Solid.class) != null)
        {
            setLocation(getX(), getY() + 1);
            ySpeed = 0;
        }


    }
}
