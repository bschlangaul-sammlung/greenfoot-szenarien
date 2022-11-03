package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays when the player wins the game
 * 
 * @author (Dylan Powell and Sean Eastley) 
 * @version (January 21, 2015)
 */
public class GameWon extends World
{
    private int enterDelayCount;
    //Ticks up to determine when the player can press enter - to keep them from accidentally flipping through two worlds
    static GreenfootSound winning = new GreenfootSound("Win.mp3");
    GreenfootSound clicked = new GreenfootSound("Clicked.wav");
    /**
     * Constructs the game over world and plays the lost music
     */
    public GameWon()
    {    
        super(700, 400, 1); 
        if(!winning.isPlaying())
        {
            winning.playLoop();
        }
    }
    
    /**
     * Will switch the world when the delay count has reached fifteen and the enter key is pressed
     */
    public void act()
    {
        enterDelayCount ++;
        if (Greenfoot.isKeyDown("enter") && enterDelayCount > 15)
        {
            clicked.play();
            winning.stop();
            Greenfoot.setWorld(new StartMenu1());
        }
    }
    
    public static void play()
    {
        winning.playLoop();
    }
}

