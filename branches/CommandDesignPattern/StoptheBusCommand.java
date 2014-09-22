

/**
 * Class represents the concrete command
 * @author bambo
 *
 */
public class StoptheBusCommand implements Command {

	Bus bus;
	
	public StoptheBusCommand(Bus bus){
		this.bus = bus;
	}
	
	@Override
	public void execute() {
		this.bus.stopTheBus();

	}

}
