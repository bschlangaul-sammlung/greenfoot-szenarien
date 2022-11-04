package org.bschlangaul.greenfootscenarios.angry_birds.mz;

import greenfoot.*;

/**
 * Write a description of class dust_cloud here.
 *
 */
public class dust_cloud extends Effects
{
    private GreenfootImage image;
    private int fade;

    public dust_cloud()
    {
        image = getImage();
    }

    public void act()
    {
        shrink();
    }

    private void shrink()
    {
        if (getImage().getWidth() > 150)
        {
            getWorld().removeObject(this);
        }
        else
        {
            GreenfootImage img = new GreenfootImage(image);
            img.scale(getImage().getWidth() + 3, getImage().getHeight() + 3);
            img.setTransparency(getImage().getTransparency() - 9);
            setImage(img);
        }
    }
}
