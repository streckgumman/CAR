package Model;

/**
 * An interface for all objects that have something to load.
 */
public interface Loadable {
    void unloadCar();
    void loadCar(Car c);
    double getTiltDeg();
}
