package com.simulator.helper;

import org.junit.Before;
import org.junit.Test;

import com.simulator.builder.RobotBuilder;
import com.simulator.builder.TableBuilder;
import com.simulator.model.Direction;
import com.simulator.model.Robot;
import com.simulator.model.Table;

import junit.framework.Assert;

public class MovementHelperImplTest {
	private MovementHelperImpl movementHelperImpl;
	
	@Before
	public void setup() {
		movementHelperImpl = new MovementHelperImpl();
	}

	@Test
	public void testIfValidMakeTheMoveWithStartingNorthFace() {
		Table table = new TableBuilder().withDimensionX(5).withDimensionY(5).build();
		Robot robot = new RobotBuilder().withLocationX(2).withLocationY(2).withDirection(Direction.NORTH).build();
		Assert.assertTrue(movementHelperImpl.ifValidMakeTheMove(table, robot));
		Assert.assertTrue(movementHelperImpl.ifValidMakeTheMove(table, robot));
		Assert.assertFalse(movementHelperImpl.ifValidMakeTheMove(table, robot));
	}
	
	@Test
	public void testIfValidMakeTheMoveWithStartingSouthFace() {
		Table table = new TableBuilder().withDimensionX(5).withDimensionY(5).build();
		Robot robot = new RobotBuilder().withLocationX(2).withLocationY(2).withDirection(Direction.SOUTH).build();
		Assert.assertTrue(movementHelperImpl.ifValidMakeTheMove(table, robot));
		Assert.assertTrue(movementHelperImpl.ifValidMakeTheMove(table, robot));
		Assert.assertFalse(movementHelperImpl.ifValidMakeTheMove(table, robot));
	}
	
	@Test
	public void testIfValidMakeTheMoveWithStartingEastFace() {
		Table table = new TableBuilder().withDimensionX(5).withDimensionY(5).build();
		Robot robot = new RobotBuilder().withLocationX(2).withLocationY(2).withDirection(Direction.EAST).build();
		Assert.assertTrue(movementHelperImpl.ifValidMakeTheMove(table, robot));
		Assert.assertTrue(movementHelperImpl.ifValidMakeTheMove(table, robot));
		Assert.assertFalse(movementHelperImpl.ifValidMakeTheMove(table, robot));
	}
	
	@Test
	public void testIfValidMakeTheMoveWithStartingWestFace() {
		Table table = new TableBuilder().withDimensionX(5).withDimensionY(5).build();
		Robot robot = new RobotBuilder().withLocationX(2).withLocationY(2).withDirection(Direction.WEST).build();
		Assert.assertTrue(movementHelperImpl.ifValidMakeTheMove(table, robot));
		Assert.assertTrue(movementHelperImpl.ifValidMakeTheMove(table, robot));
		Assert.assertFalse(movementHelperImpl.ifValidMakeTheMove(table, robot));
	}

	@Test
	public void testTurnLeft() {
		Robot robot = new RobotBuilder().withLocationX(2).withLocationX(2).withDirection(Direction.NORTH).build();
		movementHelperImpl.turnLeft(robot);
		Assert.assertEquals(Direction.WEST, robot.getFacingDirection());
		movementHelperImpl.turnLeft(robot);
		Assert.assertEquals(Direction.SOUTH, robot.getFacingDirection());
		movementHelperImpl.turnLeft(robot);
		Assert.assertEquals(Direction.EAST, robot.getFacingDirection());
		movementHelperImpl.turnLeft(robot);
		Assert.assertEquals(Direction.NORTH, robot.getFacingDirection());
	}

	@Test
	public void testTurnRight() {
		Robot robot = new RobotBuilder().withLocationX(2).withLocationX(2).withDirection(Direction.NORTH).build();
		movementHelperImpl.turnRight(robot);
		Assert.assertEquals(Direction.EAST, robot.getFacingDirection());
		movementHelperImpl.turnRight(robot);
		Assert.assertEquals(Direction.SOUTH, robot.getFacingDirection());
		movementHelperImpl.turnRight(robot);
		Assert.assertEquals(Direction.WEST, robot.getFacingDirection());
		movementHelperImpl.turnRight(robot);
		Assert.assertEquals(Direction.NORTH, robot.getFacingDirection());
	}

}
