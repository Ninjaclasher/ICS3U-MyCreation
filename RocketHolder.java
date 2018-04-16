//Ms Krasteva
//Evan Zhang
//Oct 23, 2017
//Rocket holder class for one of the animations during rocket launch for the first scene
import java.awt.*;
import hsa.Console;

public class RocketHolder extends Interface implements Runnable
{
    //stores the position of the rocket holder
    private int posX, posY;

    //Constructor to get Console reference and x and y positions of the rocket holder
    RocketHolder (Console d, int x, int y)
    {
	//calls super class
	super (d);
	//assigns variables
	posX = x;
	posY = y;
    }

    //drawHolder method to draw the main holder (before animation begins)
    public void drawHolder ()
    {
	//draws farthest vertical beams on each side
	fillRectWithLine (posX - posX / 2, 120, 10, HEIGHT, Color.BLACK);
	fillRectWithLine (posX + posX / 2 - 10, 120, 10, HEIGHT, Color.BLACK);
	
	//draws closest vertical beams on each side
	fillRectWithLine (posX - (posX * 2) / 5, 120, 10, HEIGHT, Color.BLACK);
	fillRectWithLine (posX + (posX * 2) / 5 - 10, 120, 10, HEIGHT, Color.BLACK);
	
	//draws top horizonal beams on each side
	fillRectWithLine (posX - posX / 2, 120, 160, 10, Color.BLACK);
	fillRectWithLine (posX, 120, 160, 10, Color.BLACK);

	//draws diagonal support beams between the two vertical beams on each side
	for (int x = 0, posYL = 130, posYR = 155 ; x < 16 ; x++)
	{
	    //draws the beams on each side
	    for (int y = 0 ; y < 10 ; y++)
	    {
		drawLine (posX - posX / 2 + 10, posYL + y, posX - posX / 2 + 32, posYR + y, Color.BLACK);
		drawLine (posX - posX / 2 + 10, posYR + y, posX - posX / 2 + 32, posYL + y, Color.BLACK);
		drawLine (posX + posX / 2 - 10, posYL + y, posX + posX / 2 - 32, posYR + y, Color.BLACK);
		drawLine (posX + posX / 2 - 10, posYR + y, posX + posX / 2 - 32, posYL + y, Color.BLACK);
	    }
	    
	    //decides to move the left side down or the right side down
	    if ((x & 1) == 0)
		posYL += 50;
	    else
		posYR += 50;
	}
	
	//draws three rocket supporter on the left side of the rocket
	fillRectWithLine (posX - (posX * 2) / 5, posY + 20, 63, 5, Color.BLACK);
	fillRectWithLine (posX - (posX * 2) / 5, posY + 10, 63, 5, Color.BLACK);

	fillRectWithLine (posX - (posX * 2) / 5, posY - 20, 63, 5, Color.BLACK);
	fillRectWithLine (posX - (posX * 2) / 5, posY - 10, 63, 5, Color.BLACK);

	fillRectWithLine (posX - (posX * 2) / 5, posY - 50, 63, 5, Color.BLACK);
	fillRectWithLine (posX - (posX * 2) / 5, posY - 40, 63, 5, Color.BLACK);

	//draws the arc that supports the rocket at the top
	fillArc (posX - 30, 110, 60, 40, 90, 90, Color.BLACK);
	fillArc (posX - 30, 110, 60, 40, 0, 90, Color.BLACK);
    }

    //run method for thread
    public void run ()
    {
	//draw holder without animation
	drawHolder ();
	
	//removes the old rocket top holder for the new animation holder
	fillRectWithLine (posX - (posX * 2) / 5 + 10, 110, 100, 20, EARTH_BACKGROUND);
	fillRectWithLine (posX + 20, 110, 100, 20, EARTH_BACKGROUND);
	
	//animations
	for (int x = 88 ; x < 170 ; x++)
	{
	    //get position of the rocket top holder
	    int endXL = (int) Math.round (Math.sin (Math.toRadians (x)) * 128 + posX - (posX * 2) / 5);
	    int endYL = (int) Math.round (Math.cos (Math.toRadians (x)) * 128 + 120);
	    int endXR = (int) Math.round (Math.cos (Math.toRadians (x + 90)) * 128 + posX + (posX * 2) / 5);
	    int endYR = (int) Math.round (Math.sin (Math.toRadians (x + 90)) * 128 + 120);
	    //array to store the positions of the rocket top holder
	    int[] xx1 = {posX - (posX * 2) / 5 + 10, posX - (posX * 2) / 5, endXL - 10, endXL};
	    int[] yy1 = {130, 120, endYL - 10, endYL};
	    int[] xx2 = {posX + (posX * 2) / 5 - 10, posX + (posX * 2) / 5, endXR + 10, endXR};
	    int[] yy2 = {132, 120, endYR - 10, endYR};
	    //draws the arc for the top rocket holder
	    fillArc (endXL - 30, endYL - 20, 60, 40, x, 90, Color.BLACK);
	    fillArc (endXR - 30, endYR - 20, 60, 40, 90 - x, 90, Color.BLACK);
	    //draws the two arms for the rocket holder
	    fillPolygon (xx1, yy1, 4, Color.BLACK);
	    fillPolygon (xx2, yy2, 4, Color.BLACK);
	    fillOval (endXL, endYL, 1, 1, EARTH_BACKGROUND);
	    delay (50);
	    //makes sure the rocket holder does not disappear at the end
	    if (x != 169)
	    {
		//clears rocket holder
		fillArc (endXL - 30, endYL - 20, 60, 40, x, 90, EARTH_BACKGROUND);
		fillArc (endXR - 30, endYR - 20, 60, 40, 90 - x, 90, EARTH_BACKGROUND);
		fillPolygon (xx1, yy1, 4, EARTH_BACKGROUND);
		fillPolygon (xx2, yy2, 4, EARTH_BACKGROUND);
	    }
	    //slowly clears side rocket holder
	    drawLine (posX - (posX * 2) / 5 + Math.max (10, 63 - x + 88), posY - 100, posX - (posX * 2) / 5 + Math.max (10, 63 - x + 88), posY + 100, EARTH_BACKGROUND);
	}
    }
}
