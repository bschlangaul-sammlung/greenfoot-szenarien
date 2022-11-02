package org.bschlangaul.greenfootscenarios.tetris.firedark60;

import greenfoot.*; // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Counter that displays a number.
 *
 * @author Michael Kolling & Brian Huang
 * @version 1.0.1
 */
public class Timer extends Actor
{
    // Initializes needed variables
    private int target = 0;
    private int stringLength;
    private int seconds;
    private int minutes;
    private int hours;

    /**
     * Timer Constructor
     *
     * Creates the size, font and length of the Tiemr
     *
     * @param prefix the size needed for the Timer
     */
    public Timer(int prefix)
    {
        stringLength = (prefix + 1) * 16;

        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(20.0F));

        updateImage();
    }

    /**
     * Method act
     *
     * Refreshes the Timer
     */
    public void act()
    {

        updateImage();

    }

    /**
     * Method add
     *
     * Keeps the timer in check
     *
     * @param score Adds a second to the timer
     */
    public void add(int score)
    {
        target += score;
        seconds = target % 60;
        minutes = (target / 60) % 60;

        hours = target / 60 / 60;

    }

    /**
     * Method setValue
     *
     * Sets the Value of current Counter
     *
     * @param score A Sets the value of the counter
     */
    public void setValue(int score)
    {
        target = score;
    }

    /**
     * Make the image
     */
    private void updateImage()
    {
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(hours + ":" + minutes + ":" + seconds, 1, 18);
    }
}
