package Model;

import Model.Cars;

/**
 * An interface for all objects that have something to load.
 */
public interface Loadable {
    void unloadCar();
    void loadCar(Cars c);
    double getTiltDeg();
}
