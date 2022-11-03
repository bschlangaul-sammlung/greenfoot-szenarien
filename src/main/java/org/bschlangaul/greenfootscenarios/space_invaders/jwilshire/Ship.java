package org.bschlangaul.greenfootscenarios.space_invaders.jwilshire;

import greenfoot.*; 

/**
 * Write a description of class Ship here.
 *
 */
public class Ship extends Actor
{
    private int lives;
    private boolean laserReady;
    private GreenfootSound explosion;

    public Ship()
    {
        super();
        lives = 4;
        laserReady = true;
        explosion = new GreenfootSound("shipExplosion.wav");
    }

    /**
     * Act - do whatever the Ship wants to do. This method is called whenever the 'Act' or 'Run'
     * button gets pressed in the environment.
     */
    public void act()
    {
        moveLeftOrRight();
        fireMissles();
        boolean stillAlive = checkForAlienFire();
        if (stillAlive)
        {
            checkForInvaderCollision();
        }
    }

    public void fireMissles()
    {
        if (Greenfoot.isKeyDown("space") && laserReady)
        {
            Missle missle = new Missle(this);
            getWorld().addObject(missle, getX(), getY() - 1);
            laserReady = false;
        }
    }

    public void readyLaser()
    {
        laserReady = true;
    }

    public void checkForInvaderCollision()
    {
        Actor alien = getOneIntersectingObject(Alien.class);
        if (alien != null)
        {
            lives--;
            getWorld().removeObject(alien);
            explosion.play();
            for (int i = 0; i < 3; i++)
            {
                setImage("shipExplosion" + i + ".png");
                Greenfoot.delay(30);
            }
            if (lives == 0)
            {
                getWorldOfType(MyWorld.class).gameOver(1);
            }
            else
            {
                setImage("spaceship.gif");
                getWorld().removeObjects(getWorld().getObjects(AlienFire.class));
                getWorldOfType(MyWorld.class).removeLife();
                setLocation(20, getY());
            }
        }
    }

    public boolean checkForAlienFire()
    {
        Actor fire = getOneIntersectingObject(AlienFire.class);
        if (fire != null)
        {
            lives--;
            getWorld().removeObject(fire);
            explosion.play();
            for (int i = 0; i < 3; i++)
            {
                setImage("shipExplosion" + i + ".png");
                Greenfoot.delay(30);
            }
            if (lives == 0)
            {
                getWorldOfType(MyWorld.class).gameOver(1);
                return false;
            }
            else
            {
                setImage("spaceship.gif");
                getWorld().removeObjects(getWorld().getObjects(AlienFire.class));
                getWorldOfType(MyWorld.class).removeLife();
                setLocation(20, getY());
                return true;
            }
        }
        return true;
    }

    public void moveLeftOrRight()
    {
        if (Greenfoot.isKeyDown("a"))
        {
            setLocation(getX() - 1, getY());
        }
        if (Greenfoot.isKeyDown("d"))
        {
            setLocation(getX() + 1, getY());
        }
    }
}
