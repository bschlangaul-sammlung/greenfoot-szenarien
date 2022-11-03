package org.bschlangaul.greenfootscenarios.misc.piano.yedefei;
import greenfoot.*;

/**
 * Write a description of class MainWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MainWorld extends World
{

    /**
     * Constructor for objects of class MainWorld.
     *
     */
    FreeModel freeModel = new FreeModel();
    ScoreModel scoreModel = new ScoreModel();
    public MainWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1066, 800, 1);
        addObject(new Logo(),500,100);
        addObject(new LittleLogo(),750,210);
        addObject(freeModel,600,450);
        addObject(scoreModel,600,600);
        addObject(new RecordMachine(),150,700);
        addObject(new NoteImage(),950,700);
    }
    public void act(){
        clickEvent();
    }
    public void clickEvent(){
        if(Greenfoot.mouseClicked(freeModel)){
            Greenfoot.setWorld(new Piano("free"));
        }
        if(Greenfoot.mouseClicked(scoreModel)){
            Greenfoot.setWorld(new ChooseWorld());
        }
    }
}
