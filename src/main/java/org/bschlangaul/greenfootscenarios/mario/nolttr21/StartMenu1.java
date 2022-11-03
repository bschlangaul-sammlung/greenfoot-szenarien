package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;

/**
 * Write a description of class StartMenu3 here.
 *
 * @author (Dylan Powell and Sean Eastley)
 * @version (January 21, 2015)
 */
public class StartMenu1 extends World
{
    private int enterDelayCount;
    public boolean added = false;
    GreenfootSound theme = new GreenfootSound("Menu theme.mp3");
    GreenfootSound clicked = new GreenfootSound("Clicked.wav");

    /**
     * Constructor for objects of class StartMenu1.
     *
     */
    public StartMenu1()
    {
        super(700, 400, 1, false);



        SWorld.lives = 5;

        MapMario.alreadyKey = false;
        MapMario.doKey = false;
        Map.clears = 0;

        Map.unlocked = false;
        // SWorld.marioIsSmall();
        addObject(new Title(), 350, -100);

    }


    public void act()
    {
        enterDelayCount++;
        if (enterDelayCount == 1)
        {
            prep();
        }
        if (theme.isPlaying() == false && enterDelayCount > 30)
        {
            theme.playLoop();
        }

        if (Greenfoot.isKeyDown("enter") && enterDelayCount > 60 && !added)
        {


            removeObjects(getObjects(PressEnter.class));
            Greenfoot.playSound("play.mp3");

            addObject(new CharacterArrow(), 280, 250);
            added = true;
            Greenfoot.setSpeed(49);
        }


        // MapMario.position = 0;
        if (enterDelayCount % 6 == 1)
        {
            addObject(new StartGround(), 710, 216);
        }
        MapMario.goingBackTo = 0;

    }



    /**
     * Prepare the world for the start of the program. That is: create the initial objects and add
     * them to the world.
     */
    private void prep()
    {
        StartGround startground = new StartGround();
        addObject(startground, 22, 222);
        StartGround startground2 = new StartGround();
        addObject(startground2, 59, 219);
        StartGround startground3 = new StartGround();
        addObject(startground3, 100, 220);
        StartGround startground4 = new StartGround();
        addObject(startground4, 135, 220);
        StartGround startground5 = new StartGround();
        addObject(startground5, 174, 220);
        StartGround startground6 = new StartGround();
        addObject(startground6, 209, 216);
        StartGround startground7 = new StartGround();
        addObject(startground7, 247, 216);
        StartGround startground8 = new StartGround();
        addObject(startground8, 292, 215);
        StartGround startground9 = new StartGround();
        addObject(startground9, 332, 215);
        StartGround startground10 = new StartGround();
        addObject(startground10, 368, 215);
        StartGround startground11 = new StartGround();
        addObject(startground11, 413, 215);
        StartGround startground12 = new StartGround();
        addObject(startground12, 443, 218);
        StartGround startground13 = new StartGround();
        addObject(startground13, 497, 212);
        StartGround startground14 = new StartGround();
        addObject(startground14, 525, 212);
        StartGround startground15 = new StartGround();
        addObject(startground15, 567, 214);
        StartGround startground16 = new StartGround();
        addObject(startground16, 602, 214);
        StartGround startground17 = new StartGround();
        addObject(startground17, 635, 212);
        StartGround startground18 = new StartGround();
        addObject(startground18, 664, 212);
        StartGround startground19 = new StartGround();
        addObject(startground19, 692, 213);
        StartGround startground20 = new StartGround();
        addObject(startground20, 474, 218);
        StartGround startground21 = new StartGround();
        addObject(startground21, 391, 216);
        StartGround startground22 = new StartGround();
        addObject(startground22, 274, 221);
        startground.setLocation(16, 216);
        startground2.setLocation(48, 216);
        startground3.setLocation(79, 216);
        startground4.setLocation(111, 216);
        startground5.setLocation(143, 216);
        startground6.setLocation(175, 216);
        startground7.setLocation(206, 216);
        startground22.setLocation(238, 216);
        startground8.setLocation(270, 216);
        startground9.setLocation(302, 216);
        startground10.setLocation(334, 216);
        startground21.setLocation(366, 216);
        startground11.setLocation(398, 216);
        startground12.setLocation(430, 216);
        startground20.setLocation(462, 216);
        startground13.setLocation(494, 216);
        startground14.setLocation(526, 216);
        startground15.setLocation(557, 216);
        startground16.setLocation(589, 216);
        startground17.setLocation(621, 216);
        startground18.setLocation(652, 216);
        startground19.setLocation(684, 216);
        SelectedMario selectedmario = new SelectedMario();
        addObject(selectedmario, 44, 180);
        selectedmario.setLocation(42, 175);
        SelectedLuigi selectedluigi = new SelectedLuigi();
        addObject(selectedluigi, 114, 182);
        selectedluigi.setLocation(114, 175);


        SelectedBlue toad = new SelectedBlue();
        addObject(toad, 44, 180);
        toad.setLocation(78, 175);
    }
}
