package com.example.robotrunner.robot;


import java.util.List;

import com.example.robotrunner.enums.Facing;
import com.example.robotrunner.robot.schema.Cleaned;
import com.example.robotrunner.robot.schema.Final;
import com.example.robotrunner.robot.schema.Visited;
import com.example.robotrunner.strategy.BackOffStrategy;

/**
 * 
 * @author efraintoribioreyes
 *
 */
public interface Robot {

	/**
	 * Execute a robot
	 * 
	 * @param json
	 * @return
	 */
	String run();
	
	/**
	 * Return the current battery level of a robot
	 * 
	 * @return
	 */
	int getBattery();
	
	/**
	 * Return the current X position of a robot
	 * 
	 * @return
	 */
	int getX();
	
	/**
	 * Return the map of a robot
	 * 
	 * @return
	 */
	List<List<String>> getMap();
	
	/**
	 * Return the current Y position of a robot
	 * 
	 * @return
	 */
	int getY();
	
	/**
	 * Set the specified unit of battery to the robot
	 * 
	 * @param unitBattery
	 */
	void setBattery(int unitBattery);
	
	/**
	 * Return the current {@link Facing} of the robot
	 * 
	 * @return
	 */
	Facing getFacing();
	
	/**
	 * Set the specified {@link Facing} to the robot
	 * 
	 * @param facing
	 */
	void setFacing(Facing facing);
	
	/**
	 * Return the current back of strategy of a robot
	 * 
	 * @return
	 */
	BackOffStrategy getBackOffStrategy();
	
	/**
	 * Return the cells visited by this robot
	 * 
	 * @return
	 */
	List<Visited> getVisitedCells();
	
	/**
	 * Return the cells cleaned by this robot
	 * 
	 * @return
	 */
	List<Cleaned> getCleanedCells();
	
	/**
	 * Return the current position of this robot
	 * 
	 * @return
	 */
	Final getFinalPosition();
}
