import java.awt.*;
import java.security.InvalidParameterException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * A class that represents a Cargoship that carries cars.
 */
public class Cargoship extends Vehicle implements Loadable,Movable { //not working right now
    Freightliner loader = new Freightliner();
    private final int maxCars;
    private double tiltDeg;
    private final List<Cars> loaded = new ArrayList<Cars>();

    public Cargoship(){
        super(30, Color.GRAY, "CargoShip");
        this.maxCars = 10;
        this.tiltDeg = 0;

    }

    @Override
    public void move(){
        super.move();
        for (Cars c : loaded){
            c.setSamePosition(this);
        }
    }

    @Override
    public void tiltDown() {
        this.tiltDeg = 70;
    }

    @Override
    public void tiltUp() {
        this.tiltDeg = 0;
    }


    @Override
    public double speedFactor() {
        return 0;
    }


    @Override
    void gas(double amount) throws InvalidParameterException {
        this.tiltDeg = 0;
        super.gas(amount);
    }

    @Override
    void startEngine() {
        this.tiltDeg = 0;
        super.startEngine();
    }

    public int getLoaded() {
        return loaded.size();
    }

    public double getTiltDeg() {
        return tiltDeg;
    }


    /**
     * First in, first out
     * @param car
     */
    public void loadCar(Cars car){
        if (loaded.size() < maxCars && getTiltDeg() == 70 && !loaded.contains(car) && car.distanceTo(this) < 20 && !loaded.contains(car)){//add distance between car and carrier
            loaded.add(car);
            car.setSamePosition(this);
        }
    }

    public void unloadCar(){
        if (loaded.size() > 0 && getTiltDeg() == 70){ //set coordinates to carriers coordinates, private setters obstructing
            Cars car = loaded.remove(0);
            car.setBeside(this);
        }
    }

}
