package Controller;

import Model.*;
import View.CarView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    CarView frame; //static för funkade inte annars
    World model;

    // A list of cars, modify if needed
    //private final static ArrayList<Cars> cars = new ArrayList<>();

    //methods:
    public CarController(CarView frame, World model){
        this.frame = frame;
        this.model = model;
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int count = 0;
            for (Car car : model.getCars()) {
                car.move();
                int x = (int) Math.round(car.getPosX());
                int y = (int) Math.round(car.getPosY());
                model.moveit(x, y, count);
                // repaint() calls the paintComponent method of the panel
                //frame.drawPanel.repaint();
                count++;
            }
        }
    }
    public void startTimer(){
        timer.start();
    }






    //public static ArrayList<Cars> getCars() {
       // return cars;
    //}




}
