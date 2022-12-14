package org.bschlangaul.greenfootscenarios.tetris.dibo;

import greenfoot.*;

/**
 * represents a J tetromino
 *
 * @author Dietrich Boles (University of Oldenburg, Germany)
 * @version 1.0 (30.10.2008)
 */
public class JTetromino extends Tetromino
{
    JTetromino()
    {
        super("yellow");
    }

    protected void addedToWorld(World world)
    {
        direction = genDirection();
        int start = genStartX();
        getWorld().addObject(b[0], start, 0);
        getWorld().addObject(b[1], start, 1);
        getWorld().addObject(b[2], start + 1, 1);
        getWorld().addObject(b[3], start + 2, 1);
        setDirection();
    }

    protected void setDirection()
    {
        switch (direction)
        {
            case NORTH:
                b[0].setLocation(b[2].getX() - 1, b[2].getY() + 1);
                b[1].setLocation(b[2].getX(), b[2].getY() + 1);
                b[3].setLocation(b[2].getX(), b[2].getY() - 1);
                break;
            case WEST:
                b[0].setLocation(b[2].getX() + 1, b[2].getY() + 1);
                b[1].setLocation(b[2].getX() + 1, b[2].getY());
                b[3].setLocation(b[2].getX() - 1, b[2].getY());
                break;
            case SOUTH:
                b[0].setLocation(b[2].getX() + 1, b[2].getY() - 1);
                b[1].setLocation(b[2].getX(), b[2].getY() - 1);
                b[3].setLocation(b[2].getX(), b[2].getY() + 1);
                break;
            case EAST:
                b[0].setLocation(b[2].getX() - 1, b[2].getY() - 1);
                b[1].setLocation(b[2].getX() - 1, b[2].getY());
                b[3].setLocation(b[2].getX() + 1, b[2].getY());
                break;
        }
    }

    protected Block leftMost()
    {
        switch (direction)
        {
            case NORTH:
                return b[0];
            case WEST:
                return b[3];
            case SOUTH:
                return b[1];
            default: // case EAST:
                return b[1];
        }
    }

    protected Block rightMost()
    {
        switch (direction)
        {
            case NORTH:
                return b[1];
            case WEST:
                return b[1];
            case SOUTH:
                return b[0];
            default: // case EAST:
                return b[3];
        }
    }

    protected boolean turnPossible()
    {
        TetrisWorld world = TetrisWorld.getWorld();
        switch (direction)
        {
            case NORTH:
                return b[2].getX() < world.getWidth() - 1;
            case WEST:
                return true;
            case SOUTH:
                return b[2].getX() > 0;
            default: // case EAST:
                return b[2].getY() < world.getHeight() - 3;
        }
    }

    protected int genStartX()
    {
        return (int) (Math.random() * (TetrisWorld.getWorld().getWidth() - 3)) + 1;
    }

}
