package org.bschlangaul.greenfootscenarios.tetris.firedark60;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * The Line Shape
 *
 * @Brian Huang
 *
 */
public class LineShape extends Shapes
{
    /**
     * NOTE: Look at L Shape class for clues and commenting. This class is shaped and is a close
     * copy to L Shape class So commenting is the same in this class to the L Shape.
     *
     */
    public void rotate()
    {
        if (getRotation() == 0)
        {
            List checkIntersection = getObjectsAtOffset(-16, -8, null);
            checkIntersection.remove(this);
            List checkIntersection2 = getObjectsAtOffset(16, -8, null);
            checkIntersection2.remove(this);
            List checkIntersection3 = getObjectsAtOffset(32, -8, null);
            checkIntersection3.remove(this);
            List checkIntersection4 = getObjectsAtOffset(48, -8, null);
            checkIntersection4.remove(this);
            List checkIntersection5 = getObjectsAtOffset(-32, -8, null);
            checkIntersection5.remove(this);
            List checkIntersection6 = getObjectsAtOffset(-48, -8, null);
            checkIntersection6.remove(this);

            if (checkIntersection.isEmpty() && checkIntersection2.isEmpty()
                            && checkIntersection3.isEmpty())
            {
                setRotation(getRotation() + 90);
                setLocation(getX() + 8, getY() - 8);
            }
            else if (checkIntersection2.isEmpty() && checkIntersection3.isEmpty()
                            && checkIntersection4.isEmpty())
            {
                setRotation(getRotation() + 90);
                setLocation(getX() + 24, getY() - 8);
            }
            else if (checkIntersection.isEmpty() && checkIntersection5.isEmpty()
                            && checkIntersection6.isEmpty())
            {
                setRotation(getRotation() + 90);
                setLocation(getX() - 24, getY() - 8);
            }

        }
        else if (getRotation() == 90)
        {
            List checkIntersection = getObjectsAtOffset(-8, -16, null);
            checkIntersection.remove(this);
            List checkIntersection2 = getObjectsAtOffset(-8, 16, null);
            checkIntersection2.remove(this);
            List checkIntersection3 = getObjectsAtOffset(-8, 32, null);
            checkIntersection3.remove(this);
            List checkIntersection4 = getObjectsAtOffset(0, -32, null);
            checkIntersection4.remove(this);
            if (checkIntersection.isEmpty() && checkIntersection2.isEmpty()
                            && checkIntersection3.isEmpty())
            {
                setRotation(0);
                setLocation(getX() - 8, getY() + 8);
            }
            else if (checkIntersection.isEmpty() && checkIntersection3.isEmpty()
                            && checkIntersection4.isEmpty())
            {

                setRotation(0);
                setLocation(getX() - 8, getY() - 24);
            }
        }
    }

    public boolean checkLeft()
    {
        if (getRotation() == 0)
        {
            List checkIntersection = getObjectsAtOffset(-16, 0, null);
            checkIntersection.remove(this);
            List checkIntersection2 = getObjectsAtOffset(-16, -8, null);
            checkIntersection2.remove(this);
            List checkIntersection3 = getObjectsAtOffset(-16, 24, null);
            checkIntersection3.remove(this);
            List checkIntersection4 = getObjectsAtOffset(-16, -24, null);
            checkIntersection3.remove(this);
            if (checkIntersection.isEmpty() && checkIntersection2.isEmpty()
                            && checkIntersection3.isEmpty() && checkIntersection4.isEmpty())
            {
                return true;
            }
        }
        else
        {
            List checkIntersection = getObjectsAtOffset(-40, 0, null);
            checkIntersection.remove(this);

            if (checkIntersection.isEmpty())
            {
                return true;

            }
        }

        return false;

    }

    public boolean checkRight()
    {
        if (getRotation() == 0)
        {
            List checkIntersection = getObjectsAtOffset(16, 0, null);
            checkIntersection.remove(this);
            List checkIntersection2 = getObjectsAtOffset(16, -8, null);
            checkIntersection2.remove(this);
            List checkIntersection3 = getObjectsAtOffset(16, 24, null);
            checkIntersection3.remove(this);
            List checkIntersection4 = getObjectsAtOffset(16, -24, null);
            checkIntersection3.remove(this);
            if (checkIntersection.isEmpty() && checkIntersection2.isEmpty()
                            && checkIntersection3.isEmpty() && checkIntersection4.isEmpty())
            {
                return true;
            }
        }
        else
        {
            List checkIntersection = getObjectsAtOffset(32, 0, null);
            checkIntersection.remove(this);

            if (checkIntersection.isEmpty())
            {
                return true;

            }
        }
        return false;
    }

    public boolean checkDown()
    {
        if (getRotation() == 0)
        {
            List checkIntersection = getObjectsAtOffset(0, 32, null);
            checkIntersection.remove(this);

            if (checkIntersection.isEmpty())
            {
                return true;

            }
        }
        else
        {
            List checkIntersection = getObjectsAtOffset(0, 16, null);
            checkIntersection.remove(this);
            List checkIntersection2 = getObjectsAtOffset(-8, 16, null);
            checkIntersection2.remove(this);
            List checkIntersection3 = getObjectsAtOffset(24, 16, null);
            checkIntersection3.remove(this);
            List checkIntersection4 = getObjectsAtOffset(-24, 16, null);
            checkIntersection3.remove(this);
            if (checkIntersection.isEmpty() && checkIntersection2.isEmpty()
                            && checkIntersection3.isEmpty() && checkIntersection4.isEmpty())
            {
                return true;
            }
        }
        return false;
    }

    public int[] registerShape()
    {
        if (getRotation() == 0)
        {
            int x = ((getX() - 248) / 16);
            int y = ((getY() - 116) / 16);

            TetrisWorld.tetrisArray[x][y] = 2;

            TetrisWorld.tetrisArray[x][y - 1] = 2;

            TetrisWorld.tetrisArray[x][y + 2] = 2;

            TetrisWorld.tetrisArray[x][y + 1] = 2;
            getWorld().removeObject(this);

            int[] coords = {x, y, x, y - 1, x, y + 2, x, y + 1};

            return coords;

        }
        else
        {
            int x = ((getX() - 248) / 16);
            int y = ((getY() - 116) / 16);
            TetrisWorld.tetrisArray[x][y] = 2;
            TetrisWorld.tetrisArray[x + 1][y] = 2;
            TetrisWorld.tetrisArray[x - 1][y] = 2;
            TetrisWorld.tetrisArray[x + 2][y] = 2;
            int[] coords = {x, y, x + 1, y, x - 1, y, x + 2, y};
            getWorld().removeObject(this);

            return coords;

        }
    }
}
