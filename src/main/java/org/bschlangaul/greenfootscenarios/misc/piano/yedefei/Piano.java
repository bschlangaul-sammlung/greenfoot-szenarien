package org.bschlangaul.greenfootscenarios.misc.piano.yedefei;

import greenfoot.*; // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.HashMap;

/**
 * �����࣬���������ټ�
 */
public class Piano extends World
{
    private String[] whiteKeyBoardName = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "q",
                    "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j",
                    "k", "l", "z", "x", "c", "v", "b", "n", "m"};
    private String[] whiteKeysSoundName = {"C2", "D2", "E2", "F2", "G2", "A2", "B2", "C3", "D3",
                    "E3", "F3", "G3", "A3", "B3", "C4", "D4", "E4", "F4", "G4", "A4", "B4", "C5",
                    "D5", "E5", "F5", "G5", "A5", "B5", "C6", "D6", "E6", "F6", "G6", "A6", "B6",
                    "C7"};
    private String[] blackKeysSoundName = {"C#2", "D#2", "", "F#2", "G#2", "A#2", "", "C#3", "D#3",
                    "", "F#3", "G#3", "A#3", "", "C#4", "D#4", "", "F#4", "G#4", "A#4", "", "C#5",
                    "D#5", "", "F#5", "G#5", "A#5", "", "C#6", "D#6", "", "F#6", "G#6", "A#6"};

    HashMap<String, Key> Sites = new HashMap<String, Key>();
    AutoMusic autoMusic;
    Back back = new Back();
    String type;

    public Piano(String type)
    {
        super(1600, 800, 1);
        this.type = type;
        makeKeys(); // ����makeKeys()��������Ϸ���������ϻ������е��ټ�
        addObject(back, 40, 30);
        if (type != "free")
        {
            autoMusic = new AutoMusic(type);
            autoMusic.read(Sites);
        }
    }

    private void makeKeys()
    {
        for (int i = 0; i < 36; i++)
        {
            Key key = new Key("white", i / 7 + 2, whiteKeyBoardName[i], whiteKeysSoundName[i]);
            Sites.put(whiteKeysSoundName[i], key);
            addObject(key, 118 + i * 39, 650);
        }
        for (int i = 0; i < 35; i++)
        {
            if (i % 7 == 2 || i % 7 == 6)
                continue;
            Key key = new Key("black", i / 7 + 2, null, blackKeysSoundName[i]);
            Sites.put(blackKeysSoundName[i], key);
            addObject(key, 138 + i * 39, 594);
        }
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(back))
        {
            Greenfoot.setWorld(new MainWorld());
            if (type != "free")
            {
                autoMusic.clearTimer();
            }
        }
    }

    public void stopped()
    {
        if (type != "free")
        {
            autoMusic.clearTimer();
        }
    }
}
