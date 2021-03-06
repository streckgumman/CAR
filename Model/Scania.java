package Model;

import java.awt.*;
import java.security.InvalidParameterException;

/**
 * A class for a lastbil.
 * Implements the interface Model.Loadable.
 * Extends Model.Cars.
 */
public class Scania extends Car implements Loadable {
    private double tiltDeg;

    Scania() {
        super(2, 90, Color.black, "Scania");
        this.tiltDeg = 0;
    }

    /**
     * A method that tilts the ramp down.
     */
    public void tiltDown(){
        if (getCurrentSpeed() == 0){
            this.tiltDeg = tiltDeg + 1;
            if (this.tiltDeg > 70) {
                this.tiltDeg = 70;
            }
        }
    }

    /**
     * A method that tilts the ramp up.
     */
    public void tiltUp() {
        if (getCurrentSpeed() == 0){
            this.tiltDeg = tiltDeg - 1;
            if (this.tiltDeg < 0) {
                this.tiltDeg = 0;
            }
        }
    }

    public double getTiltDeg() {
        return tiltDeg;
    }

    /**
     * A method that starts the engine and sets the ramp up.
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
    @Override
    public void gas(double amount) throws InvalidParameterException {
        this.tiltDeg = 0;
        super.gas(amount);
    }

    @Override
    public double speedFactor() {
        return getEnginePower()/100;
    }

    @Override
    public void unloadCar() {
    }

    @Override
    public void loadCar(Car c) {
    }

}
