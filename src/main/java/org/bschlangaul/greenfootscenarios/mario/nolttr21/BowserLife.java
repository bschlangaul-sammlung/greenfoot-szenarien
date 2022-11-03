package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;


/**
 * This will display Bowser's lives to the user
 *
 * @author (Dylan Powell and Sean Eastley)
 * @version (January 21, 2015)
 */
public class BowserLife extends Unneeded
{
    private static final String healthLabel = "Health: "; // This will be displayed on the
                                                          // scoreboard before the number of hits
                                                          // left
    private static final String nameLabel = "BOWSER"; // This will be displayed on the scoreboard to
                                                      // show that the lives belong to bowser
    private GreenfootImage box; // This is the background for the scoreboard

    /**
     * This will create the scoreboard background box
     */
    public BowserLife()
    {
        box = new GreenfootImage(60, 30);

        box.setColor(new Color(0, 0, 0, 0));
        box.fillRect(0, 0, 60, 30);
        updateScore(50);
    }

    /**
     * This will update the score on the scoreboard. This makes the scoreboard display yellow text
     * with the lives label and the lives.
     */
    public void updateScore(int hits)
    {
        GreenfootImage img = new GreenfootImage(box);

        img.setColor(Color.YELLOW);
        img.drawString(nameLabel, 5, 12);
        img.drawString(healthLabel + hits, 5, 25);

        setImage(img);
    }
}
