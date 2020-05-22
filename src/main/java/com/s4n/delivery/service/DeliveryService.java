package com.s4n.delivery.service;

import java.util.Arrays;

import com.s4n.delivery.constant.Movement;
import com.s4n.delivery.constant.Status;
import com.s4n.delivery.dto.Delivery;

public class DeliveryService {

	private static DeliveryService deliveryService = null;

	private DeliveryService() {
	}
	
	public void process(Delivery delivery) {
		startDelivery(delivery);

		delivery.getOrders().forEach(order -> {
			order.setStatus(Status.IN_DELIVERY);
			
			System.out.println("["+delivery.getDrone().getId()+"-"+delivery.getName()+"] Order in delivery: "+order.getNumber());
			
			String[] movements = order.getRoute().split("");
			Arrays.stream(movements).forEach(movement -> {
				if (movement.equals(Movement.A.toString())) {
					OrientationService.getInstance().stepForward(delivery.getDrone());
				} else {
					OrientationService.getInstance().changeOrientation(delivery.getDrone(), movement);
				}
			});
			order.setStatus(Status.DELIVERED);
			delivery.getReport().add((delivery.getDrone().getLocation().toString()));
			
			System.out.println("["+delivery.getDrone().getId()+"-"+delivery.getName()+"] Order delivered: "+order.getNumber() + " Drone Location: "+delivery.getDrone().getLocation().toString());
		});

		endDelivery(delivery);
	}

	public synchronized void startDelivery(Delivery delivery) {
		delivery.setDrone(DroneService.getInstance().getAvailable());
		System.out.println("["+delivery.getDrone().getId()+"-"+delivery.getName()+"] Start Delivery");
	}

	private void endDelivery(Delivery delivery) {
		DroneService.getInstance().free(delivery.getDrone());
		System.out.println("["+delivery.getDrone().getId()+"-"+delivery.getName()+"] End Delivery");
	}
	
	public static DeliveryService getInstance() {
		if (deliveryService == null) {
			synchronized (DeliveryService.class) {
				if (deliveryService == null) {
					if (deliveryService == null) {
						deliveryService = new DeliveryService();
					}
				}
			}
		}
		return deliveryService;
	}
}
