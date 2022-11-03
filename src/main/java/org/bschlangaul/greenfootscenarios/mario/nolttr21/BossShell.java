package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossShell here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BossShell extends NonJumpable
{
    public int speed;
    public int life;
    public boolean left = true;
    public boolean onGround = false;
    public int ySpeed;
    public int health;
    public int initialDelay = 30;
    public static GreenfootSound slide = new GreenfootSound("slide.wav");
    public static boolean hurtable = false;

    public BossShell(int hp)
    {
        speed = 20 - (5 * hp);
        life = 400 - (100 * hp);
        GreenfootImage img = getImage();
        img.scale(50, 50);
        health = hp;
        hurtable = false;
    }

    /**
     * Act - do whatever the BossShell wants to do. This method is called whenever the 'Act' or
     * 'Run' button gets pressed in the environment.
     */
    public void act()
    {

        ySpeed++;
        life--;



        if (isTouching(Brick.class))
        {
            left = !left;
        }

        Actor brick = getOneObjectAtOffset(0, getImage().getHeight() / 2, LongBrick.class);
        if (brick != null)
        {
            onGround = true;
        }
        else
        {
            onGround = false;
        }



        while (getOneObjectAtOffset(getImage().getWidth() / 2, getImage().getHeight() / 2,
                        LongBrick.class) != null)
        {
            setLocation(getX(), getY() - 1);
            onGround = true;
            ySpeed = 0;
        }
        setLocation(getX(), getY() + ySpeed / 2);

        initialDelay--;
        if (initialDelay > 0)
            return;

        if (!slide.isPlaying())
        {
            slide.playLoop();
        }

        if (left)
        {
            move(-speed);
        }
        else
        {
            move(speed);
        }

        hurtable = true;

        if (life < 0)
        {
            Greenfoot.playSound("outShell.mp3");
            SWorld world = (SWorld) getWorld();
            slide.stop();
            world.addObject(new Koopa(health), world.getUnivX(getX()), world.getUnivY(getY()));
            world.removeObject(this);
            return;
        }
    }
}
