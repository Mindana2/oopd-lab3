import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class ImagePosition {

    private BufferedImage image;
    private Point position;
    private Vehicle vehicle;

    public BufferedImage getImage() {
        return image;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(BufferedImage image, Point point) {
        this.position = point;
    }

    public Vehicle getVeichle(){
        return vehicle;
    }



    public ImagePosition(Vehicle vehicle, BufferedImage image, Point position) {

        this.image = image;
        this.position = position;
        this.vehicle = vehicle;

    }




}
