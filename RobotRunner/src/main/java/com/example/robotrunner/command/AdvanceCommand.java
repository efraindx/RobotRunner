package com.example.robotrunner.command;

import com.example.robotrunner.constans.CommandConstants;
import com.example.robotrunner.robot.Robot;

/**
 * 
 * @author efraintoribioreyes
 *
 */
public class AdvanceCommand extends ObstacleCommand {

	public AdvanceCommand(Robot robot) {
		super(robot);
	}

	@Override
	int discountUnitBattery() {
		return 2;
	}
	
	@Override
	public String toString() {
		return CommandConstants.A;
	}
}
