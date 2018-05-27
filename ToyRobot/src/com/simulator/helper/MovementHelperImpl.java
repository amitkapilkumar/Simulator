package com.simulator.helper;

import com.simulator.model.Direction;
import com.simulator.model.Robot;
import com.simulator.model.Table;

public class MovementHelperImpl implements MovementHelper {
	
	public boolean ifValidMakeTheMove(Table table, Robot robot) {
		long x = table.getDimensionX();
		long y = table.getDimensionY();
		
		switch(robot.getFacingDirection()) {
			case NORTH:
				if(robot.getLocation().getY() + 1 < y) {
					robot.getLocation().setY(robot.getLocation().getY() + 1);
					return true;
				}
				break;
			case SOUTH:
				if(robot.getLocation().getY() - 1 >= 0) {
					robot.getLocation().setY(robot.getLocation().getY() - 1);
					return true;
				}
				break;
			case EAST:
				if(robot.getLocation().getX() + 1 < x) {
					robot.getLocation().setX(robot.getLocation().getX() + 1);
					return true;
				}
				break;
			case WEST:
				if(robot.getLocation().getX() - 1 >= 0) {
					robot.getLocation().setX(robot.getLocation().getX() - 1);
					return true;
				}
				break;
		}
		return false;
	}
	
	public void turnLeft(Robot robot) {
		switch (robot.getFacingDirection()) {
			case NORTH:
				robot.setFacingDirection(Direction.WEST);
				break;
			case SOUTH:
				robot.setFacingDirection(Direction.EAST);
				break;
			case WEST:
				robot.setFacingDirection(Direction.SOUTH);
				break;
			case EAST:
				robot.setFacingDirection(Direction.NORTH);
				break;
		}
	}
	
	public void turnRight(Robot robot) {
		switch (robot.getFacingDirection()) {
			case NORTH:
				robot.setFacingDirection(Direction.EAST);
				break;
			case SOUTH:
				robot.setFacingDirection(Direction.WEST);
				break;
			case WEST:
				robot.setFacingDirection(Direction.NORTH);
				break;
			case EAST:
				robot.setFacingDirection(Direction.SOUTH);
				break;
		}
	}
}
