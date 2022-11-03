package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; 

/**
 * A bullet that marioG shoots at enemies to kill them.
 *
 * @author (Dylan Powell and Sean Eastley)
 * @version (January 21, 2015)
 */
public class FriendlyBullet extends Actor
{
    private int damage = 1; // defines how much damage the bullet does to enemies
    private boolean left; // defines whether the bullet should move left or right
    private boolean directionSet = false; // defines whether or not the bullet direction has been
                                          // set or not
    private boolean imminentDeath = false; // determines whether or not to kill the bullet
    public int gravity;

    /**
     * This will call the methods that move and remove the bullet, as well as set the direction for
     * the bullet once.
     */
    public void act()
    {
        if (directionSet == false)
        {
            setDirection();
        }
        if (!imminentDeath)
            moveBullet();

        checkCollision();

    }

    /**
     * This will set the direction for the bullet based on mario's direction when the bullet was
     * shot
     */
    private void setDirection()
    {
        SWorld sWorld = (SWorld) getWorld();
        if (sWorld.marioL == true)
        {
            left = true;
        }
        if (sWorld.marioL == false)
        {
            left = false;
        }
        directionSet = true;
    }

    /**
     * This will move the Bullet based on the original direction that marioG was facing
     */
    public void moveBullet()
    {
        if (isTouching(Ground.class) || isTouching(LongBrick.class) || isTouching(LongBrick.class))
        {
            gravity = 8;
            setLocation(getX(), getY() - 10);
        }
        else
        {

            gravity--;
        }
        setLocation(getX(), getY() - gravity);
        if (left == true)
        {
            move(-8);
        }
        if (left == false)
        {
            move(8);
        }
    }

    /**
     * When called, this will check if the bullet is colliding with any enemies or terrain objects.
     * If the bullet hits an enemy, it will damage the enemy and remove the bullet. If the bullet
     * hits a terrain object, it will remove the bullet.
     */
    public void checkCollision()
    {
        Ghoomba g = (Ghoomba) getOneIntersectingObject(Ghoomba.class);
        FireFlower f = (FireFlower) getOneIntersectingObject(FireFlower.class);
        HammerBro h = (HammerBro) getOneIntersectingObject(HammerBro.class);
        KoopaKid k = (KoopaKid) getOneIntersectingObject(KoopaKid.class);
        MagiKoopa m = (MagiKoopa) getOneIntersectingObject(MagiKoopa.class);
        Brick br = (Brick) getOneIntersectingObject(Brick.class);
        Bowser b = (Bowser) getOneIntersectingObject(Bowser.class);
        Block bl = (Block) getOneIntersectingObject(Block.class);
        // LongBrick lb = (LongBrick) getOneIntersectingObject(LongBrick.class);
        Pipe p = (Pipe) getOneIntersectingObject(Pipe.class);
        Cannon c = (Cannon) getOneIntersectingObject(Cannon.class);
        VerPlatform vp = (VerPlatform) getOneIntersectingObject(VerPlatform.class);
        HorPlatform hp = (HorPlatform) getOneIntersectingObject(HorPlatform.class);
        if (g != null)
        {
            g.hit(damage);
            imminentDeath = true;
        }
        if (f != null)
        {
            f.hit(damage);
            imminentDeath = true;
        }
        if (h != null)
        {
            h.hit(damage);
            imminentDeath = true;
        }
        if (k != null)
        {
            k.hit(damage);
            imminentDeath = true;
        }
        if (m != null)
        {
            m.hit(damage);
            imminentDeath = true;
        }
        if (b != null)
        {
            b.hit(damage);
            imminentDeath = true;
        }
        if (br != null)
        {
            getWorld().removeObject(this);
            return;
        }
        if (bl != null)
        {
            getWorld().removeObject(this);
            return;
        }
        // if(lb != null)
        // {
        // imminentDeath = true;
        // }
        if (p != null)
        {
            getWorld().removeObject(this);
            return;
        }
        if (c != null)
        {
            getWorld().removeObject(this);
            return;
        }
        if (hp != null)
        {
            getWorld().removeObject(this);
            return;
        }
        if (vp != null)
        {
            getWorld().removeObject(this);
            return;
        }
        if (imminentDeath == true)
        {
            StatE.kills++;
            getWorld().removeObject(this);
        }

    }
}
