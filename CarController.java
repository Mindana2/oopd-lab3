import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Workshop> workshops = new ArrayList<>();
    private ArrayList<Vehicle> cars = new ArrayList<>();




    //methods:

    public static void main(String[] args) {
        // Instance of this class

        CarController cc = new CarController();
        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95(false));
        cc.cars.add(new Scania(0));

        cc.workshops.add(new Workshop<Volvo240>(5, 300, 300, Volvo240.class));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();

    }


    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            for (Vehicle car : cars) {
                int x = (int) Math.round(car.getxPos());
                int y = (int) Math.round(car.getyPos());
                if ((0 > x || x > 700) || (0 > y || y > 500)) {
                    car.turnLeft();
                    car.turnLeft();
                }

                car.move();
                frame.drawPanel.moveit(car.getPath(), x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();

                for (Workshop workshop: workshops){

                    if (workshopCollisionCheck(car, workshop)){
                        if (workshop.getType().isInstance(car) && !workshop.getSlotList().contains(car)){
                            frame.drawPanel.loadWorkshop(car);
                            workshop.loadCar(car);
                            continue;
                        }
                        car.turnLeft();
                        car.turnLeft();

                    }
                }
            }
        }
    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars
        ) {
            car.brake(gas);
        }
    }

    void setTurboOn() {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }

        }
    }

    void setTurboOff() {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }

        }
    }

    void startEngine() {
        for (Vehicle car : cars) {
            car.startEngine();
        }
    }

    void stopEngine() {
        for (Vehicle car : cars) {
            car.stopEngine();
        }
    }

    void turnRight() {
        for (Vehicle car : cars) {
            car.turnRight();
        }
    }

    void turnLeft() {
        for (Vehicle car : cars) {
            car.turnLeft();

        }
    }

    boolean workshopCollisionCheck(Vehicle car, Workshop workshop) {

        if (Math.abs((workshop.getxPos() - car.getxPos())) < 100 && Math.abs((workshop.getyPos() - car.getyPos())) < 70 ){
                return true;
        }


        return false;
    }

}