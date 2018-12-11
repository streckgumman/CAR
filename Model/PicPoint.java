package Model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class PicPoint {
    private Point carPoint;
    private final BufferedImage image;

    public PicPoint(Point carpoint, BufferedImage image){
        this.carPoint = carpoint;
        this.image = image;
    }

    public void setCarPoint(int x, int y) {
        this.carPoint.setLocation(x,y);
    }

    public Point getCarPoint() {
        return carPoint;
    }

    public BufferedImage getImage() {
        return image;
    }


}
