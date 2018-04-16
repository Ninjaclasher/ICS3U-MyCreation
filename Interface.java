//Ms Krasteva
//Evan Zhang
//Oct 23, 2017
//Interface base class that stores all the required information and methods
//for each object to run
import java.awt.*;
import hsa.Console;

public class Interface
{
    //delcares the Console, as well as the colours of each object
    protected Console c;
    protected final int HEIGHT, WIDTH;
    protected final Color EARTH_BACKGROUND = new Color (2, 183, 255);
    protected final Color SPACE_BACKGROUND = Color.BLACK;
    protected final Color SPACE_STAR = Color.YELLOW;
    protected final Color SPACE_SUN = Color.ORANGE;
    protected final Color SPACE_MERCURY = new Color (175, 175, 175);
    protected final Color SPACE_VENUS = new Color (163, 84, 0);
    protected final Color SPACE_EARTH = new Color (72, 249, 32);
    protected final Color SPACE_MARS = new Color (137, 22, 0);
    protected final Color MARS_BACKGROUND = new Color (219, 212, 188);
    protected final Color MARS_SURFACE = new Color (201, 91, 2);
    protected final Color MARS_EARTH = new Color (72, 249, 32);
    protected final Color EARTH_ROCKET_MAIN = new Color (255, 148, 0);

    //Constructor to get Console reference
    Interface (Console d)
    {
	//assigns Console
	c = d;
	//assigns final integers for height and width of the console screen
	WIDTH = c.getWidth ();
	HEIGHT = c.getHeight ();
    }

    //delay method to allow a delay in one line instead of 3 lines
    protected void delay (int milliseconds)
    {
	try
	{
	    Thread.sleep (milliseconds);
	}
	catch (Exception e)
	{
	    //if an Exception is thrown, aborts the program
	    System.err.print ("Error detected. Aborting...");
	    System.exit (1);
	}
    }

    //fillOval for objects that are not animations (uses a for loop)
    protected void fillOvalWithLine (int x, int y, int w, int h, Color cc)
    {
	//for loop to fillOval using drawOval
	for (int xx = 0 ; xx < w ; xx++)
	{
	    drawOval (x + xx, y + xx, w - 2 * xx, h - 2 * xx, cc);
	    drawOval (x + xx + 1, y + xx + 1, w - 2 * xx, h - 2 * xx, cc);
	    drawOval (x + xx + 1, y + xx, w - 2 * xx, h - 2 * xx, cc);
	}
    }

    //fillOval method for animations
    protected void fillOval (int x, int y, int w, int h, Color cc)
    {
	synchronized (c)
	{
	    c.setColor (cc);
	    c.fillOval (x, y, w, h);
	}
    }

    //drawOval method that combines the setColor and drawOval into one method call
    protected void drawOval (int x, int y, int w, int h, Color cc)
    {
	synchronized (c)
	{
	    c.setColor (cc);
	    c.drawOval (x, y, w, h);
	}
    }

    //fillRect for objects that are not animations
    protected void fillRectWithLine (int x, int y, int w, int h, Color cc)
    {
	//for loop to fillRect with lines
	for (int xx = x ; xx < x + w ; xx++)
	    drawLine (xx, y, xx, y + h, cc);
    }

    //fillRect for animations (uses console fill method)
    protected void fillRect (int x, int y, int w, int h, Color cc)
    {
	synchronized (c)
	{
	    c.setColor (cc);
	    c.fillRect (x, y, w, h);
	}
    }

    //drawRect method that combines setColor and drawRect into one method call
    protected void drawRect (int x, int y, int w, int h, Color cc)
    {
	synchronized (c)
	{
	    c.setColor (cc);
	    c.drawRect (x, y, w, h);
	}
    }

    //fillArc for animations (uses default console fillArc method)
    protected void fillArc (int x, int y, int w, int h, int initAngle, int arcAngle, Color cc)
    {
	synchronized (c)
	{
	    c.setColor (cc);
	    c.fillArc (x, y, w, h, initAngle, arcAngle);
	}
    }

    //drawArc method that combines setColor and drawArc into one method call
    protected void drawArc (int x, int y, int w, int h, int initAngle, int arcAngle, Color cc)
    {
	synchronized (c)
	{
	    c.setColor (cc);
	    c.drawArc (x, y, w, h, initAngle, arcAngle);
	}
    }

    //fillMapleLeaf method for animations
    protected void fillMapleLeaf (int x, int y, int w, int h, Color cc)
    {
	synchronized (c)
	{
	    c.setColor (cc);
	    c.fillMapleLeaf (x, y, w, h);
	}
    }

    //drawMapleLeaf method that combines setColor and drawMapleLeaf into one method call
    protected void drawMapleLeaf (int x, int y, int w, int h, Color cc)
    {
	synchronized (c)
	{
	    c.setColor (cc);
	    c.drawMapleLeaf (x, y, w, h);
	}
    }

    //fillPolygon with drawPolygon for objects that are not animaions
    protected void fillPolygonWithLine (int[] x1, int[] y1, int numPoints, Color cc)
    {
	//makes the points doubles instead of ints
	double[] xx = new double [numPoints];
	double[] yy = new double [numPoints];
	//variables to store centre of object
	int meanX = 0, meanY = 0;
	//for loop to assign each double value and gets sum of points
	for (int x = 0 ; x < numPoints ; x++)
	{
	    xx [x] = (double) x1 [x];
	    yy [x] = (double) y1 [x];
	    meanX += x1 [x];
	    meanY += y1 [x];
	}
	//gets the mean of all points
	meanX /= numPoints;
	meanY /= numPoints;

	//stores the change of that point for each interation
	double[] [] xy = new double [2] [numPoints];

	for (int x = 0 ; x < numPoints ; x++)
	{
	    xy [0] [x] = (meanX - xx [x]) / 1000.0;
	    xy [1] [x] = (meanY - yy [x]) / 1000.0;
	}

	//for loop to draw the for loop using drawPolygon, 
	//each time moving each point closer to the centre of the polygon
	for (int x = 0 ; x < 1000 ; x++)
	{
	    drawPolygon (xx, yy, numPoints, cc);
	    //moves each point closer to the centre
	    for (int y = 0 ; y < numPoints ; y++)
	    {
		xx [y] += xy [0] [y];
		yy [y] += xy [1] [y];
	    }
	}
    }

    //drawPolygon that accepts double arrays, and converts them to integers
    //before drawing the polygon
    protected void drawPolygon (double[] x, double[] y, int numPoints, Color cc)
    {
	int[] xx = new int [numPoints], yy = new int [numPoints];
	for (int i = 0 ; i < numPoints ; i++)
	{
	    xx [i] = (int) x [i];
	    yy [i] = (int) y [i];
	}
	drawPolygon (xx, yy, numPoints, cc);
    }

    //drawPolygon that draws the polygon that combines the setColor
    //and drawPolygon into one method call
    protected void drawPolygon (int[] x, int[] y, int numPoints, Color cc)
    {
	synchronized (c)
	{
	    c.setColor (cc);
	    c.drawPolygon (x, y, numPoints);
	}
    }

    //fillPolygon for animations that uses default Console fillPolygon
    protected void fillPolygon (int[] x, int[] y, int numPoints, Color cc)
    {
	synchronized (c)
	{
	    c.setColor (cc);
	    c.fillPolygon (x, y, numPoints);
	}
    }

    //drawLine that uses the default Console drawLine
    protected void drawLine (int x, int y, int x2, int y2, Color cc)
    {
	synchronized (c)
	{
	    c.setColor (cc);
	    c.drawLine (x, y, x2, y2);
	}
    }
}
