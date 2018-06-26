package com.example.robotrunner.command;

import com.example.robotrunner.constans.CommandConstants;
import com.example.robotrunner.enums.Facing;
import com.example.robotrunner.exceptions.StopRobotException;
import com.example.robotrunner.robot.Robot;

public class TurnRightCommand extends Command {

	public TurnRightCommand(Robot robot) {
		super(robot);
	}
	
	@Override
	public void execute() throws StopRobotException {
		super.execute();
		
		/**
		 * Turn the current facing 90 degrees to right
		 */
		Facing currentFacing = robot.getFacing();
		Facing newFacing = currentFacing.next();
		robot.setFacing(newFacing);
	}

	@Override
	int discountUnitBattery() {
		return 1;
	}
	
	@Override
	public String toString() {
		return CommandConstants.TR;
	}
}
