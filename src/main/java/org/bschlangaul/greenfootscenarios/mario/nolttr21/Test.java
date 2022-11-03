package org.bschlangaul.greenfootscenarios.mario.nolttr21;

import greenfoot.*;

/**
 * Write a description of class Test here.
 */
public class Test extends SWorld
{

    /**
     * Constructor for objects of class Test.
     *
     */
    public Test()
    {
        super(600, 400, 1, 600, 400);

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial objects and add
     * them to the world.
     */
    private void prepare()
    {
        MarioS marios = new MarioS(0);
        addObject(marios, 311, 45);
        LongBrick longbrick = new LongBrick();
        addObject(longbrick, 325, 349);
    }
}
