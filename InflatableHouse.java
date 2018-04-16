//Ms Krasteva
//Evan Zhang
//Oct 23, 2017
//draws the InflatableHouse in the Mars scene (scene 3)
import java.awt.*;
import hsa.Console;

public class InflatableHouse extends Thread
{
    //Stores the Console
    private Console c;
    
    //Constructor to get Console and assigns it to c
    InflatableHouse (Console d)
    {
	c = d;
    }

    //run method for thread
    public void run ()
    {
	//draws the object "inflating"
	for (int x = 0 ; x < 250 ; x++)
	{
	    //draws main entrance
	    c.setColor (Color.WHITE);
	    c.fillRect (480 - x / 3 + x / 16, 425 - Math.min (50, x / 4), 50, Math.min (50, x / 4));
	    //draws main entrance outline
	    c.setColor (Color.BLACK);
	    c.drawRect (480 - x / 3 + x / 16, 425 - Math.min (50, x / 4), 50, Math.min (50, x / 4));
	    //draw main hub outline
	    c.fillArc (520 - x / 3 - 1, 420 - x / 2 - 1, 100 + x / 3 * 2 + 2, 10 + x + 2, 0, 180);
	    c.drawLine (520 - x / 3 - 1, 425, 620 + x / 3 + 2, 425);
	    //draw main hub
	    c.setColor (Color.WHITE);
	    c.fillArc (520 - x / 3, 420 - x / 2, 100 + x / 3 * 2, 10 + x, 0, 180);
	    //draws the maple leaf on the hub
	    c.setColor (Color.RED);
	    c.fillMapleLeaf (590 - x / 5, 427 - x / 3, x / 5, x / 5);
	    
	    //waits 10 milliseconds
	    try
	    {
		Thread.sleep (10);
	    }
	    catch (Exception e)
	    {
	    }
	}
    }
}
