package Model;

public class VehicleFactory {

    public static Cars createSaab(){
        return new Saab95();
    }
    public static Cars createScania(){
        return new Scania();
    }
    public static Cars createVolvo(){
        return new Volvo240();
    }
    public static Cars createFreightliner(){
        return new Freightliner();
    }
    public static Cars createFordGalaxy(){
        return new FordGalaxy();
    }
    public static Vehicle createCargoship(){
        return new Cargoship();
    }

}
