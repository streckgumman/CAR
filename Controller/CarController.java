package Controller;

import Model.Cars;
import Model.Saab95;
import Model.Scania;
import Model.VehicleFactory;
import View.CarView;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
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

    // A list of cars, modify if needed
    private final static ArrayList<Cars> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();


        cc.cars.add(VehicleFactory.createVolvo());
        cc.cars.add(VehicleFactory.createSaab());
        cc.cars.add(VehicleFactory.createScania());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int count = 0;
            for (Cars car : cars) {
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
        for (Cars car : cars) {
                car.gas(gas);
        }

    }
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Cars car : cars
        ) {
            car.brake(brake);
        }
    }
    public void startEngine(){
        for (Cars car : cars){
            car.startEngine();
        }
    }
    public void stopEngine(){
        for (Cars car : cars){
            car.stopEngine();
        }
    }
    public void tiltDown(){
        for (Cars car : cars){
            if (car instanceof Scania){
                ((Scania) car).tiltDown();
            }
        }
    }
    public void tiltUp(){
        for (Cars car : cars){
            if (car instanceof Scania){
                ((Scania) car).tiltDown();
            }
        }
    }
    public void setTurboOn(){
        for (Cars car : cars){
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOn();
            }
        }
    }
    public void setTurboOff(){
        for (Cars car : cars){
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOff();
            }
        }
    }

    public static ArrayList<Cars> getCars() {
        return cars;
    }
}
