package org.bschlangaul.greenfootscenarios.jwinf.bedingte_anweisung.kerze;
import greenfoot.World;

public class Kerze
{
    public Kerze(int x, World world)
    {
        for (int y = 5; y > 2; y--)
        {
            world.addObject(new Kerzenbaustein(), x, y);
        }
        world.addObject(new Docht(), x, 2);
    }
}
