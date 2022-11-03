package org.bschlangaul.greenfootscenarios.space_invaders.jwilshire;

import greenfoot.*; 

/**
 * Write a description of class Alien here.
 *
 */
public class Alien extends Actor
{
    private int stepSize = 1;
    private int direction = 1;
    private long moveTime;
    private long waitTime;
    private int imageNumber;
    private int rowNumber;
    private String imageName;

    public Alien(int row, String baseImageName)
    {
        super();
        imageName = baseImageName;
        rowNumber = row;
        imageNumber = 1;
        direction = 1;
        moveTime = System.currentTimeMillis();
        waitTime = 400L;
    }

    public int getRow()
    {
        return rowNumber;
    }

    public void changeDirection()
    {
        direction *= -1;
    }

    public boolean isMovingLeft()
    {
        return direction < 0;
    }

    public int getStepSize()
    {
        return stepSize;
    }

    public void setStepSize(int x)
    {
        stepSize = x;
    }

    public void fire()
    {
        AlienFire fire = new AlienFire();
        getWorld().addObject(fire, getX(), getY());
    }

    public boolean isTouchingMissle()
    {
        Actor missle = getOneIntersectingObject(Missle.class);
        if (missle != null)
        {
            getWorld().removeObject(missle);
            return true;
        }
        else
        {
            return false;
        }
    }

    public void moveSideToSide()
    {
        setImage(imageName + imageNumber + ".png");
        imageNumber = (imageNumber + 1) % 2;
        setLocation(getX() + stepSize * direction, getY());
    }


}
