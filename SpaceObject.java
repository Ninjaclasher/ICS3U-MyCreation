//Ms Krasteva
//Evan Zhang
//Oct 23, 2017
//Space object base class in which every object in the space scene is derived
//from. This extends another class that contains all the draw commands, and 
//this class also implements the Runnable interface for threads
import java.awt.*;
import hsa.Console;

public abstract class SpaceObject extends Interface implements Runnable
{
    //variables to store the information for each space object
    protected int rotateSpeed, size, distance;
    //boolean to store when a stop command is called
    protected boolean stopThread;
    //Constructor to get Console reference, as well as info about the derived object
    SpaceObject (Console d, int rS, int sS, int dS)
    {
	//calls super class
	super (d);
	//assigns variables
	rotateSpeed = rS;
	size = sS;
	distance = dS;
	stopThread = false;
    }

    //guarantees derived classes have run method()
    abstract public void run ();
    
    //stop method to stop the thread
    public void stop ()
    {
	stopThread = true;
    }
}
