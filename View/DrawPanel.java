package View;

import Controller.CarController;
import Model.Cars;
import Model.PicPoint;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{


    private final List<PicPoint> positions = new ArrayList<>();
    private final List<Cars> cars = CarController.getCars();


    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    // To keep track of a single cars position

    void refreshPoints(){
        for (Cars c :cars){ //if outside range, turn around and set engine to starting speed
            getCarImage(c);
            if (cars.size() != positions.size()){
                positions.add(new PicPoint(new Point(0,0),getCarImage(c)));

            }
        }
    }
    void checkValidPosition(){
        for (Cars c :cars) { //if outside range, turn around and set engine to starting speed
            if (hitsWall(c)) {
                c.turnLeft();
                c.turnLeft();
                c.startEngine();
            }
        }
    }
    boolean hitsWall(Cars c){
        if ((c.getPosX() > 680 && (c.getDeg() % 360 == 0)) || (c.getPosX() < 0 && (c.getDeg() % 360 == 180))){
            return true;
        }
        else{
            return false;
        }
    }

    BufferedImage getCarImage(Cars c){
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
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
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

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        refreshPoints();
        checkValidPosition();
        super.paintComponent(g);
         // see javadoc for more info on the parameters
        for (int i = 0; i < cars.size(); i++){
            int carSpacing = 100 * i;
            Point currentPos = positions.get(i).getCarPoint();
            BufferedImage currentImage = positions.get(i).getImage();
            g.drawImage(currentImage,currentPos.x,currentPos.y + carSpacing, null);
        }
        /*g.drawImage(images.get(0), carPoints.get(0).x, carPoints.get(0).y, null);
        g.drawImage(images.get(1), carPoints.get(1).x  , carPoints.get(1).y + 100, null);
        g.drawImage(images.get(2), carPoints.get(2).x  , carPoints.get(2).y + 200, null);*/


    }
}