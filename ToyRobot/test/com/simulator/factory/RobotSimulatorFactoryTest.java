package com.simulator.factory;

import org.junit.Assert;
import org.junit.Test;

import com.simulator.RobotSimulator;

public class RobotSimulatorFactoryTest {
	
	@Test
	public void testGetRobotSimulator() {
		RobotSimulator robotSimulator = RobotSimulatorFactory.getRobotSimulator();
		
		Assert.assertNotNull(robotSimulator);
		Assert.assertEquals(robotSimulator, RobotSimulatorFactory.getRobotSimulator());

	}

}
