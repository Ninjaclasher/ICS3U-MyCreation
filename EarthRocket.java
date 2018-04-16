//Ms Krasteva
//Evan Zhang
//Oct 23, 2017
//draws the earth rocket launching
import java.awt.*;
import hsa.Console;

public class EarthRocket extends Interface implements Runnable
{
    //stores the position of the rocket
    private final int CENTRE_X = WIDTH / 2, CENTRE_Y = HEIGHT / 2;
    //stores the holder of the rocket
    private RocketHolder rh;

    //Constructor to get Console and creates new RocketHolder
    EarthRocket (Console d)
    {
	super (d);
	rh = new RocketHolder (d, CENTRE_X, CENTRE_Y);
    }


    //drawRocketHolder method to call private drawHolder
    public void drawRocketHolder ()
    {
	rh.drawHolder ();
    }


    //draws the static rocket in the background
    public void drawRocket ()
    {
	//draws the main rocket body
	fillOvalWithLine (WIDTH / 2 - 40, HEIGHT / 2 - HEIGHT / 4 - 8, WIDTH / 8 - 2, HEIGHT / 4, Color.GRAY);
	fillRectWithLine (WIDTH / 2 - 40, HEIGHT / 2 - HEIGHT / 6, WIDTH / 8, HEIGHT / 6, Color.WHITE);
	fillRectWithLine (WIDTH / 2 - 40, HEIGHT / 2, WIDTH / 8, HEIGHT / 2 - HEIGHT / 12, EARTH_ROCKET_MAIN);

	//draws the rocket side boosters
	fillOvalWithLine (WIDTH / 2 - 65, HEIGHT / 2 - HEIGHT / 12 - 40, 23, 80, Color.GRAY);
	fillRectWithLine (WIDTH / 2 - 65, HEIGHT / 2 - HEIGHT / 12, 25, HEIGHT / 3 + HEIGHT / 12, Color.WHITE);
	fillOvalWithLine (WIDTH / 2 + WIDTH / 8 - 40, HEIGHT / 2 - HEIGHT / 12 - 40, 23, 80, Color.GRAY);
	fillRectWithLine (WIDTH / 2 + WIDTH / 8 - 40, HEIGHT / 2 - HEIGHT / 12, 25, HEIGHT / 3 + HEIGHT / 12, Color.WHITE);

	//draws the maple leaf in the centre of the rocket
	fillMapleLeaf (WIDTH / 2 - 30, HEIGHT / 2 - HEIGHT / 8 - HEIGHT / 32, 60, 60, Color.RED);
	//draws the bottom of the rocket booster
	for (int y = 80 ; y < 140 ; y++)
	{
	    //alternates color (black and gray) so that is is not a solid color
	    if ((y & 1) == 0)
		drawLine (WIDTH / 2 - y / 2, HEIGHT - HEIGHT / 12 - 80 + y, WIDTH / 2 + y / 2, HEIGHT - HEIGHT / 12 - 80 + y, Color.BLACK);
	    else
		drawLine (WIDTH / 2 - y / 2, HEIGHT - HEIGHT / 12 - 80 + y, WIDTH / 2 + y / 2, HEIGHT - HEIGHT / 12 - 80 + y, Color.GRAY);
	}
    }


    //draws the rocket body when needed in the animation
    public void redrawRocketBody (int lowerX, int upperX)
    {
	//swaps the x values if the lowerbound is greater than upperbound
	if (lowerX > upperX)
	{
	    int tmp = lowerX;
	    lowerX = upperX;
	    upperX = tmp;
	}
	//gets maximum of the lowerbound or side of the rocket
	int max = Math.max (WIDTH / 2 - 40, lowerX);
	//draws a secion of rocket body
	fillRect (max - 2, HEIGHT / 2, Math.min (upperX - max + 5, WIDTH / 8 + WIDTH / 2 - max - 40 + 5), HEIGHT / 2 - HEIGHT / 12, EARTH_ROCKET_MAIN);
	//draws the side rocket boosters based on the lowerbound and upperbound
	if (lowerX <= (WIDTH / 2 - 45))
	    fillRect (WIDTH / 2 - 65, HEIGHT / 2 - HEIGHT / 12, 25, HEIGHT / 3 + HEIGHT / 12, Color.WHITE);
	if (upperX >= (WIDTH / 2 + WIDTH / 8 - 15))
	    fillRect (WIDTH / 2 + WIDTH / 8 - 40, HEIGHT / 2 - HEIGHT / 12, 25, HEIGHT / 3 + HEIGHT / 12, Color.WHITE);
    }


