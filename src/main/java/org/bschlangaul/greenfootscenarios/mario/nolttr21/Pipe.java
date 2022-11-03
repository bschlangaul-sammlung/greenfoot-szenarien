package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * pipe to the koopa boss fight
 * 
 * @author (Dylan Powell and Sean Eastley) 
 * @version (January 21, 2015)
 */
public class Pipe extends Actor
{
    public Pipe()
    {
        
    }

    public void act() 
    {
        if (getWorld() instanceof Tower) 
            {
                setRotation(90);
            } 
            else if (getWorld() instanceof Fortress)
            {
                setRotation(270);
            }
            else
            {
                setRotation(0);
                
            }
        
        if(isTouching(Mario.class) || isTouching(MarioG.class) || isTouching(MarioS.class))
        {
            if (getWorld() instanceof Tower) 
            {
                Greenfoot.setWorld(new KoopaWorld());
            } 
            else if (getWorld() instanceof Fortress)
            {
                Greenfoot.setWorld(new BossWorld());
            }
            else
            {
                Airship.theme.stop();
                Greenfoot.setWorld(new BossWorld2());
            }
            Fortress.music.stop(); 
            Tower.theme.stop();
            Greenfoot.playSound("pipe.mp3");
        }
    }    
}
