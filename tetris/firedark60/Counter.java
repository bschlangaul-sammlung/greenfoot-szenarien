import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)



/**
 * Counter that displays a number.
 * 
 * @author Michael Kolling & Brian Huang
 * @version 1.0.1
 */
public class Counter extends Actor
{

    //variables needed
    private int target = 0;
    private int stringLength;

    /**
     * Counter Constructor
     *
     * Creates the size, font and length of the Counter
     * @param prefix the size needed for the Counter
     */
    public Counter(int prefix)
    {
        stringLength = (prefix + 1) * 16;

        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(20.0F));  // use larger font

        updateImage();
    }

    /**
     * Method act
     *
     * Refreshes the Counter
     */
    public void act() {
        updateImage();
    }

    /**
     * Method add
     *
     * Adds a value to the current Counter
     * @param score score to add
     */
    public void add(int score)
    {
        target += score;
    }

    /**
     * Method subtract
     *
     * Subtracts a value to the current Counter
     * @param score score to subtract
     */
    public void subtract(int score)
    {
        target -= score;
    }

    /**
     * Method getValue
     *
     * Gets the Value of current Counter
     * @return The return value of counter
     */
    public int getValue()
    {
        return target;
    }

    
    /**
     * Method setValue
     *
     * Sets the Value of current Counter
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
        image.drawString("" + target, 1, 18);
    }
}
