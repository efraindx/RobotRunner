package com.example.robotrunner.command;

import java.util.List;

import com.example.robotrunner.constans.CommandConstants;
import com.example.robotrunner.constans.MapValuesConstants;
import com.example.robotrunner.exceptions.StopRobotException;
import com.example.robotrunner.robot.Robot;
import com.example.robotrunner.robot.schema.Final;
import com.example.robotrunner.robot.schema.Visited;
import com.example.robotrunner.strategy.BackOffStrategy;

/**
 * Superclass for all commands that change cell
 * (change a robot of a cell)
 * 
 * @author efraintoribioreyes
 *
 */
public abstract class ObstacleCommand extends Command {

	private Visited newCellToVisit;
	
	protected ObstacleCommand(Robot robot) {
		super(robot);
	}

	@Override
	public void execute() throws StopRobotException {
		super.execute();
		
		if (commandHitsObstacle()) {
			System.out.println("Iniciando strategy");
			
			BackOffStrategy commandStrategy = robot.getBackOffStrategy();
			
			List<Command> foundCommands = commandStrategy.findNextCommmands();
			System.out.println("Lista comandos retornados:" + foundCommands);
			
			for (Command command : foundCommands) {
				command.execute();
			}
			
			commandStrategy.resetStrategy();
			System.out.println("Reiniciando strategy..");
		} else {
			
			/**
			 * Add the generated command to visited cells
			 * (if this is not an already visited cell)
			 * 
	 		 * Set the generated command as final position
			 * 
			 */
			if (!robot.getVisitedCells().contains(newCellToVisit)) {
				robot.getVisitedCells().add(newCellToVisit);
			}
			
			Final finalPosition = robot.getFinalPosition();
			finalPosition.setX(newCellToVisit.getX());
			finalPosition.setY(newCellToVisit.getY());
		}
	}
	
	/**
	 * Validates if the command is going to hit an obstacle
	 * 
	 * @param command
	 * @return true if the command is going to hit an obstacle, 
	 * 		   false if the command is not going to hit an obstacle
	 */
	private boolean commandHitsObstacle() {
		if (this instanceof AdvanceCommand) {
			return (advanceOutsideMap() || advanceWallOrColumn() );
		} else if (this instanceof BackCommand) {
			return (backOutsideMap() || backWallOrColumn());
		}
		//here we can add more obstacle commands
		
		throw new IllegalArgumentException("Current Obstacle command is not supported");
	}
	
	private boolean advanceOutsideMap() {
		switch (robot.getFacing()) {
		case N:
			return ((robot.getY() - 1) == -1);
		case E:
			int sizeX = robot.getMap().get(robot.getY()).size();
			return ((robot.getX() + 1) == sizeX);
		case S:
			int sizeY = robot.getMap().size();
			return ((robot.getY() + 1) == sizeY);
		case W:
			return ((robot.getX() - 1) == -1);
			default:
				throw new IllegalArgumentException("The current facing of robot is not allowed");
		}
	}
	
	private boolean advanceWallOrColumn() {
		newCellToVisit = new Visited();
		
		switch (robot.getFacing()) {
		case N:
			newCellToVisit.setX(robot.getX());
			newCellToVisit.setY(robot.getY() - 1);
			
			return valueIsWallOrColumn( robot.getMap().get(robot.getY() - 1).get(robot.getX()) );
		case E:
			newCellToVisit.setX(robot.getX() + 1);
			newCellToVisit.setY(robot.getY());
			
			return valueIsWallOrColumn( robot.getMap().get(robot.getY()).get(robot.getX() + 1) );
		case S:
			newCellToVisit.setX(robot.getX());
			newCellToVisit.setY(robot.getY() + 1);
			
			return valueIsWallOrColumn( robot.getMap().get(robot.getY() + 1).get(robot.getX()) );
		case W:
			newCellToVisit.setX(robot.getX() - 1);
			newCellToVisit.setY(robot.getY());
			
			return valueIsWallOrColumn( robot.getMap().get(robot.getY()).get(robot.getX() - 1) );
			default:
				throw new IllegalArgumentException("The current facing of robot is not allowed");
		}
	}
	
	private boolean valueIsWallOrColumn(String value) {
		return (value.equals(MapValuesConstants.NULL) || 
				value.equals(CommandConstants.C));
	}
	
	private boolean backOutsideMap() {
		switch (robot.getFacing()) {
		case N:
			int sizeY = robot.getMap().size();
			return ((robot.getY() + 1) == sizeY);
		case E:
			return ((robot.getX() - 1) == -1);
		case S:
			return ((robot.getY() - 1) == -1);
		case W:
			int sizeX = robot.getMap().get(robot.getY()).size();
			return ((robot.getX() + 1) == sizeX);
			default:
				throw new IllegalArgumentException("The current facing of robot is not allowed");
		}
	}
	
	private boolean backWallOrColumn() {
		newCellToVisit = new Visited();
		
		switch (robot.getFacing()) {
		case N:
			newCellToVisit.setX(robot.getX());
			newCellToVisit.setY(robot.getY() + 1);
			
			return valueIsWallOrColumn( robot.getMap().get(robot.getY() + 1).get(robot.getX()) );
		case E:
			newCellToVisit.setX(robot.getX() - 1);
			newCellToVisit.setY(robot.getY());
			
			return valueIsWallOrColumn( robot.getMap().get(robot.getY()).get(robot.getX() - 1) );
		case S:
			newCellToVisit.setX(robot.getX());
			newCellToVisit.setY(robot.getY() - 1);
			
			return valueIsWallOrColumn( robot.getMap().get(robot.getY() - 1).get(robot.getX()) );
		case W:
			newCellToVisit.setX(robot.getX() + 1);
			newCellToVisit.setY(robot.getY());
			
			return valueIsWallOrColumn( robot.getMap().get(robot.getY()).get(robot.getX() + 1) );
			default:
				throw new IllegalArgumentException("The current facing of robot is not allowed");
		}
	}
}
