package Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
//supposed to add cars here and return and access list from here
public abstract class World {
    private final static List<Cars> cars = new ArrayList<>();

    public static void addCar(Cars car){
        if (cars.size() < 10){
            cars.add(car);
        }
    }

    public static void removeCar(){ //removes last added vehicle
        if (cars.size() > 0){
            cars.remove(cars.size() - 1);
        }
    }


    /*void refreshPoints(){
        for (Cars c :cars){ //if outside range, turn around and set engine to starting speed
            getCarImage(c);
            if (cars.size() != positions.size()){
                positions.add(new Model.PicPoint(new Point(0,0),getCarImage(c)));

            }
        }
    }

    void checkValidPosition(){
        for (Cars c :cars) { //if outside range, turn around and set engine to starting speed
            if (hitsWall(c)) {
                c.turnLeft();
                c.turnLeft();
                c.startEngine();
            }
        }
    }
    boolean hitsWall(Cars c){
        if ((c.getPosX() > 680 && (c.getDeg() % 360 == 0)) || (c.getPosX() < 0 && (c.getDeg() % 360 == 180))){
            return true;
        }
        else{
            return false;
        }
    }*/
}
