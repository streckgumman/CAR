package Model;

public class VehicleFactory {

    public static Car createSaab(){
        return new Saab95();
    }
    public static Car createScania(){
        return new Scania();
    }
    public static Car createVolvo(){
        return new Volvo240();
    }
    public static Car createFreightliner(){
        return new Freightliner();
    }
    public static Car createFordGalaxy(){
        return new FordGalaxy();
    }
    public static Vehicle createCargoship(){
        return new Cargoship();
    }

}
