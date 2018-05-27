package com.simulator.helper;

import com.simulator.model.Robot;
import com.simulator.model.Table;

public interface MovementHelper {
	public boolean ifValidMakeTheMove(Table table, Robot robot);
	public void turnLeft(Robot robot);
	public void turnRight(Robot robot);
}
