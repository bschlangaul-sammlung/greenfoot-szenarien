import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This will give out powerups to mario based on what kind of mario he is (gun, big, small)
 * 
 * @author (Dylan Powell and Sean Eastley) 
 * @version (January 21, 2015)
 */
public class Block extends Solid
{
    private int powerUpChance; //determines the chance of getting each powerup
    private boolean bumped = false; //determines whether the block has been hit or not
    private GreenfootImage imageSpent;
    private int scrolled; //determines how far the main actor has moved
    GreenfootSound bump = new GreenfootSound("Bump.wav");
    public int y;
    /**
     * This will define the image for the block
     */
    public Block()
    {
        imageSpent = new GreenfootImage("SpentBlock.png");
    }
    
    /**
     * This will run the checkHit method for the block
     */
    public void act() 
    {
        checkHit();
    }    
    
    /**
     * This will check if the block has been hit by mario
     * If the block was hit by mario or marioG, then the block will create ammo or a heart, based on a random number.
     * If the block was hit by marioS, then the block will create a mushroom or a heart, based on a random number.
     */
    public void checkHit()
    {
        if (getOneObjectAtOffset (0, getImage().getHeight()/2+1, MarioG.class)!= null && getImage() != imageSpent)
        {
            bumped = true;
        }
        if (getOneObjectAtOffset (0, getImage().getHeight()/2+1, Mario.class)!= null && getImage() != imageSpent)
        {
            bumped = true;
        }
        if (getOneObjectAtOffset (0, getImage().getHeight()/2+1, MarioS.class)!= null && getImage() != imageSpent)
        {
            bumped = true;
        }
        if (bumped == true)
        {
            bump.play();
            SWorld sWorld = (SWorld)getWorld();
            scrolled = sWorld.getUnivX(getX());
            y = sWorld.getUnivY(getY());
            if(sWorld.marioGun == true)
            {
                powerUpChance = Greenfoot.getRandomNumber(10);
                if (powerUpChance <= 9)
                {
                    ((SWorld)getWorld()).addObject(new Ammo(), scrolled, y, true);
                }
                if (powerUpChance > 9)
                {
                    
                    ((SWorld)getWorld()).addObject(new Heart(),scrolled, y, true);
                }
                bumped = false;
                setImage(imageSpent);
                
            }
            if(sWorld.marioBig == true)
            {
                powerUpChance = Greenfoot.getRandomNumber(10);
                if (powerUpChance <= 7)
                {
                    ((SWorld)getWorld()).addObject(new Ammo(),scrolled, y, true);
                }
                if (powerUpChance > 7)
                {
                    ((SWorld)getWorld()).addObject(new Heart(),scrolled, y, true);
                }
                bumped = false;
                setImage(imageSpent);
            }
            if(sWorld.marioSmall == true)
            {
                powerUpChance = Greenfoot.getRandomNumber(10);
                if (powerUpChance <= 9)
                {
                    ((SWorld)getWorld()).addObject(new Mushroom(),scrolled, y, true);
                }
                if (powerUpChance > 9)
                {
                    ((SWorld)getWorld()).addObject(new Heart(),scrolled, y, true);
                }
                
                bumped = false;
                setImage(imageSpent);
            }
        }
    }
}
