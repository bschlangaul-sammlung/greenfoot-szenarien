import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * MarioS is the worst version of mario. He is the main actor. If he is hit, he will die and the level will restart with one less life.
 * 
 * @author (Dylan Powell, Sean Eastley) 
 * @version (January 21, 2015)
 */

public class MarioS extends AllMarios
{
    private int invincibilityTime; //this is the number that the invincibilityDelayCount must pass before invincibility runs out
    private int invincibilityDelayCount; //this number ticks up to determine how long you are invincible
    private int imageTime; //this is the number that the imagedDelayCount must pass before the image switches
    private int imageDelayCount; //this number ticks up to time the image switch
    final int jSpeed = 23; //this number determines how high you jump
    private int ySpeed = 0; //this number determines how fast you are moving up and down
    private int xSpeed; //this int determines how fast mario is moving in the x direction
    private boolean onGround; //this boolean shows whether or not you are on the ground
    public static boolean gotHit = false; //this boolean shows whether or not mario was hit
    private boolean mLeft; //this boolean shows whether or not mario is left
    private boolean terrainLeft; //this boolean shows whether or not the platform below mario is moving left or right
    public boolean marioSetAsSmall = false; //this boolean shows whether or not sWorld has had its variables set for mario being small
    public static boolean fell = false; //this boolean determines whether or not mario has fallen off of the world
    private int scrolled; //this int determines how far mario has moved in the x direction
    private int livesLeft; //this int stores how many lives the player has left
    private GreenfootImage imageL1;
    private GreenfootImage imageR1;
    private GreenfootImage imageL2;
    private GreenfootImage imageR2;
    GreenfootSound grow = new GreenfootSound("Grow.mp3");
    // GreenfootSound die = new GreenfootSound("Downed.wav");
    GreenfootSound jump = new GreenfootSound("Jump.wav");
    GreenfootSound squish = new GreenfootSound("Squish.wav");
    GreenfootSound bounce = new GreenfootSound("Shell.wav");
    // GreenfootSound down = new GreenfootSound("win2.mp3");
    public boolean pulling = false;
    public boolean won = false;
    public int delay = 340;
    public int position = 0;
    public boolean played = false;
    public boolean sound = false;
    public boolean lose = false;
    public int delayTime = 200;
    public int time;
    public int img = 1;
    public int imageNumber = 1;
    public static String characterName = "mario";
    public int swaps;
    public int imgBackTo = 0;
    public boolean powerUp = false;
    public boolean changedToSmall = false;
    public boolean growing2 = false;
    public boolean isLeft = true;
    public int startTime = 30;
    /**
     * This will define variables for MarioS.
     */
    public MarioS()
    {
        imageL1 = new GreenfootImage(characterName + "marioSL1.png");
        imageR1 = new GreenfootImage(characterName + "marioSR1.png");
        imageL2 = new GreenfootImage(characterName + "marioSL2.png");
        imageR2 = new GreenfootImage(characterName + "marioSR2.png");
        invincibilityTime = 50;
        MovingEnemies.moveable = true;
        setImage(imageL1);
        invincibilityDelayCount = 6;
        imageTime = 12;
        imageDelayCount = 0;
        xSpeed = 0;
        gotHit = false;
        fell = false;
        MovingEnemies.moveable = true;
    }

    /**
     * Mario continues jumping if he is hit midair
     */
    public MarioS(int Yspeed)
    {
        imageL1 = new GreenfootImage(characterName + "marioSL1.png");
        imageR1 = new GreenfootImage(characterName + "marioSR1.png");
        imageL2 = new GreenfootImage(characterName + "marioSL2.png");
        imageR2 = new GreenfootImage(characterName + "marioSR2.png");
        invincibilityTime = 50;

        MovingEnemies.moveable = true;

        setImage(imageL1);

        invincibilityDelayCount = 6;
        imageTime = 12;
        imageDelayCount = 0;
        xSpeed = 0;
        gotHit = false;
        fell = false;
        MovingEnemies.moveable = true;
        ySpeed = Yspeed;
    }

