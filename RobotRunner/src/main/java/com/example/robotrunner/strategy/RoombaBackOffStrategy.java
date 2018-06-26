package com.example.robotrunner.strategy;

import java.util.ArrayList;
import java.util.List;

import com.example.robotrunner.command.AdvanceCommand;
import com.example.robotrunner.command.BackCommand;
import com.example.robotrunner.command.Command;
import com.example.robotrunner.command.TurnLeftCommand;
import com.example.robotrunner.command.TurnRightCommand;
import com.example.robotrunner.exceptions.StopRobotException;
import com.example.robotrunner.robot.Robot;

/**
 * Strategy for command {@link AdvanceCommand} when it hits an obstacle
 * 
 * @author efraintoribioreyes
 *
 */
public class RoombaBackOffStrategy extends BackOffStrategy {
	
	public RoombaBackOffStrategy(Robot robot) {
		super(robot);
	}
	
	@Override
	public List<Command> findNextCommmands() throws StopRobotException {
		commandsFound = new ArrayList<Command>();
		currentRule++;
		
		switch (currentRule) {
		case 1:
			return firstRound();
		case 2:
			return secondRound();
		case 3:
			return thirdRound();
		case 4:
			return fourthRound();
		case 5:
			return fifthRound();
			default:
				throw new StopRobotException();
		}
	}
	
	public List<Command> firstRound() {
		commandsFound.add(new TurnRightCommand(robot));
		commandsFound.add(new AdvanceCommand(robot));
		
		return commandsFound;
	}
	
	public List<Command> secondRound() {
		commandsFound.add(new TurnLeftCommand(robot));
		commandsFound.add(new BackCommand(robot));
		commandsFound.add(new TurnRightCommand(robot));
		commandsFound.add(new AdvanceCommand(robot));
		
		return commandsFound;
	}
	
	public List<Command> thirdRound() {
		commandsFound.add(new TurnLeftCommand(robot));
		commandsFound.add(new TurnLeftCommand(robot));
		commandsFound.add(new AdvanceCommand(robot));
		
		return commandsFound;
	}
	
	public List<Command> fourthRound() {
		commandsFound.add(new TurnRightCommand(robot));
		commandsFound.add(new BackCommand(robot));
		commandsFound.add(new TurnRightCommand(robot));
		commandsFound.add(new AdvanceCommand(robot));
		
		return commandsFound;
	}
	
	public List<Command> fifthRound() {
		commandsFound.add(new TurnLeftCommand(robot));
		commandsFound.add(new TurnLeftCommand(robot));
		commandsFound.add(new AdvanceCommand(robot));
		
		return commandsFound;
	}

	@Override
	public void resetStrategy() {
		currentRule = 0;
	}
}
