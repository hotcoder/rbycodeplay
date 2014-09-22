
public class StatTheBusCommand implements Command {

	Bus bus;
	
	public StatTheBusCommand(Bus bus){
		this.bus = bus;
	}
	
	@Override
	public void execute() {
		this.bus.startTheBus();

	}

}
