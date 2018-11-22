import java.awt.*;
import java.security.InvalidParameterException;

/**
 * A class for a lastbil.
 * Implements the interface Loadable.
 * Extends Cars.
 */
public class Scania extends Cars implements Loadable{
    private double tiltDeg;

    public Scania() {
        super(2, 90, Color.black, "Scania");
        this.tiltDeg = 0;
    }

    public void tiltDown(){
        if (getCurrentSpeed() == 0){
            this.tiltDeg = tiltDeg + 1;
            if (this.tiltDeg > 70) {
                this.tiltDeg = 70;
            }
        }
    }

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

    @Override
    void startEngine() {
        this.tiltDeg = 0;
        super.startEngine();
    }

    @Override
    void gas(double amount) throws InvalidParameterException {
        this.tiltDeg = 0;
        super.gas(amount);
    }

    @Override
    public double speedFactor() {
        return getEnginePower();
    }
}
