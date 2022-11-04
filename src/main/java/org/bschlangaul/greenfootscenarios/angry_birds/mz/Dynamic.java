package org.bschlangaul.greenfootscenarios.angry_birds.mz;

import greenfoot.*;
import java.util.List;

/**
 * Write a description of class Dynamic here.
 *
 */
public class Dynamic extends Actor
{
    static double GRV = 0.15;
    static double WINDAGE = 0.25;
    private Class[] Wall = new Class[0];
    double accY;
    double accX;
    double elast;
    int mass;
    int vX0;
    int vY0;
    int vX1;
    int vY1;

    public boolean onGround()
    {
        boolean b = false;
        int wall_size = 0;
        for (Class wall : Wall)
        {
            Actor under = getOneObjectAtOffset(0, getImage().getHeight() / 2 + vY1, wall);
            if (under != null)
            {
                b = true;
                wall_size = under.getImage().getHeight() / 2;
            }
        }
        return b;
    }

    public boolean canMoveUp()
    {
        for (Class wall : Wall)
        {
            List<Actor> intSelWalls = getIntersectingObjects(wall);
            for (Actor w : intSelWalls)
            {
                if (w.getY() < getY())
                    return false;
            }
        }
        return true;
    }

    public Actor getObjectBelow()
    {
        for (Class wall : Wall)
        {
            Actor under = getOneObjectAtOffset(0, getImage().getHeight() / 2 + vY1, wall);
            if (under != null)
            {
                return (under);
            }
        }
        return null;
    }

    public Actor getObjectAbove()
    {
        for (Class wall : Wall)
        {
            List<Actor> intSelWalls = getIntersectingObjects(wall);
            for (Actor w : intSelWalls)
            {
                if (w.getY() < getY())
                    return w;
            }
        }
        return null;
    }

    public Actor getObjectRight()
    {
        for (Class wall : Wall)
        {
            List<Actor> intSelWalls = getIntersectingObjects(wall);
            for (Actor w : intSelWalls)
            {
                if (w.getX() > getX())
                    return w;
            }
        }
        return null;
    }

    public Actor getObjectLeft()
    {
        for (Class wall : Wall)
        {
            List<Actor> intSelWalls = getIntersectingObjects(wall);
            for (Actor w : intSelWalls)
            {
                if (w.getX() < getX())
                    return w;
            }
        }
        return null;
    }

    public boolean canMoveLeft()
    {
        for (Class wall : Wall)
        {
            List<Actor> intSelWalls = getIntersectingObjects(wall);
            for (Actor w : intSelWalls)
            {
                if (w.getX() < getX())
                    return false;
            }
        }
        return true;
    }

    public boolean canMoveRight()
    {
        for (Class wall : Wall)
        {
            List<Actor> intSelWalls = getIntersectingObjects(wall);
            for (Actor w : intSelWalls)
            {
                if (w.getX() > getX())
                    return false;
            }
        }
        return true;
    }

    public void doGravity()
    {
        boolean ignore = false;
        // по y
        if ((Math.abs(accY) < 1) && (onGround() == true))
        {
            Actor ground = getObjectBelow();
            setLocation(getX(), ground.getY() - ground.getImage().getHeight() / 2
                            - getImage().getHeight() / 2);
            accY = 0;
            return;
        }
        else if ((accY > 1) && (onGround() == true))
        {
            Actor ground = getObjectBelow();
            setLocation(getX(), ground.getY() - ground.getImage().getHeight() / 2
                            - getImage().getHeight() / 2);
            accY -= accY * elast;
        }
        if ((accY < 1) && (canMoveUp() == false))
        {
            Actor top = getObjectAbove();
            setLocation(getX(), top.getY() + top.getImage().getHeight() / 2
                            + getImage().getHeight() / 2);
            accY -= accY * elast;
            ignore = true;
        }
        // по x
        if (ignore != true)
        {
            if ((Math.abs(accX) < 1) && (canMoveRight() == false))
            {
                Actor wall = getObjectRight();
                setLocation(wall.getX() - wall.getImage().getWidth() / 2
                                - getImage().getWidth() / 2, getY());
                return;
            }
            else if ((Math.abs(accX) < 1) && (canMoveLeft() == false))
            {
                Actor wall = getObjectLeft();
                setLocation(wall.getX() + wall.getImage().getWidth() / 2
                                + getImage().getWidth() / 2, getY());
                return;
            }
            else if ((accX > 1) && (canMoveRight() == false))
            {
                Actor wall = getObjectRight();
                setLocation(wall.getX() - wall.getImage().getWidth() / 2
                                - getImage().getWidth() / 2, getY());
                accX -= accX * elast;
            }
            else if ((accX < 1) && (canMoveLeft() == false))
            {
                Actor wall = getObjectLeft();
                setLocation(wall.getX() + wall.getImage().getWidth() / 2
                                + getImage().getWidth() / 2, getY());
                accX -= accX * elast;
            }
        }
        setLocation(getX() + (int) accX, getY());
        if (accX < 0)
        {
            accX += (WINDAGE / mass);
        }
        else if (accX > 0)
        {
            accX -= (WINDAGE / mass);
        }
        setLocation(getX(), getY() + (int) accY);
        accY += GRV * mass;
    }

    protected void setVerticalSpeed(double speedV)
    {
        accY = speedV;
    }

    protected void setHorizontalSpeed(double speedH)
    {
        accX = speedH;
    }

    protected void setMass(int newMass)
    {
        mass = newMass;
    }

    protected void setElast(double newElast)
    {
        elast = newElast;
    }

    protected void setBlockingClasses(Class[] c)
    {
        Wall = c;
    }

    protected double getHorizontalSpeed()
    {
        return (accX);
    }
}
