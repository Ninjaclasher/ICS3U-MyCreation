//Ms Krasteva
//Evan Zhang
//Oct 23, 2017
//Background class for space scene
import java.awt.*;
import hsa.Console;

public class SpaceBackground extends Background
{
    //gets Console reference
    SpaceBackground (Console d)
    {
	//calls super class
	super (d);
    }

    //drawBackground method to draw the main background
    public void drawBackground ()
    {
	//fills the canvas with SPACE_BACKGROUND colour (black)
	fillRectWithLine (0, 0, WIDTH, HEIGHT, SPACE_BACKGROUND);
	//draws the stars using randomly generated x and y coordinates
	for (int x = 0 ; x < 400 ; x++)
	{
	    //gets random position
	    int posX = (int) (Math.random () * WIDTH);
	    int posY = (int) (Math.random () * HEIGHT);
	    //draws the stars using SPACE_STAR colour
	    fillOvalWithLine (posX, posY, 2, 2, SPACE_STAR);
	}
    }
}
