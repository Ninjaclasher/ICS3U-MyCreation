//Ms Krasteva
//Evan Zhang
//Oct 23, 2017
//draws the Earth planet in the space scene (scene 2)
import java.awt.*;
import hsa.Console;

public class Earth extends SpaceObject
{
    //declares moon variable
    Moon m;
    
    //Constructor to get Console and assigns the Moon
    Earth (Console d)
    {
	super (d, 50, 15, 130);
	m = new Moon (c, 13, 2, size + 2, Color.WHITE);
    }

    //run method for thread
    public void run ()
    {
	//runs while not stopped
	while (!stopThread)
	{
	    //goes through each degree and calculates the coordinates of Earth
	    for (int x = 0 ; x < 360 ; x++)
	    {
		//stores the position of Earth
		int xx = (int) Math.round (Math.cos (Math.toRadians (x)) * distance + WIDTH / 2);
		int yy = (int) Math.round (Math.sin (Math.toRadians (x)) * distance + HEIGHT / 2);
		//draws Earth
		fillOval (xx - size / 2, yy - size / 2, size, size, Color.BLUE);
		fillOval (xx - size / 4 - 1, yy - size / 2 + 1, size / 3, size / 2 - size / 8, Color.GREEN);
		fillOval (xx - size / 4 - 1, yy - 1, size / 3, size / 2 - size / 5, SPACE_EARTH);
		fillOval (xx + 1, yy - size / 2 + 3, size / 2 - 1, size / 4 + 1, Color.GREEN);
		fillOval (xx + 2, yy, size / 3, size / 3, SPACE_EARTH);
		//draws Earth's moon
		m.drawMoon (x, xx, yy);
		//waits specified time
		delay (rotateSpeed);
		//clears Earth
		fillOval (xx - size / 2, yy - size / 2, size, size, SPACE_BACKGROUND);
		//clears the moon
		m.clearMoon ();
	    }
	}
    }
}
