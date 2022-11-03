package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;

/**
 * decoration
 *
 */
public class MapAirship extends Decoration
{
    public int pastX;

    /**
     * Act - do whatever the MapAirship wants to do. This method is called whenever the 'Act' or
     * 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        try
        {
            Ball ball = getWorld().getObjects(Ball.class).get(0);
            if (ball != null)
            {
                setLocation(ball.getX(), ball.getY());
            }
        } catch (IndexOutOfBoundsException e)
        {

        }

        if (pastX != 0)
        {
            if (getX() > pastX)
            {
                setImage("airship1.png");
            }

            if (getX() < pastX)
            {
                setImage("airship2.png");
            }
        }

        pastX = getX();
    }
}
