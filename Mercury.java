//Ms Krasteva
//Evan Zhang
//Oct 23, 2017
//Mercury class to draw Mercury object in the space scene
import java.awt.*;
import hsa.Console;

public class Mercury extends SpaceObject
{
    //Constructor to get Console reference
    Mercury (Console d)
    {
	//calls super class
	super (d, 15, 6, 50);
    }

    //run method for a thread
    public void run ()
    {
	//randomly get intial start position
	int randStart = (int) (Math.random () * 360);
	
	//can be stopped at any time with a variable declared in SpaceObject
	while (!stopThread)
	{
	    //calculates the position for each degree 
	    for (int x = randStart ; x < randStart + 360 ; x++)
	    {
		//calculates current position using trigonometry
		int xx = (int) Math.round (Math.cos (Math.toRadians (x)) * distance + WIDTH / 2);
		int yy = (int) Math.round (Math.sin (Math.toRadians (x)) * distance + HEIGHT / 2);
		//draws the object
		fillOval (xx - size / 2, yy - size / 2, size, size, SPACE_MERCURY);
		//waits specified time
		delay (rotateSpeed);
		//clears the object
		fillOval (xx - size / 2, yy - size / 2, size, size, SPACE_BACKGROUND);
	    }
	}
    }
}
