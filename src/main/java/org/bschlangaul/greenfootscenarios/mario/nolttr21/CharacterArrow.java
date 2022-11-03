package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Arrow pointing to your currently selected character
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CharacterArrow extends Characters
{
    public boolean atMario = true;
    public boolean atToad = false;
    public boolean atLuigi = false;
    public int enterDelay = 20;

    /**
     * Act - do whatever the CharacterArrow wants to do. This method is called whenever the 'Act' or
     * 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        enterDelay--;
        if (enterDelay < 0)
        {
            if (Greenfoot.isKeyDown("right"))
            {
                enterDelay = 20;
                if (atLuigi)
                {
                    return;
                }

                if (atToad)
                {
                    setLocation(getX() + 70, getY());
                    atLuigi = true;
                    atToad = false;
                    return;
                }

                if (atMario)
                {
                    setLocation(getX() + 70, getY());
                    atToad = true;
                    atMario = false;
                    return;
                }

            }

            if (Greenfoot.isKeyDown("left"))
            {

                enterDelay = 20;
                if (atMario)
                {
                    return;
                }

                if (atToad)
                {
                    setLocation(getX() - 70, getY());
                    atMario = true;
                    atToad = false;
                    return;
                }

                if (atLuigi)
                {
                    setLocation(getX() - 70, getY());
                    atToad = true;
                    atLuigi = false;
                    return;
                }

            }
            enterDelay--;
            if (Greenfoot.isKeyDown("enter") && enterDelay < 0)
            {
                StartMenu1 start = (StartMenu1) getWorld();
                start.theme.stop();
                if (atMario)
                {

                    Mario.characterName = "mario";
                    MarioS.characterName = "mario";
                    MarioG.characterName = "mario";
                    MapMario.characterName = "mario";
                    Luigi.characterName = "Mario";

                    Greenfoot.setWorld(new MapControls());
                }
                else if (atLuigi)
                {
                    Mario.characterName = "luigi";
                    MarioS.characterName = "luigi";
                    MarioG.characterName = "luigi";
                    MapMario.characterName = "luigi";
                    Luigi.characterName = "Luigi";
                    Greenfoot.setWorld(new MapControls());
                }
                else
                {
                    Mario.characterName = "toad";
                    MarioS.characterName = "toad";
                    MarioG.characterName = "toad";
                    MapMario.characterName = "toad";
                    Luigi.characterName = "Toad";
                    Greenfoot.setWorld(new MapControls());
                }
            }
        }
    }

}
