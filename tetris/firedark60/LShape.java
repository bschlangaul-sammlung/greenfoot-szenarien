import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * The L Shape Block of the game
 * 
 * @Brian Huang
 * @June 12th 2011
 */
public class LShape extends Shapes
{
    //Checks the rotation of the shape
    public void rotate () {
        //When the shape is 0 degree rotation
        if (getRotation() == 0) { 
            //Checks coords if possible to rotate
            List checkIntersection = getObjectsAtOffset (24,0,null);
            checkIntersection.remove (this);
            if (checkIntersection.isEmpty ()) {
                setRotation (getRotation()+90);
                setLocation (getX () +8,getY () +8);
            }
            //bounces the shape so it is possible to rotate
            else {
                List checkIntersection1 = getObjectsAtOffset (-24,0,null);
                checkIntersection1.remove (this);
                if (checkIntersection1.isEmpty ()){
                    setLocation (getX () -16,getY ());
                    setRotation (getRotation()+90);
                    setLocation (getX () +8,getY () +8);
                }

            }

            
        }
        //When it is 90 degree rotation
        else if (getRotation() == 90) {
            List checkIntersection = getObjectsAtOffset (0,-24,null);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (-16,-24,null);
            checkIntersection2.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () ){
                setRotation (getRotation()+90);
                setLocation (getX () -8,getY () -8);

            }

        }
        //When 180 degree rotation
        else if (getRotation() == 180) {
            List checkIntersection = getObjectsAtOffset (-24,0,null);
            checkIntersection.remove (this);
            if (checkIntersection.isEmpty ()) {
                setRotation (getRotation()+90);
                setLocation (getX () -8,getY () -8);
            }
            else {
                //bounces the shape so it is possible to rotate
                List checkIntersection1 = getObjectsAtOffset (24,0,null);
                checkIntersection.remove (this);
                List checkIntersection2 = getObjectsAtOffset (24,-16,null);
                checkIntersection.remove (this);
                if (checkIntersection1.isEmpty () && checkIntersection2.isEmpty ()) {
                    setLocation (getX () +16,getY ());
                    setRotation (getRotation()+90);
                    setLocation (getX () -8,getY () -8);
                }
                

            }

            
        }
        //When 270 degrees rotation
        else {
            List checkIntersection = getObjectsAtOffset (0,24,null);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (16,24,null);
            checkIntersection2.remove (this);
            List checkIntersection3 = getObjectsAtOffset (0,-8,null);
            checkIntersection3.remove (this);

            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () ){
                setRotation (0);
                setLocation (getX () +8,getY () +8);

            }
            else if (checkIntersection3.isEmpty ()) 
            {
                setRotation (0);
                setLocation (getX () ,getY ()-16);
                setLocation (getX () +8,getY () +8);
            }

            
        }
    }

    //Check if it is possible to move left, structure is the same as rotate
    public boolean checkLeft () {
        if (getRotation () == 0) {
            List checkIntersection = getObjectsAtOffset (-24,0,null);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (-24,-16,null);
            checkIntersection2.remove (this);
            List checkIntersection3 = getObjectsAtOffset (-24,16,null);
            checkIntersection3.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () && checkIntersection3.isEmpty ()){
                return true;
            }
        }

        else if (getRotation () == 90 ) {
            List checkIntersection = getObjectsAtOffset (-32,-8,null);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (-32,8,null);
            checkIntersection2.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () ){
                return true;

            }
        }
        else if (getRotation () == 180) {
            List checkIntersection = getObjectsAtOffset (-24,-16,null);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (-8,0,null);
            checkIntersection2.remove (this);
            List checkIntersection3 = getObjectsAtOffset (-8,16,null);
            checkIntersection3.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () && checkIntersection3.isEmpty ()){
                return true;
            }
        }
        else {
            List checkIntersection = getObjectsAtOffset (-32,8,null);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (0,-8,null);
            checkIntersection2.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () ){
                return true;

            }
        }

        return false;

    }

    //Check if it is possible to move right, structure is the same as rotate
    public boolean checkRight () {
        if (getRotation () == 0) {
            List checkIntersection = getObjectsAtOffset (8,0,null);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (8,-16,null);
            checkIntersection2.remove (this);
            List checkIntersection3 = getObjectsAtOffset (24,16,null);
            checkIntersection3.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () && checkIntersection3.isEmpty ()){
                return true;
            }
        }

        else if (getRotation () == 90 ) {
            List checkIntersection = getObjectsAtOffset (32,-8,null);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (0,8,null);
            checkIntersection2.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () ){
                return true;

            }
        }
        else if (getRotation () == 180) {
            List checkIntersection = getObjectsAtOffset (24,-16,null);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (24,0,null);
            checkIntersection2.remove (this);
            List checkIntersection3 = getObjectsAtOffset (24,16,null);
            checkIntersection3.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () && checkIntersection3.isEmpty ()){
                return true;
            }
        }
        else {
            List checkIntersection = getObjectsAtOffset (32,8,null);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (32,-8,null);
            checkIntersection2.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () ){
                return true;

            }
        }
        return false;
    }

    //Check if it is possible to move down, structure is the same as rotate
    public boolean checkDown () {
        if (getRotation () == 0){
            List checkIntersection1 = getObjectsAtOffset (8,24,null);
            checkIntersection1.remove (this);
            List checkIntersection2 = getObjectsAtOffset (-8,24,null);
            checkIntersection2.remove (this);
            if (checkIntersection1.isEmpty () &&checkIntersection2.isEmpty ()){
                return true;

            }
        }
        else if (getRotation () == 90){
            List checkIntersection = getObjectsAtOffset (0,8,null);
            List checkIntersection2 = getObjectsAtOffset (16,8,null);
            List checkIntersection3 = getObjectsAtOffset (-16,24,null);
            checkIntersection.remove (this);
            checkIntersection2.remove (this);
            checkIntersection3.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () && checkIntersection3.isEmpty ()){
                return true;

            }
        }
        else if (getRotation () == 180){
            List checkIntersection1 = getObjectsAtOffset (8,32,null);
            checkIntersection1.remove (this);
            List checkIntersection2 = getObjectsAtOffset (-8,0,null);
            checkIntersection2.remove (this);
            if (checkIntersection1.isEmpty () &&checkIntersection2.isEmpty ()){
                return true;

            }
        }
        else {
            List checkIntersection = getObjectsAtOffset (0,24,null);
            List checkIntersection2 = getObjectsAtOffset (-16,24,null);
            List checkIntersection3 = getObjectsAtOffset (16,24,null);
            checkIntersection.remove (this);
            checkIntersection2.remove (this);
            checkIntersection3.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () && checkIntersection3.isEmpty ()){
                return true;

            }
        }
        return false;
    }

    //Registers the shape into the array and sends back coords so it can be drawn into the world
    public int [] registerShape () {
        if (getRotation () == 0) {
            int x = ((getX () - 248)/16);
            int y = ((getY () - 116)/16);
            TetrisWorld.tetrisArray [x] [y] = 1;
            TetrisWorld.tetrisArray [x] [y+1] = 1;
            TetrisWorld.tetrisArray [x] [y-1] = 1;
            TetrisWorld.tetrisArray [x+1] [y+1] = 1;
             getWorld().removeObject (this);
            int[] coords = {x,y,x,y+1,x,y-1,x+1,y+1};
                
                return coords;
           

        }
        else if (getRotation () == 90) {
            int x = ((getX () - 248)/16);
            int y = ((getY () - 116)/16);
            TetrisWorld.tetrisArray [x] [y] = 1;
            TetrisWorld.tetrisArray [x+1] [y] = 1;
            TetrisWorld.tetrisArray [x-1] [y] = 1;
            TetrisWorld.tetrisArray [x-1] [y+1] = 1;
             getWorld().removeObject (this);
            int[] coords = {x,y,x+1,y,x-1,y,x-1,y+1};
                
                return coords;


        }
        else if (getRotation () == 180) {
            int x = ((getX () - 248)/16);
            int y = ((getY () - 116)/16);
            TetrisWorld.tetrisArray [x+1] [y] = 1;
            TetrisWorld.tetrisArray [x+1] [y+1] = 1;
            TetrisWorld.tetrisArray [x+1] [y-1] = 1;
            TetrisWorld.tetrisArray [x] [y-1] = 1;
             getWorld().removeObject (this);
            int[] coords = {x+1,y,x+1,y+1,x+1,y-1,x,y-1};
                
                return coords;


        }
        else {
            int x = ((getX () - 248)/16);
            int y = ((getY () - 116)/16);
            TetrisWorld.tetrisArray [x] [y+1] = 1;
            TetrisWorld.tetrisArray [x+1] [y+1] = 1;
            TetrisWorld.tetrisArray [x-1] [y+1] = 1;
            TetrisWorld.tetrisArray [x+1] [y] = 1;
             getWorld().removeObject (this);
            int[] coords = {x,y+1,x+1,y+1,x-1,y+1,x+1,y};
                
                return coords;

        }
    }
}
