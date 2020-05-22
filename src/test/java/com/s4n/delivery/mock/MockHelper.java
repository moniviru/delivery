package com.s4n.delivery.mock;

import java.util.ArrayList;
import java.util.List;

import com.s4n.delivery.constant.Orientation;
import com.s4n.delivery.dto.Drone;
import com.s4n.delivery.dto.Location;
import com.s4n.delivery.dto.Order;

public class MockHelper {

	public static List<Order> orderList1_threeOrders(){
		List<Order> orders = new ArrayList<Order>();
		orders.add(new Order("AAAAIAA"));
		orders.add(new Order("DDDAIAD"));
		orders.add(new Order("AAIADAD"));
		return orders;
	}
	
	public static List<Order> orderList1_fiveOrders(){
		List<Order> orders = new ArrayList<Order>();
		orders.add(new Order("AAAAIAA"));
		orders.add(new Order("DDDAIAD"));
		orders.add(new Order("AAIADAD"));
		orders.add(new Order("DDAAAAA"));
		orders.add(new Order("IAAAAAA"));
		return orders;
	}
	
	public static List<Order> orderList2_twoOrders(){
		List<Order> orders = new ArrayList<Order>();
		orders.add(new Order("DDAAAAA"));
		orders.add(new Order("IAAAAAA"));
		return orders;
	}
	
	public static List<Order> orderList3_threeOrders_differentsNumberOfMovements(){
		List<Order> orders = new ArrayList<Order>();
		orders.add(new Order("DDAAAAAIAADAAIIIAA"));
		orders.add(new Order("IA"));
		orders.add(new Order("DDDAA"));
		return orders;
	}
	
	public static Drone drone1_location() {
		Drone drone = new Drone();
		drone.setLocation(location1());
		return drone;
	}
	
	public static Location location1() {
		Location location = new Location();
		location.setX(1);
		location.setY(1);
		location.setOrientation(Orientation.EAST);
		return location;
	}
}
