package com.simulator;

import static com.simulator.util.Constants.INSTRUCTION_SPLIT_PATTERN;
import static com.simulator.util.Constants.INVALID_PLACE_PARAM_COUNT;
import static com.simulator.util.Constants.NO_INSTRUCTION_FOUND;
import static com.simulator.util.Constants.*;

import java.io.IOException;
import java.util.List;

import com.simulator.exception.InvalidInputException;
import com.simulator.helper.MovementHelper;
import com.simulator.io.InstructionParser;
import com.simulator.model.Action;
import com.simulator.model.Direction;
import com.simulator.model.Location;
import com.simulator.model.Robot;
import com.simulator.model.Table;
import com.simulator.util.PrintUtility;

public class RobotSimulator {
	
	private InstructionParser instructionParser;
	private MovementHelper movementHelper;
	private Table table;
	private Robot robot;
	private PrintUtility printUtility;
	
	public void setTable(Table table) {
		this.table = table;
	}
	
	public void setRobot(Robot robot) {
		this.robot = robot;
	}
	
	public void setPrintUtility(PrintUtility printUtility) {
		this.printUtility = printUtility;
	}
	
	public void setInstructionParser(InstructionParser instructionParser) {
		this.instructionParser = instructionParser;
	}
	
	public void setMovementHelper(MovementHelper movementHelper) {
		this.movementHelper = movementHelper;
	}
	
	public void parseAndExecuteInstruction(String filepath) throws InvalidInputException, IOException {
		table = new Table();
		parseAndRun(filepath);
	}

	private void parseAndRun(String filepath) throws IOException, InvalidInputException {
		List<String> instructions = instructionParser.parseFile(filepath);
		if(instructions.isEmpty()) {
			System.out.println(NO_INSTRUCTION_FOUND);
			return;
		}			
		run(instructions);
	}
	
	public void parseAndExecuteInstruction(String filepath, long tableDimX, long tableDimY) throws IOException, InvalidInputException {
		table = new Table(tableDimX, tableDimY);
		parseAndRun(filepath);
	}
	
	private void run(List<String> instructions) throws InvalidInputException {		
		for(String instruction : instructions) {
			String[] tokens = instruction.split(INSTRUCTION_SPLIT_PATTERN);
			
			switch(Action.valueOf(tokens[0])) {
				case PLACE:
					printUtility.printInput(instruction);
					String[] params = tokens[1].split(PARAM_SPLIT_PATTERN);
					if(params.length != PLACE_PARAM_COUNT) {
						throw new InvalidInputException(INVALID_PLACE_PARAM_COUNT);
					}
					robot.setPlaced(true);
					Location location = getLocation(params[0], params[1]);
					robot.setLocation(location);
					robot.setFacingDirection(Direction.valueOf(params[2]));
					break;
				case LEFT:
					if(!robot.isPlaced())
						break;
					movementHelper.turnLeft(robot);
					printUtility.printInput(instruction);
					break;
				case RIGHT:
					if(!robot.isPlaced())
						break;
					movementHelper.turnRight(robot);
					printUtility.printInput(instruction);
					break;
				case MOVE:
					if(!robot.isPlaced())
						break;
					movementHelper.ifValidMakeTheMove(table, robot);
					printUtility.printInput(instruction);
					break;
				case REPORT:	
					if(!robot.isPlaced())
						break;
					printUtility.printInput(instruction);
					printUtility.printReport(robot);
					break;
			}
		}
	}
	
	private Location getLocation(String x, String y) {
		Location location = new Location();
		location.setX(Long.parseLong(x));
		location.setY(Long.parseLong(y));
		return location;
	}
	
}