import Controller.CarController;
import Model.VehicleFactory;
import Model.World;
import View.CarView;

public class Application {
    public static void main(String[] args) {
        // Instance of this class
        World model = new World();
        CarView frame = new CarView("CarSim 1.0", model);
        CarController cc = new CarController(frame ,model);


        model.addCar(VehicleFactory.createVolvo());
        model.addCar(VehicleFactory.createSaab());
        model.addCar(VehicleFactory.createScania());



        // Start a new view and send a reference of self

        model.addWorldObserver(frame);

        // Start the timer
        cc.startTimer();

        //LEFT TO DO, ADD BUTTONS FOR ADD/REMOVECAR, MAKE COHESION BETTER (ACTIONLISTENER IN CARVIEW,
        //ADDING CARS IN CONTROLLER NOT MODEL, TO MUCH STUFF IN WORLD?, FIX DEPENDENCY IN DRAWPANEL
    }
}
