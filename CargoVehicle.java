import java.awt.*;
import java.security.InvalidParameterException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public abstract class CargoVehicle extends Vehicle implements Loadable{
    protected final int maxCars;
    private double tiltDeg;
    protected final List<Cars> loaded = new ArrayList<Cars>();
    private final Deque<Cars> tmp = new ArrayDeque<>(); //Solve issue with loading of in the other order from this class
    /**
     * Constructor for a Vehicle.
     *
     * @param enginePower Indicates the power of the engine of the car.
     * @param color       Indicates the color of the car.
     * @param modelName   Indicates the name of a certain car model.
     */
    public CargoVehicle(double enginePower, Color color, String modelName, int maxCars) {
        super(enginePower, color, modelName);
        this.maxCars = maxCars;
        this.tiltDeg = 0;
    }

    @Override
    public void move(){
        super.move();
        for (Cars c : loaded){
            c.setSamePosition(this);
        }
        for (Cars c : tmp){
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





}
