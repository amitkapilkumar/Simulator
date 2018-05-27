package com.simulator.factory;

import com.simulator.RobotSimulator;
import com.simulator.helper.MovementHelperImpl;
import com.simulator.io.InstructionParserImpl;
import com.simulator.model.Robot;
import com.simulator.util.PrintUtilityImpl;

public class RobotSimulatorFactory {
	private static RobotSimulator robotSimulator;
	
	public static RobotSimulator getRobotSimulator() {
		if(robotSimulator == null) {
			robotSimulator = new RobotSimulator();
			robotSimulator.setInstructionParser(new InstructionParserImpl());
			robotSimulator.setMovementHelper(new MovementHelperImpl());
			robotSimulator.setPrintUtility(new PrintUtilityImpl());
			robotSimulator.setRobot(new Robot());
		}
		return robotSimulator;
	}
}
