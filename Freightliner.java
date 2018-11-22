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

    public Freightliner() {
        super(2, 60, Color.blue, "Freightliner");
        this.maxCars = 3;
        this.tiltDeg = 0;
    }

    @Override
    public void move(){
        super.move();
        for (Cars c : tmp){
            c.setSamePosition(this);
        }
    }

    @Override
    public void tiltUp() {
        this.tiltDeg = 0;
    }

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

    @Override
    void startEngine() {
        this.tiltDeg = 0;
        super.startEngine();
    }

    @Override //Get these ones better some way code reuse
    void gas(double amount) throws InvalidParameterException {
        this.tiltDeg = 0;
        super.gas(amount);
    }

    public double speedFactor(){
        return getEnginePower();
    }

    public void loadCar(Cars c){
        if (tmp.size() < maxCars && getTiltDeg() == 70 && !tmp.contains(c) && this != c){
            tmp.push(c);
            c.setSamePosition(this);
        }
    }

    public void unloadCar(){
        if(getTiltDeg() == 70 && !tmp.isEmpty()){
            Cars c = tmp.pop();
            c.setBeside(this);
        }
    }
}
