package com.simulator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.simulator.builder.RobotBuilder;
import com.simulator.exception.InvalidInputException;
import com.simulator.helper.MovementHelper;
import com.simulator.io.InstructionParser;
import com.simulator.model.Direction;
import com.simulator.model.Robot;
import com.simulator.model.Table;
import com.simulator.util.PrintUtility;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;

public class RobotSimulatorTest {
	
	@InjectMocks
	private RobotSimulator robotSimulator;
	
	@Mock
	private PrintUtility mockPrintUtility;
	
	@Mock
	private InstructionParser mockInstructionParser;
	
	@Mock
	private MovementHelper mockMovementHelper;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testParseAndExecuteInstruction() throws InvalidInputException, IOException {
		String filepath = "/file/path/testdata";
		Robot robot = new RobotBuilder().withLocationX(2).withLocationY(2).withDirection(Direction.NORTH).build();
		List<String> instructions = new ArrayList<String>() {{
			add("PLACE 0,0,NORTH");
			add("MOVE");
			add("REPORT");
			add("PLACE 0,0,NORTH");
			add("LEFT");
			add("REPORT");
			add("PLACE 1,2,EAST");
			add("MOVE");
			add("MOVE");
			add("LEFT");
			add("MOVE");
			add("REPORT");
		}};
		robotSimulator.setRobot(robot);
		
		when(mockInstructionParser.parseFile(filepath)).thenReturn(instructions);
		
		robotSimulator.parseAndExecuteInstruction(filepath);
		
		verify(mockInstructionParser).parseFile(filepath);
		verify(mockPrintUtility, times(12)).printInput(any(String.class));
		verify(mockPrintUtility, times(3)).printReport(robot);
		verify(mockMovementHelper, times(4)).ifValidMakeTheMove(any(Table.class), eq(robot));
		verify(mockMovementHelper, times(2)).turnLeft(robot);
	}
	
	@Test
	public void testParseAndExecuteInstructionEmptyInstructions() throws InvalidInputException, IOException {
		String filepath = "/file/path/testdata";
		Robot robot = new RobotBuilder().withLocationX(2).withLocationY(2).withDirection(Direction.NORTH).build();
		List<String> instructions = new ArrayList<>();
		robotSimulator.setRobot(robot);
		
		when(mockInstructionParser.parseFile(filepath)).thenReturn(instructions);
		
		robotSimulator.parseAndExecuteInstruction(filepath);
		
		verify(mockInstructionParser).parseFile(filepath);
	}
	
	@Test
	public void testParseAndExecuteInstructionNoPlaceInstructions() throws InvalidInputException, IOException {
		String filepath = "/file/path/testdata";
		Robot robot = new RobotBuilder().withLocationX(2).withLocationY(2).withDirection(Direction.NORTH).build();
		List<String> instructions = new ArrayList<String>() {{
			add("MOVE");
			add("REPORT");
			add("LEFT");
			add("REPORT");
			add("MOVE");
			add("MOVE");
			add("LEFT");
			add("MOVE");
			add("RIGHT");
			add("REPORT");
		}};
		robotSimulator.setRobot(robot);
		
		when(mockInstructionParser.parseFile(filepath)).thenReturn(instructions);
		
		robotSimulator.parseAndExecuteInstruction(filepath);
		
		verify(mockInstructionParser).parseFile(filepath);
	}
	
	@Test
	public void testParseAndExecuteInstructionWithParam() throws InvalidInputException, IOException {
		String filepath = "/file/path/testdata";
		Robot robot = new RobotBuilder().withLocationX(2).withLocationY(2).withDirection(Direction.NORTH).build();
		List<String> instructions = new ArrayList<String>() {{
			add("PLACE 0,0,NORTH");
			add("MOVE");
			add("REPORT");
			add("PLACE 0,0,NORTH");
			add("LEFT");
			add("REPORT");
			add("PLACE 1,2,EAST");
			add("MOVE");
			add("MOVE");
			add("LEFT");
			add("MOVE");
			add("MOVE");
			add("RIGHT");
			add("REPORT");
		}};
		robotSimulator.setRobot(robot);
		
		when(mockInstructionParser.parseFile(filepath)).thenReturn(instructions);
		
		robotSimulator.parseAndExecuteInstruction(filepath, 6, 7);
		
		verify(mockInstructionParser).parseFile(filepath);
		verify(mockPrintUtility, times(14)).printInput(any(String.class));
		verify(mockPrintUtility, times(3)).printReport(robot);
		verify(mockMovementHelper, times(5)).ifValidMakeTheMove(any(Table.class), eq(robot));
		verify(mockMovementHelper, times(2)).turnLeft(robot);
	}
	
	@Test
	public void testParseAndExecuteInstructionWithInvalidInputException() throws IOException, InvalidInputException {
		String filepath = "/file/path/testdata";
		Robot robot = new RobotBuilder().withLocationX(2).withLocationY(2).withDirection(Direction.NORTH).build();
		List<String> instructions = new ArrayList<String>() {{
			add("PLACE 0,0");
			add("MOVE");
			add("REPORT");
			add("PLACE 0,0,NORTH");
			add("LEFT");
			add("REPORT");
			add("PLACE 1,2,EAST");
			add("MOVE");
			add("MOVE");
			add("LEFT");
			add("MOVE");
			add("REPORT");
		}};
		robotSimulator.setRobot(robot);
		
		when(mockInstructionParser.parseFile(filepath)).thenReturn(instructions);
		
		exception.expect(InvalidInputException.class);
		exception.expectMessage("Invalid number of params in PLACE command");
		robotSimulator.parseAndExecuteInstruction(filepath);
		
		verify(mockInstructionParser).parseFile(filepath);
		
	}

}
