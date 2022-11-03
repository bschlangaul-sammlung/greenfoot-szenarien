package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; 

/**
 * Write a description of class Bowserjr here.
 *
 */
public class Bowserjr extends NonJumpable
{
    GreenfootImage jr = new GreenfootImage("jr.png");
    public boolean left = true;
    public boolean just = false;
    public int life = 3;
    public int delay = 300;

    public Bowserjr()
    {

    }

    /**
     * Act - do whatever the Bowserjr wants to do. This method is called whenever the 'Act' or 'Run'
     * button gets pressed in the environment.
     */
    public void act()
    {
        if (life >= 1)
        {
            if (left)
            {
                setLocation(getX() - 5, getY());
            }
            else
            {
                setLocation(getX() + 5, getY());
            }
            if (Greenfoot.getRandomNumber(100) == 1)
            {
                getWorld().addObject(new JrFireball(), getX(), getY());
            }
            setImage(jr);

            if (isTouching(Brick.class) || isTouching(LongBrick.class)
                            || Greenfoot.getRandomNumber(100) == 1)
            {
                // jr.mirrorHorizontally();
                if (left)
                {
                    left = false;
                    setLocation(getX() + 10, getY());
                    just = true;
                }
                else
                {
                    left = true;
                    setLocation(getX() - 10, getY());
                    just = true;
                }
            }

            if (just)
            {
                jr.mirrorHorizontally();
                just = false;
            }

            if (isTouching(Bullet.class))
            {

                getWorld().addObject(new Star(), getX(), getY());
                getWorld().addObject(new Star(), getX(), getY());
                getWorld().addObject(new Star(), getX(), getY());
                getWorld().addObject(new Star(), getX(), getY());
                getWorld().addObject(new Star(), getX(), getY());
                getWorld().addObject(new Star(), getX(), getY());
                getWorld().addObject(new Star(), getX(), getY());
                getWorld().addObject(new Star(), getX(), getY());
                getWorld().addObject(new Star(), getX(), getY());
                getWorld().addObject(new Star(), getX(), getY());
                getWorld().addObject(new Star(), getX(), getY());
                getWorld().addObject(new Star(), getX(), getY());
                getWorld().addObject(new Star(), getX(), getY());
                getWorld().addObject(new Star(), getX(), getY());
                getWorld().addObject(new Star(), getX(), getY());
                getWorld().addObject(new Star(), getX(), getY());
                getWorld().addObject(new Star(), getX(), getY());
                getWorld().addObject(new Star(), getX(), getY());
                getWorld().addObject(new Star(), getX(), getY());
                getWorld().addObject(new Star(), getX(), getY());
                getWorld().addObject(new Star(), getX(), getY());
                getWorld().addObject(new Star(), getX(), getY());
                getWorld().addObject(new Star(), getX(), getY());
                getWorld().addObject(new Star(), getX(), getY());
                getWorld().addObject(new Star(), getX(), getY());
                getWorld().addObject(new Star(), getX(), getY());
                getWorld().addObject(new Star(), getX(), getY());

                {
                    // turn(20);
                    // Greenfoot.delay(1);
                    removeTouching(Bullet.class);
                    life--;
                }


            }
        }

        if (life < 1)
        {
            // getWorld().addObject(new Peach(),350,0);
            getWorld().removeObjects(getWorld().getObjects(Cannon2.class));
            getWorld().removeObjects(getWorld().getObjects(JrFireball.class));
            getWorld().removeObjects(getWorld().getObjects(P.class));
            // getWorld().removeObject(this);
            BossWorld2.music.stop();
            turn(20);
            setLocation(getX(), getY() + 5);
            // GameWon.play();

            if (getY() > 500)
            {
                if (delay == 300)
                    Greenfoot.playSound("Down.mp3");
                delay--;
                if (delay == 0)
                    getWorld().addObject(new Peach(), 350, 0);

            }
        }
    }

    public void turn()
    {
        jr.mirrorHorizontally();
    }
}
