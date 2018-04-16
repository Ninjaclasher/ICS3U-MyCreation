//Ms Krasteva
//Evan Zhang
//Oct 23, 2017
//Venus class to draw a Venus object in the space scene
import java.awt.*;
import hsa.Console;

public class Venus extends SpaceObject
{
    //Construtor to get the Console reference
    Venus (Console d)
    {
	//calls super class
	super (d, 40, 14, 94);
    }

    //run method for a thread
    public void run ()
    {
	//randomly get initial start position
	int randStart = (int) (Math.random () * 360);
	
	//can be stopped at any time with a variable
	while (!stopThread)
	{
	    //calculates the position at each degree (360 degrees)
	    for (int x = randStart ; x < randStart + 360 ; x++)
	    {
		//calculates position using trigonometry
		int xx = (int) Math.round (Math.cos (Math.toRadians (x)) * distance + WIDTH / 2);
		int yy = (int) Math.round (Math.sin (Math.toRadians (x)) * distance + HEIGHT / 2);
		
		//draws the object using 1 fillOval (DOES NOT COUNT AS ANIMAION)
		fillOval (xx - size / 2, yy - size / 2, size, size, SPACE_VENUS);
		//waits specified time
		delay (rotateSpeed);
		//clers the object
		fillOval (xx - size / 2, yy - size / 2, size, size, SPACE_BACKGROUND);
	    }
	}
    }
}
