import java.awt.*;

public class FordGalaxy extends Cars{

    private int nDoors;
    public FordGalaxy() {
        super( 80, 0, Color.GRAY, "Ford Galaxy");
        this.nDoors = 4;
    }

    @Override
    public double speedFactor() {
        return 0;
    }
}
