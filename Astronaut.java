//Ms Krasteva
//Evan Zhang
//Oct 23, 2017
//OVERLOADED Astronaut class that draws three astronauts
import java.awt.*;
import hsa.Console;

public class Astronaut extends Interface implements Runnable
{
    //sets default variables that can be overloaded in the constructor
    private int x = WIDTH / 2, y = HEIGHT / 2, direction = 0;
    private Color mainColour = Color.WHITE;
    private EarthRocket rocket;
    //Basic constructor that gets Console reference
    Astronaut (Console d)
    {
	super (d);
    }


    //Constructor that gets Console and the position of the Astronaut
    Astronaut (Console d, int x, int y)
    {
	super (d);
	this.x = x;
	this.y = y;
    }


    //Constructor that gets Console, position, and the direction it is facing
    Astronaut (Console d, int x, int y, int direction)
    {
	super (d);
	this.x = x;
	this.y = y;
	this.mainColour = mainColour;
    }


    //Constructor that gets Console, position, direction, and the color of the rocket
    Astronaut (Console d, int x, int y, int direction, Color mainColour)
    {
	super (d);
	this.x = x;
	this.y = y;
	this.direction = direction;
	this.mainColour = mainColour;
    }


    //draws the helmet of the astronaut and the arm
    private void drawHelmetAndArm ()
    {
	//draws the helmet
	fillOval (x - 30, y, 70, 70, mainColour);
	drawOval (x - 30, y, 70, 70, Color.BLACK);
	fillOval (x - 20, y + 10, 50, 50, mainColour);
	drawOval (x - 20, y + 10, 50, 50, Color.BLACK);
	//draws the arm with a mapleleaf
	fillMapleLeaf (x - 5, y - 25, 20, 20, Color.RED);
	fillRect (x - 10, y, 30, 80, mainColour);
	drawLine (x - 10, y - 20, x - 10, y + 80, Color.BLACK);
	drawLine (x + 20, y - 20, x + 20, y + 80, Color.BLACK);
	drawArc (x - 13, y + 68, 36, 45, 157, 235, Color.BLACK);
    }


    //draws the body of the astronaut
    protected void drawBody ()
    {
	fillRect (x - 15, y - 40, 50, 110, mainColour);
	drawRect (x - 15, y - 40, 50, 110, Color.BLACK);
    }


    //draws the main astronaut
    public void drawAstronaut ()
    {
	//if facing right
	if (direction == 0)
	{
	    //draws the face of the astronaut
	    fillOvalWithLine (x - 10, y - 95, 45, 60, new Color (201, 91, 2));
	    drawOval (x + 17, y - 78, 10, 5, Color.BLACK);
	    fillOval (x + 21, y - 78, 5, 5, Color.BLACK);
	    //draws main body
	    drawBody ();
	    //draws the legs and backpack of the astronaut
	    fillRectWithLine (x - 15, y + 70, 40, 100, mainColour);
	    fillRectWithLine (x - 15, y + 170, 60, 30, mainColour);
	    fillRectWithLine (x - 50, y - 20, 35, 80, mainColour);
	    drawRect (x - 15, y + 70, 40, 100, Color.BLACK);
	    drawRect (x - 15, y + 170, 60, 30, Color.BLACK);
	    drawRect (x - 50, y - 20, 35, 80, Color.BLACK);
	    //draws the arm holding the helmet
	    drawHelmetAndArm ();

	}
	//if facing left
	else if (direction == 1)
	{
	    //draws the face of the astronaut
	    fillOvalWithLine (x - 15, y - 95, 45, 60, new Color (255, 223, 196));
	    drawOval (x - 5, y - 78, 10, 5, Color.BLACK);
	    fillOval (x - 3, y - 78, 5, 5, Color.BLUE);

	    //draws main body of the astronaut
	    drawBody ();

	    //draws backpack and legs of the astronaut
	    fillRectWithLine (x - 5, y + 70, 40, 100, mainColour);
	    fillRectWithLine (x - 25, y + 170, 60, 30, mainColour);
	    fillRectWithLine (x + 35, y - 20, 35, 80, mainColour);
	    drawRect (x - 5, y + 70, 40, 100, Color.BLACK);
	    drawRect (x - 25, y + 170, 60, 30, Color.BLACK);
	    drawRect (x + 35, y - 20, 35, 80, Color.BLACK);
	}
    }


    //draws the hand of the astronaut at specified position while animating
    private void drawHand (int posX, int posY, Color cc)
    {
	int[] xx = {posX, posX, x, x};
	int[] yy = {posY, posY + 20, y, y - 20};
	//draws the arm using a polygon
	fillPolygon (xx, yy, 4, cc);
	//draws the outline of the arm
	drawLine (posX, posY, x, y - 20, Color.BLACK);
	drawLine (posX, posY + 20, x, y, Color.BLACK);
	//draws the hand of the astronaut
	fillOval (posX - 15, posY, 30, 20, cc);
	//draws the maple leaf on the arm
	fillMapleLeaf (x, y - 25, 20, 20, Color.RED);
    }


    //set the rocket in the background
    public void setRocket (EarthRocket r)
    {
	this.rocket = r;
    }


    //run method for thread
    public void run ()
    {

	//gets the direction of movement based on which direction the astronaut
	//is facing
	int modifier = (direction == 1 ? -1 : 1);
	//gets start position based on which direction the astronaut is facing
	int start = direction * 180;
	//gets end position based on the start position
	int end = start + modifier * 17;
	//animates the arm
	for (int c = 0, i = start ; c < 5 ; i += modifier)
	{
	    //gets position of endpoint of arm
	    int xx = (int) Math.round (Math.cos (Math.toRadians (i)) * (125 + direction * 20) + x);
	    int yy = (int) Math.round (Math.sin (Math.toRadians (i)) * 135 + y);
	    //draws the hand
	    drawHand (xx, yy, mainColour);
	    //covers up hand if facing right
	    if (direction == 0)
	    {
		drawBody ();
		drawHelmetAndArm ();
	    }
	    //reverse direction of the arm movement
	    if (i == end)
	    {
		int tmp = start;
		start = end;
		end = tmp;
		modifier = -modifier;
		c++;
	    }
	    //waits 55 milliseconds
	    delay (55);
	    //clears arm
	    if (direction != 0)
	    {
		drawBody ();
		fillRect (x - 60, y - 50, 45, 100, EARTH_BACKGROUND);
	    }
	    else
		fillRect (x + 30, y - 20, 45, 100, EARTH_BACKGROUND);
	    rocket.redrawRocketBody (x, xx);
	}
    }
}
