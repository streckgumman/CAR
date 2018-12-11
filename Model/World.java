package Model;

import java.util.ArrayList;
import java.util.List;
//supposed to add CARS here and return and access list from here
public abstract class World {
    private final static List<Car> CARS = new ArrayList<>();

    public static void addCar(Car car){
        if (CARS.size() < 10){
            CARS.add(car);
        }
    }

    public static void removeCar(){ //removes last added vehicle
        if (CARS.size() > 0){
            CARS.remove(CARS.size() - 1);
        }
    }


    /*void refreshPoints(){
        for (Car c :CARS){ //if outside range, turn around and set engine to starting speed
            getCarImage(c);
            if (CARS.size() != positions.size()){
                positions.add(new Model.PicPoint(new Point(0,0),getCarImage(c)));

            }
        }
    }

    void checkValidPosition(){
        for (Car c :CARS) { //if outside range, turn around and set engine to starting speed
            if (hitsWall(c)) {
                c.turnLeft();
                c.turnLeft();
                c.startEngine();
            }
        }
    }
    boolean hitsWall(Car c){
        if ((c.getPosX() > 680 && (c.getDeg() % 360 == 0)) || (c.getPosX() < 0 && (c.getDeg() % 360 == 180))){
            return true;
        }
        else{
            return false;
        }
    }*/
}
