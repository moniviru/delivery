package com.s4n.delivery.service;

import com.s4n.delivery.constant.Movement;
import com.s4n.delivery.constant.Orientation;
import com.s4n.delivery.dto.Drone;

public class OrientationService {

	private static OrientationService orientationService = null;

	private OrientationService() {
	}

	public void stepForward(Drone drone) {
		if(drone.getLocation().getOrientation().equals(Orientation.NORTH)) {
			drone.getLocation().incrY();
		}else if(drone.getLocation().getOrientation().equals(Orientation.SOUTH)) {
			drone.getLocation().decrY();
		}else if(drone.getLocation().getOrientation().equals(Orientation.EAST)) {
			drone.getLocation().incrX();
		}else if(drone.getLocation().getOrientation().equals(Orientation.WEST)) {
			drone.getLocation().decrX();
		}
	}
	
	public void changeOrientation(Drone drone, String step) {
		if(step.equals(Movement.D.toString())) {
			drone.getLocation().setOrientation(turnRight(drone.getLocation().getOrientation()));
		}else if(step.equals(Movement.I.toString())){
			drone.getLocation().setOrientation(turnLeft(drone.getLocation().getOrientation()));
		}
	}

	private Orientation turnLeft(Orientation orientation) {
		Orientation newOrientation = null;
		if (orientation.equals(Orientation.NORTH)) {
			newOrientation = Orientation.WEST;
		} else if (orientation.equals(Orientation.WEST)) {
			newOrientation = Orientation.SOUTH;
		} else if (orientation.equals(Orientation.SOUTH)) {
			newOrientation = Orientation.EAST;
		} else if (orientation.equals(Orientation.EAST)) {
			newOrientation = Orientation.NORTH;
		}
		return newOrientation;
	}

	private Orientation turnRight(Orientation orientation) {
		Orientation newOrientation = null;
		if (orientation.equals(Orientation.NORTH)) {
			newOrientation = Orientation.EAST;
		} else if (orientation.equals(Orientation.EAST)) {
			newOrientation = Orientation.SOUTH;
		} else if (orientation.equals(Orientation.SOUTH)) {
			newOrientation = Orientation.WEST;
		} else if (orientation.equals(Orientation.WEST)) {
			newOrientation = Orientation.NORTH;
		}
		return newOrientation;
	}
	
	public static OrientationService getInstance() {
		if (orientationService == null) {
			synchronized (OrientationService.class) {
				if(orientationService == null) {
					orientationService = new OrientationService();
				}
			}			
		}
		return orientationService;
	}
}
