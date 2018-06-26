package com.example.robotrunner.util;

import java.util.ArrayList;
import java.util.List;

import com.example.robotrunner.command.AdvanceCommand;
import com.example.robotrunner.command.BackCommand;
import com.example.robotrunner.command.CleanCommand;
import com.example.robotrunner.command.Command;
import com.example.robotrunner.command.TurnLeftCommand;
import com.example.robotrunner.command.TurnRightCommand;
import com.example.robotrunner.constans.CommandConstants;
import com.example.robotrunner.robot.Robot;

/**
 * Util class for Command tasks
 * 
 * @author efraintoribioreyes
 *
 */
public class CommandUtil {

	/**
	 * Return the list of string commands 
	 * wrapped to Commands objects
	 * 
	 * @param commands
	 * @param robot
	 * @return
	 */
	public static List<Command> getWrappedCommands(List<String> commands, Robot robot) {
		List<Command> result = new ArrayList<Command>();
		
		for (String command : commands) {
			result.add(getWrappedCommand(command, robot));
		}
		
		return result;
	}
	
	private static Command getWrappedCommand(String command, Robot robot) {
		switch(command) {
		case CommandConstants.TL:
			return new TurnLeftCommand(robot);
		case CommandConstants.TR:
			return new TurnRightCommand(robot);
		case CommandConstants.A:
			return new AdvanceCommand(robot);
		case CommandConstants.B:
			return new BackCommand(robot);
		case CommandConstants.C:
			return new CleanCommand(robot);
		default:
			throw new IllegalArgumentException("The command specified is invalid");
		} 
	}
}
