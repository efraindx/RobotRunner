package com.example.robotrunner.command;

import com.example.robotrunner.exceptions.StopRobotException;
import com.example.robotrunner.robot.Robot;

/**
 * Implementing Command Design Pattern
 * Abstraction for all Commmands
 * 
 * Superclass for all commands that not change cell 
 * (change direction commands)
 * 
 * @author efraintoribioreyes
 *
 */
public abstract class Command {

	protected Robot robot;
	
	abstract int discountUnitBattery();
	
	protected Command(Robot robot) {
		this.robot = robot;
	}
	
	public void execute() throws StopRobotException {
		if (robot.getBattery() < discountUnitBattery()) {
			throw new StopRobotException();
		}
		
		discountBatteryToRobot();
	}
	
	/**
	 * Discount the command's unit of battery to the robot
	 */
	private void discountBatteryToRobot() {
		int currentRobotBattery = robot.getBattery();
		robot.setBattery( (currentRobotBattery - discountUnitBattery()) );
	}
}

