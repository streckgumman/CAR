package Model;

import java.awt.*;
import java.security.InvalidParameterException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * A freightliner class for a lastbil that can load cars.
 */
public class Freightliner extends Cars implements Loadable {
    private double tiltDeg;
    private final int maxCars = 3;
    private final Cargo c = new Cargo(this, maxCars);
   //Solve issue with loading of in the other order from this class

    /**
     * A constructor for the FreightLiner.
     */
    Freightliner() {
        super(2, 60, Color.blue, "Model.Freightliner");
        this.tiltDeg = 0;
    }
    /**
     * A method that makes the cars loaded on our ship travel along with it.
     */
    @Override
    public void move(){
        super.move();
        for (Cars c : c.getLoaded()){
            c.setSamePosition(this);
        }
    }
    /**
     * A method that tilts the ramp up.
     */

    public void tiltUp() {
        this.tiltDeg = 0;
    }
    /**
     * A method that tilts the ramp down
     */

    public void tiltDown() {
        this.tiltDeg = 70;
    }



    public double getTiltDeg() {
        return tiltDeg;
    }
    /**
     * A start engine that only works when the ramp is up.
     */
    @Override
    public void startEngine() {
        this.tiltDeg = 0;
        super.startEngine();
    }
    /**
     * A method that sets the ramp up and uses gas.
     * @param amount Indicates how much the car gases from a scale from 0 to 1.
     * @throws InvalidParameterException
     */
    @Override //Get these ones better some way code reuse
    public void gas(double amount) throws InvalidParameterException {
        this.tiltDeg = 0;
        super.gas(amount);
    }

    public double speedFactor(){
        return getEnginePower();
    }

    /**
     * A method that loads the cars according to the "last in, first out" - principle.
     * @param car
     */
    public void loadCar(Cars car){
        c.loadCar(car);
    }

    /**
     * A method that unloads the cars according to the "last in, first out" - principle.
     */
    public void unloadCar(){
        c.unloadCar();
    }
    public int getAmountLoaded(){
        return c.getLoadedAmount();
    }
}
