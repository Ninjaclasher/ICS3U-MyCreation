//Ms Krasteva
//Evan Zhang
//Oct 23, 2017
//Moon class to draw the moon in the second scene
import java.awt.*;
import hsa.Console;

public class Moon extends SpaceObject
{
    //variables to store the position and colour of each moon object
    private Color moonColour;
    private int recentX = 0, recentY = 0;
    //constructor to get Console reference and the info for each object
    Moon (Console d, int rotateSpeed, int size, int distance, Color cc)
    {
	//calls the super class with paramenters
	super (d, rotateSpeed, size, distance);
	//sets colour of moon
	moonColour = cc;
    }

    //draws the moon at the current position provided through parameters
    public void drawMoon (int radian, int posX, int posY)
    {
	//calculates actual position of the moon with the Earth/Mars position depending on the base planet
	recentX = (int) Math.round (Math.cos (Math.toRadians (radian * rotateSpeed)) * distance + posX);
	recentY = (int) Math.round (Math.sin (Math.toRadians (radian * rotateSpeed)) * distance + posY);
	//draws moon
	fillOval (recentX - size / 2, recentY - size / 2, size, size, moonColour);
    }

    //clears the moon that was just drawn
    public void clearMoon ()
    {
	//clears moon
	fillOval (recentX - size / 2, recentY - size / 2, size, size, Color.BLACK);
    }

    //uneeded run method, but is required for the SpaceObject base class
    public void run () {}
}
