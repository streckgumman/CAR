package Model;

import java.awt.*;
import java.security.InvalidParameterException;

/**
 * A class that represents a Model.Cargoship that carries cars.
 * Could create an abstract boat class in the future if need be.
 */
public class Cargoship extends Vehicle implements Loadable {
    private final int maxCars = 10;
    private final Cargo c = new Cargo(this, maxCars);
    private double tiltDeg;
    /**
     * constructor for the ship.
     */
    Cargoship(){
        super(30, Color.GRAY, "CargoShip");
        this.tiltDeg = 0;

    }

    /**
     * A method that makes the cars loaded on our ship travel along with it.
     */
    @Override
    public void move(){
        super.move();
        for (Car c : c.getLoaded()){
            c.setSamePosition(this);
        }
    }

    /**
     * A method that tilts the ramp down
     */

    public void tiltDown() {
        this.tiltDeg = 70;
    }
    /**
     * A method that tilts the ramp up.
     */

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
    public void gas(double amount) throws InvalidParameterException {
        this.tiltDeg = 0;
        super.gas(amount);
    }

    /**
     * A start engine that sets the ramp up.
     */
    @Override
    public void startEngine() {
        this.tiltDeg = 0;
        super.startEngine();
    }

    /**
     * returns a list with the cars the ship carries.
     * @return
     */
    public int getLoaded() {
        return c.getLoadedAmount();
    }

    public double getTiltDeg() {
        return tiltDeg;
    }


    /**
     * A method that loads the cars according to the "First in, first out"-principle.
     * @param car
     */
    public void loadCar(Car car){
        c.loadCar(car);
    }

    /**
     * A method that unloads the car according to the "First in, first out"-principle.
     */
    public void unloadCar(){
        c.unloadCar();
    }

}
