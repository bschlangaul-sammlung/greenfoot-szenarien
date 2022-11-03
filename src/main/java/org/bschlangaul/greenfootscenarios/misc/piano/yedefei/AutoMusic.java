package org.bschlangaul.greenfootscenarios.misc.piano.yedefei;

import greenfoot.*;
import java.io.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Write a description of class dddd here.
 */
public class AutoMusic extends Actor
{
    /**
     * Act - do whatever the dddd wants to do. This method is called whenever the 'Act' or 'Run'
     * button gets pressed in the environment.
     */
    private ArrayList<Timer> firstTimerArr = new ArrayList<Timer>();
    private ArrayList<Timer> secondTimerArr = new ArrayList<Timer>();
    private ArrayList<Timer> thirdTimerArr = new ArrayList<Timer>();
    private String MusicName;

    public AutoMusic(String MusicName)
    {
        this.MusicName = MusicName;
    }

    public void read(HashMap<String, Key> Sites)
    {

        try
        {
            BufferedReader in =
                            new BufferedReader(new FileReader("musiclist/" + MusicName + ".txt"));
            String str;
            while ((str = in.readLine()) != null)
            {
                String[] strs = str.split("\t");
                final String name = strs[0];
                final int time = Integer.valueOf(strs[1]);
                final int duration = Integer.valueOf(strs[2]);

                Key key = Sites.get(strs[0]);
                if (key != null)
                {
                    final Key finalkey = key;
                    Timer firstTimer = new Timer();
                    firstTimer.schedule(new TimerTask() {
                        public void run()
                        {
                            finalkey.autoPlay("press");
                            Timer secondTimer = new Timer();
                            secondTimer.schedule(new TimerTask() {
                                public void run()
                                {
                                    finalkey.autoPlay("uplift");
                                }
                            }, duration);
                            // secondTimerArr.add(secondTimer);
                        }
                    }, time);
                    firstTimerArr.add(firstTimer);
                }
                else
                {
                    Timer thirdTimer = new Timer();
                    thirdTimer.schedule(new TimerTask() {
                        public void run()
                        {
                            Greenfoot.playSound("" + name.charAt(name.length() - 1) + "/" + name
                                            + ".mp3");
                        }
                    }, time);
                    thirdTimerArr.add(thirdTimer);
                }
            }
        } catch (IOException e)
        {
            System.out.println(e);
        }
    }

    public void clearTimer()
    {
        for (int i = 0; i < firstTimerArr.size(); i++)
        {
            firstTimerArr.get(i).cancel();
        }
        for (int i = 0; i < secondTimerArr.size(); i++)
        {
            secondTimerArr.get(i).cancel();
        }
        for (int i = 0; i < thirdTimerArr.size(); i++)
        {
            thirdTimerArr.get(i).cancel();
        }
    }
}
