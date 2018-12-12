package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//supposed to add cars here and return and access list from here
public class World {
    private final List<Car> cars = new ArrayList<>();
    private List<WorldObserver> observers = new ArrayList<>();
    private final List<PicPoint> positions = new ArrayList<>();


    public List<Car> getCars() { // change implementation (alias issues)
        return cars;
    }

    public List<PicPoint> getPositions() {
        return positions;
    }

    public void addWorldObserver(WorldObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {//fix
        refreshPoints();
        checkValidPosition();
        for (WorldObserver observer : observers){
            observer.actOnWorldChange();
        }
    }
    void refreshPoints(){
        for (Car c :cars){ //if outside range, turn around and set engine to starting speed
            if (cars.size() != positions.size()){
                positions.add(new PicPoint(new Point(0,0),getCarImage(c)));


            }
        }
    }
    void checkValidPosition(){
        for (Car c :cars) { //if outside range, turn around and set engine to starting speed
            if (hitsWall(c)) {
                c.turnLeft();
                c.turnLeft();
                c.startEngine();
            }
        }
    }
    boolean hitsWall(Car c){
        if ((c.getPosX() > 680 && (c.getDeg() % 360 == 0)) || (c.getPosX() < 0 && (c.getDeg() % 360 == 180))){
            return true;
        }
        else{
            return false;
        }
    }


    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    // To keep track of a single cars position



    BufferedImage getCarImage(Car c){
        try {
            // You can remove the "src\\pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            // Linux users need to modify \ to / in path string
            volvoImage = ImageIO.read(new File("src\\pics\\Volvo240.jpg"));
            saabImage = ImageIO.read(new File("src\\pics\\Saab95.jpg"));
            scaniaImage = ImageIO.read(new File("src\\pics\\Scania.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        switch (c.getModelName()){
            case "Volvo240":
                return volvoImage;
            case "Saab95":
                return saabImage;
            case "Scania":
                return scaniaImage;

        }
        //never returning this
        return null;
    }

    // TODO: Make this general for all cars
    public void moveit(int x, int y, int count){
        positions.get(count).setCarPoint(x,y);
        notifyObservers();
    }
    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }

    }
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.brake(brake);
        }
    }
    public void startEngine(){
        for (Car car : cars){
            car.startEngine();
        }
    }
    public void stopEngine(){
        for (Car car : cars){
            car.stopEngine();
        }
    }
    public void tiltDown(){
        for (Car car : cars){
            if (car instanceof Scania){
                ((Scania) car).tiltDown();
            }
        }
    }
    public void tiltUp(){
        for (Car car : cars){
            if (car instanceof Scania){
                ((Scania) car).tiltDown();
            }
        }
    }
    public void setTurboOn(){
        for (Car car : cars){
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOn();
            }
        }
    }
    public void setTurboOff(){
        for (Car car : cars){
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOff();
            }
        }
    }
    public void addCar(Car car){
        if (cars.size() < 10){
            cars.add(car);
            positions.add(new PicPoint(new Point((int)car.getPosX(),(int)car.getPosY()),getCarImage(car)));
        }
    }

    public void removeCar(){ //removes last added vehicle
        if (cars.size() > 0){
            cars.remove(cars.size() - 1);
            positions.remove(positions.size() - 1);
        }
    }


}
