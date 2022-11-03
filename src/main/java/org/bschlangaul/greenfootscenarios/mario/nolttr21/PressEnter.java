package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;

/**
 * Write a description of class PressEnter here.
 */
public class PressEnter extends Text
{
    GreenfootImage image;
    public int trans = 254;
    public boolean more = false;

    public PressEnter()
    {
        image = new GreenfootImage("Press Enter", 50, Color.BLACK, new Color(0, 0, 0, 0));
        setImage(image);
    }

    /**
     * Act - do whatever the PressEnter wants to do. This method is called whenever the 'Act' or
     * 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        image.setTransparency(trans);
        setImage(image);

        if (!more)
        {
            if (trans > 162)
            {
                trans--;
                trans--;
                trans--;
                trans--;


            }
            else
                more = true;
        }



        if (more)
        {
            if (trans < 240)
            {
                trans++;
                trans++;
                trans++;
                trans++;

            }
            else
                more = false;
        }

        if (!getWorld().getObjects(CharacterArrow.class).isEmpty())
        {
            getWorld().removeObject(this);
        }
    }
}
