package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*; 


/**
 * This will display the lives and the ammo to the user
 *
 * @author (Dylan Powell and Sean Eastley)
 * @version (January 21, 2015)
 */
public class ScoreBoard extends Unneeded
{
    private static final String livesLabel = "Lives: "; // This will be displayed on the scoreboard
                                                        // before the number of lives
    private static final String ammunitionLabel = "Ammo: "; // This will be displayed on the
                                                            // scoreboard before the amount of ammo
    private GreenfootImage box; // This is the background for the scoreboard
    public static int Lives;

    /**
     * This will create the scoreboard background box
     */
    public ScoreBoard()
    {
        box = new GreenfootImage(80, 30);

        box.setColor(new Color(0, 0, 0, 80));
        box.fillRect(0, 0, 80, 30);
        // updateScore (0, 0);
    }

    /**
     * This will update the score on the scoreboard. This makes the scoreboard display yellow text
     * with the lives label and the lives as well as the ammunition label and the ammunition below
     * it
     */
    public void updateScore(int lives, int ammunition)
    {
        GreenfootImage img = new GreenfootImage(box);
        Lives = lives;
        img.setColor(Color.RED);
        img.drawString(livesLabel + lives, 5, 12);
        img.drawString(ammunitionLabel + ammunition, 5, 25);

        setImage(img);
    }
}
