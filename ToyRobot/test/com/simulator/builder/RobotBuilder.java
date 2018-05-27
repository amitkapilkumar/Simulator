package com.simulator.builder;

import com.simulator.model.Direction;
import com.simulator.model.Location;
import com.simulator.model.Robot;

public class RobotBuilder {
	private long locationX;
	private long locationY;
	private Direction direction;
	
	public RobotBuilder withLocationX(long locationX) {
		this.locationX = locationX;
		return this;
	}
	
	public RobotBuilder withLocationY(long locationY) {
		this.locationY = locationY;
		return this;
	}
	
	public RobotBuilder withDirection(Direction direction) {
		this.direction = direction;
		return this;
	}
	
	public Robot build() {
		Location location = new Location();
		location.setX(locationX);
		location.setY(locationY);
		Robot robot = new Robot();
		robot.setFacingDirection(direction);
		robot.setLocation(location);
		return robot;
	}
}
