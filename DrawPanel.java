import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;


// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage scaniaImage;
    BufferedImage saabImage;
    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);

    ImagePosition volvo = new ImagePosition(new Volvo240(),volvoImage, new Point(0, 0));
    ImagePosition scania = new ImagePosition(new Scania(0),scaniaImage, new Point(0, 100));
    ImagePosition saab = new ImagePosition(new Saab95(false), saabImage, new Point(0, 200));
    ArrayList<ImagePosition> ImagePosList = new ArrayList<>();
    CarController cc = new CarController();


    // To keep track of a single car's position

    // TODO: Make this general for all cars
    void moveit(Vehicle car, int x, int y){
        if ("pics/" + car.getModelName() + ".jpg" == )



//        for (ImagePosition ImPos : ImagePosList) {
//            if (car == ImPos.getVehicle()){
//                ImPos.setPosition(ImPos.getImage(), new Point(x, y));
//            }
//        }



    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {

        ImagePosList.add(volvo);
        ImagePosList.add(scania);
        ImagePosList.add(saab);
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.lightGray);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Remember to right-click src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.

            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(volvoImage, volvo.getPosition().x, volvo.getPosition().y, null); // see javadoc for more info on the parameters
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
        g.drawImage(scaniaImage, scania.getPosition().x, scania.getPosition().y, null);
        g.drawImage(saabImage, saab.getPosition().x, saab.getPosition().y, null);


    }
}
