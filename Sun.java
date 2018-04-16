//Ms Krasteva
//Evan Zhang
//Oct 23, 2017
//Sun class that draws the sun in the space scene
import java.awt.*;
import hsa.Console;

public class Sun extends SpaceObject
{
    //Constructor to get Console reference
    Sun (Console d)
    {
	//calls the super class
	super (d, 10, 50, 0);
    }

    //run method for thread
    public void run ()
    {
	//draws the initial sun
	fillOvalWithLine (WIDTH / 2 - size / 2, HEIGHT / 2 - size / 2, size, size, SPACE_SUN);
	//while loop so that the thread can be stopped at any time
	while (!stopThread)
	{
	    //draws the sun's "rays" inside the sun
	    for (int x = 0 ; x < size / 2 ; x++)
	    {
		//draws ray
		drawOval (WIDTH / 2 - x, HEIGHT / 2 - x, x * 2, x * 2, Color.RED);
		//waits 10 ms
		delay (rotateSpeed);
		//clears ray
		drawOval (WIDTH / 2 - x, HEIGHT / 2 - x, x * 2, x * 2, SPACE_SUN);
	    }
	    //draws the sun's "rays" outside the sun
	    for (int x = size / 2 ; x < size / 2 + size / 4 ; x++)
	    {
		//draws ray
		drawOval (WIDTH / 2 - x, HEIGHT / 2 - x, x * 2, x * 2, Color.RED);
		//waits 10 ms
		delay (rotateSpeed);
		//clears ray
		drawOval (WIDTH / 2 - x, HEIGHT / 2 - x, x * 2, x * 2, SPACE_BACKGROUND);
	    }
	}
    }
}
