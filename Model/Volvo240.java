package Model;

import java.awt.*;

/**
 * Specific car model, Volvo240. Subclass to Model.Car Imports java.awt.
 */

public class Volvo240 extends Car {
    /**
     * A static value that directly affects the speedFactor of this car model.
     */
    private final static double trimFactor = 1.25;

    /**
     * Constructor for the Volvo240.
     */
    Volvo240() {
        super(4, 100, Color.black, "Volvo240");
        this.stopEngine();
    }

    /**
     * Sets speedFactor for this certain model of car.
     * @return speedFactor for this certain model of car.
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

}

