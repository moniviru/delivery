package com.s4n.delivery.dto;

import com.s4n.delivery.constant.Orientation;

public class Location {

	private int x;
	private int y;
	private Orientation orientation;
	
	public Location() {
		x = 0;
		y = 0;
		orientation = Orientation.NORTH;
	}

	public void incrX() {
		x++;
	}
	
	public void incrY() {
		y++;
	}
	
	public void decrX() {
		x--;
	}
	
	public void decrY() {
		y--;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ") orientation " + orientation;
	}

}
