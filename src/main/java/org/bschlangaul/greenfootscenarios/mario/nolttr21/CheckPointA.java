package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;

/**
 * Write a description of class CheckPointA here.
 */
public class CheckPointA extends Items
{
    /**
     * Act - do whatever the CheckPointA wants to do. This method is called whenever the 'Act' or
     * 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (MarioS.characterName == "mario")
        {
            setImage("M.png");
        }

        if (MarioS.characterName == "luigi")
        {
            setImage("L.png");
        }

        if (MarioS.characterName == "toad")
        {
            setImage("T.png");
        }
    }
}
