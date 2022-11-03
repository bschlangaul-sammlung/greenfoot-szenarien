package org.bschlangaul.greenfootscenarios.misc.piano.yedefei;
import greenfoot.*;

/**
 * Write a description of class KeysScaleColor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class KeysScaleColor extends Actor
{
    /**
     * Act - do whatever the KeysScaleColor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static Color getScaleColor(int scale){
        Color color = new Color(0,0,0);
        switch(scale){
            case 2:color = new Color(204,204,214);break;
            case 3:color = new Color(147,181,207);break;
            case 4:color = new Color(164,202,182);break;
            case 5:color = new Color(251,185,87);break;
            case 6:color = new Color(238,128,85);break;
            case 7:color = new Color(240,124,130);break;
        }
        return color;
    }
}
