package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;

/**
 * Write a description of class Intro3 here.
 *
 */
public class Intro3 extends Intros
{
    public int life = 50;

    /**
     * Act - do whatever the Intro2 wants to do. This method is called whenever the 'Act' or 'Run'
     * button gets pressed in the environment.
     */
    public void act()
    {
        life--;
        if (life < 0)
        {
            getWorld().removeObject(this);
        }
    }
}
