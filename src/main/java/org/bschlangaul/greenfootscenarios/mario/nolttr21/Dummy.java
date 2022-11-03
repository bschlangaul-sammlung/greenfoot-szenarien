import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Appears after the boss battle
 * 
 * @author (Dylan Powell and Sean Eastley) 
 * @version (January 21, 2015)
 */
public class Dummy extends Actor
{
    public int ySpeed = 2; //determines how fast peach is falling
    private boolean added = false; //determines if the victory object has been added yet
    public int time;
    public boolean go = false;
    /**
     * Moves peach down two until she collides with a brick as well as calls the method for a collision with mario
     */
    public void act() 
    {
        setLocation(getX(), getY() + ySpeed);
        if (getOneIntersectingObject(LongBrick.class) != null)
        {
            ySpeed = 0;
            if (time % 10 == 1) setLocation(getX(), getY()-1);
        }
        checkCollision();
        time++;
        
        
        if (time == 270)
        {
            setImage("jr.png");
            go = true;
        }
        
        if (go)
        {
            turnTowards(700,0);
            move(3);
        }
        
        if(isAtEdge())
        {
            Greenfoot.setWorld(new Map(true));
        }
    }   
    
    /**
     * I don't understand why I wrote this...
     */
    public void checkCollision()
    {
        if (getOneIntersectingObject(Bowserjr.class)!= null && added == false)
        {
            added = true;
            Greenfoot.setWorld(new GameWon());
        }
        
    }
}
