//Ms Krasteva
//Evan Zhang
//Oct 23, 2017
//Background base class that is inherited for all background classes (scenes)
import java.awt.*;
import hsa.Console;

public abstract class Background extends Interface
{
    //Constructor to get Console reference
    Background (Console d)
    {
	super (d);
    }

    //provides a guarantee that all background classes have a drawBackground method
    abstract public void drawBackground ();
}
