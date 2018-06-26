package com.example.robotrunner.command;

import com.example.robotrunner.constans.CommandConstants;
import com.example.robotrunner.exceptions.StopRobotException;
import com.example.robotrunner.robot.Robot;
import com.example.robotrunner.robot.schema.Cleaned;

/**
 * 
 * @author efraintoribioreyes
 *
 */
public class CleanCommand extends Command {

	public CleanCommand(Robot robot) {
		super(robot);
	}
	
	@Override
	public void execute() throws StopRobotException {
		super.execute();		
		
		/**
		 * Add current position of robot as a cleaned cell
		 * (if this is not an already cleaned cell)
		 */
		Cleaned cleanedPosition = new Cleaned();
		cleanedPosition.setX(robot.getFinalPosition().getX());
		cleanedPosition.setY(robot.getFinalPosition().getY());
		
		if (!robot.getCleanedCells().contains(cleanedPosition)) {
			robot.getCleanedCells().add(cleanedPosition);
		}
	}

	@Override
	int discountUnitBattery() {
		return 5;
	}
	
	@Override
	public String toString() {
		return CommandConstants.C;
	}
}
