package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; 

/**
 * This will shoot cannonballs at mario and is not destroyable
 *
 * @author (Dylan Powell and Sean Eastley)
 * @version (January 21, 2015)
 */
public class Cannon2 extends Solid
{
    public int cannonDelayCount; // ticks up to delay shooting
    public int cannonDelayTime; // determines how long the cannon has to wait to shoot
    private int scrolled; // determines where to place the cannonball in the world
    GreenfootSound shot = new GreenfootSound("Explosion.wav");
    public static boolean shoot = false;
    public int depressCount = 1;

    /**
     * Initializes the delay time for the cannon
     */
    public Cannon2()
    {
        // cannonDelayTime = 200;
        setRotation(90);
    }

    /**
     * This will tick up the delay count for the cannon and call the method to add it.
     */
    public void act()
    {
        if (shoot)
        {
            getWorld().addObject(new Bullet(), getX(), getY());
            depressCount++;
            try
            {
                Actor obj = getWorld().getObjects(Bullet.class).get(depressCount);
                getWorld().removeObject(obj);
            } catch (IndexOutOfBoundsException e)
            {

            }
            shoot = false;
        }
        // cannonDelayCount ++;
    }
}