    /**
     * Ticks up the DelayCounts and calls the methods for mario
     */
    public void act() 
    {
        time++;

        StatT.time++;
        invincibilityTime--;
        imageDelayCount++;

        if (time == 3)
        {
            MovingEnemies.moveable = true;
        }

        win();

        if (won)
        {
            return;
        }

        if (gotHit)//do the death animation and nothing more
        {
            getHit();
            return;
        }

        if(powerUp)//make character big and nothing more
        {
            growing();
            return;
        }

        if (growing2)//make fire character and nothing more
        {
            grow2();
            return;
        }

        if (fell)// fall and nothing more
        {
            setLocation(getX(),getY()+50);
            fall();
            return;
        }
        
        {

            moveVertically();
            moveHorizontally();

        }
        if (!marioSetAsSmall)
        {
            setMarioAsSmall();
        }

        if(Bowser.part == 3)
        {
            won = true;
        }
        if (invincibilityTime < 0)
        removeMario();

    } 

    public void getHit()
    {
        ySpeed ++;

        try//it doesn't work sometimes
        {
            setLocation(getX(), getY()+ySpeed/2);
        }
        catch(IllegalStateException error)
        {
            return;
        }

        if (gotHit == true)
        {
            SWorld sWorld = (SWorld)getWorld();
            setImage(characterName + "lose.png");
            scrolled = ((SWorld)getWorld()).getUnivX(getX());
            // sWorld.resetAmmo();
            // if(!played) {Greenfoot.playSound("lose.mp3");played = true;}

            MyWorld.theme.stop();

            WorldTwo.music.stop();

            WorldThree.music.stop();

            Fortress.music.stop();

            BossWorld.music.stop();
            BossShell.slide.stop();
            if (getWorld() instanceof Airship)
            {
                Airship.theme.stop();
            }

            BossWorld2.music.stop();
            KoopaWorld.music.stop();
            Tower.theme.stop();
            if(!lose)
            {
                Greenfoot.playSound("lose.mp3");
                ySpeed = -15;
                Greenfoot.delay(30);
                Greenfoot.playSound(characterName + "oops.mp3");
                lose = true;
            }
            delayTime--;

            if(delayTime == 100)
            {
                sWorld.addObject(new Fader(0,false,true),scrolled > 350?scrolled:350,200);
            }

            if(delayTime > 0)
                return;

            switch (getWorld().getClass().getName())
            {
                case "MyWorld":Greenfoot.setWorld(new Map(1,1,false));break;
                case "WorldTwo":Greenfoot.setWorld(new Map(2,2,false));break;
                case "WorldThree":Greenfoot.setWorld(new Map(4,4,false));break;
                case "Fortress":Greenfoot.setWorld(new Map(5,5,false));break;
                case "Tower":Greenfoot.setWorld(new Map(3,3,false));break;
                case "KoopaWorld":Greenfoot.setWorld(new Map(3,3,false));break;
                case "BossWorld":Greenfoot.setWorld(new Map(5,5,false));break;
                case "BossWorld2":Greenfoot.setWorld(new Map(true));break;
                case "Airship":Greenfoot.setWorld(new Map(false));break;
            }
            

        }
    }

    /**
     * Sets the SWorld booleans to the appropriate ones for Mario being small
     */
    private void setMarioAsSmall()
    {
        SWorld sWorld = (SWorld)getWorld();
        sWorld.marioIsSmall();
        marioSetAsSmall= true;
    }

