package View;

import View.CarView;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    CarView view; //remove this dependency

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarView view) {
        this.view = view;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
         // see javadoc for more info on the parameters
        for (int i = 0; i < view.model.getPositions().size(); i++){
            int carSpacing = 100 * i;
            Point currentPos = view.model.getPositions().get(i).getCarPoint();
            BufferedImage currentImage = view.model.getPositions().get(i).getImage();
            g.drawImage(currentImage,currentPos.x,currentPos.y + carSpacing, null);
        }
        /*g.drawImage(images.get(0), carPoints.get(0).x, carPoints.get(0).y, null);
        g.drawImage(images.get(1), carPoints.get(1).x  , carPoints.get(1).y + 100, null);
        g.drawImage(images.get(2), carPoints.get(2).x  , carPoints.get(2).y + 200, null);*/


    }
}