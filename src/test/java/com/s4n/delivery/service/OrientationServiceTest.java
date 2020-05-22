package com.s4n.delivery.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.s4n.delivery.constant.Movement;
import com.s4n.delivery.constant.Orientation;
import com.s4n.delivery.dto.Drone;
import com.s4n.delivery.mock.MockHelper;

public class OrientationServiceTest {

	@Test
	public void stepForwardTest() {
		Drone drone = MockHelper.drone1_location();
		OrientationService.getInstance().stepForward(drone);
		assertEquals(drone.getLocation().getX(), 2);
		assertEquals(drone.getLocation().getY(), 1);
		assertEquals(drone.getLocation().getOrientation(), Orientation.EAST);
	}
	
	@Test
	public void turnRightTest() {
		Drone drone = MockHelper.drone1_location();
		OrientationService.getInstance().changeOrientation(drone, Movement.D.toString());
		assertEquals(drone.getLocation().getX(), 1);
		assertEquals(drone.getLocation().getY(), 1);
		assertEquals(drone.getLocation().getOrientation(), Orientation.SOUTH);
	}
	
	@Test
	public void turnLeftTest() {
		Drone drone = MockHelper.drone1_location();
		OrientationService.getInstance().changeOrientation(drone, Movement.I.toString());
		assertEquals(drone.getLocation().getX(), 1);
		assertEquals(drone.getLocation().getY(), 1);
		assertEquals(drone.getLocation().getOrientation(), Orientation.NORTH);
	}
	
}
