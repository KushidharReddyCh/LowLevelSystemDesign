package elevator_car;
import java.util.List;

// create interface for it... some bloddy pattern
public class ExternalDispatcher {
	
	List<ElevatorController>  elevatorControllerList = ElevatorCreater.elevatorControllerList;

	public void submitExternalRequest(int floor, Direction direction){
	//for simplicity, i am following even odd,
		for(ElevatorController elevatorController : elevatorControllerList) {
			int elevatorID = elevatorController.elevatorCar.elevatorID;
			
	        if (elevatorID%2 == 1 && floor%2 == 1){
	        	elevatorController.submitExternalRequest(floor,direction);
	        	
	        }else if(elevatorID%2 == 0 && floor%2 == 0){
	        	
	        	elevatorController.submitExternalRequest(floor,direction);
	        }
	        
		}
	}
}
