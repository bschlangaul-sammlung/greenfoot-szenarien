package org.bschlangaul.greenfootscenarios.misc.piano.yedefei;

import greenfoot.*;

/**
 * Write a description of class NoteRain here.
 *
 */
public class NoteRain extends Actor
{
    /**
     * Act - do whatever the NoteRain wants to do. This method is called whenever the 'Act' or 'Run'
     * button gets pressed in the environment.
     */
    private int height = 1;
    private int width;
    private Color color;
    private boolean isGrow = true;

    public NoteRain(int width)
    {
        setRotation(-90);
        this.width = width;
        int r = Greenfoot.getRandomNumber(128) + 128;
        int g = Greenfoot.getRandomNumber(128) + 128;
        int b = Greenfoot.getRandomNumber(128) + 128;
        color = new Color(r, g, b);

        GreenfootImage gfi = new GreenfootImage(height, width);
        gfi.setColor(color);
        gfi.fillRect(0, 0, height, width);
        setImage(gfi);
    }

    public void act()
    {
        move(4);
        if (isAtEdge())
        {
            inverseGrow(8);
        }

        if (isGrow)
        {
            grow();
        }

    }

    public void grow()
    {
        if (height <= 0)
            return;
        GreenfootImage gfi = new GreenfootImage(height, width);
        gfi.setColor(color);
        gfi.fillRect(0, 0, height, width);
        setImage(gfi);
        height += 8;
    }

    public void inverseGrow(int offset)
    {
        GreenfootImage gfi = new GreenfootImage(height, width);
        gfi.setColor(color);
        gfi.fillRect(0, 0, height, width);
        setImage(gfi);
        height -= offset;
        if (height <= 0)
        {
            getWorld().removeObject(this);
        }
    }

    public void setIsGrow(boolean isGrow)
    {
        this.isGrow = isGrow;
    }
}
