package com.simulator.model;

import static com.simulator.util.Constants.DEFAULT_DIMNESION;

public class Table {
	private long dimensionX;
	private long dimensionY;
	
	public Table() {
		dimensionX = DEFAULT_DIMNESION;
		dimensionY = DEFAULT_DIMNESION;
	}
	
	public Table(long dimensionX, long dimensionY) {
		this.dimensionX = dimensionX;
		this.dimensionY = dimensionY;
	}
	
	public long getDimensionX() {
		return dimensionX;
	}
	
	public void setDimensionX(long dimensionX) {
		this.dimensionX = dimensionX;
	}
	
	public long getDimensionY() {
		return dimensionY;
	}
	
	public void setDimensionY(long dimensionY) {
		this.dimensionY = dimensionY;
	}

}