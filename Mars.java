//Ms Krasteva
//Evan Zhang
//Oct 23, 2017
//Mars class to draw a Mars object in the space scene
import java.awt.*;
import hsa.Console;

public class Mars extends SpaceObject
{
    //declares Mars' moons 
    Moon phobos, deimos;
    //Constructor to get Console reference
    Mars (Console d)
    {
	//calls super class
	super (d, 90, 8, 200);
	//assigns each Moon object
	phobos = new Moon (c, 30, 2, size + 2, new Color (119, 119, 119));
	deimos = new Moon (c, 8, 2, size + 7, Color.WHITE);
    }

    //run method for a thread
    public void run ()
    {
	//can be stopped at any time with a variable
	while (!stopThread)
	{
	    //calculates position for each degree
	    for (int x = 210 ; x < 570 ; x++)
	    {
		//gets current position using trigonometry
		int xx = (int) Math.round (Math.cos (Math.toRadians (x)) * distance + WIDTH / 2);
		int yy = (int) Math.round (Math.sin (Math.toRadians (x)) * distance + HEIGHT / 2);
		//draw Mars using 1 fillOval
		fillOval (xx - size / 2, yy - size / 2, size, size, SPACE_MARS);
		//draws the two moons
		phobos.drawMoon (x, xx, yy);
		deimos.drawMoon (x, xx, yy);
		//waits specified time
		delay (rotateSpeed);
		//clears Mars
		fillOval (xx - size / 2, yy - size / 2, size, size, SPACE_BACKGROUND);
		//clears the two moons
		phobos.clearMoon ();
		deimos.clearMoon ();
	    }
	}
    }
}
