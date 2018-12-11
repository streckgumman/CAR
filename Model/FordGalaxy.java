package Model;

import java.awt.*;

/**
 * An extra car class for Ford Galaxy just because.
 */
public class FordGalaxy extends Car {


    FordGalaxy() {
        super( 4, 80, Color.GRAY, "Ford Galaxy");

    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }
}
