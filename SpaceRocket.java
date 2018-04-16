//Ms Krasteva
//Evan Zhang
//Oct 23, 2017
//Space rocket to draw the rocket in the space scene
import java.awt.*;
import hsa.Console;

public class SpaceRocket extends SpaceObject
{
    //Constructor to get Console reference
    SpaceRocket (Console d)
    {
	//calls super class
	super (d, 228, 0, 0);
    }

    //run method for thread
    public void run ()
    {
	//moves the space rocket from Earth to Mars
	for (int x = 0 ; x < 60 ; x++)
	{
	    //draws rocket
	    fillOval (WIDTH / 2 + 140 + x, HEIGHT / 2, 5, 5, Color.WHITE);
	    //waits 228 ms
	    delay (rotateSpeed);
	    //clears rocket
	    fillOval (WIDTH / 2 + 140 + x, HEIGHT / 2, 5, 5, SPACE_BACKGROUND);
	}
	//waits 1 second before ending thread
	delay (1000);
    }
}
