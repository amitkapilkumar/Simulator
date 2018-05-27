package com.simulator.util;

import com.simulator.model.Robot;

public class PrintUtilityImpl implements PrintUtility {

	@Override
	public void printInput(String in) {
		System.out.println(in);
		
	}

	@Override
	public void printReport(Robot robot) {
		System.out.println("\tOutput: " + robot.getLocation().getX() + ", " + robot.getLocation().getY() + 
				", " + robot.getFacingDirection());
	}

}
