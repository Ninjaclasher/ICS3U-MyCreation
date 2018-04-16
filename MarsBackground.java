//Ms Krasteva
//Evan Zhang
//Oct 23, 2017
//draws the Mars background
import java.awt.*;
import hsa.Console;

public class MarsBackground extends Background
{
    //Constructor to get Console reference
    MarsBackground (Console d)
    {
	super (d);
    }

    //draws a sun at the specified coordinates
    public void drawSun (int posX, int posY)
    {
	fillOvalWithLine (posX - 25, posY - 25, 50, 50, new Color (255, 196, 2));
    }

    //draws a crater at the specified coordinates
    public void drawCrater (int posX, int posY)
    {
	fillOvalWithLine (posX, posY, 200, 75, MARS_BACKGROUND);
    }

    //draws a static inflatable house in the background
    public void drawHouse1 ()
    {
	//draws main hub
	fillOvalWithLine (85, 325, 60, 60, Color.WHITE);
	//draws the two entrances
	int[] xx1 = {75, 85, 85, 75};
	int[] yy1 = {350, 345, 365, 365};
	int[] xx2 = {140, 155, 155, 140};
	int[] yy2 = {335, 335, 350, 350};
	fillPolygonWithLine (xx1, yy1, 4, Color.WHITE);
	fillPolygonWithLine (xx2, yy2, 4, Color.WHITE);
    }

    //draws a static inflatable house in the foreground
    public void drawHouse2 ()
    {
	//draws the entrances
	int[] x = {200, 240, 240, 200};
	int[] y = {370, 370, 424, 424};
	fillPolygonWithLine (x, y, 4, Color.WHITE);
	drawLine (0, 425, 240, 425, Color.BLACK);
	drawLine (240, 370, 240, 425, Color.BLACK);
	drawLine (204, 370, 240, 370, Color.BLACK);

	//draws the main hub
	fillArc (-80, 300, 300, 250, 0, 180, Color.WHITE);
	drawArc (-80, 300, 300, 250, 0, 180, Color.BLACK);
	drawRect (189, 410, 41, 21, Color.BLACK);
	
	//draws a container filled with Mars sand infront of the house
	fillRectWithLine (190, 410, 40, 20, Color.WHITE);
	for (int i = 0 ; i < 500 ; i++)
	{
	    //fills in the container randomly
	    int randX = (int) (Math.random () * 38 + 190);
	    int randY = (int) (Math.random () * 18 + 412);
	    drawOval (randX, randY, 1, 1, new Color (221, 72, 8));
	}

    }

    //draws the rover in the background
    public void drawRover1 ()
    {
	//draws main body
	fillRectWithLine (165, 330, 20, 7, Color.BLACK);
	fillOvalWithLine (162, 330, 7, 6, Color.BLACK);

	//draws the rover tires
	fillOvalWithLine (168, 337, 4, 4, Color.BLACK);
	fillOvalWithLine (177, 337, 4, 4, Color.BLACK);
    }

    //draws the rover in the foreground
    public void drawRover2 ()
    {
	//draws the tires
	fillOvalWithLine (20, 420, 30, 30, Color.BLACK);
	fillOvalWithLine (80, 420, 30, 30, Color.BLACK);
	
	//draws the main rover body
	int[] x = {10, 10, 30, 50, 80, 100, 120, 120};
	int[] y = {430, 410, 400, 380, 380, 400, 410, 430};
	fillPolygonWithLine (x, y, 8, Color.GRAY);
	drawPolygon (x, y, 8, Color.BLACK);
    }

    //draws the miniature Earth at the specified coordinates
    public void drawEarth (int posX, int posY)
    {
	//draws the main Earth body filled with EARTH_BACKGROUND
	fillOvalWithLine (posX - 10, posY - 10, 20, 20, EARTH_BACKGROUND);
	
	//draws the continents (The Amerticas, Europe, and Africa)
	fillArc (posX - 8, posY - 8, 15, 8, 90, 180, MARS_EARTH);
	fillArc (posX - 7, posY - 9, 10, 18, 240, 90, MARS_EARTH);
	fillOvalWithLine (posX + 2, posY - 8, 5, 3, MARS_EARTH);
	fillOvalWithLine (posX + 5, posY - 3, 3, 8, MARS_EARTH);
    }


    //draws the background with a specified type (the subscene)
    public void drawBackground (int type)
    {
	//fills the canvas with MARS_BACKGROUND
	fillRectWithLine (0, 0, WIDTH, HEIGHT, MARS_BACKGROUND);
	
	//type one draws using drawHouse1 and drawRover1
	if (type == 1)
	{
	    drawHouse1 ();
	    drawRover1 ();
	}
	
	//draws the Mars surface
	fillOvalWithLine (-WIDTH / 8, HEIGHT - HEIGHT / 3, WIDTH + WIDTH / 4, 250, MARS_SURFACE);

	//type two draws using drawHouse2 and drawRover2
	if (type == 2)
	{
	    drawHouse2 ();
	    drawRover2 ();
	}
    }

    //drawBackground calls drawBackground with parameters
    public void drawBackground ()
    {
	drawBackground (1);
    }
}
