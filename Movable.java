import java.awt.*;

/**
 * An interface for all Movable objects
 */
public interface Movable {
    enum Direction{
        NORTH, EAST, SOUTH, WEST
    }
    Point currentpoint = new Point();
    void move();
    void turnLeft();
    void turnRight();

}
