import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagePosition {

    private final BufferedImage image;
    private Point position;
    private final Vehicle vehicle;


    public ImagePosition(Vehicle vehicle, BufferedImage image, Point position) {

        this.image = image;
        this.position = position;
        this.vehicle = vehicle;

    }


    public BufferedImage getImage() {
        return image;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(BufferedImage image, Point point) {
        this.position = point;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }




}
