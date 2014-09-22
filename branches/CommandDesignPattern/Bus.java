

/***
 * This class is the receiver , who knows what to do when "start the bus"  command raised and similarly "stop the bus
 * command" raised 
 * @author bambo
 *
 */
public class Bus {
	
	boolean busEngStatus;
	
	public void startTheBus()
	{
		System.out.println("Bus Running");
		busEngStatus= true;
	}

	
	public void stopTheBus(){
		System.out.println("Bus Stopped");
		busEngStatus = false;
	}
}
