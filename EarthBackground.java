//Ms Krasteva
//Evan Zhang
//Oct 23, 2017
//draws the earth background (scene 1)
import java.awt.*;
import hsa.Console;

public class EarthBackground extends Background
{
    //Constructor to get Console reference
    EarthBackground (Console d)
    {
	super (d);
    }

    //draws the main background without objects
    public void drawBackground ()
    {
	//fill the canvas with EARTH_BACKGROUND
	fillRectWithLine (0, 0, WIDTH, HEIGHT, EARTH_BACKGROUND);
	//draws the two side green bushes 
	fillOvalWithLine (-105, HEIGHT - 105, 210, 210, Color.GREEN);
	fillOvalWithLine (WIDTH - 105, HEIGHT - 105, 210, 210, new Color (0, 175, 14));
	//displays my name and the course code in black
	c.setFont (new Font ("calibri", Font.BOLD, 17));
	c.setColor (Color.BLACK);
	c.drawString ("Evan Zhang", WIDTH - 88, HEIGHT - 30);
	c.setFont (new Font ("calibri", Font.BOLD, 20));
	c.drawString ("ICS3U3", 10, HEIGHT - 25);
    }

    //draws a cloud at the specified coordinate with the specified color
    public void drawCloud (int x, int y, Color cc)
    {
	fillOvalWithLine (x - 70, y - 45, 40, 40, cc);
	fillOvalWithLine (x - 40, y - 50, 50, 50, cc);
	fillOvalWithLine (x, y - 50, 50, 50, cc);
	fillOvalWithLine (x + 40, y - 50, 50, 50, cc);
	fillOvalWithLine (x + 80, y - 45, 40, 40, cc);
    }

    //draws a sun at the specified cooredinate with the specified color
    public void drawSun (int x, int y, Color cc)
    {
	fillOvalWithLine (x - 20, y - 20, 40, 40, cc);
    }
}
