package Controller;

import Model.Car;
import Model.Saab95;
import Model.Scania;
import Model.VehicleFactory;
import View.CarView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    public CarView frame;

    // A list of CARS, modify if needed
    private final static ArrayList<Car> CARS = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();


        cc.CARS.add(VehicleFactory.createVolvo());
        cc.CARS.add(VehicleFactory.createSaab());
        cc.CARS.add(VehicleFactory.createScania());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the CARS in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int count = 0;
            for (Car car : CARS) {
                car.move();
                int x = (int) Math.round(car.getPosX());
                int y = (int) Math.round(car.getPosY());
                frame.drawPanel.moveit(x, y, count);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                count++;
            }
        }
    }









        // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : CARS) {
                car.gas(gas);
        }

    }
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : CARS
        ) {
            car.brake(brake);
        }
    }
    public void startEngine(){
        for (Car car : CARS){
            car.startEngine();
        }
    }
    public void stopEngine(){
        for (Car car : CARS){
            car.stopEngine();
        }
    }
    public void tiltDown(){
        for (Car car : CARS){
            if (car instanceof Scania){
                ((Scania) car).tiltDown();
            }
        }
    }
    public void tiltUp(){
        for (Car car : CARS){
            if (car instanceof Scania){
                ((Scania) car).tiltDown();
            }
        }
    }
    public void setTurboOn(){
        for (Car car : CARS){
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOn();
            }
        }
    }
    public void setTurboOff(){
        for (Car car : CARS){
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOff();
            }
        }
    }

    public static ArrayList<Car> getCars() {
        return CARS;
    }
}