    //run method for thread
    public void run ()
    {
	//draws the main static rocket
	drawRocket ();
	//starts rocket holder
	new Thread (rh).start ();
	//waits until the rocket holder moves a bit out of the way
	for (int x = 0 ; x < 4 ; x++)
	{
	    delay (100);
	    drawRocket ();
	}
	//launches the rocket
	for (int yy = 0 ; yy > -HEIGHT - 100 ; yy--)
	{
	    //draws the main rocket body
	    fillOval (WIDTH / 2 - 40, HEIGHT / 2 - HEIGHT / 4 - 8 + yy, WIDTH / 8, HEIGHT / 4, Color.GRAY);
	    fillRect (WIDTH / 2 - 40, HEIGHT / 2 - HEIGHT / 6 + yy, WIDTH / 8, HEIGHT / 6, Color.WHITE);
	    fillRect (WIDTH / 2 - 40, HEIGHT / 2 + yy, WIDTH / 8, HEIGHT / 2 - HEIGHT / 12, EARTH_ROCKET_MAIN);

	    //draws the side rocket boosters
	    fillOval (WIDTH / 2 - 65, HEIGHT / 2 - HEIGHT / 12 - 40 + yy, 23, 80, Color.GRAY);
	    fillRect (WIDTH / 2 - 65, HEIGHT / 2 - HEIGHT / 12 + yy, 25, HEIGHT / 3 + HEIGHT / 12, Color.WHITE);
	    fillOval (WIDTH / 2 + WIDTH / 8 - 40, HEIGHT / 2 - HEIGHT / 12 - 40 + yy, 23, 80, Color.GRAY);
	    fillRect (WIDTH / 2 + WIDTH / 8 - 40, HEIGHT / 2 - HEIGHT / 12 + yy, 25, HEIGHT / 3 + HEIGHT / 12, Color.WHITE);

	    //draws the maple leaf in the rocket
	    fillMapleLeaf (WIDTH / 2 - 30, HEIGHT / 2 - HEIGHT / 8 - HEIGHT / 32 + yy, 60, 60, Color.RED);
	    //draws the bottom of the rocket booster
	    for (int y = 80 ; y < 125 ; y++)
	    {
		//alternates colors (black and gray) so that it is not a solid color
		if ((y & 1) == 0)
		    drawLine (WIDTH / 2 - y / 2, HEIGHT - HEIGHT / 12 - 80 + y + yy, WIDTH / 2 + y / 2, HEIGHT - HEIGHT / 12 - 80 + y + yy, Color.BLACK);
		else
		    drawLine (WIDTH / 2 - y / 2, HEIGHT - HEIGHT / 12 - 80 + y + yy, WIDTH / 2 + y / 2, HEIGHT - HEIGHT / 12 - 80 + y + yy, Color.GRAY);
	    }
	    //draws the main rocket booster flames
	    for (int x = WIDTH / 2 - 50 ; x < WIDTH / 2 + 50 ; x++)
	    {
		int rand = (int) (Math.random () * 50) + 5;
		drawLine (x, HEIGHT + yy + 4, x, HEIGHT + 4 + yy + rand, Color.YELLOW);
	    }
	    //draws the side rocket booster flames
	    for (int x = 2 ; x < 23 ; x++)
	    {
		int rand = (int) (Math.random () * 30) + 5;
		drawLine (WIDTH / 2 - 65 + x, HEIGHT / 2 + yy + HEIGHT / 3, WIDTH / 2 - 65 + x, HEIGHT / 2 + yy + HEIGHT / 3 + rand, Color.ORANGE);
		drawLine (WIDTH / 2 + WIDTH / 8 - 40 + x, HEIGHT / 2 + HEIGHT / 3 + yy, WIDTH / 2 + WIDTH / 8 - 40 + x, HEIGHT / 2 + HEIGHT / 3 + yy + rand, Color.ORANGE);
	    }
	    //creates smoke from the rocket boosters
	    for (int x = 0 ; x < Math.random () * 40 ; x++)
	    {
		int randX = (int) (Math.random () * WIDTH - 20);
		fillOval (randX, HEIGHT + yy + 55 + Math.abs (WIDTH / 2 - 10 - randX), 30, 30, new Color (119, 119, 119, 100));
	    }
	    //waits a specified time that slowly decreases (as if rocket goes faster)
	    delay (Math.max (0, 50 + (int) ((double) yy / HEIGHT * 100)));
	    //clears rocket
	    fillRect (WIDTH / 2 - 65, HEIGHT / 2 - HEIGHT / 4 - 8 + yy, WIDTH / 4 - 30, HEIGHT - HEIGHT / 8 + 4, EARTH_BACKGROUND);
	}
	//fills the rest of the screen with smoke
	for (int yy = HEIGHT / 2 ; yy >= -50 ; yy--)
	{
	    for (int x = 0 ; x < Math.random () * 40 ; x++)
	    {
		int randX = (int) (Math.random () * WIDTH - 20);
		fillOval (randX, yy, 30, 30, new Color (119, 119, 119, 100));
	    }
	}
	//waits 500 milliseconds
	delay (500);
    }
}
