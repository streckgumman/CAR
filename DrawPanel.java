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

    ArrayList<BufferedImage> images = new ArrayList<>();
    List<Point> carPoints = new ArrayList<>();
    List<Cars> cars = CarController.getCars();

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage; //temporary, maybe make a list with images/cars, link them to classes
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    // To keep track of a single cars position
    Point volvoPoint = new Point();
    Point carPoint = new Point();

    void addPoints(List<Cars> cars){
        for (Cars c :cars){ //if outside range, turn around and set engine to starting speed
            if ((c.getPosX() > 670 && (c.getDeg() %360 == 0)) ||(c.getPosX() < 0 && (c.getDeg()%360 == 180))){
                c.turnLeft();
                c.turnLeft();
                c.startEngine();
            }
            carPoints.add(new Point((int)c.getPosX(),(int)c.getPosY()));
        }
    }

    // TODO: Make this general for all cars
    void moveit(int x, int y, int position){
        carPoints.set(position, new Point(x,y));
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
        addPoints(CarController.getCars());
        super.paintComponent(g);
         // see javadoc for more info on the parameters
        int yPosition = 0;
        for (int i = 0; i < cars.size(); i++){
            if (cars.get(i) instanceof Volvo240){
                g.drawImage(volvoImage, carPoints.get(i).x, carPoints.get(i).y + yPosition, null);
            }if (cars.get(i) instanceof Saab95){
                g.drawImage(saabImage, carPoints.get(i).x  , carPoints.get(i).y + yPosition, null);
            } if (cars.get(i) instanceof Scania){
                g.drawImage(scaniaImage, carPoints.get(i).x  , carPoints.get(i).y + yPosition, null);
            }
            yPosition += 100;
        }

    }
}