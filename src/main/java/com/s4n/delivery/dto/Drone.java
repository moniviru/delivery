package com.s4n.delivery.dto;

import com.s4n.delivery.constant.DroneStatus;

public class Drone {

	private String id;	
	private Location location;
	private DroneStatus status;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public DroneStatus getStatus() {
		return status;
	}
	public void setStatus(DroneStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Drone [id=" + id + ", location=" + location + ", status=" + status + "]";
	}
}
