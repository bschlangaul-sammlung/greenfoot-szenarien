package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This fireball will jump up and down in the holes to attempt to hit mario.
 * 
 * @author (Dylan Powell and Sean Eastley) 
 * @version (January 21, 2015)
 */
public class jFireball extends NonJump
{
    private int jSpeed = -23; //defines how high the fireball will jump
    private int ySpeed; //defines how fast the fireball will fall
    private int jDelayCount; //ticks up to determine when the fireball should jump
    private int jDelayTime = 150; //Number jDelayCount must pass to jump
    
    /**
     * This will tick up the ySpeed and jDelayCount for the fireball movement.
     * It will also call the method for the fireball to jump
     * This will move the fireball if it is in the screen in the Y direction
     */
    public void act() 
    {
        ySpeed ++;
        jDelayCount ++;
        jump();
        if (getY() <= 390)
        {
            setLocation(getX(), getY() + ySpeed);
        }
    }    
    
    /**
     * This will cause the fireball to jump if the delay count has reached the delay time
     */
    private void jump()
    {
        if (jDelayCount >= jDelayTime)
        {
            ySpeed = jSpeed;
            jDelayCount = 0;
            setLocation(getX(), getY() + ySpeed);
        }
    }
}
