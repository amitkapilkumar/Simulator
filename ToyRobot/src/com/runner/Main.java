package com.runner;

import com.simulator.RobotSimulator;
import com.simulator.factory.RobotSimulatorFactory;

public class Main {
	public static void main(String[] args) {
		RobotSimulator robotSimulator = RobotSimulatorFactory.getRobotSimulator();
		try {
			if(args.length > 1) {
				robotSimulator.parseAndExecuteInstruction(args[0], Long.parseLong(args[1]), Long.parseLong(args[2]));
			}
			else {
				robotSimulator.parseAndExecuteInstruction(args[0]);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}