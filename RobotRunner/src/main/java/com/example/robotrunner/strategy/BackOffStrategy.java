package com.example.robotrunner.strategy;

import java.util.ArrayList;
import java.util.List;

import com.example.robotrunner.command.Command;
import com.example.robotrunner.exceptions.StopRobotException;
import com.example.robotrunner.robot.Robot;

/**
 * Implementing Strategy Design Pattern
 * 
 * Each strategy define its algorithm 
 * overriding these methods
 * 
 * @author efraintoribioreyes
 *
 */
public abstract class BackOffStrategy {

	protected Robot robot;
	protected List<Command> commandsFound;
	protected int currentRule;
	
	protected BackOffStrategy(Robot robot) {
		this.robot = robot;
		commandsFound = new ArrayList<Command>();
	}
	
	/**
	 * In this method each algorithm will determine which
	 * commands the robot is going to run 
	 * (commands that no hits an obstacle)
	 * 
	 * If the algorithm can not find commands
	 * (all commands hits an obstacle)
	 * Then the result will be null.
	 * 
	 * @return
	 * @throws StopRobotException 
	 */
	public abstract List<Command> findNextCommmands() throws StopRobotException;

	/**
	 * Method for reset strategy
	 */
	public abstract void resetStrategy();
}
