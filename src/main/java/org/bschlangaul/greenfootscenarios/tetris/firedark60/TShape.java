package org.bschlangaul.greenfootscenarios.tetris.firedark60;

import java.util.List;

/**
 * The T Shape
 *
 * @Brian Huang
 *
 */
public class TShape extends Shapes
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
            List checkIntersection = getObjectsAtOffset(0, 24, null);
            checkIntersection.remove(this);
            if (checkIntersection.isEmpty())
            {
                setRotation(getRotation() + 90);
                setLocation(getX() + 8, getY() + 8);
            }
            else
            {
                List checkIntersection1 = getObjectsAtOffset(0, -24, null);
                checkIntersection1.remove(this);
                List checkIntersection2 = getObjectsAtOffset(16, -8, null);
                checkIntersection2.remove(this);
                if (checkIntersection1.isEmpty() && checkIntersection2.isEmpty())
                {
                    setRotation(getRotation() + 90);
                    setLocation(getX() + 8, getY() - 8);
                }
            }
        }
        else if (getRotation() == 90)
        {
            List checkIntersection = getObjectsAtOffset(-24, 0, null);
            checkIntersection.remove(this);
            if (checkIntersection.isEmpty())
            {

                setRotation(getRotation() + 90);
                setLocation(getX() - 8, getY() - 8);
            }
            else
            {
                List checkIntersection1 = getObjectsAtOffset(24, 0, null);
                checkIntersection1.remove(this);
                List checkIntersection2 = getObjectsAtOffset(8, 16, null);
                checkIntersection2.remove(this);
                if (checkIntersection1.isEmpty() && checkIntersection2.isEmpty())
                {

                    setRotation(getRotation() + 90);
                    setLocation(getX() + 8, getY() - 8);
                }
            }
        }
        else if (getRotation() == 180)
        {
            List checkIntersection1 = getObjectsAtOffset(8, -16, null);
            checkIntersection1.remove(this);
            List checkIntersection2 = getObjectsAtOffset(-24, -16, null);
            checkIntersection2.remove(this);
            if (checkIntersection1.isEmpty() && checkIntersection2.isEmpty())
            {
                setRotation(getRotation() + 90);
                setLocation(getX() - 8, getY() - 8);
            }
            else
            {
                List checkIntersection = getObjectsAtOffset(24, -16, null);
                checkIntersection.remove(this);
                if (checkIntersection.isEmpty() && checkIntersection1.isEmpty())
                {

                    setRotation(getRotation() + 90);
                    setLocation(getX() + 8, getY() - 8);
                }
            }

        }
        else if (getRotation() == 270)
        {
            List checkIntersection1 = getObjectsAtOffset(-8, 16, null);
            checkIntersection1.remove(this);
            List checkIntersection2 = getObjectsAtOffset(24, 16, null);
            checkIntersection2.remove(this);
            if (checkIntersection1.isEmpty() && checkIntersection2.isEmpty())
            {
                setRotation(0);
                setLocation(getX() + 8, getY() + 8);
            }
            else
            {
                List checkIntersection = getObjectsAtOffset(-24, 16, null);
                checkIntersection.remove(this);
                if (checkIntersection.isEmpty() && checkIntersection1.isEmpty())
                {

                    setRotation(0);
                    setLocation(getX() - 8, getY() + 8);
                }
            }
        }
    }

    public boolean checkLeft()
    {
        if (getRotation() == 0)
        {
            List checkIntersection = getObjectsAtOffset(-32, 8, null);
            checkIntersection.remove(this);
            List checkIntersection1 = getObjectsAtOffset(-16, -8, null);
            checkIntersection1.remove(this);
            if (checkIntersection.isEmpty() && checkIntersection1.isEmpty())
            {
                return true;
            }
        }

        else if (getRotation() == 90)
        {
            List checkIntersection = getObjectsAtOffset(-24, -16, null);
            checkIntersection.remove(this);
            List checkIntersection1 = getObjectsAtOffset(-24, 0, null);
            checkIntersection1.remove(this);
            List checkIntersection2 = getObjectsAtOffset(-24, 16, null);
            checkIntersection2.remove(this);
            if (checkIntersection.isEmpty() && checkIntersection1.isEmpty()
                            && checkIntersection2.isEmpty())
            {
                return true;

            }
        }
        else if (getRotation() == 180)
        {
            List checkIntersection = getObjectsAtOffset(-32, -8, null);
            checkIntersection.remove(this);
            List checkIntersection1 = getObjectsAtOffset(-16, 8, null);
            checkIntersection1.remove(this);
            if (checkIntersection.isEmpty() && checkIntersection1.isEmpty())
            {
                return true;
            }
        }
        else
        {
            List checkIntersection = getObjectsAtOffset(-24, 0, null);
            checkIntersection.remove(this);
            List checkIntersection1 = getObjectsAtOffset(-8, 16, null);
            checkIntersection1.remove(this);
            List checkIntersection2 = getObjectsAtOffset(-8, -16, null);
            checkIntersection2.remove(this);
            if (checkIntersection.isEmpty() && checkIntersection1.isEmpty()
                            && checkIntersection2.isEmpty())
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
            List checkIntersection = getObjectsAtOffset(24, 8, null);
            checkIntersection.remove(this);
            List checkIntersection1 = getObjectsAtOffset(16, -8, null);
            checkIntersection1.remove(this);
            if (checkIntersection.isEmpty() && checkIntersection1.isEmpty())
            {
                return true;
            }
        }

        else if (getRotation() == 90)
        {
            List checkIntersection = getObjectsAtOffset(24, 0, null);
            checkIntersection.remove(this);
            List checkIntersection1 = getObjectsAtOffset(8, 16, null);
            checkIntersection1.remove(this);
            List checkIntersection2 = getObjectsAtOffset(8, -16, null);
            checkIntersection2.remove(this);
            if (checkIntersection.isEmpty() && checkIntersection1.isEmpty()
                            && checkIntersection2.isEmpty())
            {
                return true;
            }
        }
        else if (getRotation() == 180)
        {
            List checkIntersection = getObjectsAtOffset(24, -8, null);
            checkIntersection.remove(this);
            List checkIntersection1 = getObjectsAtOffset(16, 8, null);
            checkIntersection1.remove(this);
            if (checkIntersection.isEmpty() && checkIntersection1.isEmpty())
            {
                return true;
            }
        }
        else
        {
            List checkIntersection = getObjectsAtOffset(24, -16, null);
            checkIntersection.remove(this);
            List checkIntersection1 = getObjectsAtOffset(24, 0, null);
            checkIntersection1.remove(this);
            List checkIntersection2 = getObjectsAtOffset(24, 16, null);
            checkIntersection2.remove(this);
            if (checkIntersection.isEmpty() && checkIntersection1.isEmpty()
                            && checkIntersection2.isEmpty())
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
            List checkIntersection = getObjectsAtOffset(0, 24, null);
            List checkIntersection2 = getObjectsAtOffset(16, 24, null);
            List checkIntersection3 = getObjectsAtOffset(-16, 24, null);
            checkIntersection.remove(this);
            checkIntersection2.remove(this);
            checkIntersection3.remove(this);
            if (checkIntersection.isEmpty() && checkIntersection2.isEmpty()
                            && checkIntersection3.isEmpty())
            {
                return true;

            }
        }
        else if (getRotation() == 90)
        {
            List checkIntersection1 = getObjectsAtOffset(8, 16, null);
            checkIntersection1.remove(this);
            List checkIntersection2 = getObjectsAtOffset(-8, 32, null);
            checkIntersection2.remove(this);
            if (checkIntersection1.isEmpty() && checkIntersection2.isEmpty())
            {
                return true;

            }
        }
        else if (getRotation() == 180)
        {
            List checkIntersection = getObjectsAtOffset(0, 24, null);
            List checkIntersection2 = getObjectsAtOffset(16, 8, null);
            List checkIntersection3 = getObjectsAtOffset(-16, 8, null);
            checkIntersection.remove(this);
            checkIntersection2.remove(this);
            checkIntersection3.remove(this);
            if (checkIntersection.isEmpty() && checkIntersection2.isEmpty()
                            && checkIntersection3.isEmpty())
            {
                return true;

            }
        }
        else
        {
            List checkIntersection1 = getObjectsAtOffset(8, 32, null);
            checkIntersection1.remove(this);
            List checkIntersection2 = getObjectsAtOffset(-8, 12, null);
            checkIntersection2.remove(this);
            if (checkIntersection1.isEmpty() && checkIntersection2.isEmpty())
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
            int x = (getX() - 248) / 16;
            int y = (getY() - 116) / 16;
            TetrisWorld.tetrisArray[x][y] = 7;
            TetrisWorld.tetrisArray[x][y + 1] = 7;
            TetrisWorld.tetrisArray[x - 1][y + 1] = 7;
            TetrisWorld.tetrisArray[x + 1][y + 1] = 7;
            getWorld().removeObject(this);
            int[] coords = {x, y, x, y + 1, x - 1, y + 1, x + 1, y + 1};

            return coords;

        }
        else if (getRotation() == 90)
        {
            int x = ((getX() - 248) / 16);
            int y = ((getY() - 116) / 16);
            TetrisWorld.tetrisArray[x][y] = 7;
            TetrisWorld.tetrisArray[x][y - 1] = 7;
            TetrisWorld.tetrisArray[x][y + 1] = 7;
            TetrisWorld.tetrisArray[x + 1][y] = 7;
            getWorld().removeObject(this);
            int[] coords = {x, y, x, y - 1, x, y + 1, x + 1, y};

            return coords;

        }
        else if (getRotation() == 180)
        {
            int x = ((getX() - 248) / 16);
            int y = ((getY() - 116) / 16);
            TetrisWorld.tetrisArray[x][y] = 7;
            TetrisWorld.tetrisArray[x - 1][y] = 7;
            TetrisWorld.tetrisArray[x + 1][y] = 7;
            TetrisWorld.tetrisArray[x][y + 1] = 7;
            getWorld().removeObject(this);
            int[] coords = {x, y, x - 1, y, x + 1, y, x, y + 1};

            return coords;

        }
        else
        {
            int x = ((getX() - 248) / 16);
            int y = ((getY() - 116) / 16);
            TetrisWorld.tetrisArray[x][y] = 7;
            TetrisWorld.tetrisArray[x + 1][y + 1] = 7;
            TetrisWorld.tetrisArray[x + 1][y - 1] = 7;
            TetrisWorld.tetrisArray[x + 1][y] = 7;
            getWorld().removeObject(this);
            int[] coords = {x, y, x + 1, y + 1, x + 1, y - 1, x + 1, y};

            return coords;

        }
    }
}
