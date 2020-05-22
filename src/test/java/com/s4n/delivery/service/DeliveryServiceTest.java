package com.s4n.delivery.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import com.s4n.delivery.constant.DroneStatus;
import com.s4n.delivery.constant.Status;
import com.s4n.delivery.dto.Delivery;
import com.s4n.delivery.mock.MockHelper;

public class DeliveryServiceTest {
	
	@Test
	public void instancesAreEqualsTest() {
		DeliveryService service1 = DeliveryService.getInstance();
		DeliveryService service2 = DeliveryService.getInstance();
		assertEquals(service1, service2);
	}
	
	@Test
	public void verifyDeliveryReportInChallengeTest() {
		Delivery delivery = new Delivery(MockHelper.orderList1_threeOrders(), "delivery1");
		DeliveryService.getInstance().process(delivery);

		//Delivery
		assertEquals(delivery.getReport().size(), 3);
		//The Challenge said: |(-2, 4) dirección Norte| but It's not true.
		assertNotSame(delivery.getReport().get(0),"(-2,4) orientation NORTH");
		//The orientation is WEST
		assertEquals(delivery.getReport().get(0),"(-2,4) orientation WEST");
	}

	@Test
	public void processThreeOrdersTest() {
		Delivery delivery = new Delivery(MockHelper.orderList1_threeOrders(), "delivery1");
		DeliveryService.getInstance().process(delivery);
		
		//Drone
		assertEquals(delivery.getDrone().getStatus(), DroneStatus.FREE);		
		
		//Orders
		delivery.getOrders().forEach(order->{
			assertEquals(order.getStatus(), Status.DELIVERED);
		});
		
		//Delivery
		assertEquals(delivery.getReport().size(), 3);
		assertEquals(delivery.getReport().get(0),"(-2,4) orientation WEST");
		assertEquals(delivery.getReport().get(1),"(-1,3) orientation SOUTH");
		assertEquals(delivery.getReport().get(2),"(0,0) orientation WEST");
	}
	
	@Test
	public void processFiveOrdersTest() {
		Delivery delivery = new Delivery(MockHelper.orderList1_fiveOrders(), "delivery1");
		DeliveryService.getInstance().process(delivery);
		
		//Drone
		assertEquals(delivery.getDrone().getStatus(), DroneStatus.FREE);		
		
		//Orders
		delivery.getOrders().forEach(order->{
			assertEquals(order.getStatus(), Status.DELIVERED);
		});
		
		//Delivery
		assertEquals(delivery.getReport().size(), 5);
		assertEquals(delivery.getReport().get(0),"(-2,4) orientation WEST");
		assertEquals(delivery.getReport().get(1),"(-1,3) orientation SOUTH");
		assertEquals(delivery.getReport().get(2),"(0,0) orientation WEST");
		assertEquals(delivery.getReport().get(3),"(5,0) orientation EAST");
		assertEquals(delivery.getReport().get(4),"(5,6) orientation NORTH");
	}
	
	@Test
	public void processTwoOrdersTest() {
		Delivery delivery = new Delivery(MockHelper.orderList2_twoOrders(), "delivery1");
		DeliveryService.getInstance().process(delivery);
		
		//Drone
		assertEquals(delivery.getDrone().getStatus(), DroneStatus.FREE);		
		
		//Orders
		delivery.getOrders().forEach(order->{
			assertEquals(order.getStatus(), Status.DELIVERED);
		});
		
		//Delivery
		assertEquals(delivery.getReport().size(), 2);
		assertEquals(delivery.getReport().get(0),"(0,-5) orientation SOUTH");
		assertEquals(delivery.getReport().get(1),"(6,-5) orientation EAST");
	}
	
	@Test
	public void processThreeOrdersWithDifferentNumberOfMovementsTest() {
		Delivery delivery = new Delivery(MockHelper.orderList3_threeOrders_differentsNumberOfMovements(), "delivery1");
		DeliveryService.getInstance().process(delivery);
		
		//Drone
		assertEquals(delivery.getDrone().getStatus(), DroneStatus.FREE);		
		
		//Orders
		delivery.getOrders().forEach(order->{
			assertEquals(order.getStatus(), Status.DELIVERED);
		});
		
		//Delivery
		assertEquals(delivery.getReport().size(), 3);
		assertEquals(delivery.getReport().get(0),"(0,-7) orientation WEST");
		assertEquals(delivery.getReport().get(1),"(0,-8) orientation SOUTH");
		assertEquals(delivery.getReport().get(2),"(2,-8) orientation EAST");
	}
	
}
