package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; 

/**
 * This is a piece of terrain used in the creation of the world
 *
 * @author (Dylan Powell and Sean Eastley)
 * @version (January 21, 2015)
 */
public class Brick extends Solid
{
    private GreenfootImage bricks;
    private boolean changed = false; // This determines whether the brick has changed images or not

    /**
     * Defines the image for the brick
     */
    public Brick()
    {
        bricks = new GreenfootImage("castlebrick.png");
    }

    /**
     * If the world is world four or five, the image will be changed to the bricks image.
     */
    public void act()
    {
        if (getWorld() instanceof Fortress && changed == false) // changed variable added to reduce
                                                                // lag
        {
            setImage(bricks);
            changed = true;
        }

        if (getWorld() instanceof KoopaWorld && changed == false) // changed variable added to
                                                                  // reduce lag
        {
            setImage(bricks);
            changed = true;
        }

        if (getWorld() instanceof BossWorld2 && changed == false) // changed variable added to
                                                                  // reduce lag
        {
            setImage(bricks);
            changed = true;
        }

        if (getWorld() instanceof BossWorld && changed == false) // changed variable added to reduce
                                                                 // lag
        {
            setImage(bricks);
            changed = true;
        }
    }
}
