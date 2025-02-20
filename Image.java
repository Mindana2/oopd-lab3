import java.awt.image.BufferedImage;

public class Image {


    private int xPos, yPos;
    private Vehicle vehicle;
    private boolean isVisible;
    private String path;




    public Image(int xPos, int yPos, boolean isVisible, String path)  {


        this.xPos = xPos;
        this.yPos = yPos;
        this.isVisible = isVisible;
        this.path = path;

    }


    public int getxPos() {
        return this.xPos;
    }

    public int getyPos() {
        return this.yPos;
    }

    public  String getPath(){return this.path;}

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }

    public boolean getVisibility(){
        return this.isVisible;
    }

    public void setVisibility(boolean state){
        this.isVisible = state;
    }




}
