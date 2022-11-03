package org.bschlangaul.greenfootscenarios.misc.piano.yedefei;

import greenfoot.*;


/**
 * Write a description of class MusicText here.
 *
 */
public class MusicText extends Actor
{
    /**
     * Act - do whatever the MusicText wants to do. This method is called whenever the 'Act' or
     * 'Run' button gets pressed in the environment.
     */
    Font font = new Font("����", false, false, 30);
    String MusicName;

    public MusicText(String MusicName)
    {
        this.MusicName = MusicName;
        GreenfootImage gfi = new GreenfootImage(300, 50);
        gfi.setFont(font);
        gfi.setColor(Color.BLUE);
        int d = MusicName.length() * 30 / 2;
        gfi.drawString(MusicName, 150 - d, 40);
        setImage(gfi);
    }

    public String getMusicName()
    {
        return MusicName;
    }
}
