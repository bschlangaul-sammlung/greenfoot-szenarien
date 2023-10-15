package org.bschlangaul.greenfootscenarios.jwinf.bedingte_anweisung.kerze;
import greenfoot.World;

public class MyWorld extends World
{
    public MyWorld()
    {
        super(9, 6, 60);

        for (int x = 0; x < 9; x++)
        {
            for (int y = 0; y < 6; y++)
            {
                addObject(new Kachel(), x, y);
            }
        }

        new Kerze(4, this);
        addObject(new Robert(), 1, 5);
    }
}
