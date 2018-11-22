import java.awt.*;
import java.security.InvalidParameterException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * A class that represents a Cargoship that carries cars.
 * Could create an abstract boat class in the future if need be.
 */
public class Cargoship extends Vehicle implements Loadable,Movable {
    private final int maxCars;
    private double tiltDeg;
    private final List<Cars> loaded = new ArrayList<Cars>();

    /**
     * constructor for the ship.
     */
    public Cargoship(){
        super(30, Color.GRAY, "CargoShip");
        this.maxCars = 10;
        this.tiltDeg = 0;

    }

    /**
     * A method that makes the cars loaded on our ship travel along with it.
     */
    @Override
    public void move(){
        super.move();
        for (Cars c : loaded){
            c.setSamePosition(this);
        }
    }

    /**
     * A method that tilts the ramp down
     */
    @Override
    public void tiltDown() {
        this.tiltDeg = 70;
    }
    /**
     * A method that tilts the ramp up.
     */
    @Override
    public void tiltUp() {
        this.tiltDeg = 0;
    }


    @Override
    public double speedFactor() {
        return 0;
    }

    /**
     * A gas that sets the ramp up.
     * @param amount Indicates how much the car gases from a scale from 0 to 1.
     * @throws InvalidParameterException
     */
    @Override
    void gas(double amount) throws InvalidParameterException {
        this.tiltDeg = 0;
        super.gas(amount);
    }

    /**
     * A start engine that sets the ramp up.
     */
    @Override
    void startEngine() {
        this.tiltDeg = 0;
        super.startEngine();
    }

    /**
     * returns a list with the cars the ship carries.
     * @return
     */
    public int getLoaded() {
        return loaded.size();
    }

    public double getTiltDeg() {
        return tiltDeg;
    }


    /**
     * A method that loads the cars according to the "First in, first out"-principle.
     * @param car
     */
    public void loadCar(Cars car){
        if (loaded.size() < maxCars && getTiltDeg() == 70 && !loaded.contains(car) && car.distanceTo(this) < 20 && !loaded.contains(car)){//add distance between car and carrier
            loaded.add(car);
            car.setSamePosition(this);
        }
    }

    /**
     * A method that unloads the car according to the "First in, first out"-principle.
     */
    public void unloadCar(){
        if (loaded.size() > 0 && getTiltDeg() == 70){ //set coordinates to carriers coordinates, private setters obstructing
            Cars car = loaded.remove(0);
            car.setBeside(this);
        }
    }

}
