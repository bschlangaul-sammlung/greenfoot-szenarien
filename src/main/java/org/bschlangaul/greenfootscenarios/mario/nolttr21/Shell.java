package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; 

/**
 * A shell that will bounce around and attempt to kill mario
 *
 * @author (Dylan Powell and Sean Eastley)
 * @version (January 21, 2015)
 */
public class Shell extends Jump
{
    private int ySpeed; // Defines how fast the shell will fall
    private boolean left; // Determines if the shell should be moving left or right
    private int deathDelayCount; // Ticks up to make the shell die
    private int deathDelayTime; // the number the delay count must reach for the shell to die

    /**
     * Defines the left variable based on the creator's hitEdge variable Also defines the death
     * delay time
     */
    public Shell(boolean hitEdge)
    {
        left = hitEdge;
        deathDelayTime = 150;
    }

    /**
     * Calls the method to move and remove the shell and ticks up the delay counter for the death of
     * the shell
     */
    public void act()
    {
        deathDelayCount++;
        moveShell();
        removeShell();
    }

    /**
     * Will remove the shell if the death delay counter reaches the death delay time
     */
    private void removeShell()
    {
        if (deathDelayCount >= deathDelayTime)
        {
            getWorld().removeObject(this);
        }
    }

    /**
     * This method will move the shell. If there is a block to the right of the shell, it will move
     * left until it hits another object. If there is a block to the left of the shell, it will move
     * left until it hits another object. If there is no object below the shell, it will fall until
     * there is an object underneath the shell.
     */
    public void moveShell()
    {
        ySpeed++;
        setLocation(getX(), getY() + ySpeed / 2);
        while (getOneObjectAtOffset(0, getImage().getHeight() / 2 + 2, Ground.class) != null)
        {
            setLocation(getX(), getY() - 1);
            ySpeed = 0;
        }
        while (getOneObjectAtOffset(0, getImage().getHeight() / 2 + 2, Brick.class) != null)
        {
            setLocation(getX(), getY() - 1);
            ySpeed = 0;
        }
        while (getOneObjectAtOffset(0, getImage().getHeight() / 2 - 4, LongBrick.class) != null)
        {
            setLocation(getX(), getY() - 1);
            ySpeed = 0;
        }
        while (getOneObjectAtOffset(0, getImage().getHeight() / 2 - 4, Block.class) != null)
        {
            setLocation(getX(), getY() - 1);
            ySpeed = 0;
        }
        while (getOneObjectAtOffset(0, getImage().getHeight() / 2 - 4, VerPlatform.class) != null)
        {
            setLocation(getX(), getY() - 1);
            ySpeed = 0;
        }
        while (getOneObjectAtOffset(getImage().getWidth() / 2 + 1, 0, Block.class) != null)
        {
            move(-1);
            left = true;
        }
        while (getOneObjectAtOffset(-getImage().getWidth() / 2 - 1, 0, Block.class) != null)
        {
            move(1);
            left = false;
        }
        while (getOneObjectAtOffset(getImage().getWidth() / 2 + 1, 0, Brick.class) != null)
        {
            move(-1);
            left = true;
        }
        while (getOneObjectAtOffset(-getImage().getWidth() / 2 - 1, 0, Brick.class) != null)
        {
            move(1);
            left = false;
        }
        while (getOneObjectAtOffset(getImage().getWidth() / 2 + 1, 0, HorPlatform.class) != null)
        {
            move(-1);
            left = true;
        }
        while (getOneObjectAtOffset(-getImage().getWidth() / 2 - 1, 0, HorPlatform.class) != null)
        {
            move(1);
            left = false;
        }
        while (getOneObjectAtOffset(getImage().getWidth() / 2 + 1, 0, VerPlatform.class) != null)
        {
            move(-1);
            left = true;
        }
        while (getOneObjectAtOffset(-getImage().getWidth() / 2 - 1, 0, VerPlatform.class) != null)
        {
            move(1);
            left = false;
        }
        while (getOneObjectAtOffset(getImage().getWidth() / 2 + 1, 0, LongBrick.class) != null)
        {
            move(-1);
            left = true;
        }
        while (getOneObjectAtOffset(-getImage().getWidth() / 2 - 1, 0, LongBrick.class) != null)
        {
            move(1);
            left = false;
        }
        if (left == false)
        {
            move(3);
        }
        else if (left == true)
        {
            move(-3);
        }
    }
}
