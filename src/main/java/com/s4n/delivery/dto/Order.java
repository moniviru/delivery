package com.s4n.delivery.dto;

import com.s4n.delivery.constant.Status;

public class Order {

	private int number;
	private String route;
	private Status status;

	public Order(String route) {
		this.route = route;
		this.number = (int)(Math.random() * 999) + 1;
		this.status = Status.PENDING;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [number=" + number + ", route=" + route + ", status=" + status + "]";
	}
}
