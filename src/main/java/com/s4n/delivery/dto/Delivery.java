package com.s4n.delivery.dto;

import java.util.ArrayList;
import java.util.List;

public class Delivery {
	
	private String name;
	private Drone drone;
	private List<Order> orders;	
	private List<String> report;

	public Delivery(List<Order> orders, String name) {
		this.name = name;
		this.orders = orders;		
		initReport();
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Drone getDrone() {
		return drone;
	}

	public void setDrone(Drone drone) {
		this.drone = drone;
	}
	
	public List<String> getReport() {
		return report;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void initReport() {
		this.report = new ArrayList<String>();
	}	

	@Override
	public String toString() {
		return "Track [orders=" + orders + ", drone=" + drone + "]";
	}

}
