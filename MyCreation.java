//Ms Krasteva
//Evan Zhang
//Oct 23, 2017
//MyCreation driver class that runs the whole project
import java.awt.*;
import hsa.Console;

public class MyCreation
{
    //declares all the objects in the project
    private Console c;
    private EarthBackground eb;
    private Astronaut a1, a2, a3;
    private EarthRocket er;
    private SpaceBackground sb;
    private SpaceRocket sr;
    private Sun s;
    private Earth e;
    private Mars m;
    private Venus v;
    private Mercury me;
    private MarsBackground mb;
    private MarsRocket mr;
    private InflatableHouse ih;

    //Constructor to instantiates each object as well as Console
    public MyCreation ()
    {
	c  = new Console ("Journey to Mars");
	eb = new EarthBackground (c);
	er = new EarthRocket (c);
	a1 = new Astronaut (c, 180, 300);
	a2 = new Astronaut (c, 440, 300, 1, Color.GRAY);
	a3 = new Astronaut (c, 100, 200, 3);
	sb = new SpaceBackground (c);
	sr = new SpaceRocket (c);
	s  = new Sun (c);
	e  = new Earth (c);
	m  = new Mars (c);
	v  = new Venus (c);
	me = new Mercury (c);
	mb = new MarsBackground(c);
	mr = new MarsRocket(c);
	ih = new InflatableHouse (c);
    }
    
    //Scene 1 (Earth scene)
    public void scene1()
    {
	//draws Earth background
	eb.drawBackground ();
	//draws Earth sun
	eb.drawSun (540, 70, Color.YELLOW);
	//draws two earth clouds
	eb.drawCloud (500, 120, new Color (119, 119, 119));
	eb.drawCloud (100, 80, Color.GRAY);
	//draws the rocket holder
	er.drawRocketHolder ();
	//draws the rocket
	er.drawRocket ();
	//draws the two astronauts
	a1.drawAstronaut ();
	a2.drawAstronaut ();
	//sets the rocket
	a1.setRocket(er);
	a2.setRocket(er);
	//creates threads for each astronaut
	Thread a1T = new Thread (a1);
	Thread a2T = new Thread (a2);
	//runs each thread (astronauts begin shaking hands)
	a1T.start ();
	a2T.start ();
	//waits until each thread finishes before continuing
	try
	{
	    a1T.join ();
	    a2T.join ();
	}
	catch (Exception e) {}
	//redraws the backgorund for subscene 2
	eb.drawBackground ();
	//draws sun at different position
	eb.drawSun (100, 80, new Color(255, 236, 28));
	//draws cloud at different position
	eb.drawCloud (550, 180, new Color (186, 191, 198));
	//draws rocket holder and rocket
	er.drawRocketHolder ();
	er.drawRocket ();
	//creates a thread for the rocket
	Thread erT = new Thread (er);
	//launches the rocket
	erT.start ();
	//wait until the rocket finished launching
	try { erT.join (); }
	catch (Exception e) {}    
    }
    
    //Scene 2 (Space scene)
    public void scene2()
    {
	//draws the background
	sb.drawBackground ();
	//creates threads for each space object
	Thread sT = new Thread (s);
	Thread srT = new Thread (sr);
	Thread eT = new Thread (e);
	Thread mT = new Thread (m);
	Thread vT = new Thread (v);
	Thread meT = new Thread (me);
	//starts each thread so that planets begin spinning
	sT.start ();
	srT.start ();
	eT.start ();
	mT.start ();
	vT.start ();
	meT.start ();
	//waits until the space rocket arrives at Mars from Earth
	try { srT.join(); }
	catch (Exception e){}
	//stops all the threads
	sT.stop ();
	eT.stop ();
	mT.stop ();
	vT.stop ();
	meT.stop ();
    }

    //Scene 3 (Mars scene)
    public void scene3 ()
    {
	//creates mars rocket thread
	Thread mrT = new Thread(mr);
	//draws background
	mb.drawBackground(1);
	//draws the sun
	mb.drawSun(570,60);
	//draws a crater in the surface of Mars
	mb.drawCrater(450,310);
	//starts the rocket descent
	mrT.start();
	//waits until rocket lands
	try { mrT.join(); }
	catch (Exception e){}
	
	//redraws the background for subscene 2
	mb.drawBackground(2);
	//draws the sun
	mb.drawSun(78,78);
	//draws the miniature Earth
	mb.drawEarth(580,60);
	//starts the inflatable house pressurizing
	ih.start(); 
	//waits until the inflatable house finishes
	try { ih.join(); }
	catch (Exception e){}
    }

    //static main method to begin the animations
    public static void main (String[] argv)
    {
	//create MyCreation object
	MyCreation mc = new MyCreation ();
	//runs each scene
	mc.scene1();
	mc.scene2();
	mc.scene3();
    }
}
