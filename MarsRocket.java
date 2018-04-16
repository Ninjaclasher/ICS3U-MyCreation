//Ms Krasteva
//Evan Zhang
//Oct 23, 2017
//Draws the Mars rocket in the Mars scene (scene 3)
import java.awt.*;
import hsa.Console;

public class MarsRocket extends Interface implements Runnable
{
    //Constructor to get Console reference
    MarsRocket (Console d)
    {
	super (d);
    }

    //run method for thread
    public void run ()
    {
	//draws the rocket slowly landing
	for (int y = -50 ; y < HEIGHT - 50 ; y++)
	{
	    //draws the main rocket body
	    fillRect (WIDTH / 2 - 50, y - 30, 100, 30, Color.WHITE);
	    int[] x1 = {330, 290, 320};
	    int[] y1 = {y + 30, y - 5, y - 5};
	    //draws the wing of the rocket
	    fillPolygon (x1, y1, 3, Color.WHITE);
	    //draws the front of the rocket
	    fillArc (WIDTH / 2 - 90, y - 30, 80, 60, 90, 90, Color.WHITE);
	    drawArc (WIDTH / 2 - 60, y - 30, 10, 30, 270, 180, Color.BLUE);
	    //draws the strings that hold the parachute
	    drawLine (WIDTH / 2 - 40, y - 33, WIDTH / 2 - 80, y - 70, Color.BLACK);
	    drawLine (WIDTH / 2 + 30, y - 33, WIDTH / 2 + 70, y - 70, Color.BLACK);
	    //draws the parachute
	    fillArc (WIDTH / 2 - 90, y - 80, 170, 40, 0, 180, Color.BLACK);
	    //draws the back rocket booster
	    for (int x = 15 ; x < 30 ; x++)
	    {
		//alternates color (black and gray) so that it is not a solid color
		if ((x & 1) == 0)
		    drawLine (WIDTH / 2 + 35 + x, y - 15 + x / 3 * 2, WIDTH / 2 + 35 + x, y - 15 - x / 3 * 2, Color.GRAY);
		else
		    drawLine (WIDTH / 2 + 35 + x, y - 15 + x / 3 * 2, WIDTH / 2 + 35 + x, y - 15 - x / 3 * 2, Color.BLACK);
	    }
	    //draws the rocket booster flames
	    for (int x = 0 ; x < 15 ; x++)
	    {
		int randX1 = (int) (Math.random () * 20) + 10;
		int randX2 = (int) (Math.random () * 20) + 10;
		drawLine (WIDTH / 2 + 65, y - 15 - x, WIDTH / 2 + 65 + randX1, y - 15 - x, Color.YELLOW);
		drawLine (WIDTH / 2 + 65, y - 15 + x, WIDTH / 2 + 65 + randX2, y - 15 + x, Color.YELLOW);
	    }
	    //waits a specified time that increases (slowing down the rocket)
	    delay ((int) (50 - ((HEIGHT - y - 50) / (double) HEIGHT * 50)));
	    //clears the rocekt based on its position
	    if (y < HEIGHT - 51)
	    {
		if (y > HEIGHT - 180)
		{
		    fillRect (WIDTH / 2 - 110, HEIGHT - 135, 220, 110, MARS_SURFACE);
		    fillRect (WIDTH / 2 - 110, HEIGHT - HEIGHT / 3 - 100, 220, 110, MARS_BACKGROUND);
		}
		else
		    fillRect (WIDTH / 2 - 110, y - 110, 220, 150, MARS_BACKGROUND);

		fillArc (-WIDTH / 8, HEIGHT - HEIGHT / 3, WIDTH + WIDTH / 4, 250, 70, 270, MARS_SURFACE);
	    }
	    else
	    {
		fillRect (WIDTH / 2 + 65, HEIGHT - 90, 40, 100, MARS_SURFACE);
	    }
	}
	//waits 1 second before continuing
	delay (1000);
    }
}
