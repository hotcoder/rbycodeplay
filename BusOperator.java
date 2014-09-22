

/**
 * He is invoker of the commands 
 * For Example he has in our case in his Control Panel Only One Button , which operates both as to start the and stop the bus
 * 
 * 
 * @author bambo
 *
 */
public class BusOperator {
	
	private Command command;

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void operateBus()
	{
		command.execute();
	}
	
	
	
	

}