    /**
     * does the things associated with winning
     */
    public void win()
    {
        if (getOneObjectAtOffset(0,0,Pole.class) != null || won)
        {
            won = true;
            moveVertically();
            if (delay == 200)Greenfoot.playSound(characterName + "winL.mp3");
            if (getWorld() instanceof MyWorld)
            {
                MyWorld myWorld = (MyWorld)getWorld();
                myWorld.stopMusic();
                delay--;
                if (getWorld().getObjects(Fader.class).isEmpty())
                {
                    getWorld().addObject(new Fader(0,false,true),6000,200);
                    Greenfoot.playSound("Clear.mp3");
                }
                if (delay == 250)Black.launch = true;
                if(delay == 0)
                    Greenfoot.setWorld(new Map(1,1,true));
            }

            if (getWorld() instanceof WorldTwo)
            {
                WorldTwo worldTwo = (WorldTwo)getWorld();
                worldTwo.stopMusic();
                delay--;
                if (getWorld().getObjects(Fader.class).isEmpty())
                {
                    getWorld().addObject(new Fader(0,false,true),7935,200);
                    Greenfoot.playSound("Clear.mp3");
                }
                if (delay == 250)Black.launch = true;
                if(delay == 0)
                    Greenfoot.setWorld(new Map(2,2,true));
            }

            if (getWorld() instanceof WorldThree)
            {
                WorldThree worldThree = (WorldThree)getWorld();
                worldThree.stopMusic();
                delay--;
                if (getWorld().getObjects(Fader.class).isEmpty())
                {
                    getWorld().addObject(new Fader(0,false,true),7150,200);
                    Greenfoot.playSound("Clear.mp3");
                }
                if (delay == 250)Black.launch = true;
                if(delay == 0)
                    Greenfoot.setWorld(new Map(4,4,true));
            }

            if (getWorld() instanceof Fortress)
            {
                Fortress worldFour = (Fortress)getWorld();
                worldFour.stopMusic();
                delay--;
                if(delay == 0)
                    Greenfoot.setWorld(new Map(5,5,true));
            }
            else
            {
                
            }
        }
    }

    /**
     * This will move mario based on whether or not there are objects around mario and keys are pressed.
     * If the w key is pressed while an object is underneath mario, he will jump. 
     * If the d key is pressed and there is no block to the right of mario, he will move right.
     * If the a key is pressed and there is no block to the left of mario, he will move left.
     * If the s key is pressed and there is a pipe below mario, the world will change.
     */
    public void moveHorizontally()
    {
        if (!fell) setLocation(getX()+xSpeed, getY());

        while (getOneObjectAtOffset (getImage().getWidth()/2, 0, Solid.class) != null)
        {
            setLocation(getX()-1, getY());

            xSpeed = 0;
        }

        while (getOneObjectAtOffset (-getImage().getWidth()/2, 0, Solid.class) != null)
        {
            setLocation(getX()+1, getY());

            xSpeed = 0;
        }

        animateMario();
        if (Greenfoot.isKeyDown("right"))
        {
            if (xSpeed < 0)
            {
                xSpeed = 0;
            }
            if (xSpeed < 5)
            {
                xSpeed = xSpeed +1;
            }
            SWorld sWorld = (SWorld)getWorld();
            sWorld.marioL = false;
            animateMario();
        }

        if (Greenfoot.isKeyDown("left"))
        {
            if (xSpeed > 0)
            {
                xSpeed = 0;
            }
            if (xSpeed > - 5)
            {
                xSpeed = xSpeed -1;
            }
            SWorld sWorld = (SWorld)getWorld();
            sWorld.marioL = true;
            animateMario();
        }

        if (!Greenfoot.isKeyDown("left") && !Greenfoot.isKeyDown("right"))
        {
            xSpeed = 0;
        }

        if (Greenfoot.isKeyDown("up"))
        {
            jump();
            getWorld().removeObjects(getWorld().getObjects(Text.class));
            getWorld().removeObjects(getWorld().getObjects(Intros.class));
        }

        Actor checkPoint = getOneIntersectingObject(CheckPointD.class);

        if (checkPoint != null)
        {
            switch (getWorld().getClass().getName())
            {
                case "MyWorld":MyWorld.flag = true;break;
                case "WorldTwo":WorldTwo.flag = true;break;
                case "WorldThree":WorldThree.flag = true;break;
                case "Fortress":Fortress.flag = true;break;
                case "Tower":Tower.flag = true;break;
                case "Airship":Airship.flag = true;break;
            }
            SWorld world = (SWorld)getWorld();
            getWorld().addObject(new CheckPointA(),world.getUnivX(checkPoint.getX()),world.getUnivY(checkPoint.getY()));
            getWorld().removeObject(checkPoint);
            grow();
        }
    }

