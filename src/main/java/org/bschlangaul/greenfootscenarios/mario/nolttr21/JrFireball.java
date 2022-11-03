package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JrFireball here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JrFireball extends NonJump
{
    public boolean decided = false;
    public int target;
    public int time;

    /**
     * Act - do whatever the JrFireball wants to do. This method is called whenever the 'Act' or
     * 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        time++;

        turnTowards(target, getY());
        // if (getX() > target)
        // {
        // if (getRotation() < 260) turn(5);
        // }
        // else
        // {
        // if (getRotation() > 90) turn(-5);
        // }



        setLocation(getX(), getY() + 1);
        try
        {
            Actor mario = getWorld().getObjects(Mario.class).get(0);
            if (mario != null)
            {
                target = mario.getX();
            }
        } catch (IndexOutOfBoundsException c)
        {

        }
        try
        {
            Actor marioG = getWorld().getObjects(MarioG.class).get(0);
            if (marioG != null)
            {
                target = marioG.getX();
            }
        } catch (IndexOutOfBoundsException c)
        {

        }

        try
        {
            Actor marioS = getWorld().getObjects(MarioS.class).get(0);
            if (marioS != null)
            {
                if (marioS.getX() > this.getX())
                {
                    turn(-1);
                }
                else
                {
                    turn(-1);
                }
            }
        } catch (IndexOutOfBoundsException c)
        {

        }

        // decided = true;


        move(1);

        if (isTouching(LongBrick.class) || isTouching(Brick.class) || isTouching(Block.class))
        {
            getWorld().removeObject(this);
        }
    }


}
