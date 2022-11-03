package org.bschlangaul.greenfootscenarios.misc.piano.yedefei;

import greenfoot.*;

/**
 * Write a description of class ChooseWorld here.
 *
 */
public class ChooseWorld extends World
{

    /**
     * Constructor for objects of class ChooseWorld.
     *
     */
    private MusicText[] musicArr = {new MusicText("�ɶ�"), new MusicText("����"),
                    new MusicText("�������"), new MusicText("�մ��ɵ�����"),
                    new MusicText("���޵��ǿ�����"), new MusicText("��ɫ��觺�"),
                    new MusicText("���еĻ���"), new MusicText("ƽ��֮·"), new MusicText("ʮ��"),
                    new MusicText("˵�ò���")};

    public ChooseWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 580, 1);

        for (int i = 0; i < musicArr.length; i++)
        {
            addObject(musicArr[i], 150, 105 + 50 * i);
        }

    }

    public void act()
    {
        clickEvent();
    }

    public void clickEvent()
    {
        for (int i = 0; i < musicArr.length; i++)
        {
            if (Greenfoot.mouseClicked(musicArr[i]))
            {
                String str = musicArr[i].getMusicName();
                Greenfoot.setWorld(new Piano(str));
            }
        }
    }
}