    /**
     * This method will move mario vertically and then check if he should be removed because he is out of the world.
     * It will also check if mario should kill an enemy which he is standing on.
     */
    private void moveVertically()
    {

        ySpeed ++;
        setLocation(getX(), getY()+ySpeed/2);
        onGround = false;

        while (getOneObjectAtOffset (14, getImage().getHeight()/2 - 2, Solid.class)!= null)
        {
            setLocation(getX(), getY()-1);
            onGround = true;
            ySpeed = 0;
        }

        while (getOneObjectAtOffset (14, getImage().getHeight()/2 - 2, Solid.class)!= null)
        {
            setLocation(getX(), getY()-1);
            onGround = true;
            ySpeed = 0;
        }

        while (getOneObjectAtOffset (-14, getImage().getHeight()/2 - 2, Solid.class)!= null)
        {
            setLocation(getX(), getY()-1);
            onGround = true;
            ySpeed = 0;
        }

        while (getOneObjectAtOffset (0, -getImage().getHeight()/2+1, Solid.class)!= null)
        {
            setLocation(getX(), getY()+1);
            ySpeed = 0;
        }

        // while (getOneObjectAtOffset (0, getImage().getHeight()/2+1, Solid.class)!= null)
        // {
        // setLocation(getX(), getY()-1);
        // ySpeed = 0;
        // }

        if(getY() >= 395)
        {
            fell = true;
            SWorld sWorld = (SWorld)getWorld();
            // sWorld.decreaseLives();
            sWorld.marioIsSmall();
            // sWorld.increaseLives();

        }
        Actor enemy = getOneObjectAtOffset (0, getImage().getHeight()/2, MovingEnemies.class);

        Actor shell = getOneObjectAtOffset (0, getImage().getHeight()/2, Shell.class);
        Actor cannonball = getOneObjectAtOffset (0, getImage().getHeight()/2, Cannonball.class);
        Actor koopa = getOneObjectAtOffset (0, getImage().getHeight()/2, Koopa.class);
        if(koopa != null)
        {
            ySpeed = -20;
            squish.play();
            
            Koopa.lose();
            
            return;
        }

        if(enemy != null)
        {
            ySpeed = -20;
            squish.play();
            StatE.kills++;
            getWorld().removeObject(enemy);
        }

        if(shell != null)
        {
            ySpeed = -20;
            bounce.play();
            getWorld().removeObject(shell);
        }

        if(cannonball != null)
        {
            ySpeed = -20;
            bounce.play();
            getWorld().removeObject(cannonball);
        }
    }

