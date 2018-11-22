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
    private final int maxCars;
    private final Deque<Cars> tmp = new ArrayDeque<>(); //Solve issue with loading of in the other order from this class

    /**
     * A constructor for the FreightLiner.
     */
    public Freightliner() {
        super(2, 60, Color.blue, "Freightliner");
        this.maxCars = 3;
        this.tiltDeg = 0;
    }
    /**
     * A method that makes the cars loaded on our ship travel along with it.
     */
    @Override
    public void move(){
        super.move();
        for (Cars c : tmp){
            c.setSamePosition(this);
        }
    }
    /**
     * A method that tilts the ramp up.
     */
    @Override
    public void tiltUp() {
        this.tiltDeg = 0;
    }
    /**
     * A method that tilts the ramp down
     */
    @Override
    public void tiltDown() {
        this.tiltDeg = 70;
    }



    public double getTiltDeg() {
        return tiltDeg;
    }

    public int getAmountLoaded() {
        return tmp.size();
    }
    /**
     * A start engine that only works when the ramp is up.
     */
    @Override
    void startEngine() {
        this.tiltDeg = 0;
        super.startEngine();
    }
    /**
     * A method that sets the ramp up and uses gas.
     * @param amount Indicates how much the car gases from a scale from 0 to 1.
     * @throws InvalidParameterException
     */
    @Override //Get these ones better some way code reuse
    void gas(double amount) throws InvalidParameterException {
        this.tiltDeg = 0;
        super.gas(amount);
    }

    public double speedFactor(){
        return getEnginePower();
    }

    /**
     * A method that loads the cars according to the "last in, first out" - principle.
     * @param c
     */
    public void loadCar(Cars c){
        if (tmp.size() < maxCars && getTiltDeg() == 70 && c.distanceTo(this) < 20 && !tmp.contains(c) && this != c){
            tmp.push(c);
            c.setSamePosition(this);
        }
    }

    /**
     * A method that unloads the cars according to the "last in, first out" - principle.
     */
    public void unloadCar(){
        if(getTiltDeg() == 70 && !tmp.isEmpty()){
            Cars c = tmp.pop();
            c.setBeside(this);
        }
    }
}
