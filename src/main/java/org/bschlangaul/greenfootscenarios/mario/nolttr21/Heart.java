package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The heart is a powerup that will add to mario's lives when it collides with him.
 *
 * @author (Dylan Powell and Sean Eastley)
 * @version (January 21, 2015)
 */
public class Heart extends Powerups
{
    private int ySpeed; // This will determine how fast the heart is falling
    private boolean hitEdge = false; // This will determine whether the heart should move right or
                                     // left
    private boolean terrainLeft; // This will determine whether the platform below the heart is
                                 // moving right or left
    GreenfootSound oneup = new GreenfootSound("Heart.wav");
    public int spawning = 0;

    /**
     * This will call the methods for moving the heart and checking if it was hit.
     */
    public void act()
    {
        if (spawning > 25)
        {
            moveHeart();
            checkHit();
        }
        else
        {
            setLocation(getX(), getY() - 1);
            spawning++;
        }
    }

    /**
     * This method will check if the heart is colliding with mario. If it is colliding with mario,
     * the heart will be removed, the sound effect will be played and the lives counter will be
     * updated. The scoreboard will also be updated based on which world the heart is in.
     */
    private void checkHit()
    {
        MarioG g = (MarioG) getOneIntersectingObject(MarioG.class);
        Mario m = (Mario) getOneIntersectingObject(Mario.class);
        MarioS s = (MarioS) getOneIntersectingObject(MarioS.class);
        if (g != null)
        {
            oneup.play();
            SWorld sWorld = (SWorld) getWorld();
            sWorld.increaseLives();
            if (getWorld() instanceof MyWorld)
            {
                MyWorld myWorld = (MyWorld) sWorld;
                myWorld.updateScoreboard();
            }
            if (getWorld() instanceof WorldTwo)
            {
                WorldTwo worldTwo = (WorldTwo) sWorld;
                worldTwo.updateScoreboard();
            }
            if (getWorld() instanceof WorldThree)
            {
                WorldThree worldThree = (WorldThree) sWorld;
                worldThree.updateScoreboard();
            }
            if (getWorld() instanceof Fortress)
            {
                Fortress worldFour = (Fortress) sWorld;
                worldFour.updateScoreboard();
            }
            getWorld().removeObject(this);
        }
        if (m != null)
        {
            oneup.play();
            SWorld sWorld = (SWorld) getWorld();
            sWorld.increaseLives();
            if (getWorld() instanceof MyWorld)
            {
                MyWorld myWorld = (MyWorld) sWorld;
                myWorld.updateScoreboard();
            }
            if (getWorld() instanceof WorldTwo)
            {
                WorldTwo worldTwo = (WorldTwo) sWorld;
                worldTwo.updateScoreboard();
            }
            if (getWorld() instanceof WorldThree)
            {
                WorldThree worldThree = (WorldThree) sWorld;
                worldThree.updateScoreboard();
            }
            if (getWorld() instanceof Fortress)
            {
                Fortress worldFour = (Fortress) sWorld;
                worldFour.updateScoreboard();
            }
            getWorld().removeObject(this);
        }
        if (s != null)
        {
            oneup.play();
            SWorld sWorld = (SWorld) getWorld();
            sWorld.increaseLives();
            if (getWorld() instanceof MyWorld)
            {
                MyWorld myWorld = (MyWorld) sWorld;
                myWorld.updateScoreboard();
            }
            if (getWorld() instanceof WorldTwo)
            {
                WorldTwo worldTwo = (WorldTwo) sWorld;
                worldTwo.updateScoreboard();
            }
            if (getWorld() instanceof WorldThree)
            {
                WorldThree worldThree = (WorldThree) sWorld;
                worldThree.updateScoreboard();
            }
            if (getWorld() instanceof Fortress)
            {
                Fortress worldFour = (Fortress) sWorld;
                worldFour.updateScoreboard();
            }
            getWorld().removeObject(this);
        }
    }

    /**
     * This method will move the heart. If there is a block to the right of the heart, it will move
     * left until it hits another object. If there is a block to the left of the heart, it will move
     * left until it hits another object. If there is no object below the heart, it will fall until
     * there is an object underneath the heart.
     */
    public void moveHeart()
    {
        ySpeed++;
        setLocation(getX(), getY() + ySpeed / 2);
        while (getOneObjectAtOffset(0, getImage().getHeight() / 2, Ground.class) != null)
        {
            setLocation(getX(), getY() - 1);
            ySpeed = 0;
        }
        while (getOneObjectAtOffset(0, getImage().getHeight() / 2, Brick.class) != null)
        {
            setLocation(getX(), getY() - 1);
            ySpeed = 0;
        }
        while (getOneObjectAtOffset(0, getImage().getHeight() / 2, LongBrick.class) != null)
        {
            setLocation(getX(), getY() - 1);
            ySpeed = 0;
        }
        while (getOneObjectAtOffset(0, getImage().getHeight() / 2, Block.class) != null)
        {
            setLocation(getX(), getY() - 1);
            ySpeed = 0;
        }
        while (getOneObjectAtOffset(0, getImage().getHeight() / 2 - 4, VerPlatform.class) != null)
        {
            setLocation(getX(), getY() - 1);
            ySpeed = 0;
        }
        while (getOneObjectAtOffset(0, getImage().getHeight() / 2 - 4, HorPlatform.class) != null)
        {
            setLocation(getX(), getY() - 1);
            ySpeed = 0;
            terrainLeft = ((HorPlatform) getOneIntersectingObject(HorPlatform.class)).getLeft();
            if (terrainLeft == true)
            {
                move(-2);
            }
            if (terrainLeft == false)
            {
                move(2);
            }
        }
        while (getOneObjectAtOffset(getImage().getWidth() / 2 + 1, 0, Block.class) != null)
        {
            move(-1);
            hitEdge = true;
        }
        while (getOneObjectAtOffset(-getImage().getWidth() / 2 - 1, 0, Block.class) != null)
        {
            move(1);
            hitEdge = false;
        }
        while (getOneObjectAtOffset(getImage().getWidth() / 2 + 1, 0, Brick.class) != null)
        {
            move(-1);
            hitEdge = true;
        }
        while (getOneObjectAtOffset(-getImage().getWidth() / 2 - 1, 0, Brick.class) != null)
        {
            move(1);
            hitEdge = false;
        }
        while (getOneObjectAtOffset(getImage().getWidth() / 2 + 1, 0, HorPlatform.class) != null)
        {
            move(-1);
            hitEdge = true;
        }
        while (getOneObjectAtOffset(-getImage().getWidth() / 2 - 1, 0, HorPlatform.class) != null)
        {
            move(1);
            hitEdge = false;
        }
        while (getOneObjectAtOffset(getImage().getWidth() / 2 + 1, 0, VerPlatform.class) != null)
        {
            move(-1);
            hitEdge = true;
        }
        while (getOneObjectAtOffset(-getImage().getWidth() / 2 - 1, 0, VerPlatform.class) != null)
        {
            move(1);
            hitEdge = false;
        }
        while (getOneObjectAtOffset(getImage().getWidth() / 2 + 1, 0, LongBrick.class) != null)
        {
            move(-1);
            hitEdge = true;
        }
        while (getOneObjectAtOffset(-getImage().getWidth() / 2 - 1, 0, LongBrick.class) != null)
        {
            move(1);
            hitEdge = false;
        }
        if (hitEdge == false)
        {
            move(5);
        }
        else if (hitEdge == true)
        {
            move(-5);
        }

    }
}
