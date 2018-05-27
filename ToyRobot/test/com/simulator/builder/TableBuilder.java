package com.simulator.builder;

import com.simulator.model.Table;

public class TableBuilder {
	private long dimensionX;
	private long dimensionY;
	
	public TableBuilder withDimensionX(long dimensionX) {
		this.dimensionX = dimensionX;
		return this;
	}
	
	public TableBuilder withDimensionY(long dimensionY) {
		this.dimensionY = dimensionY;
		return this;
	}
	
	public Table build() {
		Table table = new Table(dimensionX, dimensionY);
		return table;
	}
	
}
