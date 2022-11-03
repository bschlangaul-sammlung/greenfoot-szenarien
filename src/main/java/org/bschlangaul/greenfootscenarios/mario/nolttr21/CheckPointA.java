import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CheckPointA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CheckPointA extends Items
{
    /**
     * Act - do whatever the CheckPointA wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (MarioS.characterName == "mario")
        {
            setImage("M.png");
        }    
        
        if (MarioS.characterName == "luigi")
        {
            setImage("L.png");
        }
        
        if (MarioS.characterName == "toad")
        {
            setImage("T.png");
        }
    }
}
