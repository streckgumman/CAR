import java.awt.*;
import java.security.InvalidParameterException;

/**
 * An abstract superclass for all different kinds of cars.
 * Shared methods and functions for all cars are included.
 * Extends the abstract class Vehicle.
 * Implements the interface Movable and imports java.awt and java.lang.Math.
 */
public abstract class Cars extends Vehicle implements Movable {
    /**
     * A car has all things a vehicle has, and also doors.
     */
    private final int nrDoors; // Number of doors on the car

    /**
     * Constructor for a car.
     *
     * @param nrDoors     Indicates the number of doors on the car.
     * @param enginePower Indicates the power of the engine of the car.
     * @param color       Indicates the color of the car.
     * @param modelName   Indicates the name of a certain car model.
     */
    public Cars(int nrDoors, double enginePower, Color color, String modelName) {
        super( enginePower, color, modelName);
        this.nrDoors = nrDoors;
    }


}
