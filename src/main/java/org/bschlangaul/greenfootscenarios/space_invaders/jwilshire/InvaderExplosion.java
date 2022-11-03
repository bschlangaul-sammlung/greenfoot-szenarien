package org.bschlangaul.greenfootscenarios.space_invaders.jwilshire;

import greenfoot.*;

/**
 * Write a description of class InvaderExplosion here.
 */
public class InvaderExplosion extends Actor
{
    private long creationTime;
    private long maxDuration;

    public InvaderExplosion()
    {
        creationTime = System.currentTimeMillis();
        maxDuration = 500L;
    }

    /**
     * Act - do whatever the InvaderExplosion wants to do. This method is called whenever the 'Act'
     * or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (System.currentTimeMillis() - creationTime > maxDuration)
        {
            getWorld().removeObject(this);
        } // Add your action code here.
    }
}
