import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A LongBrick terrain piece used in the construction of the world.
 * 
 * @author (Dylan Powell and Sean Eastley) 
 * @version (January 21, 2015)
 */
public class LongBrick extends Solid
{
    private boolean changed = false; //determines whether or not the brick's image has been changed to suit the world it is in
    
    
    /**
     * Creates a long brick in the world which is the length of 5 bricks. Has same mechanics as brick, it is just easier to place.
     */
    public LongBrick() 
    {
        GreenfootImage bricks = new GreenfootImage("brick.png");
        GreenfootImage image = new GreenfootImage(160, bricks.getHeight());
        int w = bricks.getWidth();
        for(int offset=0; offset<160; offset+=w) 
        {
            image.drawImage(bricks, offset, 0);
        }
        setImage(image);
    }   
    
    /**
     * This will change the image of the brick to the grey castle brick if the world is worldFour or the BossWorld
     * Eliminates the need for extra coding by making a new class for the grey brick.
     */
    public void act()
    {
        if (getWorld() instanceof Fortress && changed == false)//changed variable here to reduce lag
        {
            GreenfootImage platform = new GreenfootImage("castlebrick.png");
            GreenfootImage image = new GreenfootImage(160, platform.getHeight());
            int w = platform.getWidth();
            for(int offset=0; offset<160; offset+=w) 
            {
                image.drawImage(platform, offset, 0);
            }
            setImage(image);
            changed = true;
        }
        
        if (getWorld() instanceof KoopaWorld && changed == false)//changed variable here to reduce lag
        {
            GreenfootImage platform = new GreenfootImage("castlebrick.png");
            GreenfootImage image = new GreenfootImage(160, platform.getHeight());
            int w = platform.getWidth();
            for(int offset=0; offset<160; offset+=w) 
            {
                image.drawImage(platform, offset, 0);
            }
            setImage(image);
            changed = true;
        }
        
        if (getWorld() instanceof BossWorld2 && changed == false)//changed variable here to reduce lag
        {
            GreenfootImage platform = new GreenfootImage("castlebrick.png");
            GreenfootImage image = new GreenfootImage(160, platform.getHeight());
            int w = platform.getWidth();
            for(int offset=0; offset<160; offset+=w) 
            {
                image.drawImage(platform, offset, 0);
            }
            setImage(image);
            changed = true;
        }
        
        if (getWorld() instanceof BossWorld && changed == false)//changed variable here to reduce lag
        {
            GreenfootImage platform = new GreenfootImage("castlebrick.png");
            GreenfootImage image = new GreenfootImage(160, platform.getHeight());
            int w = platform.getWidth();
            for(int offset=0; offset<160; offset+=w) 
            {
                image.drawImage(platform, offset, 0);
            }
            setImage(image);
            changed = true;
        }
    }
}
