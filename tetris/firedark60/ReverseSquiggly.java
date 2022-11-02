import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * The Reverse Squiggly
 * 
 * @Brian Huang
 *
 */
public class ReverseSquiggly  extends Shapes
{
    /**
     * NOTE: Look at L Shape class for clues and commenting. 
     * This class is shaped and is a close copy to L Shape class
     * So commenting is the same in this class to the L Shape.
     * 
     */
    public void rotate () {
        if (getRotation() == 0 ) {
            List checkIntersection = getObjectsAtOffset (8,16,null);
            checkIntersection.remove (this);
            List checkIntersection1 = getObjectsAtOffset (24,16,null);
            checkIntersection1.remove (this);
            List checkIntersection2 = getObjectsAtOffset (-16,-8,null);
            checkIntersection2.remove (this);
            List checkIntersection3 = getObjectsAtOffset (-24,0,null);
            checkIntersection3.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection1.isEmpty ()){
                setRotation (getRotation()+90);
                setLocation (getX () +8,getY () +8);
            }

            else if (checkIntersection2.isEmpty ()  && checkIntersection3.isEmpty () ) {
                setRotation (getRotation()+90);
                setLocation (getX () -8,getY () +8);
            }
        }
        else if (getRotation() == 90) {
            List checkIntersection = getObjectsAtOffset (0,-24,null);
            checkIntersection.remove (this);
            List checkIntersection1 = getObjectsAtOffset (-16,8,null);
            checkIntersection1.remove (this);
            List checkIntersection2 = getObjectsAtOffset (-16,-24,null);
            checkIntersection2.remove (this);
            List checkIntersection3 = getObjectsAtOffset (0,-40,null);
            checkIntersection3.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection1.isEmpty ()){
                setRotation (0);
                setLocation (getX () -8,getY () -8);
            }

            else if (checkIntersection.isEmpty () && checkIntersection2.isEmpty ()  && checkIntersection3.isEmpty () ) {
                setRotation (0);
                setLocation (getX () -8,getY () -24);
            }

        }
    }

    public boolean checkLeft () {
        if (getRotation () == 0) {
            List checkIntersection = getObjectsAtOffset (-24,0,null);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (-24,16,null);
            checkIntersection2.remove (this);
            List checkIntersection3 = getObjectsAtOffset (-8,-16,null);
            checkIntersection3.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () && checkIntersection3.isEmpty ()){
                return true;
            }
        }
        else {
            List checkIntersection = getObjectsAtOffset (-32,-8,null);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (-16,8,null);
            checkIntersection2.remove (this);

            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () ){
                return true;
            }
        }

        return false;

    }

    public boolean checkRight () {
        if (getRotation () == 0) {
            List checkIntersection = getObjectsAtOffset (24,0,null);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (24,-16,null);
            checkIntersection2.remove (this);
            List checkIntersection3 = getObjectsAtOffset (8,16,null);
            checkIntersection3.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () && checkIntersection3.isEmpty ()){
                return true;
            }
        }
        else {
            List checkIntersection = getObjectsAtOffset (16,-8,null);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (32,8,null);
            checkIntersection2.remove (this);

            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () ){
                return true;
            }
        }
        return false;
    }

    public boolean checkDown () {
        if (getRotation () == 0){
            List checkIntersection = getObjectsAtOffset (-8,32,null);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (8,16,null);
            checkIntersection2.remove (this);

            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () ){
                return true;

            }
        }
        else {
            List checkIntersection = getObjectsAtOffset (0,24,null);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (16,24,null);
            checkIntersection2.remove (this);
            List checkIntersection3 = getObjectsAtOffset (-16,8,null);
            checkIntersection3.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () && checkIntersection3.isEmpty ()){
                return true;
            }
        }
        return false;
    }

    public int [] registerShape () {
        if (getRotation () == 0) {
            int x = ((getX () - 248)/16);
            int y = ((getY () - 116)/16);
            TetrisWorld.tetrisArray [x+1] [y-1] = 5;
            TetrisWorld.tetrisArray [x] [y] = 5;
            TetrisWorld.tetrisArray [x] [y+1] = 5;
            TetrisWorld.tetrisArray [x+1] [y] = 5;
            getWorld().removeObject (this);
            int[] coords = {x,y,x+1,y-1,x,y+1,x+1,y};

            return coords;

        }
        else {
            int x = ((getX () - 248)/16);
            int y = ((getY () - 116)/16);
            TetrisWorld.tetrisArray [x] [y] = 5;
            TetrisWorld.tetrisArray [x+1] [y+1] = 5;
            TetrisWorld.tetrisArray [x-1] [y] = 5;
            TetrisWorld.tetrisArray [x] [y+1] = 5;
            getWorld().removeObject (this);

            int[] coords = {x,y,x+1,y+1,x-1,y,x,y+1};

            return coords;
        }
    }
}
