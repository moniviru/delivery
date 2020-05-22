package com.s4n.delivery.thread;

import java.util.List;
import java.util.stream.Collectors;

import com.s4n.delivery.dto.Delivery;
import com.s4n.delivery.dto.Order;
import com.s4n.delivery.service.DeliveryService;
import com.s4n.delivery.util.FileUtil;

public class DeliveryThread implements Runnable {

	private String file;
	private Delivery delivery;
	
	private static final String REPORT_PATH = "src/main/resources/deliveriesReport/";
	private static final String DELIVERY_PATH = "src/main/resources/deliveries/";

	public DeliveryThread(String name) {
		file = name + ".txt";
		delivery = new Delivery(scheduleOrders(), name);
	}

	@Override
	public void run() {
		DeliveryService.getInstance().process(delivery);
		generateDeliveryReport(delivery);	
	}
	
	private List<Order> scheduleOrders() {
		List<String> orders = FileUtil.getInstance().readFile(DELIVERY_PATH+file);
		return orders.stream().map(order -> {
			return new Order(order);
		}).collect(Collectors.toList());
	}
	
	private void generateDeliveryReport(Delivery delivery) {
		String path = REPORT_PATH+delivery.getDrone().getId()+delivery.getName();
		FileUtil.getInstance().writeFile(path, delivery.getReport());
	}
}
