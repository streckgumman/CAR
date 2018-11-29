import java.util.ArrayList;
import java.util.List;

public class Cargo implements Loadable {
    private final Loadable parent;
    private final int maxCars;
    private final List<Cars> loaded = new ArrayList<Cars>();

    Cargo(Loadable parent, int maxCars){
        this.parent = parent;
        this.maxCars = maxCars;
    }

    public Loadable getParent() {
        return parent;
    }

    public int getMaxCars() {
        return maxCars;
    }

    public List<Cars> getLoaded() {
        return loaded;
    }
    public int getLoadedAmount() {
        return loaded.size();
    }
    /**
     * A method that loads the cars according to the "First in, first out"-principle or 2first in last out depending on the object.
     * @param car
     */

    public void loadCar(Cars car){
        if (loaded.size() < maxCars && parent.getTiltDeg() == 70 && !loaded.contains(car) && car.distanceTo((Vehicle)parent) < 20 && car != parent){//add distance between car and carrier
            loaded.add(car);
            car.setSamePosition((Vehicle)parent);
        }
    }

    /**
     * A method that unloads the car according to the "First in, first out"-principle or "first in last out" depending on the vehicle.
     */
    public void unloadCar(){
        if (loaded.size() > 0 && parent.getTiltDeg() == 70){ //set coordinates to carriers coordinates, private setters obstructing
            if (parent instanceof Cars){
                Cars car = loaded.remove(loaded.size() - 1);
                car.setBeside((Vehicle)parent);
            }

            else{
                Cars car = loaded.remove(0);
                car.setBeside((Vehicle)parent);
            }


        }

    }

























    public double getTiltDeg(){
        return 0;
    }
}
