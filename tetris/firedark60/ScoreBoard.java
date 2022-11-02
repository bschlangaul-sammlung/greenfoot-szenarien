import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)


import java.util.Calendar;

/**
 * The ScoreBoard is used to display results on the screen. It can display some
 * text and several numbers.
 * 
 * @author M Kolling && Brian Huang
 * @version 1.0
 */
public class ScoreBoard extends Actor
{
    //The 
    public static final float FONT_SIZE = 30.0f;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    
    /**
     * Create a score board with dummy result for testing.
     */
    public ScoreBoard()
    {
        this("Game Over",100, 100);
    }

    /**
     * Create a score board for the final result.
     * NOTE: I added so you can make it say what you want instead of only game over.
     */
    public ScoreBoard(String title,int score, int highScore)
    {
        makeImage(title, "Your score is: ", score, highScore);
    }

    /**
     * Make the score board image.
     * NOTE: I added so you can make it say what you want instead of only game over.
     */
    private void makeImage(String title, String prefix, int score, int highScore)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);

        image.setColor(new Color(0, 0, 0, 160));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(255, 255, 255, 100));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 60, 80);
        image.drawString(prefix + score, 60, 130);
        image.drawString("The hi-Score: " + highScore, 60, 180);
        image.drawString("Press 1 to play again", 60, 230);
        image.drawString("Press 2 to see credits", 60, 280);
        setImage(image);
    }
}
