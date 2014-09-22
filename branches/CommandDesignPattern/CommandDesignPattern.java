
public class CommandDesignPattern {
	
	public static void main(String[] args) {
		Bus bus = new Bus();
		
		Command start = new StatTheBusCommand(bus);
		Command stop = new StoptheBusCommand(bus);
		
		BusOperator operator = new BusOperator();
		
		operator.setCommand(start);
		operator.operateBus();
		
		operator.setCommand(stop);
		operator.operateBus();
		
	}

}
