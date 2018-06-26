package com.example.robotrunner.command;

import com.example.robotrunner.constans.CommandConstants;
import com.example.robotrunner.robot.Robot;

/**
 * 
 * @author efraintoribioreyes
 *
 */
public class BackCommand extends ObstacleCommand {

	public BackCommand(Robot robot) {
		super(robot);
	}

	@Override
	int discountUnitBattery() {
		return 3;
	}
	
	@Override
	public String toString() {
		return CommandConstants.B;
	}
}
