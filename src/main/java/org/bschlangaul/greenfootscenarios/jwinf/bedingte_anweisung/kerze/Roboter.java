package org.bschlangaul.greenfootscenarios.jwinf.bedingte_anweisung.kerze;
import greenfoot.Actor;

import java.util.LinkedList;
import java.util.Queue;

public class Roboter extends Actor
{
    Queue<String> queue;

    public Roboter ()
    {
        queue = new LinkedList<String>();
    }

    public void gehe(String richtung)
    {
        queue.add("gehe-" + richtung);
    }

    public void zündeAn()
    {
        queue.add("zünde-an");
    }

    public void act()
    {
        if (queue.peek() == null)
        {
            return;
        }
        String aktion = queue.remove();
        switch(aktion)
        {
            case "gehe-links":
                setRotation(180);
                move(1);
                break;

            case "gehe-rechts":
                setRotation(0);
                move(1);
                break;

            case "gehe-oben":
                setRotation(270);
                move(1);
                break;

            case "gehe-unten":
                setRotation(90);
                move(1);
                break;

            case "zünde-an":
                getWorld().addObject(new Flamme(), getX(), getY());
                break;
        }
    }
}
