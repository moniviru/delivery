package com.s4n.delivery.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.s4n.delivery.constant.DroneStatus;
import com.s4n.delivery.constant.Orientation;
import com.s4n.delivery.dto.Drone;

public class DroneServiceTest {
	
	@Test
	public void instancesAreEqualsTest() {
		DroneService service1 = DroneService.getInstance();
		DroneService service2 = DroneService.getInstance();
		assertEquals(service1, service2);
	}

	@Test
	public void getAvailableDroneTest() {
		Drone drone = DroneService.getInstance().getAvailable();
		assertEquals(drone.getStatus(), DroneStatus.BUSY);
		DroneService.getInstance().free(drone);
	}
	
	@Test
	public void freeDroneTest() {
		Drone drone = DroneService.getInstance().getAvailable();
		DroneService.getInstance().free(drone);
		
		assertEquals(drone.getStatus(), DroneStatus.FREE);
		assertEquals(drone.getLocation().getX(),0);
		assertEquals(drone.getLocation().getY(),0);
		assertEquals(drone.getLocation().getOrientation(),Orientation.NORTH);
	}
	
}
