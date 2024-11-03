package elevator_car;

import java.io.*;
import java.io.IOException; 
import java.util.logging.Logger;

import test.LoggingTest;

import java.util.logging.Level;
import java.util.logging.*; 

public class ElevatorCar {
	
	int elevatorID;
	int currentFloor;
	Status state;
	Direction dir;
	InternalButtons intBtns;
	Display display;
	// Doors :- skipped...
	// meta data... dimensions
	 public ElevatorCar(){
	        display = new Display();
	        intBtns = new InternalButtons();
	        state = Status.IDLE;
	        currentFloor = 0;
	        dir = Direction.UP;
//	        elevatorDoor = new ElevatorDoor();
	    }

	 
	private final static Logger logger =  Logger.getLogger(ElevatorCar.class.getName()); 
	
	public int getElevatorID() {
		return elevatorID;
	}
	public void setElevatorID(int elevatorID) {
		this.elevatorID = elevatorID;
	}
	public Status getstate() {
		return state;
	}
	public void setstate(Status state) {
		this.state = state;
	}
	public Direction getDir() {
		return dir;
	}
	public void setDir(Direction dir) {
		this.dir = dir;
	}
	public int getCurrentFloor() {
		return currentFloor;
	}
	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
	
	public void pressButton(int destinationFloor){
		intBtns.pressButton(destinationFloor, this);
	}
	
	public void showDisplay() {
		display.showDisplay();
	}
	
	public void setDisplay() {
		display.setDisplay(this.currentFloor, this.dir);
	}
	
	public boolean moveElevator(Direction dir, int destinationFloor) {
		
		if(this.state == Status.MAINTENANCE) {
			logger.warning("Maintenance mode on elevatorId = " + this.elevatorID);
			return false;
		}
		
		int startFloor = this.currentFloor;
		
		if(dir == Direction.UP) {
			for(int i = startFloor; i <= destinationFloor; i++) {
				this.currentFloor = i;
				setDisplay();
				showDisplay();
				if(i == destinationFloor) {
					logger.info("Destination Reached in UP Direction, curr floor = " + this.currentFloor);
					return true;
				}
			}
		}

	    if (dir == Direction.DOWN) {
	        for (int i = startFloor; i >= destinationFloor; i--) {
	            this.currentFloor = i; 
	            setDisplay();
	            showDisplay();
	            if (i == destinationFloor) {
					logger.info("Destination Reached in DOWN Direction, curr floor = " + this.currentFloor);
	                return true;
	            }
	        }
	    }
	    logger.severe("Something unexpected happend!");
	    logger.severe("dir = " + dir + " destinationFloor = " + destinationFloor);
		return false;
	}
	
}
