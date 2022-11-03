package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;

/**
 * A surface for mario to move on
 *
 * @author (Dylan Powell and Sean Eastley)
 * @version (January 21, 2015)
 */
public class Ground extends Solid
{
    /**
     * Creates a long platform (600 blocks) for the main actor.
     */
    public Ground()
    {
        GreenfootImage platform = new GreenfootImage("Ground.png");
        GreenfootImage image = new GreenfootImage(600, platform.getHeight());
        int w = platform.getWidth();
        for (int offset = 0; offset < 600; offset += w)
        {
            image.drawImage(platform, offset, 0);
        }
        setImage(image);
    }
}
