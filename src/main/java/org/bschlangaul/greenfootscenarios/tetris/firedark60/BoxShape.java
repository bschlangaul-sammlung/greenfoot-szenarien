package org.bschlangaul.greenfootscenarios.tetris.firedark60;

import java.util.List;

/**
 * Write a description of class BoxShape here.
 */
public class BoxShape extends Shapes
{
    /**
     * NOTE: Look at L Shape class for clues and commenting. This class is shaped and is a close
     * copy to L Shape class So commenting is the same in this class to the L Shape.
     *
     */

    public void rotate()
    {
        setLocation(getX(), getY());
    }

    public boolean checkLeft()
    {
        List checkIntersection = getObjectsAtOffset(-24, -8, null);
        checkIntersection.remove(this);
        List checkIntersection1 = getObjectsAtOffset(-24, 8, null);
        checkIntersection1.remove(this);
        if (checkIntersection1.isEmpty() && checkIntersection.isEmpty())
        {
            return true;

        }

        return false;
    }

    public boolean checkRight()
    {
        List checkIntersection = getObjectsAtOffset(24, -8, null);
        checkIntersection.remove(this);
        List checkIntersection1 = getObjectsAtOffset(24, 8, null);
        checkIntersection1.remove(this);
        if (checkIntersection1.isEmpty() && checkIntersection.isEmpty())
        {
            return true;

        }

        return false;
    }

    public boolean checkDown()
    {
        List checkIntersection = getObjectsAtOffset(8, 24, null);
        checkIntersection.remove(this);
        List checkIntersection1 = getObjectsAtOffset(-8, 24, null);
        checkIntersection1.remove(this);
        if (checkIntersection1.isEmpty() && checkIntersection.isEmpty())
        {
            return true;

        }

        return false;
    }

    public int[] registerShape()
    {

        int x = ((getX() - 248) / 16);
        int y = ((getY() - 116) / 16);
        TetrisWorld.tetrisArray[x][y] = 6;
        TetrisWorld.tetrisArray[x + 1][y] = 6;
        TetrisWorld.tetrisArray[x][y + 1] = 6;
        TetrisWorld.tetrisArray[x + 1][y + 1] = 6;
        getWorld().removeObject(this);

        int[] coords = {x, y, x + 1, y, x + 1, y + 1, x, y + 1};

        return coords;

    }
}
