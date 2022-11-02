package org.bschlangaul.greenfootscenarios.tetris.firedark60;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * The Tetris game (The main program)
 *
 * @Brian Huang
 * @May 26th 2011 -June 12th 2011
 * @Final Project (FiNaL VeRsIoN)
 */

public class TetrisWorld extends World
{

    // Intializes all the variable.
    Counter level = new Counter(2); // The level
    Counter score = new Counter(7); // The current Score
    Counter lines = new Counter(2); // The lines needed to go on to the next level
    Counter combo = new Counter(1); // The combo. How many turns in a row the player scored a line
    Counter hiScore = new Counter(7); // The highest Score so far
    Timer time = new Timer(7); // The timer
    public static int[][] tetrisArray = new int[10][16]; // The game board array
    public Shapes currentShape; // The current piece the player is playing
    public Shapes holdShape; // The Shape being held to be used in a later time
    public int currentShapeNumber; // the number that represents the current Shape
    public int holdShapeNumber; // the number that represents the next Shape
    public int delayTime = 50; // Initial delay time, depedning on level
    public int delayTimeByLevel = 50; // Inital delay time to hit, depending on level
    public boolean haveHold = false; // Check if the player has held this turn
    long startTime = 0; // The starting time
    public boolean hasScoreBoardAppeared = false; // Check if the Scoreboard has appread yet
    public Shapes[] nextShape = new Shapes[6]; // The next Shapes to spawn
    public int[] nextShapeNumber = new int[6]; // The numbers that corasponds the next shape
    public long currentTime; // The current time
    GreenfootSound backgroundMusic = new GreenfootSound("Level 1.mp3"); // The background music