    /**
     * This will animate mario based on these factors:
     * Whether the boolean mLeft is true or false
     * If mario is currently moving
     * If the DelayCounteer is higher than the image switch time
     */
    private void animateMario()
    {
        if (Greenfoot.isKeyDown("left"))
        {
            isLeft = true;
            if (imageDelayCount >= imageTime)//if it's time to change the image
            {
                imageNumber++;

                if (imageNumber == 3)//so we don't get an error
                {
                    imageNumber = 1;
                }

                setImage(characterName +"marioSL" + imageNumber + ".png");//it looks like we're walking
                img = imageNumber;//so we can see what image we have
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

        if (img == 2  && !Greenfoot.isKeyDown("left"))//true
        {
            setImage(imageL1);
            img = 1;
        }

        if (Greenfoot.isKeyDown("right"))
        {
            isLeft = false;
            if (imageDelayCount >= imageTime)
            {
                imageNumber++;
                if (imageNumber == 3)
                {
                    imageNumber = 1;
                }
                setImage(characterName + "marioSR" + imageNumber + ".png");
                img = imageNumber + 2;
                imageDelayCount = 0;
            }

            if (img == 1)
            {
                setImage(imageR1);
                img = 3;
                imageDelayCount = 0;
            }
            if (img == 2)
            {
                setImage(imageR1);
                img = 3;
                imageDelayCount = 0;
            }

        }

        if (img == 4 && !Greenfoot.isKeyDown("right"))//false
        {
            setImage(imageR1);
            img = 3;
        }
    }

    /**
     * do the things ascociated with falling out of the world
     */
    public void fall()
    {
        SWorld sWorld = (SWorld)getWorld();
        scrolled = ((SWorld)getWorld()).getUnivX(getX());
        if(!lose)
        {
            Greenfoot.playSound("lose.mp3");
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
        if(delayTime == 100)
        {
            sWorld.addObject(new Fader(0,false,true),scrolled > 350?scrolled:350,200);
        }
        if(delayTime != 0)
            return;
        if (getWorld() instanceof MyWorld)
        {
            Greenfoot.setWorld(new Map(1,1,false));
        }
        if (getWorld() instanceof WorldTwo)
        {
            Greenfoot.setWorld(new Map(2,2,false));
        }
        if (getWorld() instanceof Tower)
        {
            Greenfoot.setWorld(new Map(3,3,false));
        }
        if (getWorld() instanceof WorldThree)
        {
            Greenfoot.setWorld(new Map(4,4,false));
        }
        if (getWorld() instanceof Fortress)
        {
            Greenfoot.setWorld(new Map(5,5,false));
        }
        if (getWorld() instanceof BossWorld)
        {
            Greenfoot.setWorld(new Map(5,5,false));
        }

        if (getWorld() instanceof Airship)
        {
            Greenfoot.setWorld(new Map(false));
        }
    }

    /**
     * This will remove mario if he is hit by an enemy or an enemy projectile. It will also add a regular mario in the same place as MarioG was at.
     * If mario is at the bottom of the world, it will call the rebuildWorld method in whatever world mario is currently in.
     * This will also decrease the lives of the player
     */
    public void removeMario()
    {
        if(getY() >= 395)
        {
            fell = true;
            SWorld sWorld = (SWorld)getWorld();
            sWorld.marioIsSmall();
            // sWorld.decreaseLives();
        }
        if (getOneObjectAtOffset (-getImage().getWidth()/2, 0, Jumpable.class)!= null)
        {
            gotHit = true;
        }
        if (getOneObjectAtOffset (getImage().getWidth()/2, 0, Jumpable.class)!= null)
        {
            gotHit = true;
        }
        if (getOneObjectAtOffset (-getImage().getWidth()/2, 0, Jump.class)!= null)
        {
            gotHit = true;
        }
        if (getOneObjectAtOffset (0, -getImage().getHeight()/2, Jump.class)!= null)
        {
            gotHit = true;
        }
        
        if (getOneIntersectingObject (NonJumpable.class)!= null)
        {
            if (!(getOneIntersectingObject(NonJumpable.class) instanceof BossShell) || BossShell.hurtable )gotHit = true;
        }
        if (getOneIntersectingObject (NonJump.class)!= null)
        {
            gotHit = true;
        }
        
        

    }

    /**
     * This will add ammo to mario's gun and update the scoreboard based on which world mario is in
     */
    public void addAmmo()
    {
        SWorld sWorld = (SWorld)getWorld();
        sWorld.increaseAmmunition();
        if (getWorld() instanceof MyWorld)
        {
            MyWorld myWorld = (MyWorld)sWorld;
            myWorld.updateScoreboard();

        }
        if (getWorld() instanceof WorldTwo)
        {
            WorldTwo worldTwo = (WorldTwo)sWorld;
            worldTwo.updateScoreboard();
        }
        if (getWorld() instanceof WorldThree)
        {
            WorldThree worldThree = (WorldThree)sWorld;
            worldThree.updateScoreboard();
        }
        if (getWorld() instanceof Fortress)
        {
            Fortress worldFour = (Fortress)sWorld;
            worldFour.updateScoreboard();
        }
        if (getWorld() instanceof BossWorld)
        {
            BossWorld bossWorld = (BossWorld)sWorld;
            bossWorld.updateScoreboard();
        }
    }

    /**
     * When called, this method will replace small mario with big mario
     */
    public void grow()
    {
        if(!gotHit)
        {
            while(!grow.isPlaying()) grow.play();
            powerUp = true;
        }

    }

    public void growing()
    {
        if (time % 5 == 0)
        {
            if (swaps < 6)
            {
                if (!changedToSmall)
                {
                    if (isLeft)
                    {
                        setImage(characterName + "marioSL1.png");
                    }
                    else
                    {                    
                        setImage(characterName + "marioSR1.png");
                    }
                    changedToSmall = true;
                    swaps++;
                    return;
                }
                else
                {
                    if (isLeft)
                    {
                        setImage(characterName + "marioL1.png");
                    }
                    else
                    {
                        setImage(characterName + "marioR1.png");
                    }
                    changedToSmall = false;
                    swaps++;
                }
            }
            else
            {
                SWorld world = (SWorld)getWorld();    
                Actor futureMain = new Mario(ySpeed);
                world.addObject(futureMain, getX(), getY(), false); 
                world.mainActor = futureMain;
                setLocation(getX(), getY());
                gotHit = false;
                invincibilityDelayCount = 0;
                world.removeObject(this);
                return;
            }
            if (getWorld() == null) return;
            growHelp();

            MovingEnemies.moveable = false;
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
     * When called, the X coordinate of mario will be sent
     */
    public int getXCoord()
    {
        return getX();
    }

    public void grow2()
    {
        growing2 = true;
        if (time % 5 == 0)
        {
            if (swaps == 1)
            {
                grow.play();
            }

            if (swaps < 6)
            {

                if (changedToSmall)
                {
                    if(isLeft)
                    {
                        setImage(characterName + "mariogunL1.png");
                    }
                    else
                    {
                        setImage(characterName + "mariogunR1.png");
                    }

                    changedToSmall = false;
                    swaps++;
                }

                else
                {
                    if(isLeft)
                    {
                        setImage(characterName + "marioSL1.png");
                    }
                    else
                    {
                        setImage(characterName + "marioSR1.png");
                    }

                    swaps++;
                    changedToSmall = true;
                }
            }
            else
            {
                SWorld world = (SWorld)getWorld();    
                Actor futureMain = new MarioG(ySpeed);
                world.addObject(futureMain, getX(), getY(), false); 
                world.mainActor = futureMain;
                setLocation(getX(), getY());
                gotHit = false;
                invincibilityDelayCount = 0;
                world.removeObject(this);
            }

            MovingEnemies.moveable = false;
        }
        if(getWorld() == null) return;
        growHelp();

    }

    public void growHelp()
    {
        if (onGround) setLocation(getX(),getY()+10);
        while (getOneObjectAtOffset (14, getImage().getHeight()/2 - 2, Solid.class)!= null)
        {
            setLocation(getX(), getY()-1);
            onGround = true;
            ySpeed = 0;
        }

        while (getOneObjectAtOffset (14, getImage().getHeight()/2 - 2, Solid.class)!= null)
        {
            setLocation(getX(), getY()-1);
            onGround = true;
            ySpeed = 0;
        }

        while (getOneObjectAtOffset (-14, getImage().getHeight()/2 - 2, Solid.class)!= null)
        {
            setLocation(getX(), getY()-1);
            onGround = true;
            ySpeed = 0;
        }

        while (getOneObjectAtOffset (0, -getImage().getHeight()/2+1, Solid.class)!= null)
        {
            setLocation(getX(), getY()+1);
            ySpeed = 0;
        }

    }
}
