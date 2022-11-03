package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; 

/**
 * Displays when the player loses
 *
 * @author (Dylan Powell and Sean Eastley)
 * @version (January 21, 2015)
 */
public class GameOver extends World
{
    private int enterDelayCount; // Ticks up to determine when the player can press enter - to keep
                                 // them from accidentally flipping through two worlds
    GreenfootSound lost = new GreenfootSound("lost.mp3");
    GreenfootSound clicked = new GreenfootSound("Clicked.wav");
    public int delayTime = 100;

    /**
     * Constructs the game over world and plays the lost music
     */
    public GameOver()
    {
        super(700, 400, 1, false);
        lost.play();
        prepare();
        Greenfoot.start();
    }


    /**
     * Will switch the world when the delay count has reached fifteen and the enter key is pressed
     */
    public void act()
    {
        Map.map.stop();
        enterDelayCount++;
        Greenfoot.start();
        Map.clears = 0;

        SWorld.lives = 5;
        delayTime--;
        // MapMario.position = 0;
        MyWorld.flag = false;
        WorldTwo.flag = false;
        WorldThree.flag = false;
        Tower.flag = false;
        Airship.flag = false;
        Fortress.flag = false;
        if (Greenfoot.isKeyDown("enter") && enterDelayCount > 200)
        {
            clicked.play();
            Greenfoot.setWorld(new Map(0, 0, true));
        }
        if (delayTime == 0)
        {

            addObject(new BouncingLetter(25, "P", Color.RED, 250), 280, -20);
            addObject(new BouncingLetter(25, "R", Color.RED, 250), 295, -20);
            addObject(new BouncingLetter(25, "E", Color.RED, 250), 310, -20);
            addObject(new BouncingLetter(25, "S", Color.RED, 250), 325, -20);
            addObject(new BouncingLetter(25, "S", Color.RED, 250), 340, -20);


            addObject(new BouncingLetter(25, "E", Color.RED, 250), 370, -20);
            addObject(new BouncingLetter(25, "N", Color.RED, 250), 385, -20);
            addObject(new BouncingLetter(25, "T", Color.RED, 250), 400, -20);
            addObject(new BouncingLetter(25, "E", Color.RED, 250), 415, -20);
            addObject(new BouncingLetter(25, "R", Color.RED, 250), 430, -20);
        }



    }


    private void prepare()
    {
        addObject(new BouncingLetter(60, "G", Color.RED, 200), 205, -20);
        addObject(new BouncingLetter(60, "A", Color.RED, 200), 240, -20);
        addObject(new BouncingLetter(60, "M", Color.RED, 200), 280, -20);
        addObject(new BouncingLetter(60, "E", Color.RED, 200), 315, -20);

        addObject(new BouncingLetter(60, "O", Color.RED, 200), 380, -20);
        addObject(new BouncingLetter(60, "V", Color.RED, 200), 415, -20);
        addObject(new BouncingLetter(60, "E", Color.RED, 200), 445, -20);
        addObject(new BouncingLetter(60, "R", Color.RED, 200), 475, -20);


    }


}