    /**
     * Constructor for objects of class TetrisWorld. This creates more of the permanent objects in
     * the world, and starts up the Actors.
     *
     */
    public TetrisWorld()
    {

        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 500, 1);
        addShape(0);
        addObject(level, 195, 409);
        addObject(lines, 195, 332);
        addObject(combo, 318, 72);
        addObject(hiScore, 495, 417);
        addObject(score, 495, 362);
        addObject(time, 495, 302);
        level.setValue(1);
        lines.setValue(5);
        createBoarder();
        beginNextShapes();
        startTime = System.currentTimeMillis();

    }

    /**
     * Method act The main program.
     */
    public void act()
    {

        // If 1 is pressed, resets the game
        if (Greenfoot.isKeyDown("1"))
        {
            reset();
        }

        // If 2 is pressed, credits pop up
        if (Greenfoot.isKeyDown("2"))
        {
            hasScoreBoardAppeared = true;
            credits();
        }

        if (hasScoreBoardAppeared == false)
        {

            // Checks if music is playing
            backgroundMusic.playLoop();

            // Changes the time so it is accurate
            currentTime = System.currentTimeMillis() - startTime;
            if (currentTime > 1000)
            {
                time.add(1);
                startTime = System.currentTimeMillis();
            }

            // Delays the shape
            delays();

            // If the down button is pressed, moves the shape down
            if (Greenfoot.isKeyDown("down"))
            {

                boolean checkIntersection = currentShape.checkDown();
                if (checkIntersection == true)
                {
                    currentShape.setLocation(currentShape.getX(), currentShape.getY() + 16);

                    // Increase score for dropping faster
                    score.add(1);
                    Greenfoot.playSound("sound 12.mp3");
                }
                else
                {
                    Greenfoot.playSound("sound 10.mp3");
                    finishWithShape();
                }

                // This delay so the it the block doesnt move too fast
                Greenfoot.delay(2);

            }

            // Hard Drops the shape
            if (Greenfoot.isKeyDown("space"))
            {

                boolean checkIntersection = currentShape.checkDown();

                // keeps dropping the shape until it hits something.
                while (checkIntersection == true)
                {
                    checkIntersection = currentShape.checkDown();
                    if (checkIntersection == true)
                    {
                        currentShape.setLocation(currentShape.getX(), currentShape.getY() + 16);
                        score.add(1);

                    }

                    else
                    {
                        Greenfoot.playSound("sound 10.mp3");

                        finishWithShape();
                    }
                }
                Greenfoot.delay(4);
            }

            // Rotates the Shape
            if (Greenfoot.isKeyDown("up"))
            {
                currentShape.rotate();
                Greenfoot.delay(3);

                Greenfoot.playSound("sound 12.mp3");
            }

            // Holds a shape so player can use later, Can only hold once per turn
            else if (Greenfoot.isKeyDown("c") && haveHold == false)
            {
                if (holdShapeNumber == 0)
                {

                    // holds the shape if this is the first shape
                    holdShapeNumber = currentShapeNumber;
                    holdShape = currentShape;
                    removeObject(currentShape);
                    holdShape.getImage().scale(holdShape.getImage().getHeight() / 2,
                                    holdShape.getImage().getWidth() / 2);
                    addObject(holdShape, 255, 80);
                    nextShapes();
                    Greenfoot.playSound("sound 13.mp3");

                }

                // Exchanges the hold Shape with the current Shape
                else
                {
                    int holdShapeNumber1;
                    Shapes holdShape1 = null;
                    holdShapeNumber1 = currentShapeNumber;
                    holdShape1 = currentShape;
                    removeObject(currentShape);
                    currentShapeNumber = holdShapeNumber;
                    removeObject(holdShape);
                    holdShape = holdShape1;
                    holdShapeNumber = holdShapeNumber1;
                    holdShape.getImage().scale(holdShape.getImage().getHeight() / 2,
                                    holdShape.getImage().getWidth() / 2);

                    addObject(holdShape, 255, 80);
                    addShape(currentShapeNumber);
                    Greenfoot.playSound("sound 13.mp3");
                }
                Greenfoot.delay(2);

                // This is so the player cannot switch shape again this turn
                haveHold = true;

            }

            // Checks if it is possible to move shape left, if it is, then move it
            else if (Greenfoot.isKeyDown("left"))
            {
                boolean checkIntersection = currentShape.checkLeft();
                if (checkIntersection == true)
                {

                    currentShape.setLocation(currentShape.getX() - 16, currentShape.getY());
                    Greenfoot.playSound("sound 12.mp3");
                }
                Greenfoot.delay(2);
            }

            // Checks if it is possible to move shape right, if it is, then move it
            else if (Greenfoot.isKeyDown("right"))
            {

                boolean checkIntersection = currentShape.checkRight();
                if (checkIntersection == true)
                {

                    currentShape.setLocation(currentShape.getX() + 16, currentShape.getY());
                    Greenfoot.playSound("sound 12.mp3");
                }
                Greenfoot.delay(2);
            }
        }

    }

    /**
     * Method delays Delay time of drop shapes, with the delay depending on the level difficulty
     *
     */
    public void delays()
    {

        if (delayTime > 0)
            delayTime--;
        else
        {
            // Changes the delay if level up
            delayTime = delayTimeByLevel;
            // drops shape after each delay, and register if it cannot go any further
            boolean checkIntersection = currentShape.checkDown();
            if (checkIntersection == true)
            {
                currentShape.setLocation(currentShape.getX(), currentShape.getY() + 16);
            }
            else
            {
                finishWithShape();
                Greenfoot.playSound("sound 10.mp3");
            }
        }
    }

    /**
     * Method finishWithShape This registers the shape, and if the shape is in front of the spawning
     * area, then it goes to Game Over
     */
    public void finishWithShape()
    {

        // Registers the shape
        if ((getObjectsAt(304, 116, null)).isEmpty())
        {
            redrawCetainArea(currentShape.registerShape());
            lineCheck();
            haveHold = false;
            nextShapes();
        }
        // If a piece is in the spawning area, then Game Over
        else if (hasScoreBoardAppeared == false)
        {
            // Stops the music, register highscore, and pop up Game Over Scoreboard
            backgroundMusic.stop();
            if (score.getValue() > hiScore.getValue())
            {
                hiScore.setValue(score.getValue());
            }
            if (score.getValue() > 1000)
            {
                Greenfoot.playSound("Good Job!.mp3");
            }
            addObject(new ScoreBoard("Game Over", score.getValue(), hiScore.getValue()),
                            getWidth() / 2, getHeight() / 2);
            hasScoreBoardAppeared = true;
        }

    }

    /**
     * Method addShape Adds a new Current Shape to the game
     *
     * @param x Shape to Spawn
     */
    public void addShape(int x)
    {

        int shape;
        if (x == 0)
        {
            shape = Greenfoot.getRandomNumber(7) + 1;
        }
        else
        {
            shape = x;
        }

        currentShapeNumber = shape;
        if (shape == 1)
        {
            currentShape = new LShape();

            addObject(currentShape, 304, 116);
        }

        else if (shape == 2)
        {
            currentShape = new LineShape();
            addObject(currentShape, 312, 124);

        }
        else if (shape == 3)
        {
            currentShape = new ReverseLShape();
            addObject(currentShape, 304, 116);

        }
        else if (shape == 4)
        {
            currentShape = new Squiggly();
            addObject(currentShape, 304, 116);

        }
        else if (shape == 5)
        {
            currentShape = new ReverseSquiggly();
            addObject(currentShape, 304, 116);
        }

        else if (shape == 6)
        {
            currentShape = new BoxShape();
            addObject(currentShape, 304, 124);
        }
        else if (shape == 7)
        {
            currentShape = new TShape();
            addObject(currentShape, 312, 124);
        }

    }

    /**
     * Method beginNextShapes
     *
     * Starts up the next Shapes
     */
    public void beginNextShapes()
    {

        for (int i = 0; i < 6; i++)
        {
            nextShapeNumber[i] = Greenfoot.getRandomNumber(7) + 1;
            if (nextShapeNumber[i] == 1)
            {
                nextShape[i] = new LShape();
            }
            else if (nextShapeNumber[i] == 2)
            {
                nextShape[i] = new LineShape();

            }
            else if (nextShapeNumber[i] == 3)
            {
                nextShape[i] = new ReverseLShape();

            }
            else if (nextShapeNumber[i] == 4)
            {
                nextShape[i] = new Squiggly();

            }
            else if (nextShapeNumber[i] == 5)
            {
                nextShape[i] = new ReverseSquiggly();
            }

            else if (nextShapeNumber[i] == 6)
            {
                nextShape[i] = new BoxShape();
            }
            else if (nextShapeNumber[i] == 7)
            {
                nextShape[i] = new TShape();
            }
        }

        // adds the next Shapes
        addObject(nextShape[0], 370, 75);
        addObject(nextShape[1], 435, 75);
        addObject(nextShape[2], 435, 105);
        addObject(nextShape[3], 435, 140);
        addObject(nextShape[4], 435, 175);
        addObject(nextShape[5], 435, 210);

        // Scale to fit
        for (int i = 0; i < 6; i++)
        {
            nextShape[i].getImage().scale(nextShape[i].getImage().getHeight() / 2,
                            nextShape[i].getImage().getWidth() / 2);
        }

    }

    /**
     * Method nextShapes Makes the next Shape into the current Shape, and moves all the next Shape
     * up by 1
     */
    public void nextShapes()
    {
        addShape(nextShapeNumber[0]);
        currentShapeNumber = nextShapeNumber[0];
        for (int i = 0; i < 6; i++)
        {
            removeObject(nextShape[i]);
        }
        for (int i = 0; i < 5; i++)
        {
            nextShape[i] = nextShape[i + 1];
            nextShapeNumber[i] = nextShapeNumber[i + 1];
        }
        addObject(nextShape[0], 370, 75);
        addObject(nextShape[1], 435, 75);
        addObject(nextShape[2], 435, 105);
        addObject(nextShape[3], 435, 140);
        addObject(nextShape[4], 435, 175);

        // Adds a new next Shape
        nextShapeNumber[5] = Greenfoot.getRandomNumber(7) + 1;

        if (nextShapeNumber[5] == 1)
        {
            nextShape[5] = new LShape();
        }
        else if (nextShapeNumber[5] == 2)
        {
            nextShape[5] = new LineShape();

        }
        else if (nextShapeNumber[5] == 3)
        {
            nextShape[5] = new ReverseLShape();

        }
        else if (nextShapeNumber[5] == 4)
        {
            nextShape[5] = new Squiggly();

        }
        else if (nextShapeNumber[5] == 5)
        {
            nextShape[5] = new ReverseSquiggly();
        }

        else if (nextShapeNumber[5] == 6)
        {
            nextShape[5] = new BoxShape();
        }
        else if (nextShapeNumber[5] == 7)
        {
            nextShape[5] = new TShape();
        }

        // Scale to fit
        nextShape[5].getImage().scale(nextShape[5].getImage().getHeight() / 2,
                        nextShape[5].getImage().getWidth() / 2);
        addObject(nextShape[5], 435, 210);

    }

    /**
     * Method credits Pops up credits Page
     */
    public void credits()
    {
        Credits creditPage = new Credits();
        addObject(creditPage, 300, 250);
        backgroundMusic.stop();
        backgroundMusic = new GreenfootSound("Level 10.mp3");
        backgroundMusic.playLoop();
    }

    /**
     * Method lineCheck Checks for and clear filled Line, adds up the points, changes the level ,
     * and change the level music if needed.
     */
    public void lineCheck()
    {
        int linesCleared = 0;

        // Loops through the array for filled line
        for (int i = 0; i < 16; i++)
        {
            boolean lineIsFull = true;
            for (int j = 0; j < 10; j++)
            {
                if (tetrisArray[j][i] == 0)
                {
                    lineIsFull = false;
                    break;
                }
            }
            if (lineIsFull == false)
            {
                continue;
            }
            // If there is a filled line, clear the line and move all the lines down
            else if (lineIsFull == true)
            {
                linesCleared++;
                for (int k = i; k >= 0; k--)
                {
                    for (int l = 0; l < 10; l++)
                    {
                        if (k == 0)
                        {
                            tetrisArray[l][k] = 0;
                        }
                        else
                        {
                            tetrisArray[l][k] = tetrisArray[l][k - 1];
                        }
                    }
                }
            }
        }

        // Depending how many lines cleared and how many time lines were cleared per turn, points
        // are scored
        if (linesCleared == 0)
        {
            combo.setValue(0);
        }
        else if (linesCleared == 1)
        {
            Greenfoot.playSound("sound 8.mp3");
            combo.add(1);
            score.add(100 * (combo.getValue() + 1));
            lines.subtract(1);
            redraw();
        }
        else if (linesCleared == 2)
        {
            Greenfoot.playSound("sound 8.mp3");
            Greenfoot.playSound("Double.mp3");
            combo.add(1);
            score.add(250 * (combo.getValue() + 1));
            lines.subtract(2);
            redraw();
        }
        else if (linesCleared == 3)
        {
            Greenfoot.playSound("sound 8.mp3");
            Greenfoot.playSound("Triple.mp3");
            combo.add(1);
            score.add(400 * (combo.getValue() + 1));
            lines.subtract(3);
            redraw();
        }
        else if (linesCleared == 4)
        {
            Greenfoot.playSound("sound 8.mp3");
            Greenfoot.playSound("Tetris.mp3");
            combo.add(1);
            score.add(800 * (combo.getValue() + 1));
            lines.subtract(4);
            redraw();

        }

        // If combo was increased, play combo Increased sounds.
        if (combo.getValue() == 3)
        {
            Greenfoot.playSound("Combo 3.mp3");
        }
        else if (combo.getValue() == 4)
        {
            Greenfoot.playSound("Combo 4.mp3");
        }
        else if (combo.getValue() == 5)
        {
            Greenfoot.playSound("Combo 5.mp3");
        }
        else if (combo.getValue() == 6)
        {
            Greenfoot.playSound("Combo 6.mp3");
        }
        else if (combo.getValue() == 7)
        {
            Greenfoot.playSound("Combo 7.mp3");
        }
        else if (combo.getValue() == 8)
        {
            Greenfoot.playSound("Combo 8.mp3");
        }
        else if (combo.getValue() == 9)
        {
            Greenfoot.playSound("Combo 9.mp3");
        }
        else if (combo.getValue() >= 10)
        {
            Greenfoot.playSound("Combo 10.mp3");
        }

        // If the lines of the levels were cleared, move up level and change the music
        if (lines.getValue() <= 0)
        {
            level.add(1);
            Greenfoot.playSound("Level Up.mp3");
            lines.setValue(level.getValue() * 10 + lines.getValue());
            delayTimeByLevel -= 5;

            if (level.getValue() == 2)
            {
                backgroundMusic.stop();
                backgroundMusic = new GreenfootSound("Level 2.mp3");
            }
            if (level.getValue() == 3)
            {
                backgroundMusic.stop();
                backgroundMusic = new GreenfootSound("Level 3.mp3");
            }
            if (level.getValue() == 4)
            {
                backgroundMusic.stop();
                backgroundMusic = new GreenfootSound("Level 4.mp3");
            }
            if (level.getValue() == 5)
            {
                backgroundMusic.stop();
                backgroundMusic = new GreenfootSound("Level 5.mp3");
            }
            if (level.getValue() == 6)
            {
                backgroundMusic.stop();
                backgroundMusic = new GreenfootSound("Level 6.mp3");
            }
            if (level.getValue() == 7)
            {
                backgroundMusic.stop();
                backgroundMusic = new GreenfootSound("Level 7.mp3");
            }
            if (level.getValue() == 8)
            {
                backgroundMusic.stop();
                backgroundMusic = new GreenfootSound("Level 8.mp3");
            }
            if (level.getValue() == 9)
            {
                backgroundMusic.stop();
                backgroundMusic = new GreenfootSound("Level 9.mp3");
            }
            if (level.getValue() == 10)
            {
                backgroundMusic.stop();
                backgroundMusic = new GreenfootSound("Level 10.mp3");
            }

            // If it hits level 11, the player wins!
            if (level.getValue() == 11)
            {
                if (hasScoreBoardAppeared == false)
                {
                    backgroundMusic.stop();
                    if (score.getValue() > hiScore.getValue())
                    {
                        hiScore.setValue(score.getValue());
                    }

                    Greenfoot.playSound("You Win!.mp3");

                    addObject(new ScoreBoard("You Win!", score.getValue(), hiScore.getValue()),
                                    getWidth() / 2, getHeight() / 2);
                    hasScoreBoardAppeared = true;
                }

            }

        }

    }

    /**
     * Method redrawCetainArea
     *
     * Redraws the area the Shape stopped in
     *
     * @param x 4 coordinates of the current shape to register
     */
    public void redrawCetainArea(int[] x)
    {

        // loops through the co-ords and registers it in the array
        for (int h = 0; h < 4; h++)
        {
            int i;
            int j;

            if (h == 0)
            {
                i = x[0];
                j = x[1];
            }
            else if (h == 1)
            {
                i = x[2];
                j = x[3];
            }
            else if (h == 2)
            {
                i = x[4];
                j = x[5];
            }
            else
            {
                i = x[6];
                j = x[7];
            }
            // Draws the blocks if needed.
            if (tetrisArray[i][j] == 1)
            {
                if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, L.class)).isEmpty()))
                {
                    continue;
                }
                else if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, null)).isEmpty()))
                {
                    removeObjects(getObjectsAt(i * 16 + 248, j * 16 + 116, null));
                }
                addObject(new L(), i * 16 + 248, j * 16 + 116);
            }

            else if (tetrisArray[i][j] == 2)
            {
                if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, I.class)).isEmpty()))
                {
                    continue;
                }
                else if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, null)).isEmpty()))
                {
                    removeObjects(getObjectsAt(i * 16 + 248, j * 16 + 116, null));
                }
                addObject(new I(), i * 16 + 248, j * 16 + 116);
            }

            else if (tetrisArray[i][j] == 3)
            {
                if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, J.class)).isEmpty()))
                {
                    continue;
                }
                else if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, null)).isEmpty()))
                {
                    removeObjects(getObjectsAt(i * 16 + 248, j * 16 + 116, null));
                }
                addObject(new J(), i * 16 + 248, j * 16 + 116);
            }

            else if (tetrisArray[i][j] == 4)
            {
                if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, S.class)).isEmpty()))
                {
                    continue;
                }
                else if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, null)).isEmpty()))
                {
                    removeObjects(getObjectsAt(i * 16 + 248, j * 16 + 116, null));
                }
                addObject(new S(), i * 16 + 248, j * 16 + 116);
            }

            else if (tetrisArray[i][j] == 5)
            {
                if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, Z.class)).isEmpty()))
                {
                    continue;
                }
                else if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, null)).isEmpty()))
                {
                    removeObjects(getObjectsAt(i * 16 + 248, j * 16 + 116, null));
                }
                addObject(new Z(), i * 16 + 248, j * 16 + 116);
            }

            else if (tetrisArray[i][j] == 6)
            {
                if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, O.class)).isEmpty()))
                {
                    continue;
                }
                else if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, null)).isEmpty()))
                {
                    removeObjects(getObjectsAt(i * 16 + 248, j * 16 + 116, null));
                }
                addObject(new O(), i * 16 + 248, j * 16 + 116);
            }

            else
            {
                if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, T.class)).isEmpty()))
                {
                    continue;
                }
                else if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, null)).isEmpty()))
                {
                    removeObjects(getObjectsAt(i * 16 + 248, j * 16 + 116, null));
                }
                addObject(new T(), i * 16 + 248, j * 16 + 116);
            }
        }

    }

    /**
     * Method redraw
     *
     * Redraws the whole playing field (Only used when clearing lines)
     */
    public void redraw()
    {

        // Goes through array by loop and replace the blocks in needed
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 16; j++)
            {

                if (tetrisArray[i][j] == 0)
                {
                    if ((getObjectsAt(i * 16 + 248, j * 16 + 116, null)).isEmpty())
                    {
                        continue;
                    }
                    else
                    {
                        removeObjects(getObjectsAt(i * 16 + 248, j * 16 + 116, null));
                    }
                }

                else if (tetrisArray[i][j] == 1)
                {
                    if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, L.class)).isEmpty()))
                    {
                        continue;
                    }
                    else if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, null)).isEmpty()))
                    {
                        removeObjects(getObjectsAt(i * 16 + 248, j * 16 + 116, null));
                    }
                    addObject(new L(), i * 16 + 248, j * 16 + 116);
                }

                else if (tetrisArray[i][j] == 2)
                {
                    if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, I.class)).isEmpty()))
                    {
                        continue;
                    }
                    else if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, null)).isEmpty()))
                    {
                        removeObjects(getObjectsAt(i * 16 + 248, j * 16 + 116, null));
                    }
                    addObject(new I(), i * 16 + 248, j * 16 + 116);
                }

                else if (tetrisArray[i][j] == 3)
                {
                    if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, J.class)).isEmpty()))
                    {
                        continue;
                    }
                    else if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, null)).isEmpty()))
                    {
                        removeObjects(getObjectsAt(i * 16 + 248, j * 16 + 116, null));
                    }
                    addObject(new J(), i * 16 + 248, j * 16 + 116);
                }

                else if (tetrisArray[i][j] == 4)
                {
                    if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, S.class)).isEmpty()))
                    {
                        continue;
                    }
                    else if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, null)).isEmpty()))
                    {
                        removeObjects(getObjectsAt(i * 16 + 248, j * 16 + 116, null));
                    }
                    addObject(new S(), i * 16 + 248, j * 16 + 116);
                }

                else if (tetrisArray[i][j] == 5)
                {
                    if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, Z.class)).isEmpty()))
                    {
                        continue;
                    }
                    else if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, null)).isEmpty()))
                    {
                        removeObjects(getObjectsAt(i * 16 + 248, j * 16 + 116, null));
                    }
                    addObject(new Z(), i * 16 + 248, j * 16 + 116);
                }

                else if (tetrisArray[i][j] == 6)
                {
                    if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, O.class)).isEmpty()))
                    {
                        continue;
                    }
                    else if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, null)).isEmpty()))
                    {
                        removeObjects(getObjectsAt(i * 16 + 248, j * 16 + 116, null));
                    }
                    addObject(new O(), i * 16 + 248, j * 16 + 116);
                }

                else
                {
                    if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, T.class)).isEmpty()))
                    {
                        continue;
                    }
                    else if (!((getObjectsAt(i * 16 + 248, j * 16 + 116, null)).isEmpty()))
                    {
                        removeObjects(getObjectsAt(i * 16 + 248, j * 16 + 116, null));
                    }
                    addObject(new T(), i * 16 + 248, j * 16 + 116);
                }

            }
        }
    }

    /**
     * Method createBoarder Intializes the Boarder of the game, so the blocks don't fall out of the
     * game
     */
    public void createBoarder()
    {

        for (int i = 0; i < 17; i++)
        {
            addObject(new Boarder(), 232, i * 16 + 116);
        }
        for (int i = 0; i < 17; i++)
        {
            addObject(new Boarder(), 408, i * 16 + 116);
        }
        for (int i = 0; i < 11; i++)
        {
            addObject(new Boarder(), i * 16 + 232, 372);
        }
        for (int i = 0; i < 11; i++)
        {
            addObject(new Boarder(), i * 16 + 232, 100);
        }

    }

    /**
     * Method reset
     *
     * Resets the Game
     */
    public void reset()
    {
        removeObjects(getObjects(null));

        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 16; j++)
            {
                tetrisArray[i][j] = 0;
            }
        }
        backgroundMusic.stop();
        currentShapeNumber = 0;
        holdShapeNumber = 0;
        delayTime = 30;
        delayTimeByLevel = 40;
        haveHold = false;
        redraw();
        addShape(0);
        addObject(level, 195, 409);
        addObject(lines, 195, 332);
        addObject(combo, 318, 72);
        addObject(hiScore, 495, 417);
        addObject(score, 495, 362);
        addObject(time, 495, 302);
        level.setValue(1);
        lines.setValue(5);
        score.setValue(0);
        time.setValue(0);
        createBoarder();
        beginNextShapes();
        backgroundMusic = new GreenfootSound("Level 1.mp3");
        backgroundMusic.playLoop();
        startTime = System.currentTimeMillis();
        currentTime = System.currentTimeMillis();
        hasScoreBoardAppeared = false;
    }

}
