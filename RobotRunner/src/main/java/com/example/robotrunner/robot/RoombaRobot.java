package com.example.robotrunner.robot;

import java.util.List;

import com.example.robotrunner.command.Command;
import com.example.robotrunner.enums.Facing;
import com.example.robotrunner.exceptions.StopRobotException;
import com.example.robotrunner.robot.schema.Cleaned;
import com.example.robotrunner.robot.schema.Final;
import com.example.robotrunner.robot.schema.RoombaResponse;
import com.example.robotrunner.robot.schema.Start;
import com.example.robotrunner.robot.schema.Visited;
import com.example.robotrunner.strategy.BackOffStrategy;
import com.example.robotrunner.strategy.RoombaBackOffStrategy;
import com.example.robotrunner.util.CommandUtil;
import com.google.gson.Gson;

/**
 * Class for the Roomba Robot
 * 
 * @author efraintoribioreyes
 *
 */
public class RoombaRobot implements Robot {

	private List<List<String>> map;
	private Start start;
	private List<String> commands;
	private int battery;
	
	private transient RoombaResponse roombaResponse;
	private transient BackOffStrategy backOffStrategy;
	
	public String run() {
		initializeRoombaResponse();
		List<Command> wrappedCommands = CommandUtil.getWrappedCommands(commands, this);	
		
		try {
			for (Command command : wrappedCommands) {
				command.execute();
			}
			
			return getRoombaJsonResponse();
			
		} catch (StopRobotException e) {
			return getRoombaJsonResponse();
		}
	}
	
	public String getRoombaJsonResponse() {
		Gson gson = new Gson();
		return gson.toJson(roombaResponse);
	}
	
	/**
	 * Initialize the RoombaResponse with the input values
	 * Initially:
	 * 
	 * The start position of robot is added as a visited cell
	 * The start position of robot is set as the final position
	 * The initial battery level is set as the final battery unit
	 */
	public void initializeRoombaResponse() {
		roombaResponse = new RoombaResponse();
		
		Visited visitedCell = new Visited();
		visitedCell.setX(start.getX());
		visitedCell.setY(start.getY());
		
		roombaResponse.getVisited().add(visitedCell);
		
		Final finalPosition = new Final();
		finalPosition.setX(start.getX());
		finalPosition.setY(start.getY());
		finalPosition.setFacing(start.getFacing());
		
		roombaResponse.setFinalPosition(finalPosition);
		roombaResponse.setBattery(battery);
	}

	public void setMap(List<List<String>> map) {
		this.map = map;
	}

	public List<List<String>> getMap() {
		return this.map;
	}

	public void setStart(Start start) {
		this.start = start;
	}

	public Start getStart() {
		return this.start;
	}

	public void setCommands(List<String> commands) {
		this.commands = commands;
	}

	public List<String> getCommands() {
		return this.commands;
	}

	public void setBattery(int battery) {
		roombaResponse.setBattery(battery);
	}

	public int getBattery() {
		return roombaResponse.getBattery();
	}
	
	public RoombaResponse getRoombaResponse() {
		return roombaResponse;
	}

	public void setRoombaResponse(RoombaResponse roombaResponse) {
		this.roombaResponse = roombaResponse;
	}
	
	@Override
	public Facing getFacing() {
		Facing currentFacing = Facing.valueOf(roombaResponse.getFinalPosition().getFacing());
		return currentFacing;
	}

	@Override
	public void setFacing(Facing facing) {
		roombaResponse.getFinalPosition().setFacing(facing.name());
	}

	@Override
	public String toString() {
		return "Root [map=" + map + ", start=" + start + ", commands=" + commands + ", battery=" + battery + "]";
	}

	@Override
	public BackOffStrategy getBackOffStrategy() {
		/**
		 * Instance the back of strategy only the first time for
		 * conserve the status of the rules
		 */
		if (backOffStrategy == null) {
			backOffStrategy = new RoombaBackOffStrategy(this);
		}
		
		return backOffStrategy;
	}

	@Override
	public int getX() {
		return roombaResponse.getFinalPosition().getX();
	}

	@Override
	public int getY() {
		return roombaResponse.getFinalPosition().getY();
	}

	@Override
	public List<Visited> getVisitedCells() {
		return roombaResponse.getVisited();
	}

	@Override
	public List<Cleaned> getCleanedCells() {
		return roombaResponse.getCleaned();
	}

	@Override
	public Final getFinalPosition() {
		return roombaResponse.getFinalPosition();
	}
}
